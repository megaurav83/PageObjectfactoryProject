package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import customAnnotations.RetyCountIfFailed;

public class RetryListener implements IRetryAnalyzer {
	int count = 0;
	int maxCount = 4;

	public boolean retry(ITestResult result) {

		if (count < maxCount) {

			count++;
			return true;
		}

		/*
		 * RetyCountIfFailed annotation =
		 * result.getMethod().getConstructorOrMethod().getMethod().getAnnotation
		 * (RetyCountIfFailed.class);
		 * 
		 * result.getMethod()--> ITestNGMethod Interface
		 * result.getMethod().getConstructorOrMethod() --> Constructoror method
		 * Class result.getMethod().getConstructorOrMethod().getMethod() -->
		 * Method Class from java.lang.reflect
		 * result.getMethod().getConstructorOrMethod().getMethod().getAnnotation
		 * (annotationClass) --> it will give the annotation of the class that
		 * you have passed
		 * 
		 * 
		 * if((annotation!=null)&&(count<annotation.value())){
		 */

		/* System.out.println(annotation.value()); */

		else {
			return false;
		}

	}
}
