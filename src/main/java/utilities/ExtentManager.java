package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	

    public static ExtentReports createInstance(String fileName) {
        /*ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);*/
       
        ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle(fileName);
        spark.config().setEncoding("utf-8");
        spark.config().setReportName(fileName);
        
        extent = new ExtentReports();
        
        extent.attachReporter(spark);
        extent.setSystemInfo("Automation Tester", "Gaurav Bhardwaj");
        extent.setSystemInfo("Organization", "Personal");
        extent.setSystemInfo("Build no", "W2A-1234");
        
        
        return extent;
    }

}
