package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.UserDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.UserDetails;
import com.technicalprashikshan.main.service.interfaces.UserDetailsServiceInterface;

@Service
public class UserDetailsService implements UserDetailsServiceInterface {

	@Autowired
	private UserDetailsDAOInterface userDetailsDAO;

	@Override
	public int addNewUserDetails(UserDetails userDetails) {
		return userDetailsDAO.addNewUserDetails(userDetails);
	}

	@Override
	public UserDetails updateUserDetails(UserDetails userDetails) {
		return userDetailsDAO.updateUserDetails(userDetails);
	}

	@Override
	public UserDetails getUserDetailsByUserId(int userId) {
		return userDetailsDAO.getUserDetailsByUserId(userId);
	}

	@Override
	public List<UserDetails> getAllUsreDetails() {
		return userDetailsDAO.getAllUsreDetails();
	}

	@Override
	public boolean deleteUserDetailsByUserId(int userId) {
		return userDetailsDAO.deleteUserDetailsByUserId(userId);
	}
}
