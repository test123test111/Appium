package com.crazy.appium.KYE;

import org.openqa.selenium.By;
import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ifLogin {
	
	public static void iflogin(AndroidDriver<AndroidElement> driver) throws Exception {
		
		KYEfengzhuang.clickKYEMenu(driver, 5);
		if (fengzhuang.isElementExist(driver, By.id("com.oxbix.spanlogistics:id/super_text_view_logout"))) {
			System.out.println("账号已经登录");
			KYEloginout kyEloginout = new KYEloginout();
			kyEloginout.loginout(driver);
			
		}else {
			
			KYELogin kyeLogin = new KYELogin();
			kyeLogin.login(driver);
		}
		
	}
	public static void main(String[] args) throws Exception {
		
		AndroidDriver<AndroidElement> driver = fengzhuang.AndroidKYEsetUp();
		
		iflogin(driver);
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
