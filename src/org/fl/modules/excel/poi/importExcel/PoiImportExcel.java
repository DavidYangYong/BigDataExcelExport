package org.fl.modules.excel.poi.importExcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.fl.modules.excel.AbstractImportExcel;
import org.fl.modules.excel.ExcelReturn;
import org.fl.modules.excel.IImportExcel;

public class PoiImportExcel extends AbstractImportExcel
		implements IImportExcel {
	
	public static boolean match(String str) {
		String regex = "^(-{0,1}[1-9]\\d*\\.\\d*|0\\.[0-9]{1,})|(-{0,1}[1-9]\\d*|0)$";
		Pattern p = Pattern.compile(regex);
		return p.matcher(str).matches();
	}
	
	public static boolean matchDate(String str) {
		if (str == null) {
			return false;
		} else if (str.trim().length() != 10) {
			return false;
		}
		String regex = "^((?:19|20|99)[0-9][0-9])-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
		Pattern p = Pattern.compile(regex);
		return p.matcher(str).matches();
	}
	
	private int columns;
	
	private Workbook workbook;
	
	/**
	 * 创建一个新的实例 JxlImportExcel.
	 */
	public PoiImportExcel(Workbook workbook) {
		this.workbook = workbook;
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * org.fl.modules.excel.IImportExcel#importExcelData(java.util.Collection)
	 */
	@Override
	public void importExcelData(Collection collection) {
	}
	
	public boolean isEmptyOrNull(String str) {
		return str == null || "".equals(str);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.fl.modules.excel.IImportExcel#validateExcelData()
	 */
	@Override
	public ExcelReturn validateExcelData() throws IOException {
		synchronized (workbook) {
			Sheet sheet = workbook.getSheetAt(0);
			
			try {
				boolean isSame = false;
				
				boolean isError = false;
				Object[] errors = null;
				for (int i = 2; i < sheet.getLastRowNum(); i++) {
					Row row = sheet.getRow(i);
					
					columns = row.getLastCellNum();
					errors = createObjects();
					List list = createRowCellValue(row);
					errors[0] = i + 1;
					
					// validateCell(errors, isError, isSame, sheet, row);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
				workbook.close();
				
			}
			
		}
		return null;
	}
	
	private Object[] createObjects() {
		Object[] errors = new Object[columns];
		
		for (int i = 0; i < errors.length; i++) {
			errors[i] = " ";
		}
		return errors;
	}
	
	/**
	 * 获得一行的所有单元格的数据，转换为list集合
	 */
	private List<String> createRowCellValue(Row row) {
		List<String> list = new ArrayList<String>(row.getLastCellNum());
		for (Cell cell : row) {
			CellReference cellRef = new CellReference(row.getRowNum(),
					cell.getColumnIndex());
			
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				list.add(cell.getRichStringCellValue().getString());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					System.out.println(cell.getDateCellValue());
				} else {
					System.out.println(cell.getNumericCellValue());
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				System.out.println(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				System.out.println(cell.getCellFormula());
				break;
			default:
				System.out.println();
			}
		}
		return list;
	}
	
}
