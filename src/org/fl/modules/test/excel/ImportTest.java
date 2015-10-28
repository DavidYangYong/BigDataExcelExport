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
 * # * t.java Create on 2013-11-13 下午05:11:50
 * # * project qy-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：t.java
 * 版本信息：
 * 日期：2013-11-13
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.test.excel;

import java.io.File;
import java.io.IOException;

import jxl.read.biff.BiffException;

import org.fl.modules.excel.IImportExcel;
import org.fl.modules.excel.jxl.JxlImportExcelFactory;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-13 下午05:11:50
 *          类说明
 */
/**
 * 项目名称：qy-modules-excel
 * 类名称：t
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-13 下午05:11:50
 * 修改人：David.Yang
 * 修改时间：2013-11-13 下午05:11:50
 * 修改备注：
 * 
 * @version
 */
public class ImportTest {
	
	public static void main(String[] args) throws IOException, BiffException {
		File file = new File("d:\\test.xls");
		JxlImportExcelFactory jxlImportExcelFactory = new JxlImportExcelFactory(
		        file);
		IImportExcel importExcel = jxlImportExcelFactory.createImportExcel();
		long start = System.currentTimeMillis();
		System.out.println("start:" + start);
		importExcel.validateExcelData();
		long end = System.currentTimeMillis();
		System.out.println("end:" + end);
		System.out.println(end - start);
		System.out.println("Took : " + ((end - start) / 1000));
	}
}
