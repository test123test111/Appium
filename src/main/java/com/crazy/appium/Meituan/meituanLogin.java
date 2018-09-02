package com.crazy.appium.Meituan;

import org.openqa.selenium.By;

import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class meituanLogin {

	
	public static void login(AndroidDriver<AndroidElement> driver) throws Exception {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		menu.clickMenu(driver, 1);
		fengzhuang.yinshiWait(driver, 2000);
//		if(fengzhuang.isElememtExist(driver, By.id("com.sankuai.meituan:id/user_name"))) {
//			driver.findElement(By.id("com.sankuai.meituan:id/avatar")).click();
//			driver.findElement(By.id("com.sankuai.meituan:id/user_password_login")).click();
////			driver.findElement(By.id("com.sankuai.meituan:id/passport_mobile_phone")).sendKeys("18025478840");
//			driver.findElement(By.id("com.sankuai.meituan:id/edit_password")).sendKeys("62218852000duan");
//			try {
//				Thread.sleep(3000);
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//			driver.findElement(By.id("com.sankuai.meituan:id/login_button")).click();
//			try {
//				Thread.sleep(5000);
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}else {
//			System.out.println("账号未登录");
//			try {
//				Thread.sleep(3000);
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}
		
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='com.sankuai.meituan:id/container']/android.widget.ImageView[1]")).click();
		Thread.sleep(10000);
		System.out.println(driver.getContext());
		System.out.println("---------------------------");
		System.out.println(driver.getContextHandles());
		
	}
	
	public static void main(String[] args) {
		
		
		try {
			AndroidDriver<AndroidElement> driver = fengzhuang.AndroidmeituansetUp();
			System.out.println("脚本开始执行");
			login(driver);
			
			
			
			Thread.sleep(5000);
			
			System.out.println("脚本已经执行完成，等待退出");
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
