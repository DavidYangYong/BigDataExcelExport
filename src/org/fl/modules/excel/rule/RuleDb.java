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
 * # * RuleDb.java Create on 2013-11-13 下午02:56:36
 * # * project qy-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：RuleDb.java
 * 版本信息：
 * 日期：2013-11-13
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.excel.rule;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-13 下午02:56:36
 *          类说明
 */
/**
 * 项目名称：qy-modules-excel
 * 类名称：RuleDb
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-13 下午02:56:36
 * 修改人：David.Yang
 * 修改时间：2013-11-13 下午02:56:36
 * 修改备注：
 * 
 * @version
 */
public enum RuleDb {
	exsitDb("exsitDb", 2, "数据库中已经存在"), notExsitDb("notExsitDb", 5, "数据库中不存在");
	// 普通方法
	public static String getName(int index) {
		for (RuleDb c : RuleDb.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}
	
	private String error;
	
	private int index;
	
	private String name;
	
	private RuleDb(String name, int index, String error) {
		this.name = name;
		this.error = error;
		this.index = index;
	}
	
	public String getError() {
		return error;
	}
	
	public int getIndex() {
		return index;
	}
	
	// get set 方法
	public String getName() {
		return name;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
