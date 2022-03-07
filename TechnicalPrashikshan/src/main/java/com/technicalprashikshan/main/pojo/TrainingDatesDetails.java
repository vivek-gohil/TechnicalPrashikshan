package com.technicalprashikshan.main.pojo;

public class TrainingDatesDetails {
	private int trainingDateId;
	private DaysDetails daysDetails;
	private TrainingDetails trainingDetails;
	private TrainerDetails trainerDetails;

	public TrainingDatesDetails() {
		// TODO Auto-generated constructor stub
	}

	public TrainingDatesDetails(int trainingDateId, DaysDetails daysDetails, TrainingDetails trainingDetails,
			TrainerDetails trainerDetails) {
		super();
		this.trainingDateId = trainingDateId;
		this.daysDetails = daysDetails;
		this.trainingDetails = trainingDetails;
		this.trainerDetails = trainerDetails;
	}

	public int getTrainingDateId() {
		return trainingDateId;
	}

	public void setTrainingDateId(int trainingDateId) {
		this.trainingDateId = trainingDateId;
	}

	public DaysDetails getDaysDetails() {
		return daysDetails;
	}

	public void setDaysDetails(DaysDetails daysDetails) {
		this.daysDetails = daysDetails;
	}

	public TrainingDetails getTrainingDetails() {
		return trainingDetails;
	}

	public void setTrainingDetails(TrainingDetails trainingDetails) {
		this.trainingDetails = trainingDetails;
	}

	public TrainerDetails getTrainerDetails() {
		return trainerDetails;
	}

	public void setTrainerDetails(TrainerDetails trainerDetails) {
		this.trainerDetails = trainerDetails;
	}

	@Override
	public String toString() {
		return "TrainingDatesDetails [trainingDateId=" + trainingDateId + ", daysDetails=" + daysDetails
				+ ", trainingDetails=" + trainingDetails + ", trainerDetails=" + trainerDetails + "]";
	}

}
