package com.testingfoo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testingfoo.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LoginTest extends BaseTest {

	@Test(dataProvider="getData")
	public void loginTest(String userName,String password) {
		
		//System.out.println("**TestCase Started**");
		
		driver.launchApp();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OR.getProperty("LoginPageUserNameTF"))));
		
        driver.findElement(By.id(OR.getProperty("LoginPageUserNameTF"))).sendKeys(userName);
		
		driver.findElement(By.id(OR.getProperty("LoginPagePasswordTF"))).sendKeys(password);
	
		try {
            driver.hideKeyboard();
            } catch (Exception e) {
            }
		
		driver.findElement(By.xpath(OR.getProperty("LoginBtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("LoginBtn"))).click();
	
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expectedResult = driver.findElement(By.id(OR.getProperty("SuccessPageText"))).getText();
		
		Assert.assertEquals(expectedResult.contains("You have sucessfully logged in :)"), true);
		
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); 

      //System.out.println("Testcase Completed");
      
      
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] obj= new Object[3][2];
		
		obj[0][0]="uday.ss@outlook.com";
		obj[0][1]="pass1234";
		
		obj[1][0]="uday.ss@outlook.com";
		obj[1][1]="pass12345";
		
		obj[2][0]="uday.s22s@outlook.com";
		obj[2][1]="pass12345";
		
		return obj;
		
		
	}
	
	
	
}

