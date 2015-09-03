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
 * # * JxlImportExcel.java Create on 2013-11-13 上午09:41:17
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

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.lang.StringUtils;
import org.fl.modules.excel.AbstractImportExcelSupport;
import org.fl.modules.excel.IImportExcel;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-13 上午09:41:17
 *          类说明
 */
/**
 * 项目名称：qy-modules-excel
 * 类名称：JxlImportExcel
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-13 上午09:41:17
 * 修改人：David.Yang
 * 修改时间：2013-11-13 上午09:41:17
 * 修改备注：
 * 
 * @version
 */
public class JxlImportExcelFactory extends AbstractImportExcelSupport {
	
	private String type;
	
	/**
	 * 创建一个新的实例 JxlImportExcel.
	 * 
	 * @param file
	 */
	public JxlImportExcelFactory(File file) {
		super(file);
		type = "excel";
		// TODO Auto-generated constructor stub
	}
	
	public JxlImportExcelFactory(File file, String type) {
		super(file);
		this.type = type;
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.fl.modules.excel.AbstractImportExcel#createImportExcel()
	 */
	@Override
	public IImportExcel createImportExcel() throws IOException, BiffException {
		return createImportExcel(type);
	}
	
	public IImportExcel createImportExcel(String type) throws BiffException,
	        IOException {
		Workbook workbook = Workbook.getWorkbook(getImportFile());
		if (workbook == null) {
			throw new IOException("读取导入excel文件错误");
		}
		
		if (StringUtils.equals("excelRule", type)) {
			return new JxlImportExcelRule(workbook);
		}
		return new JxlImportExcel(workbook);
	}
}
