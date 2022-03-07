package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.dao.ContactDetailsDAO;
import com.technicalprashikshan.main.pojo.ClientDetails;
import com.technicalprashikshan.main.pojo.ContactDetails;

public class ClientDetailsRowMapper implements RowMapper<ClientDetails> {

	private static final Logger logger = LoggerFactory.getLogger(ClientDetailsRowMapper.class);
	private JdbcTemplate jdbcTemplate;

	public ClientDetailsRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public ClientDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		logger.info("ClientDetailsRowMapper mapRow");

		ClientDetails clientDetails = new ClientDetails();

		clientDetails.setClientId(resultSet.getInt("client_id"));
		clientDetails.setCompanyName(resultSet.getString("company_name"));
		clientDetails.setAddressLineOne(resultSet.getString("address_line_1"));
		clientDetails.setAddressLineTwo(resultSet.getString("address_line_2"));
		clientDetails.setLandmark(resultSet.getString("landmark"));
		clientDetails.setCity(resultSet.getString("city"));
		clientDetails.setState(resultSet.getString("state"));
		clientDetails.setPin(resultSet.getString("pin"));
		clientDetails.setClientStatus(resultSet.getString("client_status"));

		ContactDetailsDAO contactDetailsDAO = new ContactDetailsDAO(jdbcTemplate);
		ContactDetails contactDetails = contactDetailsDAO
				.getContactDetailsByContactId(resultSet.getInt("primary_contact_id"));

		clientDetails.setPrimaryContact(contactDetails);

		return clientDetails;
	}
}
