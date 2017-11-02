package org.fl.modules.test.excel;

import java.math.BigDecimal;
import org.fl.modules.excel.poi.annotation.Excel;

public class Person {

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Excel(exportName = "编号")
	private BigDecimal id;
	@Excel(exportName = "名称", orderNum = "1")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
