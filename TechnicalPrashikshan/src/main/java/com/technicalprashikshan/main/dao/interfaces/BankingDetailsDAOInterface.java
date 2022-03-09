package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.BankingDetails;

public interface BankingDetailsDAOInterface {
	public int addNewBankingDetails(BankingDetails bankingDetails);

	public BankingDetails updateBankingDetails(BankingDetails bankingDetails);

	public BankingDetails getBankingDetailsByBankingId(int bankingId);

	public List<BankingDetails> getAllBankingDetails();

	public boolean deleteBankingDetailsByBankingId(int bankingId);
}
