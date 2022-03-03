package com.technicalprashikshan.main.service.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.ClientDetails;

public interface ClientDetailsServiceInterface {
	public int addNewClientDetails(ClientDetails clientDetails);

	public ClientDetails updateClientDetails(ClientDetails clientDetails);

	public ClientDetails getClientDetailsByClientId(int clientId);

	public List<ClientDetails> getAllClientDetails();

	public boolean deleteClientDetailsByClientId(int clientId);
}
