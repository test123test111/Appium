package com.appium.testng;

import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.crazy.appium.util.GetByLocator;
import io.appium.java_client.android.AndroidDriver;

public class DeerPersoninfo {
	AndroidDriver<AndroidElement> driver;
	
	@BeforeClass
	public void beforeClass() throws Exception{
		this.driver=fengzhuang.AndroidsetUp();
		
		
	}
	@Test
	public void t1_personInfo() throws Exception{
		Deerlogin.Login(driver, "17688930446");
		driver.findElement(GetByLocator.getLocator("deer_tab5")).click();
		driver.findElement(GetByLocator.getLocator("deer_family")).click();
		Thread.sleep(3000);
//		driver.findElement(GetByLocator.getLocator("deer_info_sexMan")).click();
//		System.out.println("printsomething");
//		System.out.println(driver.findElement(By.id("com.yce.deerstewardphone:id/btn_woman")).isSelected());
//		driver.findElement(By.id("com.yce.deerstewardphone:id/btn_woman")).isSelected();
//		
//		Thread.sleep(5000);
//		driver.findElement(GetByLocator.getLocator("deer_info_save")).click();
//		driver.findElement(By.name("是")).click();
//		if(driver.findElement(GetByLocator.getLocator("deer_info_sexMan")).isSelected()){
//			driver.findElement(GetByLocator.getLocator("deer_info_sexWomen")).click();
//			System.out.println("已经选择女性");
//		}else{
//			driver.findElement(GetByLocator.getLocator("deer_info_sexMan")).click();
//			System.out.println("已经选择男性");
//		}
		driver.findElement(GetByLocator.getLocator("deer_family_add")).click();
		if(driver.findElement(GetByLocator.getLocator("deer_family_boy")).isSelected()){
		driver.findElement(GetByLocator.getLocator("deer_family_girl")).click();
		System.out.println("已经选择女性");
			}else{
		driver.findElement(GetByLocator.getLocator("deer_family_boy")).click();
		System.out.println("已经选择男性");
		}
		Thread.sleep(3000);
		
		
		
	}
	@AfterClass
	public void aterClass(){
		driver.quit();
	}
	

}
