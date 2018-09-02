package com.crazy.appium.KYE;

import org.openqa.selenium.By;

import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class t1_signIn {
	public static void kyeSignIn(AndroidDriver<AndroidElement> driver) throws Exception {
		Thread.sleep(5000);
		if(driver.getPageSource().contains("发现新版本")) {
			driver.findElement(By.id("com.oxbix.spanlogistics:id/iv_update_main_cancel")).click();
			driver.findElement(By.id("com.oxbix.spanlogistics:id/md_buttonDefaultNegative")).click();	
		}

		KYEfengzhuang.clickKYEMenu(driver, 5);
		driver.findElement(By.id("com.oxbix.spanlogistics:id/linear_layout_info")).click();
		driver.findElement(By.id("com.oxbix.spanlogistics:id/edit_text_login_phone")).sendKeys("13392414902");
		driver.findElement(By.id("com.oxbix.spanlogistics:id/button_login_get_verification_code")).click();
		Thread.sleep(40000);
		driver.findElement(By.id("com.oxbix.spanlogistics:id/button_login_login")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.oxbix.spanlogistics:id/edit_text_complete_information_name")).sendKeys("张子强");
		driver.findElement(By.id("com.oxbix.spanlogistics:id/edit_text_complete_information_company")).sendKeys("深圳市粤创科技有限公司");
		driver.findElement(By.id("com.oxbix.spanlogistics:id/button_complete_information_submit")).click();
		Thread.sleep(10000);
		
	}
	public static void main(String[] args) throws Exception {
		AndroidDriver<AndroidElement> driver = fengzhuang.AndroidKYEsetUp();
		kyeSignIn(driver);
		
		
		
		
	}

}
