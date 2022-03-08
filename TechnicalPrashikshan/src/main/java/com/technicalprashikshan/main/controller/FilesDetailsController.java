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

import com.technicalprashikshan.main.pojo.FilesDetails;
import com.technicalprashikshan.main.service.interfaces.FilesDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/filesdetailapi")
public class FilesDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(FilesDetailsController.class);

	@Autowired
	private FilesDetailsServiceInterface filesDetailsService;

	public FilesDetailsController() {
		logger.info("FilesDetailsController object created");
	}

	@RequestMapping(value = "filesdetails", method = RequestMethod.POST)
	public int newFilesDetails(@RequestBody FilesDetails filesDetails) {
		logger.info(filesDetails.toString());
		return filesDetailsService.addNewFileDetails(filesDetails);
	}

	@RequestMapping(value = "filesdetails/{fileId}", method = RequestMethod.DELETE)
	public boolean deleteFilesDetails(@PathVariable int fileId) {
		logger.info("" + fileId);
		return filesDetailsService.deleteFileDetailsByFileId(fileId);
	}

	@RequestMapping(value = "filesdetails", method = RequestMethod.PUT)
	public FilesDetails updateFilesDetails(@RequestBody FilesDetails filesDetails) {
		logger.info(filesDetails.toString());
		return filesDetailsService.updateFileDetails(filesDetails);
	}

	@RequestMapping(value = "filesdetails/all", method = RequestMethod.GET)
	public List<FilesDetails> getAllFilesDetails() {
		logger.info("Retriving all client details");
		return filesDetailsService.getAllFileDetails();
	}

	@RequestMapping(value = "filesdetails/{clientId}", method = RequestMethod.GET)
	public FilesDetails getSingleFilesDetails(@PathVariable int fileId) {
		logger.info("" + fileId);
		return filesDetailsService.getFileDetailsByFileId(fileId);
	}

}
