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
 * # * ExcelReturn.java Create on 2013-11-13 上午09:33:27
 * # * project qy-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：ExcelReturn.java
 * 版本信息：
 * 日期：2013-11-13
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package org.fl.modules.excel;

import java.util.Collection;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-13 上午09:33:27
 *          类说明
 */
/**
 * 项目名称：qy-modules-excel
 * 类名称：ExcelReturn
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-13 上午09:33:27
 * 修改人：David.Yang
 * 修改时间：2013-11-13 上午09:33:27
 * 修改备注：
 *
 * @version
 */
public class ExcelReturn {
	/**
	 * 验证失败的集合
	 */
	private Collection errorcCollection;
	/**
	 * 验证成功的集合
	 */
	private Collection rightCollection;
	
	public Collection getErrorcCollection() {
		return errorcCollection;
	}
	
	public Collection getRightCollection() {
		return rightCollection;
	}
	
	public boolean isError() {
		if (errorcCollection != null && errorcCollection.size() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean isRight() {
		if (rightCollection != null && rightCollection.size() > 0) {
			return true;
		}
		return false;
	}
	
	public void setErrorcCollection(Collection errorcCollection) {
		this.errorcCollection = errorcCollection;
	}
	
	public void setRightCollection(Collection rightCollection) {
		this.rightCollection = rightCollection;
	}
	
}
