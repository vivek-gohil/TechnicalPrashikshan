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

import com.technicalprashikshan.main.pojo.BankingDetails;
import com.technicalprashikshan.main.service.interfaces.BankingDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/financialyeardetailsapi")
public class BankingDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(BankingDetailsController.class);

	@Autowired
	private BankingDetailsServiceInterface financialYearDetailsService;

	public BankingDetailsController() {
		logger.info("BankingDetailsController object created");
	}

	@RequestMapping(value = "financialYeardetails", method = RequestMethod.POST)
	public int newBankingDetails(@RequestBody BankingDetails financialYearDetails) {
		logger.info(financialYearDetails.toString());
		return financialYearDetailsService.addNewBankingDetails(financialYearDetails);
	}

	@RequestMapping(value = "financialYeardetails/{financialYearId}", method = RequestMethod.DELETE)
	public boolean deleteBankingDetails(@PathVariable int financialYearId) {
		logger.info("" + financialYearId);
		return financialYearDetailsService.deleteBankingDetailsByBankingId(financialYearId);
	}

	@RequestMapping(value = "financialYeardetails", method = RequestMethod.PUT)
	public BankingDetails updateBankingDetails(@RequestBody BankingDetails financialYearDetails) {
		logger.info(financialYearDetails.toString());
		return financialYearDetailsService.updateBankingDetails(financialYearDetails);
	}

	@RequestMapping(value = "financialYeardetails/all", method = RequestMethod.GET)
	public List<BankingDetails> getAllBankingDetails() {
		logger.info("Retriving all client details");
		return financialYearDetailsService.getAllBankingDetails();
	}

	@RequestMapping(value = "financialYeardetails/{financialYearId}", method = RequestMethod.GET)
	public BankingDetails getSingleBankingDetails(@PathVariable int financialYearId) {
		logger.info("" + financialYearId);
		return financialYearDetailsService.getBankingDetailsByBankingId(financialYearId);
	}
}
