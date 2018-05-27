package com.web.webaction;

import org.openqa.selenium.WebDriver;

import com.etyero.object.BasePage;

/**
 * 用户修改密码
 * 
 * @author lijialong
 */
public class UpdatePwd {
	private WebDriver driver;

	public UpdatePwd(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 修改密码
	 * 
	 * @author lijialong
	 */
	public void updatePwd(String oldPwd, String newPwd, String repeatPwd) throws Exception {
		BasePage userPage = new BasePage(driver, "userPage","page.xml");
		BasePage updatePwdPage = new BasePage(driver, "updatePwdPage","page.xml");
		if (updatePwdPage.isElementExist("保存")) {
			updatePwdPage.click("取消");
		}
		userPage.click("用户头像");
		userPage.click("修改密码");
		updatePwdPage.sendKey("输入旧密码", oldPwd);
		updatePwdPage.sendKey("设置新密码", newPwd);
		updatePwdPage.sendKey("重复新密码", repeatPwd);
		updatePwdPage.click("保存");
	}
}
