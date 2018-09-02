package com.crazy.appium.qq;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class qqelementSwipe {
	
	public static void elementSwipe(AndroidDriver<AndroidElement> driver) {
		
		
		fengzhuang.yinshiWait(driver, 2);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.TabHost[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.AbsListView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]")).swipe(SwipeElementDirection.LEFT, 5, 5, 1000);
//		driver.findElement(By.name("删除")).click();
//		
////		driver.findElements(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.TabHost[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.AbsListView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]")).get(0).swipe(SwipeElementDirection.LEFT, 5, 5, 1000);
////		driver.findElements(By.id("com.tencent.mobileqq:id/name")).get(2).click();
//		
//		
//		
//		//String app=driver.currentActivity();
//		driver.tap(1, driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.TabHost[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[2]/android.widget.AbsListView[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]")), 200);
//		System.out.println(driver.getAppStringMap());
		

//		driver.findElementByAccessibilityId("看看手机通讯录里哪些人在用QQ。").click();
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='com.tencent.mobileqq:id/root']/android.widget.RelativeLayout[2]")).swipe(SwipeElementDirection.DOWN, 10, 10, 2000);
//		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"快捷入口\")").click();
		driver.findElementByAccessibilityId("快捷入口").click();
		driver.findElementByAccessibilityId("创建群聊 按钮").click();
		driver.pressKeyCode(4);
		
		System.out.println(driver.getContext());
		
		
		System.out.println("-------------------------");
		System.out.println(driver.getContextHandles());
		
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

	
	public static void main(String[] args) {
		
		try {
			AndroidDriver<AndroidElement> driver = fengzhuang.AndroidQQsetUp();
			System.out.println("开始执行脚本");
			fengzhuang.yinshiWait(driver);
			fengzhuang.getNetworkConnection(driver);
			driver.pressKeyCode(3);
			//fengzhuang.appInstallAndUninstall(driver,"com.yce.deerstewardphone", "D:\\DesktopWas\\luguanjia.apk");
			//elementSwipe(driver);
//			driver.findElement(By.name("设置")).click();
//			fengzhuang.listClick(driver, By.id("android:id/title"), 14, 13);
			Thread.sleep(5000);
			fengzhuang.drag(driver, By.name("鹿管家"), By.name("微信"));
			driver.findElement(By.name("设置")).click();
			fengzhuang.isElementAndClick(driver, By.name("安全"));
			driver.findElement(By.name("屏幕锁定")).click();
			driver.findElement(By.name("图案")).click();
			fengzhuang.shoushisuo(driver, By.id("com.android.settings:id/lockPattern"));
			Thread.sleep(2000);
			
			
			
			System.out.println("脚本执行完成，等待退出");
			driver.quit();
			System.out.println("已退出成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
