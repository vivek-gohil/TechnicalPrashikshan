package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.TrainingDatesDetails;

public interface TrainingDatesDetailsServiceInterface {
	public int addNewTrainingDatesDetails(TrainingDatesDetails trainingDatesDetails);

	public TrainingDatesDetails updateTrainingDatesDetails(TrainingDatesDetails trainingDatesDetails);

	public TrainingDatesDetails getTrainingDatesDetailsByTrainingDatesId(int trainingDatesId);

	public List<TrainingDatesDetails> getAllTrainingDatesDetails();

	public boolean deleteVenderDetailsByTrainingDatesId(int trainingDatesId);
}