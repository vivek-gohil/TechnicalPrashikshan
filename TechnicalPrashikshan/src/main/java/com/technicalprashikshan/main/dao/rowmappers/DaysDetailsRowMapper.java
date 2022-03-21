package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.dao.MonthsDetailsDAO;
import com.technicalprashikshan.main.pojo.DaysDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;

public class DaysDetailsRowMapper implements RowMapper<DaysDetails> {

	private static final Logger logger = LoggerFactory.getLogger(DaysDetailsRowMapper.class);
	private JdbcTemplate jdbcTemplate;

	public DaysDetailsRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public DaysDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		logger.info("DaysDetailsRowMapper mapRow");
		DaysDetails daysDetails = new DaysDetails();
		daysDetails.setDaysId(resultSet.getInt("day_id"));
		daysDetails.setDate(resultSet.getDate("day_date").toLocalDate());

		MonthsDetailsDAO monthsDetailsDAO = new MonthsDetailsDAO(jdbcTemplate);
		MonthsDetails monthsDetails = monthsDetailsDAO.getMonthsDetailsByMonthsId(resultSet.getInt("month_id"));
		daysDetails.setMonthsDetails(monthsDetails);

		return daysDetails;
	}

}
