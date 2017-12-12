package org.fl.modules.excel.poi.exportExcel.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.fl.modules.excel.poi.annotation.Excel;
import org.fl.modules.excel.poi.annotation.ExcelCollection;
import org.fl.modules.excel.poi.annotation.ExcelTarget;
import org.fl.modules.excel.poi.exportExcel.ISXSSFWorkBook;
import org.fl.modules.excel.poi.exportExcel.entity.ComparatorExcelField;
import org.fl.modules.excel.poi.exportExcel.entity.ExcelExportEntity;
import org.fl.modules.excel.poi.exportExcel.entity.ExportTypeEnum;
import org.fl.modules.utils.ExcelPublicUtil;

public class SXSSFWorkBookImpl implements ISXSSFWorkBook {

	private List<ExcelExportEntity> excelParams;

	public SXSSFWorkBookImpl(Class<?> pojoClass) {
		excelParams = new ArrayList<ExcelExportEntity>();
		// 得到所有字段
		Field fileds[] = ExcelPublicUtil.getClassFields(pojoClass);
		ExcelTarget etarget = pojoClass.getAnnotation(ExcelTarget.class);
		String targetId = null;
		if (etarget != null) {
			targetId = etarget.id();
		}
		try {
			getAllExcelField(targetId, fileds, excelParams, pojoClass, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sortAllParams(excelParams);
	}


	public void doExecute(Row contenRow, Object object, CellStyle cellStyle) {

		for (int i = 0; i < excelParams.size(); i++) {
			ExcelExportEntity excelExportEntity = excelParams.get(i);
			Cell contentCell = contenRow.createCell(i);
			try {
				Object tempValue = getCellValue(excelExportEntity, object);
				if (tempValue instanceof Integer) {
					Integer temp = (Integer) tempValue;
					contentCell.setCellValue(temp);
				} else if (tempValue instanceof Double) {
					contentCell.setCellValue((Double) tempValue);
				} else if (tempValue instanceof BigDecimal) {
					double doubleVal = ((BigDecimal) tempValue).doubleValue();
					contentCell.setCellValue(doubleVal);
				} else {
					if (ExportTypeEnum.EXPORT_TYPE_DATE.compareTo(excelExportEntity.getExportFortmatType()) == 0
							&& tempValue != null&&excelExportEntity.getExportOtherFormat()!=null) {
						try {
							SimpleDateFormat sdf = new SimpleDateFormat(excelExportEntity.getExportOtherFormat());
							String dateString = getValueStr(tempValue);
							Date date = sdf.parse(dateString);
							contentCell.setCellValue(date);
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						contentCell.setCellValue(getValueStr(tempValue));
					}
				}
				contentCell.setCellStyle(contenRow.getSheet().getColumnStyle(i));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	protected String getValueStr(Object object) {
		return object == null ? "" : object.toString();
	}

	private static Object getCellValue(ExcelExportEntity entity, Object obj) throws Exception {
		Object value = entity.getGetMethods() != null ? getFieldBySomeMethod(entity.getGetMethods(), obj)
				: entity.getGetMethod().invoke(obj, new Object[]{});
		return value;
	}

	/**
	 * 多个反射获取值
	 */
	private static Object getFieldBySomeMethod(List<Method> list, Object t) throws Exception {
		for (Method m : list) {
			if (t == null) {
				t = "";
				break;
			}
			t = m.invoke(t, new Object[]{});
		}
		return t;
	}

	/**
	 * 对字段根据用户设置排序
	 */
	private static void sortAllParams(List<ExcelExportEntity> excelParams) {
		Collections.sort(excelParams, new ComparatorExcelField());
		for (ExcelExportEntity entity : excelParams) {
			if (entity.getList() != null) {
				Collections.sort(entity.getList(), new ComparatorExcelField());
			}
		}
	}

	private static void getAllExcelField(String targetId, Field[] fields, List<ExcelExportEntity> excelParams,
			Class<?> pojoClass, List<Method> getMethods) throws Exception {
		// 遍历整个filed
		ExcelExportEntity excelEntity;
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			// 先判断是不是collection,在判断是不是java自带对象,之后就是我们自己的对象了
			if (ExcelPublicUtil.isNotUserExcelUserThis(field, targetId)) {
				continue;
			}
			if (ExcelPublicUtil.isCollection(field.getType())) {
				ExcelCollection excel = field.getAnnotation(ExcelCollection.class);
				ParameterizedType pt = (ParameterizedType) field.getGenericType();
				Class<?> clz = (Class<?>) pt.getActualTypeArguments()[0];
				List<ExcelExportEntity> list = new ArrayList<ExcelExportEntity>();
				getExcelFieldList(targetId, ExcelPublicUtil.getClassFields(clz), clz, list, null);
				excelEntity = new ExcelExportEntity();
				excelEntity.setName(getExcelName(excel.exportName(), targetId));
				excelEntity.setOrderNum(getCellOrder(excel.orderNum(), targetId));
				excelEntity.setGetMethod(ExcelPublicUtil.getMethod(field.getName(), pojoClass));
				excelEntity.setList(list);
				excelParams.add(excelEntity);
			} else if (ExcelPublicUtil.isJavaClass(field)) {
				Excel excel = field.getAnnotation(Excel.class);
				excelEntity = new ExcelExportEntity();
				excelEntity.setType(excel.exportType());
				getExcelField(targetId, field, excelEntity, excel, pojoClass);
				if (getMethods != null) {
					List<Method> newMethods = new ArrayList<Method>();
					newMethods.addAll(getMethods);
					newMethods.add(excelEntity.getGetMethod());
					excelEntity.setGetMethods(newMethods);
				}
				excelParams.add(excelEntity);
			} else {
				List<Method> newMethods = new ArrayList<Method>();
				if (getMethods != null) {
					newMethods.addAll(getMethods);
				}
				newMethods.add(ExcelPublicUtil.getMethod(field.getName(), pojoClass));
				getAllExcelField(targetId, ExcelPublicUtil.getClassFields(field.getType()), excelParams,
						field.getType(), newMethods);
			}
		}
	}

	/**
	 * @param targetId
	 * @param fields
	 * @param pojoClass
	 * @param list
	 * @param getMethods
	 * @throws Exception
	 */
	private static void getExcelFieldList(String targetId, Field[] fields, Class<?> pojoClass,
			List<ExcelExportEntity> list, List<Method> getMethods) throws Exception {
		ExcelExportEntity excelEntity;
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			if (ExcelPublicUtil.isNotUserExcelUserThis(field, targetId)) {
				continue;
			}
			if (ExcelPublicUtil.isJavaClass(field)) {
				Excel excel = field.getAnnotation(Excel.class);
				excelEntity = new ExcelExportEntity();
				getExcelField(targetId, field, excelEntity, excel, pojoClass);
				excelEntity.setType(excel.exportType());
				if (getMethods != null) {
					List<Method> newMethods = new ArrayList<Method>();
					newMethods.addAll(getMethods);
					newMethods.add(excelEntity.getGetMethod());
					excelEntity.setGetMethods(newMethods);
				}
				list.add(excelEntity);
			} else {
				List<Method> newMethods = new ArrayList<Method>();
				if (getMethods != null) {
					newMethods.addAll(getMethods);
				}
				newMethods.add(ExcelPublicUtil.getMethod(field.getName(), pojoClass));
				getExcelFieldList(targetId, ExcelPublicUtil.getClassFields(field.getType()), field.getType(), list,
						newMethods);
			}
		}
	}

	/**
	 * @param targetId
	 * @param field
	 * @param excelEntity
	 * @param excel
	 * @param pojoClass
	 * @throws Exception
	 */
	public static void getExcelField(String targetId, Field field, ExcelExportEntity excelEntity, Excel excel,
			Class<?> pojoClass) throws Exception {
		excelEntity.setName(getExcelName(excel.exportName(), targetId));
		excelEntity.setWidth(excel.exportFieldWidth());
		excelEntity.setHeight(excel.exportFieldHeight());
		excelEntity.setNeedMerge(excel.needMerge());
		excelEntity.setOrderNum(getCellOrder(excel.orderNum(), targetId));
		excelEntity.setWrap(excel.isWrap());
		excelEntity.setExportImageType(excel.imageType());
		excelEntity.setExportFormat(
				StringUtils.isNotEmpty(excel.exportFormat()) ? excel.exportFormat() : excel.imExFormat());
		excelEntity.setExportOtherFormat(excel.exportOtherFormat());
		String fieldname = field.getName();
		excelEntity.setGetMethod(ExcelPublicUtil.getMethod(fieldname, pojoClass));
		excelEntity.setExportFortmatType(excel.exportFortmatType());
		if (excel.exportConvertSign() == 1 || excel.imExConvert() == 1) {
			StringBuffer getConvertMethodName = new StringBuffer("convertGet");
			getConvertMethodName.append(fieldname.substring(0, 1).toUpperCase());
			getConvertMethodName.append(fieldname.substring(1));
			Method getConvertMethod = pojoClass.getMethod(getConvertMethodName.toString(), new Class[]{});
			excelEntity.setGetMethod(getConvertMethod);
		}
	}

	/**
	 * 判断在这个单元格显示的名称
	 */
	private static String getExcelName(String exportName, String targetId) {
		if (exportName.indexOf(",") < 0) {
			return exportName;
		}
		String[] arr = exportName.split(",");
		for (String str : arr) {
			if (str.indexOf(targetId) != -1) {
				return str.split("_")[0];
			}
		}
		return null;
	}

	/**
	 * 获取这个字段的顺序
	 */
	private static int getCellOrder(String orderNum, String targetId) {
		if (isInteger(orderNum) || targetId == null) {
			return Integer.valueOf(orderNum);
		}
		String[] arr = orderNum.split(",");
		for (String str : arr) {
			if (str.indexOf(targetId) != -1) {
				return Integer.valueOf(str.split("_")[0]);
			}
		}
		return 0;
	}

	/**
	 * 判断字符串是否是整数
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void doExecuteCreateTitle(Sheet sheet) {
		Row contenRow = sheet.createRow(0);
		Cell contentCell = null;
		for (int i = 0, exportFieldTitleSize = excelParams.size(); i < exportFieldTitleSize; i++) {
			ExcelExportEntity entity = excelParams.get(i);
			contentCell = contenRow.createCell(i);
			contentCell.setCellValue(entity.getName());
			if (entity != null && entity.getWidth() == 0) {
				sheet.setColumnWidth(i, 10 * 2 * 256);//默认10个中文字符
			} else {
				sheet.setColumnWidth(i, entity.getWidth() * 2 * 256);//根据注解上设置的宽度进行设置
			}
			if (entity != null && StringUtils.isNotEmpty(entity.getExportOtherFormat())) {
				CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
				if (ExportTypeEnum.EXPORT_TYPE_DATE.compareTo(entity.getExportFortmatType()) == 0) {
					DataFormat dataFormat = sheet.getWorkbook().createDataFormat();
					cellStyle.setDataFormat(dataFormat.getFormat(entity.getExportOtherFormat()));
				} else {
					cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(entity.getExportOtherFormat()));
				}

				sheet.setDefaultColumnStyle(i, cellStyle);
			}
		}

	}


}

