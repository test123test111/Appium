package com.crazy.appium.KYE;

import org.openqa.selenium.By;

import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class KYEfengzhuang {
	
	
	
	public static void testSwipe(AndroidDriver<AndroidElement> driver) {
		int x = driver.manage().window().getSize().width;
		int y = driver.manage().window().getSize().height;
		for(int i=0;i<3;i++) {
			
		}
		
	}
	
	
	
	
	public static boolean iselementExist(AndroidDriver<AndroidElement> driver,By by) {
		try {
			driver.findElement(by);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	
	
	/**
	 * 
	* @Title: clikKYEMenu  
	* @Description: TODO(定位底部菜单按钮，order范围1~5)  
	* @param @param driver
	* @param @param order    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void clickKYEMenu(AndroidDriver<AndroidElement> driver,int order) {
		
		if (order>5||order<1) {
			System.out.println("输入的数字无效");
		}else {
			driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='com.oxbix.spanlogistics:id/tabLayout']/android.widget.LinearLayout[1]/android.widget.RelativeLayout["+order+"]")).click();
		}
		
		
		
	}
	
//	public static void main(String[] args) throws Exception {
//		AndroidDriver<AndroidElement> driver = fengzhuang.AndroidKYEsetUp();
//		clickKYEMenu(driver, -1);
//	}

}
