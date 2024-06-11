package com.qa.TestNG;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Class4th {

	@BeforeClass(enabled=false)
	public void beforeClass() {
		System.out.println("I am Before Class Annotation");
	}

	@Test(timeOut=4000)

	public void firstMethod() {
		System.out.println("This is TetNG First class");
	
	}

	@Test(dependsOnMethods={"firstMethod"})
	public void secondMethod() {
		System.out.println("This is TestNG second class");
		//can be use while running Listeners testng.xml
		Assert.assertTrue(false);
	}

}
