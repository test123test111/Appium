package com.crazy.appium.Zhihu;

import org.openqa.selenium.By;

import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class zhihuLogin {
	
	public static void login(AndroidDriver<AndroidElement> driver) throws Exception {
		if(fengzhuang.isElementExist(driver, By.id("com.zhihu.android:id/search_box"))) {
			System.out.println("账号已经登录");
		}else {
			driver.findElement(By.id("com.zhihu.android:id/login_btn")).click();
			driver.findElement(By.id("com.zhihu.android:id/username")).sendKeys("437765664@qq.com");
			driver.findElement(By.id("com.zhihu.android:id/password")).sendKeys("74543804duan");
			Thread.sleep(3000);
			//driver.findElements(By.name("登录")).get(1).click();
			driver.findElement(By.id("com.zhihu.android:id/btn_progress")).click();
		}
		
	}
	public static void main(String[] args) throws Exception {
		AndroidDriver<AndroidElement> driver = fengzhuang.AndroidZhihusetUp();
		System.out.println("开始启动脚本");
		fengzhuang.yinshiWait(driver, 10);
		login(driver);
		
		fengzhuang.clickMenu(driver, 5);
		
		if(driver.findElement(By.id("com.zhihu.android:id/night_mode_switch")).getAttribute("checked").equals("false")) {
			System.out.println("夜间模式是关闭状态");
			driver.findElement(By.id("com.zhihu.android:id/night_mode_switch")).click();
			System.out.println("夜间模式开启成功");
		}else {
			System.out.println("夜间模式是开启状态");
			driver.findElement(By.id("com.zhihu.android:id/night_mode_switch")).click();
			System.out.println("夜间模式关闭成功");
		}
		
		
		
		
//		zhihuLogout.logout(driver);
		Thread.sleep(3000);
		
		
		
		
		
		System.out.println("执行完成，准备执行退出");
		driver.quit();
	}

}
