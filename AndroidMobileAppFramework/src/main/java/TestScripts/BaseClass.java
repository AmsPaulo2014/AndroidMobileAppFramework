package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	public static AndroidDriver<AndroidElement> driver;
	
	
	
	//Here we are launch the app
	public static void applaunch() throws MalformedURLException
	{
		DesiredCapabilities capabilites = new DesiredCapabilities();
		
		//Use Following capabilities for Emulator
		capabilites.setCapability(MobileCapabilityType.DEVICE_NAME, "AmolEmulator");
		capabilites.setCapability(MobileCapabilityType.APP ,System.getProperty("user.dir")+"\\apkFile\\ApiDemos-debug.apk");
		
		//Use Following capabilities for real device
		
		/*
		capabilites.setCapability("deviceName", "DeviceName");
		capabilites.setCapability("udid", "udidNumber");
		capabilites.setCapability("platformVersion", "androidVersion");
		capabilites.setCapability("platformName", "Android");
		capabilites.setCapability("appPackage", "appPackage name");
		capabilites.setCapability("appActivity", "appActivitySplash name");
		capabilites.setCapability("autoGrantPermissions", true);
		*/
		
		driver= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub") ,capabilites);		
	}

}
