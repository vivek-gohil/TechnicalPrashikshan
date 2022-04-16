package com.technicalprashikshan.main.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.technicalprashikshan.main.dao.ClientDetailsDAO;
import com.technicalprashikshan.main.dao.FilesDetailsDAO;
import com.technicalprashikshan.main.dao.TrainingDetailsDAO;
import com.technicalprashikshan.main.dao.VendorDetailsDAO;
import com.technicalprashikshan.main.pojo.ClientDetails;
import com.technicalprashikshan.main.pojo.FilesDetails;
import com.technicalprashikshan.main.pojo.PurchaseOrderDetails;
import com.technicalprashikshan.main.pojo.TrainingDetails;
import com.technicalprashikshan.main.pojo.VendorDetails;

public class PurchaseOrderDetailsRowMapper implements RowMapper<PurchaseOrderDetails> {
	private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderDetailsRowMapper.class);

	private JdbcTemplate jdbcTemplate;

	public PurchaseOrderDetailsRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public PurchaseOrderDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		logger.info("PurchaseOrderDetailsRowMapper mapRow");
		PurchaseOrderDetails purchaseOrderDetails = new PurchaseOrderDetails();

		purchaseOrderDetails.setPurchseOrderId(resultSet.getString("purchase_order_id"));
		purchaseOrderDetails.setAmount(resultSet.getDouble("amount"));
		purchaseOrderDetails.setReceivedDate(resultSet.getDate("received_date").toLocalDate());

		FilesDetailsDAO filesDetailsDAO = new FilesDetailsDAO(jdbcTemplate);
		FilesDetails filesDetails = filesDetailsDAO.getFileDetailsByFileId(resultSet.getInt("purchase_order_file_id"));
		purchaseOrderDetails.setPurchaseOrderFile(filesDetails);

		purchaseOrderDetails.setPurchaseOrderStatus(resultSet.getString("purchase_order_status"));

		TrainingDetailsDAO trainingDetailsDAO = new TrainingDetailsDAO(jdbcTemplate);
		TrainingDetails trainingDetails = trainingDetailsDAO
				.getTrainingDetailsByTrainingId(resultSet.getInt("training_details_id"));
		purchaseOrderDetails.setTrainingDetails(trainingDetails);

		return purchaseOrderDetails;
	}
}
