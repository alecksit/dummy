/**
 * 
 */
package com.advaizer.service;

import java.util.List;
import java.util.Map;

import com.advaizer.model.RoamingThresholds;

/**
 * @author smruti
 *
 */
public interface ConfigurationService {
	
/**
 * Method to list all the thresholds
 * @param RoamType
 * @return
 */
	List<RoamingThresholds> fetchAllThresholds(final String roamType);
	
	/**
	 * This method saves three thresholds for a country id
	 * @param countryId
	 * @param roamType
	 * @param zero
	 * @param moderate
	 * @param heavy
	 * @return
	 */
	Map<String,Object> saveThresholds(final String roamType, int countryId, RoamingThresholds zero, RoamingThresholds moderate,
			RoamingThresholds heavy);
	/**
	 * Deletes a user defined configuration
	 * @param roamType
	 * @param countryId
	 * @return
	 */
	Map<String,Object> deleteThresholds(final String roamType, int countryId);
	
	List<RoamingThresholds> getSystemGeneratedThreshold(final String roamType, int countryId);
	
}
