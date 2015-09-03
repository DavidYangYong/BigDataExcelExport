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
 * # * SXSSFWorkBookUtil.java Create on 2013-11-18 上午08:57:43
 * # * project david-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：SXSSFWorkBookUtil.java
 * 版本信息：
 * 日期：2013-11-18
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.excel.poi.exportExcel.multi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.fl.modules.excel.poi.exportExcel.ISXSSFWorkBook;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-18 上午08:57:43
 *          类说明
 */
/**
 * 项目名称：david-modules-excel
 * 类名称：SXSSFWorkBookUtil
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-18 上午08:57:43
 * 修改人：David.Yang
 * 修改时间：2013-11-18 上午08:57:43
 * 修改备注：
 * 
 * @version
 */
public class SXSSFWorkBookOperation {
	
	private static Logger logger = Logger
	        .getLogger(SXSSFWorkBookOperation.class);
	private int pageNo; // 分页数
	
	private int pageSize; // 每页行数
	
	private int rowaccess = 100;// 内存中缓存记录行数;
	
	private int sheet_num;// 生成sheet_num个SHEET
	
	private ISXSSFWorkBook sxIsxssfWorkBook;// 执行excel操作接口
	private int totalRows;// 导出数据总数
	private SXSSFWorkbook wb;// poi workbook
	
	/**
	 * 创建一个新的实例 SXSSFWorkBookUtil.
	 */
	public SXSSFWorkBookOperation() {
		// TODO Auto-generated constructor stub
		
		/* keep 100 rowsin memory,exceeding rows will be flushed to disk */
		wb = new SXSSFWorkbook(rowaccess);
		wb.setCompressTempFiles(false);
	}
	
	public void compressFiles2Zip() {
		org.apache.commons.io.output.ByteArrayOutputStream byteArrayOutputStream = new org.apache.commons.io.output.ByteArrayOutputStream();
		try {
			byteArrayOutputStream = write(byteArrayOutputStream);
			ZipArchiveOutputStream zaos = null;
			zaos = new ZipArchiveOutputStream(byteArrayOutputStream);
			// Use Zip64 extensions for all entries where they are required
			zaos.setUseZip64(Zip64Mode.AsNeeded);
			if (byteArrayOutputStream != null) {
				ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry("excel");
				zaos.putArchiveEntry(zipArchiveEntry);
				try {
					byteArrayOutputStream.writeTo(zaos);
					zaos.closeArchiveEntry();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 执行excel操作主要模板方法
	 * 
	 * @param int rowSize 行数
	 * @param ISXSSFWorkBook
	 *            sxsWorkBook
	 * @param List
	 *            list 数据
	 **/
	
	public void excute(int pageSize, ISXSSFWorkBook sxsWorkBook, List list)
	        throws IOException, RuntimeException {
		int rowCount = list.size();
		if (rowCount > pageSize) {
			throw new RuntimeException("导出数据条数大于excel规定的条数");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("excute(int, ISXSSFWorkBook, List) - start");
		}
		
		long curr_time = System.currentTimeMillis();
		if (logger.isDebugEnabled()) {
			logger.debug("excute(int, ISXSSFWorkBook, List) - "
			        + new Date().toString());
		}
		Sheet sh = null;
		synchronized (wb) {
			sh = wb.createSheet();
			
			sxsWorkBook.doExecuteCreateTitle(sh);
			
			// 每个SHEET有rowCount ROW
			for (int rownum = 0; rownum < rowCount; rownum++) {
				Row row = sh.createRow(rownum + 1);
				
				Object object = list.get(rownum);
				sxsWorkBook.doExecute(row, object);
				
				// 每当行数达到设置的值就刷新数据到硬盘,以清理内存
				if (rownum % rowaccess == 0) {
					((SXSSFSheet) sh).flushRows();
				}
			}
		}
		/* 计算耗时 */
		if (logger.isDebugEnabled()) {
			logger.debug("excute(int, ISXSSFWorkBook, List) - 耗时:"
			        + (System.currentTimeMillis() - curr_time) / 1000 + "秒");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("excute(int, ISXSSFWorkBook, List) - "
			        + new Date().toString());
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("excute(int, ISXSSFWorkBook, List) - end");
		}
	}
	
	public void excute(ISXSSFWorkBook sxsWorkBook, List list)
	        throws IOException, RuntimeException {
		excute(PageSizeUtils.pageSize, sxsWorkBook, list);
	}
	
	public int getPageNo() {
		return pageNo;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public int getSheet_num() {
		return sheet_num;
	}
	
	public ISXSSFWorkBook getSxIsxssfWorkBook() {
		return sxIsxssfWorkBook;
	}
	
	public int getTotalRows() {
		return totalRows;
	}
	
	public SXSSFWorkbook getWb() {
		return wb;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public void setSheet_num(int sheetNum) {
		sheet_num = sheetNum;
	}
	
	public void setSxIsxssfWorkBook(ISXSSFWorkBook sxIsxssfWorkBook) {
		this.sxIsxssfWorkBook = sxIsxssfWorkBook;
	}
	
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	/**
	 * 写入流
	 * 
	 * @param ByteArrayOutputStream
	 *            outputStream
	 * @return byte[]
	 */
	public byte[] write(ByteArrayOutputStream outputStream) throws IOException {
		byte[] b = null;
		
		wb.write(outputStream);
		outputStream.flush();
		
		b = outputStream.toByteArray();
		return b;
		
	}
	
	public org.apache.commons.io.output.ByteArrayOutputStream write(
	        org.apache.commons.io.output.ByteArrayOutputStream outputStream)
	        throws IOException {
		byte[] b = null;
		
		wb.write(outputStream);
		
		outputStream.flush();
		
		return outputStream;
		
	}
	
}
