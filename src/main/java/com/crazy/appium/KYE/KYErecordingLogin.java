package com.crazy.appium.KYE;

import cn.crazy.appium.util.fengzhuang;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class KYErecordingLogin {
	
	
	public void login(AndroidDriver<AndroidElement> driver) {
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("跨越速运");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.oxbix.spanlogistics:id/llContainer");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.oxbix.spanlogistics:id/llContainer");
		el4.click();
		MobileElement el5 = (MobileElement) driver.findElementById("com.oxbix.spanlogistics:id/llContainer");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("com.oxbix.spanlogistics:id/llContainer");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View[2]");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[5]");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]");
		el9.click();
		MobileElement el10 = (MobileElement) driver.findElementById("com.oxbix.spanlogistics:id/edit_text_login_phone");
		el10.sendKeys("18025478840");
		MobileElement el11 = (MobileElement) driver.findElementById("com.oxbix.spanlogistics:id/button_login_get_verification_code");
		el11.click();
		MobileElement el12 = (MobileElement) driver.findElementById("com.oxbix.spanlogistics:id/edit_text_login_verification_code");
		el12.sendKeys("230525");
		MobileElement el13 = (MobileElement) driver.findElementById("com.oxbix.spanlogistics:id/button_login_login");
		el13.click();
		MobileElement el14 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.ImageView");
		el14.click();
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		AndroidDriver<AndroidElement> driver = fengzhuang.AndroidKYEsetUp();
		KYErecordingLogin kyErecordingLogin = new KYErecordingLogin();
		kyErecordingLogin.login(driver);
		
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}
	
	


}
