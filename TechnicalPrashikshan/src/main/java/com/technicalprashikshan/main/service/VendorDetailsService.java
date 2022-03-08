package com.technicalprashikshan.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalprashikshan.main.dao.interfaces.VendorDetailsDAOInterface;
import com.technicalprashikshan.main.pojo.VendorDetails;
import com.technicalprashikshan.main.service.interfaces.VendorDetailsServiceInteface;

@Service
public class VendorDetailsService implements VendorDetailsServiceInteface {

	@Autowired
	private VendorDetailsDAOInterface vendorDetailsDAO;

	@Override
	public int addNewVendorDetails(VendorDetails vendorDetails) {
		return vendorDetailsDAO.addNewVendorDetails(vendorDetails);
	}

	@Override
	public VendorDetails updateVendorDetails(VendorDetails vendorDetails) {
		return vendorDetailsDAO.updateVendorDetails(vendorDetails);
	}

	@Override
	public VendorDetails getVendorDetailsByVendorId(int vendorId) {
		return vendorDetailsDAO.getVendorDetailsByVendorId(vendorId);
	}

	@Override
	public List<VendorDetails> getAllVendorDetails() {
		return vendorDetailsDAO.getAllVendorDetails();
	}

	@Override
	public boolean deleteVenderDetailsByVendorId(int vendorId) {
		return vendorDetailsDAO.deleteVenderDetailsByVendorId(vendorId);
	}

}
