/*
 * 工程：SpringBootDemo
 * 文件：org.ldj.entity.User.java
 * 创建日期：2018年3月10日
 * 创建者：ldj
 *
 */
package org.ldj.test.entity;

import org.springframework.stereotype.Component;

/**
 * @author ldj
 *
 */
@Component
public class User {

	private Integer id;
	private String name;
	private String sex;
	
	
	public User() {
		super();
	}
	public User(Integer id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
	
}
