package com.appium.testng;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DeerLogout {
	
	public static void logout(AndroidDriver<AndroidElement> driver){
		fengzhuang.ClickMenu(driver, 4);
		driver.findElement(By.id("com.yce.deerstewardphone:id/lay_setting")).click();
		driver.findElement(By.id("com.yce.deerstewardphone:id/lay_logout")).click();
		driver.findElement(By.id("com.yce.deerstewardphone:id/btn_conform")).click();
		System.out.println("账号退出成功");
	}
	

}
