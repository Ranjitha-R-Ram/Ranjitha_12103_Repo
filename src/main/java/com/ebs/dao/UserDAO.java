package com.ebs.dao;

import java.util.List;
import com.ebs.entity.User;

public interface UserDAO {

	public void addUser(User user);

	List<User> getAllUser();

	List<User> getUserIds();

}
