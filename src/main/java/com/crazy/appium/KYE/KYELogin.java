package com.crazy.appium.KYE;

import org.openqa.selenium.By;
import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class KYELogin {

	public void login(AndroidDriver<AndroidElement> driver) throws Exception {

		
		driver.findElement(By.name("登录")).click();
		driver.findElement(By.id("com.oxbix.spanlogistics:id/edit_text_login_phone")).sendKeys("18025478840");
//		driver.findElement(By.id("com.oxbix.spanlogistics:id/button_login_get_verification_code")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.oxbix.spanlogistics:id/edit_text_login_verification_code")).sendKeys("875763");
		driver.findElement(By.id("com.oxbix.spanlogistics:id/button_login_login")).click();
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("开始执行脚本");
		AndroidDriver<AndroidElement> driver = fengzhuang.AndroidKYEsetUp();
		
		KYELogin kyeLogin = new KYELogin();
		kyeLogin.login(driver);
		
		
		
		System.out.println("脚本执行结束");
		driver.quit();
	}

}
