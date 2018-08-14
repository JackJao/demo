package com.jaon.demo.service;

import com.jaon.demo.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IUserService extends UserDetailsService{

	/**
     * spring security 认证的方法
	 * @param username
     * @return
     * @throws UsernameNotFoundException
	 */
	@Override
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

	/**
	 * 获取所有用户
	 * @return allUserInfo
	 */
	List<User> getAll();

	/**
     * 根据用户名获取用户信息
	 * @param name
     * @return
     */
	User getUserByName(String name);

	/**
     * 保存用户
	 * @return
     */
	int saveUser(User user);
}
