package com.web.testcase;

import org.openqa.selenium.WebDriver;
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
import com.web.webaction.PropertyPayManage;

/**
 * 物业缴费管理测试类
 * @author lijialong
 * */
@Listeners({ TestNGListener.class })
public class PropertyPayManageTest {
	private WebDriver driver;
	private PropertyPayManage propertyPayManage;
    private String pageXml = "page.xml";
	@DataProvider(name = "params")
	public Object[][] params() {
		return new Object[][] { { "2017-07-25", "2017-07-26", "U区", "9栋", "1单元3205", "", "18813866764" }};
	}

	@BeforeClass
	@Parameters({ "browserType","browserDriverUrl","waitTime", "url" })
	public void beforeClass(String browserType, String browserDriverUrl, long waitTime, String url) {
		driver = BrowserUtil.getInstance().getWebDriver(browserType, browserDriverUrl, waitTime);
		driver.get(url);
	}

	@BeforeMethod
	public void BeforeMethod() {
		propertyPayManage = new PropertyPayManage(driver);
		TestNGListener.setDriver(driver);
	}

	@Test(dataProvider = "params", description = "查找缴费记录")
	public void searchPayMent(String startTime,String endTime,String segment,String building,String door,String status,String number) throws Exception {
		new BasePage(driver, "mainPage", pageXml).click("物业缴费管理");
		propertyPayManage.searchPayMent(startTime, endTime, segment, building, door, status, number);
	}


	@AfterClass
	public void afterClass() {
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
