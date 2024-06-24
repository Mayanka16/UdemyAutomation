package com.qa.TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class3rd {

	@Test(groups="Sanity")
	public void homeLoanWebPage() {
		System.out.println("This is Web Login for Home Loan");
	}

	@Test
	public void homeLoanAPIPage() {
		System.out.println("This is API Login for Home Loan");
	}

	@Test

	public void homeLoanMobilePage() {
		System.out.println("This is Mobile Login for Home Loan");
	}

	@Test

	public void excludehomeLoanMobilePage() {
		System.out.println("This is exclude Mobile Login for Home Loan");
	}

	@Test

	public void excludehomeLoanAPIPage() {
		System.out.println("This is exclude API Login for Home Loan");
	}

	@Test

	public void excludehomeLoanWebage() {
		System.out.println("This is exclude Web Login for Home Loan");
	}

	// Coverage within the Test Folder in testng.xml
	@BeforeTest
	public void beforeTest() {
		System.out.println("I am Before Test Annotation");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am Before Suite Annotation");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am After Suite Annotation");
	}

}
