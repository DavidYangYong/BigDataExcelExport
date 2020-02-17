package com.example.fastjson.controller;

import com.example.fastjson.domain.User;
import java.util.Date;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author david
 * @create 2018-09-09 08:54
 **/
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		return "hello,SpringBoot";
	}

	/**
	 * Spring boot 默认json解析框架是Jackson
	 * @return
	 */
	@RequestMapping("/getUser")
	public User getUser() {
		User u = new User();
		u.setName("张三");
		u.setAge(33);
		u.setCreateTime(new Date());
		return u;
	}
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		User u = new User();
		u.setName(user.getName()+"saveUser");
		u.setAge(33);
		u.setCreateTime(new Date());
		return u;
	}

}
