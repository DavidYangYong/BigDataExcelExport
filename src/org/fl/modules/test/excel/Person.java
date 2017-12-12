package org.fl.modules.test.excel;

import java.math.BigDecimal;
import org.fl.modules.excel.poi.annotation.Excel;
import org.fl.modules.excel.poi.exportExcel.entity.ExportTypeEnum;

public class Person {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Excel(exportName = "编号",orderNum = "3",exportOtherFormat = "#,##0")
	private Integer id;
	@Excel(exportName = "名称", orderNum = "1")
	private String name;

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Excel(exportName = "金额", orderNum = "2",exportOtherFormat = "#,##0.00")

	private Double money;

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Excel(exportName = "创建日期", orderNum = "4",exportFortmatType = ExportTypeEnum.EXPORT_TYPE_DATE,exportOtherFormat = "yyyy-MM-dd")

	private String createDate;

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	@Excel(exportName = "创建时间", orderNum = "5",exportFortmatType = ExportTypeEnum.EXPORT_TYPE_DATE,exportOtherFormat =
			"yyyy-MM-dd HH:mm:ss")

	private String createDateTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
