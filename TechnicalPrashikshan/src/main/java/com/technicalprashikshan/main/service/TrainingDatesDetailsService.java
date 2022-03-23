package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.TrainingDatesDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingDatesDetails;
import com.technicalprashikshan.main.service.interfaces.TrainingDatesDetailsServiceInterface;

@Service
public class TrainingDatesDetailsService implements TrainingDatesDetailsServiceInterface {

	@Autowired
	private TrainingDatesDetailsDAOInterface trainingDatesDetailsDAO;

	@Override
	public int addNewTrainingDatesDetails(TrainingDatesDetails trainingDatesDetails) {
		return trainingDatesDetailsDAO.addNewTrainingDatesDetails(trainingDatesDetails);
	}

	@Override
	public TrainingDatesDetails updateTrainingDatesDetails(TrainingDatesDetails trainingDatesDetails) {
		return trainingDatesDetailsDAO.updateTrainingDatesDetails(trainingDatesDetails);
	}

	@Override
	public TrainingDatesDetails getTrainingDatesDetailsByTrainingDatesId(int trainingDatesId) {
		return trainingDatesDetailsDAO.getTrainingDatesDetailsByTrainingDatesId(trainingDatesId);
	}

	@Override
	public List<TrainingDatesDetails> getAllTrainingDatesDetails() {
		return trainingDatesDetailsDAO.getAllTrainingDatesDetails();
	}

	@Override
	public boolean deleteVenderDetailsByTrainingDatesId(int trainingDatesId) {
		return trainingDatesDetailsDAO.deleteVenderDetailsByTrainingDatesId(trainingDatesId);
	}

	@Override
	public List<TrainingDatesDetails> getAllTrainingDatesDetailsByMonthStartDate(MonthsDetails monthsDetails) {
		return trainingDatesDetailsDAO.getAllTrainingDatesDetailsByMonthStartDate(monthsDetails);
	}

}
