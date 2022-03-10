package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.PurchaseOrderDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.PurchaseOrderDetails;
import com.technicalprashikshan.main.service.interfaces.PurchaseOrderDetailsServiceInterface;

@Service
public class PurchaseOrderDetailsService implements PurchaseOrderDetailsServiceInterface {

	@Autowired
	private PurchaseOrderDetailsDAOInterface purchaseOrderDetailsDAO;

	@Override
	public String addNewPurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails) {
		return purchaseOrderDetailsDAO.addNewPurchaseOrderDetails(purchaseOrderDetails);
	}

	@Override
	public PurchaseOrderDetails updatePurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails) {
		return purchaseOrderDetailsDAO.updatePurchaseOrderDetails(purchaseOrderDetails);
	}

	@Override
	public PurchaseOrderDetails getPurchaseOrderDetailsByPurchaseOrderId(String purchaseOrderId) {
		return purchaseOrderDetailsDAO.getPurchaseOrderDetailsByPurchaseOrderId(purchaseOrderId);
	}

	@Override
	public List<PurchaseOrderDetails> getAllPurchaseOrderDetails() {
		return purchaseOrderDetailsDAO.getAllPurchaseOrderDetails();
	}

	@Override
	public boolean deletePurchaseOrderDetailsByPurchaseOrderId(String purchaseOrderId) {
		return purchaseOrderDetailsDAO.deletePurchaseOrderDetailsByPurchaseOrderId(purchaseOrderId);
	}

}
