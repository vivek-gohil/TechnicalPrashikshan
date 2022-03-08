package com.technicalprashikshan.main.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.technicalprashikshan.main.dao.interfaces.UserDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.UserDetailsRowMapper;
import com.technicalprashikshan.main.pojo.UserDetails;

@Repository
public class UserDetailsDAO implements UserDetailsDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsDAO.class);

	private static final String insertNewUserDetails = "insert into user_master (password , role) values(?,?)";
	private static final String updateUserDetails = "update user_master set password = ? ,role = ?  where user_id = ?";
	private static final String deleteUserDetails = "delete from user_master where user_id = ?";
	private static final String selectUserByUserId = "select * from user_master where user_id = ?";
	private static final String selectAllUserDetails = "select * from user_master order by user_id";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addNewUserDetails(UserDetails userDetails) {
		logger.info(userDetails.toString());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection.prepareStatement(insertNewUserDetails,
					new String[] { "user_id" });
			preparedStatement.setString(1, userDetails.getPassword());
			preparedStatement.setString(2, userDetails.getRole());
			return preparedStatement;
		}, keyHolder);

		int userId = keyHolder.getKey().intValue();
		logger.info("Generated UserId :: " + userId);
		return userId;
	}

	@Override
	public UserDetails updateUserDetails(UserDetails userDetails) {
		logger.info(userDetails.toString());
		Object[] args = { userDetails.getPassword(), userDetails.getRole(), userDetails.getUserId() };
		count = jdbcTemplate.update(updateUserDetails, args);
		if (count > 0) {
			logger.info("User Details Updated Successfully");
			return userDetails;
		} else {
			logger.info("Failed To Update User Details");
			return null;
		}
	}

	@Override
	public UserDetails getUserDetailsByUserId(int userId) {
		UserDetails userDetails = null;
		try {
			Object[] args = { userId };
			userDetails = jdbcTemplate.queryForObject(selectUserByUserId, new UserDetailsRowMapper(), args);
			if (userDetails != null)
				return userDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<UserDetails> getAllUsreDetails() {
		List<UserDetails> userDetailsList = jdbcTemplate.query(selectAllUserDetails, new UserDetailsRowMapper());
		return userDetailsList;
	}

	@Override
	public boolean deleteUserDetailsByUserId(int userId) {
		logger.info("" + userId);
		Object[] args = { userId };
		count = jdbcTemplate.update(deleteUserDetails, args);
		if (count > 0) {
			logger.info("User Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete User Details");
			return false;
		}
	}

}
