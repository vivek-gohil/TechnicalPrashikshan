package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.TrainerDetails;

public interface TrainerDetailsServiceInterface {
	public int addNewTrainerDetails(TrainerDetails trainerDetails);

	public TrainerDetails updateTrainerDetails(TrainerDetails trainerDetails);

	public TrainerDetails getTrainerDetailsByTrainerId(int trainerId);

	public List<TrainerDetails> getAllTrainerDetails();

	public boolean deleteTrainerDetailsByTrainerId(int trainerId);

	public TrainerDetails getTrainerDetailsByUserId(int userId);
}
