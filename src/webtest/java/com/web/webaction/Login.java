package com.web.webaction;

import org.openqa.selenium.WebDriver;

import com.etyero.object.BasePage;

public class Login {
	private WebDriver driver;
	private String pageXml = "page.xml";

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 登录操作
	 * 
	 * @author lijialong
	 */
	public void login(String username, String pwd) throws Exception {
		BasePage loginPage = new BasePage(driver, "loginPage", pageXml);
		cancelLogin();
		loginPage.click("登录入口");
		loginPage.sendKey("登录输入账号框", username);
		loginPage.sendKey("登录输入密码框", pwd);
		loginPage.click("登录");
	}

	/**
	 * 取消登录
	 * 
	 * @author lijialong
	 * @throws Exception
	 */
	public void cancelLogin() throws Exception {
		BasePage loginPage = new BasePage(driver, "loginPage", pageXml);
		boolean flag = loginPage.isElementExist("登录");
		if (flag) {
			loginPage.click("取消");
		}
	}

	/**
	 * 判断是否登录，已登录则退出登录
	 * 
	 * @author lijialong
	 */
	public void isLogined() throws Exception {
		BasePage userPage = new BasePage(driver, "userPage", pageXml);
		boolean flag = userPage.isElementExist("当前社区");
		if (flag) {
			userPage.click("用户头像");
			userPage.click("退出登录");
		}
	}
}
