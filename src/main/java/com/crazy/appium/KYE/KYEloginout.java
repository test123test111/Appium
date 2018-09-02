package com.crazy.appium.KYE;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class KYEloginout {
	
	public void loginout(AndroidDriver<AndroidElement> driver) {
		
		
		KYEfengzhuang.clickKYEMenu(driver, 5);
		
		driver.findElement(By.id("com.oxbix.spanlogistics:id/super_text_view_logout")).click();
		
		driver.findElement(By.id("com.oxbix.spanlogistics:id/md_buttonDefaultPositive")).click();
		
		System.out.println("账号退出成功");
		
	}

}
