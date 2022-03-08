package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.FilesDetails;

public interface FileDetailsDAOInterface {
	public int addNewFileDetails(FilesDetails filesDetails);

	public FilesDetails updateFileDetails(FilesDetails filesDetails);

	public FilesDetails getFileDetailsByFileId(int fileId);

	public List<FilesDetails> getAllFileDetails();

	public boolean deleteFileDetailsByFileId(int fileId);
}
