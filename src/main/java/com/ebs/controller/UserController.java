package com.ebs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ebs.dao.UserDAOImpl;
import com.ebs.entity.User;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

	@Autowired
	UserDAOImpl dao;

	@PostMapping("/AddUser")
	public String addUser(@RequestBody User user) {
		String msg = "";
		try {
			dao.addUser(user);
			msg = "User Object Saved";
		} catch (Exception e) {
			msg = "User Object Not Saved";
		}
		return msg;
	}

	@GetMapping("/GetAllUser")
	List<User> getAllUser() {
		return dao.getAllUser();
	}

	@GetMapping("/GetUserIds")
	List<User> getUserIds() {
		return dao.getUserIds();
	}

}
