package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.InvoiceDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.InvoiceDetails;
import com.technicalprashikshan.main.service.interfaces.InvoiceDetailsServiceInterface;

@Service
public class InvoiceDetailsService implements InvoiceDetailsServiceInterface {

	@Autowired
	private InvoiceDetailsDAOInterface invoiceDetailsDAO;

	@Override
	public String addNewInvoiceDetails(InvoiceDetails invoiceDetails) {
		return invoiceDetailsDAO.addNewInvoiceDetails(invoiceDetails);
	}

	@Override
	public InvoiceDetails updateInvoiceDetails(InvoiceDetails invoiceDetails) {
		return invoiceDetailsDAO.updateInvoiceDetails(invoiceDetails);
	}

	@Override
	public InvoiceDetails getInvoiceDetailsByInvoiceId(String invoiceId) {
		return invoiceDetailsDAO.getInvoiceDetailsByInvoiceId(invoiceId);
	}

	@Override
	public List<InvoiceDetails> getAllInvoiceDetails() {
		return invoiceDetailsDAO.getAllInvoiceDetails();
	}

	@Override
	public boolean deleteInvoiceDetailsByInvoiceId(String invoiceId) {
		return invoiceDetailsDAO.deleteInvoiceDetailsByInvoiceId(invoiceId);
	}

}
