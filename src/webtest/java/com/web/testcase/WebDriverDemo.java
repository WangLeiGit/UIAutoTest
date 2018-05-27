package com.web.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverDemo {
	private WebDriver driver;
	private String baseUrl = "http://58.42.231.231:59193/zmkmglYl//index.jsp";
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {
		String browserDriverUrl = "E:/eclipseWorkSpace/webUITestPro/browserDriver/chromedriver.exe";// 浏览器驱动路径
		//启动chrome浏览器
		System.setProperty("webdriver.chrome.driver", browserDriverUrl);
		driver = new ChromeDriver();
		driver.manage().window().maximize();// 最大化浏览器
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//设置操作超时时长，该设置是全局性的，即所有操作都最长等待30s

	}

	@Test
	/**
	 * 搜索selenium
	 * 
	 * */
	public void testLogin() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("headLogin")).click();
		driver.findElement(By.id("username_id")).sendKeys("88888888888");
		driver.findElement(By.id("password_id")).sendKeys("123456");
		driver.findElement(By.id("dialog_tijiao")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[10]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("btn")).click();
		System.out.println(driver.findElements(By.tagName("tr")).size());
		System.out.println(driver.findElements(By.tagName("tr")).get(1).findElements(By.tagName("td")).size());
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}
