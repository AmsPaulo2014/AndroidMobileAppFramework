package ExtentReport;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import TestScripts.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class htmlExtentReport {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reporter;
	public static ExtentTest logger;
	public static AndroidDriver<AndroidElement> driver;
	
	
	public static ExtentReports startReport()
	{
		 Date date= new Date();
		 String name= date.toString().replace(":", "_").replace(" ", "_")+".html";
		 htmlReporter = new ExtentHtmlReporter( System.getProperty("user.dir")+"\\ExtentReportResult\\"+name);
		 reporter= new ExtentReports();
		 reporter.attachReporter(htmlReporter);
		 
		 // System information
		 reporter.setSystemInfo("OS" , "Android");
		 reporter.setSystemInfo("Host Name" , "Host_001");
		 reporter.setSystemInfo("Environment" , "QA Environment");
		 reporter.setSystemInfo("UserName" , "Amol Pawar");
	
		 return reporter;			
		
	}
	
	public static void endReport()
	{
		reporter.flush();
	}

	public static void getResult(ITestResult result)
	{

		 try {
			if(result.getStatus()==ITestResult.FAILURE)
			 {
				 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"TestCase failed due to below issue : ", ExtentColor.RED));
				 logger.info(result.getThrowable());
				 
				 String screenshotPath = htmlExtentReport.screenShotOfFailedTCs(driver, result.getName());
				 logger.fail("Screen Shot : " + logger.addScreenCaptureFromPath(screenshotPath));
			 }
			 else if(result.getStatus()==ITestResult.SUCCESS)
			 {
				 logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" TestCase Passed", ExtentColor.GREEN));
				 
					String screenshotPath = htmlExtentReport.screenShotOfPassedTCs(driver, result.getName());
					logger.pass("Screen Shot : " + logger.addScreenCaptureFromPath(screenshotPath));

			 }
			 else
			 {
				 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" TestCase Skipped", ExtentColor.ORANGE));
				 logger.info(result.getThrowable());
			 }
		} 
		 catch (Exception e) 
		 {
			System.out.println(" getResult Error message is >>" +e);
		}
	 
	}
	
	
	
	public static String screenShotOfPassedTCs(AndroidDriver<AndroidElement> driver,String screenshotName) throws IOException
	{
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_");
		TakesScreenshot screen = (TakesScreenshot) BaseClass.driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		//String dest ="C:\\Users\\Admin\\eclipse-workspace\\DemoApp\\Screenshots\\PassTCsScreeshots\\" + screenshotName +"_" + fileName + ".png";
		String dest = System.getProperty("user.dir")+"\\Screenshots\\PassTCsScreeshots\\" + screenshotName +"_" + fileName + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
		
	}
	
	public static String screenShotOfFailedTCs(AndroidDriver<AndroidElement> driver,String screenshotName)throws IOException
	{

		Date d = new Date();
		String dateName = d.toString().replace(":", "_").replace(" ", "_");
		
		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//String destination = "C:\\Users\\Admin\\eclipse-workspace\\DemoApp\\Screenshots\\FailedTCsScreenshots\\" + screenshotName + "_"+dateName + ".png";
		String destination = System.getProperty("user.dir")+"\\Screenshots\\FailedTCsScreenshots\\" + screenshotName + "_"+dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	
	}
}
