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
 * # * ImportValidate.java Create on 2013-11-13 上午10:24:12
 * # * project qy-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：ImportValidate.java
 * 版本信息：
 * 日期：2013-11-13
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.excel.rule;

import java.io.Serializable;
import java.util.regex.Pattern;

import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-13 上午10:24:12
 *          类说明
 */
/**
 * 项目名称：qy-modules-excel
 * 类名称：ImportValidate
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-13 上午10:24:12
 * 修改人：David.Yang
 * 修改时间：2013-11-13 上午10:24:12
 * 修改备注：
 * 
 * @version
 */
public class ImportValidatePredicate implements Predicate, Serializable {
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
	
	private ImportValidateRule importValidateRule;
	
	/***
	 * 单元格验证规则定义
	 */
	@Override
	public boolean evaluate(Object obj) {
		
		boolean b = true;
		if (obj instanceof ImportValidateRule) {
			ImportValidateRule importValidateRuledateRuleTemp = (ImportValidateRule) obj;
			Rule rule = importValidateRuledateRuleTemp.getRule();
			String value = importValidateRuledateRuleTemp.getValue();
			switch (rule) {
			case emptyOrNull:
				b = StringUtils.isNotEmpty(value);
				if (b) {
					rule.setError("");
					importValidateRuledateRuleTemp.setRule(rule);
				} else {
					Rule[] rules = importValidateRuledateRuleTemp.getSubRules();
					for (int i = 0; i < rules.length; i++) {
						Rule ruleTemp = rules[i];
						evaluate(value, ruleTemp,
						        importValidateRuledateRuleTemp);
					}
				}
				break;
			case formatError:
				evaluate(value, rule, importValidateRuledateRuleTemp);
				break;
			case ltOne:
				evaluate(value, rule, importValidateRuledateRuleTemp);
				break;
			case notNumber:
				evaluate(value, rule, importValidateRuledateRuleTemp);
				break;
			default:
				break;
			}
			
		} else {
			b = false;
		}
		
		return b;
		
	}
	
	public boolean evaluate(String value, Rule rule,
	        ImportValidateRule importValidateRuledateRuleTemp) {
		
		boolean b = true;
		
		switch (rule) {
		case formatError:
			b = !matchDate(value.trim());
			if (b) {
				rule.setError("");
				importValidateRuledateRuleTemp.setRule(rule);
			}
			break;
		case ltOne:
			b = Double.parseDouble(value) <= 0;
			if (b) {
				rule.setError("");
				importValidateRuledateRuleTemp.setRule(rule);
			}
			break;
		case notNumber:
			b = match(value.trim());
			if (b) {
				rule.setError("");
				importValidateRuledateRuleTemp.setRule(rule);
			}
			break;
		default:
			break;
		}
		
		return b;
		
	}
	
	public ImportValidateRule getImportValidateRule() {
		return importValidateRule;
	}
	
	public void setImportValidateRule(ImportValidateRule importValidateRule) {
		this.importValidateRule = importValidateRule;
	}
}
