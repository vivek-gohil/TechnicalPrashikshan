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

import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingDetails;
import com.technicalprashikshan.main.service.interfaces.TrainingDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/trainingdetailsapi")
public class TrainingDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(TrainingDetailsController.class);

	@Autowired
	private TrainingDetailsServiceInterface trainingDetailsService;

	public TrainingDetailsController() {
		logger.info("TrainingDetailsController object created");
	}

	@RequestMapping(value = "trainingdetails", method = RequestMethod.POST)
	public int newTrainingDetails(@RequestBody TrainingDetails trainingDetails) {
		logger.info(trainingDetails.toString());
		return trainingDetailsService.addNewTrainingDetails(trainingDetails);
	}

	@RequestMapping(value = "trainingdetails/{trainingDetailsId}", method = RequestMethod.DELETE)
	public boolean deleteTrainingDetails(@PathVariable int trainingDetailsId) {
		logger.info("" + trainingDetailsId);
		return trainingDetailsService.deleteTrainingDetailsByTrainingId(trainingDetailsId);
	}

	@RequestMapping(value = "trainingdetails", method = RequestMethod.PUT)
	public TrainingDetails updateTrainingDetails(@RequestBody TrainingDetails trainingDetails) {
		logger.info(trainingDetails.toString());
		return trainingDetailsService.updateTrainingDetails(trainingDetails);
	}

	@RequestMapping(value = "trainingdetails/all", method = RequestMethod.GET)
	public List<TrainingDetails> getAllTrainingDetails() {
		logger.info("Retriving all training details");
		return trainingDetailsService.getAllTrainingDetails();
	}

	@RequestMapping(value = "trainingdetails/{trainingDetailsId}", method = RequestMethod.GET)
	public TrainingDetails getSingleTrainingDetails(@PathVariable int trainingDetailsId) {
		logger.info("" + trainingDetailsId);
		return trainingDetailsService.getTrainingDetailsByTrainingId(trainingDetailsId);
	}
	
	@RequestMapping(value = "trainingdetails/alltrainingdetailsbymonthstartdate", method = RequestMethod.POST)
	public List<TrainingDetails> getAllTrainingDetailsByMonthStartDate(@RequestBody MonthsDetails monthsDetails) {
		logger.info("Retriving all training details");
		return trainingDetailsService.getAllTrainingDetails();
	}
}
