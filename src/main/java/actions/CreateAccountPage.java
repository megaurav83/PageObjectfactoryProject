package actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Page;



public class CreateAccountPage extends Page {
	
	public CreateAccountPageLocator CreateAccount;
	
	public CreateAccountPage(){
		
		this.CreateAccount = new CreateAccountPageLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.CreateAccount);
		
		
	}
	
	
	public void createAccount(String userName, String MobNo, String eMail,String Pwd){
		
		
		type(CreateAccount.custName,userName);
		type(CreateAccount.mobNumber,MobNo);
		type(CreateAccount.eMailCreateAccount,eMail);
		type(CreateAccount.passWord,Pwd);
		click(CreateAccount.continueBtn);
		
	}

}
