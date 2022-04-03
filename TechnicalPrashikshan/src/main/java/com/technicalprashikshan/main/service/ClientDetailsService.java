package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.ClientDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.ClientDetails;
import com.technicalprashikshan.main.service.interfaces.ClientDetailsServiceInterface;

@Service
public class ClientDetailsService implements ClientDetailsServiceInterface {

	@Autowired
	private ClientDetailsDAOInterface clientDetailsDAO;

	@Override
	public int addNewClientDetails(ClientDetails clientDetails) {
		return clientDetailsDAO.addNewClientDetails(clientDetails);
	}

	@Override
	public ClientDetails updateClientDetails(ClientDetails clientDetails) {
		return clientDetailsDAO.updateClientDetails(clientDetails);
	}

	@Override
	public ClientDetails getClientDetailsByClientId(int clientId) {
		return clientDetailsDAO.getClientDetailsByClientId(clientId);
	}

	@Override
	public List<ClientDetails> getAllClientDetails() {
		return clientDetailsDAO.getAllClientDetails();
	}

	@Override
	public boolean deleteClientDetailsByClientId(int clientId) {
		return clientDetailsDAO.deleteClientDetailsByClientId(clientId);
	}

	@Override
	public ClientDetails getClientDetailsByCompanyName(String companyName) {
		return clientDetailsDAO.getClientDetailsByCompanyName(companyName);
	}

}
