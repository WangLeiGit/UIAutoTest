package com.appium.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appium.appaction.Login;
import com.etyero.object.BasePage;
import com.etyero.utils.AppDriverUtil;
import com.etyero.utils.TestNGListener;

/**
 * 登录测试类
 * 
 * @author lijialong
 */
@Listeners({ TestNGListener.class })
public class LoginTest {
	private WebDriver driver;
	private Login login;
	private String pageXml = "neighborPage.xml";

	@DataProvider(name = "loginParams")
	public Object[][] loginParams() {
		return new Object[][] { { "18503086491", "123456" } };
	}

	@DataProvider(name = "errorLoginParams")
	public Object[][] errorLoginParams() {
		return new Object[][] { { "", "", "手机号码不能为空" }, { "18503086491", "", "密码不能为空" },
				{ "18503086491", "1234567", "用户名或密码错误" }, };
	}

	@BeforeClass
	@Parameters({ "apkName", "platformName", "platformVersion", "deviceName", "appPackage", "appActivity" })
	public void beforeClass(String apkName, String platformName, String platformVersion, String deviceName,
			String appPackage, String appActivity) throws Exception {
		driver = AppDriverUtil.getInstance().getAppDriver(apkName, platformName, platformVersion, deviceName, appPackage, appActivity);
		login = new Login(driver);
		TestNGListener.setDriver(driver);
		new BasePage(driver, "mainPage", pageXml).click("我的");
	}

	@Test(dataProvider = "errorLoginParams", description = "错误用户信息登录")
	public void errorLogin(String userName, String pwd, String exceptTip) throws Exception {
		Assert.assertEquals(false, login.login(userName, pwd, exceptTip));
	}

	@Test(dataProvider = "loginParams", dependsOnMethods = "errorLogin", description = "正常用户信息登录")
	public void login(String userName, String pwd, String exceptTip) throws Exception {
		Assert.assertEquals(true, login.login(userName, pwd, exceptTip));
	}

	@AfterClass
	public void afterClass() {

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
