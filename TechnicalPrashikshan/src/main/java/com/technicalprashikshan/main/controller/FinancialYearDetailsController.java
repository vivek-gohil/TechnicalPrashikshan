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

import com.technicalprashikshan.main.pojo.FinancialYearDetails;
import com.technicalprashikshan.main.service.interfaces.FinancialYearDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/financialyeardetailsapi")
public class FinancialYearDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(FinancialYearDetailsController.class);

	@Autowired
	private FinancialYearDetailsServiceInterface financialYearDetailsService;

	public FinancialYearDetailsController() {
		logger.info("FinancialYearDetailsController object created");
	}

	@RequestMapping(value = "financialyeardetails", method = RequestMethod.POST)
	public int newFinancialYearDetails(@RequestBody FinancialYearDetails financialYearDetails) {
		logger.info(financialYearDetails.toString());
		return financialYearDetailsService.addNewFinancialYearDetails(financialYearDetails);
	}

	@RequestMapping(value = "financialyeardetails/{financialYearId}", method = RequestMethod.DELETE)
	public boolean deleteFinancialYearDetails(@PathVariable int financialYearId) {
		logger.info("" + financialYearId);
		return financialYearDetailsService.deleteFinancialYearDetailsByFinancialYearId(financialYearId);
	}

	@RequestMapping(value = "financialyeardetails", method = RequestMethod.PUT)
	public FinancialYearDetails updateFinancialYearDetails(@RequestBody FinancialYearDetails financialYearDetails) {
		logger.info(financialYearDetails.toString());
		return financialYearDetailsService.updateFinancialYearDetails(financialYearDetails);
	}

	@RequestMapping(value = "financialyeardetails/all", method = RequestMethod.GET)
	public List<FinancialYearDetails> getAllFinancialYearDetails() {
		logger.info("Retriving all client details");
		return financialYearDetailsService.getAllFinancialYearDetails();
	}

	@RequestMapping(value = "financialyeardetails/{financialYearId}", method = RequestMethod.GET)
	public FinancialYearDetails getSingleFinancialYearDetails(@PathVariable int financialYearId) {
		logger.info("" + financialYearId);
		return financialYearDetailsService.getFinancialYearDetailsByFinancialYearId(financialYearId);
	}
}
