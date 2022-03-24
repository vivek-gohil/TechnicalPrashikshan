package com.technicalprashikshan.main.pojo;

public class MonthlyTrainingCalenderDetails {
	private DaysDetails allDaysDetails;
	private DaysDetails trainingDaysDetails;
	private TrainingDetails trainingDetails;

	public MonthlyTrainingCalenderDetails() {
		// TODO Auto-generated constructor stub
	}

	public MonthlyTrainingCalenderDetails(DaysDetails allDaysDetails, DaysDetails trainingDaysDetails,
			TrainingDetails trainingDetails) {
		super();
		this.allDaysDetails = allDaysDetails;
		this.trainingDaysDetails = trainingDaysDetails;
		this.trainingDetails = trainingDetails;
	}

	public DaysDetails getAllDaysDetails() {
		return allDaysDetails;
	}

	public void setAllDaysDetails(DaysDetails allDaysDetails) {
		this.allDaysDetails = allDaysDetails;
	}

	public DaysDetails getTrainingDaysDetails() {
		return trainingDaysDetails;
	}

	public void setTrainingDaysDetails(DaysDetails trainingDaysDetails) {
		this.trainingDaysDetails = trainingDaysDetails;
	}

	public TrainingDetails getTrainingDetails() {
		return trainingDetails;
	}

	public void setTrainingDetails(TrainingDetails trainingDetails) {
		this.trainingDetails = trainingDetails;
	}

	@Override
	public String toString() {
		return "MonthlyTrainingCalenderDetails [allDaysDetails=" + allDaysDetails + ", trainingDaysDetails="
				+ trainingDaysDetails + ", trainingDetails=" + trainingDetails + "]";
	}

}
