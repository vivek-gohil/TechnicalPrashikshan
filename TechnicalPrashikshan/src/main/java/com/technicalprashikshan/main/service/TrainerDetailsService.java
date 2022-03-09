package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.TrainerDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.TrainerDetails;
import com.technicalprashikshan.main.service.interfaces.TrainerDetailsServiceInterface;

@Service
public class TrainerDetailsService implements TrainerDetailsServiceInterface {

	@Autowired
	private TrainerDetailsDAOInterface trainerDetailsDAO;

	@Override
	public int addNewTrainerDetails(TrainerDetails trainerDetails) {
		return trainerDetailsDAO.addNewTrainerDetails(trainerDetails);
	}

	@Override
	public TrainerDetails updateTrainerDetails(TrainerDetails trainerDetails) {
		return trainerDetailsDAO.updateTrainerDetails(trainerDetails);
	}

	@Override
	public TrainerDetails getTrainerDetailsByTrainerId(int trainerId) {
		return trainerDetailsDAO.getTrainerDetailsByTrainerId(trainerId);
	}

	@Override
	public List<TrainerDetails> getAllTrainerDetails() {
		return trainerDetailsDAO.getAllTrainerDetails();
	}

	@Override
	public boolean deleteTrainerDetailsByTrainerId(int trainerId) {
		return trainerDetailsDAO.deleteTrainerDetailsByTrainerId(trainerId);
	}

}
