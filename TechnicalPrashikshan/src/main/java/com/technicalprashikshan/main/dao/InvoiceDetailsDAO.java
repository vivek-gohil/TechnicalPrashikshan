package com.technicalprashikshan.main.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.technicalprashikshan.main.dao.interfaces.InvoiceDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.InvoiceDetailsRowMapper;
import com.technicalprashikshan.main.pojo.InvoiceDetails;

@Repository
public class InvoiceDetailsDAO implements InvoiceDetailsDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceDetailsDAO.class);

	private static final String insertNewInvoiceDetails = "insert into invoice_details(invoice_id,raised_date,clearing_date,invoice_amount,invoice_amount_in_words,invoice_file_id,invoice_status,invoice_cleared_amount,tax_deducted_amount,trainer_id) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String updateInvoiceDetails = "update invoice_details set raised_date = ? ,clearing_date = ? ,invoice_amount = ? ,invoice_amount_in_words = ? ,invoice_file_id = ? ,invoice_status = ? ,invoice_cleared_amount = ? ,tax_deducted_amount = ? ,trainer_id = ? where invoice_id = ? ";
	private static final String deleteInvoiceDetails = "delete from invoice_details where invoice_id = ?";
	private static final String selectInvoiceByInvoiceId = "select * from invoice_details where invoice_id = ?";
	private static final String selectAllInvoiceDetails = "select * from invoice_details";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public InvoiceDetailsDAO() {
	}

	public InvoiceDetailsDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String addNewInvoiceDetails(InvoiceDetails invoiceDetails) {
		logger.info(invoiceDetails.toString());
		Object[] args = { invoiceDetails.getInvoiceId(), invoiceDetails.getRaisedDate(),
				invoiceDetails.getClearingDate(), invoiceDetails.getAmount(), invoiceDetails.getAmountInWords(),
				invoiceDetails.getInvoiceFile().getFileId(), invoiceDetails.getInvoiceStatus(),
				invoiceDetails.getClearedAmount(), invoiceDetails.getTaxDeductedAmount(),
				invoiceDetails.getTrainerDetails().getTrainerId() };
		count = jdbcTemplate.update(insertNewInvoiceDetails, args);
		if (count > 0) {
			logger.info("Invoice Details Inserted Successfully");
			return invoiceDetails.getInvoiceId();
		} else {
			logger.info("Failed To Insert Invoice Details");
			return invoiceDetails.getInvoiceId();
		}
	}

	@Override
	public InvoiceDetails updateInvoiceDetails(InvoiceDetails invoiceDetails) {
		logger.info(invoiceDetails.toString());
		Object[] args = { invoiceDetails.getRaisedDate(), invoiceDetails.getClearingDate(), invoiceDetails.getAmount(),
				invoiceDetails.getAmountInWords(), invoiceDetails.getInvoiceFile().getFileId(),
				invoiceDetails.getInvoiceStatus(), invoiceDetails.getClearedAmount(),
				invoiceDetails.getTaxDeductedAmount(), invoiceDetails.getTrainerDetails().getTrainerId(),
				invoiceDetails.getInvoiceId() };
		count = jdbcTemplate.update(updateInvoiceDetails, args);
		if (count > 0) {
			logger.info("Invoice Details Inserted Successfully");
			return invoiceDetails;
		} else {
			logger.info("Failed To Insert Invoice Details");
			return invoiceDetails;
		}
	}

	@Override
	public InvoiceDetails getInvoiceDetailsByInvoiceId(String invoiceId) {
		logger.info("InvoiceId ::" + invoiceId);
		InvoiceDetails invoiceDetails = null;
		try {
			Object[] args = { invoiceId };
			invoiceDetails = jdbcTemplate.queryForObject(selectInvoiceByInvoiceId,
					new InvoiceDetailsRowMapper(jdbcTemplate), args);
			if (invoiceDetails != null)
				return invoiceDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<InvoiceDetails> getAllInvoiceDetails() {
		List<InvoiceDetails> invoiceDetailsList = jdbcTemplate.query(selectAllInvoiceDetails,
				new InvoiceDetailsRowMapper(jdbcTemplate));
		return invoiceDetailsList;
	}

	@Override
	public boolean deleteInvoiceDetailsByInvoiceId(String invoiceId) {
		logger.info("" + invoiceId);
		Object[] args = { invoiceId };
		count = jdbcTemplate.update(deleteInvoiceDetails, args);
		if (count > 0) {
			logger.info("Invoice Details Deleted Successfully");
			return true;
		} else {
			logger.info("Invoice To Delete File Details");
			return false;
		}
	}

}
