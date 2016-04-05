package org.fl.modules.utils;

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
 * # * PageListTest.java Create on 2013-11-18 下午03:03:10
 * # * project Test
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：PageListTest.java
 * 版本信息：
 * 日期：2013-11-18
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-18 下午03:03:10
 *          类说明
 */
/**
 * 项目名称：Test
 * 类名称：PageListTest
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-18 下午03:03:10
 * 修改人：David.Yang
 * 修改时间：2013-11-18 下午03:03:10
 * 修改备注：
 * 
 * @version
 */
public class PageListTest {
	
	public static void main(String[] args) {
		int totalRows = 430039;
		int pageSize = 60000;
		int pageNo = (totalRows + (pageSize - 1)) / pageSize; // 页数
		System.out.println(pageNo);
		for (int i = 0; i < pageNo; i++) {
			// PageBean page = new PageBean(pageSize, i, totalRows);
			RowSelect page = new RowSelect(i + 1, pageSize, totalRows);
			System.out.println(page.toString());
		}
		
	}
}
