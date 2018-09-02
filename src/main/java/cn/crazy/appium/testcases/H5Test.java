package cn.crazy.appium.testcases;

import java.util.Set;

import org.openqa.selenium.By;

import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class H5Test {
	
	
	public void testfan(AndroidDriver<AndroidElement> driver) throws Exception{
//		driver.get("http://www.baidu.com");
//		driver.findElement(By.id("index-kw")).sendKeys("testfan");
//		driver.findElement(By.id("index-bn")).click();
		driver.get("http://ask.testfan.cn");
		Thread.sleep(3000);
//		driver.findElement(By.linkText("如何用appium设置设备的网络状态")).click();
		//partialLinkText是一个在H5上模糊查找的文字方法
//		driver.findElement(By.partialLinkText("appium设置设备的网络状态")).click();
//		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div[1]/div[1]/div[2]/p[1]")).click();
		
		Handle.getHandle(driver);
		driver.findElement(By.cssSelector("body > div.wrap > div.container > div > div.col-xs-12.col-md-9.main > div.widget-box.mb-10 > div > div:nth-child(2) > ul > li:nth-child(1) > a")).click();
		Thread.sleep(3000);
		System.out.println("原窗口的句柄为：  "+Handle.getHandle(driver)+"------->标题为: "+driver.getTitle());
		Handle.zhuanhuanHandle(driver);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("body > div.wrap > div > div > div.col-xs-12.col-md-9.main > div.widget-question.widget-article > ul > li > a")).click();
		
		
	}
	public static void main(String[] args) throws Exception {
		System.out.println("开始测试脚本");
		AndroidDriver<AndroidElement> driver = fengzhuang.androidByH5SetUp();
		H5Test h5Test = new H5Test();
		h5Test.testfan(driver);
		
		
		
		System.out.println("脚本测试完成");
		driver.quit();
	}

}
