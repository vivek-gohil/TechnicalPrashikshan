package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.UserDetails;

public interface UserDetailsDAOInterface {
	public int addNewUserDetails(UserDetails userDetails);

	public UserDetails updateUserDetails(UserDetails userDetails);

	public UserDetails getUserDetailsByUserId(int userId);

	public List<UserDetails> getAllUsreDetails();

	public boolean deleteUserDetailsByUserId(int userId);

	public UserDetails userLogin(UserDetails userDetails);
}
