package TestSuites;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ExtentReport.htmlExtentReport;
import TestScripts.BaseClass;
import TestScripts.dashBoardScreen;

public class demoSuite extends BaseClass {
	
	BaseClass suite = new BaseClass();
	htmlExtentReport report= new htmlExtentReport();
	dashBoardScreen dashBoardScreen = new dashBoardScreen();

	@Test (priority=1)
	public void Test1()
	{
		dashBoardScreen.Accessibility();
		
	}
	@Test (priority=2)
	public void Test2()
	{
		dashBoardScreen.Animation();
	}
	
	
	@BeforeSuite (alwaysRun=true)
	public void StartExtentReport() throws MalformedURLException
	{
		System.out.println("Extent Report about to Started");
		report.startReport();
		System.out.println("Extent Report Started");
	}
	
	
	@BeforeTest
	public void beforeTest() throws MalformedURLException
	{
		System.out.println("App Initialization");
		suite.applaunch();
		System.out.println("App Launch Successfully");
	}
	@AfterTest
	public void EndExtentReport()
	{
		System.out.println("Extent Report about flush");
		report.reporter.flush();	
		System.out.println("Extent Report about flush successfully");
	}
	
	@AfterSuite
	public void reportfinish()
	{
		System.out.println("Extent Report about to End");
		htmlExtentReport.endReport();
		System.out.println("Extent Report Ended");
		
	}	
	
	@AfterMethod (alwaysRun=true)
	public void EndReportlooger(ITestResult result) throws Exception
	{	
		htmlExtentReport.getResult(result);
	}

}
