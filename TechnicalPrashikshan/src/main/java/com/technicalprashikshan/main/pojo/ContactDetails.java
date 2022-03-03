package com.technicalprashikshan.main.pojo;

public class ContactDetails {
	private int contactId;
	private String firstName;
	private String lastName;
	private String contactNumberOne;
	private String contactNumberTwo;
	private String emailOne;
	private String emailTwo;
	private String contactType;
	private String contactStatus;

	public ContactDetails() {
		// TODO Auto-generated constructor stub
	}

	public ContactDetails(int contactId, String firstName, String lastName, String contactNumberOne,
			String contactNumberTwo, String emailOne, String emailTwo, String contactType, String contactStatus) {
		super();
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumberOne = contactNumberOne;
		this.contactNumberTwo = contactNumberTwo;
		this.emailOne = emailOne;
		this.emailTwo = emailTwo;
		this.contactType = contactType;
		this.contactStatus = contactStatus;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumberOne() {
		return contactNumberOne;
	}

	public void setContactNumberOne(String contactNumberOne) {
		this.contactNumberOne = contactNumberOne;
	}

	public String getContactNumberTwo() {
		return contactNumberTwo;
	}

	public void setContactNumberTwo(String contactNumberTwo) {
		this.contactNumberTwo = contactNumberTwo;
	}

	public String getEmailOne() {
		return emailOne;
	}

	public void setEmailOne(String emailOne) {
		this.emailOne = emailOne;
	}

	public String getEmailTwo() {
		return emailTwo;
	}

	public void setEmailTwo(String emailTwo) {
		this.emailTwo = emailTwo;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactStatus() {
		return contactStatus;
	}

	public void setContactStatus(String contactStatus) {
		this.contactStatus = contactStatus;
	}

	@Override
	public String toString() {
		return "ContactDetails [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNumberOne=" + contactNumberOne + ", contactNumberTwo=" + contactNumberTwo + ", emailOne="
				+ emailOne + ", emailTwo=" + emailTwo + ", contactType=" + contactType + ", contactStatus="
				+ contactStatus + "]";
	}

}
