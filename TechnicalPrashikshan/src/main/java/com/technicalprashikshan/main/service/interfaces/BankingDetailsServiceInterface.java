package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.BankingDetails;

public interface BankingDetailsServiceInterface {
	public int addNewBankingDetails(BankingDetails bankingDetails);

	public BankingDetails updateBankingDetails(BankingDetails bankingDetails);

	public BankingDetails getBankingDetailsByBankingId(int bankingId);

	public List<BankingDetails> getAllBankingDetails();

	public boolean deleteBankingDetailsByBankingId(int bankingId);
}
