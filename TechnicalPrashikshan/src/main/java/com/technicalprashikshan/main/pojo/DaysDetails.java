package com.technicalprashikshan.main.pojo;

import java.time.LocalDate;

public class DaysDetails {
	private int daysId;
	private LocalDate date;
	private MonthsDetails monthsDetails;

	public DaysDetails() {
		// TODO Auto-generated constructor stub
	}

	public DaysDetails(int daysId, LocalDate date, MonthsDetails monthsDetails) {
		super();
		this.daysId = daysId;
		this.date = date;
		this.monthsDetails = monthsDetails;
	}

	public int getDaysId() {
		return daysId;
	}

	public void setDaysId(int daysId) {
		this.daysId = daysId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public MonthsDetails getMonthsDetails() {
		return monthsDetails;
	}

	public void setMonthsDetails(MonthsDetails monthsDetails) {
		this.monthsDetails = monthsDetails;
	}

	@Override
	public String toString() {
		return "DaysDetails [daysId=" + daysId + ", date=" + date + ", monthsDetails=" + monthsDetails + "]";
	}

}
