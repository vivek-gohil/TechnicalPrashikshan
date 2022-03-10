package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.dao.FilesDetailsDAO;
import com.technicalprashikshan.main.dao.TrainerDetailsDAO;
import com.technicalprashikshan.main.pojo.FilesDetails;
import com.technicalprashikshan.main.pojo.InvoiceDetails;
import com.technicalprashikshan.main.pojo.TrainerDetails;

public class InvoiceDetailsRowMapper implements RowMapper<InvoiceDetails> {
	private static final Logger logger = LoggerFactory.getLogger(InvoiceDetailsRowMapper.class);
	private JdbcTemplate jdbcTemplate;

	public InvoiceDetailsRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public InvoiceDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		logger.info("InvoiceDetailsRowMapper mapRow");

		InvoiceDetails invoiceDetails = new InvoiceDetails();
		invoiceDetails.setInvoiceId(resultSet.getString("invoice_id"));
		invoiceDetails.setRaisedDate(resultSet.getDate("raised_date").toLocalDate());
		invoiceDetails.setClearingDate(resultSet.getDate("clearing_date").toLocalDate());
		invoiceDetails.setAmount(resultSet.getDouble("invoice_amount"));
		invoiceDetails.setAmountInWords(resultSet.getString("invoice_amount_in_words"));

		FilesDetailsDAO filesDetailsDAO = new FilesDetailsDAO(jdbcTemplate);
		FilesDetails filesDetails = filesDetailsDAO.getFileDetailsByFileId(resultSet.getInt("invoice_file_id"));
		invoiceDetails.setInvoiceFile(filesDetails);

		invoiceDetails.setInvoiceStatus(resultSet.getString("invoice_status"));
		invoiceDetails.setClearedAmount(resultSet.getDouble("invoice_cleared_amount"));
		invoiceDetails.setTaxDeductedAmount(resultSet.getDouble("tax_deducted_amount"));

		TrainerDetailsDAO trainerDetailsDAO = new TrainerDetailsDAO(jdbcTemplate);
		TrainerDetails trainerDetails = trainerDetailsDAO.getTrainerDetailsByTrainerId(resultSet.getInt("trainer_id"));
		invoiceDetails.setTrainerDetails(trainerDetails);

		return invoiceDetails;
	}

}
