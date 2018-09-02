package cn.crazy.appium.page;

import cn.crazy.appium.base.AndroidDriverBase;
import cn.crazy.appium.util.GetByLocator;
import io.appium.java_client.android.AndroidElement;

public class Zhihulogin extends BasePage{
	
	public AndroidElement loginBtn;
	public AndroidElement username;
	public AndroidElement password;
	public AndroidElement loginSubmit;
	public AndroidElement sheqiaoLoginBtn;
	public AndroidElement notLoginBtn;
	public AndroidElement notWarn;
	public AndroidElement cancle;
	
	

	public AndroidElement getNotWarn() {
		if(notWarn!=null){
			return super.driver.findElement(GetByLocator.getLocator("notwarn"));
		}
		return notWarn;
	}

	public AndroidElement getCancle() {
		return super.driver.findElement(GetByLocator.getLocator("ingroe"));
	}
	
	public AndroidElement getLoginBtn() {
		return super.driver.findElement(GetByLocator.getLocator("loginOrReg"));
	}

	public AndroidElement getUsername() {
		return super.driver.findElement(GetByLocator.getLocator("username"));
	}


	public AndroidElement getPassword() {
		return super.driver.findElement(GetByLocator.getLocator("password"));
	}
	
	public AndroidElement getLoginSubmit() {
		return super.driver.findElement(GetByLocator.getLocator("loginSubmit"));
	}


	public AndroidElement getSheqiaoLoginBtn() {
		return super.driver.findElement(GetByLocator.getLocator("shejiaoLogin"));
	}

	public AndroidElement getNotLoginBtn() {
		return super.driver.findElement(GetByLocator.getLocator("notLoginBtn"));
	}
	
	
	public Zhihulogin(AndroidDriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ZhihuHome loginTest(String username,String pwd) {
//		click(getNotWarn());
//		click(getCancle());
		click(getLoginBtn());
		sendkeys(getUsername(), username);
		sendkeys(getPassword(), pwd);
		click(getLoginSubmit());
		return new ZhihuHome(driver);
		
	}
	
	
	
	

}
