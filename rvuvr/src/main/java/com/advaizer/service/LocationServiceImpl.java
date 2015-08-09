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

import com.advaizer.model.Product;
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
	 * @see com.advaizer.service.LocationService#getProductDetailPerCompanyService(int)
	 */
	@Override
	public List<Product> getProductDetailPerCompanyService(final int companyId) {
		// TODO Auto-generated method stub
LOGGER.debug("inside getProductDetailsPerCompanyService");
		
		return locationRepository.getProductDetailPerCompanyRepository(companyId);
	}

	

}
