package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.pojo.FinancialYearDetails;

public class FinancialYearDetailsRowMapper implements RowMapper<FinancialYearDetails> {

	private static final Logger logger = LoggerFactory.getLogger(FinancialYearDetailsRowMapper.class);
	private JdbcTemplate jdbcTemplate;

	public FinancialYearDetailsRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public FinancialYearDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		FinancialYearDetails financialYearDetails = new FinancialYearDetails();

		financialYearDetails.setYearId(resultSet.getInt("year_id"));
		financialYearDetails.setYearStartDate(resultSet.getDate("year_start_date").toLocalDate());
		financialYearDetails.setYearEndDate(resultSet.getDate("year_end_date").toLocalDate());

		return financialYearDetails;
	}

}
