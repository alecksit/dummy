/**
 * 
 */
package com.advaizer.repository;

import java.util.List;
import java.util.Map;

import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.Attribute;
import com.advaizer.model.AttributeCategory;
import com.advaizer.model.Country;
import com.advaizer.model.Filter;

/**
 * @author sarvesh
 *
 */
public interface MetaDataRepository {

	/**
	 * Gets the attribute list for left panel.
	 *
	 * @return the attribute list
	 */
	public List<Attribute> getAttributeList(Filter filter, String roamType) throws RADataAccessException;
	
	
	/**
	 * Gets the all networks.
	 *
	 * @return the all networks
	 */
	public Map<Long, List<AttributeCategory>> getAllNetworkAndNetworkGroups(Filter filter, long networkAttrId, 
			long networkGroupAttrId, String roamType) throws RADataAccessException ;
	
	
	/**
	 * Gets the all networks.
	 *
	 * @return the all networks
	 */
	public Map<Long, List<AttributeCategory>> getDeviceModelsAndManufactures(Filter filter, long deviceModelAttrId, 
			long deviceManufacturerAttrId, long deviceCategoryAttrId, String roamType) throws RADataAccessException ;
	
	/**
	 * Gets the all countries.
	 *
	 * @return the all countries
	 */
	public List<Country> getAllCountries(Filter filter, String roamType) throws RADataAccessException;
	
	/**
	 * Gets the all countries.
	 *
	 * @return the all countries
	 */
	public List<Country> getAllStaticCountries( String roamType) throws RADataAccessException;
	
	
	/**
	 * Gets the other countries traveled.
	 *
	 * @param filter the filter
	 * @return the other countries traveled
	 */
	public List<AttributeCategory> getOtherCountriesTraveled(Filter filter, String roamType) throws RADataAccessException;
	
	/**
	 * Gets all time zones defined in Confgi table
	 * @return
	 * @throws RADataAccessException
	 */
	public String getTimeZone() throws RADataAccessException;
}
