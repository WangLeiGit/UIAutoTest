package com.appium.testcase;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.etyero.utils.UIExecutorImpl;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppiumDemo {
//	private WebDriver driver;
	private AppiumDriver<WebElement> driver;

	@Before
	public void setUp() throws Exception {
//		File classpathRoot = new File(System.getProperty("user.dir"));
//		File appDir = new File(classpathRoot, "apk");
//		System.out.println("classpathRoot--" + classpathRoot);
//		File app = new File(appDir, "app-release.apk"); //
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("deviceName", "F8UDU15526003170");
//		capabilities.setCapability("app", app.getAbsolutePath());
//		capabilities.setCapability("unicodeKeyboard", true);  
//	    capabilities.setCapability("resetKeyboard", true);  //重置输入法为系统默认
	    capabilities.setCapability("noReset", true);  //不需要再次安装
		capabilities.setCapability("appPackage", "com.neighbor");
		capabilities.setCapability("appActivity", ".activity.LoadingActivity");
		capabilities.setCapability("automationName","uiautomator2");
		capabilities.setCapability("newCommandTimeout", 120);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("app启动成功"); 
		System.out.println("newCommandTimeout="+capabilities.getCapability("newCommandTimeout"));
	}

	@Test
	public void addContact() throws InterruptedException {
		System.out.println("分辨率为：" + driver.manage().window().getSize().height + "x" + driver.manage().window().getSize().width);
		driver.findElement(By.id("com.neighbor:id/main_bottom_mine_rb")).click();
		driver.findElement(By.id("com.neighbor:id/et_phone")).sendKeys("123");
		System.out.println(driver.findElements(By.id("com.neighbor:id/et_password")).size());
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("com.neighbor:id/et_password"));
		element.sendKeys("000");
		System.out.println("size="+driver.findElements(By.className("android.widget.TextView")).size());
        driver.findElement(By.className("android.widget.TextView")).click();
        System.out.println(new UIExecutorImpl(driver).getToastText("手机号码不能为空", 20));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
