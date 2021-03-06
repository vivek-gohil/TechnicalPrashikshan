package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingDetails;

public interface TrainingDetailsDAOInterface {
	public int addNewTrainingDetails(TrainingDetails trainingDetails);

	public TrainingDetails updateTrainingDetails(TrainingDetails trainingDetails);

	public TrainingDetails getTrainingDetailsByTrainingId(int trainingId);

	public List<TrainingDetails> getAllTrainingDetails();

	public boolean deleteTrainingDetailsByTrainingId(int trainingId);

	public List<TrainingDetails> getAllTrainingDetailsByMonthStartDate(MonthsDetails monthsDetails);
}
