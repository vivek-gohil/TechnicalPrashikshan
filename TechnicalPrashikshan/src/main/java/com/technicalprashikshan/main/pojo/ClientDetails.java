package com.technicalprashikshan.main.pojo;

public class ClientDetails {
	private int clientId;
	private String companyName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String pin;
	private ContactDetails primaryContact;

	public ClientDetails() {
	}

	public ClientDetails(int clientId, String companyName, String addressLine1, String addressLine2, String city,
			String state, String pin, ContactDetails primaryContact) {
		super();
		this.clientId = clientId;
		this.companyName = companyName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.primaryContact = primaryContact;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public ContactDetails getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(ContactDetails primaryContact) {
		this.primaryContact = primaryContact;
	}

	@Override
	public String toString() {
		return "ClientDetails [clientId=" + clientId + ", companyName=" + companyName + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", pin=" + pin
				+ ", primaryContact=" + primaryContact + "]";
	}

}
