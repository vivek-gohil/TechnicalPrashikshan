package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.TrainingDetails;

public interface TrainingDetailsServiceInterface {
	public int addNewTrainingDetails(TrainingDetails trainingDetails);

	public TrainingDetails updateTrainingDetails(TrainingDetails trainingDetails);

	public TrainingDetails getTrainingDetailsByTrainingId(int trainingId);

	public List<TrainingDetails> getAllTrainingDetails();

	public boolean deleteTrainingDetailsByTrainingId(int trainingId);
}