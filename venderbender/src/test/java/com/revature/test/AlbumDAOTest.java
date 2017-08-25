package com.revature.test;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AlbumDAOTest {
	private static ApplicationContext context;
	@BeforeClass
	public static void setup(){
		context = new ClassPathXmlApplicationContext("bender.xml");
	}

}
