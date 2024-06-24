package com.qa.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Class2nd {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am Before Method Annotation");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("I am After Method Annotation");
	}

	@Test
	public void carLoanWebPage() {
		System.out.println("This is Web Login for Car Loan");
	}

	@Test(groups="Sanity")
	public void carLoanAPIPage() {
		System.out.println("This is API Login for Car Loan");
	}

	@Test(groups="Sanity")

	public void carLoanMobilePage() {
		System.out.println("This is Mobile Login for Car Loan");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am After Class Annotation");
	}
}
