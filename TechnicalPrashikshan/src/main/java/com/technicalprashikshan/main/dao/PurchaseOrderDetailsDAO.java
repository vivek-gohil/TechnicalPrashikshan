package com.technicalprashikshan.main.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.technicalprashikshan.main.dao.interfaces.PurchaseOrderDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.PurchaseOrderDetailsRowMapper;
import com.technicalprashikshan.main.pojo.PurchaseOrderDetails;

@Repository
public class PurchaseOrderDetailsDAO implements PurchaseOrderDetailsDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderDetailsDAO.class);

	private static final String insertNewPurchaseOrderDetails = "insert into purchase_order_details(purchase_order_id,amount,received_date,purchase_order_file_id,purchase_order_status, training_details_id ) values (?,?,?,?,?,?)";
	private static final String updatePurchaseOrderDetails = "update purchase_order_details set amount = ? ,received_date = ? , purchase_order_file_id = ? , purchase_order_status = ? , training_details_id = ? where purchase_order_id = ? ";
	private static final String deletePurchaseOrderDetails = "delete from purchase_order_details where purchase_order_id = ?";
	private static final String selectPurchaseOrderByPurchaseOrderId = "select * from purchase_order_details where purchase_order_id = ?";
	private static final String selectAllPurchaseOrderDetails = "select * from purchase_order_details ";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PurchaseOrderDetailsDAO() {
	}

	public PurchaseOrderDetailsDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String addNewPurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails) {
		logger.info("in addNewPurchaseOrderDetails");

		Object[] args = { purchaseOrderDetails.getPurchseOrderId(), purchaseOrderDetails.getAmount(),
				purchaseOrderDetails.getReceivedDate(), purchaseOrderDetails.getPurchaseOrderFile().getFileId(),
				purchaseOrderDetails.getPurchaseOrderStatus(),
				purchaseOrderDetails.getTrainingDetails().getTrainingDetailsId() };
		count = jdbcTemplate.update(insertNewPurchaseOrderDetails, args);
		if (count > 0) {
			logger.info("Purchase Order Details Inserted Successfully");
		} else {
			logger.info("Failed To Inserted Purchase Order Details");
		}
		return purchaseOrderDetails.getPurchseOrderId();
	}

	@Override
	public PurchaseOrderDetails updatePurchaseOrderDetails(PurchaseOrderDetails purchaseOrderDetails) {
		logger.info(purchaseOrderDetails.toString());
		Object[] args = { purchaseOrderDetails.getAmount(), purchaseOrderDetails.getReceivedDate(),
				purchaseOrderDetails.getPurchaseOrderFile().getFileId(), purchaseOrderDetails.getPurchaseOrderStatus(),
				purchaseOrderDetails.getTrainingDetails().getTrainingDetailsId(),
				purchaseOrderDetails.getPurchseOrderId() };
		count = jdbcTemplate.update(updatePurchaseOrderDetails, args);
		if (count > 0) {
			logger.info("Purchase Order Details Updated Successfully");
			return purchaseOrderDetails;
		} else {
			logger.info("Failed To Update Purchase Order Details");
			return null;
		}
	}

	@Override
	public PurchaseOrderDetails getPurchaseOrderDetailsByPurchaseOrderId(String purchaseOrderId) {
		PurchaseOrderDetails purchaseOrderDetails = null;
		try {
			Object[] args = { purchaseOrderId };
			purchaseOrderDetails = jdbcTemplate.queryForObject(selectPurchaseOrderByPurchaseOrderId,
					new PurchaseOrderDetailsRowMapper(jdbcTemplate), args);
			if (purchaseOrderDetails != null)
				return purchaseOrderDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<PurchaseOrderDetails> getAllPurchaseOrderDetails() {
		List<PurchaseOrderDetails> purchaseOrderDetailsList = jdbcTemplate.query(selectAllPurchaseOrderDetails,
				new PurchaseOrderDetailsRowMapper(jdbcTemplate));
		return purchaseOrderDetailsList;
	}

	@Override
	public boolean deletePurchaseOrderDetailsByPurchaseOrderId(String purchaseOrderId) {
		logger.info("" + purchaseOrderId);
		Object[] args = { purchaseOrderId };
		count = jdbcTemplate.update(deletePurchaseOrderDetails, args);
		if (count > 0) {
			logger.info("Purchase Order Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete Purchase Order Details");
			return false;
		}
	}

}
