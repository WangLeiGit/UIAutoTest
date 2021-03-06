package com.etyero.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * 记录测试过程
 * 
 * @author lijialong
 */
public class TestNGListener extends TestListenerAdapter {

	private static WebDriver driver;

	LogUtil log = new LogUtil(TestNGListener.class);

	public static void setDriver(WebDriver driver) {
		TestNGListener.driver = driver;
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		log.info("Test Success");
		super.onTestSuccess(tr);
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		log.error("Test Failure");
		super.onTestFailure(tr);
		ScreenShot screenShot = new ScreenShot(driver);
		//获取当前project目录
		String path = System.getProperty("user.dir").replace("\\", "/");
		//加上时间戳以区分截图
		String curTime = TimeUtil.getDate("yyyyMMddHHmmss");
		screenShot.saveScreenShot(path + "/img/", "testFail" + curTime + ".png");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log.error("Test Skipped");
		super.onTestSkipped(tr);
	}

	@Override
	public void onStart(ITestContext testContext) {
		log.info("Test Start");
		super.onStart(testContext);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		log.info("Test Finish");
		super.onFinish(testContext);
	}

}
