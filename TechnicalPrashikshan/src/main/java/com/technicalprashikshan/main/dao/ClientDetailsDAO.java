package com.technicalprashikshan.main.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.technicalprashikshan.main.dao.interfaces.ClientDetailsDAOInterface;
import com.technicalprashikshan.main.dao.rowmappers.ClientDetailsRowMapper;
import com.technicalprashikshan.main.pojo.ClientDetails;

@Repository
public class ClientDetailsDAO implements ClientDetailsDAOInterface {

	private static final Logger logger = LoggerFactory.getLogger(ClientDetailsDAO.class);

	private static final String insertNewClientDetails = "insert into client_master (company_name,address_line_1,address_line_2,landmark,city,state,pin,primary_contact_id,client_status) values(?,?,?,?,?,?,?,?,?)";
	private static final String updateClientDetails = "update client_master set company_name = ? ,address_line_1 = ? ,address_line_2 = ? ,landmark = ? ,city = ? ,state = ? ,pin = ? ,primary_contact_id = ? ,client_status = ? where client_id = ?";
	private static final String deleteClientDetails = "delete from client_master where client_id = ?";
	private static final String selectClientByClientId = "select * from client_master where client_id = ?";
	private static final String selectAllClientDetails = "select * from client_master order by company_name";

	private int count;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addNewClientDetails(ClientDetails clientDetails) {

		logger.info(clientDetails.toString());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection.prepareStatement(insertNewClientDetails,
					new String[] { "client_id" });
			preparedStatement.setString(1, clientDetails.getCompanyName());
			preparedStatement.setString(2, clientDetails.getAddressLineOne());
			preparedStatement.setString(3, clientDetails.getAddressLineTwo());
			preparedStatement.setString(4, clientDetails.getLandmark());
			preparedStatement.setString(5, clientDetails.getCity());
			preparedStatement.setString(6, clientDetails.getState());
			preparedStatement.setString(7, clientDetails.getPin());
			preparedStatement.setString(7, clientDetails.getClientStatus());
			preparedStatement.setInt(8, clientDetails.getPrimaryContact().getContactId());
			return preparedStatement;
		}, keyHolder);

		int clientId = keyHolder.getKey().intValue();
		logger.info("Generated ClientId :: " + clientId);
		return clientId;
	}

	@Override
	public ClientDetails updateClientDetails(ClientDetails clientDetails) {
		logger.info(clientDetails.toString());
		Object[] args = { clientDetails.getCompanyName(), clientDetails.getAddressLineOne(),
				clientDetails.getAddressLineTwo(), clientDetails.getLandmark(), clientDetails.getCity(),
				clientDetails.getState(), clientDetails.getPin(), clientDetails.getClientStatus(),
				clientDetails.getPrimaryContact().getContactId(), clientDetails.getClientId() };
		count = jdbcTemplate.update(updateClientDetails, args);
		if (count > 0) {
			logger.info("Client Details Updated Successfully");
			return clientDetails;
		} else {
			logger.info("Failed To Update Client Details");
			return null;
		}

	}

	@Override
	public ClientDetails getClientDetailsByClientId(int clientId) {
		ClientDetails clientDetails = null;
		try {
			Object[] args = { clientId };
			clientDetails = jdbcTemplate.queryForObject(selectClientByClientId,
					new ClientDetailsRowMapper(jdbcTemplate), args);
			if (clientDetails != null)
				return clientDetails;
		} catch (Exception e) {
			logger.error("Exception :: " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<ClientDetails> getAllClientDetails() {
		List<ClientDetails> clientDetailsList = jdbcTemplate.query(selectAllClientDetails,
				new ClientDetailsRowMapper(jdbcTemplate));
		return clientDetailsList;
	}

	@Override
	public boolean deleteClientDetailsByClientId(int clientId) {
		logger.info("" + clientId);
		Object[] args = { clientId };
		count = jdbcTemplate.update(deleteClientDetails, args);
		if (count > 0) {
			logger.info("Client Details Deleted Successfully");
			return true;
		} else {
			logger.info("Failed To Delete Client Details");
			return false;
		}
	}

}
