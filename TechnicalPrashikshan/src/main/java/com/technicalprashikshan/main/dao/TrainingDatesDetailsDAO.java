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

import com.technicalprashikshan.main.dao.interfaces.TrainingDatesDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.TrainingDatesDetailsRowMapper;
import com.technicalprashikshan.main.pojo.TrainingDatesDetails;

@Repository
public class TrainingDatesDetailsDAO implements TrainingDatesDetailsDAOInterface {
	private static final Logger logger = LoggerFactory.getLogger(TrainingDatesDetailsDAO.class);

	private static final String insertNewTrainingDatesDetails = "insert into training_dates_details(day_id,training_details_id,trainer_id) values(?,?,?)";
	private static final String updateTrainingDatesDetails = "update training_dates_details set day_id = ? , training_details_id = ? ,trainer_id = ?  where training_date_id = ?";
	private static final String deleteTrainingDatesDetails = "delete from training_dates_details where training_date_id = ?";
	private static final String selectTrainingDatesByTrainingDatesId = "select * from training_dates_details where training_date_id = ?";
	private static final String selectAllTrainingDatesDetails = "select * from training_dates_details";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addNewTrainingDatesDetails(TrainingDatesDetails trainingDatesDetails) {
		logger.info(trainingDatesDetails.toString());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection.prepareStatement(insertNewTrainingDatesDetails,
					new String[] { "vendor_id" });
			preparedStatement.setInt(1, trainingDatesDetails.getDaysDetails().getDaysId());
			preparedStatement.setInt(2, trainingDatesDetails.getTrainingDetails().getTrainingDetailsId());
			preparedStatement.setInt(3, trainingDatesDetails.getTrainerDetails().getTrainerId());

			return preparedStatement;
		}, keyHolder);

		int trainingDateId = keyHolder.getKey().intValue();
		logger.info("Generated trainingDateId :: " + trainingDateId);
		return trainingDateId;
	}

	@Override
	public TrainingDatesDetails updateTrainingDatesDetails(TrainingDatesDetails trainingDatesDetails) {
		logger.info(trainingDatesDetails.toString());
		Object[] args = { trainingDatesDetails.getDaysDetails().getDaysId(),
				trainingDatesDetails.getTrainingDetails().getTrainingDetailsId(),
				trainingDatesDetails.getTrainerDetails().getTrainerId(), trainingDatesDetails.getTrainingDateId() };
		count = jdbcTemplate.update(updateTrainingDatesDetails, args);
		if (count > 0) {
			logger.info("training Dates Details  Updated Successfully");
			return trainingDatesDetails;
		} else {
			logger.info("Failed To Update training Dates Details");
			return null;
		}
	}

	@Override
	public TrainingDatesDetails getTrainingDatesDetailsByTrainingDatesId(int trainingDatesId) {
		TrainingDatesDetails trainingDatesDetails = null;
		try {
			Object[] args = { trainingDatesId };
			trainingDatesDetails = jdbcTemplate.queryForObject(selectTrainingDatesByTrainingDatesId,
					new TrainingDatesDetailsRowMapper(jdbcTemplate), args);
			if (trainingDatesDetails != null)
				return trainingDatesDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<TrainingDatesDetails> getAllTrainingDatesDetails() {
		List<TrainingDatesDetails> trainingDatesDetailsList = jdbcTemplate.query(selectAllTrainingDatesDetails,
				new TrainingDatesDetailsRowMapper(jdbcTemplate));
		return trainingDatesDetailsList;
	}

	@Override
	public boolean deleteVenderDetailsByTrainingDatesId(int trainingDatesId) {
		logger.info("" + trainingDatesId);
		Object[] args = { trainingDatesId };
		count = jdbcTemplate.update(deleteTrainingDatesDetails, args);
		if (count > 0) {
			logger.info("training dates Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete Training dates Details");
			return false;
		}
	}

}
