package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.dao.DaysDetailsDAO;
import com.technicalprashikshan.main.dao.TrainerDetailsDAO;
import com.technicalprashikshan.main.dao.TrainingDetailsDAO;
import com.technicalprashikshan.main.pojo.DaysDetails;
import com.technicalprashikshan.main.pojo.TrainerDetails;
import com.technicalprashikshan.main.pojo.TrainingDatesDetails;
import com.technicalprashikshan.main.pojo.TrainingDetails;

public class TrainingDatesDetailsRowMapper implements RowMapper<TrainingDatesDetails> {
	private static final Logger logger = LoggerFactory.getLogger(VendorDetailsRowMapper.class);
	private JdbcTemplate jdbcTemplate;

	public TrainingDatesDetailsRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public TrainingDatesDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		TrainingDatesDetails trainingDatesDetails = new TrainingDatesDetails();

		trainingDatesDetails.setTrainingDateId(resultSet.getInt("training_date_id"));

		DaysDetailsDAO daysDetailsDAO = new DaysDetailsDAO(jdbcTemplate);
		DaysDetails daysDetails = daysDetailsDAO.getDaysDetailsByDaysId(resultSet.getInt("day_id"));
		trainingDatesDetails.setDaysDetails(daysDetails);

		TrainingDetailsDAO trainingDetailsDAO = new TrainingDetailsDAO(jdbcTemplate);
		TrainingDetails trainingDetails = trainingDetailsDAO
				.getTrainingDetailsByTrainingId(resultSet.getInt("training_details_id"));
		trainingDatesDetails.setTrainingDetails(trainingDetails);

		TrainerDetailsDAO trainerDetailsDAO = new TrainerDetailsDAO(jdbcTemplate);
		TrainerDetails trainerDetails = trainerDetailsDAO.getTrainerDetailsByTrainerId(resultSet.getInt("trainer_id"));
		trainingDatesDetails.setTrainerDetails(trainerDetails);

		return trainingDatesDetails;
	}
}
