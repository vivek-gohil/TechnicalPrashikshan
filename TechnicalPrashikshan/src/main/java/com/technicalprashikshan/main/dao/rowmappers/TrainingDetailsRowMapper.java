package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.dao.ClientDetailsDAO;
import com.technicalprashikshan.main.dao.VendorDetailsDAO;
import com.technicalprashikshan.main.pojo.ClientDetails;
import com.technicalprashikshan.main.pojo.TrainingDetails;
import com.technicalprashikshan.main.pojo.VendorDetails;

public class TrainingDetailsRowMapper implements RowMapper<TrainingDetails> {
	private static final Logger logger = LoggerFactory.getLogger(TrainingDetailsRowMapper.class);
	private JdbcTemplate jdbcTemplate;

	public TrainingDetailsRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public TrainingDetails mapRow(ResultSet restultSet, int rowNum) throws SQLException {
		logger.info("TrainingDetailsRowMapper mapRow");
		TrainingDetails trainingDetails = new TrainingDetails();
		trainingDetails.setTrainingDetailsId(restultSet.getInt("training_details_id"));
		trainingDetails.setTopic(restultSet.getString("topic"));
		trainingDetails.setTotalNumberOfDays(restultSet.getInt("total_number_of_days"));
		trainingDetails.setPerDayRate(restultSet.getDouble("per_day_rate"));
		trainingDetails.setSessionType(restultSet.getString("session_type"));
		trainingDetails.setRemarks(restultSet.getString("remarks"));
		trainingDetails.setTrainingStatus(restultSet.getString("training_status"));

		VendorDetailsDAO vendorDetailsDAO = new VendorDetailsDAO(jdbcTemplate);
		VendorDetails vendorDetails = vendorDetailsDAO.getVendorDetailsByVendorId(restultSet.getInt("vendor_id"));
		trainingDetails.setVendorDetails(vendorDetails);

		ClientDetailsDAO clientDetailsDAO = new ClientDetailsDAO(jdbcTemplate);
		ClientDetails clientDetails = clientDetailsDAO.getClientDetailsByClientId(restultSet.getInt("client_id"));
		trainingDetails.setClientDetails(clientDetails);


		return trainingDetails;
	}
}
