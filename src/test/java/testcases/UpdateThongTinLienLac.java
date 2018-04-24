package testcases;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.HomeScreen;
import pageObjects.LoginHelioScreen;
import pageObjects.NguoiDung;
import pageObjects.TaiKhoanCuaToi;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethod.CommonMethod;



public class UpdateThongTinLienLac {

	AppiumDriver<MobileElement> driver=null;
	
	HomeScreen homeS=new HomeScreen();
	LoginHelioScreen loginHelio=new LoginHelioScreen();
	NguoiDung nguoidung=new NguoiDung();
	TaiKhoanCuaToi myAccount=new TaiKhoanCuaToi();
	String sDienthoai="0123456789";
	String sQuocgia="Viet Nam";
	String sThanhpho="da nang";
	String sThanhpho2="Nha Trang";
	String sDiachi="Tuyen Son";
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
	public void updateThongtinLienLac() {
		
		//click vao tab Nguoi dung
		driver.findElementByXPath(nguoidung.getBtnNguoiDung()).click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//Step 2: Tai khoan cua toi
		driver.findElementByXPath(nguoidung.getBtnTaikhoancuatoi()).click();
		
		//Step 3: tab on Thong tin lien lac
		driver.findElementByXPath(myAccount.getBtnThongTinLienLac()).click();
		
		//Step 4: nhap du lieu

		MobileElement elmDienthoai;
		elmDienthoai=driver.findElementByXPath(myAccount.getTxtDienThoai());
		elmDienthoai.clear();
		elmDienthoai.sendKeys(sDienthoai);		

		driver.findElementByXPath(myAccount.getTxtQuocGia()).clear();
		driver.findElementByXPath(myAccount.getTxtQuocGia()).sendKeys(sQuocgia);
			
		driver.findElementByXPath(myAccount.getTxtThanhPho()).clear();
		driver.findElementByXPath(myAccount.getTxtThanhPho()).sendKeys(sThanhpho);
	
		//swipe to find Luu button
		cm.swipeUp(driver, elmDienthoai, 200);
		
		MobileElement btnLuu;
		btnLuu=driver.findElementByXPath(myAccount.getBtnLuuThayDoi());
			
		MobileElement diachi = driver.findElementByXPath(myAccount.getTxtDiaChi());
		diachi.clear();
		diachi.sendKeys(sDiachi);
		
		//Step 5: luu thay doi
		btnLuu.click();
		
		//pop up hien thi khi thong tin khong thay doi, thuc hien sua thanh pho va luu thanh cong
		if(cm.isElementPresent(driver, myAccount.getBtnCancel())) {
			
			driver.findElementByXPath(myAccount.getBtnCancel()).click();
			driver.findElementByXPath(myAccount.getTxtThanhPho()).clear();
			driver.findElementByXPath(myAccount.getTxtThanhPho()).sendKeys(sThanhpho2);
			driver.findElementByXPath(myAccount.getBtnLuuThayDoi()).click();
			//verify
			driver.findElementByXPath(myAccount.getBtnThongTinLienLac()).click();
			assertTrue(driver.findElementByXPath(myAccount.getTxtThanhPho()).getText().equals(sThanhpho2));
		}else {
			//verify
			driver.findElementByXPath(myAccount.getBtnThongTinLienLac()).click();
			assertTrue(driver.findElementByXPath(myAccount.getTxtThanhPho()).getText().equals(sThanhpho));
		}
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	
}
