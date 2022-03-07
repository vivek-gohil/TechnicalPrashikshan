package com.technicalprashikshan.main.pojo;

import java.util.Arrays;

public class FilesDetails {
	private int fileId;
	private String fileContentType;
	private String fileName;
	private byte[] fileContent;

	public FilesDetails() {
		// TODO Auto-generated constructor stub
	}

	public FilesDetails(int fileId, String fileContentType, String fileName, byte[] fileContent) {
		super();
		this.fileId = fileId;
		this.fileContentType = fileContentType;
		this.fileName = fileName;
		this.fileContent = fileContent;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	@Override
	public String toString() {
		return "FilesDetails [fileId=" + fileId + ", fileContentType=" + fileContentType + ", fileName=" + fileName
				+ ", fileContent=" + Arrays.toString(fileContent) + "]";
	}

}
