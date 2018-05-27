package com.web.webaction;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.appium.entity.YlNcRelation;
import com.etyero.object.BasePage;
import com.etyero.utils.StrUtil;

public class PropertyPayManage {
	private WebDriver driver;

	public PropertyPayManage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 物业缴费记录查询
	 * 
	 * @author lijialong
	 * @param startTime 查询开始时间
	 * @param endTime 查询结束时间
	 * @param segment 分区名称
	 * @param building 楼栋名称
	 * @param door 门牌号
	 * @param status 状态
	 * @param number 订单号||手机号
	 * @throws Exception
	 */
	public List<YlNcRelation>  searchPayMent(String startTime,String endTime,String segment,String building,String door,String status,String number) throws Exception {
		Thread.sleep(5000);
		BasePage propertyPayManagePage = new BasePage(driver, "propertyPayManagePage","page.xml");
		propertyPayManagePage.jsExecutor(
				 "document.getElementById('startDate').setAttribute('type','text');"
				 +"document.getElementById('endDate').setAttribute('type','text')"
				);
		propertyPayManagePage.sendKey("查询开始时间", startTime);
		propertyPayManagePage.sendKey("查询结束时间", endTime);
		// 选择分区
		if (StrUtil.isNotNull(segment)) {
			selectCondition(propertyPayManagePage, "显示分区", "分区下拉项", "分区下拉", segment);
			// 选择楼栋
			if (StrUtil.isNotNull(building)) {
				selectCondition(propertyPayManagePage, "显示楼栋", "楼栋下拉项", "楼栋下拉", building);
				// 选择门牌号
				if (StrUtil.isNotNull(door)) {
					selectCondition(propertyPayManagePage, "显示门牌号", "门牌下拉项", "门牌下拉", door);
				}
			}
		}

		// 选择状态
		if (StrUtil.isNotNull(status)) {
			selectCondition(propertyPayManagePage, "显示状态", "状态下拉项", "状态下拉", status);
		}

		// 输入手机号||订单号
		propertyPayManagePage.sendKey("订单/手机号", number);
		propertyPayManagePage.click("查询");
		
		Thread.sleep(3000);//停顿3s，速度太快会导致元素获取后过期，无法正常使用元素的一系列api进行操作
		List<YlNcRelation> ylNcRelations = new ArrayList<>();
		YlNcRelation order = null;
		List<WebElement> rowElements = propertyPayManagePage.getElements("订单列表");
		Map<String, Integer> locatorName_indexs = new LinkedHashMap<>();
		for (int i = 1; i < rowElements.size(); i++) {
			locatorName_indexs.put("订单列表", i);
			locatorName_indexs.put("订单信息", null);
			List<WebElement> columnElements = propertyPayManagePage.getLevelElements(locatorName_indexs);
			order = new YlNcRelation();
			order.setDocno(columnElements.get(0).getText());
			order.setDoc_reamt(Double.parseDouble(columnElements.get(4).getText()));
			order.setDoc_netamt(Double.parseDouble(columnElements.get(5).getText()));
			ylNcRelations.add(order);
		}
		return ylNcRelations;
	}
	
	/**
	 * 根据名称找到对应的下拉项的下标
	 * @author lijialong
	 * @param name 要匹配的名称
	 * */
	private int getIndex(List<WebElement> elements, String name) {
		int index = 0;
		for (int i = 0; i < elements.size(); i++) {
			if (name.equals(elements.get(i).getText())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * 选择下拉项
	 * 
	 * @author lijialong
	 * @param str1
	 *            点击显示下拉
	 * @param str2
	 *            下拉项
	 * @param str3
	 *            下拉框
	 * @param key
	 *            要选择的下拉项
	 * @throws Exception 
	 */
	private void selectCondition(BasePage page, String str1, String str2, String str3, String key) throws Exception {
		page.click(str1);
		Map<String, Integer> locatorName_indexs = new LinkedHashMap<>();
		locatorName_indexs.put(str3, 0);
		locatorName_indexs.put(str2, null);
		List<WebElement> elements = page.getLevelElements(locatorName_indexs);
		int index = getIndex(elements, key);
		elements.get(index).click();
		locatorName_indexs.clear();
	}
}
