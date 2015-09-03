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
 * # * JxlImportExcel.java Create on 2013-11-13 下午05:01:46
 * # * project qy-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：JxlImportExcel.java
 * 版本信息：
 * 日期：2013-11-13
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.excel.jxl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import org.fl.modules.excel.AbstractImportExcel;
import org.fl.modules.excel.ExcelReturn;
import org.fl.modules.excel.IImportExcel;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-13 下午05:01:46
 *          类说明
 */
/**
 * 项目名称：qy-modules-excel
 * 类名称：JxlImportExcel
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-13 下午05:01:46
 * 修改人：David.Yang
 * 修改时间：2013-11-13 下午05:01:46
 * 修改备注：
 * 
 * @version
 */
public class JxlImportExcel extends AbstractImportExcel implements IImportExcel {
	
	public static boolean match(String str) {
		String regex = "^(-{0,1}[1-9]\\d*\\.\\d*|0\\.[0-9]{1,})|(-{0,1}[1-9]\\d*|0)$";
		Pattern p = Pattern.compile(regex);
		return p.matcher(str).matches();
	}
	
	public static boolean matchDate(String str) {
		if (str == null) {
			return false;
		} else if (str.trim().length() != 10) {
			return false;
		}
		String regex = "^((?:19|20|99)[0-9][0-9])-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
		Pattern p = Pattern.compile(regex);
		return p.matcher(str).matches();
	}
	
	private int columns;
	
	private Workbook workbook;
	
	/**
	 * 创建一个新的实例 JxlImportExcel.
	 */
	public JxlImportExcel(Workbook workbook) {
		this.workbook = workbook;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * org.fl.modules.excel.IImportExcel#importExcelData(java.util.Collection)
	 */
	@Override
	public void importExcelData(Collection collection) {
	}
	
	public boolean isEmptyOrNull(String str) {
		return str == null || "".equals(str);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.fl.modules.excel.IImportExcel#validateExcelData()
	 */
	@Override
	public ExcelReturn validateExcelData() {
		synchronized (workbook) {
			Sheet sheet = workbook.getSheet(0);
			try {
				boolean isSame = false;
				
				boolean isError = false;
				Object[] errors = null;
				for (int row = 2; row < sheet.getRows(); row++) {
					Cell[] cells = sheet.getRow(row);
					columns = cells.length;
					errors = createObjects();
					List list = createRowCellValue(cells);
					errors[0] = row + 1;
					
					// validateCell(errors, isError, isSame, sheet, row);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
				workbook.close();
				
			}
			
		}
		return null;
	}
	
	private Object[] createObjects() {
		Object[] errors = new Object[columns];
		
		for (int i = 0; i < errors.length; i++) {
			errors[i] = " ";
		}
		return errors;
	}
	
	/**
	 *获得一行的所有单元格的数据，转换为list集合
	 */
	private List<String> createRowCellValue(Cell[] cells) {
		List<String> list = new ArrayList<String>(cells.length);
		for (Cell cell : cells) {
			if (cell.getType() == CellType.NUMBER) {
				list.add(((NumberCell) cell).getValue() + "");
			} else if (cell.getType() == CellType.LABEL) {
				list.add(cell.getContents());
			}
		}
		return list;
	}
	
}
