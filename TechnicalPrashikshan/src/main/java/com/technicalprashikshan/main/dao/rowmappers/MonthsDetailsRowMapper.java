package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.dao.FinancialYearDetailsDAO;
import com.technicalprashikshan.main.pojo.FinancialYearDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;

public class MonthsDetailsRowMapper implements RowMapper<MonthsDetails> {
	private static final Logger logger = LoggerFactory.getLogger(MonthsDetailsRowMapper.class);
	private JdbcTemplate jdbcTemplate;

	public MonthsDetailsRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public MonthsDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		logger.info("MonthsDetailsRowMapper mapRow");
		MonthsDetails monthsDetails = new MonthsDetails();

		monthsDetails.setMonthId(resultSet.getInt("month_id"));
		monthsDetails.setMonthStartDate(resultSet.getDate("month_start_date").toLocalDate());
		monthsDetails.setMonthEndDate(resultSet.getDate("month_end_date").toLocalDate());

		FinancialYearDetailsDAO financialYearDetailsDAO = new FinancialYearDetailsDAO(jdbcTemplate);
		FinancialYearDetails financialYearDetails = financialYearDetailsDAO
				.getFinancialYearDetailsByFinancialYearId(resultSet.getInt("year_id"));
		monthsDetails.setFinancialYearDetails(financialYearDetails);

		return monthsDetails;
	}

}
