package com.jaon.demo.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * 使用jackson的时候返回的对象需要去掉值为null的字段配置：
 * 对象类上加@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
 * 推荐：@JsonInclude(value = JsonInclude.Include.NON_NULL)
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5825896777778390022L;

	private Long id;
	private String name;
	private Integer code;
	private Date birthday;
	private Date createrTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreaterTime() {
		return createrTime;
	}

	public void setCreaterTime(Date createrTime) {
		this.createrTime = createrTime;
	}

	public User(String name, Integer code) {
		super();
		this.name = name;
		this.code = code;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
}
