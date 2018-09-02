package cn.crazy.appium.testcases;

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
import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidElement;


public class ZhihuPicture {
	
	
	AndroidDriverBase driver;
	
	
	
	@BeforeClass
	public void beforeclass() {
//		driver = fengzhuang.AndroidZhihusetUp();
		String server = "http://127.0.0.1";
		String port = "4490";
		String capsPath = CrazyPath.capsPath;
		String udid = "a64c4287d540";
		String input = "com.baidu.input_mi/.ImeService";
		try {
			driver = new AndroidDriverBase(server, port, capsPath, udid, input);
			driver.implicitlyWaitDefault();
		} catch (Exception e) {
			// TODO: handle exception
			fengzhuang.send("driver启动失败", e.getMessage());
			Assert.fail();
			System.out.println(e.getMessage());
		}

	}
	
	@Test
	public void t1_picture() throws Exception {
		driver.findElement(GetByLocator.getLocator("tab5")).click();
		driver.findElement(GetByLocator.getLocator("persioninfo")).click();
		driver.findElement(GetByLocator.getLocator("edit")).click();
		
		driver.findElement(By.id("com.zhihu.android:id/btn_revise_header")).click();
		driver.findElement(By.name("相册")).click();
		if(driver.findElement(By.name("最近"))!=null) {
			driver.findElement(By.name("最近")).click();
		}
		List<AndroidElement> androidElements  = driver.findElements(By.id("com.android.documentsui:id/icon_thumb"));
		
		System.out.println("总共有"+androidElements.size()+"张图片");
		for(int i = 0;i<androidElements.size();i++) {
			androidElements.get(i).click();
			driver.wait(3000);
			AndroidElement yes = driver.findElement(By.name("知道了"));
			if(yes!=null) {
				yes.click();
			}
			if(i!=androidElements.size()-1) {
				driver.takeScreenForElement(By.id("com.zhihu.android:id/header"), "images/", String.valueOf(i));
				driver.findElement(By.id("com.zhihu.android:id/btn_revise_header")).click();
				driver.findElement(By.name("相册")).click();
			}

		}
		
		
		driver.takeScreenForElement(By.id("com.zhihu.android:id/header"), "images/", "current");
		int current = 0;
		for(int i = 0;i<6;i++) {
			if(ImageUtil.compareImg("images/"+1+".png", "images/current.png", 100f)) {
				current = i;
				break;
			}
			
		}
		driver.findElement(By.id("com.zhihu.android:id/btn_revise_header")).click();
		driver.findElement(By.name("相册")).click();
		if(driver.findElement(By.name("最近"))!=null) {
			driver.findElement(By.name("最近")).click();
		}
//		List<AndroidElement> androidElements  = driver.findElements(By.id("com.android.documentsui:id/icon_thumb"));
		int index = fengzhuang.getRandomInt(0, androidElements.size());
		while(index ==current) {
			index = fengzhuang.getRandomInt(0, androidElements.size());		
		}
		androidElements.get(index).click();
		AndroidElement yes1 = driver.findElement(By.name("知道了"));
		if(yes1!=null) {
			yes1.click();
		}
		
		driver.takeScreenForElement(By.id("com.zhihu.android:id/header"), "images/", "result");
		try {
			Assert.assertEquals(fengzhuang.compareImg("images/"+index+".png","images/result.png", 100f),true);
		} catch (Exception e) {
			// TODO: handle exception
			driver.takeScreen("images", "uploderror");
			Assert.fail(e.getMessage()+"上传的第"+index+"张");
		}
	
	}
	
	@AfterClass
	public void afterclass() {
		driver.quit();
	}

}
