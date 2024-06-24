package com.qa.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Class1st {
	@BeforeClass
	public void beforeClass() {
		System.out.println("I am Before Class Annotation");
	}

	@Test

	public void firstMethod() {
		System.out.println("This is TetNG First class");
	}

	@Test
	public void secondMethod() {
		System.out.println("This is TestNG second class");
	}

//Coverage within the Test Folder in testng.xml
	@AfterTest
	public void afterTest() {
		System.out.println("I am After test Annotation.");
	}
}
