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

import com.technicalprashikshan.main.dao.interfaces.VendorDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.VendorDetailsRowMapper;
import com.technicalprashikshan.main.pojo.VendorDetails;

@Repository
public class VendorDetailsDAO implements VendorDetailsDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(VendorDetailsDAO.class);

	private static final String insertNewVendorDetails = "insert into vendor_master(vendor_name , address_line_1,address_line_2,landmark,city,state,pin,vendor_status,primary_contact_id) values(?,?,?,?,?,?,?,?,?)";
	private static final String updateVendorDetails = "update vendor_master set vendor_name = ? , address_line_1 = ? ,address_line_2 = ? ,landmark = ? ,city = ? ,state = ? ,pin = ? ,vendor_status = ? ,primary_contact_id = ?  where vendor_id = ?";
	private static final String deleteVendorDetails = "delete from vendor_master where vendor_id = ?";
	private static final String selectVendorByVendorId = "select * from vendor_master where vendor_id = ?";
	private static final String selectAllVendorDetails = "select * from vendor_master order by vendor_name";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addNewVendorDetails(VendorDetails vendorDetails) {
		logger.info(vendorDetails.toString());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection.prepareStatement(insertNewVendorDetails,
					new String[] { "vendor_id" });
			preparedStatement.setString(1, vendorDetails.getVendorName());
			preparedStatement.setString(2, vendorDetails.getAddressLineOne());
			preparedStatement.setString(3, vendorDetails.getAddressLineTwo());
			preparedStatement.setString(4, vendorDetails.getLandmark());
			preparedStatement.setString(5, vendorDetails.getCity());
			preparedStatement.setString(6, vendorDetails.getState());
			preparedStatement.setString(7, vendorDetails.getPin());
			preparedStatement.setString(8, vendorDetails.getVendorStatus());
			preparedStatement.setInt(9, vendorDetails.getPrimaryContactDetails().getContactId());
			return preparedStatement;
		}, keyHolder);

		int vendorId = keyHolder.getKey().intValue();
		logger.info("Generated VendorId :: " + vendorId);
		return vendorId;
	}

	@Override
	public VendorDetails updateVendorDetails(VendorDetails vendorDetails) {
		logger.info(vendorDetails.toString());
		Object[] args = { vendorDetails.getVendorName(), vendorDetails.getAddressLineOne(),
				vendorDetails.getAddressLineTwo(), vendorDetails.getLandmark(), vendorDetails.getCity(),
				vendorDetails.getState(), vendorDetails.getPin(), vendorDetails.getVendorStatus(),
				vendorDetails.getPrimaryContactDetails().getContactId(), vendorDetails.getVendorId() };
		count = jdbcTemplate.update(updateVendorDetails, args);
		if (count > 0) {
			logger.info("Vendor Details Updated Successfully");
			return vendorDetails;
		} else {
			logger.info("Failed To Update Vendor Details");
			return null;
		}
	}

	@Override
	public VendorDetails getVendorDetailsByVendorId(int vendorId) {

		VendorDetails vendorDetails = null;
		try {
			Object[] args = { vendorId };
			vendorDetails = jdbcTemplate.queryForObject(selectVendorByVendorId,
					new VendorDetailsRowMapper(jdbcTemplate), args);
			if (vendorDetails != null)
				return vendorDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<VendorDetails> getAllVendorDetails() {
		List<VendorDetails> vendorDetailsList = jdbcTemplate.query(selectAllVendorDetails,
				new VendorDetailsRowMapper(jdbcTemplate));
		return vendorDetailsList;
	}

	@Override
	public boolean deleteVenderDetailsByVendorId(int vendorId) {
		logger.info("" + vendorId);
		Object[] args = { vendorId };
		count = jdbcTemplate.update(deleteVendorDetails, args);
		if (count > 0) {
			logger.info("Vendor Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete Vendor Details");
			return false;
		}
	}

}
