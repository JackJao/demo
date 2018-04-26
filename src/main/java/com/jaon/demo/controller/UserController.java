package com.jaon.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaon.demo.domain.User;
import com.jaon.demo.service.IUserService;

import javax.annotation.Resource;


/**
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private IUserService userService;

	@GetMapping("/getAll")
	public List<User> getAll(){
		return userService.getAll();
	}
}
