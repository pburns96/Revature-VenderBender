package com.revature.services;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Aspect
public class SecurityService {

	@Autowired 
	private AuthenticationService authenticationService;
	
	private static final Logger log = Logger.getLogger(SecurityService.class);
	
	@SuppressWarnings("rawtypes")
	@Before(value="execution(* *(..))")
	public ResponseEntity securityValidation(ProceedingJoinPoint joinpoint) throws Throwable{
		log.info("Security Check: " + joinpoint.getTarget());
		if(authenticationService.isLoggedIn())
			return (ResponseEntity) joinpoint.proceed();
		else
			return new ResponseEntity(HttpStatus.FORBIDDEN);
	}
}
