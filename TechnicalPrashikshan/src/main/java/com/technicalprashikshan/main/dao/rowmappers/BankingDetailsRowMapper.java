package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.dao.FilesDetailsDAO;
import com.technicalprashikshan.main.pojo.BankingDetails;
import com.technicalprashikshan.main.pojo.FilesDetails;

public class BankingDetailsRowMapper implements RowMapper<BankingDetails> {

	private JdbcTemplate jdbcTemplate;

	public BankingDetailsRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public BankingDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		BankingDetails bankingDetails = new BankingDetails();
		bankingDetails.setBankingDetailsId(resultSet.getInt("banking_id"));
		bankingDetails.setAccountNumber(resultSet.getString("account_number"));
		bankingDetails.setAccountHoldersName(resultSet.getString("account_holders_name"));
		bankingDetails.setIfscCode(resultSet.getString("ifsc_code"));
		bankingDetails.setBankName(resultSet.getString("bank_name"));
		bankingDetails.setBranchAddress(resultSet.getString("branch_address"));
		bankingDetails.setPanCardNumber(resultSet.getString("pan_card_number"));

		FilesDetailsDAO filesDetailsDAO = new FilesDetailsDAO(jdbcTemplate);
		FilesDetails panCardFileDetails = filesDetailsDAO.getFileDetailsByFileId(resultSet.getInt("pan_card_file_id"));
		bankingDetails.setPanCardFile(panCardFileDetails);

		bankingDetails.setAadharNumber(resultSet.getString("aadhar_number"));
		FilesDetails aadharFileDetails = filesDetailsDAO.getFileDetailsByFileId(resultSet.getInt("aadhar_file_id"));
		bankingDetails.setAadharFile(aadharFileDetails);

		bankingDetails.setBankingDetailsStatus(resultSet.getString("banking_details_status"));
		return bankingDetails;
	}
}
