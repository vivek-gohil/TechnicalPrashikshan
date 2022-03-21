package com.technicalprashikshan.main.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.technicalprashikshan.main.dao.interfaces.FinancialYearDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.FinancialYearDetailsRowMapper;
import com.technicalprashikshan.main.pojo.FinancialYearDetails;

@Repository
public class FinancialYearDetailsDAO implements FinancialYearDetailsDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(FinancialYearDetailsDAO.class);

	private static final String insertNewFinancialYearDetails = "insert into financial_year_master(year_start_date , year_end_date) values(?,?)";
	private static final String updateFinancialYearDetails = "update financial_year_master set year_start_date = ? , year_end_date = ? where year_id = ?";
	private static final String deleteFinancialYearDetails = "delete from financial_year_master where year_id = ?";
	private static final String selectFinancialYearByFinancialYearId = "select * from financial_year_master where year_id = ?";
	private static final String selectAllFinancialYearDetails = "select * from financial_year_master";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public FinancialYearDetailsDAO() {
	}

	public FinancialYearDetailsDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addNewFinancialYearDetails(FinancialYearDetails financialYearDetails) {
		logger.info(financialYearDetails.toString());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection.prepareStatement(insertNewFinancialYearDetails,
					new String[] { "vendor_id" });
			preparedStatement.setDate(1, Date.valueOf(financialYearDetails.getYearStartDate()));
			preparedStatement.setDate(2, Date.valueOf(financialYearDetails.getYearEndDate()));
			return preparedStatement;
		}, keyHolder);

		int yearId = keyHolder.getKey().intValue();
		logger.info("Generated YearID :: " + yearId);
		return yearId;
	}

	@Override
	public FinancialYearDetails updateFinancialYearDetails(FinancialYearDetails financialYearDetails) {
		logger.info(financialYearDetails.toString());
		Object[] args = { financialYearDetails.getYearStartDate(), financialYearDetails.getYearEndDate(),
				financialYearDetails.getYearId() };
		count = jdbcTemplate.update(updateFinancialYearDetails, args);
		if (count > 0) {
			logger.info("Year Details Updated Successfully");
			return financialYearDetails;
		} else {
			logger.info("Failed To Update Year Details");
			return null;
		}
	}

	@Override
	public FinancialYearDetails getFinancialYearDetailsByFinancialYearId(int financialYearId) {
		FinancialYearDetails financialYearDetails = null;
		try {
			Object[] args = { financialYearId };
			financialYearDetails = jdbcTemplate.queryForObject(selectFinancialYearByFinancialYearId,
					new FinancialYearDetailsRowMapper(jdbcTemplate), args);
			if (financialYearDetails != null)
				return financialYearDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<FinancialYearDetails> getAllFinancialYearDetails() {
		List<FinancialYearDetails> financialYearDetailsList = jdbcTemplate.query(selectAllFinancialYearDetails,
				new FinancialYearDetailsRowMapper(jdbcTemplate));
		return financialYearDetailsList;
	}

	@Override
	public boolean deleteFinancialYearDetailsByFinancialYearId(int financialYearId) {
		logger.info("" + financialYearId);
		Object[] args = { financialYearId };
		count = jdbcTemplate.update(deleteFinancialYearDetails, args);
		if (count > 0) {
			logger.info("Year Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete Year Details");
			return false;
		}
	}

}
