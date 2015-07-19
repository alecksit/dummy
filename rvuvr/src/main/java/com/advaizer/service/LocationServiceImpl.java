/**
 * 
 */
package com.advaizer.service;

import java.util.HashMap;

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

}
