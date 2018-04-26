package com.jaon.demo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jaon.demo.domain.User;
import com.jaon.demo.mapper.IUserMapper;
import com.jaon.demo.service.IUserService;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements IUserService{


	@Resource
	private IUserMapper userMapper;

	@Override
	public List<User> getAll() {
		return userMapper.findAll();
	}

}
