package com.technicalprashikshan.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technicalprashikshan.main.pojo.MonthlyTrainingCalenderDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.service.interfaces.MonthlyTrainingCalendarDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/monthlytrainingcalendardetailsapi")
public class MonthlyTrainingCalenderDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(MonthlyTrainingCalenderDetailsController.class);

	@Autowired
	private MonthlyTrainingCalendarDetailsServiceInterface monthlyTrainingCalendarDetailsService;

	@RequestMapping(value = "monthlytrainingcalendardetails/bymonthstartdate", method = RequestMethod.POST)
	public List<MonthlyTrainingCalenderDetails> getMonthlyTrainingCalenderDetails(
			@RequestBody MonthsDetails monthsDetails) {
		logger.info(monthsDetails.toString());
		List<MonthlyTrainingCalenderDetails> monthlyTrainingCalendarList = monthlyTrainingCalendarDetailsService
				.getMonthlyTrainingCalenderDetails(monthsDetails);
		for (MonthlyTrainingCalenderDetails monthlyTrainingCalenderDetails : monthlyTrainingCalendarList) {
			logger.info(monthlyTrainingCalenderDetails.toString());
		}
		return monthlyTrainingCalendarList;
	}

}
