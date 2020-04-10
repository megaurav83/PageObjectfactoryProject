package actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Page;

public class HomePage extends Page {
	
	public HomePageLocator home;
	
public HomePage() {
		
		this.home= new HomePageLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);		
		PageFactory.initElements(factory, this.home);

	}

	public SignInPage goToSignInPage() {
		
		
		/*signInbtn.click();*/
		 
		/*WebElement signInbtn = driver.findElement(By.cssSelector("div#nav-signin-tooltip > a>span.nav-action-inner"));
		signInbtn.click();*/
		
		click(home.signInbtn);
			

		return new SignInPage();

	}


}
