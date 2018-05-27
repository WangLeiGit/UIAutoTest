package com.web.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.etyero.object.BasePage;
import com.etyero.utils.BrowserUtil;
import com.etyero.utils.TestNGListener;
import com.web.webaction.Login;

/**
 * 登录测试类
 * @author lijialong
 * */
@Listeners({ TestNGListener.class })
public class LoginTest {
	private WebDriver driver;
	private Login login;
    private String pageXml = "page.xml";
	@DataProvider(name = "false_loginParams")
	public Object[][] false_loginParams() {
		return new Object[][] { { "", "", "输入手机号码" },
			                    { "88888888888", "", "输入登录密码" },
				                { "88888888888", "111111", "该用户不存在或密码不正确" } 
		};
	}

	@DataProvider(name = "true_loginParams")
	public Object[][] true_loginParams() {
		return new Object[][] { { "88888888888", "123456", "当前社区：贵阳·宏立城·花果园" } };
	}

	@BeforeClass
	@Parameters({ "browserType","browserDriverUrl","waitTime", "url" })
	public void beforeClass(String browserType, String browserDriverUrl, long waitTime, String url) {
		driver = BrowserUtil.getInstance().getWebDriver(browserType, browserDriverUrl, waitTime);
		driver.get(url);
	}

	@BeforeMethod
	public void BeforeMethod() {
		login = new Login(driver);
		TestNGListener.setDriver(driver);
	}

	@Test(dataProvider = "false_loginParams", description = "错误的用户信息登录", enabled = false)
	public void errorLogin(String username, String pwd, String expectedTip) throws Exception {
		login.login(username, pwd);
		String tip = new BasePage(driver, "loginPage", pageXml).getAlertText();
		Assert.assertEquals(tip, expectedTip);
	}

	@Test(dataProvider = "true_loginParams", description = "正确的用户信息登录")
	public void login(String username, String pwd, String expectedTip) throws Exception {
		login.login(username, pwd);
		String tip = new BasePage(driver, "userPage", pageXml).getText("当前社区");
		Assert.assertEquals(tip, expectedTip);
	}

	@AfterClass
	public void afterClass() {
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
