package com.web.testcase;

import java.util.LinkedHashMap;
import java.util.Map;

public class Mytest {

	public static void main(String[] args) {
	Map<String, Integer> map = new LinkedHashMap<>();
	map.put("分区下拉", 0);
	map.put("分区下拉项", 24);
	for(Map.Entry<String, Integer> str : map.entrySet()){
		System.out.println(str.getKey() + " >> " + str.getValue());
	}
	}
}
