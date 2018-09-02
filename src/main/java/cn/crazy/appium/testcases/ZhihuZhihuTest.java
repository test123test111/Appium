package cn.crazy.appium.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.base.CrazyPath;
import cn.crazy.appium.page.ZhihuArticle;
import cn.crazy.appium.page.ZhihuHome;
import cn.crazy.appium.page.Zhihulogin;
import cn.crazy.appium.testng.Assertion;
import cn.crazy.appium.util.ProUtil;
import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class ZhihuZhihuTest {
	AndroidDriverBase driver;
	Assertion myassert;
	
	
	
	
	@Parameters({"udid","port"})
	@BeforeClass
	public void beforeclass(String udid,String port) {
		ProUtil proUtil = new ProUtil(CrazyPath.globalPath);
		String server = proUtil.getPro("server");
//		String server = "http://127.0.0.1";
//		String port = "4723";
		String capsPath = CrazyPath.capsPath;
//		String udid = "a64c4287d540";
		String input= "com.baidu.input_mi/.ImeService";
		
		try {
			driver = new AndroidDriverBase(server, port, capsPath, udid, input);
			myassert = new Assertion(driver);
			
			
			driver.implicitlyWaitDefault();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fengzhuang.send("driver启动失败", e.getMessage());
			
		}
		
	}
	
	@Test
	public void t001_login() throws Exception {
		Zhihulogin zhihulogin = new Zhihulogin(driver);
		zhihulogin.loginTest("437765664@qq.com", "74543804duan");
		Thread.sleep(5000);
//		Assert.assertEquals(driver.getPageSouce().contains("搜索话题、问题或人"), true);
//		myassert.assertEquals(actual, expected, fileName);
		myassert.assertEquals(driver.getPageSouce().contains("搜索话题、问题或人"), true, "loginError");
	}
	
	@Test
	public void t002_search() {
		ZhihuHome zhihuHome  = new ZhihuHome(driver);
//		Assert.assertEquals(zhihuHome.zhihuSearchTest("郭德纲"), true);
		myassert.assertEquals(zhihuHome.zhihuSearchTest("郭德纲"), true,"SearchError");
		
	}
	
	
	@Test
	public void t003_guanzhu() throws Exception {
		ZhihuArticle zhihuArticle = new ZhihuArticle(driver);
		Thread.sleep(5000);
//		Assert.assertEquals(zhihuArticle.attention(), true);
		myassert.assertEquals(zhihuArticle.attention(), true,"guanzhuError");
		
	}
	
	
	@AfterMethod
	public void restartapp() {
		String appPackage = (String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE);
		String appActivity = (String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_ACTIVITY);
		
		driver.startActivity(appPackage, appActivity);
	}

	@AfterClass
	public void afterclass() {
		driver.resetApp();
		driver.quit();
	}
}
