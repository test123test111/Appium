package com.crazy.appium.maimai;

import org.openqa.selenium.By;

import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class maimaiHunhe {
	
	
	
	public static void start(AndroidDriver<AndroidElement> driver) throws Exception {
		Thread.sleep(10000);
		fengzhuang.yinshiWait(driver);
		driver.findElement(By.name("人脉办事")).click();
		driver.findElement(By.name("极速找人")).click();
		
		Thread.sleep(5000);
		System.out.println(driver.getContextHandles());
	}
	
	public static void main(String[] args) throws Exception {
		AndroidDriver<AndroidElement> driver = fengzhuang.AndroidmaimaisetUp();
		start(driver);
	}

	
	

}
