package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.BankingDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.BankingDetails;
import com.technicalprashikshan.main.service.interfaces.BankingDetailsServiceInterface;

@Service
public class BankingDetailsService implements BankingDetailsServiceInterface {

	@Autowired
	private BankingDetailsDAOInterface bankingDetailsDAO;

	@Override
	public int addNewBankingDetails(BankingDetails bankingDetails) {
		return bankingDetailsDAO.addNewBankingDetails(bankingDetails);
	}

	@Override
	public BankingDetails updateBankingDetails(BankingDetails bankingDetails) {
		return bankingDetailsDAO.updateBankingDetails(bankingDetails);
	}

	@Override
	public BankingDetails getBankingDetailsByBankingId(int bankingId) {
		return bankingDetailsDAO.getBankingDetailsByBankingId(bankingId);
	}

	@Override
	public List<BankingDetails> getAllBankingDetails() {
		return bankingDetailsDAO.getAllBankingDetails();
	}

	@Override
	public boolean deleteBankingDetailsByBankingId(int bankingId) {
		return bankingDetailsDAO.deleteBankingDetailsByBankingId(bankingId);
	}

}
