package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.MonthlyTrainingCalenderDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;

public interface MonthlyTrainingCalendarDetailsServiceInterface {
	public List<MonthlyTrainingCalenderDetails> getMonthlyTrainingCalenderDetails(MonthsDetails monthsDetails);
}
