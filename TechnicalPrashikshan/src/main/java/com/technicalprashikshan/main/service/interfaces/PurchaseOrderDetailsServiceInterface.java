package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.PurchaseOrderDetails;

public interface PurchaseOrderDetailsServiceInterface {
	public String addNewPurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails);

	public PurchaseOrderDetails updatePurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails);

	public PurchaseOrderDetails getPurchaseOrderDetailsByPurchaseOrderId(String purchaseOrderId);

	public List<PurchaseOrderDetails> getAllPurchaseOrderDetails();

	public boolean deletePurchaseOrderDetailsByPurchaseOrderId(String purchaseOrderId);
}
