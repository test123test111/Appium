package com.appium.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.crazy.appium.util.GetByLocator;
import cn.crazy.appium.util.RandomUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ZhihuPersonInfo {
	AndroidDriver<AndroidElement> driver;
	@BeforeClass
	public void beforeClass(){
		this.driver = fengzhuang.AndroidsetUpByZhihu();
	}
	@Test
	public void t1_personInfo(){
		fengzhuang.yinshiWait(driver,10);
		driver.findElement(GetByLocator.getLocator("tab5")).click();
		driver.findElement(GetByLocator.getLocator("persioninfo")).click();
		driver.findElement(GetByLocator.getLocator("edit")).click();
		//姓名
		driver.findElement(By.id("com.zhihu.android:id/username")).click();
		driver.findElement(By.name("知道了")).click();
		AndroidElement username = driver.findElement(By.id("com.zhihu.android:id/username"));
		String oldUsername = username.getText();
		String newUsername = RandomUtil.getRndStrZhByLen(10);
		while(oldUsername.equals(newUsername)){
			newUsername = RandomUtil.getRndStrZhByLen(10);
		}
		username.sendKeys(newUsername);
		
		//个人介绍
		AndroidElement description = driver.findElement(GetByLocator.getLocator("description"));
		String olddescriptionValue = driver.findElement(GetByLocator.getLocator("description")).getText();
		String newdescriptionValue = RandomUtil.getRndStrZhByLen(10);
		while(newdescriptionValue.equals(olddescriptionValue)){
			newdescriptionValue = RandomUtil.getRndStrZhByLen(10);
		}
		description.sendKeys(newdescriptionValue);
		//一句话描述
		AndroidElement headline = driver.findElement(GetByLocator.getLocator("headline"));
		String oldheadline = headline.getText();
		String newheadline = RandomUtil.getRndStrZhByLen(10);
		while(newheadline.equals(oldheadline)){
			newheadline = RandomUtil.getRndStrZhByLen(10);
			
		}
		headline.sendKeys(newheadline);
		//居住地
		AndroidElement location = driver.findElement(GetByLocator.getLocator("location"));
		String oldlocation = headline.getText();
		String newlocation = RandomUtil.getRndStrZhByLen(10);
		while(newlocation.equals(oldlocation)){
			newlocation = RandomUtil.getRndStrZhByLen(10);
			
		}
		location.sendKeys(newlocation);
		//行业
		AndroidElement profession = driver.findElement(GetByLocator.getLocator("profession"));
		String oldprofession = driver.findElement(GetByLocator.getLocator("professionvalue")).getText();
		profession.click();
		List<AndroidElement> listview = driver.findElements(GetByLocator.getLocator("listview"));
		int index = RandomUtil.randomInt(0, listview.size());
		while(oldprofession.equals(listview.get(index).getText())){
			index = RandomUtil.randomInt(0, listview.size());
		}
		listview.get(index).click();
		//保存
		driver.findElement(GetByLocator.getLocator("save")).click();
	}
	
	@AfterClass
	public void afterClass(){
		driver.quit();
	}

}
