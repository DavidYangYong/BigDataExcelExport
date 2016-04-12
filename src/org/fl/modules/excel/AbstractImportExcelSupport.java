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
package org.fl.modules.excel;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.lang.BooleanUtils;

/***
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-13 上午09:18:55
 *          类说明
 *          操作excel的模板类，使用IImportExcel接口进行操作
 */
/***
 * 项目名称：qy-modules-excel*类名称：AbstractJxlImportExcel*类描述：*创建人：David.Yang*创建时间：
 * 2013-11-13 上午09:18:55*修改人：David.Yang*修改时间：2013-11-13 上午09:18:55*修改备注：**
 *
 * @version
 */
public abstract class AbstractImportExcelSupport
		extends AbstractImportExcelStream {
	
	private IImportExcel importExcel;
	
	/**
	 * 创建一个新的实例 AbstractJxlImportExcel.
	 *
	 * @param file
	 */
	public AbstractImportExcelSupport(File file) {
		super(file);
		// TODO Auto-generated constructor stub
		boolean booleanUtils = BooleanUtils.isFalse(false);
	}
	
	/**
	 * 进行导入excel数据
	 */
	public abstract IImportExcel createImportExcel() throws IOException;
	
	/**
	 * 进行导入excel数据的模板方法
	 */
	private void importExcelData() throws IOException {
		boolean validate = false;
		IImportExcel importExcel = createImportExcel();
		if (importExcel != null) {
			try {
				ExcelReturn excelReturn = validateExcelData(importExcel);
				if (excelReturn != null) {
					validate = excelReturn.isRight();
					if (validate) {
						Collection imCollection = excelReturn
								.getRightCollection();
						importExcel.importExcelData(imCollection);
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	/**
	 * 进行导入excel数据的验证模板方法
	 */
	private ExcelReturn validateExcelData(IImportExcel importExcel) {
		ExcelReturn excelReturn = new ExcelReturn();
		try {
			excelReturn = importExcel.validateExcelData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excelReturn;
		
	}
	
}
