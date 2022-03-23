package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingDatesDetails;

public interface TrainingDatesDetailsDAOInterface {
	public int addNewTrainingDatesDetails(TrainingDatesDetails trainingDatesDetails);

	public TrainingDatesDetails updateTrainingDatesDetails(TrainingDatesDetails trainingDatesDetails);

	public TrainingDatesDetails getTrainingDatesDetailsByTrainingDatesId(int trainingDatesId);

	public List<TrainingDatesDetails> getAllTrainingDatesDetails();

	public boolean deleteVenderDetailsByTrainingDatesId(int trainingDatesId);
	
	public List<TrainingDatesDetails> getAllTrainingDatesDetailsByMonthStartDate(MonthsDetails monthsDetails);
}
