package org.fl.modules.excel.poi.importExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.fl.modules.excel.AbstractImportExcelSupport;
import org.fl.modules.excel.IImportExcel;

public class PoiImportExcelFactory extends AbstractImportExcelSupport {
	private String type;
	
	/**
	 * 创建一个新的实例 JxlImportExcel.
	 *
	 * @param file
	 */
	public PoiImportExcelFactory(File file) {
		super(file);
		type = "excel";
		// TODO Auto-generated constructor stub
	}
	
	public PoiImportExcelFactory(File file, String type) {
		super(file);
		this.type = type;
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.fl.modules.excel.AbstractImportExcel#createImportExcel()
	 */
	@Override
	public IImportExcel createImportExcel() throws IOException {
		
		try {
			return createImportExcel(type);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public IImportExcel createImportExcel(String type) throws IOException,
			EncryptedDocumentException, InvalidFormatException {
		if (getImportFile() != null) {
			InputStream inp = new FileInputStream(getImportFile());
			Workbook workbook = WorkbookFactory.create(inp);
			if (workbook == null) {
				throw new IOException("读取导入excel文件错误");
			}
			
			if (StringUtils.equals("excelRule", type)) {
				return new PoiImportExcelRule(workbook);
			}
			return new PoiImportExcel(workbook);
		}
		return null;
	}
}
