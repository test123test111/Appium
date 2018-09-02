package cn.crazy.appium.testcases;

import java.util.Set;

import org.openqa.selenium.By;

import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DeerHunhe {
	
	public static void hunheTest(AndroidDriver<AndroidElement> driver){
		Set<String> handles = driver.getContextHandles();
		for(String ae:handles){
			System.out.println(ae);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		AndroidDriver<AndroidElement> driver = fengzhuang.AndroidsetUp();
		System.out.println("脚本开始执行");
		Deerlogin.Login(driver);
		fengzhuang.ClickMenu(driver, 2);
		Thread.sleep(10000);
		hunheTest(driver);
		driver.findElement(By.name("糖尿病")).click();
		Thread.sleep(5000);
		
		
		
		
		
		System.out.println("脚本执行结束");
		driver.quit();
		
	}

}
