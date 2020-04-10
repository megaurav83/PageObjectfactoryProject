package rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoAmazon {

	public static WebDriver driver;

	public static void initConfig() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void quitBrowser() {
		driver.quit();
	}

	public void signIn() {
		initConfig();
		WebElement signInBlock = driver.findElement(By.cssSelector("a#nav-link-accountList.nav-a.nav-a-2"));
		WebElement signInbtn = driver.findElement(
				By.xpath("//div[@id='nav-signin-tooltip']/a/span[@class='nav-action-inner'][text()='Sign in']"));
		signInbtn.click();
		WebElement eMailSignIn = driver.findElement(By.cssSelector("input#ap_email"));
		WebElement continueBtnSignIn = driver.findElement(By.cssSelector("input#continue.a-button-input"));
		eMailSignIn.sendKeys("9899894875");
		continueBtnSignIn.click();
		WebElement passWordSignIn = driver.findElement(By.cssSelector("input#ap_password"));
		WebElement signInBtn = driver.findElement(By.cssSelector("input#signInSubmit.a-button-input"));
		passWordSignIn.sendKeys("Eva@1234");
		signInBtn.click();
		quitBrowser();
	}

	public void createAccount() {
		initConfig();

		WebElement signInBlock = driver.findElement(By.cssSelector("a#nav-link-accountList.nav-a.nav-a-2"));
		WebElement signInbtn = driver.findElement(
				By.xpath("//div[@id='nav-signin-tooltip']/a/span[@class='nav-action-inner'][text()='Sign in']"));
		signInbtn.click();
		WebElement createAccoutbtn = driver.findElement(By.cssSelector("a#createAccountSubmit"));
		createAccoutbtn.click();
		WebElement custName = driver.findElement(By.cssSelector("input#ap_customer_name"));
		WebElement mobNumber = driver.findElement(By.cssSelector("input#ap_phone_number"));
		WebElement eMailCreateAccount = driver.findElement(By.cssSelector("input#ap_email"));
		WebElement passWord = driver.findElement(By.cssSelector("input#ap_password"));
		WebElement continueBtn = driver.findElement(By.cssSelector("input#continue.a-button-input"));

		custName.sendKeys("testuser");
		mobNumber.sendKeys("9899101011");
		eMailCreateAccount.sendKeys("merajguru@gmail.com");
		passWord.sendKeys("Eva@090909");
		continueBtn.click();
		quitBrowser();
	}

	public static void main(String[] args) {

		DoAmazon t = new DoAmazon();
		t.signIn();
		t.createAccount();
		
		System.out.println("Adding the code to Git");
	}

}
