/**
 * 
 */
package com.ani.core;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ani.data.Books;
import com.ani.util.SpringExpression;

/**
 * @author aniket
 *
 *
 * This class will invoke the factory and store the data as and when required on the appropriate cache.
 */
public class CoreDriverClass {

	@Autowired
	static SpringExpression exp;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("application.xml");
		Books bookInstance = (Books) appContext.getBean("books");
		System.out.println(bookInstance.getAuthor());
		exp.expressionEvaluator();
		//load the application context file.
		
		
	}

}
