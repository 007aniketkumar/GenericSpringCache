/**
 * 
 */
package com.ani.core;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ani.data.Books;

/**
 * @author aniket
 *
 *
 * This class will invoke the factory and store the data as and when required on the appropriate cache.
 */
public class CoreDriverClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("application.xml");
		Books bookInstance = (Books) appContext.getBean("books");
		System.out.println(bookInstance.getAuthor());
		//load the application context file.
		
		
	}

}
