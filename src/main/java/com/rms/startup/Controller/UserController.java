package com.rms.startup.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.startup.Bean.UserBean;
import com.rms.startup.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	@GetMapping("/logIn")
	public List<UserBean> showData()
	{
		return userService.getAllUser();
	}

//	@GetMapping("/logInList")
//	public List<Map<String, Object>> show()
//	{
//		//return jdbcObject.queryForList("select * from User;");
//	}
}
