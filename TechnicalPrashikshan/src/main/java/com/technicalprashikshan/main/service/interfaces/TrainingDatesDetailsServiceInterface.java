package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.DaysDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingDatesDetails;

public interface TrainingDatesDetailsServiceInterface {
	public int addNewTrainingDatesDetails(TrainingDatesDetails trainingDatesDetails);

	public TrainingDatesDetails updateTrainingDatesDetails(TrainingDatesDetails trainingDatesDetails);

	public TrainingDatesDetails getTrainingDatesDetailsByTrainingDatesId(int trainingDatesId);

	public List<TrainingDatesDetails> getAllTrainingDatesDetails();

	public boolean deleteVenderDetailsByTrainingDatesId(int trainingDatesId);

	public List<TrainingDatesDetails> getAllTrainingDatesDetailsByMonthStartDate(MonthsDetails monthsDetails);

	public List<DaysDetails> getAllTrainingDatesDetailsByTrainingDetailsId(int trainingDetailsId);
}
