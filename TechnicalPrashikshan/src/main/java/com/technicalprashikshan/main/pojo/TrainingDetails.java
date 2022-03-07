package com.technicalprashikshan.main.pojo;

public class TrainingDetails {
	private int trainingDetailsId;
	private String topic;
	private int totalNumberOfDays;
	private double perDayRate;
	private String sessionType;
	private String remarks;
	private String trainingStatus;
	private VendorDetails vendorDetails;
	private ClientDetails clientDetails;
	private PurchaseOrderDetails purchaseOrderDetails;
	private InvoiceDetails invoiceDetails;

	public TrainingDetails() {
		// TODO Auto-generated constructor stub
	}

	public TrainingDetails(int trainingDetailsId, String topic, int totalNumberOfDays, double perDayRate,
			String sessionType, String remarks, String trainingStatus, VendorDetails vendorDetails,
			ClientDetails clientDetails, PurchaseOrderDetails purchaseOrderDetails, InvoiceDetails invoiceDetails) {
		super();
		this.trainingDetailsId = trainingDetailsId;
		this.topic = topic;
		this.totalNumberOfDays = totalNumberOfDays;
		this.perDayRate = perDayRate;
		this.sessionType = sessionType;
		this.remarks = remarks;
		this.trainingStatus = trainingStatus;
		this.vendorDetails = vendorDetails;
		this.clientDetails = clientDetails;
		this.purchaseOrderDetails = purchaseOrderDetails;
		this.invoiceDetails = invoiceDetails;
	}

	public int getTrainingDetailsId() {
		return trainingDetailsId;
	}

	public void setTrainingDetailsId(int trainingDetailsId) {
		this.trainingDetailsId = trainingDetailsId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getTotalNumberOfDays() {
		return totalNumberOfDays;
	}

	public void setTotalNumberOfDays(int totalNumberOfDays) {
		this.totalNumberOfDays = totalNumberOfDays;
	}

	public double getPerDayRate() {
		return perDayRate;
	}

	public void setPerDayRate(double perDayRate) {
		this.perDayRate = perDayRate;
	}

	public String getSessionType() {
		return sessionType;
	}

	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTrainingStatus() {
		return trainingStatus;
	}

	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	public VendorDetails getVendorDetails() {
		return vendorDetails;
	}

	public void setVendorDetails(VendorDetails vendorDetails) {
		this.vendorDetails = vendorDetails;
	}

	public ClientDetails getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}

	public PurchaseOrderDetails getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	public InvoiceDetails getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(InvoiceDetails invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	@Override
	public String toString() {
		return "TrainingDetails [trainingDetailsId=" + trainingDetailsId + ", topic=" + topic + ", totalNumberOfDays="
				+ totalNumberOfDays + ", perDayRate=" + perDayRate + ", sessionType=" + sessionType + ", remarks="
				+ remarks + ", trainingStatus=" + trainingStatus + ", vendorDetails=" + vendorDetails
				+ ", clientDetails=" + clientDetails + ", purchaseOrderDetails=" + purchaseOrderDetails
				+ ", invoiceDetails=" + invoiceDetails + "]";
	}

}
