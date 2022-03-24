package com.technicalprashikshan.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.pojo.DaysDetails;
import com.technicalprashikshan.main.pojo.MonthlyTrainingCalenderDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingCalendarDetails;
import com.technicalprashikshan.main.service.interfaces.MonthlyTrainingCalendarDetailsServiceInterface;
import com.technicalprashikshan.main.service.interfaces.TrainingCalendarDetailsServiceInterface;

@Service
public class MonthlyCalendarDetailsService implements MonthlyTrainingCalendarDetailsServiceInterface {

	@Autowired
	private TrainingCalendarDetailsServiceInterface trainingCalendarDetailsService;

	@Override
	public List<MonthlyTrainingCalenderDetails> getMonthlyTrainingCalenderDetails(MonthsDetails monthsDetails) {
		// creating a empty list to store full month details
		List<MonthlyTrainingCalenderDetails> monthlyTrainingCalenderDetailsList = new ArrayList<MonthlyTrainingCalenderDetails>();

		// retrieving training calendar details
		TrainingCalendarDetails trainingCalendarDetails = trainingCalendarDetailsService
				.getAllTrainingCalenderDetailsByMonthStartDate(monthsDetails);
		List<DaysDetails> allDaysDetailsList = trainingCalendarDetails.getAllDaysDetailsList();

		// adding all days into monthlyTrainingCalenderDetailsList
		for (DaysDetails daysDetails : allDaysDetailsList) {
			MonthlyTrainingCalenderDetails monthlyTrainingCalenderDetails = new MonthlyTrainingCalenderDetails();
			monthlyTrainingCalenderDetails.setAllDaysDetails(daysDetails);
			monthlyTrainingCalenderDetailsList.add(monthlyTrainingCalenderDetails);
		}

		List<DaysDetails> trainingDaysDetails = trainingCalendarDetails.getTrainingDaysDetailsList();

		for (MonthlyTrainingCalenderDetails monthlyTrainingCalenderDetails : monthlyTrainingCalenderDetailsList) {
			for (DaysDetails daysDetails : trainingDaysDetails) {
				if (monthlyTrainingCalenderDetails.getAllDaysDetails().getDaysId() == daysDetails.getDaysId()) {
					monthlyTrainingCalenderDetails.setTrainingDaysDetails(daysDetails);
				}
			}
		}
		
		return monthlyTrainingCalenderDetailsList;
	}

}
