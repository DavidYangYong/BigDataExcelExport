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
 * # * Total.java Create on 2013-11-24 下午04:26:33
 * # * project david-modules-excel
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：Total.java
 * 版本信息：
 * 日期：2013-11-24
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package math.page;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-24 下午04:26:33
 *          类说明
 */
/**
 * 项目名称：david-modules-excel
 * 类名称：Total
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-24 下午04:26:33
 * 修改人：David.Yang
 * 修改时间：2013-11-24 下午04:26:33
 * 修改备注：
 *
 * @version
 */
public class Total implements Comparable<Total> {
	private long no;
	private int total;
	
	public int compareTo(Total o) {
		
		return this.getTotal().compareTo(o.getTotal());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Total other = (Total) obj;
		if (no != other.no)
			return false;
		if (total != other.total)
			return false;
		return true;
	}
	
	public long getNo() {
		return no;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (no ^ (no >>> 32));
		result = prime * result + total;
		return result;
	}
	
	public void setNo(long no) {
		this.no = no;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
}
