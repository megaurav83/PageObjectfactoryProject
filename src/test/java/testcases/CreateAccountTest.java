package testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import actions.HomePage;
import base.Page;
import utilities.TestUtil;

public class CreateAccountTest {
	/*@BeforeMethod
	public void setup(){
		Page.initConfiguration();
	}
	
	@AfterMethod
	public void tearDown(){
		Page.quitBrowser();
	}*/
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	
		public void createAccountTest(Hashtable<String,String>data){
		if(data.get("runmode").equalsIgnoreCase("n")){
			throw new SkipException("Skiping the iteration since runmode is no");
		}
		Page.initConfiguration();
		HomePage home = new HomePage();		
		home.goToSignInPage().goToCreateAccountPage().createAccount(data);
		Page.quitBrowser();
	}

}
