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
 * # * ExportExcelMultiSupport.java Create on 2013-11-20 上午09:30:41
 * # * project david-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：ExportExcelMultiSupport.java
 * 版本信息：
 * 日期：2013-11-20
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.excel.poi.exportExcel.multi;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.biz.app.util.DateUtils;
import org.fl.modules.excel.poi.exportExcel.ISXSSFWorkBook;
import org.fl.modules.excel.poi.exportExcel.ISxssfWorkBookList;
import org.fl.modules.utils.RowSelect;

/**
 * @author David.Yang
 * @version 1.0 CreateDate：2013-11-20 上午09:30:41 类说明
 */
/**
 * 项目名称：david-modules-excel 类名称：ExportExcelMultiSupport 类描述： 创建人：David.Yang
 * 创建时间：2013-11-20 上午09:30:41 修改人：David.Yang 修改时间：2013-11-20 上午09:30:41 修改备注：
 *
 * @version
 * 			synchronized (excelMultiSupport) {
 *          try {
 *          excelMultiSupport.run(Long.valueOf(num).intValue(),
 *          new ISXSSFWorkBook() {
 * @Override
 * 			public void doExecuteCreateTitle(Sheet sheet) {
 *           Row contenRow = sheet.createRow(0);
 *           Cell contentCell = contenRow.createCell(0);
 *           contentCell.setCellValue("包件编码");
 *           sheet.setColumnWidth(0, 4000);
 *           contentCell = contenRow.createCell(1);
 *           contentCell.setCellValue("包件名称");
 *           sheet.setColumnWidth(1, 8000);
 *           contentCell = contenRow.createCell(2);
 *           contentCell.setCellValue("工厂编码");
 *           sheet.setColumnWidth(2, 3000);
 *           contentCell = contenRow.createCell(3);
 *           contentCell.setCellValue("工厂名称");
 *           sheet.setColumnWidth(3, 6000);
 *           contentCell = contenRow.createCell(4);
 *           contentCell.setCellValue("板件编码");
 *           sheet.setColumnWidth(4, 4000);
 *           contentCell = contenRow.createCell(5);
 *           contentCell.setCellValue("板件名称");
 *           sheet.setColumnWidth(5, 4000);
 *           contentCell = contenRow.createCell(6);
 *           contentCell.setCellValue("板件基数");
 *           sheet.setColumnWidth(6, 3000);
 *           contentCell = contenRow.createCell(7);
 *           contentCell.setCellValue("工序代码");
 *           sheet.setColumnWidth(7, 3000);
 *           contentCell = contenRow.createCell(8);
 *           contentCell.setCellValue("工序名称");
 *           sheet.setColumnWidth(8, 3000);
 *           contentCell = contenRow.createCell(9);
 *           contentCell.setCellValue("中工序代码");
 *           sheet.setColumnWidth(9, 4000);
 *           contentCell = contenRow.createCell(10);
 *           contentCell.setCellValue("中工序名称");
 *           sheet.setColumnWidth(10, 4000);
 *           contentCell = contenRow.createCell(11);
 *           contentCell.setCellValue("小工序代码");
 *           sheet.setColumnWidth(11, 3000);
 *           contentCell = contenRow.createCell(12);
 *           contentCell.setCellValue("小工序名称");
 *           sheet.setColumnWidth(12, 3000);
 *           contentCell = contenRow.createCell(13);
 *           contentCell.setCellValue("单价");
 *           sheet.setColumnWidth(13, 2000);
 *           contentCell = contenRow.createCell(14);
 *           contentCell.setCellValue("总工价");
 *           sheet.setColumnWidth(14, 2000);
 *           contentCell = contenRow.createCell(15);
 *           contentCell.setCellValue("生效日期");
 *           sheet.setColumnWidth(15, 4000);
 *           }
 * @Override
 * 			public void doExecute(Row contenRow, Object object) {
 *           WorkHourpItem workHourpItem = (WorkHourpItem) object;
 *           Cell contentCell = contenRow.createCell(0);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getPmatnr()));
 *           contentCell = contenRow.createCell(1);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getPmaktx()));
 *           contentCell = contenRow.createCell(2);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getWerks()));
 *           contentCell = contenRow.createCell(3);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getFactoryName()));
 *           contentCell = contenRow.createCell(4);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getMatnr()));
 *           contentCell = contenRow.createCell(5);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getMaktx()));
 *           contentCell = contenRow.createCell(6);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getBnum()));
 *           contentCell = contenRow.createCell(7);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getPstepCode()));
 *           contentCell = contenRow.createCell(8);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getPstepName()));
 *           contentCell = contenRow.createCell(9);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getStepCode()));
 *           contentCell = contenRow.createCell(10);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getStepName()));
 *           contentCell = contenRow.createCell(11);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getMinStepCode()));
 *           contentCell = contenRow.createCell(12);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getMinStepName()));
 *           contentCell = contenRow.createCell(13);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getPrice()));
 *           contentCell = contenRow.createCell(14);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getTotalPrice()));
 *           contentCell = contenRow.createCell(15);
 *           contentCell
 *           .setCellValue(getValueStr(workHourpItem
 *           .getStartDate()));
 *           }
 *           }, new ISxssfWorkBookList() {
 * @Override
 * 			public List doExecuteList(RowSelect rowSelect) {
 *           List list = new ArrayList();
 *           try {
 *           list = workHourpItemService
 *           .queryAllIEReport(item, rowSelect
 *           .getRowStart(), rowSelect
 *           .getRowEnd());
 *           if (logger.isDebugEnabled()) {
 *           logger
 *           .debug("doExecuteList(RowSelect) - query:"
 *           + list.size());
 *           }
 *           } catch (Exception e) {
 *           // TODO Auto-generated catch block
 *           logger.error("doExecuteList(RowSelect)", e);
 *           }
 *           return list;
 *           }
 *           });
 *           } catch (IOException e1) {
 *           // TODO Auto-generated catch block
 *           e1.printStackTrace();
 *           } catch (RuntimeException e1) {
 *           // TODO Auto-generated catch block
 *           e1.printStackTrace();
 *           }
 *           }
 */
public class ExportExcelMultiSupport {
	
	class ExecutorServiceRun implements Runnable {
		private volatile Thread mTheThread = null;
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			if (mTheThread != Thread.currentThread()) {
				throw new RuntimeException();
			}
			while (!Thread.interrupted() && mTheThread != null) {// 如果标志位为null，不再继续。
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt(); // mTheThread可能已经为空了，因此用Thread.currentThread()替代之
				}
			}
		}
		
		public void start() {
			mTheThread = new Thread(this);
			mTheThread.start();
		}
		
		public void stop() {
			if (mTheThread != null) {
				mTheThread.interrupt();
				try {
					mTheThread.join(); // 等待线程彻底结束
				} catch (InterruptedException e) {
					e.printStackTrace();
					mTheThread.interrupt();
				}
			}
		}
		
	}
	
	private static Logger logger = Logger
			.getLogger(ExportExcelMultiSupport.class);
	private boolean isMulti;
	
	private SXSSFWorkBookOperation sxssfWorkBookOperation;
	
	/**
	 * 创建一个新的实例 ExportExcelMultiSupport.
	 */
	public ExportExcelMultiSupport() {
		isMulti = true;
	}
	
	public SXSSFWorkBookOperation getSxssfWorkBookOperation() {
		return sxssfWorkBookOperation;
	}
	
	public boolean isMulti() {
		return isMulti;
	}
	
	/***************************************************************************
	 * @param int
	 *            count
	 * @param ISXSSFWorkBook
	 *            sIsxssfWorkBook
	 * @param ISxssfWorkBookList
	 *            sxssfWorkBookList
	 */
	public boolean run(final int count, final ISXSSFWorkBook sIsxssfWorkBook, final ISxssfWorkBookList sxssfWorkBookList)
			throws IOException, RuntimeException {
		logger.info("查询数据开始.....");
		long start = System.currentTimeMillis();
		logger.info(
				DateUtils.formatDateTimeDateByPattern("yyyy-MM-dd HH:mm:ss"));
		sxssfWorkBookOperation = new SXSSFWorkBookOperation();
		sxssfWorkBookOperation.setSxIsxssfWorkBook(sIsxssfWorkBook);
		boolean isRun = false;
		if (isMulti) {
			ExecutorService executorService = Executors
					.newSingleThreadExecutor();
			final CountDownLatchTemplete countDownLatchTemplete = new CountDownLatchTemplete();
			
			boolean isCompleted = false;
			countDownLatchTemplete.countDownLatch(
					Long.valueOf(count).intValue(), sxssfWorkBookOperation,
					sxssfWorkBookList);
			
			isRun = countDownLatchTemplete.isClose();
			// 等待子线程结束，再继续执行下面的代码
		} else {
			sxssfWorkBookOperation.setTotalRows(count);
			sxssfWorkBookOperation.setSheet_num(1);
			int pageSize = PageSizeUtils.pageSize;
			RowSelect rowSelect = new RowSelect(1, pageSize, count);
			sxssfWorkBookOperation.excute(sIsxssfWorkBook,
					sxssfWorkBookList.doExecuteList(rowSelect));
			isRun = true;
		}
		
		long end = System.currentTimeMillis();
		long temp = (end - start) / 1000;
		logger.info("耗时:" + temp + "秒");
		logger.info("耗时:" + temp / 60 + "分钟");
		logger.info("查询数据结束.....");
		return isRun;
	}
	
	public void setMulti(boolean isMulti) {
		this.isMulti = isMulti;
	}
}
