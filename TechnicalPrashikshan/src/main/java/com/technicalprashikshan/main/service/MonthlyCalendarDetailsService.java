package com.technicalprashikshan.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.pojo.DaysDetails;
import com.technicalprashikshan.main.pojo.MonthlyTrainingCalendarDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingCalendarDetails;
import com.technicalprashikshan.main.pojo.TrainingDatesDetails;
import com.technicalprashikshan.main.service.interfaces.MonthlyTrainingCalendarDetailsServiceInterface;
import com.technicalprashikshan.main.service.interfaces.TrainingCalendarDetailsServiceInterface;
import com.technicalprashikshan.main.service.interfaces.TrainingDatesDetailsServiceInterface;

@Service
public class MonthlyCalendarDetailsService implements MonthlyTrainingCalendarDetailsServiceInterface {

	@Autowired
	private TrainingCalendarDetailsServiceInterface trainingCalendarDetailsService;

	@Autowired
	private TrainingDatesDetailsServiceInterface trainingDatesDetailsService;

	@Override
	public List<MonthlyTrainingCalendarDetails> getMonthlyTrainingCalenderDetails(MonthsDetails monthsDetails) {
		// creating a empty list to store full month details
		List<MonthlyTrainingCalendarDetails> monthlyTrainingCalenderDetailsList = new ArrayList<MonthlyTrainingCalendarDetails>();

		// retrieving training calendar details
		TrainingCalendarDetails trainingCalendarDetails = trainingCalendarDetailsService
				.getAllTrainingCalenderDetailsByMonthStartDate(monthsDetails);
		List<DaysDetails> allDaysDetailsList = trainingCalendarDetails.getAllDaysDetailsList();

		// adding all days into monthlyTrainingCalenderDetailsList
		for (DaysDetails daysDetails : allDaysDetailsList) {
			MonthlyTrainingCalendarDetails monthlyTrainingCalenderDetails = new MonthlyTrainingCalendarDetails();
			monthlyTrainingCalenderDetails.setAllDaysDetails(daysDetails);
			monthlyTrainingCalenderDetailsList.add(monthlyTrainingCalenderDetails);
		}

		List<DaysDetails> trainingDaysDetails = trainingCalendarDetails.getTrainingDaysDetailsList();

		for (MonthlyTrainingCalendarDetails monthlyTrainingCalenderDetails : monthlyTrainingCalenderDetailsList) {
			for (DaysDetails daysDetails : trainingDaysDetails) {
				if (monthlyTrainingCalenderDetails.getAllDaysDetails().getDaysId() == daysDetails.getDaysId()) {
					monthlyTrainingCalenderDetails.setTrainingDaysDetails(daysDetails);
				}
			}
		}

		List<TrainingDatesDetails> trainingDatesDetailsList = trainingDatesDetailsService
				.getAllTrainingDatesDetailsByMonthStartDate(monthsDetails);

		for (MonthlyTrainingCalendarDetails monthlyTrainingCalenderDetails : monthlyTrainingCalenderDetailsList) {
			for (TrainingDatesDetails trainingDatesDetails : trainingDatesDetailsList) {
				if (monthlyTrainingCalenderDetails.getAllDaysDetails().getDaysId() == trainingDatesDetails
						.getDaysDetails().getDaysId()) {
					monthlyTrainingCalenderDetails.setTrainingDetails(trainingDatesDetails.getTrainingDetails());
				}
			}
		}

//		for (TrainingDatesDetails trainingDatesDetails : trainingDatesDetailsList) {
//			for (DaysDetails daysDetails : trainingDaysDetails) {
//				if(trainingDatesDetails.getDaysDetails().getDaysId() == daysDetails.getDaysId()) {
//					
//				}
//			}
//		}
		return monthlyTrainingCalenderDetailsList;
	}

}
