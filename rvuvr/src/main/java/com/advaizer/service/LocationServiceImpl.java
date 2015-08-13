/**
 * 
 */
package com.advaizer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advaizer.model.Area;
import com.advaizer.model.Category;
import com.advaizer.model.Company;
import com.advaizer.model.Location;
import com.advaizer.model.Product;
import com.advaizer.model.ProductBrand;
import com.advaizer.model.ProductRating;
import com.advaizer.model.User;
import com.advaizer.repository.LocationRepository;

/**
 * @author smruti
 *
 */
@Service
public class LocationServiceImpl implements LocationService {
	
	private static Logger LOGGER = LogManager.getLogger(LocationServiceImpl.class.getName());
	

	/** The trend service. */
	@Autowired
	private LocationRepository locationRepository;

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#getAllStatesService()
	 */
	@Override
	public HashMap<Integer, String> getAllStatesService() {
		
		LOGGER.debug("inside getAllStatesService");
		
		return locationRepository.getAllStatesRepository();
		
	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#getStateAreaService(int)
	 */
	@Override
	public Map<Integer, String> getStateAreaService(final int stateId) {

		LOGGER.debug("inside getStateAreaService");
		
		return locationRepository.getStateAreaRepository(stateId);
	}

	/* (non-Javadoc)

	 * @see com.advaizer.service.LocationService#getSomeStateService(java.lang.Object)
	 */
	@Override
	public Map<Integer, String> getZoneStateService(final int statezone) {
		// TODO Auto-generated method stub
		return locationRepository.getZoneStateRepository(statezone);
	}

	 /* @see com.advaizer.service.LocationService#getMajorAreaService()
	 */
	@Override
	public Map<Integer, String> getMajorAreaService() {
LOGGER.debug("inside getMajorAreaService");
		
		return locationRepository.getMajorAreaRepository();

	}
	
	@Override
	public Map<Integer, String> getMajorZoneAreaService(final int zoneid) {
		LOGGER.debug("inside getMajorZoneAreaService");
				
				return locationRepository.getMajorZoneAreaRepository(zoneid);

			}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#getMajorZoneAreaService()
	 */
	@Override
	public Map<Integer, String> getMajorZoneAreaService() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#getCompaniesDataService(int)
	 */
	@Override
	public Map<Integer, String> getCompaniesPerLocationService(final int locationId) {
		
		LOGGER.debug("inside getCompanyPerLocationService");
		
		return locationRepository.getCompaniesPerLocationRepository(locationId);

		
	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#getBrandsPerCompanyService(int)
	 */
	@Override
	public Map<Integer, String> getBrandsPerCompanyService(final int companyId) {
		// TODO Auto-generated method stub
LOGGER.debug("inside getBrandsPerCompanyService");
		
		return locationRepository.getBrandsPerCompanyRepository(companyId);

	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#getBrandsPerLocationService(int)
	 */
	@Override
	public Map<Integer, String> getBrandsPerLocationService(final int locationId) {
		// TODO Auto-generated method stub
LOGGER.debug("inside getBrandsPerLocationService");
		
		return locationRepository.getBrandsPerLocationRepository(locationId);
	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#getProductsPerLocationService(int)
	 */
	@Override
	public Map<Integer, String> getProductsPerLocationService(final int locationId) {
		// TODO Auto-generated method stub
		LOGGER.debug("inside getProductsPerLocationService");
		
		return locationRepository.getProductsPerLocationRepository(locationId);

	}
	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#getCompanyPerStateService(int)
	 */
	@Override
	public Map<Integer, String> getCompanyPerStateService(final int stateId) {
		// TODO Auto-generated method stub
		LOGGER.debug("inside getCompaniesPerStateService");
		
		return locationRepository.getCompanyPerStateRepository(stateId);

	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#getProductPerCompanyService(int)
	 */
	@Override
	public Map<Integer, String> getProductPerCompanyService(final int companyId) {
		// TODO Auto-generated method stub
LOGGER.debug("inside getCompaniesPerStateService");
		
		return locationRepository.getProductPerCompanyRepository(companyId);
	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#getProductRatingPerLocationService(int)
	 */
	@Override
	public Map<Integer, String> getProductRatingPerLocationService(final int locationId) {
		// TODO Auto-generated method stub
LOGGER.debug("inside getProductRatingsPerLocationService");
		
		return locationRepository.getProductRatingPerLocationRepository(locationId);
	}

	/* (non-Javadoc)
<<<<<<< HEAD
	 * @see com.advaizer.service.LocationService#saveBrandDetails(java.util.Map)
	 */
	@Override
	public Map<String, String> saveBrandDetails(final ProductBrand brandData) {
		 
		return locationRepository.saveBrandDetails(brandData);
	}
	 /* @see com.advaizer.service.LocationService#getProductDetailPerCompanyService(int)
	 */
	@Override
	public List<Product> getProductDetailPerCompanyService(final int companyId) {
		// TODO Auto-generated method stub
LOGGER.debug("inside getProductDetailsPerCompanyService");
		
		return locationRepository.getProductDetailPerCompanyRepository(companyId);
 	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#saveAreaDetails(com.advaizer.model.Area)
	 */
	@Override
	public Map<String, String> saveAreaDetails(final Area areaData) {
		// TODO Auto-generated method stub
		return locationRepository.saveAreaDetails(areaData);
	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#saveCategoryDetails(com.advaizer.model.Category)
	 */
	@Override
	public Map<String, String> saveCategoryDetails(final Category categoryData) {
		// TODO Auto-generated method stub
		return locationRepository.saveCategoryDetails(categoryData);
	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#saveCompanyDetails(com.advaizer.model.Company)
	 */
	@Override
	public Map<String, String> saveCompanyDetails(final Company companyData) {
		// TODO Auto-generated method stub
		return locationRepository.saveCompanyDetails(companyData);
	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#saveCompanyDetails(com.advaizer.model.Location)
	 */
	@Override
	public Map<String, String> saveLocationDetails(final Location locationData) {
		// TODO Auto-generated method stub
		return locationRepository.saveLocationDetails(locationData);
	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#saveProductDetails(com.advaizer.model.Product)
	 */
	@Override
	public Map<String, String> saveProductDetails(final Product productData) {
		// TODO Auto-generated method stub
		return locationRepository.saveProductDetails(productData);
	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#saveProductDetails(com.advaizer.model.ProductRating)
	 */
	@Override
	public Map<String, String> saveProductDetails(final ProductRating productRatingData) {
		// TODO Auto-generated method stub
		return locationRepository.saveProductRatingDetails(productRatingData);
	}

	/* (non-Javadoc)
	 * @see com.advaizer.service.LocationService#saveUserDetails(com.advaizer.model.User)
	 */
	@Override
	public Map<String, String> saveUserDetails(final User userData) {
		// TODO Auto-generated method stub
		return locationRepository.saveUserDetails(userData);
	}

	

}
