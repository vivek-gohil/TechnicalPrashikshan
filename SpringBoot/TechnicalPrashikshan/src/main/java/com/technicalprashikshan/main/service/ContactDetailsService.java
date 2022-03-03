package com.technicalprashikshan.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.ContactDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.ContactDetails;
import com.technicalprashikshan.main.service.interfaces.ContactDetailsServiceInterface;

@Service
public class ContactDetailsService implements ContactDetailsServiceInterface {

	@Autowired
	private ContactDetailsDAOInterface contactDetailsDAO;

	private static final Logger logger = LoggerFactory.getLogger(ContactDetailsService.class);

	public ContactDetailsService() {
		logger.info("ContactDetailsService object created");
	}

	@Override
	public int addNewContactDetails(ContactDetails contactDetails) {
		logger.info("ContactDetailsService addNewContactDetails");
		return contactDetailsDAO.addNewContactDetails(contactDetails);
	}

	@Override
	public ContactDetails updateContactDetails(ContactDetails contactDetails) {
		logger.info("ContactDetailsService updateContactDetails");
		return contactDetailsDAO.updateContactDetails(contactDetails);
	}

	@Override
	public ContactDetails getContactDetailsByContactId(int contactId) {
		logger.info("ContactDetailsService getContactDetailsByContactId");
		return contactDetailsDAO.getContactDetailsByContactId(contactId);
	}

	@Override
	public List<ContactDetails> getAllContactDetails() {
		logger.info("ContactDetailsService getAllContactDetails");
		return contactDetailsDAO.getAllContactDetails();
	}

	@Override
	public boolean deleteContactDetailsByContactId(int contactId) {
		logger.info("ContactDetailsService deleteContactDetailsByContactId");
		return contactDetailsDAO.deleteContactDetailsByContactId(contactId);
	}

}
