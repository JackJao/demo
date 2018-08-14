package com.jaon.demo.service.impl;

import com.jaon.demo.domain.User;
import com.jaon.demo.mapper.IUserMapper;
import com.jaon.demo.service.IUserService;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements IUserService {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	private IUserMapper userMapper;
	@Resource
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getUserByName(username);
		if(user == null){
			LOG.info("用户未找到，不存在");
			throw new UsernameNotFoundException("用户未找到");
		}
		LOG.info("当前登录用户用户信息："+user);
		boolean enabled = true;//帐号可用
		boolean accountNonExpired = true;//帐号未过期
		boolean credentialsNonExpired = true;//凭据未过期
		boolean accountNonLocked = true;//账号未锁定
		//密码数据库查询，授权给固定字符串"admin"
		return new org.springframework.security.core.userdetails.User(username,user.getPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonLocked, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		//默认全部
		//return new org.springframework.security.core.userdetails.User(username,user.getCode().toString(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		//return new org.springframework.security.core.userdetails.User(username,"123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

	@Override
	public List<User> getAll() {
		return userMapper.findAll();
	}

	@Override
	public User getUserByName(String name) {
		return userMapper.selectUserByName(name);
	}

	@Override
	public int saveUser(User user) {
		String rwp = user.getPassword();
		//第一次测试用明文登录，然后插入用户，在注释
		//user.setPassword(new BCryptPasswordEncoder().encode(rwp));
		user.setPassword(passwordEncoder.encode(rwp));
		return userMapper.insert(user);
	}

}
