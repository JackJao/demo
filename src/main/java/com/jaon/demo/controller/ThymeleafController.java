package com.jaon.demo.controller;

import com.jaon.demo.domain.User;
import com.jaon.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 */
@Api("thymeleaf示例")
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
	
	@Resource
	private IUserService userService;

	@ApiOperation(value = "获取用户列表",notes = "获取用户列表")
	@GetMapping("/getAll")
	public String getAll(Map<String,Object> model){
		List<User> all = userService.getAll();
		model.put("contacts",all);
		return "home";
	}
}
