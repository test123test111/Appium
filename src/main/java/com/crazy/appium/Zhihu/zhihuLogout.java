package com.crazy.appium.Zhihu;

import org.openqa.selenium.By;

import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class zhihuLogout {
	
	public static void logout(AndroidDriver<AndroidElement> driver) {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		fengzhuang.clickMenu(driver, 5);
		driver.findElement(By.id("com.zhihu.android:id/layout_settings")).click();
		while(true) {
			if(fengzhuang.isElementExist(driver, By.name("退出帐号"))) {
				driver.findElement(By.name("退出帐号")).click();
				driver.findElement(By.id("android:id/button1")).click();
				break;
			}else {
				try {
					fengzhuang.swipe(driver, "up", 1000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					try {
						Thread.sleep(1000);
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
					
				}
		}
		
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
}
