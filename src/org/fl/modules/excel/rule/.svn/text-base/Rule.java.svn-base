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
 * # * Rule.java Create on 2013-11-13 上午10:24:44
 * # * project qy-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：Rule.java
 * 版本信息：
 * 日期：2013-11-13
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.excel.rule;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-13 上午10:24:44
 *          类说明
 */
/**
 * 项目名称：qy-modules-excel
 * 类名称：Rule
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-13 上午10:24:44
 * 修改人：David.Yang
 * 修改时间：2013-11-13 上午10:24:44
 * 修改备注：
 * 
 * @version
 */
public enum Rule {
	emptyOrNull("emptyOrNull", 1, "不能为空"), formatError("formatError", 2,
	        "格式不正确"), ltOne("ltOne", 3, "不能小于1"), notNumber("notNumber", 4,
	        "不是有效数字");
	// 普通方法
	public static String getName(int index) {
		for (Rule c : Rule.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}
	
	private String error;
	
	private int index;
	
	private String name;
	
	private Rule(String name, int index, String error) {
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
