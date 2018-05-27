package com.etyero.utils;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppDriverUtil {
	private AndroidDriver<WebElement> driver;
	private static AppDriverUtil appDriverUtil = null;

	/**
	 * 使用单例模式，只启用一次app
	 * 
	 */
	private AppDriverUtil() {
	}

	public static synchronized AppDriverUtil getInstance() {
		if (appDriverUtil == null) {
			appDriverUtil = new AppDriverUtil();
		}
		return appDriverUtil;
	}

	/**
	 * 获取app driver
	 * 
	 * @author lijialong
	 */
	public AndroidDriver<WebElement> getAppDriver(String apkName, String platformName, String platformVersion, String deviceName,
			String appPackage, String appActivity) {
		if (getDriver() == null) {
			try {
				if (StrUtil.isNotNull(apkName)) {
					driver = appRemoteDriver(apkName, platformName, platformVersion, deviceName, appPackage, appActivity);
				} else {
					driver = appRemoteDriver(platformName, platformVersion, deviceName, appPackage, appActivity);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			setDriver(driver);
		}
		return getDriver();
	}

	public void setDriver(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}

	public AndroidDriver<WebElement> getDriver() {
		return driver;
	}

	/**
	 * 安装后app获取app driver
	 * 
	 * @author lijialong
	 * @param apkName
	 *            apk全称，带后缀
	 * @param platformName
	 *            iOS||Android
	 * @param platformVersion
	 *            系统版本
	 * @param deviceName
	 *            设备名称
	 * @param appPackage
	 *            app包名
	 * @param appActivity
	 *            启动的appActivity
	 */
	public AndroidDriver<WebElement> appRemoteDriver(String apkName, String platformName, String platformVersion, String deviceName,
			String appPackage, String appActivity) throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apk");
		File app = new File(appDir, apkName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("deviceName", deviceName);
	    capabilities.setCapability("noSign", true);  //安装时不对apk进行签名
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("unicodeKeyboard", true);  
	    capabilities.setCapability("resetKeyboard", true);  //重置输入法为系统默认
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("automationName","uiautomator2");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;
	}
	
	/**
	 * 无安装获取app driver
	 * 
	 * @author lijialong
	 */
	public AndroidDriver<WebElement> appRemoteDriver(String platformName, String platformVersion, String deviceName, String appPackage,
			String appActivity) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("unicodeKeyboard", true);  
	    capabilities.setCapability("resetKeyboard", true);  //重置输入法为系统默认
	    capabilities.setCapability("noReset", true);  //不需要再次安装
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("automationName","uiautomator2");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;
	}
}
