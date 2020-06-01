package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import customAnnotations.RetyCountIfFailed;

public class RetryTestCase {
	
	
	
	
	@Test(retryAnalyzer=listener.RetryListener.class)
	public void retryMechanism(){
		
		Assert.assertEquals(10, 20);
		
		System.out.println("Checking the retry mechanism");
		
		
	}

}
