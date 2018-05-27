package com.etyero.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserUtil {
	private WebDriver driver;
	private static BrowserUtil browserUtil = null;

	/**
	 * 使用单例模式，只启用一个流浏览器
	 * 
	 */
	private BrowserUtil() {
	}

	public static synchronized BrowserUtil getInstance() {
		if (browserUtil == null) {
			browserUtil = new BrowserUtil();
		}
		return browserUtil;
	}

	/**
	 * 按需启动浏览器并获取其driver
	 * 
	 * @author lijialong
	 */
	public WebDriver getWebDriver(String browser, String browserDriverUrl, long sec) {
		if (getDriver() == null) {
			switch (browser) {
			case "ie":
				driver = ie(browserDriverUrl, sec);
				break;
			case "chrome":
				driver = chrome(browserDriverUrl, sec);
				break;
			case "firefox":
				driver = fireFox(browserDriverUrl, sec);
				break;
			default:
				driver = htmlUnitDriver(sec);
				break;
			}
			setDriver(driver);
		}
		return getDriver();
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * 启动ie浏览器
	 * 
	 * @param browserDriverUrl
	 *            浏览器驱动url
	 * @param sec
	 *            所以页面操作的等待超时时长，此处为隐式等待，超时后找不到元素则抛出异常NoSuchElementException
	 * @author lijialong
	 */
	public WebDriver ie(String browserDriverUrl, long sec) {
		System.setProperty("webdriver.ie.driver", browserDriverUrl);
		// 关闭IE保护模式
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver = new InternetExplorerDriver(ieCapabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * 启动chrome浏览器
	 * 
	 * @param browserDriverUrl
	 *            浏览器驱动url
	 * @param sec
	 *            所以页面操作的等待超时时长
	 * @author lijialong
	 */
	public WebDriver chrome(String browserDriverUrl, long sec) {
		System.setProperty("webdriver.chrome.driver", browserDriverUrl);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * 启动fireFox浏览器
	 * 
	 * @param browserDriverUrl
	 *            浏览器驱动url
	 * @param sec
	 *            所有页面操作的等待超时时长
	 * @author lijialong
	 */
	public WebDriver fireFox(String browserDriverUrl, long sec) {
		System.setProperty("webdriver.firefox.bin", browserDriverUrl);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * 启动htmlUnitDriver,不会打开实际游览器，运行速度快 但当页面有复杂js时，会定位不到元素，不建议使用
	 * 
	 * @author lijialong
	 */
	public WebDriver htmlUnitDriver(long sec) {
		driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		return driver;
	}
	
}
