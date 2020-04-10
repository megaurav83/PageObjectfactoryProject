package actions;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Page;


public class SignInPage extends Page {
	public SignInPageLocator signPage;

	public SignInPage() {

		this.signPage = new SignInPageLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.signPage);

	}

	public void doLogin(String usrname, String pwd) {
		
		type(signPage.eMailSignIn,usrname);
		click(signPage.continueBtnSignIn);
		type(signPage.passWordSignIn,pwd);
		click(signPage.signInBtn);

	}

	public CreateAccountPage goToCreateAccountPage() {
		click(signPage.createAccoutbtn); 
		return new CreateAccountPage();

	}

}
