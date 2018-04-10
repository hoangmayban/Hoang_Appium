package seleniumTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest {
	
	public static void main(String[] args) {
		
		AppiumDriver<MobileElement> driver=null;
		// Set the Desired Capabilities
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "My phone");
		caps.setCapability("udid", "42007b3bd088348d");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		//caps.setCapability("appPackage", "com.android.vending"); play store
		//caps.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
		//helio app
		caps.setCapability("appPackage", "vn.vooc.helio.mobile"); 
		caps.setCapability("appActivity", "vn.vooc.helio.mobile.ui.walkthrough.SplashActivity");
		caps.setCapability("noReset", "true");
		
		//Instantiate Appium Driver
		try {
			driver=new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
		} catch(MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		driver.findElementByXPath("//*[@resource-id='vn.vooc.helio.mobile:id/loginHelio']").click();
		driver.findElementById("vn.vooc.helio.mobile:id/edtEmail").sendKeys("v2hoang@gmail.com");

	}

}
