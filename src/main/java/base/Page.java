package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class Page {

	/*
	 * WebDriver Extent Report Log4j Excel reader utility Properties
	 */
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(Page.class.getName());

	public static Properties p = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

	/* public static WebDriverWait wait = new WebDriverWait(driver,10); */
	public static void initConfiguration() {

		setLogPropertiesPath();

		/* if (driver == null) { */

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			p.load(fis);
			log.info("Property file loaded");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (p.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);

			log.info("Chrome Lauched");

		} else if (p.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (p.getProperty("browser").equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}

		driver.get("https://www.amazon.in");

		log.info("navigating to test site");
		driver.manage().window().maximize();
		/* driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); */

	}

	public static void quitBrowser() {
		setLogPropertiesPath();
		if (driver != null) {
			log.info("quiting the browser");
			driver.quit();

		}

	}

	public static void setLogPropertiesPath() {
		/*
		 * String log4jConfpath =
		 * "./src/test/resources/properties/log4j.properties";
		 */
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

	}

	public static void click(WebElement element) {

		element.click();

	}

	public static void type(WebElement element, String value) {

		element.sendKeys(value);

	}

	@SuppressWarnings("finally")
	public static WebElement findElement(String locator, int time) {

		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(locator));
		} catch (Throwable t) {
			for (int i = 0; i < time; i++) {
				element = driver.findElement(By.xpath(locator));
				Thread.sleep(2000);
			}
		} finally {
			return element;
		}

	}

	public void moveToElement(WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}
	public void dragAndDrop(WebElement source, WebElement target) {

		Actions action = new Actions(driver);
		action.dragAndDrop(source, target);

	}

	public void selectFromDropDownByVisibleText(WebElement dropDown, String visibleText) {

		Select select = new Select(dropDown);
		select.selectByVisibleText(visibleText);

	}

	public void selectFromDropDownByIndex(WebElement dropDown, int index) {

		Select select = new Select(dropDown);
		select.selectByIndex(index);
	}
	
	public void selectFromDropDownByvalue(WebElement dropDown, String value) {

		Select select = new Select(dropDown);
		select.selectByValue(value);
	}

}
