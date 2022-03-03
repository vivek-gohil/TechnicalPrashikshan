package com.technicalprashikshan.main.pojo;

public class ContactDetails {
	private int contactId;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNumber;

	public ContactDetails() {
	}

	public ContactDetails(int contactId, String firstName, String lastName, String email, String contactNumber) {
		super();
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "ContactDetails [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", contactNumber=" + contactNumber + "]";
	}

}
