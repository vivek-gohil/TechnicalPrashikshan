package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.pojo.ContactDetails;

public class ContactDetailsRowMapper implements RowMapper<ContactDetails> {
	private static final Logger logger = LoggerFactory.getLogger(ContactDetailsRowMapper.class);

	public ContactDetailsRowMapper() {
		logger.info("ContactDetailsRowMapper object created");
	}

	@Override
	public ContactDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		logger.info("ContactDetailsRowMapper mapRow");

		ContactDetails contactDetails = new ContactDetails();
		contactDetails.setContactId(resultSet.getInt("contact_id"));
		contactDetails.setFirstName(resultSet.getString("first_name"));
		contactDetails.setLastName(resultSet.getString("last_name"));
		contactDetails.setContactNumberOne(resultSet.getString("contact_number_1"));
		contactDetails.setContactNumberTwo(resultSet.getString("contact_number_2"));
		contactDetails.setEmailOne(resultSet.getString("email_1"));
		contactDetails.setEmailTwo(resultSet.getString("email_2"));
		contactDetails.setContactType(resultSet.getString("contact_type"));
		contactDetails.setContactStatus(resultSet.getString("contact_status"));
		
		logger.info(contactDetails.toString());

		return contactDetails;
	}

}
