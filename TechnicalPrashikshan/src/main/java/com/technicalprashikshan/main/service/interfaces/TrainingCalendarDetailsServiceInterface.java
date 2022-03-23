package com.technicalprashikshan.main.service.interfaces;

import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingCalendarDetails;

public interface TrainingCalendarDetailsServiceInterface {
	public TrainingCalendarDetails getAllTrainingCalenderDetailsByMonthStartDate(MonthsDetails monthsDetails);
}
