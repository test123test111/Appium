package com.appium.testng;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.page.BasePage;
import cn.crazy.appium.util.GetByLocator;
import io.appium.java_client.android.AndroidElement;

public class ZhiHuLogin extends BasePage{
	public ZhiHuLogin(AndroidDriverBase driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}
	private AndroidElement logins;
	private AndroidElement username;
	private AndroidElement password;
	private AndroidElement login;
	
	public AndroidElement getLogins() {
		return driver.findElement(GetByLocator.getLocator("loginOrReg"));
	}
	public void setLogins(AndroidElement logins) {
		this.logins = logins;
	}
	public AndroidElement getUsername() {
		return super.driver.findElement(GetByLocator.getLocator("username"));
	}
	public void setUsername(AndroidElement username) {
		this.username = username;
	}
	public AndroidElement getPassword() {
		return super.driver.findElement(GetByLocator.getLocator("password"));
	}
	public void setPassword(AndroidElement password) {
		this.password = password;
	}
	public AndroidElement getLogin() {
		return driver.findElement(GetByLocator.getLocator("loginSubmit"));
	}
	public void setLogin(AndroidElement login) {
		this.login = login;
	}
	
	
	
	public void LoginTest(String username,String password){
		click(getLogins());
		sendkeys(getUsername(), username);
		sendkeys(getPassword(), password);
		click(getLogin());
//		return new Home(driver);
	}
}
