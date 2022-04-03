package com.technicalprashikshan.main.dao.interfaces;

import java.util.List;

import com.technicalprashikshan.main.pojo.VendorDetails;

public interface VendorDetailsDAOInterface {
	public int addNewVendorDetails(VendorDetails vendorDetails);

	public VendorDetails updateVendorDetails(VendorDetails vendorDetails);

	public VendorDetails getVendorDetailsByVendorId(int vendorId);

	public List<VendorDetails> getAllVendorDetails();

	public boolean deleteVenderDetailsByVendorId(int vendorId);
	
	public VendorDetails getVendorDetailsByVendorName(String vendorName);
}
