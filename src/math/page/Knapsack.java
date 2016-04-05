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
 * # * Knapsack.java Create on 2013-11-22 上午11:25:40
 * # * project Test
 * # * Copyright 2013 by .
 * #
 */
/**
 * 文件名：Knapsack.java
 * 版本信息：
 * 日期：2013-11-22
 * Copyright 足下 Corporation 2013
 * 版权所有
 */
package math.page;

/**
 * @author David.Yang
 * @version 1.0
 *          CreateDate：2013-11-22 上午11:25:40
 *          类说明
 */
/**
 * 项目名称：Test
 * 类名称：Knapsack
 * 类描述：
 * 创建人：David.Yang
 * 创建时间：2013-11-22 上午11:25:40
 * 修改人：David.Yang
 * 修改时间：2013-11-22 上午11:25:40
 * 修改备注：
 *
 * @version
 */
public class Knapsack implements Comparable<Knapsack> {
	private long no;
	/** 背包物品价值 */
	private int value;
	
	/** 背包重量 */
	private int weight;
	
	/***
	 * 构造器
	 */
	public Knapsack(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Knapsack o) {
		
		return this.getWeight().compareTo(o.getWeight());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knapsack other = (Knapsack) obj;
		if (no != other.no)
			return false;
		if (value != other.value)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	public long getNo() {
		return no;
	}
	
	public int getValue() {
		return value;
	}
	
	public Integer getWeight() {
		return weight;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (no ^ (no >>> 32));
		result = prime * result + value;
		result = prime * result + weight;
		return result;
	}
	
	public void setNo(long no) {
		this.no = no;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		// return "[weight: " + weight + " " + "value: " + value + "]";
		return "" + weight;
	}
}
