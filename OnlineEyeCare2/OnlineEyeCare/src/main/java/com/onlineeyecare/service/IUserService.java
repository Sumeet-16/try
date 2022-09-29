package com.onlineeyecare.service;

import com.onlineeyecare.dto.User;
import com.onlineeyecare.exceptions.PasswordNotMatchException;
import com.onlineeyecare.exceptions.UserNotFoundException;

public interface IUserService {
	public Boolean signIn(User user) throws UserNotFoundException;
	public Boolean signOut(User user) throws UserNotFoundException;
	public User changePassword(String userName, User user) throws UserNotFoundException, PasswordNotMatchException;
}
