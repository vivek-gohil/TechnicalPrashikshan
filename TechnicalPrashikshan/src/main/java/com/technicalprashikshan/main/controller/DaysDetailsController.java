package com.technicalprashikshan.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technicalprashikshan.main.pojo.DaysDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.service.interfaces.DaysDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/daysdetailsapi")
public class DaysDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(DaysDetailsController.class);

	@Autowired
	private DaysDetailsServiceInterface daysDetailsService;

	public DaysDetailsController() {
		logger.info("DaysDetailsController object created");
	}

	@RequestMapping(value = "daysdetails", method = RequestMethod.POST)
	public int newDaysDetails(@RequestBody DaysDetails daysDetails) {
		logger.info(daysDetails.toString());
		return daysDetailsService.addNewDaysDetails(daysDetails);
	}

	@RequestMapping(value = "daysdetails/{daysId}", method = RequestMethod.DELETE)
	public boolean deleteDaysDetails(@PathVariable int daysId) {
		logger.info("" + daysId);
		return daysDetailsService.deleteDaysDetailsByDaysId(daysId);
	}

	@RequestMapping(value = "daysdetails", method = RequestMethod.PUT)
	public DaysDetails updateDaysDetails(@RequestBody DaysDetails daysDetails) {
		logger.info(daysDetails.toString());
		return daysDetailsService.updateDaysDetails(daysDetails);
	}

	@RequestMapping(value = "daysdetails/all", method = RequestMethod.GET)
	public List<DaysDetails> getAllDaysDetails() {
		logger.info("Retriving all client details");
		return daysDetailsService.getAllDaysDetails();
	}

	@RequestMapping(value = "daysdetails/{daysId}", method = RequestMethod.GET)
	public DaysDetails getSingleDaysDetails(@PathVariable int daysId) {
		logger.info("" + daysId);
		return daysDetailsService.getDaysDetailsByDaysId(daysId);
	}

	@RequestMapping(value = "daysdetails/alldaysbymonthstartdate", method = RequestMethod.POST)
	public List<DaysDetails> getAllDaysDetailsByMonthStartDate(@RequestBody MonthsDetails monthsDetails) {
		logger.info("Retriving all month details by start date");
		logger.info(monthsDetails.toString());
		return daysDetailsService.getAllDaysDetailsByMonthStartDate(monthsDetails);
	}

	@RequestMapping(value = "daysdetails/alltrainingdaysbymonthstartdate", method = RequestMethod.POST)
	public List<DaysDetails> getAllTrainingDaysDetailsByMonthStartDate(@RequestBody MonthsDetails monthsDetails) {
		logger.info("Retriving all training days details by start date");
		logger.info(monthsDetails.toString());
		return daysDetailsService.getAllTrainingDaysByMonthStartDate(monthsDetails);
	}

}
