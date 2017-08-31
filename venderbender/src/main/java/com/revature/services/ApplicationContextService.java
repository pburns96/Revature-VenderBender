package com.revature.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextService {

	private static ApplicationContext context;
	
	
	
	public static ApplicationContext getContext(){
		if(context != null)
			return context;
		else{
			context =  new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/bender.xml"); 
			return context;
		}
	}
}
