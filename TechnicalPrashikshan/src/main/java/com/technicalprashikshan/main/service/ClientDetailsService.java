package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.pojo.ClientDetails;
import com.technicalprashikshan.main.service.interfaces.ClientDetailsServiceInterface;

@Service
public class ClientDetailsService implements ClientDetailsServiceInterface {

	@Override
	public int addNewClientDetails(ClientDetails clientDetails) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ClientDetails updateClientDetails(ClientDetails clientDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDetails getClientDetailsByClientId(int clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClientDetails> getAllClientDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteClientDetailsByClientId(int clientId) {
		// TODO Auto-generated method stub
		return false;
	}

}
