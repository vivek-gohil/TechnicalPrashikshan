package com.technicalprashikshan.main.pojo;

public class BankingDetails {
	private int bankingDetailsId;
	private String accountNumber;
	private String accountHoldersName;
	private String ifscCode;
	private String bankName;
	private String branchAddress;
	private String panCardNumber;
	private FilesDetails panCardFile;
	private String aadharNumber;
	private FilesDetails aadharFile;
	private String bankingDetailsStatus;

	public BankingDetails() {
		// TODO Auto-generated constructor stub
	}

	public BankingDetails(int bankingDetailsId, String accountNumber, String accountHoldersName, String ifscCode,
			String bankName, String branchAddress, String panCardNumber, FilesDetails panCardFile, String aadharNumber,
			FilesDetails aadharFile, String bankingDetailsStatus) {
		super();
		this.bankingDetailsId = bankingDetailsId;
		this.accountNumber = accountNumber;
		this.accountHoldersName = accountHoldersName;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.branchAddress = branchAddress;
		this.panCardNumber = panCardNumber;
		this.panCardFile = panCardFile;
		this.aadharNumber = aadharNumber;
		this.aadharFile = aadharFile;
		this.bankingDetailsStatus = bankingDetailsStatus;
	}

	public int getBankingDetailsId() {
		return bankingDetailsId;
	}

	public void setBankingDetailsId(int bankingDetailsId) {
		this.bankingDetailsId = bankingDetailsId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHoldersName() {
		return accountHoldersName;
	}

	public void setAccountHoldersName(String accountHoldersName) {
		this.accountHoldersName = accountHoldersName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public FilesDetails getPanCardFile() {
		return panCardFile;
	}

	public void setPanCardFile(FilesDetails panCardFile) {
		this.panCardFile = panCardFile;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public FilesDetails getAadharFile() {
		return aadharFile;
	}

	public void setAadharFile(FilesDetails aadharFile) {
		this.aadharFile = aadharFile;
	}

	public String getBankingDetailsStatus() {
		return bankingDetailsStatus;
	}

	public void setBankingDetailsStatus(String bankingDetailsStatus) {
		this.bankingDetailsStatus = bankingDetailsStatus;
	}

	@Override
	public String toString() {
		return "BankingDetails [bankingDetailsId=" + bankingDetailsId + ", accountNumber=" + accountNumber
				+ ", accountHoldersName=" + accountHoldersName + ", ifscCode=" + ifscCode + ", bankName=" + bankName
				+ ", branchAddress=" + branchAddress + ", panCardNumber=" + panCardNumber + ", panCardFile="
				+ panCardFile + ", aadharNumber=" + aadharNumber + ", aadharFile=" + aadharFile
				+ ", bankingDetailsStatus=" + bankingDetailsStatus + "]";
	}

}
