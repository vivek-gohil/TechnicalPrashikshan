package com.technicalprashikshan.main.pojo;

public class TrainerDetails {
	private int trainerId;
	private String firstName;
	private String lastName;
	private double perDayRate;
	private FilesDetails profile;
	private String description;
	private String trainerStatus;
	private String addressLineOne;
	private String addressLineTwo;
	private String landmark;
	private String city;
	private String state;
	private String pin;
	private ContactDetails trainerContactDetails;
	private UserDetails userDetails;
	private BankingDetails bankingDetails;

	public TrainerDetails() {
		// TODO Auto-generated constructor stub
	}

	public TrainerDetails(int trainerId, String firstName, String lastName, double perDayRate, FilesDetails profile,
			String description, String trainerStatus, String addressLineOne, String addressLineTwo, String landmark,
			String city, String state, String pin, ContactDetails trainerContactDetails, UserDetails userDetails,
			BankingDetails bankingDetails) {
		super();
		this.trainerId = trainerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.perDayRate = perDayRate;
		this.profile = profile;
		this.description = description;
		this.trainerStatus = trainerStatus;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.trainerContactDetails = trainerContactDetails;
		this.userDetails = userDetails;
		this.bankingDetails = bankingDetails;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
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

	public double getPerDayRate() {
		return perDayRate;
	}

	public void setPerDayRate(double perDayRate) {
		this.perDayRate = perDayRate;
	}

	public FilesDetails getProfile() {
		return profile;
	}

	public void setProfile(FilesDetails profile) {
		this.profile = profile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrainerStatus() {
		return trainerStatus;
	}

	public void setTrainerStatus(String trainerStatus) {
		this.trainerStatus = trainerStatus;
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

	public ContactDetails getTrainerContactDetails() {
		return trainerContactDetails;
	}

	public void setTrainerContactDetails(ContactDetails trainerContactDetails) {
		this.trainerContactDetails = trainerContactDetails;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public BankingDetails getBankingDetails() {
		return bankingDetails;
	}

	public void setBankingDetails(BankingDetails bankingDetails) {
		this.bankingDetails = bankingDetails;
	}

	@Override
	public String toString() {
		return "TrainerDetails [trainerId=" + trainerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", perDayRate=" + perDayRate + ", profile=" + profile + ", description=" + description
				+ ", trainerStatus=" + trainerStatus + ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", landmark=" + landmark + ", city=" + city + ", state=" + state + ", pin=" + pin
				+ ", trainerContactDetails=" + trainerContactDetails + ", userDetails=" + userDetails
				+ ", bankingDetails=" + bankingDetails + "]";
	}

}
