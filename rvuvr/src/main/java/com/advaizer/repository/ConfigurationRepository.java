/**
 * 
 */
package com.advaizer.repository;

import java.util.List;

import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.RoamingThresholds;

/**
 * @author smruti
 *
 */
public interface ConfigurationRepository {
	
	/**
	 * Method to list all the thresholds
	 * @param RoamType
	 * @return
	 */
	List<RoamingThresholds> FetchAllThresholds(final String RoamType) throws RADataAccessException ;
	
	void deleteCountryThresholds(final String RoamType, int countryId) throws RADataAccessException;
	
	List<RoamingThresholds> getSystemGeneratedThreshold(final String RoamType, int countryId) throws RADataAccessException;
	
	/**
	 * This method saves three thresholds for a country id
	 * @param countryId
	 * @param roamType
	 * @param zero
	 * @param moderate
	 * @param heavy
	 * @return
	 * @throws RADataAccessException 
	 */
	void saveThresholds(final String roamType, int countryId, RoamingThresholds zero, RoamingThresholds moderate,
			RoamingThresholds heavy) throws RADataAccessException;
		
		

		
}
