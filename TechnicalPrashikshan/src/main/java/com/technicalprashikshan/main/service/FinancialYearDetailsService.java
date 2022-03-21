package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.FinancialYearDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.FinancialYearDetails;
import com.technicalprashikshan.main.service.interfaces.FinancialYearDetailsServiceInterface;

@Service
public class FinancialYearDetailsService implements FinancialYearDetailsServiceInterface {

	@Autowired
	private FinancialYearDetailsDAOInterface financialYearDetailsDAO;

	@Override
	public int addNewFinancialYearDetails(FinancialYearDetails financialYearDetails) {
		return financialYearDetailsDAO.addNewFinancialYearDetails(financialYearDetails);
	}

	@Override
	public FinancialYearDetails updateFinancialYearDetails(FinancialYearDetails financialYearDetails) {
		return financialYearDetailsDAO.updateFinancialYearDetails(financialYearDetails);
	}

	@Override
	public FinancialYearDetails getFinancialYearDetailsByFinancialYearId(int financialYearId) {
		return financialYearDetailsDAO.getFinancialYearDetailsByFinancialYearId(financialYearId);
	}

	@Override
	public List<FinancialYearDetails> getAllFinancialYearDetails() {
		return financialYearDetailsDAO.getAllFinancialYearDetails();
	}

	@Override
	public boolean deleteFinancialYearDetailsByFinancialYearId(int financialYearId) {
		return financialYearDetailsDAO.deleteFinancialYearDetailsByFinancialYearId(financialYearId);
	}

}
