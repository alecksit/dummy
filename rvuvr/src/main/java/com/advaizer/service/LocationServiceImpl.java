/**
 * 
 */
package com.advaizer.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	

}
