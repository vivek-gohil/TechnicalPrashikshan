package com.technicalprashikshan.main.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.technicalprashikshan.main.dao.interfaces.DaysDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.DaysDetailsRowMapper;
import com.technicalprashikshan.main.pojo.DaysDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;

@Repository
public class DaysDetailsDAO implements DaysDetailsDAOInterface {
	private static final Logger logger = LoggerFactory.getLogger(DaysDetailsDAO.class);
	private static final String selectDaysByDaysId = "select * from days_master where day_id = ?";
	private static final String selectAllDaysDetails = "select * from days_master";
	private static final String selectAllDaysDetailsByMonthStartDate = "select * from days_master where month_id = (select month_id from months_master where month_start_date = ?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public DaysDetailsDAO() {
	}

	public DaysDetailsDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addNewDaysDetails(DaysDetails daysDetails) {
		return 0;
	}

	@Override
	public DaysDetails updateDaysDetails(DaysDetails daysDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DaysDetails getDaysDetailsByDaysId(int daysId) {
		DaysDetails daysDetails = null;
		try {
			Object[] args = { daysId };
			daysDetails = jdbcTemplate.queryForObject(selectDaysByDaysId, new DaysDetailsRowMapper(jdbcTemplate), args);
			if (daysDetails != null)
				return daysDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<DaysDetails> getAllDaysDetails() {
		List<DaysDetails> daysDetailsList = jdbcTemplate.query(selectAllDaysDetails,
				new DaysDetailsRowMapper(jdbcTemplate));
		return daysDetailsList;
	}

	@Override
	public boolean deleteDaysDetailsByDaysId(int daysId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DaysDetails> getAllDaysDetailsByMonthStartDate(MonthsDetails monthsDetails) {
		Object[] args = { monthsDetails.getMonthStartDate() };
		List<DaysDetails> daysDetailsList = jdbcTemplate.query(selectAllDaysDetailsByMonthStartDate,
				new DaysDetailsRowMapper(jdbcTemplate), args);
		return daysDetailsList;
	}

}
