package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.BankingDetails;
import com.technicalprashikshan.main.pojo.InvoiceDetails;

public interface InvoiceDetailsDAOInterface {
	public String addNewInvoiceDetails(InvoiceDetails invoiceDetails);

	public InvoiceDetails updateInvoiceDetails(InvoiceDetails invoiceDetails);

	public InvoiceDetails getInvoiceDetailsByInvoiceId(String invoiceId);

	public List<InvoiceDetails> getAllInvoiceDetails();

	public boolean deleteInvoiceDetailsByInvoiceId(String invoiceId);
}
