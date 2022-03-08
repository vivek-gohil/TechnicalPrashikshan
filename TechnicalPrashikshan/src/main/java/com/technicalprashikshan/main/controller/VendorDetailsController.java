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

import com.technicalprashikshan.main.pojo.VendorDetails;
import com.technicalprashikshan.main.service.interfaces.VendorDetailsServiceInteface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/vendordetailsapi")
public class VendorDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(VendorDetailsController.class);

	@Autowired
	private VendorDetailsServiceInteface vendorDetailsService;

	public VendorDetailsController() {
		logger.info("VendorDetailsController object created");
	}

	@RequestMapping(value = "vendordetails", method = RequestMethod.POST)
	public int newClientDetails(@RequestBody VendorDetails vendorDetails) {
		logger.info(vendorDetails.toString());
		return vendorDetailsService.addNewVendorDetails(vendorDetails);
	}

	@RequestMapping(value = "vendordetails/{vendorId}", method = RequestMethod.DELETE)
	public boolean deleteClientDetails(@PathVariable int vendorId) {
		logger.info("" + vendorId);
		return vendorDetailsService.deleteVenderDetailsByVendorId(vendorId);
	}

	@RequestMapping(value = "vendordetails", method = RequestMethod.PUT)
	public VendorDetails updateClientDetails(@RequestBody VendorDetails vendorDetails) {
		logger.info(vendorDetails.toString());
		return vendorDetailsService.updateVendorDetails(vendorDetails);
	}

	@RequestMapping(value = "vendordetails/all", method = RequestMethod.GET)
	public List<VendorDetails> getAllClientDetails() {
		logger.info("Retriving all vendor details");
		return vendorDetailsService.getAllVendorDetails();
	}

	@RequestMapping(value = "vendordetails/{vendorId}", method = RequestMethod.GET)
	public VendorDetails getSingleClientDetails(@PathVariable int vendorId) {
		logger.info("" + vendorId);
		return vendorDetailsService.getVendorDetailsByVendorId(vendorId);
	}
}
