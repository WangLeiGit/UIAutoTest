package com.web.webaction;

import org.openqa.selenium.WebDriver;

import com.etyero.object.BasePage;


public class ItemManage {
	private WebDriver driver;

	public ItemManage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 编辑分区||楼栋||单元||门牌号
	 * 
	 * @param name
	 *            名称
	 * @param otherName
	 *            别名
	 * @param equipmentIndex_Count
	 *            要添加的设备及设备数
	 * @param saveFlag
	 *            0为普通保存，非0为无分区||楼栋保存
	 * @author lijialong
	 * @throws Exception
	 * @return String(弹框内容)
	 */
	public String edit(String name, String otherName, int[][] equipmentIndex_Count, int saveflag) throws Exception {
		BasePage editPage = new BasePage(driver, "editPage","page.xml");
		editPage.sendKey("名称", name);
		editPage.sendKey("别名", otherName);
		if (equipmentIndex_Count != null && equipmentIndex_Count.length > 0) {
			editPage.click("添加设备");
			for (int i = 0; i < equipmentIndex_Count.length; i++) {
				for (int j = 0; j < equipmentIndex_Count[i].length - 1; j++) {
					int index = equipmentIndex_Count[i][j];
					String count = equipmentIndex_Count[i][j + 1] + "";
					switch (index) {
					case 1:
						editPage.click("勾选门禁1");
						editPage.sendKey("门禁1数量", count);
						break;
					case 2:
						editPage.click("勾选门禁2");
						editPage.sendKey("门禁2数量", count);
						break;
					case 3:
						editPage.click("勾选门禁对讲机");
						editPage.sendKey("门禁对讲机数量", count);
						break;
					case 4:
						editPage.click("勾选门锁");
						editPage.sendKey("门锁数量", count);
						break;
					default:
						break;
					}
				}
			}
			editPage.click("提交设备");
		}
		if (saveflag == 0) {
			editPage.click("保存");
		} else {
			editPage.click("无分区||楼栋保存");
		}
		String tip = editPage.getAlertText();
		//页面复位，回到首页
		editPage.click("首页");
		return tip;
	}
}
