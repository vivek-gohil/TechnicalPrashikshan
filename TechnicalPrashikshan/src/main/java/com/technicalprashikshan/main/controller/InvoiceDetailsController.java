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

import com.technicalprashikshan.main.pojo.InvoiceDetails;
import com.technicalprashikshan.main.service.interfaces.InvoiceDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/invoicedetailsapi")
public class InvoiceDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(InvoiceDetailsController.class);

	@Autowired
	private InvoiceDetailsServiceInterface invoiceDetailsService;

	public InvoiceDetailsController() {
		logger.info("InvoiceDetailsController object created");
	}

	@RequestMapping(value = "invoicedetails", method = RequestMethod.POST)
	public String newInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) {
		logger.info(invoiceDetails.toString());
		return invoiceDetailsService.addNewInvoiceDetails(invoiceDetails);
	}

	@RequestMapping(value = "invoicedetails/{invoiceId}", method = RequestMethod.DELETE)
	public boolean deleteInvoiceDetails(@PathVariable String invoiceId) {
		logger.info("" + invoiceId);
		return invoiceDetailsService.deleteInvoiceDetailsByInvoiceId(invoiceId);
	}

	@RequestMapping(value = "invoicedetails", method = RequestMethod.PUT)
	public InvoiceDetails updateInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) {
		logger.info(invoiceDetails.toString());
		return invoiceDetailsService.updateInvoiceDetails(invoiceDetails);
	}

	@RequestMapping(value = "invoicedetails/all", method = RequestMethod.GET)
	public List<InvoiceDetails> getAllInvoiceDetails() {
		logger.info("Retriving all invoice details");
		return invoiceDetailsService.getAllInvoiceDetails();
	}

	@RequestMapping(value = "invoicedetails/{invoiceId}", method = RequestMethod.GET)
	public InvoiceDetails getSingleInvoiceDetails(@PathVariable String invoiceId) {
		logger.info("" + invoiceId);
		return invoiceDetailsService.getInvoiceDetailsByInvoiceId(invoiceId);
	}
}
