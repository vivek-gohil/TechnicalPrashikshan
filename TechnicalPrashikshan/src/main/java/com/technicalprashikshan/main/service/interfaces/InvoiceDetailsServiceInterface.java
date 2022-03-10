package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.InvoiceDetails;

public interface InvoiceDetailsServiceInterface {
	public String addNewInvoiceDetails(InvoiceDetails invoiceDetails);

	public InvoiceDetails updateInvoiceDetails(InvoiceDetails invoiceDetails);

	public InvoiceDetails getInvoiceDetailsByInvoiceId(String invoiceId);

	public List<InvoiceDetails> getAllInvoiceDetails();

	public boolean deleteInvoiceDetailsByInvoiceId(String invoiceId);
}
