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
 * # * PredicateChainExample.java Create on 2013-11-13 上午11:43:15
 * # * project qy-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：PredicateChainExample.java
 * 版本信息：
 * 日期：2013-11-13
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.test.excel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.fl.modules.excel.rule.ImportValidatePredicate;
import org.fl.modules.excel.rule.ImportValidateRule;
import org.fl.modules.excel.rule.Rule;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-13 上午11:43:15
 *          类说明
 */
/**
 * 项目名称：qy-modules-excel
 * 类名称：PredicateChainExample
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-13 上午11:43:15
 * 修改人：David.Yang
 * 修改时间：2013-11-13 上午11:43:15
 * 修改备注：
 * 
 * @version
 */
public class PredicateChainExample {
	public static void main(String[] args) {
		PredicateChainExample chainExample = new PredicateChainExample();
		chainExample.setUpData();
		chainExample.filterDataUsingMultipleCriteria();
	}
	
	List<ImportValidateRule> personList = new ArrayList<ImportValidateRule>();
	
	/**
	 * Here we are adding multiple predicate
	 * filters the collection so that final person object will contain
	 * firstName as "ganesh" & lastName as "gowtham"
	 */
	void filterDataUsingMultipleCriteria() {
// ImportValidateRule importValidateRule = new ImportValidateRule();
// importValidateRule.setAlias("包件编码");
// importValidateRule.setIndex(0);
// importValidateRule.setRule(Rule.emptyOrNull);
		ImportValidatePredicate firstNameEqlPredicate = new ImportValidatePredicate();
		// firstNameEqlPredicate.setImportValidateRule(importValidateRule);
		Predicate[] allPredicateArray = { firstNameEqlPredicate };
		Predicate allPredicate = PredicateUtils.allPredicate(allPredicateArray);
		Collection<ImportValidateRule> filteredSuccessCollection = CollectionUtils
		        .select(personList, allPredicate);
		Collection<ImportValidateRule> filteredCollection = CollectionUtils
		        .selectRejected(personList, allPredicate);
		// CollectionUtils.filter(personList, firstNameEqlPredicate);
// for (ImportValidateRule person : personList) {
// System.out.println(person.toString());
// }
	}
	
	/**
	 * Basic method which creates the list of person object's
	 */
	void setUpData() {
		ImportValidateRule importValidateRule = new ImportValidateRule();
		importValidateRule.setAlias("包件编码");
		importValidateRule.setIndex(0);
		importValidateRule.setRule(Rule.emptyOrNull);
		importValidateRule.setValue("");
		personList.add(importValidateRule);
		importValidateRule = new ImportValidateRule();
		importValidateRule.setAlias("工厂编码");
		importValidateRule.setIndex(2);
		importValidateRule.setRule(Rule.emptyOrNull);
		importValidateRule.setValue("2001");
		personList.add(importValidateRule);
	}
}
