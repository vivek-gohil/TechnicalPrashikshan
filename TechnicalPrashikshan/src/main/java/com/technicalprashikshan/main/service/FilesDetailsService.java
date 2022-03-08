package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.FileDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.FilesDetails;
import com.technicalprashikshan.main.service.interfaces.FilesDetailsServiceInterface;

@Service
public class FilesDetailsService implements FilesDetailsServiceInterface {

	@Autowired
	private FileDetailsDAOInterface fileDetailsDAO;

	@Override
	public int addNewFileDetails(FilesDetails filesDetails) {
		return fileDetailsDAO.addNewFileDetails(filesDetails);
	}

	@Override
	public FilesDetails updateFileDetails(FilesDetails filesDetails) {
		return fileDetailsDAO.updateFileDetails(filesDetails);
	}

	@Override
	public FilesDetails getFileDetailsByFileId(int fileId) {
		return fileDetailsDAO.getFileDetailsByFileId(fileId);
	}

	@Override
	public List<FilesDetails> getAllFileDetails() {
		return fileDetailsDAO.getAllFileDetails();

	}

	@Override
	public boolean deleteFileDetailsByFileId(int fileId) {
		return fileDetailsDAO.deleteFileDetailsByFileId(fileId);
	}

}
