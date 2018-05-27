package com.web.testcase;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CSDN {
	private WebDriver driver;
	private String baseUrl = "http://blog.csdn.net/u010798968";
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {
		String browserDriverUrl = "E:/eclipseWorkSpace/webUITestPro/browserDriver/chromedriver.exe";// 浏览器驱动路径
		// 启动chrome浏览器
		System.setProperty("webdriver.chrome.driver", browserDriverUrl);
		driver = new ChromeDriver();
		driver.manage().window().maximize();// 最大化浏览器
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 设置操作超时时长，该设置是全局性的，即所有操作都最长等待30s

	}

	@Test
	/**
	 * 刷阅读量
	 * 
	 */
	public void testLogin() throws Exception {
		while (true) {
			String[] url = {"http://blog.csdn.net/u010798968/article/details/76674434",
			"http://blog.csdn.net/u010798968/article/details/76451647",
			"http://blog.csdn.net/u010798968/article/details/76215445",
			"http://blog.csdn.net/u010798968/article/details/76172855",
			"http://blog.csdn.net/u010798968/article/details/76130860",
			"http://blog.csdn.net/u010798968/article/details/76034803",
			"http://blog.csdn.net/u010798968/article/details/75212693",
			"http://blog.csdn.net/u010798968/article/details/74932124",
			"http://blog.csdn.net/u010798968/article/details/74909807",
			"http://blog.csdn.net/u010798968/article/details/74066392",
			"http://blog.csdn.net/u010798968/article/details/74065238",
			"http://blog.csdn.net/u010798968/article/details/72869392",
			"http://blog.csdn.net/u010798968/article/details/72846166",
			"http://blog.csdn.net/u010798968/article/details/72867690"
			};
			for(String urlTemp:url){
				driver.get(urlTemp);
				Thread.sleep(20000);
			}
			//每半小时跑一次
			Thread.sleep(15 * 60 * 1000);
		}
	}
    
	/**
	 * 刷阅读量
	 * 
	 */
	@Test(enabled = false)
	public void testLogin02() throws Exception {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				driver.get(baseUrl);
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("link_title")));
				List<WebElement> elements = driver.findElements(By.className("link_title"));
				System.out.println("elements.size()=" + elements.size());
				for (int i = 0; i < elements.size(); i++) {
					elements.get(i).click();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.navigate().back();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		};
		Timer timer = new Timer();
		long delay = 0;
		long timePeriod = 1 * 60 * 1000;
		timer.scheduleAtFixedRate(task, delay, timePeriod);
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
