package com.technicalprashikshan.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technicalprashikshan.main.pojo.TrainerDetails;
import com.technicalprashikshan.main.service.interfaces.TrainerDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/trainerdetailsapi")
public class TrainerDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(TrainerDetailsController.class);

	@Autowired
	private TrainerDetailsServiceInterface trainerDetailsService;

	public TrainerDetailsController() {
		logger.info("TrainerDetailsController object created");
	}

	@RequestMapping(value = "trainerdetails", method = RequestMethod.POST)
	public int newTrainerDetails(@RequestBody TrainerDetails trainerDetails) {
		logger.info(trainerDetails.toString());
		return trainerDetailsService.addNewTrainerDetails(trainerDetails);
	}

	@RequestMapping(value = "trainerdetails/{trainerId}", method = RequestMethod.DELETE)
	public boolean deleteTrainerDetails(@PathVariable int trainerId) {
		logger.info("" + trainerId);
		return trainerDetailsService.deleteTrainerDetailsByTrainerId(trainerId);
	}

	@RequestMapping(value = "trainerdetails", method = RequestMethod.PUT)
	public TrainerDetails updateTrainerDetails(@RequestBody TrainerDetails trainerDetails) {
		logger.info(trainerDetails.toString());
		return trainerDetailsService.updateTrainerDetails(trainerDetails);
	}

	@RequestMapping(value = "trainerdetails/all", method = RequestMethod.GET)
	public List<TrainerDetails> getAllTrainerDetails() {
		logger.info("Retriving all client details");
		return trainerDetailsService.getAllTrainerDetails();
	}

	@RequestMapping(value = "trainerdetails/{trainerId}", method = RequestMethod.GET)
	public TrainerDetails getSingleTrainerDetails(@PathVariable int trainerId) {
		logger.info("" + trainerId);
		return trainerDetailsService.getTrainerDetailsByTrainerId(trainerId);
	}
	
	@RequestMapping(value = "trainerdetails/byuserid/{userId}", method = RequestMethod.GET)
	public TrainerDetails getSingleTrainerDetailsByUserId(@PathVariable int userId) {
		logger.info("" + userId);
		return trainerDetailsService.getTrainerDetailsByUserId(userId);
	}
}
