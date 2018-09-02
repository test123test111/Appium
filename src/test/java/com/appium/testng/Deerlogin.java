package com.appium.testng;


import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Deerlogin {

	
	public static void Login(AndroidDriver<AndroidElement> driver,String username) throws Exception{
		Thread.sleep(5000);
		if(driver.getPageSource().contains("商城")){
			System.out.println("账号已经登录，无需再次登录");
			Thread.sleep(2000);
		}else {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.yce.deerstewardphone:id/btn_tozhmilogin\"]")).click();
			driver.findElement(By.id("com.yce.deerstewardphone:id/edt_login_user")).sendKeys(username);
			driver.findElement(By.id("com.yce.deerstewardphone:id/edt_login_code")).sendKeys("123456");
			driver.findElement(By.id("com.yce.deerstewardphone:id/btn_submit")).click();
			System.out.println("账号登录成功");
			Thread.sleep(2000);
		}


	}
	
	public static void ClickMenu(AndroidDriver<AndroidElement> driver,int order){
		driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout["+order+"]/android.widget.Button[1]")).click();
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("开始执行脚本");
		AndroidDriver<AndroidElement> driver=fengzhuang.AndroidsetUp();
		Deerlogin deerlogin=new Deerlogin();
//		//隐式等待
		fengzhuang.yinshiWait(driver, 10);
		Login(driver, "17688930446");
//		driver.pressKeyCode(3);
//		Thread.sleep(3000);
//		driver.pressKeyCode(3);
		
		
		//拖拽和手势密码
//		fengzhuang.drag(driver, By.name("今日头条"), By.name("设置"));
//		driver.findElement(By.name("设置")).click();
//		fengzhuang.isElementAndClick(driver,By.name("锁屏和密码"));
//		driver.findElement(By.name("锁屏密码")).click();
//		driver.findElement(By.name("图案")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("android:id/button1")).click();
//		Thread.sleep(1000);
//		fengzhuang.shoushiLock(driver,By.xpath("//android.view.View[@resource-id='com.android.settings:id/lockPattern']"));
//		Thread.sleep(2000);
//		fengzhuang.shoushiLock(driver,By.xpath("//android.view.View[@resource-id='com.android.settings:id/lockPattern']"));
//		driver.findElement(By.name("确认")).click();
		
		
		System.out.println("脚本执行完成");
		driver.quit();
	}
}
