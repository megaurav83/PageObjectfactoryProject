package listener;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.Page;
import utilities.ExtentManager;
import utilities.TestUtil;

public class CustomListeners extends Page implements ITestListener,ISuiteListener {

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	static String filepath  = 	System.getProperty("user.dir")+"\\reports\\";
	static String messageBody;
	private static ExtentReports extent = ExtentManager.createInstance(filepath);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	public static ExtentTest test;
	

	public void onTestStart(ITestResult result) {

	
		test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
       
		/*testReport.set(test);*/
        
        

	}

	public void onTestSuccess(ITestResult result) {

		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		/*testReport.get().pass(m);*/
		test.log(Status.PASS, m);
		

	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output","false");
		
		
		/*String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		
		try {

			TestUtil.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotPath)
							.build());
		} catch (IOException e) {

		}*/
		
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		Markup m1 = MarkupHelper.createLabel(result.getThrowable()+"---Test case failed", ExtentColor.RED);
		test.log(Status.FAIL, m);
		test.log(Status.FAIL, m1);
		String path;
		try {
			path = TestUtil.captureScreenshot();
			
			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			

	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		

	}

	public void onFinish(ISuite arg0) {
		
		/*MonitoringMail mail = new MonitoringMail();
		 
		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/DataDrivenLiveProject/Extent_Reports/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {


		if (extent != null) {

			extent.flush();
		}
		
	}


}
