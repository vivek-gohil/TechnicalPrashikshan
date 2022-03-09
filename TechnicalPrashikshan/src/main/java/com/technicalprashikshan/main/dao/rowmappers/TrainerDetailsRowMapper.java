package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.dao.BankingDetailsDAO;
import com.technicalprashikshan.main.dao.ContactDetailsDAO;
import com.technicalprashikshan.main.dao.FilesDetailsDAO;
import com.technicalprashikshan.main.dao.UserDetailsDAO;
import com.technicalprashikshan.main.pojo.BankingDetails;
import com.technicalprashikshan.main.pojo.ContactDetails;
import com.technicalprashikshan.main.pojo.FilesDetails;
import com.technicalprashikshan.main.pojo.TrainerDetails;
import com.technicalprashikshan.main.pojo.UserDetails;

public class TrainerDetailsRowMapper implements RowMapper<TrainerDetails> {
	private static final Logger logger = LoggerFactory.getLogger(TrainerDetailsRowMapper.class);
	private JdbcTemplate jdbcTemplate;

	public TrainerDetailsRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public TrainerDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		logger.info("TrainerDetailsRowMapper mapRow");
		TrainerDetails trainerDetails = new TrainerDetails();
		trainerDetails.setTrainerId(resultSet.getInt("trainer_id"));
		trainerDetails.setFirstName(resultSet.getString("first_name"));
		trainerDetails.setLastName(resultSet.getString("last_name"));
		trainerDetails.setPerDayRate(resultSet.getDouble("per_day_rate"));

		FilesDetailsDAO filesDetailsDAO = new FilesDetailsDAO(jdbcTemplate);
		FilesDetails trainerProfileFile = filesDetailsDAO.getFileDetailsByFileId(resultSet.getInt("profile_file_id"));
		trainerDetails.setProfile(trainerProfileFile);

		trainerDetails.setDescription(resultSet.getString("trainer_description"));
		trainerDetails.setTrainerStatus(resultSet.getString("trainer_status"));

		ContactDetailsDAO contactDetailsDAO = new ContactDetailsDAO(jdbcTemplate);
		ContactDetails contactDetails = contactDetailsDAO.getContactDetailsByContactId(resultSet.getInt("trainer_contact_id"));
		trainerDetails.setTrainerContactDetails(contactDetails);

		UserDetailsDAO userDetailsDAO = new UserDetailsDAO(jdbcTemplate);
		UserDetails userDetails = userDetailsDAO.getUserDetailsByUserId(resultSet.getInt("user_id"));
		trainerDetails.setUserDetails(userDetails);

		BankingDetailsDAO bankingDetailsDAO = new BankingDetailsDAO(jdbcTemplate);
		BankingDetails bankingDetails = bankingDetailsDAO.getBankingDetailsByBankingId(resultSet.getInt("banking_id"));
		trainerDetails.setBankingDetails(bankingDetails);

		return trainerDetails;
	}
}
