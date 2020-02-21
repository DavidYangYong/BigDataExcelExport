package test.java.org.fl.excel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.fl.modules.excel.Person;
import org.fl.modules.excel.poi.exportExcel.ISXSSFWorkBook;
import org.fl.modules.excel.poi.exportExcel.ISxssfWorkBookList;
import org.fl.modules.excel.poi.exportExcel.impl.SXSSFWorkBookImpl;
import org.fl.modules.excel.poi.exportExcel.multi.ExportExcelMultiSupport;
import org.fl.modules.test.excel.Person;
import org.fl.modules.utils.RowSelect;

public class ExportAnnotationTest {

	public static void main(String[] args)
			throws IOException, RuntimeException {
		ExportExcelMultiSupport excelMultiSupport = new ExportExcelMultiSupport();
		excelMultiSupport.setMulti(true);
		excelMultiSupport.getSxssfWorkBookOperation().setPageSize(120000);
		ISXSSFWorkBook isxssfWorkBook = new SXSSFWorkBookImpl(org.fl.modules.test.excel.Person.class);
		excelMultiSupport.run(1000000, isxssfWorkBook, new ISxssfWorkBookList() {

			public List doExecuteList(RowSelect rowSelect) {
				List<org.fl.modules.test.excel.Person> list = new ArrayList();
				try {
					org.fl.modules.test.excel.Person person = new org.fl.modules.test.excel.Person();
					person.setId(100);
					person.setName("personTest1");
					person.setMoney(60000.96);
					person.setCreateDate("2017-10-11");
					Float moneyFloat = new Float("100.1");
					person.setMoneyFloat(moneyFloat);
					list.add(person);

					person = new org.fl.modules.test.excel.Person();
					person.setId(20000);
					person.setName("personTest2");
					person.setMoney(50000.96);
					person.setCreateDate("2017-11-11");
					person.setCreateDateTime("2014-04-24 08:11:59");

					list.add(person);
					person = new Person();
					person.setId(0);
					person.setName("personTest3");
					person.setMoney(70000.96);
					person.setCreateDate("2017-12-11");
					person.setMoneyTotal("80000.96");
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
		String source = rootPath + "test1.xlsx";
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
