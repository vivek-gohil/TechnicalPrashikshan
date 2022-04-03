package com.technicalprashikshan.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.technicalprashikshan.main.pojo.ClientDetails;
import com.technicalprashikshan.main.service.interfaces.ClientDetailsServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("technicalprashikshanapi/clientdetailsapi")
public class ClientDetailsController {
	private static final Logger logger = LoggerFactory.getLogger(ClientDetailsController.class);

	@Autowired
	private ClientDetailsServiceInterface clientDetailsService;

	public ClientDetailsController() {
		logger.info("ClientDetailsController object created");
	}

	@RequestMapping(value = "clientdetails", method = RequestMethod.POST)
	public int newClientDetails(@RequestBody ClientDetails clientDetails) {
		logger.info(clientDetails.toString());
		return clientDetailsService.addNewClientDetails(clientDetails);
	}

	@RequestMapping(value = "clientdetails/{clientId}", method = RequestMethod.DELETE)
	public boolean deleteClientDetails(@PathVariable int clientId) {
		logger.info("" + clientId);
		return clientDetailsService.deleteClientDetailsByClientId(clientId);
	}

	@RequestMapping(value = "clientdetails", method = RequestMethod.PUT)
	public ClientDetails updateClientDetails(@RequestBody ClientDetails clientDetails) {
		logger.info(clientDetails.toString());
		return clientDetailsService.updateClientDetails(clientDetails);
	}

	@RequestMapping(value = "clientdetails/all", method = RequestMethod.GET)
	public List<ClientDetails> getAllClientDetails() {
		logger.info("Retriving all client details");
		return clientDetailsService.getAllClientDetails();
	}

	@RequestMapping(value = "clientdetails/{clientId}", method = RequestMethod.GET)
	public ClientDetails getSingleClientDetails(@PathVariable int clientId) {
		logger.info("" + clientId);
		return clientDetailsService.getClientDetailsByClientId(clientId);
	}

	@RequestMapping(value = "clientdetails/byname/{companyName}", method = RequestMethod.GET)
	public ClientDetails getClientDetailsByCompanyName(@PathVariable String companyName) {
		logger.info("" + companyName);
		return clientDetailsService.getClientDetailsByCompanyName(companyName);
	}
}
