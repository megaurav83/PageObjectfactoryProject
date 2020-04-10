package testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import actions.HomePage;
import base.Page;
import utilities.TestUtil;

public class SignInTest {

	/*public WebDriver driver;*/
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void signInTest(Hashtable<String,String> data){
		/*WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		WebElement signInbtn = driver.findElement(By.xpath("//div[@id='nav-signin-tooltip']/a/span[@class='nav-action-inner'][text()='Sign in']"));
		signInbtn.click();*/
		
		if(data.get("runmode").equalsIgnoreCase("n")){
			
			throw new SkipException("Skipping the test case as mode is n");
		}
		Page.initConfiguration();
		HomePage home = new HomePage();	
		
		home.goToSignInPage().doLogin(data.get("username"), data.get("password"));
		
		
		Page.quitBrowser();
		
		
		
	}

}
