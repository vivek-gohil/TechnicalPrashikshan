package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.FilesDetails;

public interface FilesDetailsServiceInterface {
	public int addNewFileDetails(FilesDetails filesDetails);

	public FilesDetails updateFileDetails(FilesDetails filesDetails);

	public FilesDetails getFileDetailsByFileId(int fileId);

	public List<FilesDetails> getAllFileDetails();

	public boolean deleteFileDetailsByFileId(int fileId);
}
