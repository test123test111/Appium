package cn.crazy.appium.testngtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.crazy.appium.Zhihu.zhihuLogin;
import com.crazy.appium.Zhihu.zhihuLogout;
import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ZhihuTests {
	
	AndroidDriver<AndroidElement> driver;
	
	
	@Parameters({"udid","port"})
	@BeforeClass
	public void beforeclass(String udid,String port) {
		try {
			driver = fengzhuang.MoreDevicessetBy(udid, port);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void t1_login() {
		
		
		try {
			fengzhuang.yinshiWait(driver);
			zhihuLogin.login(driver);
			Assert.assertEquals(fengzhuang.isElementExist(driver, By.id("com.zhihu.android:id/search_box")), true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void t2_logout() {
		try {
			fengzhuang.yinshiWait(driver);
			zhihuLogout.logout(driver);
			Assert.assertEquals(driver.getPageSource().contains("登录"), true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	@AfterClass
	public void afterclass() {
		driver.quit();
	}
	
	

}
