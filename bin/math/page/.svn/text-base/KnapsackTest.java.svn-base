/*
 * Copyright (C) 2013 Open Source Project
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * # * KnapsackTest.java Create on 2013-11-22 上午11:26:24
 * # * project Test
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：KnapsackTest.java
 * 版本信息：
 * 日期：2013-11-22
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package math.page;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-22 上午11:26:24
 *          类说明
 */
/**
 * 项目名称：Test
 * 类名称：KnapsackTest
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-22 上午11:26:24
 * 修改人：David.Yang
 * 修改时间：2013-11-22 上午11:26:24
 * 修改备注：
 * 
 * @version
 */
public class KnapsackTest {
	public static void main(String[] args) throws InvalidFormatException,
	        IOException {
		test3();
	}
	
	public static ArrayList<Knapsack> test1(Integer totalWeight,
	        List<Knapsack> bags) {
		
		// int totalWeight = 3000;
		Knapsack[] knapsacks = {};
		knapsacks = bags.toArray(knapsacks);
		KnapsackProblem kp = new KnapsackProblem(knapsacks, totalWeight);
		Arrays.sort(knapsacks, Collections.reverseOrder());
		kp.solve();
		System.out.println(" -------- 该背包问题实例的解: --------- ");
		System.out.println("最优值：" + kp.getBestValue());
		System.out.println("最优解【选取的背包】: ");
		System.out.println(kp.getBestSolution());
		int num = 0;
		return kp.getBestSolution();
// for (int i = 0; i < kp.getBestSolution().size(); i++) {
// Knapsack knapsack = kp.getBestSolution().get(i);
// num += knapsack.getWeight();
// System.out.println("knapsack.getWeight:" + knapsack.getWeight());
// System.out.println("num:" + num);
// }
		// System.out.println("最优值矩阵：");
		// int[][] bestValues = kp.getBestValues();
// for (int i = 0; i < bestValues.length; i++) {
// for (int j = 0; j < bestValues[i].length; j++) {
// System.out.printf("%-5d", bestValues[i][j]);
// }
// System.out.println();
// }
		
	}
	
// public static void test2() {
// Knapsack[] bags = new Knapsack[] { new Knapsack(2, 13),
// new Knapsack(1, 10), new Knapsack(3, 24), new Knapsack(2, 15),
// new Knapsack(4, 28), new Knapsack(5, 33), new Knapsack(3, 20),
// new Knapsack(1, 8) };
// int totalWeight = 12;
// KnapsackProblem kp = new KnapsackProblem(bags, totalWeight);
//		
// kp.solve();
// System.out.println(" -------- 该背包问题实例的解: --------- ");
// System.out.println("最优值：" + kp.getBestValue());
// System.out.println("最优解【选取的背包】: ");
// System.out.println(kp.getBestSolution());
// System.out.println("最优值矩阵：");
// int[][] bestValues = kp.getBestValues();
// for (int i = 0; i < bestValues.length; i++) {
// for (int j = 0; j < bestValues[i].length; j++) {
// System.out.printf("%-5d", bestValues[i][j]);
// }
// System.out.println();
// }
// }
	
	public static void test3() throws InvalidFormatException, IOException {
		String path = "d:" + File.separator + "price.xlsx";
		File file = new File(path);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheetAt(0);
		List<Knapsack> bags = new ArrayList<Knapsack>();
		try {
			for (int row = 1; row <= sheet.getLastRowNum(); row++) {
				Row row2 = sheet.getRow(row);
				Cell cell0 = row2.getCell(0);
				Cell cell1 = row2.getCell(1);
				// 输出方格中的内容，以空格间隔
				// System.out.print(cell.toString() + "  ");
				// System.out.println(cell0.getCellComment().toString());
				
// Integer integer = Double.valueOf(cell0.getNumericCellValue())
				// .intValue();
				Integer integer = null;
				switch (cell0.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(cell0)) {
						
					} else {
						cell0.setCellType(Cell.CELL_TYPE_STRING);
						String temp = cell0.getStringCellValue();
						// 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
						if (temp.indexOf(".") > -1) {
							integer = Double.valueOf(temp).intValue();
						} else {
							integer = Integer.valueOf(temp).intValue();
						}
					}
					break;
				case Cell.CELL_TYPE_STRING:
					integer = Integer.valueOf(cell0.getStringCellValue())
					        .intValue();
					break;
				default:
					break;
				}
				Knapsack knapsack = new Knapsack(integer, integer);
				knapsack.setNo(Double.valueOf(cell1.getNumericCellValue())
				        .intValue());
				
				bags.add(knapsack);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Total> list = test4();
		
		write(list, bags);
		
	}
	
	public static List<Total> test4() throws InvalidFormatException,
	        IOException {
		String path = "d:" + File.separator + "total.xlsx";
		File file = new File(path);
		// Workbook workbook = Workbook.getWorkbook(file);
		Workbook workbook = WorkbookFactory.create(file);
		// Sheet sheet = workbook.getSheet(0);
		Sheet sheet = workbook.getSheetAt(0);
		List<Total> bags = new ArrayList<Total>();
		try {
			
			for (int row = 1; row <= sheet.getLastRowNum(); row++) {
				// Cell[] cells = sheet.getRow(row);
				// System.out.println(cells[0].getContents());
				Row row2 = sheet.getRow(row);
				Cell cell0 = row2.getCell(0);
				Cell cell1 = row2.getCell(1);
				Integer integer = null;
				switch (cell0.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(cell0)) {
						
					} else {
						cell0.setCellType(Cell.CELL_TYPE_STRING);
						String temp = cell0.getStringCellValue();
						// 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
						if (temp.indexOf(".") > -1) {
							integer = Double.valueOf(temp).intValue();
						} else {
							integer = Integer.valueOf(temp).intValue();
						}
					}
					break;
				case Cell.CELL_TYPE_STRING:
					integer = Integer.valueOf(cell0.getStringCellValue())
					        .intValue();
					break;
				default:
					break;
				}
				
				Total total = new Total();
				total.setNo(Double.valueOf(cell1.getNumericCellValue())
				        .intValue());
				total.setTotal(integer);
				bags.add(total);
			}
			Arrays.sort(bags.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bags;
	}
	
//	
// public static void write(int row, int total, List<Knapsack> list)
// throws WriteException, IOException {
// String path = "d:" + File.separator + "out.xlsx";// 输出的excel文件名
// String worksheet = "List";// 输出的excel文件工作表名
// String[] title = { "amount", "price", "makeup", "num", "bno", "cno" };//
	// excel工作表的标题
// WritableWorkbook workbook = null;
// try {
// File file = new File(path);
// if (file.exists()) {
// file.delete();
// }
// OutputStream os = new FileOutputStream(path);
//			
// workbook = Workbook.createWorkbook(os);
// WritableSheet sheet = workbook.createSheet(worksheet, 0); // 添加第一个工作表
// jxl.write.Label label;
// for (int i = 0; i < title.length; i++) {
// // Label(列号,行号 ,内容 )
// label = new jxl.write.Label(i, 0, title[i]); // put the title in
// // row1
// sheet.addCell(label);
// }
//			
// label = new jxl.write.Label(0, row + 1, total + ""); // put the
// // title
// // in
// // row1
// sheet.addCell(label);
// label = new jxl.write.Label(1, row + 1, total + "");
// sheet.addCell(label);
// label = new jxl.write.Label(2, row + 1, list.toString() + "");
//			
// sheet.addCell(label);
// label = new jxl.write.Label(3, row + 1, list.size() + "");
//			
// sheet.addCell(label);
//			
// label = new jxl.write.Label(4, row + 1, list.size() + "");
//			
// sheet.addCell(label);
// label = new jxl.write.Label(5, row + 1, list.size() + "");
//			
// sheet.addCell(label);
// workbook.write();
//			
// } catch (Exception e) {
// e.printStackTrace();
// } finally {
// if (workbook != null) {
// workbook.close();
// }
//			
// }
//		
// }
	
	/**
	 * write(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * TODO(这里描述这个方法的执行流程 – 可选)
	 * TODO(这里描述这个方法的使用方法 – 可选)
	 * TODO(这里描述这个方法的注意事项 – 可选)
	 * 
	 * @param name
	 * @param @return 设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample　Ver(编码范例查看) 1.1
	 */
	private static void write(List<Total> totals, List<Knapsack> prices)
	        throws FileNotFoundException {
		String path = "d:" + File.separator + "out.xlsx";// 输出的excel文件名
		String worksheet = "List";// 输出的excel文件工作表名
		String[] title = { "amount", "price", "makeup", "num", "bno", "cno" };// excel工作表的标题
		// 创建excel工作簿
		Workbook workbook = new XSSFWorkbook();
		OutputStream os = new FileOutputStream(path);
		
		try {
			File file = new File(path);
			if (file.exists()) {
				file.delete();
			}
			
			// 创建第一个sheet（页），命名为 new sheet
			Sheet sheet = workbook.createSheet(worksheet);
			Row row = sheet.createRow((short) 0);
			for (int i = 0; i < title.length; i++) {
				// Label(列号,行号 ,内容 )
				row.createCell(i).setCellValue(title[i]);
				// row1
				// sheet.addCell(label);
			}
			int num = 1;
			int total = 0;
			for (int i = 0; i < totals.size(); i++) {
				ArrayList<Knapsack> list2 = test1(totals.get(i).getTotal(),
				        prices);
				for (int j = 0; j < list2.size(); j++) {
					Knapsack knapsack = list2.get(j);
					total += knapsack.getWeight();
				}
				if (total != totals.get(i).getTotal()) {
					total = 0;
					continue;
				} else {
					total = 0;
				}
				
				if (list2 != null && !list2.isEmpty()) {
					prices.removeAll(list2);
				}
				for (int j = 0; j < list2.size(); j++) {
					row = sheet.createRow((short) num);
					Knapsack knapsack = list2.get(j);
					row.createCell(0).setCellValue(totals.get(i).getTotal());
// label = new jxl.write.Label(0, num + 1, totals.get(i)
// .getTotal()
					// + ""); // put
					// the
					// title
					// in
					// row1
					row.createCell(1).setCellValue(totals.get(i).getTotal());
// sheet.addCell(label);
// label = new jxl.write.Label(1, num + 1, totals.get(i)
// .getTotal()
// + "");
// sheet.addCell(label);
					row.createCell(2).setCellValue(knapsack.getWeight());
// label = new jxl.write.Label(2, num + 1, list2.get(i)
// .toString()
// + "");
//					
// sheet.addCell(label);
					row.createCell(3).setCellValue(list2.size());
// label = new jxl.write.Label(3, num + 1, list2.size() + "");
//					
// sheet.addCell(label);
					row.createCell(4).setCellValue(totals.get(i).getNo());
// label = new jxl.write.Label(4, num + 1, totals.get(i)
// .getNo()
// + "");
//					
// sheet.addCell(label);
					row.createCell(5).setCellValue(knapsack.getNo());
// label = new jxl.write.Label(5, num + 1, knapsack.getNo()
// + "");
//					
// sheet.addCell(label);
					num++;
				}
				
			}
			
			workbook.write(os);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	}
}
