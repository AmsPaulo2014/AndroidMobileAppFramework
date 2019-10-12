package ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OR_DashboardScreen {
	
	public OR_DashboardScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy (xpath="//android.widget.TextView[@text='Animation']")
	public AndroidElement animation;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Accessibility']")
	public AndroidElement accessibility;
}
