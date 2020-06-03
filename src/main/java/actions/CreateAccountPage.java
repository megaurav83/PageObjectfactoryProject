package actions;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.Test;

import base.Page;
import utilities.TestUtil;



public class CreateAccountPage extends Page {
	
	public CreateAccountPageLocator CreateAccount;
	
	public CreateAccountPage(){
		
		this.CreateAccount = new CreateAccountPageLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.CreateAccount);
		
		
	}
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void createAccount(Hashtable<String,String>data){
		
		
		type(CreateAccount.custName,data.get("userName"));
		type(CreateAccount.mobNumber,data.get("MobNo"));
		type(CreateAccount.eMailCreateAccount,data.get("eMail"));
		type(CreateAccount.passWord,data.get("Pwd"));
		click(CreateAccount.continueBtn);
		
		
	}

}
