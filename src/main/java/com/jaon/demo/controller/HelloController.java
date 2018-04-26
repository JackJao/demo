package com.jaon.demo.controller;

import com.jaon.demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * value 和 path 作用相同，可用于普通的url：
 * 例如：RequestMapping("/user") 和 RequestMapping(path="/user")和RequestMapping(value="/user")
 * 两者都可以使用@PathVariable注解，该注解用于解析url中的变量并映射为接收参数值
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

	@PostMapping("user")
	public User getUser() {
		User u = new User();
		u.setId(1L);
		u.setCode(28);
		u.setName("admin");
		return u;
	}
	
	@GetMapping(path= {"/path/{id:[0-9]}"},params= {"code"})
	public String sayHello(@PathVariable Integer id) {
		return "hello world!"+id;
	}
	
	@GetMapping(value= {"/path2/{id:[a-z]}"},params= {"code2"})
	public String sayHello2(@PathVariable("id") String id3) {
		return "hello world 2 !"+id3;
	}
	
	
	@GetMapping("/path3/{id:[a-z]}")
	public String sayHello3(@PathVariable("id") String str,@RequestParam String id) {
		return "hello world 3 !"+id+"===str="+str;
	}
}
