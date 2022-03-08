package com.technicalprashikshan.main.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public int newFilesDetails(@RequestParam("file") MultipartFile file) {
		try {
			FilesDetails filesDetails = new FilesDetails();
			filesDetails.setFileContentType(file.getContentType());
			filesDetails.setFileName(file.getOriginalFilename());
			filesDetails.setFileContent(file.getBytes());
			logger.info(filesDetails.toString());
			return filesDetailsService.addNewFileDetails(filesDetails);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@RequestMapping(value = "filesdetails/{fileId}", method = RequestMethod.DELETE)
	public boolean deleteFilesDetails(@PathVariable int fileId) {
		logger.info("" + fileId);
		return filesDetailsService.deleteFileDetailsByFileId(fileId);
	}

	@RequestMapping(value = "filesdetails", method = RequestMethod.PUT)
	public FilesDetails updateFilesDetails(@RequestParam("file") MultipartFile file, @RequestParam("fileId") int fileId) {
		FilesDetails filesDetails = new FilesDetails();
		try {
			filesDetails.setFileId(fileId);
			filesDetails.setFileContentType(file.getContentType());
			filesDetails.setFileName(file.getOriginalFilename());
			filesDetails.setFileContent(file.getBytes());
			logger.info(filesDetails.toString());
			filesDetailsService.updateFileDetails(filesDetails);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filesDetails;

	}

	@RequestMapping(value = "filesdetails/all", method = RequestMethod.GET)
	public List<FilesDetails> getAllFilesDetails() {
		logger.info("Retriving all client details");
		return filesDetailsService.getAllFileDetails();
	}

	@RequestMapping(value = "filesdetails/{fileId}", method = RequestMethod.GET)
	public ResponseEntity<Resource> getSingleFilesDetails(@PathVariable int fileId) {
		logger.info("" + fileId);
		FilesDetails filesDetails = filesDetailsService.getFileDetailsByFileId(fileId);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(filesDetails.getFileContentType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filesDetails.getFileName())
				.body(new ByteArrayResource(filesDetails.getFileContent()));
	}

}
