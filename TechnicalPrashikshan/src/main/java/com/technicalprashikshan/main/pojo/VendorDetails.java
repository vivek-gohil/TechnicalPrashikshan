package com.technicalprashikshan.main.pojo;

public class VendorDetails {
	private int vendorId;
	private String vendorName;
	private String addressLineOne;
	private String addressLineTwo;
	private String landmark;
	private String city;
	private String state;
	private String pin;
	private String vendorStatus;
	private ContactDetails primaryContactDetails;

	public VendorDetails() {
		// TODO Auto-generated constructor stub
	}

	public VendorDetails(int vendorId, String vendorName, String addressLineOne, String addressLineTwo, String landmark,
			String city, String state, String pin, String vendorStatus, ContactDetails primaryContactDetails) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.vendorStatus = vendorStatus;
		this.primaryContactDetails = primaryContactDetails;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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

	public String getVendorStatus() {
		return vendorStatus;
	}

	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}

	public ContactDetails getPrimaryContactDetails() {
		return primaryContactDetails;
	}

	public void setPrimaryContactDetails(ContactDetails primaryContactDetails) {
		this.primaryContactDetails = primaryContactDetails;
	}

	@Override
	public String toString() {
		return "VendorDetails [vendorId=" + vendorId + ", vendorName=" + vendorName + ", addressLineOne="
				+ addressLineOne + ", addressLineTwo=" + addressLineTwo + ", landmark=" + landmark + ", city=" + city
				+ ", state=" + state + ", pin=" + pin + ", vendorStatus=" + vendorStatus + ", primaryContactDetails="
				+ primaryContactDetails + "]";
	}

}
