package com.technicalprashikshan.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technicalprashikshan.main.pojo.UserDetails;
import com.technicalprashikshan.main.service.interfaces.UserDetailsServiceInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("technicalprashikshanapi/userdetailsapi")
public class UserDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsController.class);

	@Autowired
	private UserDetailsServiceInterface userDetailsService;

	public UserDetailsController() {
		logger.info("UserDetailsController object created");
	}

	@RequestMapping(value = "userdetails", method = RequestMethod.POST)
	public int newClientDetails(@RequestBody UserDetails userDetails) {
		logger.info(userDetails.toString());
		return userDetailsService.addNewUserDetails(userDetails);
	}

	@RequestMapping(value = "userdetails/{userId}", method = RequestMethod.DELETE)
	public boolean deleteClientDetails(@PathVariable int userId) {
		logger.info("" + userId);
		return userDetailsService.deleteUserDetailsByUserId(userId);
	}

	@RequestMapping(value = "userdetails", method = RequestMethod.PUT)
	public UserDetails updateClientDetails(@RequestBody UserDetails userDetails) {
		logger.info(userDetails.toString());
		return userDetailsService.updateUserDetails(userDetails);
	}

	@RequestMapping(value = "userdetails/all", method = RequestMethod.GET)
	public List<UserDetails> getAllClientDetails() {
		logger.info("Retriving all client details");
		return userDetailsService.getAllUsreDetails();
	}

	@RequestMapping(value = "userdetails/{userId}", method = RequestMethod.GET)
	public UserDetails getSingleClientDetails(@PathVariable int userId) {
		logger.info("" + userId);
		return userDetailsService.getUserDetailsByUserId(userId);
	}

	@RequestMapping(value = "userdetails/login", method = RequestMethod.POST)
	public UserDetails userLogin(@RequestBody UserDetails userDetails) {
		logger.info("userLogin");
		logger.info(userDetails.toString());
		return userDetailsService.userLogin(userDetails);
	}

}
