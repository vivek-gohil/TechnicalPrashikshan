package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.pojo.UserDetails;

public class UserDetailsRowMapper implements RowMapper<UserDetails> {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsRowMapper.class);

	@Override
	public UserDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		logger.info("UserDetailsRowMapper mapRow");

		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(resultSet.getInt("user_id"));
		userDetails.setPassword(resultSet.getString("password"));
		userDetails.setRole(resultSet.getString("role"));

		logger.info(userDetails.toString());

		return userDetails;
	}

}
