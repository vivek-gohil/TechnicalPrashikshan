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

import com.technicalprashikshan.main.pojo.ContactDetails;
import com.technicalprashikshan.main.service.interfaces.ContactDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/contactdetailsapi")
public class ContactDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(ContactDetailsController.class);

	@Autowired
	private ContactDetailsServiceInterface contactDetailsService;

	public ContactDetailsController() {
		logger.info("ContactDetailsController object created");
	}

	@RequestMapping(value = "contactdetails", method = RequestMethod.POST)
	public int newContactDetails(@RequestBody ContactDetails contactDetails) {
		logger.info(contactDetails.toString());
		return contactDetailsService.addNewContactDetails(contactDetails);
	}

	@RequestMapping(value = "contactdetails/{contactId}", method = RequestMethod.DELETE)
	public boolean deleteContactDetails(@PathVariable int contactId) {
		logger.info("" + contactId);
		return contactDetailsService.deleteContactDetailsByContactId(contactId);
	}

	@RequestMapping(value = "contactdetails", method = RequestMethod.PUT)
	public ContactDetails updateContactDetails(@RequestBody ContactDetails contactDetails) {
		logger.info(contactDetails.toString());
		return contactDetailsService.updateContactDetails(contactDetails);
	}

	@RequestMapping(value = "contactdetails/all", method = RequestMethod.GET)
	public List<ContactDetails> getAllContactDetails() {
		logger.info("Retriving all contact details");
		return contactDetailsService.getAllContactDetails();
	}

	@RequestMapping(value = "contactdetails/{contactId}", method = RequestMethod.GET)
	public ContactDetails getSingleContactDetails(@PathVariable int contactId) {
		logger.info("" + contactId);
		return contactDetailsService.getContactDetailsByContactId(contactId);
	}

}
