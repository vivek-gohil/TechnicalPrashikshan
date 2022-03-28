package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.DaysDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;

public interface DaysDetailsServiceInterface {
	public int addNewDaysDetails(DaysDetails daysDetails);

	public DaysDetails updateDaysDetails(DaysDetails daysDetails);

	public DaysDetails getDaysDetailsByDaysId(int daysId);

	public List<DaysDetails> getAllDaysDetails();

	public boolean deleteDaysDetailsByDaysId(int daysId);

	public List<DaysDetails> getAllDaysDetailsByMonthStartDate(MonthsDetails monthsDetails);
	
	public List<DaysDetails> getAllTrainingDaysByMonthStartDate(MonthsDetails monthsDetails);
	
	public List<DaysDetails> getAllSelectedDaysByDayId(List<Integer> dayIdList);
	
}
