package com.td.mbna.msec.midtier.util.perf;

import com.td.mbna.msec.midtier.types.common.ValidationException;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static org.springframework.util.StringUtils.hasText;

@Aspect
@Component
public class ProfileAspect {
	
	private static final MbnaLogger LOGGER = new MbnaLogger(ProfileAspect.class);

	@Around("execution(* com.td.mbna..*(..)) && @annotation(profileLog)")
	public Object logAround(ProceedingJoinPoint joinPoint, ProfileLog profileLog) throws Throwable {
		String methodName = hasText(profileLog.methodName()) ? profileLog.methodName() : joinPoint.getSignature().toLongString();
		LOGGER.enterMethod(methodName);
		long startTime = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			LOGGER.leaveMethod(methodName, startTime, MbnaLogger.SUCCESS);
			return result;
		} catch (Throwable t) {
			if (t instanceof ValidationException) { // no need to log stack trace for ValidationExceptoin
				ValidationException ve = (ValidationException)t;
				LOGGER.error(methodName, ve.getFieldError().toString());
			} else {
				LOGGER.error(methodName, t.getLocalizedMessage(), t);
			}
			LOGGER.leaveMethod(methodName, startTime, MbnaLogger.FAILED);
			throw t;
		}
	}

}
