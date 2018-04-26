package com.jaon.demo.domain;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5825896777778390022L;

	private Long id;
	private String name;
	private Integer code;
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
