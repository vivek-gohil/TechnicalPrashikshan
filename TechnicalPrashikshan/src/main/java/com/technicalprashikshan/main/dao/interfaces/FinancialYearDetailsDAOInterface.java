package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.FinancialYearDetails;

public interface FinancialYearDetailsDAOInterface {
	public int addNewFinancialYearDetails(FinancialYearDetails financialYearDetails);

	public FinancialYearDetails updateFinancialYearDetails(FinancialYearDetails financialYearDetails);

	public FinancialYearDetails getFinancialYearDetailsByFinancialYearId(int financialYearId);

	public List<FinancialYearDetails> getAllFinancialYearDetails();

	public boolean deleteFinancialYearDetailsByFinancialYearId(int financialYearId);
}
