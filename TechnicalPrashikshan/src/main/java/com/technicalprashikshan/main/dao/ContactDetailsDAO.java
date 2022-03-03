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

import com.technicalprashikshan.main.dao.interfaces.ContactDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.ContactDetailsRowMapper;
import com.technicalprashikshan.main.pojo.ContactDetails;

@Repository
public class ContactDetailsDAO implements ContactDetailsDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(ContactDetailsDAO.class);

	private static final String insertNewContactDetails = "insert into contact_master(first_name,last_name,email,contact_number) values(?,?,?,?)";
	private static final String updateContactDetails = "update contact_master set first_name = ? , last_name = ? , email = ? , contact_number = ? where contact_id = ?";
	private static final String deleteContactDetails = "delete from contact_master where contact_id = ?";
	private static final String selectContactDetailsByContactId = "select * from contact_master where contact_id = ?";
	private static final String selectAllContactDetails = "select * from contact_master order by first_name";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ContactDetailsDAO() {
	}

	public ContactDetailsDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addNewContactDetails(ContactDetails contactDetails) {

		logger.info(contactDetails.toString());

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection.prepareStatement(insertNewContactDetails,
					new String[] { "contact_id" });
			preparedStatement.setString(1, contactDetails.getFirstName());
			preparedStatement.setString(2, contactDetails.getLastName());
			preparedStatement.setString(3, contactDetails.getEmail());
			preparedStatement.setString(4, contactDetails.getContactNumber());
			return preparedStatement;
		}, keyHolder);

		int contactId = keyHolder.getKey().intValue();
		logger.info("Generated ContactId :: " + contactId);
		return contactId;
	}

	@Override
	public ContactDetails updateContactDetails(ContactDetails contactDetails) {
		logger.info(contactDetails.toString());
		Object[] args = { contactDetails.getFirstName(), contactDetails.getLastName(), contactDetails.getEmail(),
				contactDetails.getContactNumber(), contactDetails.getContactId() };
		count = jdbcTemplate.update(updateContactDetails, args);
		if (count > 0) {
			logger.info("Contact Details Updated Successfully");
			return contactDetails;
		} else {
			logger.info("Failed To Update Contact Details");
			return null;
		}

	}

	@Override
	public ContactDetails getContactDetailsByContactId(int contactId) {
		ContactDetails contactDetails = null;
		try {
			Object[] args = { contactId };
			contactDetails = jdbcTemplate.queryForObject(selectContactDetailsByContactId, new ContactDetailsRowMapper(),
					args);
			if (contactDetails != null)
				return contactDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<ContactDetails> getAllContactDetails() {
		List<ContactDetails> contactDetailsList = jdbcTemplate.query(selectAllContactDetails,
				new ContactDetailsRowMapper());
		return contactDetailsList;
	}

	@Override
	public boolean deleteContactDetailsByContactId(int contactId) {
		logger.info("" + contactId);
		Object[] args = { contactId };
		count = jdbcTemplate.update(deleteContactDetails, args);
		if (count > 0) {
			logger.info("Contact Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete Contact Details");
			return false;
		}
	}

}
