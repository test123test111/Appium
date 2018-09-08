package cn.crazy.appium.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import cn.crazy.appium.base.CrazyPath;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import net.sf.saxon.functions.Data;

public class fengzhuang {
	AndroidDriver<AndroidElement> driver;
	public fengzhuang(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
	}
	
	
	
	
	/**
	 * Android手机的appium关键字设置
	 * @author duanhao
	 * @return
	 * @throws Exception
	 */
	//com.kye.express.business.splash.SplashActivity   跨越速运启动activity
	//com.oxbix.spanlogistics   跨越速运包名
	
	//com.yce.deerstewardphone        鹿管家包名
	//com.yce.deerstewardphone.activity.SplashActivity   鹿管家启动activity
	
    public static  AndroidDriver<AndroidElement> AndroidsetUp() throws Exception {
   	 // set up appium
       File classpathRoot = new File(System.getProperty("user.dir"));
       File appDir = new File(classpathRoot, "/apps");
       File app = new File(appDir,"deersteward_phone.apk");
       DesiredCapabilities caps =new DesiredCapabilities();
       caps.setCapability(MobileCapabilityType.DEVICE_NAME,"a64c4287d540");//a64c4287d540//d8c6d48b7d63
       caps.setCapability("platformVersion","7.1.2");
       caps.setCapability("platformName","android");
       //caps.setCapability("app", app.getAbsolutePath());
       caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.yce.deerstewardphone");
       caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
       //caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
       caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
       caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
       caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
       caps.setCapability(MobileCapabilityType.NO_RESET,true);
       AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
       		new URL("http://127.0.0.1:4723/wd/hub"), caps);
       return driver;
   }
    
    public static  AndroidDriver<AndroidElement> AndroidmaimaisetUp() throws Exception {
      	 // set up appium
          File classpathRoot = new File(System.getProperty("user.dir"));
          File appDir = new File(classpathRoot, "/apks");
          File app = new File(appDir,"maimai.apk");
          DesiredCapabilities caps =new DesiredCapabilities();
          caps.setCapability(MobileCapabilityType.DEVICE_NAME,"127.0.0.1:62001");//a64c4287d540//d8c6d48b7d63
          caps.setCapability("platformVersion","4.4.2");
          caps.setCapability("platformName","android");
          //caps.setCapability("app", app.getAbsolutePath());
          caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.taou.maimai");
          caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.taou.maimai.SplashActivity");
          //caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
          caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
          caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
          caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
          caps.setCapability(MobileCapabilityType.NO_RESET,true);
          AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
          		new URL("http://127.0.0.1:4723/wd/hub"), caps);
          return driver;
      }
    
    
    public static  AndroidDriver<AndroidElement> AndroidKYEsetUp() throws Exception {
      	 // set up appium
          File classpathRoot = new File(System.getProperty("user.dir"));
          File appDir = new File(classpathRoot, "/apps");
          File app = new File(appDir,"KYE.apk");
          DesiredCapabilities caps =new DesiredCapabilities();
          caps.setCapability(MobileCapabilityType.DEVICE_NAME,"127.0.0.1:62001");//a64c4287d540//d8c6d48b7d63
          caps.setCapability("platformVersion","");
          caps.setCapability("platformName","android");
          //caps.setCapability("app", app.getAbsolutePath());
          caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.oxbix.spanlogistics");
          caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.kye.express.business.splash.SplashActivity");
          //caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
          caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
          caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
          caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
          caps.setCapability(MobileCapabilityType.NO_RESET,true);
          AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
          		new URL("http://127.0.0.1:4723/wd/hub"), caps);
          return driver;
      }
    
    public static  AndroidDriver<AndroidElement> AndroidZhihusetUp(){
     	 // set up appium
         File classpathRoot = new File(System.getProperty("user.dir"));
         File appDir = new File(classpathRoot, "/apps");
         File app = new File(appDir,"zhihu.apk");
         DesiredCapabilities caps =new DesiredCapabilities();
         caps.setCapability(MobileCapabilityType.DEVICE_NAME,"a64c4287d540");//a64c4287d540//d8c6d48b7d63
         caps.setCapability("platformVersion","7.1.2");
         caps.setCapability("platformName","Android");
         //caps.setCapability("app", app.getAbsolutePath());
         caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zhihu.android");
         caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zhihu.android.app.ui.activity.MainActivity");
         //caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
         caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
         caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
         caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
         caps.setCapability(MobileCapabilityType.NO_RESET,true);
         AndroidDriver<AndroidElement> driver;
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	         return driver;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			fengzhuang.send("driver创建失败", e.getMessage());
			return null;
		}

     }
    
    
    public static  AndroidDriver<AndroidElement> AndroidQQsetUp() throws Exception {
    	 // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apps");
        File app = new File(appDir,"qq.apk");
        DesiredCapabilities caps =new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"127.0.0.1:62001");//a64c4287d540//d8c6d48b7d63
        caps.setCapability("platformVersion","4.4.2");
        caps.setCapability("platformName","Android");
        //caps.setCapability("app", app.getAbsolutePath());
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.tencent.mobileqq");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.tencent.mobileqq.activity.SplashActivity");
        //caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
        caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
        caps.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
        		new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }
    
    
    
    public static  AndroidDriver<AndroidElement> MoreDevicessetBy(String udid,String port) throws Exception {
   	 // set up appium
       File classpathRoot = new File(System.getProperty("user.dir"));
       File appDir = new File(classpathRoot, "/apps");
       File app = new File(appDir,"meituan.apk");
       DesiredCapabilities caps =new DesiredCapabilities();
       caps.setCapability(MobileCapabilityType.DEVICE_NAME,udid);//a64c4287d540//d8c6d48b7d63
       caps.setCapability("platformVersion","4.4.2");
       caps.setCapability("platformName","Android");
       //caps.setCapability("app", app.getAbsolutePath());
       caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zhihu.android");
       caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zhihu.android.app.ui.activity.MainActivity");
       //caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
       caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
       caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
       caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
       caps.setCapability(MobileCapabilityType.NO_RESET,true);
       AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
       		new URL("http://127.0.0.1:"+port+"/wd/hub"), caps);
       return driver;
   }
    
    
    public static  AndroidDriver<AndroidElement> AndroidmeituansetUp() throws Exception {
    	 // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apps");
        File app = new File(appDir,"meituan.apk");
        DesiredCapabilities caps =new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"a64c4287d540");//a64c4287d540//d8c6d48b7d63
        caps.setCapability("platformVersion","7.1.2");
        caps.setCapability("platformName","Android");
        //caps.setCapability("app", app.getAbsolutePath());
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.sankuai.meituan");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.meituan.android.pt.homepage.activity.Welcome");
        //caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.yce.deerstewardphone.activity.SplashActivity");
        caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
        caps.setCapability(MobileCapabilityType.NO_RESET,true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
        		new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }
    
    public static  AndroidDriver<AndroidElement> AndroidByParameter(String udid,String appPackage,String appActivity) throws Exception {
      	 // set up appium
          File classpathRoot = new File(System.getProperty("user.dir"));
          File appDir = new File(classpathRoot, "/apps");
          File app = new File(appDir,"deersteward_phone.apk");
          DesiredCapabilities caps =new DesiredCapabilities();
          caps.setCapability(MobileCapabilityType.UDID,udid);//a64c4287d540//d8c6d48b7d63
          caps.setCapability("platformVersion","7.1.2");
          caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
          caps.setCapability("platformName","android");
          //caps.setCapability("app", app.getAbsolutePath());
          caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
          caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
          caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
          caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
          caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
          caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
          AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
          		new URL("http://127.0.0.1:4723/wd/hub"), caps);
          return driver;
      }
    
    
    /**
     * H5的启动driver
     * @return
     * @throws Exception
     */
    public static AndroidDriver<AndroidElement> androidByH5SetUp() throws Exception{
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
		caps.setCapability(MobileCapabilityType.UDID, "a64c4287d540");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;
	}
    
	public static IOSDriver initIosDriverByH5() throws IOException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.3");
		capabilities.setCapability("deviceName", "iPhone 6");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		//capabilities.setCapability("app", "/Users/lixionggang/Library/Developer/Xcode/DerivedData/Book-brixbgarbyxyeybewnllyzizwpln/Build/Products/Debug-iphonesimulator/Book.app");
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
		capabilities.setCapability(IOSMobileCapabilityType.SEND_KEY_STRATEGY,"grouped");
		//capabilities.setCapability(MobileCapabilityType.UDID, "be4be033372e9c7f4bc558a0a6fc4c1b41e8e2f2");
		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://192.168.216.128:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public static IOSDriver initIosDriverByWebview() throws IOException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.3.2");
		capabilities.setCapability("deviceName", "iPhone 5s");
		capabilities.setCapability("app", "/Users/lixionggang/Library/Developer/Xcode/DerivedData/Book-brixbgarbyxyeybewnllyzizwpln/Build/Products/Debug-iphonesimulator/Book.app");
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
		capabilities.setCapability(IOSMobileCapabilityType.SEND_KEY_STRATEGY,"grouped");
		capabilities.setCapability(MobileCapabilityType.UDID, "be4be033372e9c7f4bc558a0a6fc4c1b41e8e2f2");
		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://192.168.216.128:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public static IOSDriver initIosDriver() throws IOException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.3");
		capabilities.setCapability("deviceName", "iPhone 5s");
		capabilities.setCapability("app", "/Users/lixionggang/Library/Developer/Xcode/DerivedData/SmallDay-apeemwhoeruhdlavdjskumgyeldy/Build/Products/Debug-iphonesimulator/SmallDay.app");
		capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
		capabilities.setCapability(IOSMobileCapabilityType.SEND_KEY_STRATEGY,"grouped");
		IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(new URL("http://192.168.216.128:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	/**
	 * deiveceName:moniqi
	 * app:C:/Users/LXG/Desktop/zhihu.apk
	 */
	public static AndroidDriver<AndroidElement>  initDriver1(String udid,String port) throws Exception {
		File app=new File("C:/Users/LXG/Desktop/zhihu.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		//deviceName是必须项，但是值可以随便写
		caps.setCapability("deviceName", "moniqi");
		//要安装的app路径，路径必须是服务端所在的电脑上存放的apk文件路径
		caps.setCapability("app", app.getAbsolutePath());
		//如果你的安卓是4.2以下，需要使用automationName指定Selendroid
		//caps.setCapability("automationName", "Selendroid");
		//使用appium的输入法，支持中文并隐藏键盘
		caps.setCapability("unicodeKeyboard", true);
		//将输入法重置回设备默认的输入法
		caps.setCapability("resetKeyboard", true);
		//不重签名app
		caps.setCapability("noSign", true);
		//设置driver超时时间，单位s
		caps.setCapability("newCommandTimeout", 600);
		//appPackage表示要启动的应用的包名
//		caps.setCapability("appPackage", "com.zhihu.android");
//		//appActivity表示要启动的应用的起始activity
//		caps.setCapability("appActivity", "com.zhihu.android.app.ui.activity.MainActivity");
//		//appWaitActivity,这个参数的值写的是app启动后真正的界面activity
		caps.setCapability("appWaitActivity", "com.zhihu.android.app.ui.activity.MainActivity1");
		//deviceReadyTimeout修改appium判断设备正常响应的超时时间，默认是5秒
		caps.setCapability("deviceReadyTimeout",30);
		//browserName手机web自动化的浏览器的名字
		//caps.setCapability("browserName", "Chrome");
		//udid表示指定连接某台设备
		caps.setCapability("udid", "127.0.0.1:62001");
		//caps.setCapability("noReset", false);
		caps.setCapability("fullReset", true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		return driver;
	}
	
	public static AndroidDriver<AndroidElement> initDriver1() throws Exception{
		File app=new File("C:/Users/LXG/Desktop/zhihu.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		caps.setCapability(MobileCapabilityType.UDID, "127.0.0.1:62001");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		//caps.setCapability(MobileCapabilityType.FULL_RESET, true);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zhihu.android");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zhihu.android.app.ui.activity.MainActivity");
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		return driver;
		
	}
	public static AndroidDriver<AndroidElement> initDriverBySelendroid() throws Exception{
		File app=new File("C:/Users/LXG/Desktop/zhihu.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//这个参数表示要选择的测试引擎
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Selendroid");
		caps.setCapability(MobileCapabilityType.UDID, "127.0.0.1:62001");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		//caps.setCapability(MobileCapabilityType.FULL_RESET, true);
//		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zhihu.android");
//		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zhihu.android.app.ui.activity.MainActivity");
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		//caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;
	}
	public static AndroidDriver<AndroidElement> initDriverByH5() throws Exception{
		//File app=new File("C:/Users/LXG/Desktop/zhihu.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
		//caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//这个参数表示要选择的测试引擎
		//caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Selendroid");
		caps.setCapability(MobileCapabilityType.UDID, "d8c6d48b7d63");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		//caps.setCapability(MobileCapabilityType.FULL_RESET, true);
//		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zhihu.android");
//		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.zhihu.android.app.ui.activity.MainActivity");
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		//caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;
	}
	
	public static AndroidDriver<AndroidElement> initDriverAlreadyInstall(String appPackage,String appActivity) throws Exception{
		//File app=new File("C:/Users/LXG/Desktop/zhihu.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxx");
		//caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//这个参数表示要选择的测试引擎
		//caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Selendroid");
		caps.setCapability(MobileCapabilityType.UDID, "d8c6d48b7d63");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);
		//caps.setCapability(MobileCapabilityType.FULL_RESET, true);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,appPackage);
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appActivity);
		caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);
		caps.setCapability("noReset", true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), caps);
		return driver;
	}
	
	public static AndroidDriver<AndroidElement>  initDriver(String udid,String port) throws Exception {
		
		File app=new File("C:/Users/dhqinli/Desktop/meituan.apk");
		DesiredCapabilities caps=new DesiredCapabilities();
		//deviceName是必须项，但是值可以随便写
		caps.setCapability("deviceName", "Android");
		//要安装的app路径，路径必须是服务端所在的电脑上存放的apk文件路径
		caps.setCapability("app", app.getAbsolutePath());
		//如果你的安卓是4.2以下，需要使用automationName指定Selendroid
		//caps.setCapability("automationName", "Selendroid");
		//使用appium的输入法，支持中文并隐藏键盘
		caps.setCapability("unicodeKeyboard", true);
		//将输入法重置回设备默认的输入法
		caps.setCapability("resetKeyboard", true);
		//不重签名app
		caps.setCapability("noSign", true);
		//设置driver超时时间，单位s
		caps.setCapability("newCommandTimeout", 600);
		//appPackage表示要启动的应用的包名
		caps.setCapability("appPackage", "com.sankuai.meituan");
		//appActivity表示要启动的应用的起始activity
		caps.setCapability("appActivity", "com.sankuai.meituan.activity.Welcome");
//		//appWaitActivity,这个参数的值写的是app启动后真正的界面activity
	//	caps.setCapability("appWaitActivity", "com.zhihu.android.app.ui.activity.MainActivity1");
		//deviceReadyTimeout修改appium判断设备正常响应的超时时间，默认是5秒
		caps.setCapability("deviceReadyTimeout",30);
		//browserName手机web自动化的浏览器的名字
		//caps.setCapability("browserName", "Chrome");
		//udid表示指定连接某台设备
		caps.setCapability("udid",udid);
		caps.setCapability("noReset",true);
	//	caps.setCapability("fullReset", true);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:"+port+"/wd/hub"), caps);
		return driver;
	}
	
	/**
	 * 点击底部菜单按钮
	 */
    public static void clickMenu(AndroidDriver<AndroidElement>driver,int order){
		//android.widget.HorizontalScrollView/android.widget.LinearLayout/*[5]
		if(order>0&&order<6){
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.View/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.a.c["+order+"]").click();
			
		}else{
			System.out.println("没有这个菜单");
		}
		
	}
    
    

    
    
    //获取元素上的属性attribute
    public static void ElementAttribute(AndroidDriver<AndroidElement> driver) throws Exception{
    	Thread.sleep(2000);
    	driver.findElementByXPath("//android.widget.ImageView[@resource-id=\"com.sankuai.meituan:id/settings\"]").click();
    	Thread.sleep(1000);
    	driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.sankuai.meituan:id/settings_common_settings_label\"]").click();
    	Thread.sleep(1000);
    	AndroidElement Close=driver.findElementByXPath("//android.widget.ToggleButton[@resource-id=\"com.sankuai.meituan:id/settings_no_picture_mode_toggle\"]");
    	Close.click();
    	Thread.sleep(1000);
    	String status=Close.getAttribute("checked");
//    	String text=Close.getAttribute("text");
//    	String id=Close.getAttribute("resourceId");
//    	String className=Close.getAttribute("className");
//    	String content_desc=Close.getAttribute("content-desc");
//    	String clickable=Close.getAttribute("clickable");
//    	//对复选框进行勾选
//    	String checked=Close.getAttribute("checked");
//    	String checkable=Close.getAttribute("checkable");
//    	String long_clickable=Close.getAttribute("longClickable");
//    	//name参数优先获取cantent-desc属性的值，如果这个值为空字符串，那么会获取text属性的值
//    	String name=Close.getAttribute("name");
    	if (status.equals("false")) {
			System.out.println("省流量开关关闭成功");
		}else {
			System.out.println("省流量开关开启成功");
		}
    }
	//向左滑动
	public static void swipeToLeft(AndroidDriver<AndroidElement>driver,int duration) throws Exception{
		int x=driver.manage().window().getSize().getWidth();
		int y=driver.manage().window().getSize().getHeight();
		driver.swipe(4*x/5, 1*y/2, 1*x/5, 1*y/2, duration);
		Thread.sleep(500);
	}
	//向右滑动
	public static void swipeToRight(AndroidDriver<AndroidElement>driver,int duration) throws Exception{
		int x=driver.manage().window().getSize().getWidth();
		int y=driver.manage().window().getSize().getHeight();
		driver.swipe(x/5, y/2, 4*x/5, y/2, duration);
		Thread.sleep(500);
	}
	//向上滑动
	public static void swipeToUp(AndroidDriver<AndroidElement>driver,int duration) throws Exception{
		int x=driver.manage().window().getSize().getWidth();
		int y=driver.manage().window().getSize().getHeight();
		driver.swipe(x/2, 3*y/4, x/2, y/4, duration);
		Thread.sleep(500);
	}
	//向下滑动
	public static void swipeToDown(AndroidDriver<AndroidElement>driver,int duration) throws Exception{
		int x=driver.manage().window().getSize().getWidth();
		int y=driver.manage().window().getSize().getHeight();
		driver.swipe(x/2,y/4,x/2,3*y/4,duration);
		Thread.sleep(500);
	}
	/**
	 * 
	* @Title: swipeElement  
	* @Description: TODO(整个页面滑动的封装)  
	* @param @param driver
	* @param @param direction
	* @param @param duration    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void swipe(AndroidDriver<AndroidElement>driver,String direction,int duration){
		
		
		try {
			switch (direction.toLowerCase()) {
			case "up":
				swipeToUp(driver, duration);
				break;
			case "down":
				swipeToDown(driver, duration);
				break;
			case "left":
				swipeToLeft(driver, duration);
				break;
			case "right":
				swipeToRight(driver, duration);
				break;
			default:
				System.out.println("方向参数不准确");
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
	}
	
	
	/**
	 * 
	* @Title: elementSwipe  
	* @Description: TODO(元素内滑动的封装)  
	* @param @param driver
	* @param @param by   by对象
	* @param @param direction   方向参数
	* @param @param duration    持续时间参数 
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void elementSwipe(AndroidDriver<AndroidElement>driver,By by,String direction,int duration){
		
		
		try {
			switch (direction.toLowerCase()) {
			case "up":
				elementSwipeUP(driver, by, duration);
				break;
			case "down":
				elementSwipeDOWN(driver, by, duration);
				break;
			case "left":
				elementSwipeLEFT(driver, by, duration);
				break;
			case "right":
				elementSwipeRIGHT(driver, by, duration);
				break;
			default:
				System.out.println("方向参数不准确");
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
	}
	
	/**
	 * 
	* @Title: elementSwipeUP  
	* @Description: TODO(元素的向上滑动，偏移量为10)  
	* @param @param driver
	* @param @param by
	* @param @param duration   持续时间，单位为ms
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void elementSwipeUP(AndroidDriver<AndroidElement> driver,By by,int duration) {
		driver.findElement(by).swipe(SwipeElementDirection.UP, 20, 20, duration);
		
	}
	/**
	 * 
	* @Title: elementSwipeDOWN  
	* @Description: TODO(元素内滑动，方向向下)  
	* @param @param driver
	* @param @param by   By对象
	* @param @param duration    持续时间，单位为ms  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void elementSwipeDOWN(AndroidDriver<AndroidElement> driver,By by,int duration) {
		driver.findElement(by).swipe(SwipeElementDirection.DOWN, 20, 20, duration);
		
	}
	
	/**
	 * 
	* @Title: elementSwipeLEFT  
	* @Description: TODO(元素内滑动，方向向左)  
	* @param @param driver
	* @param @param by
	* @param @param duration    持续时间，单位为ms  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void elementSwipeLEFT(AndroidDriver<AndroidElement> driver,By by,int duration) {
		driver.findElement(by).swipe(SwipeElementDirection.LEFT, 20, 20, duration);
		
	}
	/**
	 * 
	* @Title: elementSwipeRIGHT  
	* @Description: TODO(元素内滑动，方向向右)  
	* @param @param driver
	* @param @param by   By对象
	* @param @param duration    持续时间，单位为ms  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void elementSwipeRIGHT(AndroidDriver<AndroidElement> driver,By by,int duration) {
		driver.findElement(by).swipe(SwipeElementDirection.RIGHT, 20, 20, duration);
		
	}
	
	
    public void elementSwipe(){
    	AndroidElement element = driver.findElement(By.id(""));
    	//offsetFromStartBorder---偏移量
    	//offsetFromEndBorder---偏移量
    	//Direction--方向
    	//
    	element.swipe(SwipeElementDirection.DOWN, 10, 10, 1000);
    }
	
	
	
	
	/**
	 * 启动另外一个app的命令
	 * @param args
	 */
	public static void StartAvtivity(AndroidDriver<AndroidElement> driver){
		driver.startActivity("", "");
	}
	
	
	
	/**
	 * 获取输入框的text文本
	 * 将光标置于输入框的最后
	 * 根据文本长度循环调用物理键盘删除操作，逐个字符进行删除; 对于密码输入框无效
	 * @throws Exception 
	 * @param driver
	 * @param ele
	 * @throws Exception
	 */
	public static void clearElement(AndroidDriver<AndroidElement> driver,By by,String value) throws Exception{
		AndroidElement ele=driver.findElement(by);
		ele.click();
		String text=ele.getText();
		//将光标置于最后
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_MOVE_END);
		for(int i=0;i<text.length();i++){
			Thread.sleep(200);
			driver.pressKeyCode(AndroidKeyCode.BACKSPACE);
		}
		ele.sendKeys(value);
	}
	/**
	 * 针对密码输入框clear不干净时使用
	 * @param driver
	 * @param ele
	 * @throws Exception
	 */
	public static void clearPassword(AndroidDriver<AndroidElement> driver,AndroidElement ele) throws Exception{
		ele.click();
		//将光标置于最后
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_MOVE_END);
		for(int i=0;i<20;i++){
			Thread.sleep(200);
			driver.pressKeyCode(AndroidKeyCode.BACKSPACE);
		}
	}
	/**
	 * 滑动查找元素
	 * @param driver
	 * @throws Exception
	 */
	public static void swipeElement(AndroidDriver<AndroidElement> driver) throws Exception{
		if(fengzhuang.isElementExist(driver, By.name("设置"))){
			driver.findElement(By.name("设置")).click();
			
		}else {
			fengzhuang.swipe(driver, "up", 500);
			driver.findElement(By.name("设置")).click();
		}
		while(true){
			if(fengzhuang.isElementExist(driver, By.name("退出账号"))){
				driver.findElement(By.name("退出账号")).click();
				break;
			}else {
				fengzhuang.swipe(driver, "up", 500);
				driver.findElement(By.name("退出账号")).click();
			}
		}
	}


	
	/**
	 * 
	* @Title: getEndElementLocatian  
	* @Description: TODO(获取元素结束点坐标，在我们仅仅想使用这个元素的结束点坐标的时候使用)  
	* @param @param driver
	* @param @param by
	* @param @return    参数  
	* @return Point    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static Point getEndElementLocatian(AndroidDriver<AndroidElement> driver,By by){
		AndroidElement element=driver.findElement(by);
//		int startx=element.getLocation().getX();//获取起始点X
//		int starty=element.getLocation().getY();//获取起始点Y
//		
//		int width=element.getSize().getWidth();//获取元素的宽
//		int height=element.getSize().getHeight();//获取元素的高
//		
//		int endx=startx+width;//结束点的X
//		int endy=starty+height;//结束点的y
//		
//		int centerx=element.getCenter().getX();//中点x
//		int centery=element.getCenter().getY();//中点y
		return getElementLocatian(element);
	}

	/**
	 * 
	* @Title: getElementLocatian  
	* @Description: TODO(元素结束点坐标,返回一个point对象)  
	* @param @param element
	* @param @return    参数  
	* @return Point    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static Point getElementLocatian(AndroidElement element){
		int startx=element.getLocation().getX();//获取起始点X
		int starty=element.getLocation().getY();//获取起始点Y
		
		int width=element.getSize().getWidth();//获取元素的宽
		int height=element.getSize().getHeight();//获取元素的高
		
		int endx=startx+width;//结束点的X
		int endy=starty+height;//结束点的y
		
		int centerx=element.getCenter().getX();//中点x
		int centery=element.getCenter().getY();//中点y
		return new Point(endx, endy);	
	}
	
	/**
	 * 
	* @Title: getElemntPoint  
	* @Description: TODO(获取元素结束点的坐标)  
	* @param @param driver
	* @param @param element
	* @param @return    参数  
	* @return Point    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static Point getElemntPoint(AndroidDriver<AndroidElement> driver,AndroidElement element) {
		//获取元素的起始点的X和Y
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		//获取元素的宽和高
		int width = element.getSize().getWidth();
		int hight = element.getSize().getHeight();
		//获取元素的结束点的X和Y
		int endX = x+width;
		int endY = y+hight;
		
		return new Point(endX, endY);
		
	}
	
	/**
	 * 
	* @Title: getElementCenterPoint  
	* @Description: TODO(获取元素点的中间点坐标)  
	* @param @param driver
	* @param @param element
	* @param @return    参数  
	* @return Point    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static Point getElementCenterPoint(AndroidDriver<AndroidElement> driver,AndroidElement element) {
		//获取元素的中间点的X和Y
		int centerX = element.getCenter().getX();
		int centerY = element.getCenter().getY();
		return new Point(centerX, centerY);
	}
	
	
	/**
	 * 
	* @Title: getCurrentActivity  
	* @Description: TODO(获取当前界面的activity)  
	* @param @param driver
	* @param @return    返回当前界面的activity  
	* @return String    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static String getCurrentActivity(AndroidDriver<AndroidElement> driver) {
		String currentActivity = driver.currentActivity();
		System.out.println(currentActivity);
		return currentActivity;
	}
	
	/**
	 * 
	* @Title: getNetworkConnection  
	* @Description: TODO(获取当前网络的连接状态,数据模式：4，飞行模式：1，WIFI模式：2)  
	* @param @param driver
	* @param @return    参数  
	* @return NetworkConnectionSetting    返回类型  
	* @throws  
	* @author duanhao
	 */
	public  static NetworkConnectionSetting getNetworkConnection(AndroidDriver<AndroidElement> driver) {
		NetworkConnectionSetting networkConnectionSetting = driver.getNetworkConnection();
		System.out.println(networkConnectionSetting.toString());
		System.out.println(networkConnectionSetting.value);
		return networkConnectionSetting;
		
	}
	
	
	/**
	 * 
	* @Title: setNetworkConnection  
	* @Description: TODO(设置网络的连接模式，数据模式：4，飞行模式：1，WIFI模式：2)  
	* @param @param driver
	* @param @param date    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void setNetworkConnection(AndroidDriver<AndroidElement> driver,int date) {
		NetworkConnectionSetting networkConnectionSetting = new NetworkConnectionSetting(date);
		driver.setNetworkConnection(networkConnectionSetting);
		getNetworkConnection(driver);
	}
	
	//设置手机的横竖屏
	/**
	 * 
	* @Title: ScreenOrientationPortrait  
	* @Description: TODO(设置手机的竖屏)  
	* @param @param driver    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void  ScreenOrientationPortrait(AndroidDriver<AndroidElement> driver){
		ScreenOrientation orientation=driver.getOrientation();
		System.out.println(orientation.value());
		//设置手机屏幕为横屏LANDSCAPE
		driver.rotate(ScreenOrientation.PORTRAIT);
		System.out.println(orientation.value());
		//当    当前app不支持设置横竖屏时，运行脚本会报错
	}
	
	/**
	 * 
	* @Title: ScreenOrientationLandscape  
	* @Description: TODO(设置手机的横屏)  
	* @param @param driver    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void  ScreenOrientationLandscape(AndroidDriver<AndroidElement> driver){
		ScreenOrientation orientation=driver.getOrientation();
		System.out.println(orientation.value());
		//设置手机屏幕为横屏LANDSCAPE
		driver.rotate(ScreenOrientation.LANDSCAPE);
		System.out.println(orientation.value());
		//当   当前app不支持设置横竖屏时，运行脚本会报错
	}
	
	
	
	
	//应用的卸载和安装
	/**
	 * 
	* @Title: appInstallAndUninstall  
	* @Description: TODO(应用的安装和卸载)  
	* @param @param driver
	* @param @param startappPackage   app的包名
	* @param @param endAppPackage
	* @param @param path    app的路径位置  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void appInstallAndUninstall(AndroidDriver<AndroidElement> driver,String appPackage,String path){
		if (driver.isAppInstalled(appPackage)) {
			driver.removeApp(appPackage);
		}
		driver.installApp(path);
		System.out.println("app是否安装成功？       "+driver.isAppInstalled(appPackage));
	}

	
	
	/**
	 * 
	* @Title: reSetApp  
	* @Description: TODO(重置当前App的数据)  
	* @param @param driver    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void reSetApp(AndroidDriver<AndroidElement> driver) {
		driver.resetApp();
	}
	
	/**
	 * 
	* @Title: openTongzhilan  
	* @Description: TODO(打开通知栏)  
	* @param @param driver    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void openTongzhilan(AndroidDriver<AndroidElement> driver) {
		driver.openNotifications();
	}
	
	
	
	
	
	/**
	 * 
	* @Title: waitUtilElement  
	* @Description: TODO(自定义的显式等待)  
	* @param @param driver
	* @param @param element
	* @param @return    参数  
	* @return AndroidElement    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static AndroidElement waitUtilElement(final AndroidDriver<AndroidElement> driver,AndroidElement element){
		WebDriverWait wait=new WebDriverWait(driver, 10);
		AndroidElement any = (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(element));
		return any;
	}
	
	/**
	 * 
	* @Title: containText  
	* @Description: TODO(检查元素中是否包含某个文本)  
	* @param @param driver
	* @param @param by
	* @param @param text    是否包含的元素  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static Boolean containText(AndroidDriver<AndroidElement> driver,By by,String text) {
		return driver.findElement(by).getText().contains(text);
	}
	/**
	 * 
	* @Title: checkcheckable  
	* @Description: TODO(检查checkable的状态)  
	* @param @param driver
	* @param @param by
	* @param @param bool   字符串"true" or "false"
	* @param @return    参数  
	* @return boolean    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static boolean checkcheckable(AndroidDriver<AndroidElement> driver,By by,String bool) {
		return driver.findElement(by).getAttribute("checkable").equals(bool);
    	//String status=Close.getAttribute("checked");
//    	String text=Close.getAttribute("text");
//    	String id=Close.getAttribute("resourceId");
//    	String className=Close.getAttribute("className");
//    	String content_desc=Close.getAttribute("content-desc");
//    	String clickable=Close.getAttribute("clickable");
//    	//对复选框进行勾选
//    	String checked=Close.getAttribute("checked");
//    	String checkable=Close.getAttribute("checkable");
//    	String long_clickable=Close.getAttribute("longClickable");
//    	//name参数优先获取cantent-desc属性的值，如果这个值为空字符串，那么会获取text属性的值
//    	String name=Close.getAttribute("name");
	}
	
	public static boolean checkchecked(AndroidDriver<AndroidElement> driver,By by,String bool) {
		return driver.findElement(by).getAttribute("checked").equals(bool);
	}
	public static boolean checktext(AndroidDriver<AndroidElement> driver,By by,String bool) {
		return driver.findElement(by).getAttribute("text").equals(bool);
	}
	public static boolean checkresourceId(AndroidDriver<AndroidElement> driver,By by,String bool) {
		return driver.findElement(by).getAttribute("resourceId").equals(bool);
	}
	public static boolean checkclassName(AndroidDriver<AndroidElement> driver,By by,String bool) {
		return driver.findElement(by).getAttribute("className").equals(bool);
	}
	public static boolean checkcontent_Desc(AndroidDriver<AndroidElement> driver,By by,String bool) {
		return driver.findElement(by).getAttribute("contentDescription").equals(bool);
	}
	public static boolean checkclickable(AndroidDriver<AndroidElement> driver,By by,String bool) {
		return driver.findElement(by).getAttribute("clickable").equals(bool);
	}
	public static boolean checklongClickable(AndroidDriver<AndroidElement> driver,By by,String bool) {
		return driver.findElement(by).getAttribute("longClickable").equals(bool);
	}
	public static boolean checkname(AndroidDriver<AndroidElement> driver,By by,String bool) {
		return driver.findElement(by).getAttribute("name").equals(bool);
	}
	public static boolean checkCheckable(AndroidDriver<AndroidElement> driver,By by,String bool) {
		return driver.findElement(by).getAttribute("enable").equals(bool);
	}
	
	
	/**
	 * 
	* @Title: ScreenShot  
	* @Description: TODO(截图方法)  
	* @param @param driver
	* @param @param filename   文件名
	* @param @throws Exception    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void ScreenShot(AndroidDriver<AndroidElement>driver,String filename){
		try {
			File file=driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,new File("images\\"+filename+".png"));
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

	}
	/**
	 * 
	* @Title: Screenshot  
	* @Description: TODO(失败截图方法)  
	* @param @param driver
	* @param @param ScreenName
	* @param @throws Exception    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void Screenshot(AndroidDriver<AndroidElement> driver,String ScreenName){
		try {
			//设置时间格式
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			//生成时间戳
			String dataString=formater.format(new Date());
			String dir_name=System.getProperty("user.dir")+"\\异常图片";
			System.out.println("异常图片目录"+dir_name);
			//由于可能存在异常图片的目录被删除的可能，所以这边先判断目录是否存在
			if (!(new File(dir_name).isDirectory())) 
			{
				//判断是否存在该目录
				new File(dir_name).mkdir();
			}
			//调用方法捕捉画面
			File screen=driver.getScreenshotAs(OutputType.FILE);
			//复制文件到指定目录
			//图片最后存放的路径有 目录：dir_name+时间戳+测试套件+测试用例+测试步骤组合生成
			System.out.println("异常图片名称"+dir_name+"\\"+dataString+ScreenName+".png");
			FileUtils.copyFile(screen,new File(dir_name+"\\"+dataString+ScreenName+".png"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}
	
	
	//判断屏幕是否锁屏,如果锁屏，则解锁
	public static void locked(AndroidDriver<AndroidElement>driver){
		if (driver.isLocked()) {
			driver.unlockDevice();
		}
	}
	/**
	 * 
	* @Title: zoom  
	* @Description: TODO(放大元素)  
	* @param @param driver
	* @param @param by    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void zoom(AndroidDriver<AndroidElement>driver,By by){
		driver.zoom(driver.findElement(by));
	}


	/**
	 * 
	* @Title: pinch  
	* @Description: TODO(缩小元素)  
	* @param @param driver
	* @param @param by    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void pinch(AndroidDriver<AndroidElement>driver,By by){
		driver.pinch(driver.findElement(by));
	}
	
	/**
	 * 
	* @Title: longpressElement  
	* @Description: TODO(长按某一个元素)  
	* @param @param driver
	* @param @param by    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void longpressElement(AndroidDriver<AndroidElement> driver,By by) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(driver.findElement(by)).release().perform();
	}
	
	/**
	 * 
	* @Title: longpressPoint  
	* @Description: TODO(长按一个坐标点)  
	* @param @param driver
	* @param @param X    x点坐标
	* @param @param Y    y点坐标 
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void longpressPoint(AndroidDriver<AndroidElement> driver,int X,int Y) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(X, Y).release().perform();
	}
	
	
	
	
	//拖拽
	public static void touchaction1(AndroidDriver<AndroidElement>driver){
		AndroidElement element1=driver.findElement(By.id("xxxx"));
		AndroidElement element2=driver.findElement(By.id("xxxx"));
		TouchAction ta=new TouchAction(driver);
		
		//从一个点拖拽到另一个点，可用于屏幕的解锁
		ta.press(element1).moveTo(element2).release().perform();
		ta.longPress(element1).moveTo(element2).release().perform();
		
		//对某一个元素进行长按操作
		ta.longPress(element1).release().perform();
		//对某一个元素根据坐标进行长按操作
		ta.longPress(300,500).release().perform();
		
		//对某一个元素进行点击
		ta.press(element1).release().perform();
		ta.press(300, 500).release().perform();	
	}
	//拖拽
	public static void touchaction(AndroidDriver<AndroidElement>driver) throws Exception{
		TouchAction ta=new TouchAction(driver);
		driver.pressKeyCode(3);
		Thread.sleep(2000);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		Thread.sleep(500);
		fengzhuang.swipe(driver, "left", 1000);
		AndroidElement zhihu=driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"知乎\"]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]"));
		AndroidElement rili=driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"日历\"]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]"));
		ta.press(zhihu).moveTo(rili).release().perform();
		
	}
	
	//通过id定位当前屏幕所有设置，并且获取所有设置的文本存入list，如果这个list的大小小于**，那就向上滑动
	//再次获取当前屏幕的所有设置，并且将所有设置的文本存入list，并且判重，再次判断list的大小是否大于**，如果大于，直接list.get(**-1).clik，完成点击
	/**
	 * 
	* @Title: listClick  
	* @Description: TODO(滑动查找不可见的元素)  
	* @param @param driver
	* @param @param element
	* @param @param by
	* @param @param index
	* @param @param clicknum
	* @param @throws Exception    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void listClick(AndroidDriver<AndroidElement> driver,By by,int index,int clicknum) throws Exception{
		yinshiWait(driver);
		List<String> settingTexts=new ArrayList<String>();
		List<AndroidElement> settings=new ArrayList<AndroidElement>();
		while(true){
			List<AndroidElement> titles=driver.findElements(by);
			for(AndroidElement ae:titles){
				String text=ae.getText();
				if(settingTexts.contains(text)){
					
				}else {
					settingTexts.add(text);
					settings.add(ae);
				}
			}
			if(settingTexts.size()>index){
				settings.get(clicknum).click();
				Thread.sleep(5000);
				break;
			}else{
				fengzhuang.swipe(driver, "up", 1000);
			}
		}
	}
	//滑动查找元素
	public static void findelement(AndroidDriver<AndroidElement>driver) throws Exception{
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.findElement(By.name("设置")).click();
		if (fengzhuang.isElementExist(driver, By.xpath("//android.widget.TextView[@text=\"锁屏和密码\"]"))) {
			driver.findElement(By.xpath("//android.widget.TextView[@text=\"锁屏和密码\"]")).click();
		}else {
			fengzhuang.swipe(driver, "up", 2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text=\"锁屏和密码\"]")).click();
		}		
	}
	
	public void logout(AndroidDriver<AndroidElement>driver) throws Exception{
		if(fengzhuang.isElementExist(driver, By.name("设置"))){
			driver.findElement(By.name("设置")).click();
		}else{
			fengzhuang.swipe(driver, "up", 500);
			driver.findElement(By.name("设置")).click();
		}
		while(true){
			if(fengzhuang.isElementExist(driver, By.name("退出帐号"))){
				driver.findElement(By.name("退出帐号")).click();
				driver.findElement(By.name("确定")).click();
				break;
			}else{
				fengzhuang.swipe(driver, "up", 500);
			}
		}
	}

	/**
	 * @throws Exception 
	 * 
	 */
	public static void selectElement(AndroidDriver<AndroidElement> driver) throws Exception{
		driver.pressKeyCode(3);
		driver.findElement(By.id("xxx"));
		List<String> settingTexts = new ArrayList<String>();
		List<AndroidElement> settings = new ArrayList<AndroidElement>();
		while(!fengzhuang.isElementExist(driver,By.xpath(""))){
			List<AndroidElement> titles = driver.findElements(By.id(""));
			for(AndroidElement ae:titles){
				String text = ae.getText();
				if(!settingTexts.contains(text)){
					settingTexts.add(text);
					settings.add(ae);
				}
			}
			if(settingTexts.size()>13){
				settings.get(14).click();
				Thread.sleep(1000);
				break;
				
			}else {
				fengzhuang.swipe(driver, "up", 1000);
			}
		}
		
	}
	


	/**
	 * 长按home键，3值是home键
	 * @param driver
	 */
	public static void longPressKeyCode(AndroidDriver<AndroidElement> driver){
		driver.longPressKeyCode(3);
	}
	
	/**
	 * 对元素进行缩小
	 * @param driver
	 * @param by
	 */
	public static void suoxiao(AndroidDriver<AndroidElement> driver,By by){
		//可以使用元素进行缩小
		driver.pinch(driver.findElement(by));
		//可以对某一个坐标进行缩小
		driver.pinch(300,500);
	}
	
	/**
	 * 对元素进行放大
	 * @param driver
	 * @param by
	 */
	public static void fangda(AndroidDriver<AndroidElement> driver,By by){
		//对某一个元素进行放大
		driver.zoom(driver.findElement(by));
		//对某一个坐标点进行放大
		driver.zoom(300, 500);
	}

	public static void touchAction(AndroidDriver<AndroidElement> driver){
		AndroidElement element=driver.findElement(By.id("xx"));
		TouchAction touchAction=new TouchAction(driver);
		touchAction.longPress(element).release().perform();
		driver.scrollTo("");
	}
	
	//解锁手势锁
	public static void shoushisuo(AndroidDriver<AndroidElement>driver) throws Exception{
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.findElement(By.name("设置")).click();
		if (fengzhuang.isElementExist(driver, By.name("锁屏和密码"))) {
			driver.findElement(By.name("锁屏和密码")).click();
		}else {
			fengzhuang.swipe(driver,"up", 2000);
			Thread.sleep(2000);
			driver.findElement(By.name("锁屏和密码")).click();
		}	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"锁屏密码\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"图案\"]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		AndroidElement element=driver.findElement(By.id("com.android.settings:id/lockPattern"));
		Point p=element.getLocation();
		int x=p.getX();
		int y=p.getY();
		Dimension d=element.getSize();
		int width=d.getWidth();
		int height=d.getHeight();
		List<Point> pList=new ArrayList<Point>();
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				int center_x=x+(2*j+1)*width/6;
				int center_y=y+(2*i+1)*height/6;
				Point p1=new Point(center_x, center_y);
				pList.add(p1);
			}
		}
		//绘制手势图，moveTo里的坐标是相对与前一个点的偏移量
		TouchAction ta=new TouchAction(driver);
		ta.press(pList.get(0).getX(),pList.get(0).getY())
		.moveTo(pList.get(1).getX()-pList.get(0).getX(),pList.get(1).getY()-pList.get(0).getY())
		.moveTo(pList.get(2).getX()-pList.get(1).getX(),pList.get(2).getY()-pList.get(1).getY())
		.moveTo(pList.get(4).getX()-pList.get(2).getX(),pList.get(4).getY()-pList.get(2).getY())
		.moveTo(pList.get(6).getX()-pList.get(4).getX(),pList.get(6).getY()-pList.get(4).getY())
		.moveTo(pList.get(7).getX()-pList.get(6).getX(),pList.get(7).getY()-pList.get(6).getY())
		.moveTo(pList.get(8).getX()-pList.get(7).getX(),pList.get(8).getY()-pList.get(7).getY())
		.moveTo(1,1).release().perform();
		Thread.sleep(3000);
		//再滑动一次进行确认 
		ta.press(pList.get(0).getX(),pList.get(0).getY())
		.moveTo(pList.get(1).getX()-pList.get(0).getX(),pList.get(1).getY()-pList.get(0).getY())
		.moveTo(pList.get(2).getX()-pList.get(1).getX(),pList.get(2).getY()-pList.get(1).getY())
		.moveTo(pList.get(4).getX()-pList.get(2).getX(),pList.get(4).getY()-pList.get(2).getY())
		.moveTo(pList.get(6).getX()-pList.get(4).getX(),pList.get(6).getY()-pList.get(4).getY())
		.moveTo(pList.get(7).getX()-pList.get(6).getX(),pList.get(7).getY()-pList.get(6).getY())
		.moveTo(pList.get(8).getX()-pList.get(7).getX(),pList.get(8).getY()-pList.get(7).getY())
		.moveTo(1,1).release().perform();
		Thread.sleep(2000);
		driver.findElement(By.name("确认")).click();	
	}
	//
	public static void xiangduizuobiao(AndroidDriver<AndroidElement>driver) throws Exception{
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.pressKeyCode(3);
		driver.findElement(By.name("设置")).click();
		if (fengzhuang.isElementExist(driver, By.name("锁屏和密码"))) {
			driver.findElement(By.name("锁屏和密码")).click();
		}else {
			fengzhuang.swipe(driver,"up", 2000);
			Thread.sleep(2000);
			driver.findElement(By.name("锁屏和密码")).click();
		}	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"锁屏密码\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"图案\"]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		AndroidElement element=driver.findElement(By.id("com.android.settings:id/lockPattern"));
		Point p=element.getLocation();
		int x=p.getX();
		int y=p.getY();
		Dimension d=element.getSize();
		int width=d.getWidth();
		int height=d.getHeight();
		List<Point> pList=new ArrayList<Point>();
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				int center_x=x+(2*j+1)*width/6;
				int center_y=y+(2*i+1)*height/6;
				Point p1=new Point(center_x, center_y);
				pList.add(p1);
			}
		}
		
		TouchAction ta=new TouchAction(driver);
		ta.press(171,693).moveTo(358,693).moveTo(547,693).moveTo(361,880).moveTo(171,1066)
		.moveTo(358,1066).moveTo(547,1066).moveTo(1,1).release().perform();
		Thread.sleep(5000);
	}
	
	
	public static void login(AndroidDriver<AndroidElement> driver) throws Exception{
		
		Thread.sleep(2000);
		driver.findElement(By.name("我的")).click();
		if (driver.getPageSource().contains("个人信息")) {
			System.out.println("账号已经登录");
		} else {
			Thread.sleep(500);
			driver.findElement(By.name("请点击登录")).click();
			Thread.sleep(500);
			driver.findElement(By.name("使用其他方式登录")).click();
			Thread.sleep(500);
			driver.findElement(By.name("账号密码")).click();
			Thread.sleep(500);
			driver.findElement(By.id("com.sankuai.meituan:id/edit_account")).sendKeys("18025478840");
			Thread.sleep(500);
			driver.findElement(By.id("com.sankuai.meituan:id/edit_password")).sendKeys("62218852000duan");
			Thread.sleep(500);
			driver.findElement(By.name("登录")).click();
			Thread.sleep(2000);
			System.out.println(driver.getPageSource());
			if (driver.getPageSource().contains("个人信息")) {
				System.out.println("账号登录成功");
				fengzhuang.clickMenu(driver, 1);
			} else {
				System.out.println("登录失败");
			}

		}
	}
	
	public static void login_out(AndroidDriver<AndroidElement> driver) throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.name("我的")).click();
		if (driver.getPageSource().contains("请点击登录")) {
			System.out.println("账号还未登录");
		} else {
			Thread.sleep(500);
			driver.findElement(By.id("com.sankuai.meituan:id/settings")).click();
			Thread.sleep(500);
			driver.findElement(By.name("退出账户")).click();
			Thread.sleep(500);
			driver.findElement(By.id("android:id/button1")).click();
			System.out.println("账号退出成功");
			fengzhuang.clickMenu(driver, 1);

		}
	}
	
	
	/**
	 * 打印倒数第三个
	 * 先是滑到底部，获取最后一屏的所有title，然后点倒数第三个
	 * 如何判断滑动到最后一屏
	 * 判断每次滑动前后的界面内容是否一致，如果一致则表示滑动到底部，在这里以每项设置的文本作为判断滑动屏幕是否一样的依据
	 * @author duanhao
	 * @param driver
	 * @param a 是要点击的第几个
	 * @param by传进来的元素对象
	 * @throws Exception
	 */
	public static void scollEndScrren(AndroidDriver<AndroidElement> driver,int a,By by) throws Exception{
		boolean flag=false;
		while(true){
			List<String> oldTexts=new ArrayList<String>();
			List<String> newTexts=new ArrayList<String>();
			
			List<AndroidElement> titles=driver.findElements(by);
			for(AndroidElement ae:titles){
				String text=ae.getText();
				oldTexts.add(text);
			}
			if(!flag){
				fengzhuang.swipe(driver, "up",1000);
			}else{
				titles.get(a).click();
				Thread.sleep(1000);
				break;
			}
			List<AndroidElement> titles1=driver.findElements(by);
			for(AndroidElement ae:titles1){
				String text=ae.getText();
				newTexts.add(text);
			}
			System.out.println(oldTexts.get(oldTexts.size()-1));
			System.out.println(newTexts.get(newTexts.size()-1));
			if(oldTexts.get(oldTexts.size()-1).equals(newTexts.get(newTexts.size()-1))){
				flag=true;
			}
//			if(oldTexts.size()==newTexts.size()){
//				for(int i=0;i<oldTexts.size();i++){
//					if(oldTexts.get(i).equals(newTexts.get(i))){
//						flag=true;
//						continue;
//					}else{
//						flag=false;
//						break;
//					}
//				}
//			}
			
		}
	}
	

	/**
	 * 
	* @Title: yinshiWait  
	* @Description: TODO(设置findelement的隐式等待)  
	* @param @param driver
	* @param @param second    自定义隐式等待的时长  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void yinshiWait(AndroidDriver<AndroidElement> driver,int second){
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	}
	
	/**
	 * 
	* @Title: yinshiWait  
	* @Description: TODO(10s的隐式等待时长)  
	* @param @param driver    参数  
	* @return void    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static void yinshiWait(AndroidDriver<AndroidElement> driver){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * 拖拽的方法封装
	 * @author duanhao
	 * @param driver
	 * @param startLocation：开始点的坐标位置
	 * @param endLocation：结束点的坐标位置
	 */
	public static void drag(AndroidDriver<AndroidElement> driver,By startElement,By endElement){
		TouchAction touchAction = new TouchAction(driver);
		AndroidElement start = driver.findElement(startElement);
		AndroidElement end = driver.findElement(endElement);
		touchAction.longPress(start).moveTo(end).release().perform();
		
		
	}
	
	/**
	 * 该方法用户对某个元素只能左滑后才能出现，该方法为知道元素出现为止
	 * swip方法为偏移量滑动，20位偏移量，持续时间1s
	 * @author duanhao
	 * @param driver
	 * @param by
	 */
	public static void pianyiLeft(AndroidDriver<AndroidElement> driver,By by){
		AndroidElement element = driver.findElement(by);
		element.swipe(SwipeElementDirection.LEFT, 20, 20, 1000);
	}
	
	/**
	 * 对不能定位到的手势密码元素进行定位，并且进行分割，然后定位元素中的每一个单元格，然后进行滑动
	 * @author duanhao
	 * @param driver
	 * @param by
	 * @throws Exception
	 */
	public static void shoushisuo(AndroidDriver<AndroidElement> driver,By by) throws Exception{
		AndroidElement element = driver.findElement(by);
		Point point = element.getLocation();
		int x = point.getX();
		int y = point.getY();
		Dimension dimension = element.getSize();
		int width = dimension.getWidth();
		int higth = dimension.getHeight();
		List<Point> points = new ArrayList<Point>();
		for(int i = 0;i<3;i++){
			for(int j = 0;j <3;j++){
				int center_x = x+(2*j+1)*width/6;
				int center_y = y+(2*i+1)*higth/6;
				Point point2 = new Point(center_x, center_y);
				points.add(point2);
			}
		}
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(points.get(0).getX(),points.get(0).getY())
		.moveTo(points.get(1).getX(),points.get(1).getY())
		.moveTo(points.get(2).getX(),points.get(2).getY())
		.moveTo(points.get(4).getX(),points.get(4).getY())
		.moveTo(points.get(6).getX(),points.get(6).getY())
		.moveTo(points.get(7).getX(),points.get(7).getY())
		.moveTo(points.get(8).getX(),points.get(8).getY())
		.moveTo(1, 1)
		.release().perform();
		Thread.sleep(2000);
		
	}
	/**
	 * 判断屏幕是否锁定，如果锁定，则解锁
	 * @author duanhao
	 * @param driver
	 */
	public static void unlock(AndroidDriver<AndroidElement> driver){
		if(driver.isLocked()){
			driver.unlockDevice();
		}
		
	}
	/**
	 * 对鹿管家的首页四个菜单键进行点击，手起1
	 * @author duanhao
	 * @param driver
	 * @param order
	 */
	public static void ClickMenu(AndroidDriver<AndroidElement> driver,int order){
		driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout["+order+"]/android.widget.Button[1]")).click();
	}
	
	
	
	/**
	 * 封装了滑动查找元素并且点击
	 * @author duanhao
	 * @param driver
	 * @param by
	 * @throws Exception
	 */
	public static void isElementAndClick(AndroidDriver<AndroidElement> driver,By by) throws Exception{
		while(true){
			if(fengzhuang.isElementExist(driver, by)){
				driver.findElement(by).click();
				break;
			}else {
				fengzhuang.swipe(driver, "up", 1000);
			}
		}
	}
	
	
	/**
	 * 
	* @Title: isElementExist  
	* @Description: TODO(查找当前页面的元素是否存在)  
	* @param @param driver
	* @param @param by  by对象
	* @param @return    参数  
	* @return boolean    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static boolean isElementExist(AndroidDriver<AndroidElement> driver,By by){
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
	* @Title: getMysqldata  查询数据库中的某个字段，已经处理，只返回一个数据
	* @Description: TODO(主要用作查询动态验证码用)  
	* @param @param database   要连接的数据库
	* @param @param selectdate    要查询的字段
	* @param @param selecttable			要查询的数据表
	* @param @param where			where条件，where已经提前加入了
	* @param @return    参数  
	* @return String    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static Object getMysqldata(String database,String selectdate,String selecttable,String where) {
        //数据库连接名称
        String username="root";
        //数据库连接密码
        String password="root";
        String driver="com.mysql.jdbc.Driver";
        //其中database为数据库名称
        String url="jdbc:mysql://localhost:3306/"+database+"?useSSL=false&useUnicode=true&characterEncoding=GBK";
        Connection conn=null;
        try{
            Class.forName(driver);
            conn=(Connection) DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        // sql语句
        String sql = "select "+selectdate+" from "+selecttable+" "+where; 
        PreparedStatement pst = null;
        // 定义一个list用于接受数据库查询到的内容
        List<String> list = new ArrayList<String>();
        try {
            pst = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
                list.add(rs.getString(selectdate));
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        System.out.println("查询出来的数据是："+list.get(0));
        return list.get(0);
	}
	
	
	/**
	 * 
	* @Title: getUdid  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param cmdString    adb devices命令的输入
	* @param @return    参数  
	* @return List<String>    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static List<String> getUdid(String cmdString){
		DosCmd dosCmd = new DosCmd();
		try {
			return dosCmd.execCmdConsole(cmdString);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 
	* @Title: getdate  
	* @Description: TODO(获取当前设备的系统时间的方法)  
	* @param @return    参数  
	* @return String    返回类型    返回当前时间
	* @throws  
	* @author duanhao
	 */
	public static String getdate() {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        
        
        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");
//        System.out.println(df1.format(System.currentTimeMillis()));  
        return df1.format(System.currentTimeMillis()).toString();
	}
	
	/**
	 * 
	* @Title: SplitString  
	* @Description: TODO(传入一个string，根据分隔符拆分string，得到所需要的索引的字符串)  
	* @param @param string   传入的字符串
	* @param @param splitSgin   分割符
	* @param @param index   分割后需要的索引的字符串
	* @param @return    参数  
	* @return Str    返回类型    返回拆分后的字符串
	* @throws  
	* @author duanhao
	 */
	public static String SplitString(String str,String splitSgin,int index) {
		return str.split(splitSgin)[index];
	}

	
	/**
	 * 从字符串里提取整数，索引是从0开始  dsd234dsf455h34h232h34545
	 * @param str  目标字符串
	 * @param index 提取第几组数字，从0开始
	 * @return 返回一个整数，如果返回-1则表明你提取的组数不存在
	 */
	public static int getIntFromString(String str,int index){
		Pattern p = Pattern.compile("\\d{1,}");//这个1是指连续数字的最少个数
        Matcher m = p.matcher(str);
        List<Integer> result=new ArrayList<Integer>();
        while (m.find()) {
           // System.out.println(m.group());
            result.add(Integer.valueOf(m.group()));
        }
        if(!result.isEmpty()&&index<result.size()){
        	System.out.println("你要找的数字在第"+index+"个索引");
        	return result.get(index);
        }else{
        	System.out.println("你要找的第"+(index+1)+"组数字不存在");
        	return -1;
        }
	}
	

	
	/**
	 * 
	* @Title: randomInt  
	* @Description: TODO(生成指定范围内的整数)  
	* @param @param min   最小数，包含生成的最小数
	* @param @param max		最大数，包含生成的最大数
	* @param @return    参数  
	* @return int    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static int getRandomInt(int min,int max){ 
        Random random = new Random();
        //10,100 88%91=88+10=98
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
	}
	
	
	
	/**
	 * 
	* @Title: randomFloat  
	* @Description: TODO(生成指定范围内的浮点数)  
	* @param @param min
	* @param @param max
	* @param @return    参数  
	* @return float    返回类型  
	* @throws  
	* @author duanhao
	 */
	public static float getRandomFloat(int min,int max){
        Random random = new Random();
        //10,100
        //0.0746273646*100=746.273646=746=7.46
//        int s = random.nextInt(max)%(max-min+1) + min;
        float x=min;//x=10
        while(x<=min){
        	double db = random.nextDouble() * max * 100;
        	x = ((int) db) / 100f;
        }
        return x;
	}
	
	
	
	
	/**
	 * 生成指定数字，向零靠拢的数字，不包含数字本身
	 * @param extent
	 * @return
	 */
	public static int getRandomNumber(int extent) {
		int number = (int) (Math.random() * extent);
		return number;
	}
	
	/**
	 * 随机生成指定长度的数字，以字符串形式返回
	 * @param lengthOfNumber
	 * @return
	 */
	public static String getRandomNumberByLength(int lengthOfNumber) {
		int i, count = 0;
		//098
		StringBuffer randomStr = new StringBuffer("");
		Random rnd = new Random();

		while (count < lengthOfNumber) {
			i = Math.abs(rnd.nextInt(10));
			if (i == 0 && count == 0) {
				//意思是不生成开始为0的数字，比如098,01
			} else {
				randomStr.append(String.valueOf(i));
				count++;
			}
		}
		return randomStr.toString();
	}
	
	
	
	
	/**
	 * 随机生成指定长度的中文字符，以字符串形式返回
	 * @author duanhao
	 * @param lengthOfString
	 * @return
	 */
	public static String getRandomChineseStringByLength(int lengthOfString) {
		int i, count = 0;
		final String chars ="我,国,北,方,地,区,出,现,大,范,围,持,续,性,高,温,的,可,能,性,不,是,很,大,但,在,南,方,夏,秋,交,替,之,际,副,热,带,高,压,开,始,南,退,东,撤,由,于,大,气,环,流,的,不,稳,定,性,副,热,带,高,压,有,时,又,可,能,短,暂,地,西,伸,北,抬,再,次,控,制,我,国,东,部,地,区,造,成,高,温,重,现,民,间,称,之,为,秋,老,虎,因,此,防,御,高,温,仍,然,不,可,掉,以,轻,心";
		String[] charArr = chars.split(",");

		StringBuffer randomStr = new StringBuffer("");
		Random rnd = new Random();
		int strLen = charArr.length;

		while (count < lengthOfString) {
			i = rnd.nextInt(strLen);//strLen如果等于30，i值就在0-30之间
			//System.out.println(i);
			randomStr.append(charArr[i]);
			count++;
		}
		return randomStr.toString().toLowerCase();
	}
	
	
	/**
	 * 随机生成指定长度的纯小写字母英文字符串，以字符串的形式返回
	 * @author duanhao
	 * @param lengthOfString
	 * @return
	 */
	public static String getRandomSmallEnglishByLength(int lengthOfString) {
		int i, count = 0;
		final String chars ="A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
		String[] charArr = chars.split(",");

		StringBuffer randomStr = new StringBuffer("");
		Random rnd = new Random();
		int strLen = charArr.length;

		while (count < lengthOfString) {
			i = rnd.nextInt(strLen);//strLen如果等于26，i值就在0-25之间
			//System.out.println(i);
			randomStr.append(charArr[i]);
			count++;
		}
		return randomStr.toString().toLowerCase();
	}
	
	
	/**
	 * 随机生成指定长度的纯大写字母英文字符串，以字符串的形式返回
	 * @author duanhao
	 * @param lengthOfString
	 * @return
	 */
	public static String getRandomBigEnglishByLength(int lengthOfString) {
		int i, count = 0;
		final String chars ="A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
		String[] charArr = chars.split(",");

		StringBuffer randomStr = new StringBuffer("");
		Random rnd = new Random();
		int strLen = charArr.length;

		while (count < lengthOfString) {
			i = rnd.nextInt(strLen);//strLen如果等于26，i值就在0-25之间
			//System.out.println(i);
			randomStr.append(charArr[i]);
			count++;
		}
		return randomStr.toString();
	}
	
	
	
	
	/**
	 * 随机生成指定长度的数字和小写英文字符串，以字符串的形式返回
	 * @param chars
	 * @param lengthOfString
	 * @return
	 */
	public static String getRandomSmallStringAndNumberByLength(int lengthOfString) {
		int i, count = 0;
		final String chars ="1,2,3,4,5,6,7,8,9,0,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
		String[] charArr = chars.split(",");

		StringBuffer randomStr = new StringBuffer("");
		Random rnd = new Random();
		int strLen = charArr.length;

		while (count < lengthOfString) {
			i = rnd.nextInt(strLen);//strLen如果等于36，i值就在0-35之间
			//System.out.println(i);
			randomStr.append(charArr[i]);
			count++;
		}
		return randomStr.toString().toLowerCase();
	}
	
	/**
	 * 随机生成指定长度的数字和大写英文字符串，以字符串的形式返回
	 * @param chars
	 * @param lengthOfString
	 * @return
	 */
	public static String getRandomBigStringAndNumberByLength(int lengthOfString) {
		int i, count = 0;
		final String chars ="1,2,3,4,5,6,7,8,9,0,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
		String[] charArr = chars.split(",");

		StringBuffer randomStr = new StringBuffer("");
		Random rnd = new Random();
		int strLen = charArr.length;

		while (count < lengthOfString) {
			i = rnd.nextInt(strLen);//strLen如果等于36，i值就在0-35之间
			//System.out.println(i);
			randomStr.append(charArr[i]);
			count++;
		}
		return randomStr.toString();
	}
	
	
    public static int[] getData(String name)throws Exception{
        BufferedImage img = ImageIO.read(new File(name));
        BufferedImage slt = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
        slt.getGraphics().drawImage(img,0,0,100,100,null);
//        System.out.println(slt.getWidth());
//        System.out.println(slt.getHeight());
        
        int[] data = new int[256];
        for(int x = 0;x<slt.getWidth();x++){
            for(int y = 0;y<slt.getHeight();y++){
                int rgb = slt.getRGB(x,y);
                Color myColor = new Color(rgb);
                int r = myColor.getRed();
                int g = myColor.getGreen();
                int b = myColor.getBlue();
                data[(r+g+b)/3]++;
            }
        }
        return data;
    }
    /*
     * 异常情况下的截图操作
     */
    public static void ErrorScreemShot(AndroidDriver<AndroidElement> driver,String ErrorScreenShot) throws Exception{
    	//设置时间格式
    	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    	//生成时间戳
    	String dataString = format.format(new Data());
    	String dir_name = System.getProperty("user.dir")+"\\images";
    	System.out.println("异常图片目录"+dir_name);
    	//由于可能存在异常图片的目录被删除的可能，所以先判断一下目录是否存在
    	if(!(new File(dir_name).isDirectory())){
    		//判断目录是否存在
    		new File(dir_name).mkdirs();
    	}
    	//调用方法捕捉画面
    	File Screen = driver.getScreenshotAs(OutputType.FILE);
    	//复制文件到指定的目录
    	//图片最后存放的路径由目录：dir_name+时间桌+测试套件+测试用例+测试步骤组合生成
    	System.out.println("异常图片名称"+dir_name+"\\"+dataString+ErrorScreenShot+".png");
    	FileUtils.copyFile(Screen, new File(dir_name+"\\"+dataString+ErrorScreenShot+".png"));
    }
    
    
    
    
    
    public static float compare(int[] s,int[] t){
        float result = 0F;
        for(int i = 0;i<256;i++){
            int abs = Math.abs(s[i]-t[i]);
            int max = Math.max(s[i],t[i]);
            
            result += (1-((float)abs/(max==0?1:max)));
            
        }
        return (result/256)*100;
    }
    /**
     * 
    * @Title: compareImg  
    * @Description: TODO(图片对比方法)  
    * @param @param srcName
    * @param @param desName
    * @param @param f
    * @param @return
    * @param @throws Exception    参数  
    * @return boolean    返回类型  
    * @throws  
    * @author duanhao
     */
    public static boolean compareImg(String srcName,String desName,float f) throws Exception{
    	if(compare(getData(srcName), getData(desName))>=f){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    

    /**
     * 
    * @Title: send  
    * @Description: TODO(发送邮件的方法)  
    * @param @param title   邮件标题
    * @param @param text    邮件内容  
    * @return void    返回类型  
    * @throws  
    * @author duanhao
     */
    public static void send(String title,String text) {
        try {
        	Properties p = new Properties(); //Properties p = System.getProperties();   
            p.put("mail.smtp.auth", "true");   
            p.put("mail.transport.protocol", "smtp");   
            p.put("mail.smtp.host", "smtp.163.com");   
            p.put("mail.smtp.port", "25");   
            //建立会话   
            Session session = Session.getInstance(p);   
            Message msg = new MimeMessage(session); //建立信息  
            //读取配置文件
            ProUtil pu=new ProUtil(CrazyPath.globalPath);
            String sendUser=pu.getPro("senduser");
            String password=pu.getPro("password");
            msg.setFrom(new InternetAddress(sendUser)); //发件人   
            
        	String[] to=pu.getPro("tomail").split(",");
            String toPersion = getMailList(to);
            InternetAddress[] iaToList = new InternetAddress().parse(toPersion);
            
            msg.setRecipients(Message.RecipientType.TO,iaToList); //收件人   
    
            msg.setSentDate(new Date()); // 发送日期   
            msg.setSubject(title); // 主题   
            msg.setText(text); //内容   
            // 邮件服务器进行验证   
            Transport tran = session.getTransport("smtp");   
            tran.connect("smtp.163.com",sendUser,password);    
            tran.sendMessage(msg, msg.getAllRecipients()); // 发送   
            System.out.println("邮件发送成功");   
    
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
    
    private static String getMailList(String[] mailArray){
        
        StringBuffer toList = new StringBuffer();
        int length = mailArray.length;
        if(mailArray!=null && length <2){
             toList.append(mailArray[0]);
        }else{
             for(int i=0;i<length;i++){
                     toList.append(mailArray[i]);
                     if(i!=(length-1)){
                         toList.append(",");
                     }
             }
         }
     return toList.toString();
    }
	
    
	/**
	 * 获取设备默认输入法
	 * @return
	 */
	public static  String getDefaultInput(String udid){
		DosCmd dc=new DosCmd();
		String input="";
		try {
			//List<String> res=dc.execCmdConsole("adb -s 192.168.56.101:5555 shell settings get secure default_input_method");
			List<String> res=dc.execCmdConsole("adb -s "+udid+" shell settings get secure default_input_method");
			//System.out.println("adb -s "+udid+" shell settings get secure default_input_method");
			System.out.println(res.size());
			input=res.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return input;
	}
	/**
	 * 唤醒屏幕
	 * @throws Exception
	 */
	public static void wakeUp(String udid) throws Exception{
		DosCmd dc=new DosCmd();
		try {
			dc.execCmdConsole("adb -s "+udid+" shell am start -n io.appium.unlock/io.appium.unlock.Unlock");
			System.out.println("adb -s "+udid+" shell am start -n io.appium.unlock/io.appium.unlock.Unlock");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
    
    
    
    
    
    
    
    
	public static void main(String[] args) {
		System.out.println(getMysqldata("school", "name", "student", "where name='张一'"));
		System.out.println(getdate());
		
		
//		System.out.println(SplitString("127.0.0.1:62001", ":", 0));
////		System.out.println(getIntFromString("appium -p 4490 -bp 2253 -U 127.0.0.1:62001>logs/127.0.0.1:62001.log", 0));
//		System.out.println(getRandomInt(10, 11));
//		System.out.println(getRandomFloat(1, 2));
//		System.out.println(getRandomNumber(1));
//		System.out.println(getRandomNumberByLength(10));
//		System.out.println(getRandomChineseStringByLength(300));
//		System.out.println(getRandomSmallEnglishByLength(50));
//		System.out.println(getRandomBigEnglishByLength(50));
	}

	

	


}
