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

import com.technicalprashikshan.main.dao.interfaces.TrainerDetailsDAOInterface;
import com.technicalprashikshan.main.dao.interfaces.TrainingDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.TrainingDetailsRowMapper;
import com.technicalprashikshan.main.pojo.TrainerDetails;
import com.technicalprashikshan.main.pojo.TrainingDetails;

@Repository
public class TrainingDetailsDAO implements TrainingDetailsDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(TrainingDetailsDAO.class);

	private static final String insertNewTrainingDetails = "insert into training_details(topic,total_number_of_days,per_day_rate,session_type,remarks,training_status,vendor_id,client_id,purchase_order_id,invoice_id) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String updateTrainingDetails = "update training_details set topic = ? ,total_number_of_days = ? ,per_day_rate = ? ,session_type = ? , remarks = ? ,training_status = ? ,vendor_id = ? ,client_id = ? ,purchase_order_id = ? ,invoice_id = ?  where training_details_id = ?";
	private static final String deleteTrainingDetails = "delete from training_details where training_details_id = ?";
	private static final String selectTrainingByTrainingId = "select * from training_details where training_details_id = ?";
	private static final String selectAllTrainingDetails = "select * from training_details";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public TrainingDetailsDAO() {
	}

	public TrainingDetailsDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addNewTrainingDetails(TrainingDetails trainingDetails) {
		logger.info(trainingDetails.toString());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection.prepareStatement(insertNewTrainingDetails,
					new String[] { "training_details_id" });
			preparedStatement.setString(1, trainingDetails.getTopic());
			preparedStatement.setInt(2, trainingDetails.getTotalNumberOfDays());
			preparedStatement.setDouble(3, trainingDetails.getPerDayRate());
			preparedStatement.setString(4, trainingDetails.getSessionType());
			preparedStatement.setString(5, trainingDetails.getRemarks());
			preparedStatement.setString(6, trainingDetails.getTrainingStatus());
			preparedStatement.setInt(7, trainingDetails.getVendorDetails().getVendorId());
			preparedStatement.setInt(8, trainingDetails.getClientDetails().getClientId());
			preparedStatement.setString(9, trainingDetails.getPurchaseOrderDetails().getPurchseOrderId());
			preparedStatement.setString(10, trainingDetails.getInvoiceDetails().getInvoiceId());

			return preparedStatement;
		}, keyHolder);

		int trainingDetailsId = keyHolder.getKey().intValue();
		logger.info("Generated trainingDetailsId :: " + trainingDetailsId);
		return trainingDetailsId;
	}

	@Override
	public TrainingDetails updateTrainingDetails(TrainingDetails trainingDetails) {
		logger.info(trainingDetails.toString());
		Object[] args = { trainingDetails.getTopic(), trainingDetails.getTotalNumberOfDays(),
				trainingDetails.getPerDayRate(), trainingDetails.getSessionType(), trainingDetails.getRemarks(),
				trainingDetails.getTrainingStatus(), trainingDetails.getVendorDetails().getVendorId(),
				trainingDetails.getClientDetails().getClientId(),
				trainingDetails.getPurchaseOrderDetails().getPurchseOrderId(),
				trainingDetails.getInvoiceDetails().getInvoiceId(), trainingDetails.getTrainingDetailsId() };
		count = jdbcTemplate.update(updateTrainingDetails, args);
		if (count > 0) {
			logger.info("Training Details Updated Successfully");
			return trainingDetails;
		} else {
			logger.info("Failed To Update Training Details");
			return null;
		}
	}

	@Override
	public TrainingDetails getTrainingDetailsByTrainingId(int trainingDetailsId) {
		TrainingDetails trainingDetails = null;
		try {
			Object[] args = { trainingDetailsId };
			trainingDetails = jdbcTemplate.queryForObject(selectTrainingByTrainingId,
					new TrainingDetailsRowMapper(jdbcTemplate), args);
			if (trainingDetails != null)
				return trainingDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<TrainingDetails> getAllTrainingDetails() {
		List<TrainingDetails> TrainingDetailsList = jdbcTemplate.query(selectAllTrainingDetails,
				new TrainingDetailsRowMapper(jdbcTemplate));
		return TrainingDetailsList;
	}

	@Override
	public boolean deleteTrainingDetailsByTrainingId(int trainingDetailsId) {
		logger.info("" + trainingDetailsId);
		Object[] args = { trainingDetailsId };
		count = jdbcTemplate.update(deleteTrainingDetails, args);
		if (count > 0) {
			logger.info("Training Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete Training Details");
			return false;
		}
	}

}
