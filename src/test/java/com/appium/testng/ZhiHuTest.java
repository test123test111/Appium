package com.appium.testng;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.base.CrazyPath;
import cn.crazy.appium.util.ProUtil;
import cn.crazy.appium.util.SendMail;

public class ZhiHuTest {
	AndroidDriverBase driver;
	static String value = "为什么商务手机";
	public static String returnValue(){
		return value;
	}
	@BeforeClass
	public void beforeClass(){
		ProUtil proUtil = new ProUtil(CrazyPath.globalPath);
		String server = proUtil.getPro("server");
		String port = "4723";
		String capsPath = CrazyPath.capsPath;
		String udid = "a64c4287d540";
		String input = "com.baidu.input_mi/.ImeService";
		try {
			this.driver = new AndroidDriverBase(server, port, capsPath, udid, input);
			driver.implicitlyWaitDefault();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			SendMail.send("driver启动失败", e.getMessage());
		}
	}
	@Test
	public void t001_login(){
		ZhiHuLogin zhiHuLogin = new ZhiHuLogin(driver);
		zhiHuLogin.LoginTest("437765664@qq.com", "62218852000duan");
		Home home = new Home(driver);
		try {
			Assert.assertEquals(home.getSearch()!=null, true);
		} catch (Exception e) {
			// TODO: handle exception
			try {
				driver.takeScreen("images/", "loginError");
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void t002_search(){
		Home home = new Home(driver);
		try {
			Assert.assertEquals(home.search(value)==true, true);
		} catch (Exception e) {
			// TODO: handle exception
			try {
				driver.takeScreen("images/", "seachError");
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			Assert.fail(e.getMessage());
		}
		home.getTitles().get(0).click();
	}
	@Test
	public void t003_attention(){
		Article article = new Article(driver);
		try {
			Assert.assertEquals(article.thank()==true, true);
		} catch (Exception e) {
			// TODO: handle exception
			try {
				driver.takeScreen("images/", "attentionError");
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			Assert.fail(e.getMessage());
		}
	}
	@AfterClass
	public void afterClass(){
		driver.quit();
	}
}
