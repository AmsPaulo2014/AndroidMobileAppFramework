package TestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import ExtentReport.htmlExtentReport;
import com.aventstack.extentreports.Status;

import ObjectRepository.OR_DashboardScreen;
import  ReadAndWriteXL.ReadExcelFile;

public class dashBoardScreen extends BaseClass {
	//ClassExtentReports report = new ClassExtentReports();
	
	htmlExtentReport report= new htmlExtentReport();
	ReadExcelFile ReadExcelFile = new ReadExcelFile();
	
	@Test
	public void myTest() throws IOException
	{
		String city =ReadExcelFile.readCellData1(2, 1);
		System.out.println("===> 1 " +city);
		
		
		//System.out.println(ReadExcelFile.readCellData1(2, 0));
		
	}
	public void Accessibility()
	{		
		try {
				OR_DashboardScreen dashboardScreenElement = new OR_DashboardScreen(driver);
				report.logger= report.reporter.createTest("Test Case 1");
				report.logger.log(Status.INFO, "accessibility button is about to click");
				dashboardScreenElement.accessibility.click();
				//driver.findElementByXPath("//android.widget.TextView[@text='Accessibility']").click();
				report.logger.log(Status.INFO, "Accessibility button is clicked");
				Thread.sleep(2000);
				assertTrue(true);
				driver.navigate().back();
			} 
			catch (Exception e) 
			{
				System.out.println("Accessibility() Error message is >>" +e);
				assertTrue(false);
			}		
	}
	
	public void Animation()
	{
		try {
			OR_DashboardScreen dashboardScreenElement = new OR_DashboardScreen(driver);
			report.logger= report.reporter.createTest("Test Case 2");
			report.logger.log(Status.INFO, "Animation button is about to click");
			dashboardScreenElement.animation.click();
			//driver.findElementByXPath("//android.widget.TextView[@text='Animation']").click();
			report.logger.log(Status.INFO, "Animation button is clicked");
			Thread.sleep(2000);
			assertTrue(true);
			driver.navigate().back();
			} 
		catch (InterruptedException e) 
		{
			System.out.println("Animation() Error message is >>" +e);
			assertTrue(false);
		} 
		
	}

}
