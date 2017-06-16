package com.dlizarra.starter.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<String> findAll() {
		List<String> out = new ArrayList<String>();
		out.add("Yes,");
		out.add("it");
		out.add("seems");
		out.add("I'm");
		out.add("still");
		out.add("working.");
		return out;
	}
//	public List<UserDto> findAll() {
//		return userService.getUsers();
//	}

}
