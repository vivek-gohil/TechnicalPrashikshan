package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.DaysDetails;

public interface DaysDetailsDAOInterface {
	public int addNewDaysDetails(DaysDetails daysDetails);

	public DaysDetails updateDaysDetails(DaysDetails daysDetails);

	public DaysDetails getDaysDetailsByDaysId(int daysId);

	public List<DaysDetails> getAllDaysDetails();

	public boolean deleteDaysDetailsByDaysId(int daysId);
}
