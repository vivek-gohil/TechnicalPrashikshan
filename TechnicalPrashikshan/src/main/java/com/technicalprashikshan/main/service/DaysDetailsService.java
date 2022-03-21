package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.DaysDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.DaysDetails;
import com.technicalprashikshan.main.service.interfaces.DaysDetailsServiceInterface;

@Service
public class DaysDetailsService implements DaysDetailsServiceInterface, DaysDetailsDAOInterface {

	@Autowired
	private DaysDetailsDAOInterface daysDetailsDAO;

	@Override
	public int addNewDaysDetails(DaysDetails daysDetails) {
		return daysDetailsDAO.addNewDaysDetails(daysDetails);
	}

	@Override
	public DaysDetails updateDaysDetails(DaysDetails daysDetails) {
		return daysDetailsDAO.updateDaysDetails(daysDetails);
	}

	@Override
	public DaysDetails getDaysDetailsByDaysId(int daysId) {
		return daysDetailsDAO.getDaysDetailsByDaysId(daysId);
	}

	@Override
	public List<DaysDetails> getAllDaysDetails() {
		return daysDetailsDAO.getAllDaysDetails();
	}

	@Override
	public boolean deleteDaysDetailsByDaysId(int daysId) {
		return daysDetailsDAO.deleteDaysDetailsByDaysId(daysId);
	}

}
