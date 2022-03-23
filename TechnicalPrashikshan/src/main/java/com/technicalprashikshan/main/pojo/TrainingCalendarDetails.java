package com.technicalprashikshan.main.pojo;

import java.util.List;

public class TrainingCalendarDetails {

	private List<DaysDetails> allDaysDetailsList;
	private List<DaysDetails> trainingDaysDetailsList;
	private List<TrainingDetails> trainingDetailsList;

	public TrainingCalendarDetails() {
		// TODO Auto-generated constructor stub
	}

	public TrainingCalendarDetails(List<DaysDetails> allDaysDetailsList, List<DaysDetails> trainingDaysDetailsList,
			List<TrainingDetails> trainingDetailsList) {
		super();
		this.allDaysDetailsList = allDaysDetailsList;
		this.trainingDaysDetailsList = trainingDaysDetailsList;
		this.trainingDetailsList = trainingDetailsList;
	}

	public List<DaysDetails> getAllDaysDetailsList() {
		return allDaysDetailsList;
	}

	public void setAllDaysDetailsList(List<DaysDetails> allDaysDetailsList) {
		this.allDaysDetailsList = allDaysDetailsList;
	}

	public List<DaysDetails> getTrainingDaysDetailsList() {
		return trainingDaysDetailsList;
	}

	public void setTrainingDaysDetailsList(List<DaysDetails> trainingDaysDetailsList) {
		this.trainingDaysDetailsList = trainingDaysDetailsList;
	}

	public List<TrainingDetails> getTrainingDetailsList() {
		return trainingDetailsList;
	}

	public void setTrainingDetailsList(List<TrainingDetails> trainingDetailsList) {
		this.trainingDetailsList = trainingDetailsList;
	}

	@Override
	public String toString() {
		return "TrainingCalendarDetails [allDaysDetailsList=" + allDaysDetailsList + ", trainingDaysDetailsList="
				+ trainingDaysDetailsList + ", trainingDetailsList=" + trainingDetailsList + "]";
	}

}
