package com.testingfoo.rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class firstpgm {
	
	private static DesiredCapabilities cap;

	
	@Test
	public void test() throws MalformedURLException {
		
		File appDir = new File("src");
		File app = new File(appDir, "ApiDemos-debug.apk");
		
		cap=new DesiredCapabilities();
		cap.setCapability("deviceName", "Android Phone");
		cap.setCapability("udid", "LGH87292f5872c"); //Give Device ID of your mobile phone
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		cap.setCapability("noReset", "true");
		
		AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL("http:/127.0.0.1:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}

}
