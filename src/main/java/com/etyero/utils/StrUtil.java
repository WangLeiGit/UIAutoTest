package com.etyero.utils;

/**
 * String工具类
 * 
 * @author lijialong
 */
public class StrUtil {
	public static boolean isNotNull(String str) {
		boolean flag = false;
		if (str != null && !str.equals("")) {
			flag = true;
		}
		return flag;
	}
}
