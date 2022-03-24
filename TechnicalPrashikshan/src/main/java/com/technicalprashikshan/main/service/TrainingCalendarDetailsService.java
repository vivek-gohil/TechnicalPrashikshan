package com.technicalprashikshan.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.DaysDetailsDAOInterface;
import com.technicalprashikshan.main.dao.interfaces.TrainingDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.DaysDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingCalendarDetails;
import com.technicalprashikshan.main.pojo.TrainingDetails;
import com.technicalprashikshan.main.service.interfaces.TrainingCalendarDetailsServiceInterface;

@Service
public class TrainingCalendarDetailsService implements TrainingCalendarDetailsServiceInterface {
	private static final Logger logger = LoggerFactory.getLogger(TrainingCalendarDetailsService.class);

	@Autowired
	private DaysDetailsDAOInterface daysDetailsDAO;

	@Autowired
	private TrainingDetailsDAOInterface trainingDetailsDAO;

	@Override
	public TrainingCalendarDetails getAllTrainingCalenderDetailsByMonthStartDate(MonthsDetails monthsDetails) {

		TrainingCalendarDetails trainingCalendarDetails = new TrainingCalendarDetails();

		List<DaysDetails> allDaysDetailsByMonthStartDate = daysDetailsDAO
				.getAllDaysDetailsByMonthStartDate(monthsDetails);
		trainingCalendarDetails.setAllDaysDetailsList(allDaysDetailsByMonthStartDate);

		List<DaysDetails> allAllTrainingDaysDetailsByMonthStartDate = daysDetailsDAO
				.getAllTrainingDaysByMonthStartDate(monthsDetails);
		trainingCalendarDetails.setTrainingDaysDetailsList(allAllTrainingDaysDetailsByMonthStartDate);

		List<TrainingDetails> allTrainingDetailsByMonthStartDate = trainingDetailsDAO
				.getAllTrainingDetailsByMonthStartDate(monthsDetails);
		trainingCalendarDetails.setTrainingDetailsList(allTrainingDetailsByMonthStartDate);

		return trainingCalendarDetails;
	}

}
