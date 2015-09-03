/*
 * Copyright (C) 2013 Open Source Project
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * # * ImportValidateRule.java Create on 2013-11-13 上午10:18:07
 * # * project qy-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：ImportValidateRule.java
 * 版本信息：
 * 日期：2013-11-13
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.excel.rule;

import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-13 上午10:18:07
 *          类说明
 *          数据验证规则定义
 */
/**
 * 项目名称：qy-modules-excel
 * 类名称：ImportValidateRule
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-13 上午10:18:07
 * 修改人：David.Yang
 * 修改时间：2013-11-13 上午10:18:07
 * 修改备注：
 * 
 * @version
 */
public class ImportValidateRule {
	
	private String alias;
	
	private String cellName;
	
	private int index;
	
	private boolean isShowValue;
	
	private Predicate predicate;
	
	private Rule rule;
	
	private Rule[] subRules;
	
	private String value;
	
	public String getAlias() {
		return alias;
	}
	
	public String getCellName() {
		return cellName;
	}
	
	public int getIndex() {
		return index;
	}
	
	public Rule getRule() {
		return rule;
	}
	
	public Rule[] getSubRules() {
		return subRules;
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean isShowValue() {
		return isShowValue;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setPredicate(Predicate predicate) {
		this.predicate = predicate;
	}
	
	public void setRule(Rule rule) {
		this.rule = rule;
	}
	
	public void setShowValue(boolean isShowValue) {
		this.isShowValue = isShowValue;
	}
	
	public void setSubRules(Rule[] subRules) {
		this.subRules = subRules;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		if (rule != null && StringUtils.isNotEmpty(rule.getError())) {
			if (StringUtils.isNotEmpty(alias)) {
				stringBuffer.append(alias);
			}
			if (isShowValue && StringUtils.isNotEmpty(value)) {
				stringBuffer.append(value);
			}
			
			stringBuffer.append(rule.getError());
			
		}
		return stringBuffer.toString();
	}
}
