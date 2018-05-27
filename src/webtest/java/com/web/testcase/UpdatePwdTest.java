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
import com.web.webaction.UpdatePwd;

/**
 * 修改密码测试类
 * @author lijialong
 * */
@Listeners({ TestNGListener.class })
public class UpdatePwdTest {
	private WebDriver driver;
	private UpdatePwd updatePwd;
	private String pageXml = "page.xml";

	@DataProvider(name = "false_updateParams")
	public Object[][] false_updateParams() {
		return new Object[][] { 
				{ "", "", "", "输入旧密码" }, 
				{ "11", "", "", "密码输入错误，请重新输入" }, 
				{ "111111", "", "", "设置新密码" },
				{ "111111", "12", "", "密码输入错误，请重新输入" }, 
				{ "111111", "123456", "", "重复新密码" },
				{ "111111", "123456", "12", "密码输入错误，请重新输入" },
				{ "111111", "123456", "654321", "两次密码不匹配，请重新输入" },
				{ "111111", "123456", "123456", "旧密码不正确" } 
		};
	}

	@DataProvider(name = "true_updateParams")
	public Object[][] true_updateParams() {
		return new Object[][] { { "123456", "123456", "123456", "密码修改成功" } };
	}

	@BeforeClass
	@Parameters({ "browserType", "browserDriverUrl", "waitTime"})
	public void beforeClass(String browserType, String browserDriverUrl, long waitTime) {
		driver = BrowserUtil.getInstance().getWebDriver(browserType, browserDriverUrl, waitTime);
	}

	@BeforeMethod
	public void BeforeMethod() {
		updatePwd = new UpdatePwd(driver);
		TestNGListener.setDriver(driver);
	}

	@Test(dataProvider = "false_updateParams", description = "以错误信息修改密码", dependsOnMethods = "com.etyero.testcase.LoginTest.login")
	public void errorUpdatePwd(String oldPwd, String newPwd, String repeatPwd, String expectedTip) throws Exception {
		updatePwd.updatePwd(oldPwd, newPwd, repeatPwd);
		String tip = new BasePage(driver, "updatePwdPage", pageXml).getAlertText();
		Assert.assertEquals(tip, expectedTip);
	}

	@Test(dataProvider = "true_updateParams", description = "以正确的信息修改密码", dependsOnMethods = "errorUpdatePwd")
	public void updatePwd(String oldPwd, String newPwd, String repeatPwd, String expectedTip) throws Exception {
		updatePwd.updatePwd(oldPwd, newPwd, repeatPwd);
		String tip = new BasePage(driver, "updatePwdPage", pageXml).getAlertText();
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
