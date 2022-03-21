package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.MonthsDetails;

public interface MonthsDetailsServiceInterface {
	public int addNewMonthsDetails(MonthsDetails monthsDetails);

	public MonthsDetails updateMonthsDetails(MonthsDetails monthsDetails);

	public MonthsDetails getMonthsDetailsByMonthsId(int monthsId);

	public List<MonthsDetails> getAllMonthsDetails();

	public boolean deleteMonthsDetailsByMonthsId(int monthsId);
}
