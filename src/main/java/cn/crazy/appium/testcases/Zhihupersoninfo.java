package cn.crazy.appium.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cn.crazy.appium.util.GetByLocator;
import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Zhihupersoninfo {
	AndroidDriver<AndroidElement> driver;
	
	
	@BeforeClass
	
	public void BeforeClass() throws Exception {
		driver = fengzhuang.AndroidZhihusetUp();
	}
	
	
	
	@Test
	public void t1_personinfo() {
		fengzhuang.yinshiWait(driver);
		driver.findElement(GetByLocator.getLocator("tab5")).click();
		driver.findElement(GetByLocator.getLocator("persioninfo")).click();
		driver.findElement(GetByLocator.getLocator("edit")).click();
		
		
		
		//性别
		String sexOldValue = driver.findElements(By.id("android:id/text1")).get(0).getText();
		if(driver.getPageSource().contains("男")) {
			driver.findElement(GetByLocator.getLocator("gender")).click();
			driver.findElement(GetByLocator.getLocator("female")).click();
			
		}else if (driver.getPageSource().contains("女")) {
			driver.findElement(GetByLocator.getLocator("gender")).click();
			driver.findElement(GetByLocator.getLocator("male")).click();
			
		}
		
		
		
		
		
		//姓名
		String oldname = driver.findElement(By.id("com.zhihu.android:id/username")).getText();
		driver.findElement(By.id("com.zhihu.android:id/username")).sendKeys(fengzhuang.getRandomChineseStringByLength(2));

		
		
		
		//一句话描述
		String oldvalue = driver.findElement(By.id("com.zhihu.android:id/headline")).getText();
		driver.findElement(By.id("com.zhihu.android:id/headline")).sendKeys(fengzhuang.getRandomChineseStringByLength(10));

		
		
		//个人介绍
		String oldjieshao = driver.findElement(By.id("com.zhihu.android:id/description")).getText();
		driver.findElement(By.id("com.zhihu.android:id/description")).sendKeys(fengzhuang.getRandomChineseStringByLength(10));

		
		
		//居住地
		String oldlocation = driver.findElement(By.id("com.zhihu.android:id/location")).getText();
		driver.findElement(By.id("com.zhihu.android:id/location")).sendKeys(fengzhuang.getRandomChineseStringByLength(3));

		
		
		//行业
		String oldhangye = driver.findElements(By.id("android:id/text1")).get(1).getText();
		driver.findElement(By.id("com.zhihu.android:id/profession")).click();
		fengzhuang.elementSwipe(driver, By.className("android.widget.ListView"), "up", 1000);
		List<AndroidElement> list = driver.findElements(GetByLocator.getLocator("item"));
		int index = fengzhuang.getRandomInt(0, list.size());
		while(oldhangye.equals(list.get(index).getText())) {
			index = fengzhuang.getRandomInt(0, list.size());
		}
		list.get(index).click();

		
		
		
		//保存
		driver.findElement(GetByLocator.getLocator("save")).click();
		
		
		
		driver.findElement(GetByLocator.getLocator("edit")).click();
		//断言
		
		try {
			String sexnewvalue = driver.findElements(By.id("android:id/text1")).get(0).getText();
			Assert.assertNotEquals(sexOldValue, sexnewvalue);
			
			String newname = driver.findElement(By.id("com.zhihu.android:id/username")).getText();
			Assert.assertNotEquals(oldname, newname);
			
			String newvalue = driver.findElement(By.id("com.zhihu.android:id/headline")).getText();
			Assert.assertNotEquals(oldvalue, newvalue);
			
			String newjieshao = driver.findElement(By.id("com.zhihu.android:id/description")).getText();
			Assert.assertNotEquals(oldjieshao, newjieshao);
			
			String newlocation = driver.findElement(By.id("com.zhihu.android:id/location")).getText();
			Assert.assertNotEquals(oldlocation, newlocation);
			
			String newhangye = driver.findElements(By.id("android:id/text1")).get(1).getText();
			Assert.assertEquals(oldhangye, newhangye);
		} catch (Exception e) {
			// TODO: handle exception
//			fengzhuang.Screenshot(driver, "personinfo");
			fengzhuang.ScreenShot(driver, "personinfo");
			e.getMessage();
			Assert.fail();
		}

		
	}
	
	
	
	@AfterClass
	public void afterclass() {
		driver.quit();
		
	}
	
	

}
