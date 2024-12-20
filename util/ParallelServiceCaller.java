package com.td.mbna.msec.midtier.util;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


/**
 * This class allows parallel calls to be made to TD. This increases performance.
 * ToDo: Externalize Thread Pool Size settings.
 */
public class ParallelServiceCaller {
	public static int MAX_POOL_SIZE = 64;
	private static final MbnaLogger logger = new MbnaLogger(ParallelServiceCaller.class);

	private final static ThreadPoolTaskExecutor executor;

	static {
		ThreadPoolTaskExecutor tempExecutor = null;

//		if (!ConfigUtil.isTest()) { // skip initialization under unit test flow.
		// The default configuration is a core pool size of 1, with unlimited max pool size and unlimited queue capacity.
		try {
			tempExecutor = new ThreadPoolTaskExecutor();
			tempExecutor.setCorePoolSize(8);
			tempExecutor.setMaxPoolSize(MAX_POOL_SIZE);
//			tempExecutor.setQueueCapacity(8);
			tempExecutor.initialize();
		} catch (Exception e) {
			logger.error("static init", "Failed to look up parallelServiceCaller work manager", e);
		}
//		}
		executor = tempExecutor;
	}

	private boolean async = true;            // if set to false, service calls will be made synchronously at point of submission.
	// This mode can be used for debugging, or used when it's known that
	// there is no need for asynchronous processing (e.g. we are doing one call
	// per account, but if we know there's only one account, then there's no point to spawn
	// the call and hold up an extra thread).

	private static boolean globalAsync = true;        // same as async above but globally applied
	// !! This should be used only for testing and debugging
	// !! Must be set to true in production

	private int numCalls = 0; // number of calls that are added to this caller

	private final List<CompletableFuture<?>> futureList = new ArrayList<>();

	private final Map<String, Object> responseMap = new HashMap<>();

	private final List<ServiceCall<?>> pendingCallList = new ArrayList<>();

	public static String executorIdentity()
	{
		executor.getActiveCount();
		return executor.toString();
	}

	public static int activeThreads()
	{
		return executor.getActiveCount();
	}

	/**
	 * scheduleCall may be called by multiple threads simultaneously if it is used inside a scheduled
	 * service call's invoke function (e.g. in GetCustomerDetailsForAccountsOperationRealImpl),
	 * so need to be thread safe
	 *
	 */
	public void scheduleCall(String id, ServiceCall<?> serviceCall) throws Exception {
		serviceCall.setId(id);
		String responseKey = genResponseKey(serviceCall);

		if (globalAsync && async) {
			if (executor == null) {
				throw new Exception("The parallelServiceCaller ThreadPoolTaskExecutor is not available");
			}

            CompletableFuture<?> future = CompletableFuture.supplyAsync(() -> {
                try {
                    serviceCall.call();
                    Object response = serviceCall.getResponse();
                    processSucceededCall(response, responseKey);
                    System.out.println("Thread " + Thread.currentThread().getId() + "about to Complete.!!!");
                } catch (Exception e) {
                    processFailedCall(e);
                }
                return null;
            }, executor);

			synchronized (this) { // needed to make method thread safe
				pendingCallList.add(serviceCall);
				numCalls++;
				futureList.add(future);
			}
		} else {
			try {
				synchronized (this) {
					numCalls++;
					serviceCall.call();
					processFinishedCall(serviceCall);
				}
			} catch (Exception e) {
				logger.error("scheduleCall", id + " failed", e);
				throw ExceptionUtil.genRuntimeException(e);
			}
		}
	}

	public void sync() throws Exception {
		if (pendingCallList.size() == 0) {
			return;
		}
        logger.debug("Waiting for, " + pendingCallList.size() + " call(s) to finish: " + pendingCallList);

        int numberOfCalls = futureList.size();

        logger.info("Before: ", numberOfResponses() + " " + numberOfCalls + " " + activeThreads());

        CompletableFuture<Void> completableFutures = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        completableFutures.join(); //blocks the current thread that until all the futures in futureList are completed

        logger.info("After: ", numberOfResponses() + " " + numberOfCalls + " " + activeThreads());
	}

		// future.get() waits until the future completes.
		// Original CommonJ code waits for WorkManager.INDEFINITE. No change to this logic.
		// Do not need the returned object from get() because the Callback provided to the ListenableFuture has processed the result.
//		for(int i = 0; i < numberOfCalls; i++) {
//			System.out.println(futureList.get(i).get());
//			System.out.println("Thread " + Thread.currentThread().getId() + " calling future.get()");
//			futureList.get(i).get();
//			if(futureList.get(i).get() == null) {
//				System.out.println("Thread " + Thread.currentThread().getId() + " get() null.");
//			}
//		}

	//synchronized(this) {if(numberOfResponses() < numberOfCalls) wait(100);} 		 // wait only once and briefly

//		System.out.println("Thread " + Thread.currentThread().getId() + " calling parallelStream.");
//		long t1 = System.currentTimeMillis();
/*
		List<ListenableFuture> listAfterRun = futureList.stream().map(future -> {
			try {
//				System.out.println("Thread " + Thread.currentThread().getId() + " calling future.get().");
//				long tt1 = System.currentTimeMillis();
				future.get();
//				long tt2 = System.currentTimeMillis();
//				System.out.println("Thread " + Thread.currentThread().getId() + " called  future.get(). Time Span: " + (tt2 - tt1));
			} catch (Exception e) { // Possible: CancellationException, ExecutionException, InterruptedException, TimeoutException
				// Do not stop MSEC server.
				logger.debug("Exception: " + e.getClass().getName() + ". Message: " + e.getMessage());
			}
			return future;
		}).collect(Collectors.toList());
		int numberOfCompletedCalls = listAfterRun.size();
*/
//		System.out.println("listAfterRun size: " + numberOfCompletedCalls);
//		long t2 = System.currentTimeMillis();
//		System.out.println("Thread " + Thread.currentThread().getId() + " called parallelStream. Time Span: " + (t2 - t1));

		// Treat Exception as Done. Error and Exception are handled in the callback provided to the ListenableFuture.
		// The callbacks also counts the remaining executions.
//		logger.debug("All executions completed. Total: " + numberOfCompletedCalls);


	private void processFinishedCall(ServiceCall<?> finishedCall) {
		logger.debug("Finished call: " + finishedCall);
		Exception serviceException = finishedCall.getException();
		if (serviceException != null) {
			processFailedCall(serviceException);
		} else {
			Object callResponse = finishedCall.getResponse();
			String responseKey = genResponseKey(finishedCall);
			processSucceededCall(callResponse, responseKey);
		}
	}

	private synchronized int numberOfResponses() {
		return responseMap.size();
	}

	private void processSucceededCall(Object callResponse, String responseKey) {
//		System.out.println("Thread " + Thread.currentThread().getId() + " add callResponse to responseMap.");
		if (callResponse != null) {
			synchronized (this) {
				responseMap.put(responseKey, callResponse);
				notify();
			}
		}
		else {
			System.out.println("callResponse is null: " + responseKey);
		}
	}

	private void processFailedCall(Throwable t) {
		logger.debug("Failed Execution: " + t);
	}

	private static String genResponseKey(String id, Class<?> responseClass) {
		String className = getClassName(responseClass);
		return genResponseKey(id, className);
	}

	private static String genResponseKey(ServiceCall<?> serviceCall) {
		return genResponseKey(serviceCall.getId(), serviceCall.getResponseClassName());
	}

	private static String genResponseKey(String id, String responseClassName) {
		return id + "-" + responseClassName;
	}

	public int size() {
		return numCalls;
	}

	@SuppressWarnings("unchecked")
	public <Response> Response getResponse(String id, Class<Response> responseClass) {
		String responseKey = genResponseKey(id, responseClass);
		return (Response) responseMap.get(responseKey);
	}

	@SuppressWarnings("unchecked")
	public <Response> Response getResponse(String id, String responseClassName) {
		String responseKey = genResponseKey(id, responseClassName);
		return (Response) responseMap.get(responseKey);
	}

	private static String getClassName(Class<?> c) {
		String rc;
		rc = c.getCanonicalName();
		if (rc == null) {
			rc = c.getName();
		}
		return rc;
	}

	public boolean isAsync() {
		return async;
	}

	public void useAsynchrousCall() {
		this.async = true;
	}

	public void useSynchrousCall() {
		this.async = false;
	}

	public static boolean isGloablAsync() {
		return globalAsync;
	}

	public static void useGlobalAsynchrousCall() {
		globalAsync = true;
	}

	public static void useGlobalSynchrousCall() {
		globalAsync = false;
	}
}