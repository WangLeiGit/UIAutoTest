package com.appium.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appium.appaction.LifePropertyPayManage;
import com.appium.mapper.YlNcRelationDao;
import com.appium.mapper.YlNcRelationDaoImpl;
import com.etyero.utils.AppDriverUtil;
import com.etyero.utils.TestNGListener;

/**
 * app物业缴费测试类
 * 
 * @author lijialong
 */
@Listeners({ TestNGListener.class })
public class LifePropertyPayManageTest {
	private WebDriver driver;
	private LifePropertyPayManage lifePropertyPayManage;


	@BeforeClass
	@Parameters({ "apkName", "platformName", "platformVersion", "deviceName", "appPackage", "appActivity" })
	public void beforeClass(String apkName, String platformName, String platformVersion, String deviceName,
			String appPackage, String appActivity) {
		driver = AppDriverUtil.getInstance().getAppDriver(apkName, platformName, platformVersion, deviceName,appPackage, appActivity);
	}

	@BeforeMethod
	public void BeforeMethod() {
		lifePropertyPayManage = new LifePropertyPayManage(driver);
		TestNGListener.setDriver(driver);
	}

	@Test(description = "缴费")
	public void propertyPay() throws Exception {
		YlNcRelationDao yDao = new YlNcRelationDaoImpl();
		String userId = "c5404254-3b79-48a1-a0f1-c789aab9eda9";
		int count = yDao.countYlNcRelation(userId);
		lifePropertyPayManage.propertyPay();
		int countAfter = yDao.countYlNcRelation(userId);
		Assert.assertEquals(count, countAfter - 1);
	}

	@AfterClass
	public void afterClass() {

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
