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
import org.springframework.transaction.annotation.Transactional;

import com.advaizer.common.RAConstants;
import com.advaizer.exception.ApplicationException;
import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.RoamingThresholds;
import com.advaizer.repository.ConfigurationRepository;

/**
 * @author smruti
 *
 */
@Service
public class ConfigurationServiceImpl implements ConfigurationService {
	

	@Autowired
	private ConfigurationRepository configurationDao;
	
	private static Logger LOGGER = LogManager.getLogger(ConfigurationServiceImpl.class.getName());

	@Override
	public List<RoamingThresholds> fetchAllThresholds(final String RoamType){

		try{
			return configurationDao.FetchAllThresholds(RoamType);

		} catch (final RADataAccessException dae) {
			LOGGER.debug("Fetch Threshold error: " + dae.getMessage());
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}

	@Override
	@Transactional
	public Map<String, Object> saveThresholds(final String roamType, final int countryId,
			final RoamingThresholds zero, final RoamingThresholds moderate,
			final RoamingThresholds heavy) {
		final Map<String,Object> result = new HashMap<String,Object>();
		result.put("success", Boolean.TRUE);
		result.put("message", RAConstants.CONFIG_SAVE_SUCCESS_FULLY);
		try {
			configurationDao.deleteCountryThresholds(roamType, countryId);
			configurationDao.saveThresholds(roamType, countryId, zero, moderate, heavy);
		} catch (final RADataAccessException dae) {
			result.put("success", Boolean.FALSE);
			result.put("message",  RAConstants.CONFIG_SAVE_ERROR);
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.service.ConfigurationService#deleteThresholds(java.lang.String, int)
	 */
	@Override
	@Transactional
	public Map<String, Object> deleteThresholds(final String roamType, final int countryId) {
		final Map<String,Object> result = new HashMap<String,Object>();
		result.put("success", Boolean.TRUE);
		try {
			configurationDao.deleteCountryThresholds(roamType, countryId);
		} catch (final RADataAccessException dae) {
			result.put("success", Boolean.FALSE);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.service.ConfigurationService#getSystemGeneratedThreshold(java.lang.String, int)
	 */
	@Override
	public List<RoamingThresholds> getSystemGeneratedThreshold(final String roamType,
			final int countryId) {
		try {
			return configurationDao.getSystemGeneratedThreshold(roamType, countryId);
		} catch (final RADataAccessException dae) {
			LOGGER.debug("Fetch Threshold error: " + dae.getMessage());
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}

}
