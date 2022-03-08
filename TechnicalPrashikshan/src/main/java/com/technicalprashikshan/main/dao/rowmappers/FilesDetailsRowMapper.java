package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.pojo.FilesDetails;

public class FilesDetailsRowMapper implements RowMapper<FilesDetails> {

	private static final Logger logger = LoggerFactory.getLogger(FilesDetailsRowMapper.class);

	@Override
	public FilesDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		logger.info("FilesDetailsRowMapper mapRow");

		FilesDetails filesDetails = new FilesDetails();
		filesDetails.setFileId(resultSet.getInt("file_id"));
		filesDetails.setFileContentType(resultSet.getString("file_content_type"));
		filesDetails.setFileName(resultSet.getString("file_name"));
		filesDetails.setFileContent(resultSet.getBytes("content_file"));
		
		return filesDetails;
	}
}
