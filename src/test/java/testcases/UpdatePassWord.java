package testcases;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.HomeScreen;
import pageObjects.LoginHelioScreen;
import pageObjects.NguoiDung;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class UpdatePassWord {

	AppiumDriver<MobileElement> driver=null;
	HomeScreen homeS=new HomeScreen();
	LoginHelioScreen loginHelio=new LoginHelioScreen();
	NguoiDung nguoidung=new NguoiDung();

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
	
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
				driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
		}
		

	//logout
	@Test
	public void logout() {
		
		//click vao tab Nguoi dung
		driver.findElementByXPath(nguoidung.getBtnNguoiDung()).click();
		
		//Tai khoan cua toi
		driver.findElementByXPath(nguoidung.getBtnTaikhoancuatoi()).click();
		
		//Dang xuat
		driver.findElementByXPath(nguoidung.getBtnDangxuat()).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	
}
