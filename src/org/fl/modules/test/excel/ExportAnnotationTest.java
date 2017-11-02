package org.fl.modules.test.excel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.fl.modules.excel.poi.exportExcel.ISXSSFWorkBook;
import org.fl.modules.excel.poi.exportExcel.ISxssfWorkBookList;
import org.fl.modules.excel.poi.exportExcel.impl.SXSSFWorkBookImpl;
import org.fl.modules.excel.poi.exportExcel.multi.ExportExcelMultiSupport;
import org.fl.modules.utils.RowSelect;

public class ExportAnnotationTest {
	
	public static void main(String[] args)
			throws IOException, RuntimeException {
		ExportExcelMultiSupport excelMultiSupport = new ExportExcelMultiSupport();
		excelMultiSupport.setMulti(false);
		ISXSSFWorkBook isxssfWorkBook=new SXSSFWorkBookImpl(Person.class);
		excelMultiSupport.run(1000,isxssfWorkBook,new ISxssfWorkBookList() {

			public List doExecuteList(RowSelect rowSelect) {
				List list = new ArrayList();
				try {
					Person person = new Person();
					person.setId(new BigDecimal(1));
					person.setName("personTest1");
					list.add(person);
					 person = new Person();
					person.setId(new BigDecimal(2));
					person.setName("personTest2");
					list.add(person);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;
			}
		});
		ExportAnnotationTest test = new ExportAnnotationTest();
		String rootPath = test.getClass().getResource("/").getPath();
		String source = rootPath + "test.xlsx";
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
