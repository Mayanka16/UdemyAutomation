package com.qa.TestNG;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersMethods implements ITestListener{
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+ "  -> Test Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+ " -> Test Success");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+ " -> Test Failed");
		
	}
	

}
