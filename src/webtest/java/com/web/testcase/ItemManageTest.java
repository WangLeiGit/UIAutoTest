package com.web.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import com.web.mapper.BuildingsDao;
import com.web.mapper.BuildingsDaoImpl;
import com.web.mapper.DoorControlLocationDao;
import com.web.mapper.DoorControlLocationDaoImpl;
import com.web.mapper.RoomsDao;
import com.web.mapper.RoomsDaoImpl;
import com.web.mapper.SegmentsDao;
import com.web.mapper.SegmentsDaoImpl;
import com.web.mapper.UnitsDao;
import com.web.mapper.UnitsDaoImpl;
import com.web.webaction.ItemManage;

/**
 * 设备管理测试类
 * 
 * @author lijialong
 */
@Listeners({ TestNGListener.class })
public class ItemManageTest {
	private WebDriver driver;
	private ItemManage itemManage;
	private String pageXml = "page.xml";
    private String[] itemName={"分区测试","分区测试-楼栋","分区测试-楼栋-单元","分区测试-楼栋-单元-门牌号"};

	@DataProvider(name = "addComunity")
	public Object[][] addComunity() {
		int[][] equipmentIndex_Count = { { 2, 1 }, { 3, 2 } };
		return new Object[][] { { itemName[0], "分区测试别名", equipmentIndex_Count, 0, "分区添加成功" } };
	}

	@DataProvider(name = "addBuilding")
	public Object[][] addBuilding() {
		int[][] equipmentIndex_Count = { { 1, 1 } };
		return new Object[][] { { itemName[1], "分区测试-楼栋别名", equipmentIndex_Count, 0, "楼栋添加成功" } };
	}

	@DataProvider(name = "addUnit")
	public Object[][] addUnit() {
		int[][] equipmentIndex_Count = { { 1, 1 } };
		return new Object[][] { { itemName[2], "分区测试-楼栋别名-单元别名", equipmentIndex_Count, 0, "单元添加成功" } };
	}

	@DataProvider(name = "addDoor")
	public Object[][] addDoor() {
		return new Object[][] { { itemName[3], "分区测试-楼栋别名-单元别名-门牌号别名", 0, "门牌添加成功" } };
	}

	@BeforeClass
	@Parameters({ "browserType", "browserDriverUrl", "waitTime", "url" })
	public void beforeClass(String browserType, String browserDriverUrl, long waitTime, String url) {
		driver = BrowserUtil.getInstance().getWebDriver(browserType, browserDriverUrl, waitTime);
		driver.get(url);
	}

	@BeforeMethod
	public void BeforeMethod() {
		itemManage = new ItemManage(driver);
		TestNGListener.setDriver(driver);
	}

	@Test(dataProvider = "addComunity", description = "添加分区测试")
	public void addComunity(String name, String otherName, int[][] equipmentIndex_Count, int saveflag,String exceptedTip) throws Exception {
		
		new BasePage(driver, "mainPage",pageXml).click("设备管理");
		
		new BasePage(driver, "itemManagePage",pageXml).click("添加分区");
		
		String tip = itemManage.edit(name, otherName, equipmentIndex_Count, saveflag);
		Assert.assertEquals(tip, exceptedTip);
	}

	@Test(dataProvider = "addBuilding", description = "分区添加楼栋测试")
	public void addBuilding(String name, String otherName, int[][] equipmentIndex_Count, int saveflag,String exceptedTip) throws Exception {
		
		new BasePage(driver, "mainPage",pageXml).click("设备管理");
		
		BasePage itemManagePage = new BasePage(driver, "itemManagePage",pageXml);
		int index = itemManagePage.getElements("分区列表").size() - 1;
		itemManagePage.click("分区列表", index);
		
		new BasePage(driver, "item_Partition_ManagePage",pageXml).click("添加楼栋");
		
		String tip = itemManage.edit(name, otherName, equipmentIndex_Count, saveflag);
		Assert.assertEquals(tip, exceptedTip);
	}

	@Test(dataProvider = "addUnit", description = "分区-楼栋添加单元测试")
	public void addUnit(String name, String otherName, int[][] equipmentIndex_Count, int saveflag, String exceptedTip)throws Exception {
		
		new BasePage(driver, "mainPage",pageXml).click("设备管理");
		
		BasePage itemManagePage = new BasePage(driver, "itemManagePage",pageXml);
		int comunityIndex = itemManagePage.getElements("分区列表").size() - 1;
		itemManagePage.click("分区列表", comunityIndex);
		
		BasePage item_Partition_ManagePage = new BasePage(driver, "item_Partition_ManagePage",pageXml);
		int buildingIndex = item_Partition_ManagePage.getElements("楼栋列表").size() - 1;
		item_Partition_ManagePage.click("楼栋列表", buildingIndex);
		
		new BasePage(driver, "item_Partition_building_ManagePage",pageXml).click("添加单元");
		
		String tip = itemManage.edit(name, otherName, equipmentIndex_Count, saveflag);
		Assert.assertEquals(tip, exceptedTip);
	}

	@Test(dataProvider = "addDoor", description = "分区-楼栋-单元添加门牌测试")
	public void addDoor(String name, String otherName, int saveflag, String exceptedTip)throws Exception {
		
		new BasePage(driver, "mainPage",pageXml).click("设备管理");
		
		BasePage itemManagePage = new BasePage(driver, "itemManagePage",pageXml);
		int comunityIndex = itemManagePage.getElements("分区列表").size() - 1;
		itemManagePage.click("分区列表", comunityIndex);
		
		BasePage item_Partition_ManagePage = new BasePage(driver, "item_Partition_ManagePage",pageXml);
		int buildingIndex = item_Partition_ManagePage.getElements("楼栋列表").size() - 1;
		item_Partition_ManagePage.click("楼栋列表", buildingIndex);
		
		BasePage item_Partition_building_unit_ManagePage = new BasePage(driver, "item_Partition_building_ManagePage",pageXml);
		int unitIndex = item_Partition_building_unit_ManagePage.getElements("单元列表").size() -1;
		item_Partition_building_unit_ManagePage.click("单元列表", unitIndex);
		
		new BasePage(driver, "item_Partition_building_unit_ManagePage",pageXml).click("添加门牌号");
		
		String tip = itemManage.edit(name, otherName, null, saveflag);
		Assert.assertEquals(tip, exceptedTip);
	}
 	
	/**
	 * 清理新增的数据
	 * 
	 */
	@AfterClass
	public void afterClass() {
		// 清理分区及分区设备数据
		SegmentsDao sDao = new SegmentsDaoImpl();
		String location_uuid = sDao.selectByName(itemName[0], "").get(0).getUuid();
		sDao.deleteByName(itemName[0]);
		DoorControlLocationDao dLocationDao = new DoorControlLocationDaoImpl();
		dLocationDao.deleteByLocationUuid(location_uuid);
		// 清理楼栋及楼栋设备数据
		BuildingsDao bDao = new BuildingsDaoImpl();
		location_uuid = bDao.selectByName(itemName[1], "").get(0).getUuid();
		bDao.deleteByName(itemName[1]);
		dLocationDao.deleteByLocationUuid(location_uuid);
		// 清理单元及单元设备数据
		UnitsDao uDao = new UnitsDaoImpl();
		location_uuid = uDao.selectByName(itemName[2], "").get(0).getUuid();
		uDao.deleteByName(itemName[2]);
		dLocationDao.deleteByLocationUuid(location_uuid);
		// 清理门牌数据
		RoomsDao rDao = new RoomsDaoImpl();
		rDao.deleteByName(itemName[3]);
	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
	}
}
