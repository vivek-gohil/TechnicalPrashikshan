package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.FinancialYearDetails;

public interface FinancialYearDetailsServiceInterface {
	public int addNewFinancialYearDetails(FinancialYearDetails financialYearDetails);

	public FinancialYearDetails updateFinancialYearDetails(FinancialYearDetails financialYearDetails);

	public FinancialYearDetails getFinancialYearDetailsByFinancialYearId(int financialYearId);

	public List<FinancialYearDetails> getAllFinancialYearDetails();

	public boolean deleteFinancialYearDetailsByFinancialYearId(int financialYearId);
}
