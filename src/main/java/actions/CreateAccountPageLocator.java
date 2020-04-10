package actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPageLocator {
	
	@FindBy(css="input#ap_customer_name")
	public WebElement custName;
	
	@FindBy(css="input#ap_phone_number")
	public WebElement mobNumber;
	
	@FindBy(css="input#ap_email")
	public WebElement eMailCreateAccount;
	
	@FindBy(css="input#ap_password")
	public WebElement passWord;
	
	@FindBy(css="input#continue.a-button-input")
	public WebElement continueBtn;
	
	
	
	

}
