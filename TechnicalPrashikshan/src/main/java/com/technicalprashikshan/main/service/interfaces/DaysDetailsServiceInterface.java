package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.DaysDetails;

public interface DaysDetailsServiceInterface {
	public int addNewDaysDetails(DaysDetails daysDetails);

	public DaysDetails updateDaysDetails(DaysDetails daysDetails);

	public DaysDetails getDaysDetailsByDaysId(int daysId);

	public List<DaysDetails> getAllDaysDetails();

	public boolean deleteDaysDetailsByDaysId(int daysId);
}
