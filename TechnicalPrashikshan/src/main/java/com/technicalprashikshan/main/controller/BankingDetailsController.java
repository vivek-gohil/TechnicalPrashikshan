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
@RequestMapping("technicalprashikshanapi/bankingdetailsapi")
public class BankingDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(BankingDetailsController.class);

	@Autowired
	private BankingDetailsServiceInterface bankingDetailsService;

	public BankingDetailsController() {
		logger.info("BankingDetailsController object created");
	}

	@RequestMapping(value = "bankingdetails", method = RequestMethod.POST)
	public int newBankingDetails(@RequestBody BankingDetails bankingDetails) {
		logger.info(bankingDetails.toString());
		return bankingDetailsService.addNewBankingDetails(bankingDetails);
	}

	@RequestMapping(value = "bankingdetails/{bankingId}", method = RequestMethod.DELETE)
	public boolean deleteBankingDetails(@PathVariable int bankingId) {
		logger.info("" + bankingId);
		return bankingDetailsService.deleteBankingDetailsByBankingId(bankingId);
	}

	@RequestMapping(value = "bankingdetails", method = RequestMethod.PUT)
	public BankingDetails updateBankingDetails(@RequestBody BankingDetails bankingDetails) {
		logger.info(bankingDetails.toString());
		return bankingDetailsService.updateBankingDetails(bankingDetails);
	}

	@RequestMapping(value = "bankingdetails/all", method = RequestMethod.GET)
	public List<BankingDetails> getAllBankingDetails() {
		logger.info("Retriving all client details");
		return bankingDetailsService.getAllBankingDetails();
	}

	@RequestMapping(value = "bankingdetails/{bankingId}", method = RequestMethod.GET)
	public BankingDetails getSingleBankingDetails(@PathVariable int bankingId) {
		logger.info("" + bankingId);
		return bankingDetailsService.getBankingDetailsByBankingId(bankingId);
	}
}
