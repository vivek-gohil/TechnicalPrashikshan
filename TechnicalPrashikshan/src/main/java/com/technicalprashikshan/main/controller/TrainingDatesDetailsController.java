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

import com.technicalprashikshan.main.pojo.DaysDetails;
import com.technicalprashikshan.main.pojo.MonthsDetails;
import com.technicalprashikshan.main.pojo.TrainingDatesDetails;
import com.technicalprashikshan.main.service.interfaces.TrainingDatesDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/trainingdatesdetailsapi")
public class TrainingDatesDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(TrainingDatesDetailsController.class);

	@Autowired
	private TrainingDatesDetailsServiceInterface trainingDatesDetailsService;

	public TrainingDatesDetailsController() {
		logger.info("TrainingDatesDetailsController object created");
	}

	@RequestMapping(value = "trainingdatesdetails", method = RequestMethod.POST)
	public int newTrainingDatesDetails(@RequestBody TrainingDatesDetails trainingDatesDetails) {
		logger.info("");
		logger.info(trainingDatesDetails.toString());
		logger.info("");
		return trainingDatesDetailsService.addNewTrainingDatesDetails(trainingDatesDetails);
	}

	@RequestMapping(value = "trainingdatesdetails/{trainingDatesId}", method = RequestMethod.DELETE)
	public boolean deleteTrainingDatesDetails(@PathVariable int trainingDatesId) {
		logger.info("" + trainingDatesId);
		return trainingDatesDetailsService.deleteVenderDetailsByTrainingDatesId(trainingDatesId);
	}

	@RequestMapping(value = "trainingdatesdetails", method = RequestMethod.PUT)
	public TrainingDatesDetails updateTrainingDatesDetails(@RequestBody TrainingDatesDetails trainingDatesDetails) {
		logger.info(trainingDatesDetails.toString());
		return trainingDatesDetailsService.updateTrainingDatesDetails(trainingDatesDetails);
	}

	@RequestMapping(value = "trainingdatesdetails/all", method = RequestMethod.GET)
	public List<TrainingDatesDetails> getAllTrainingDatesDetails() {
		logger.info("Retriving all trainingDates details");
		return trainingDatesDetailsService.getAllTrainingDatesDetails();
	}

	@RequestMapping(value = "trainingdatesdetails/{trainingDatesId}", method = RequestMethod.GET)
	public TrainingDatesDetails getSingleTrainingDatesDetails(@PathVariable int trainingDatesId) {
		logger.info("" + trainingDatesId);
		return trainingDatesDetailsService.getTrainingDatesDetailsByTrainingDatesId(trainingDatesId);
	}

	@RequestMapping(value = "trainingdatesdetails/bymonthstartdate", method = RequestMethod.POST)
	public List<TrainingDatesDetails> getAllTrainingDatesDetailsByMonthStartDate(
			@RequestBody MonthsDetails monthsDetails) {
		logger.info("Retriving all getAllTrainingDatesDetailsByMonthStartDate");
		logger.info(monthsDetails.toString());
		return trainingDatesDetailsService.getAllTrainingDatesDetailsByMonthStartDate(monthsDetails);
	}

	@RequestMapping(value = "trainingdatesdetails/bytrainingdetailsid/{trainingDetailsId}", method = RequestMethod.GET)
	public List<DaysDetails> getAllTrainingDatesDetailsByTrainingDetailsId(@PathVariable int trainingDetailsId) {
		logger.info("Retriving all getAllTrainingDatesDetailsByTrainingDetailsId");
		return trainingDatesDetailsService.getAllTrainingDatesDetailsByTrainingDetailsId(trainingDetailsId);
	}

}
