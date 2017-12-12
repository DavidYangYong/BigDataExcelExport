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
 * # * ISXSSFWorkBook.java Create on 2013-11-18 下午04:18:20
 * # * project david-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：ISXSSFWorkBook.java
 * 版本信息：
 * 日期：2013-11-18
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.excel.poi.exportExcel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-18 下午04:18:20
 *          类说明
 *          执行excel操作接口
 */
/**
 * 项目名称：david-modules-excel
 * 类名称：ISXSSFWorkBook
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-18 下午04:18:20
 * 修改人：David.Yang
 * 修改时间：2013-11-18 下午04:18:20
 * 修改备注：
 * 
 * @version
 */
public interface ISXSSFWorkBook {
	/**
	 * 执行创建行的操作
	 * 
	 * @param org
	 *            .apache.poi.ss.usermodel.Row row
	 */
	public void doExecute(Row row, Object object,CellStyle cellStyle);
	
	/**
	 * 执行创建表头的操作
	 * 
	 * @param org
	 *            .apache.poi.ss.usermodel.Sheet
	 *            sheet
	 */
	public void doExecuteCreateTitle(Sheet sheet);
}
