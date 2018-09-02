package com.appium.testng;


import java.util.List;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.base.CrazyPath;
import cn.crazy.appium.util.GetByLocator;
import cn.crazy.appium.util.ImageUtil;
import cn.crazy.appium.util.RandomUtil;
import cn.crazy.appium.util.SendMail;
import io.appium.java_client.android.AndroidElement;

public class UploadPhoto {
	AndroidDriverBase driver;
	@BeforeClass
	public void beforeClass(){
		String server ="http://127.0.0.1";
		String port = "4723";
		String capsPath = CrazyPath.capsPath;
		String udid = "a64c4287d540";
		String input = "com.baidu.input_mi/.ImeService";
		try {
			this.driver = new AndroidDriverBase(server, port, capsPath, udid, input);
			fengzhuang.yinshiWait(this.driver,5000);
			driver.implicitlyWaitDefault();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			SendMail.send("driver启动失败", e.getMessage());
		}
	}
	@Test
	public void t1_uploadPhoto() throws Exception{
		driver.findElement(GetByLocator.getLocator("tab5")).click();
		driver.findElement(GetByLocator.getLocator("persioninfo")).click();
		driver.findElement(GetByLocator.getLocator("edit")).click();
		driver.takeScreenForElement(GetByLocator.getLocator("header"),"images/", "current");
		driver.findElement(GetByLocator.getLocator("editPhoto")).click();
		driver.findElement(GetByLocator.getLocator("photo")).click();
		driver.wait(2000);
		List<AndroidElement> photos = driver.findElements(By.id("com.miui.gallery:id/micro_thumb"));
		for(int i = 0;i<photos.size();i++){
			photos.get(i).click();
			driver.wait(5000);
			driver.takeScreenForElement(GetByLocator.getLocator("header"), "images/", String.valueOf(i));
			driver.findElement(GetByLocator.getLocator("editPhoto")).click();
			driver.findElement(GetByLocator.getLocator("photo")).click();
			
		}
		int current = 0;
		for(int i = 0;i<5;i++){
			if(ImageUtil.compareImg("images/"+i+".png", "images/current.png", 100f)){
				current = i;
				System.out.println("我选择的图片是第"+current+"张");
				break;
			}
		}
		int index = RandomUtil.randomInt(0, photos.size()+1);
		while(index==current){
			index = RandomUtil.randomInt(0, photos.size()+1);
		}
		photos.get(index).click();
		driver.wait(5000);
		driver.takeScreenForElement(GetByLocator.getLocator("header"), "images/", "result");
		try {
			Assert.assertEquals(ImageUtil.compareImg("images/"+index+".png", "images/result.png", 100f), true);
		} catch (Error e) {
			// TODO: handle exception
			driver.takeScreen("images/", "uploadPhotoError");
			Assert.fail(e.getMessage()+"上传的是第"+index+"张");
			System.out.println(e.getMessage());
		}
		
		
	}
	@AfterClass
	public void afterClass(){
		driver.quit();
	}

}
