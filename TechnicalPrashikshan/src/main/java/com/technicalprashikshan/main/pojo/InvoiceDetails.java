package com.technicalprashikshan.main.pojo;

import java.time.LocalDate;

public class InvoiceDetails {
	private String invoiceId;
	private LocalDate raisedDate;
	private LocalDate clearingDate;
	private double amount;
	private String amountInWords;
	private FilesDetails invoiceFile;
	private String invoiceStatus;
	private double clearedAmount;
	private double taxDeductedAmount;
	private TrainerDetails trainerDetails;

	public InvoiceDetails() {
		// TODO Auto-generated constructor stub
	}

	public InvoiceDetails(String invoiceId, LocalDate raisedDate, LocalDate clearingDate, double amount,
			String amountInWords, FilesDetails invoiceFile, String invoiceStatus, double clearedAmount,
			double taxDeductedAmount, TrainerDetails trainerDetails) {
		super();
		this.invoiceId = invoiceId;
		this.raisedDate = raisedDate;
		this.clearingDate = clearingDate;
		this.amount = amount;
		this.amountInWords = amountInWords;
		this.invoiceFile = invoiceFile;
		this.invoiceStatus = invoiceStatus;
		this.clearedAmount = clearedAmount;
		this.taxDeductedAmount = taxDeductedAmount;
		this.trainerDetails = trainerDetails;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public LocalDate getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(LocalDate raisedDate) {
		this.raisedDate = raisedDate;
	}

	public LocalDate getClearingDate() {
		return clearingDate;
	}

	public void setClearingDate(LocalDate clearingDate) {
		this.clearingDate = clearingDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAmountInWords() {
		return amountInWords;
	}

	public void setAmountInWords(String amountInWords) {
		this.amountInWords = amountInWords;
	}

	public FilesDetails getInvoiceFile() {
		return invoiceFile;
	}

	public void setInvoiceFile(FilesDetails invoiceFile) {
		this.invoiceFile = invoiceFile;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public double getClearedAmount() {
		return clearedAmount;
	}

	public void setClearedAmount(double clearedAmount) {
		this.clearedAmount = clearedAmount;
	}

	public double getTaxDeductedAmount() {
		return taxDeductedAmount;
	}

	public void setTaxDeductedAmount(double taxDeductedAmount) {
		this.taxDeductedAmount = taxDeductedAmount;
	}

	public TrainerDetails getTrainerDetails() {
		return trainerDetails;
	}

	public void setTrainerDetails(TrainerDetails trainerDetails) {
		this.trainerDetails = trainerDetails;
	}

	@Override
	public String toString() {
		return "InvoiceDetails [invoiceId=" + invoiceId + ", raisedDate=" + raisedDate + ", clearingDate="
				+ clearingDate + ", amount=" + amount + ", amountInWords=" + amountInWords + ", invoiceFile="
				+ invoiceFile + ", invoiceStatus=" + invoiceStatus + ", clearedAmount=" + clearedAmount
				+ ", taxDeductedAmount=" + taxDeductedAmount + ", trainerDetails=" + trainerDetails + "]";
	}

}
