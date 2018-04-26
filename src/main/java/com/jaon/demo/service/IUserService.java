package com.jaon.demo.service;

import java.util.List;

import com.jaon.demo.domain.User;

/**
 *
 * @author Administrator
 */
public interface IUserService {

	/**
	 * 获取所有用户
	 * @return allUserInfo
	 */
	List<User> getAll();
}
