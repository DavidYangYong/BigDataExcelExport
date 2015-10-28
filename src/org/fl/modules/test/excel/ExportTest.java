package org.fl.modules.test.excel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.fl.modules.excel.poi.exportExcel.ISXSSFWorkBook;
import org.fl.modules.excel.poi.exportExcel.ISxssfWorkBookList;
import org.fl.modules.excel.poi.exportExcel.multi.ExportExcelMultiSupport;
import org.fl.modules.utils.RowSelect;

public class ExportTest {
	
	public static void main(String[] args)
			throws IOException, RuntimeException {
		ExportExcelMultiSupport excelMultiSupport = new ExportExcelMultiSupport();
		excelMultiSupport.setMulti(false);
		excelMultiSupport.run(1000, new ISXSSFWorkBook() {
			
			@Override
			public void doExecuteCreateTitle(Sheet sheet) {
				Row contenRow = sheet.createRow(0);
				
				Cell contentCell = contenRow.createCell(0);
				contentCell.setCellValue("包件编码");
				sheet.setColumnWidth(0, 4000);
				
			}
			
			@Override
			public void doExecute(Row contenRow, Object object) {
				Person person = (Person) object;
				Cell contentCell = contenRow.createCell(0);
				contentCell.setCellValue(person.getName());
				
			}
		}, new ISxssfWorkBookList() {
			
			@Override
			public List doExecuteList(RowSelect rowSelect) {
				List list = new ArrayList();
				try {
					Person person = new Person();
					person.setName("personTest");
					list.add(person);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;
			}
		});
		ExportTest test = new ExportTest();
		String rootPath = test.getClass().getResource("/").getPath();
		String source = rootPath + "test.xls";
		File file = new File(source);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		// test
		byte[] b = excelMultiSupport.getSxssfWorkBookOperation()
				.write(byteArrayOutputStream);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		
		int bytesWritten = 0;
		
		int byteCount = 0;
		fileOutputStream.write(b);
	}
}
