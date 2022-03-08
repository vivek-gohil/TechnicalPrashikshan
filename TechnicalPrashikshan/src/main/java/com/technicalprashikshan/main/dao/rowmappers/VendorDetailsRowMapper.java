package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.dao.ContactDetailsDAO;
import com.technicalprashikshan.main.pojo.ContactDetails;
import com.technicalprashikshan.main.pojo.VendorDetails;

public class VendorDetailsRowMapper implements RowMapper<VendorDetails> {
	private static final Logger logger = LoggerFactory.getLogger(VendorDetailsRowMapper.class);
	private JdbcTemplate jdbcTemplate;

	public VendorDetailsRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public VendorDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		logger.info("VendorDetailsRowMapper mapRow");

		VendorDetails vendorDetails = new VendorDetails();
		vendorDetails.setVendorId(resultSet.getInt("vendor_id"));
		vendorDetails.setVendorName(resultSet.getString("vendor_name"));
		vendorDetails.setAddressLineOne(resultSet.getString("address_line_1"));
		vendorDetails.setAddressLineTwo(resultSet.getString("address_line_2"));
		vendorDetails.setLandmark(resultSet.getString("landmark"));
		vendorDetails.setCity(resultSet.getString("city"));
		vendorDetails.setState(resultSet.getString("state"));
		vendorDetails.setPin(resultSet.getString("pin"));
		vendorDetails.setVendorStatus(resultSet.getString("vendor_status"));

		ContactDetailsDAO contactDetailsDAO = new ContactDetailsDAO(jdbcTemplate);
		ContactDetails contactDetails = contactDetailsDAO
				.getContactDetailsByContactId(resultSet.getInt("primary_contact_id"));

		vendorDetails.setPrimaryContactDetails(contactDetails);

		logger.info(vendorDetails.toString());

		return vendorDetails;
	}
}
