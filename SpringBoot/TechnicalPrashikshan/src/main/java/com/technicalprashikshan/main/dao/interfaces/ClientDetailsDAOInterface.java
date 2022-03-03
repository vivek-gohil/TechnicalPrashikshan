package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.ClientDetails;

public interface ClientDetailsDAOInterface {
	public int addNewClientDetails(ClientDetails clientDetails);

	public ClientDetails updateClientDetails(ClientDetails clientDetails);

	public ClientDetails getClientDetailsByClientId(int clientId);

	public List<ClientDetails> getAllClientDetails();

	public boolean deleteClientDetailsByClientId(int clientId);
}
