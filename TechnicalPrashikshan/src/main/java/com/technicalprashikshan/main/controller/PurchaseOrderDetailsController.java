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

import com.technicalprashikshan.main.pojo.PurchaseOrderDetails;
import com.technicalprashikshan.main.service.interfaces.PurchaseOrderDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/purchaseorderdetailsapi")
public class PurchaseOrderDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderDetailsController.class);

	@Autowired
	private PurchaseOrderDetailsServiceInterface purchaseOrderDetailsService;

	public PurchaseOrderDetailsController() {
		logger.info("PurchaseOrderDetailsController object created");
	}

	@RequestMapping(value = "purchaseorderdetails", method = RequestMethod.POST)
	public String newPurchaseOrderDetails(@RequestBody PurchaseOrderDetails purchaseOrderDetails) {
		logger.info(purchaseOrderDetails.toString());
		return purchaseOrderDetailsService.addNewPurchaseOrderDetails(purchaseOrderDetails);
	}

	@RequestMapping(value = "purchaseorderdetails/{purchaseOrderId}", method = RequestMethod.DELETE)
	public boolean deletePurchaseOrderDetails(@PathVariable String purchaseOrderId) {
		logger.info("" + purchaseOrderId);
		return purchaseOrderDetailsService.deletePurchaseOrderDetailsByPurchaseOrderId(purchaseOrderId);
	}

	@RequestMapping(value = "purchaseorderdetails", method = RequestMethod.PUT)
	public PurchaseOrderDetails updatePurchaseOrderDetails(@RequestBody PurchaseOrderDetails purchaseOrderDetails) {
		logger.info(purchaseOrderDetails.toString());
		return purchaseOrderDetailsService.updatePurchaseOrderDetails(purchaseOrderDetails);
	}

	@RequestMapping(value = "purchaseorderdetails/all", method = RequestMethod.GET)
	public List<PurchaseOrderDetails> getAllPurchaseOrderDetails() {
		logger.info("Retriving all purchaseOrder details");
		return purchaseOrderDetailsService.getAllPurchaseOrderDetails();
	}

	@RequestMapping(value = "purchaseorderdetails/{purchaseOrderId}", method = RequestMethod.GET)
	public PurchaseOrderDetails getSinglePurchaseOrderDetails(@PathVariable String purchaseOrderId) {
		logger.info("" + purchaseOrderId);
		return purchaseOrderDetailsService.getPurchaseOrderDetailsByPurchaseOrderId(purchaseOrderId);
	}
}
