package com.appium.testng;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DeerTest1 {
	AndroidDriver<AndroidElement> driver;
	 
	@Parameters({"port","udid"})
	@BeforeClass
	public void beforeclass(int port,String udid) throws Exception{
		driver = fengzhuang.AndroidsetUp(port,udid);
	}

	
	
	@Test
	public void t1_login() throws Exception{
		Deerlogin.Login(driver,"17688930446");
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
