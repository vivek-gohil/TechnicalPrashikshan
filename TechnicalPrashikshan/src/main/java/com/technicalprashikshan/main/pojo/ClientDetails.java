package com.technicalprashikshan.main.pojo;

public class ClientDetails {
	private int clientId;
	private String companyName;
	private String addressLineOne;
	private String addressLineTwo;
	private String landmark;
	private String city;
	private String state;
	private String pin;
	private String clientStatus;
	private ContactDetails primaryContact;

	public ClientDetails() {
		// TODO Auto-generated constructor stub
	}

	public ClientDetails(int clientId, String companyName, String addressLineOne, String addressLineTwo,
			String landmark, String city, String state, String pin, String clientStatus,
			ContactDetails primaryContact) {
		super();
		this.clientId = clientId;
		this.companyName = companyName;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.clientStatus = clientStatus;
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

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
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

	public String getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

	public ContactDetails getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(ContactDetails primaryContact) {
		this.primaryContact = primaryContact;
	}

	@Override
	public String toString() {
		return "ClientDetails [clientId=" + clientId + ", companyName=" + companyName + ", addressLineOne="
				+ addressLineOne + ", addressLineTwo=" + addressLineTwo + ", landmark=" + landmark + ", city=" + city
				+ ", state=" + state + ", pin=" + pin + ", clientStatus=" + clientStatus + ", primaryContact="
				+ primaryContact + "]";
	}

}
