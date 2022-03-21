package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.MonthsDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.service.interfaces.MonthsDetailsServiceInterface;

@Service
public class MonthsDetailsService implements MonthsDetailsServiceInterface {

	@Autowired
	private MonthsDetailsDAOInterface monthsDetailsDAO;

	@Override
	public int addNewMonthsDetails(MonthsDetails monthsDetails) {
		return monthsDetailsDAO.addNewMonthsDetails(monthsDetails);
	}

	@Override
	public MonthsDetails updateMonthsDetails(MonthsDetails monthsDetails) {
		return monthsDetailsDAO.updateMonthsDetails(monthsDetails);
	}

	@Override
	public MonthsDetails getMonthsDetailsByMonthsId(int monthsId) {
		return monthsDetailsDAO.getMonthsDetailsByMonthsId(monthsId);
	}

	@Override
	public List<MonthsDetails> getAllMonthsDetails() {
		return monthsDetailsDAO.getAllMonthsDetails();
	}

	@Override
	public boolean deleteMonthsDetailsByMonthsId(int monthsId) {
		return monthsDetailsDAO.deleteMonthsDetailsByMonthsId(monthsId);
	}

}
