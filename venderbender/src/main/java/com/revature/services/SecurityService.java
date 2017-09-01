package com.revature.services;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityService {

	@Autowired 
	private AuthenticationService authenticationService;
	
	private static final Logger log = Logger.getLogger(SecurityService.class);
	
	@SuppressWarnings("rawtypes")
	@Around(value="execution(* com.revature.controllers.ManagerController.*(..)) || execution(* com.revature.controllers.OrderController.*(..))")
	public Object securityValidation(ProceedingJoinPoint joinpoint) throws Throwable{
		log.info("Security Check: " + joinpoint.getTarget());
		if(authenticationService.isLoggedIn())
			return (ResponseEntity) joinpoint.proceed();
		else
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		//return joinpoint.proceed();
	}
	
	public void setAuthenticationService(AuthenticationService authenticationService){
		this.authenticationService = authenticationService;
	}
}
