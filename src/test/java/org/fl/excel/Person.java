package test.java.org.fl.excel;

import org.fl.modules.excel.poi.annotation.Excel;
import org.fl.modules.excel.poi.exportExcel.entity.ExportTypeEnum;

public class Person {

	@Excel(exportName = "编号", orderNum = "3", exportOtherFormat = "#,##0")
	private Integer id;
	@Excel(exportName = "名称", orderNum = "1")
	private String name;
	@Excel(exportName = "金额", orderNum = "2", exportOtherFormat = "#,##0.00")

	private Double money;
	@Excel(exportName = "创建日期", orderNum = "4", exportFortmatType = ExportTypeEnum.EXPORT_TYPE_DATE, exportOtherFormat =
			"yyyy-MM-dd")

	private String createDate;
	@Excel(exportName = "创建时间", orderNum = "5", exportFortmatType = ExportTypeEnum.EXPORT_TYPE_DATE, exportOtherFormat =
			"yyyy-MM-dd HH:mm:ss")

	private String createDateTime;
	@Excel(exportName = "总金额", orderNum = "6", exportOtherFormat = "#,##0.00", exportFortmatType = ExportTypeEnum
			.EXPORT_TYPE_BIGDECIMAL)

	private String moneyTotal;
	@Excel(exportName = "金额1", orderNum = "7", exportOtherFormat = "#,##0.00")

	private Float moneyFloat;

	public Float getMoneyFloat() {
		return moneyFloat;
	}

	public void setMoneyFloat(Float moneyFloat) {
		this.moneyFloat = moneyFloat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMoneyTotal() {
		return moneyTotal;
	}

	public void setMoneyTotal(String moneyTotal) {
		this.moneyTotal = moneyTotal;
	}

}
