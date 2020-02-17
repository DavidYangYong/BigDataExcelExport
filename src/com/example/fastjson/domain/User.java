package com.example.fastjson.domain;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author david
 * @create 2018-09-09 08:55
 **/
public class User implements Serializable {

	private String name;

	private int age;

	@JSONField(format="yyyy-MM-dd HH:mm")
	private Date createTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}




}
