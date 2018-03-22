package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfiguration {
	//test whether the user instance is created or not
	public static void main(String[] args) {
		//bcs we used annotations above the domain classws
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		//will scan the pkg and check whether any classes are tere inside this pkg with annotation
		context.scan("com.niit");
		
		//will clear the context and create new instances of the classes which are thier in com.niit pkg with annotations
		context.refresh();
		
		
		//try to get instance of user class
		//it will ret the instance if avail
		//else it will throgh error
		context.getBean("user");
		System.out.println("sucessfully created instance ");
		
	}

}
