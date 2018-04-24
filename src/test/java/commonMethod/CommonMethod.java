package commonMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class CommonMethod {

	
	public boolean isElementPresent(AppiumDriver<MobileElement> driver, String xpath) {
		  try {
		    driver.findElementByXPath(xpath);
		    return true;
		  }
		catch (org.openqa.selenium.NoSuchElementException e) {
		    return false;
		  }
		}
	
	
	public void swipeUp(AppiumDriver<MobileElement> driver, MobileElement elm, int space) {
		int startX = (int) ((driver.manage().window().getSize().getWidth()) * 0.70);
		int endX = (int) ((driver.manage().window().getSize().getWidth()) * 0.20);
		
		Point point = elm.getLocation();
		
		int startY = point.y;
	
		System.out.println("starty:"+ startY);
		
		//scroll
		TouchAction actions = new TouchAction(driver);
		actions.press(startX, startY).waitAction(Duration.ofSeconds(2)).moveTo(startX, startY-space).release().perform();
	}
	
}
