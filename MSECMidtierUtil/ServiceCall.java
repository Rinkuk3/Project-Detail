package com.td.mbna.msec.midtier.util;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.Callable;

/**
 * http://tutorials.jenkov.com/java-util-concurrent/executorservice.html
 * https://www.baeldung.com/java-executor-service-tutorial
 * https://www.ibm.com/docs/en/was/9.0.5?topic=mc-examples-migrate-ee-concurrency-from-asynchronous-beans-commonj
 * @author HANHAR4
 *
 * @param <Response>
 */
public abstract class ServiceCall<Response> implements Callable {

	
		public abstract Response invoke() throws Exception;

		private String responseClassName;
		private Response response;
		private Exception exception;
		private String id;
		
		private  MbnaLogger logger = new MbnaLogger(ServiceCall.class);

		public ServiceCall() {
			responseClassName = getGenericParameterClassName();
		}

		void setId(String id) {
			this.id = id;
		}

		String getId() {
			return id;
		}

		public Response getResponse() {
			return response;
		}

		public Exception getException() {
			return exception;
		}

		public void release() {
			// nothing to do
		}

		public boolean isDaemon() {
			return false;
		}

		public Response call() {
			WebServiceInfoCallTracker.clear(); // clear thread's left-over soap fault response, if any
			try {
				logger.debug("Before invoke: " + toString());
				response = invoke();
				logger.debug("After invoke: " + toString());
			} catch (Exception e) {
				logger.error("run", "run failed", e);
				String errInfo = WebServiceInfoCallTracker.getErrorInfo();
				if (errInfo != null) {
					if (WebServiceInfoCallTracker.getSoapFaultEncountered()) {
						exception = new SoapFaultTriggeredException(e, errInfo);
					} else {
						exception = new WebServiceErrorInfoEnvelopeException(e, errInfo);
					}
				} else {
					exception = e;
				}
			} finally {
				WebServiceInfoCallTracker.clear();
				return response;
			}
		}

		/**
		 * Returns the generic type parameter of this ServiceCall object.
		 * For example, for call created with:
		 * caller = new ParallelServiceCaller<p.ClassA>()
		 * Or, for a caller created with:
		 * caller = new ParallelServicalCall<java.util.List<p.ClassB>>()
		 * This function will return the string "java.util.List<p.ClassB>"
		 *
		 * @return A string that uniquely identifies this class
		 */
		private String getGenericParameterClassName() {
			String rc;
			Object rootType = getClass().getGenericSuperclass();
			Class<?> rootClass;
			Object paramType = ((ParameterizedType) rootType).getActualTypeArguments()[0];
			if (paramType instanceof Class<?>) {
				rootClass = (Class<?>) paramType;
				rc = getClassName(rootClass);
			} else {
				// assume the generic parameter is a List<?>
				rc = paramType.toString();
			}
			return rc;
		}

		public String toString() {
			StringBuilder rc = new StringBuilder(genResponseKey(id, responseClassName));
			if (response != null) {
				rc.append("+R");
			}
			else if (exception != null) {
				rc.append("+E");
			}
			return rc.toString();
		}

		public String getResponseClassName() {
			return responseClassName;
		}
		
		private static String getClassName(Class<?> c) {
			String rc;
			rc = c.getCanonicalName();
			if (rc == null) {
				rc = c.getName();
			}
			return rc;
		}
		


		private static String genResponseKey(String id, String responseClassName) {
			StringBuilder rc = new StringBuilder();
			rc.append(id).append("-").append(responseClassName);
			return rc.toString();
		}
		
	}