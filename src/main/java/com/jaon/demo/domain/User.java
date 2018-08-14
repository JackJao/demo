package com.jaon.demo.domain;

import org.springframework.format.annotation.DateTimeFormat;

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
	private String username;
	private String password;
	private boolean enabled = true;
	private boolean locked = true;
	private Date birthday;
	private Date createrTime = new Date();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public Date getBirthday() {
		return birthday;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreaterTime() {
		return createrTime;
	}

	public void setCreaterTime(Date createrTime) {
		this.createrTime = createrTime;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", enabled=" + enabled +
				", locked=" + locked +
				", birthday=" + birthday +
				", createrTime=" + createrTime +
				'}';
	}
}
