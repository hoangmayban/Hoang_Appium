package testcases;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.HomeScreen;
import pageObjects.LoginHelioScreen;
import pageObjects.NguoiDung;
import pageObjects.TaiKhoanCuaToi;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;



import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.net.HostAndPort;

import commonMethod.CommonMethod;



public class UpdateThongTinCaNhan {

	AppiumDriver<MobileElement> driver=null;
	HomeScreen homeS=new HomeScreen();
	LoginHelioScreen loginHelio=new LoginHelioScreen();
	NguoiDung nguoidung=new NguoiDung();
	TaiKhoanCuaToi myAccount=new TaiKhoanCuaToi();
	String sHoten="hoang vo";
	String sHoten2="hoangvoviet";
	String sNgaysinh="1989-01-21";
	String sCMND="191728876";
	CommonMethod cm=new CommonMethod();

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
	public void updateThongTinCaNhan() {
		
		//Step 1: click vao tab Nguoi dung
		driver.findElementByXPath(nguoidung.getBtnNguoiDung()).click();
		
		//Step 2: Tai khoan cua toi
		driver.findElementByXPath(nguoidung.getBtnTaikhoancuatoi()).click();
		
		//Step 3: tab on Thong tin ca nhan
		driver.findElementByXPath(myAccount.getBtnThongTinCaNhan()).click();
		
		//Step 4: nhap du lieu

		driver.findElementByXPath(myAccount.getTxtHoTen()).clear();
		driver.findElementByXPath(myAccount.getTxtHoTen()).sendKeys(sHoten);
		
		driver.findElementByXPath(myAccount.getTxtNgaySinh()).setValue(sNgaysinh);
			
		driver.findElementByXPath(myAccount.getTxtCMND()).clear();
		driver.findElementByXPath(myAccount.getTxtCMND()).sendKeys(sCMND);
			
		//Step 5: luu thay doi
		driver.findElementByXPath(myAccount.getBtnLuuThayDoi()).click();
		
		
		//pop up hien thi khi thong tin khong thay doi, thuc hien sua hoten va luu
		if(cm.isElementPresent(driver, myAccount.getBtnCancel())) {
			driver.findElementByXPath(myAccount.getBtnCancel()).click();
			driver.findElementByXPath(myAccount.getTxtHoTen()).clear();
			driver.findElementByXPath(myAccount.getTxtHoTen()).sendKeys(sHoten2);
			driver.findElementByXPath(myAccount.getBtnLuuThayDoi()).click();
			//verify
			driver.findElementByXPath(myAccount.getBtnThongTinCaNhan()).click();
			assertTrue(driver.findElementByXPath(myAccount.getTxtHoTen()).getText().equals(sHoten2));
		}else {
			//verify
			driver.findElementByXPath(myAccount.getBtnThongTinCaNhan()).click();
			assertTrue(driver.findElementByXPath(myAccount.getTxtHoTen()).getText().equals(sHoten));
		}
		
	}
	

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	
}
