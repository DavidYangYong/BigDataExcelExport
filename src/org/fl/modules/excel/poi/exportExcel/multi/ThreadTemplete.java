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
 * # * ThreadTest.java Create on 2013-11-14 上午09:50:06
 * # * project Test
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：ThreadTest.java
 * 版本信息：
 * 日期：2013-11-14
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.excel.poi.exportExcel.multi;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
import org.fl.modules.excel.poi.exportExcel.ISxssfWorkBookList;
import org.fl.modules.utils.RowSelect;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-14 上午09:50:06
 *          类说明
 */
/**
 * 项目名称：Test
 * 类名称：ThreadTest
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-14 上午09:50:06
 * 修改人：David.Yang
 * 修改时间：2013-11-14 上午09:50:06
 * 修改备注：
 * 
 * @version
 */
class ThreadTemplete implements Runnable {
	private static CountDownLatch doneCdl;// 所有连接工作都结束的控制器
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ThreadTemplete.class);
	
	private int pageSize;
	private RowSelect rowSelect;
	private ISxssfWorkBookList sxssfWorkBookList;
	
	private SXSSFWorkBookOperation sxssfWorkBookOperation;
	
	public ThreadTemplete(CountDownLatch doneCdl,
			SXSSFWorkBookOperation sxssfWorkBookOperation, RowSelect rowSelect,
			ISxssfWorkBookList sxssfWorkBookList, int pageSize) {
		this.doneCdl = doneCdl;
		this.sxssfWorkBookOperation = sxssfWorkBookOperation;
		this.rowSelect = rowSelect;
		this.sxssfWorkBookList = sxssfWorkBookList;
		this.pageSize = pageSize;
	}
	
	public List getList(RowSelect rowSelect, ISxssfWorkBookList sxssfWorkBookList) {
		if (sxssfWorkBookList != null) {
			return sxssfWorkBookList.doExecuteList(rowSelect);
		}
		return null;
		
	}
	
	public void run() {
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("run() - " + Thread.currentThread().getName()
						+ " has been working!!!!");
			}
			doneCdl.countDown();
			// 此处需要代码清单一的那些连接操作
			
			List list = getList(rowSelect, sxssfWorkBookList);
			if (list == null || list.isEmpty()) {
				Thread.currentThread().interrupt();
			}
			sxssfWorkBookOperation.excute(pageSize,
					sxssfWorkBookOperation.getSxIsxssfWorkBook(), list);
			
			if (logger.isDebugEnabled()) {
				logger.debug("run() - " + Thread.currentThread().getName()
						+ " has been working end !!!!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("run()", e);
			Thread.currentThread().interrupt();
		}
	}
}
