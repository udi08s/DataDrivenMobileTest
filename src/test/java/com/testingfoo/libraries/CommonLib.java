package com.testingfoo.libraries;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CommonLib {
	
	//public  AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> InstallApk(String path,AndroidDriver<MobileElement> driver) {
		
		driver.installApp(path);
		
		return driver;
				
		
	}

}
