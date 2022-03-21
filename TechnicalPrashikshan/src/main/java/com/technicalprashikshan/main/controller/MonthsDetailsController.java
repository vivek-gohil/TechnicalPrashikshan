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

import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.service.interfaces.MonthsDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/monthsdetailsapi")
public class MonthsDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(MonthsDetailsController.class);

	@Autowired
	private MonthsDetailsServiceInterface monthsDetailsService;

	public MonthsDetailsController() {
		logger.info("MonthsDetailsController object created");
	}

	@RequestMapping(value = "monthsdetails", method = RequestMethod.POST)
	public int newMonthsDetails(@RequestBody MonthsDetails monthsDetails) {
		logger.info(monthsDetails.toString());
		return monthsDetailsService.addNewMonthsDetails(monthsDetails);
	}

	@RequestMapping(value = "monthsdetails/{monthId}", method = RequestMethod.DELETE)
	public boolean deleteMonthsDetails(@PathVariable int monthId) {
		logger.info("" + monthId);
		return monthsDetailsService.deleteMonthsDetailsByMonthsId(monthId);
	}

	@RequestMapping(value = "monthsdetails", method = RequestMethod.PUT)
	public MonthsDetails updateMonthsDetails(@RequestBody MonthsDetails monthsDetails) {
		logger.info(monthsDetails.toString());
		return monthsDetailsService.updateMonthsDetails(monthsDetails);
	}

	@RequestMapping(value = "monthsdetails/all", method = RequestMethod.GET)
	public List<MonthsDetails> getAllMonthsDetails() {
		logger.info("Retriving all months details");
		return monthsDetailsService.getAllMonthsDetails();
	}

	@RequestMapping(value = "monthsdetails/{monthId}", method = RequestMethod.GET)
	public MonthsDetails getSingleMonthsDetails(@PathVariable int monthId) {
		logger.info("" + monthId);
		return monthsDetailsService.getMonthsDetailsByMonthsId(monthId);
	}
}
