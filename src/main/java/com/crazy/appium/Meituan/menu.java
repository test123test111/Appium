package com.crazy.appium.Meituan;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class menu {

	public static void clickMenu(AndroidDriver<AndroidElement> driver,int order) {
		if(order>0&&order<6) {
			driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[3]/android.widget.LinearLayout[1]/android.view.View["+order+"]")).click();
		}else {
			System.out.println("输入的底部菜单栏的数字不准确，请确认后重新输入");
		}
	}
}
