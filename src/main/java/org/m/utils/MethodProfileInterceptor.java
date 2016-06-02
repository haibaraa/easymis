package org.m.utils;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.ClassUtils;

public class MethodProfileInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation arg0) throws Throwable {
		if (TimeProfiler.isProfileEnable()) {
			return invokeWithProfile(arg0);
		} else {
			return arg0.proceed();
		}
	}

	private Object invokeWithProfile(MethodInvocation invocation) throws Throwable {
		Method method = invocation.getMethod();
		Class clazz = method.getDeclaringClass();
		String className = ClassUtils.getShortName(clazz);
		TimeProfiler.beginTask(new StringBuilder(className).append(':').append(method.getName()).toString());
		Object result;
		try {
			result = invocation.proceed();
		} finally {
			TimeProfiler.endTask();
		}
		return result;
	}
}
