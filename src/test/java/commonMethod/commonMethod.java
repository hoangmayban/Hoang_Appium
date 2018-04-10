package commonMethod;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class commonMethod {

	
	public boolean isElementPresent(AppiumDriver<MobileElement> driver, String xpath) {
		  try {
		    driver.findElementByXPath(xpath);
		    return true;
		  }
		catch (org.openqa.selenium.NoSuchElementException e) {
		    return false;
		  }
		}
	
}
