package com.appium.appaction;

import org.openqa.selenium.WebDriver;

import com.etyero.object.BasePage;

public class Login {
	private WebDriver driver;
	private String pageXml = "neighborPage.xml";

	public Login(WebDriver driver) {
		this.driver = driver;
	}
    
	/**
	 * 登录操作
	 * @author lijialong
	 * */
	public boolean login(String userName,String pwd,String exceptTip) throws Exception {
		if (isLogined()) {
			new BasePage(driver, "myPage", pageXml).click("设置");
			BasePage setUpPage = new BasePage(driver, "setUpPage", pageXml);
			setUpPage.appSwipeUp(0, 1);
			setUpPage.click("退出登录"); 
		}
		BasePage loginPage = new BasePage(driver, "loginPage", pageXml);
		loginPage.sendKey("手机号码", userName);
		loginPage.sendKey("密码", pwd);
		//loginPage.appTapByXY(1, 985, 1800, 0);
		loginPage.click("登录");
		loginPage.getToastText(exceptTip, 10);
		return isLogined();
	}
	
	/**
	 * 判断是否登录
	 * 
	 * @author lijialong
	 */
	public boolean isLogined() throws Exception {
		BasePage loginPage = new BasePage(driver, "loginPage", pageXml);
		boolean flag = !loginPage.isElementExist("登录");
		return flag;
	}
}
