package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.PurchaseOrderDetails;

public interface PurchaseOrderDetailsDAOInterface {
	public String addNewPurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails);

	public PurchaseOrderDetails updatePurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails);

	public PurchaseOrderDetails getPurchaseOrderDetailsByPurchaseOrderId(String purchaseOrderId);

	public List<PurchaseOrderDetails> getAllPurchaseOrderDetails();

	public boolean deletePurchaseOrderDetailsByPurchaseOrderId(String purchaseOrderId);
}
