package com.web.webaction;

import org.openqa.selenium.WebDriver;

import com.etyero.object.BasePage;

public class ChangeCommunity {
	private WebDriver driver;

	public ChangeCommunity(WebDriver driver) {
		this.driver = driver;
	}
    
	/**
	 * 切换社区
	 * @author lijialong
	 * */
	public void changeComunity() throws Exception {
		BasePage mainPage = new BasePage(driver, "mainPage","page.xml");
		mainPage.click("设备管理");
        
	}
}
