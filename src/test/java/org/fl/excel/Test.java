package test.java.org.fl.excel;

import static org.fl.modules.excel.poi.exportExcel.entity.ExportTypeEnum.EXPORT_TYPE_DATE;

/**
 * @author david
 * @create 2017-12-14 15:01
 **/
public class Test {

	public static void main(String[] args) {
		org.fl.modules.excel.poi.exportExcel.entity.ExportTypeEnum exportTypeEnum = EXPORT_TYPE_DATE;
		switch (exportTypeEnum) {
			case EXPORT_TYPE_DATE:
				System.out.println(1);
				break;
			default:
				System.out.println(2);
				break;

		}
	}
}
