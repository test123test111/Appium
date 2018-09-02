package com.appium.testng;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DeerTest2 {
	AndroidDriver<AndroidElement> driver;
	 
	
	@BeforeClass
	public void beforeclass() throws Exception{
		driver = fengzhuang.AndroidsetUp(4724,"127.0.0.1:62001");
	}

	
	
	@Test
	public void t1_login() throws Exception{
		Deerlogin.Login(driver,"18025478840");
		Assert.assertEquals(true, driver.getPageSource().contains("商城"));
	}
	@Test(dependsOnMethods = "t1_login")
	public void t2_logout(){
		DeerLogout.logout(driver);
		Assert.assertEquals(true,driver.getPageSource().contains("使用账号密码登录"));
		
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}

}
