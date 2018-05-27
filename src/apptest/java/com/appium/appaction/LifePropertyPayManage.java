package com.appium.appaction;

import org.openqa.selenium.WebDriver;

import com.etyero.object.BasePage;

/**
 * 生活模块的物业缴费操作类
 * 
 * @author lijialong
 */
public class LifePropertyPayManage {
	private WebDriver driver;
	private String pageXml = "neighborPage.xml";

	public LifePropertyPayManage(WebDriver driver) {
		this.driver = driver;
	}

	public void propertyPay() throws Exception {
		new BasePage(driver, "mainPage", pageXml).click("生活");
		new BasePage(driver, "lifePage", pageXml).click("物业缴费");
		BasePage lifePage = new BasePage(driver, "propertyPayPage", pageXml);
		lifePage.appTapByXY(1, 500, 1560, 0);//同意协议
		lifePage.click("选择缴费房屋", 0);
		lifePage.click("进入缴费");
		lifePage.click("生成付款单");
	}
}
