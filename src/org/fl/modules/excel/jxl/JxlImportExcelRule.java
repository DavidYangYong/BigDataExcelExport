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
 * # * JxlImportExcel.java Create on 2013-11-13 上午09:46:29
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

import jxl.Cell;
import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.fl.modules.excel.AbstractImportExcel;
import org.fl.modules.excel.ExcelReturn;
import org.fl.modules.excel.IImportExcel;
import org.fl.modules.excel.rule.ImportValidatePredicate;
import org.fl.modules.excel.rule.ImportValidateRule;
import org.fl.modules.excel.rule.Rule;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-13 上午09:46:29
 *          类说明
 */
/**
 * 项目名称：qy-modules-excel
 * 类名称：JxlImportExcel
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-13 上午09:46:29
 * 修改人：David.Yang
 * 修改时间：2013-11-13 上午09:46:29
 * 修改备注：
 * 
 * @version
 */
public class JxlImportExcelRule extends AbstractImportExcel implements
        IImportExcel {
	
	private int columns;
	
	private Workbook workbook;
	
	/**
	 * 创建一个新的实例 JxlImportExcel.
	 */
	public JxlImportExcelRule(Workbook workbook) {
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
	
	/*
	 * (non-Javadoc)
	 * @see org.fl.modules.excel.IImportExcel#validateExcelData()
	 */
	@Override
	public ExcelReturn validateExcelData() {
		Sheet sheet = workbook.getSheet(0);
		ExcelReturn excelReturn = new ExcelReturn();
		try {
			boolean isSame = false;
			
			for (int row = 2; row < sheet.getRows(); row++) {
				Cell[] cells = sheet.getRow(row);
				columns = cells.length;
				List<ImportValidateRule> list = createImportValidateRules(createRowCellValue(cells));
				ImportValidatePredicate firstNameEqlPredicate = new ImportValidatePredicate();
				Predicate[] allPredicateArray = { firstNameEqlPredicate };
				Predicate allPredicate = PredicateUtils
				        .allPredicate(allPredicateArray);
				Collection<ImportValidateRule> filteredSuccessCollection = CollectionUtils
				        .select(list, allPredicate);
				Collection<ImportValidateRule> filteredCollection = CollectionUtils
				        .selectRejected(list, allPredicate);
				// excelReturn.getRightCollection().add(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			workbook.close();
			
		}
		return excelReturn;
	}
	
	private List<ImportValidateRule> createAlias() {
		List<ImportValidateRule> list = new ArrayList<ImportValidateRule>();
		ImportValidateRule importValidateRule = new ImportValidateRule();
		importValidateRule.setAlias("包件编码");
		importValidateRule.setIndex(0);
		importValidateRule.setRule(Rule.emptyOrNull);
		list.add(importValidateRule);
		importValidateRule = new ImportValidateRule();
		importValidateRule.setAlias("工厂编码");
		importValidateRule.setIndex(2);
		importValidateRule.setRule(Rule.emptyOrNull);
		list.add(importValidateRule);
		importValidateRule = new ImportValidateRule();
		importValidateRule.setAlias("板件编码");
		importValidateRule.setIndex(4);
		importValidateRule.setRule(Rule.emptyOrNull);
		list.add(importValidateRule);
		return list;
	}
	
	private List<ImportValidateRule> createImportValidateRules(
	        List<String> cells) {
		List<ImportValidateRule> importValidateRules = new ArrayList<ImportValidateRule>(
		        columns);
		List<String> list = new ArrayList<String>(cells.size());
		List<ImportValidateRule> alias = createAlias();
		for (int i = 0; i < cells.size(); i++) {
			for (int j = 0; j < alias.size(); j++) {
				ImportValidateRule importValidateRule = alias.get(j);
				if (i == importValidateRule.getIndex()) {
					importValidateRule.setValue(cells.get(i));
				}
			}
		}
		
		return importValidateRules;
	}
	
	private Object[] createObjects() {
		Object[] errors = new Object[columns];
		
		for (int i = 0; i < errors.length; i++) {
			errors[i] = " ";
		}
		return errors;
	}
	
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
