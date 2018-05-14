package com.jaon.demo.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaon.demo.domain.User;
import com.jaon.demo.service.IUserService;

import javax.annotation.Resource;


/**
 * @author Administrator
 */
@Api("用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private IUserService userService;

	@ApiOperation(value = "获取用户列表",notes = "获取用户列表")
	@GetMapping("/getAll")
	public List<User> getAll(){
		return userService.getAll();
	}
}
