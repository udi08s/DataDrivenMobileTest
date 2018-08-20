package com.testingfoo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	public static DesiredCapabilities cap;
	public static AndroidDriver<MobileElement> driver;

	public static Properties config = new Properties();
	public static Properties OR = new Properties();

	@BeforeSuite
	public void setUp() throws MalformedURLException {

		if (driver == null) {
			
			FileInputStream fis = null;

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("platformName").equals("Android")) {
				
				System.out.println("Test Started");

				//File appDir = new File("src");
				//File app = new File(appDir, "ApiDemos-debug.apk");

				cap = new DesiredCapabilities();
				cap.setCapability("deviceName", config.getProperty("deviceName"));
				cap.setCapability("udid", config.getProperty("udid")); // Give Device ID of your mobile phone
				cap.setCapability("platformName", config.getProperty("platformName"));
				cap.setCapability("platformVersion", config.getProperty("platformVersion"));
				cap.setCapability("appPackage", config.getProperty("appPackage"));
				cap.setCapability("appActivity", config.getProperty("appActivity"));
				cap.setCapability("noReset", config.getProperty("noReset"));
				
				driver = new AndroidDriver<MobileElement>(new URL("http:/127.0.0.1:4723/wd/hub"), cap);
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				System.out.println("Testing GitHub");
			}

			
		}
	}

	@Test
	public void test() {
		System.out.println("Test Pass");
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("Test Complete");
		driver.quit();
	}
}
