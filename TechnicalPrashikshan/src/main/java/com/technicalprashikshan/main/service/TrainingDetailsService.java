package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.TrainingDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingDetails;
import com.technicalprashikshan.main.service.interfaces.TrainingDetailsServiceInterface;

@Service
public class TrainingDetailsService implements TrainingDetailsServiceInterface {

	@Autowired
	private TrainingDetailsDAOInterface trainingDetailsDAO;

	@Override
	public int addNewTrainingDetails(TrainingDetails trainingDetails) {
		return trainingDetailsDAO.addNewTrainingDetails(trainingDetails);
	}

	@Override
	public TrainingDetails updateTrainingDetails(TrainingDetails trainingDetails) {
		return trainingDetailsDAO.updateTrainingDetails(trainingDetails);
	}

	@Override
	public TrainingDetails getTrainingDetailsByTrainingId(int trainingId) {
		return trainingDetailsDAO.getTrainingDetailsByTrainingId(trainingId);
	}

	@Override
	public List<TrainingDetails> getAllTrainingDetails() {
		return trainingDetailsDAO.getAllTrainingDetails();
	}

	@Override
	public boolean deleteTrainingDetailsByTrainingId(int trainingId) {
		return trainingDetailsDAO.deleteTrainingDetailsByTrainingId(trainingId);
	}

	@Override
	public List<TrainingDetails> getAllTrainingDetailsByMonthStartDate(MonthsDetails monthsDetails) {
		return trainingDetailsDAO.getAllTrainingDetailsByMonthStartDate(monthsDetails);
	}

}
