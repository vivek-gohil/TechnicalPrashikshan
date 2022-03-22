package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.UserDetails;

public interface UserDetailsServiceInterface {
	public int addNewUserDetails(UserDetails userDetails);

	public UserDetails updateUserDetails(UserDetails userDetails);

	public UserDetails getUserDetailsByUserId(int userId);

	public List<UserDetails> getAllUsreDetails();

	public boolean deleteUserDetailsByUserId(int userId);

	public UserDetails userLogin(UserDetails userDetails);
}
