package com.technicalprashikshan.main.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.technicalprashikshan.main.dao.interfaces.MonthsDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.MonthsDetailsRowMapper;
import com.technicalprashikshan.main.pojo.MonthsDetails;

@Repository
public class MonthsDetailsDAO implements MonthsDetailsDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(MonthsDetailsDAO.class);

	private static final String updateMonthsDetails = "update months_master set month_start_date = ? , month_end_date = ? , year_id = ? where month_id = ?";
	private static final String deleteMonthsDetails = "delete from months_master where month_id = ?";
	private static final String selectMonthsByMonthsId = "select * from months_master where month_id = ?";
	private static final String selectAllMonthsDetails = "select * from months_master";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MonthsDetailsDAO() {
	}

	public MonthsDetailsDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addNewMonthsDetails(MonthsDetails monthsDetails) {
		return 0;
	}

	@Override
	public MonthsDetails updateMonthsDetails(MonthsDetails monthsDetails) {
		logger.info(monthsDetails.toString());
		Object[] args = { monthsDetails.getMonthStartDate(), monthsDetails.getMonthEndDate(),
				monthsDetails.getFinancialYearDetails().getYearId(), monthsDetails.getMonthId() };
		count = jdbcTemplate.update(updateMonthsDetails, args);
		if (count > 0) {
			logger.info("Monthds Details Updated Successfully");
			return monthsDetails;
		} else {
			logger.info("Failed To Update Months Details");
			return null;
		}
	}

	@Override
	public MonthsDetails getMonthsDetailsByMonthsId(int monthsId) {
		MonthsDetails monthsDetails = null;
		try {
			Object[] args = { monthsId };
			monthsDetails = jdbcTemplate.queryForObject(selectMonthsByMonthsId,
					new MonthsDetailsRowMapper(jdbcTemplate), args);
			if (monthsDetails != null)
				return monthsDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<MonthsDetails> getAllMonthsDetails() {
		List<MonthsDetails> monthsDetailsList = jdbcTemplate.query(selectAllMonthsDetails,
				new MonthsDetailsRowMapper(jdbcTemplate));
		return monthsDetailsList;
	}

	@Override
	public boolean deleteMonthsDetailsByMonthsId(int monthsId) {
		logger.info("" + monthsId);
		Object[] args = { monthsId };
		count = jdbcTemplate.update(deleteMonthsDetails, args);
		if (count > 0) {
			logger.info("Months Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete Months Details");
			return false;
		}
	}

}
