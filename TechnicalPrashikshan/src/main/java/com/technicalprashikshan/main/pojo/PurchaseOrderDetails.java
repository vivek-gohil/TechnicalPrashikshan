package com.technicalprashikshan.main.pojo;

import java.time.LocalDate;

public class PurchaseOrderDetails {
	private int purchseOrderId;
	private double amount;
	private LocalDate receivedDate;
	private FilesDetails purchaseOrderFile;
	private VendorDetails vendorDetails;
	private ClientDetails clientDetails;

	public PurchaseOrderDetails() {
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrderDetails(int purchseOrderId, double amount, LocalDate receivedDate,
			FilesDetails purchaseOrderFile, VendorDetails vendorDetails, ClientDetails clientDetails) {
		super();
		this.purchseOrderId = purchseOrderId;
		this.amount = amount;
		this.receivedDate = receivedDate;
		this.purchaseOrderFile = purchaseOrderFile;
		this.vendorDetails = vendorDetails;
		this.clientDetails = clientDetails;
	}

	public int getPurchseOrderId() {
		return purchseOrderId;
	}

	public void setPurchseOrderId(int purchseOrderId) {
		this.purchseOrderId = purchseOrderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}

	public FilesDetails getPurchaseOrderFile() {
		return purchaseOrderFile;
	}

	public void setPurchaseOrderFile(FilesDetails purchaseOrderFile) {
		this.purchaseOrderFile = purchaseOrderFile;
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

	@Override
	public String toString() {
		return "PurchaseOrderDetails [purchseOrderId=" + purchseOrderId + ", amount=" + amount + ", receivedDate="
				+ receivedDate + ", purchaseOrderFile=" + purchaseOrderFile + ", vendorDetails=" + vendorDetails
				+ ", clientDetails=" + clientDetails + "]";
	}

}