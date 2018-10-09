package com.ityongman.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.log4j.Log4j2;

//@Component
@Aspect
@Log4j2
public class WebLogAspect {
	
	@Pointcut("execution(public * com.ityongman.controller..*.*(..))")
	public void webLog() {
		
	}
	@Before("webLog()")
	public void doBefore(JoinPoint joinpoint) {
		ServletRequestAttributes attiAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest req = attiAttributes.getRequest() ;
		
		log.info("URL : " + req.getRequestURL().toString());
		log.info("HTTP_METHOND :" + req.getMethod());
		log.info("IP : " + req.getRemoteAddr());
		log.info("CLASS_METHOD : " + joinpoint.getSignature().getDeclaringType() + " , " + joinpoint.getSignature().getName());
		log.info("ARGS : " + Arrays.toString(joinpoint.getArgs()));
	}
	
	@AfterReturning(pointcut="webLog()", returning="ret")
	public void doAfterRetuing(Object ret) {
		//处理完请求, 返回结果
		log.info("Response : " + ret);
	}
}
