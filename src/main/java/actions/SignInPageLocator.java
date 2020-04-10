package actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageLocator {
	
	
	@FindBy(css="input#ap_email")
	public WebElement eMailSignIn;
	
	@FindBy(css="input#continue.a-button-input")
	public WebElement continueBtnSignIn;
	
	@FindBy(css="input#ap_password")
	public WebElement passWordSignIn;
	
	@FindBy(css="input#signInSubmit.a-button-input")
	public WebElement signInBtn;
	
	@FindBy(css="a#createAccountSubmit")
	public WebElement createAccoutbtn;
	
}
