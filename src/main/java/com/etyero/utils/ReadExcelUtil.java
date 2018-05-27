package com.etyero.utils;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * excel读取类，用于读取excel数据
 * @author lijialong
 *
 */
public class ReadExcelUtil {
	/**
	 * 指定开始及结束行，开始及结束列
	 * @param sheet_id 工作表下标，0开始
	 * @param start_row 开始行，0开始
	 * @param end_row 结束行，0开始
	 * @param start_col 开始列，0开始
	 * @param end_col 结束列，0开始
	 * @param sourcefile .xls文件路径
	 * @return Object[][]
	 */
	public static Object[][] case_data_excel(int sheet_id, int start_row, int end_row, int start_col, int end_col,String sourcefile) {
		String cell_value = null;
		Cell cell = null;
		int rowLength = end_row - start_row + 1;
		int colLength = end_col - start_col + 1;
		String[][] testcase_data_array = new String[rowLength][colLength];
		Workbook testcase_data_workbook = null;
		try {

			testcase_data_workbook = Workbook.getWorkbook(new File(sourcefile));
			Sheet testcase_data_sheet = testcase_data_workbook.getSheet(sheet_id);
			// 外循环行数
			for (int row = start_row, i = 0; row <= end_row || i < rowLength; row++, i++) {
				//内循环列数
				for (int col = start_col, j = 0; col <= end_col || j < colLength; col++, j++) {
					cell = testcase_data_sheet.getCell(col, row);
					cell_value = cell.getContents();
					testcase_data_array[i][j] = cell_value;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Object[][] testcase_data_object = (Object[][]) testcase_data_array;
		return testcase_data_object;

	}

	/**
	 * 读取所有数据不带行列范围
	 * @param sheet_id 工作表下标，从0开始
	 * @param sourcefile .xls文件路径
	 * @return Object[][]
	 */
	public static Object[][] case_data_excel(int sheet_id, String sourcefile) {
		String cell_value = null;
		Cell cell = null;
		String[][] testcase_data_array = null;
		Workbook testcase_data_workbook = null;
		try {
			testcase_data_workbook = Workbook.getWorkbook(new File(sourcefile));
			Sheet testcase_data_sheet = testcase_data_workbook.getSheet(sheet_id);
			int rows = testcase_data_sheet.getRows();
			int cols = testcase_data_sheet.getColumns();
			testcase_data_array = new String[rows][cols];
			// 获取每行用例数据
			for (int i = 0;  i < rows; i++) {
				for (int j = 0;  j < cols; j++) {
					cell = testcase_data_sheet.getCell(j, i);
					cell_value = cell.getContents();
					testcase_data_array[i][j] = cell_value;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object[][] testcase_data_object = (Object[][]) testcase_data_array;
		return testcase_data_object;
	}
//	public static void main(String[] args) {
//		String filePath = "E:/test.xls";
//		Object[][] excel = ReadExcelUtil.case_data_excel(1, 1, 2, 2, 3, filePath);
//		for (int i = 0; i < excel.length; i++) {
//			Object[] excel2 = excel[i];
//			for (int j = 0; j < excel2.length; j++) {
//				System.out.println(excel2[j]);
//			}
//		}
//		Object[][] excel22 = ReadExcelUtil.case_data_excel(1, filePath);
//		for (int i = 0; i < excel22.length; i++) {
//			Object[] excel2 = excel22[i];
//			for (int j = 0; j < excel2.length; j++) {
//				System.out.println(excel2[j]);
//			}
//		}
//	}
}
