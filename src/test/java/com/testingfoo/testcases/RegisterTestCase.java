package com.testingfoo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingfoo.base.BaseTest;
import com.testingfoo.rough.ReadingToastMessage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.sourceforge.tess4j.TesseractException;

public class RegisterTestCase extends BaseTest {

	private String expectedResult;

	@Test
	public void test() {
		
		System.out.println("**TestCase Started**");
		
		driver.findElement(By.id(OR.getProperty("RegisterBtn"))).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("RegistrationPageUserNameTextField"))));
		
		driver.findElement(By.id(OR.getProperty("RegistrationPageUserNameTextField"))).sendKeys("uday.ss@outlook.com");
		
		driver.findElement(By.id(OR.getProperty("RegistrationPagePasswordTextField"))).sendKeys("pass1234");
		
		driver.findElement(By.id(OR.getProperty("RegistrationPageConfirmPasswordTextField"))).sendKeys("pass1234");
		
		driver.findElement(By.id(OR.getProperty("CreateBtn"))).click();
		
		
		try {
			expectedResult=ReadingToastMessage.readToastMessage(driver);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Assert.assertEquals(expectedResult.contains("Account Successfully Created"), true);
		

		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.HOME));

		
		System.out.println("Testcase Completed");
		
	}
}
