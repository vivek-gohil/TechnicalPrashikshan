package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.MonthlyTrainingCalendarDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;

public interface MonthlyTrainingCalendarDetailsServiceInterface {
	public List<MonthlyTrainingCalendarDetails> getMonthlyTrainingCalenderDetails(MonthsDetails monthsDetails);
}
