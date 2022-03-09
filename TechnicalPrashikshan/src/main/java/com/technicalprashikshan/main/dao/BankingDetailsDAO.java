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

import com.technicalprashikshan.main.dao.interfaces.BankingDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.BankingDetailsRowMapper;
import com.technicalprashikshan.main.pojo.BankingDetails;

@Repository
public class BankingDetailsDAO implements BankingDetailsDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(BankingDetailsDAO.class);

	private static final String insertNewBankingDetails = "insert into banking_master(account_number,account_holders_name,ifsc_code,bank_name,branch_address,pan_card_number,pan_card_file_id,aadhar_number,aadhar_file_id,banking_details_status) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String updateBankingDetails = "update banking_master set account_number = ? , account_holders_name = ? , ifsc_code = ? , bank_name = ? , branch_address = ? , pan_card_number = ? , pan_card_file_id = ? ,aadhar_number = ? ,aadhar_file_id = ? ,banking_details_status = ?  where banking_id = ?";
	private static final String deleteBankingDetails = "delete from banking_master where banking_id = ?";
	private static final String selectBankingDetailsByBankingId = "select * from banking_master where banking_id = ?";
	private static final String selectAllBankingDetails = "select * from banking_master";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public BankingDetailsDAO() {
		// TODO Auto-generated constructor stub
	}

	public BankingDetailsDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addNewBankingDetails(BankingDetails bankingDetails) {

		logger.info(bankingDetails.toString());

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection.prepareStatement(insertNewBankingDetails,
					new String[] { "banking_id" });
			preparedStatement.setString(1, bankingDetails.getAccountNumber());
			preparedStatement.setString(2, bankingDetails.getAccountHoldersName());
			preparedStatement.setString(3, bankingDetails.getIfscCode());
			preparedStatement.setString(4, bankingDetails.getBankName());
			preparedStatement.setString(5, bankingDetails.getBranchAddress());
			preparedStatement.setString(6, bankingDetails.getPanCardNumber());
			preparedStatement.setInt(7, bankingDetails.getPanCardFile().getFileId());
			preparedStatement.setString(8, bankingDetails.getAadharNumber());
			preparedStatement.setInt(9, bankingDetails.getAadharFile().getFileId());
			preparedStatement.setString(10, bankingDetails.getBankingDetailsStatus());
			return preparedStatement;
		}, keyHolder);

		int bankingId = keyHolder.getKey().intValue();
		logger.info("Generated BankingId :: " + bankingId);
		return bankingId;
	}

	@Override
	public BankingDetails updateBankingDetails(BankingDetails bankingDetails) {
		logger.info(bankingDetails.toString());
		Object[] args = { bankingDetails.getAccountNumber(), bankingDetails.getAccountHoldersName(),
				bankingDetails.getIfscCode(), bankingDetails.getBankName(), bankingDetails.getBranchAddress(),
				bankingDetails.getPanCardNumber(), bankingDetails.getPanCardFile().getFileId(),
				bankingDetails.getAadharNumber(), bankingDetails.getAadharFile().getFileId(),
				bankingDetails.getBankingDetailsStatus(), bankingDetails.getBankingDetailsId() };
		count = jdbcTemplate.update(updateBankingDetails, args);
		if (count > 0) {
			logger.info("Banking Details Updated Successfully");
			return bankingDetails;
		} else {
			logger.info("Failed To Update Banking Details");
			return null;
		}
	}

	@Override
	public BankingDetails getBankingDetailsByBankingId(int bankingId) {
		BankingDetails bankingDetails = null;
		try {
			Object[] args = { bankingId };
			bankingDetails = jdbcTemplate.queryForObject(selectBankingDetailsByBankingId,
					new BankingDetailsRowMapper(jdbcTemplate), args);
			if (bankingDetails != null)
				return bankingDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return new BankingDetails();
	}

	@Override
	public List<BankingDetails> getAllBankingDetails() {
		List<BankingDetails> bankingDetailsList = jdbcTemplate.query(selectAllBankingDetails,
				new BankingDetailsRowMapper(jdbcTemplate));
		return bankingDetailsList;
	}

	@Override
	public boolean deleteBankingDetailsByBankingId(int bankingId) {
		logger.info("" + bankingId);
		Object[] args = { bankingId };
		count = jdbcTemplate.update(deleteBankingDetails, args);
		if (count > 0) {
			logger.info("Banking Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete Banking Details");
			return false;
		}
	}

}
