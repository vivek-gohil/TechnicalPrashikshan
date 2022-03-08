package com.technicalprashikshan.main.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.technicalprashikshan.main.dao.interfaces.FileDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.FilesDetailsRowMapper;
import com.technicalprashikshan.main.pojo.FilesDetails;

@Repository
public class FileDetailsDAO implements FileDetailsDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(FileDetailsDAO.class);

	private static final String insertNewFileDetails = "insert into files_master(file_content_type,file_name,content_file) values(?,?,?)";
	private static final String updateFileDetails = "update files_master set file_content_type = ? ,file_name = ? ,content_file = ? where files_id = ?";
	private static final String deleteFileDetails = "delete from files_master where files_id = ?";
	private static final String selectFileByFileId = "select * from files_master where files_id = ?";
	private static final String selectAllFileDetails = "select * from files_master order by file_name";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addNewFileDetails(FilesDetails filesDetails) {
		logger.info("in addNewFileDetails");

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection.prepareStatement(insertNewFileDetails,
					new String[] { "files_id" });
			preparedStatement.setString(1, filesDetails.getFileContentType());
			preparedStatement.setString(2, filesDetails.getFileName());
			preparedStatement.setBytes(3, filesDetails.getFileContent());

			return preparedStatement;
		}, keyHolder);

		int fileId = keyHolder.getKey().intValue();
		logger.info("Generated FileId :: " + fileId);
		return fileId;
	}

	@Override
	public FilesDetails updateFileDetails(FilesDetails filesDetails) {

		logger.info(filesDetails.toString());
		Object[] args = { filesDetails.getFileContentType(), filesDetails.getFileName(), filesDetails.getFileContent(),
				filesDetails.getFileId() };
		count = jdbcTemplate.update(updateFileDetails, args);
		if (count > 0) {
			logger.info("File Details Updated Successfully");
			return filesDetails;
		} else {
			logger.info("Failed To Update File Details");
			return null;
		}
	}

	@Override
	public FilesDetails getFileDetailsByFileId(int fileId) {
		FilesDetails filesDetails = null;
		try {
			Object[] args = { fileId };
			filesDetails = jdbcTemplate.queryForObject(selectFileByFileId, new FilesDetailsRowMapper(), args);
			if (filesDetails != null)
				return filesDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<FilesDetails> getAllFileDetails() {
		List<FilesDetails> fileDetailsList = jdbcTemplate.query(selectAllFileDetails, new FilesDetailsRowMapper());
		return fileDetailsList;
	}

	@Override
	public boolean deleteFileDetailsByFileId(int fileId) {
		logger.info("" + fileId);
		Object[] args = { fileId };
		count = jdbcTemplate.update(deleteFileDetails, args);
		if (count > 0) {
			logger.info("File Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete File Details");
			return false;
		}
	}

}
