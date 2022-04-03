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
import com.technicalprashikshan.main.dao.rowmappers.TrainerDetailsRowMapper;
import com.technicalprashikshan.main.pojo.TrainerDetails;

@Repository
public class TrainerDetailsDAO implements TrainerDetailsDAOInterface {
	private static final Logger logger = LoggerFactory.getLogger(TrainerDetailsDAO.class);

	private static final String insertNewTrainerDetails = "insert into trainer_master(first_name,last_name,per_day_rate,profile_file_id,trainer_description,trainer_status,trainer_contact_id,user_id,banking_id) values(?,?,?,?,?,?,?,?,?)";
	private static final String updateTrainerDetails = "update trainer_master set first_name = ? ,last_name = ? ,per_day_rate = ? ,profile_file_id = ? ,trainer_description = ? ,trainer_status = ? ,trainer_contact_id = ? ,user_id = ? ,banking_id = ?  where trainer_id = ?";
	private static final String deleteTrainerDetails = "delete from trainer_master where trainer_id = ?";
	private static final String selectTrainerByTrainerId = "select * from trainer_master where trainer_id = ?";
	private static final String selectAllTrainerDetails = "select * from trainer_master";
	private static final String selectTrainerDetailsByUserId = "select * from trainer_master where user_id = ?";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public TrainerDetailsDAO() {
	}

	public TrainerDetailsDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addNewTrainerDetails(TrainerDetails trainerDetails) {
		logger.info(trainerDetails.toString());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection.prepareStatement(insertNewTrainerDetails,
					new String[] { "trainer_id" });
			preparedStatement.setString(1, trainerDetails.getFirstName());
			preparedStatement.setString(2, trainerDetails.getLastName());
			preparedStatement.setDouble(3, trainerDetails.getPerDayRate());
			preparedStatement.setInt(4, trainerDetails.getProfile().getFileId());
			preparedStatement.setString(5, trainerDetails.getDescription());
			preparedStatement.setString(6, trainerDetails.getTrainerStatus());
			preparedStatement.setInt(7, trainerDetails.getTrainerContactDetails().getContactId());
			preparedStatement.setInt(8, trainerDetails.getUserDetails().getUserId());
			preparedStatement.setInt(9, trainerDetails.getBankingDetails().getBankingDetailsId());
			return preparedStatement;
		}, keyHolder);

		int trainerId = keyHolder.getKey().intValue();
		logger.info("Generated TrainerId :: " + trainerId);
		return trainerId;
	}

	@Override
	public TrainerDetails updateTrainerDetails(TrainerDetails trainerDetails) {
		logger.info(trainerDetails.toString());
		Object[] args = { trainerDetails.getFirstName(), trainerDetails.getLastName(), trainerDetails.getPerDayRate(),
				trainerDetails.getProfile().getFileId(), trainerDetails.getDescription(),
				trainerDetails.getTrainerStatus(), trainerDetails.getTrainerContactDetails().getContactId(),
				trainerDetails.getUserDetails().getUserId(), trainerDetails.getBankingDetails().getBankingDetailsId(),
				trainerDetails.getTrainerId() };
		count = jdbcTemplate.update(updateTrainerDetails, args);
		if (count > 0) {
			logger.info("Trainer Details Updated Successfully");
			return trainerDetails;
		} else {
			logger.info("Failed To Update Trainer Details");
			return null;
		}
	}

	@Override
	public TrainerDetails getTrainerDetailsByTrainerId(int trainerId) {
		TrainerDetails trainerDetails = null;
		try {
			Object[] args = { trainerId };
			trainerDetails = jdbcTemplate.queryForObject(selectTrainerByTrainerId,
					new TrainerDetailsRowMapper(jdbcTemplate), args);
			if (trainerDetails != null)
				return trainerDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<TrainerDetails> getAllTrainerDetails() {
		List<TrainerDetails> trainerDetailsList = jdbcTemplate.query(selectAllTrainerDetails,
				new TrainerDetailsRowMapper(jdbcTemplate));
		return trainerDetailsList;
	}

	@Override
	public boolean deleteTrainerDetailsByTrainerId(int trainerId) {
		logger.info("" + trainerId);
		Object[] args = { trainerId };
		count = jdbcTemplate.update(deleteTrainerDetails, args);
		if (count > 0) {
			logger.info("Trainer Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete Trainer Details");
			return false;
		}
	}

	@Override
	public TrainerDetails getTrainerDetailsByUserId(int userId) {
		TrainerDetails trainerDetails = null;
		try {
			Object[] args = { userId };
			trainerDetails = jdbcTemplate.queryForObject(selectTrainerDetailsByUserId,
					new TrainerDetailsRowMapper(jdbcTemplate), args);
			if (trainerDetails != null)
				return trainerDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

}
