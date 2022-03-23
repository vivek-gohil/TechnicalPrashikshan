package com.technicalprashikshan.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingCalendarDetails;
import com.technicalprashikshan.main.service.interfaces.TrainingCalendarDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/trainingcalenderdetailsapi")
public class TrainingCalendarDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(TrainingCalendarDetailsController.class);

	@Autowired
	private TrainingCalendarDetailsServiceInterface trainingCalendarDetailsService;

	@RequestMapping(value = "trainingcalenderdetails/bymonthstartdate", method = RequestMethod.POST)
	public TrainingCalendarDetails getTrainingCalenderDetailsByMonthStartDate(
			@RequestBody MonthsDetails monthsDetails) {
		TrainingCalendarDetails trainingCalendarDetails = trainingCalendarDetailsService
				.getAllTrainingCalenderDetailsByMonthStartDate(monthsDetails);
		logger.info(trainingCalendarDetails.toString());
		return trainingCalendarDetails;
	}
}
