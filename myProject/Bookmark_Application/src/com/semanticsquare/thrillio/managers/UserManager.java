package com.semanticsquare.thrillio.managers;

import java.util.List;

import com.semanticsquare.thrillio.constants.Gender;
import com.semanticsquare.thrillio.dao.UserDao;
import com.semanticsquare.thrillio.entities.User;

// Singleton Design
// We need to make constructor private to instantiate manager once

public class UserManager {

	private static UserManager instance = new UserManager();
	private static UserDao dao = new UserDao(); // to let manager call getUsers()

	private UserManager() {}

// static since we cannot create an instance of the class	
	public static UserManager getInstance() {
		return instance;
	}

	public User createUser(long id, String email, String password, String firstName, String lastName, Gender gender,
			String userType) {
		
		User user = new User();
		
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		
		return user;
	}
	
	public List<User> getUsers() {
		return dao.getUsers();
	}
}
