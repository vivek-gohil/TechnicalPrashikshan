package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.ContactDetails;

public interface ContactDetailsDAOInterface {
	public int addNewContactDetails(ContactDetails contactDetails);

	public ContactDetails updateContactDetails(ContactDetails contactDetails);

	public ContactDetails getContactDetailsByContactId(int contactId);

	public List<ContactDetails> getAllContactDetails();

	public boolean deleteContactDetailsByContactId(int contactId);
}
