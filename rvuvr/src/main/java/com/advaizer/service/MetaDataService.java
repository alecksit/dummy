/**
 * 
 */
package com.advaizer.service;

import java.util.List;

import com.advaizer.model.Attribute;
import com.advaizer.model.AttributeCategory;
import com.advaizer.model.Country;
import com.advaizer.model.Filter;

/**
 * @author Quovantis_Dev
 *
 */
public interface MetaDataService {

	/**
	 * Gets the attribute list for left panel.
	 *
	 * @return the attribute list
	 */
	public List<Attribute> getAttributes(Filter filter,String roamType);
	
	/**
	 * Gets the all countries.
	 *
	 * @return the all countries
	 */
	public List<Country> getAllCountries(Filter filter,String roamType);
	
	/**
	 * Gets the all Static countries.
	 *
	 * @return the all countries
	 */
	
	public List<Country> getAllStaticCountries(String roamType);
	
	
	/**
	 * Gets the other countries traveled.
	 *
	 * @param filter the filter
	 * @return the other countries traveled
	 */
	public List<AttributeCategory> getOtherCountriesTraveled(Filter filter,String roamType);
	
	/**
	 * Added by smruti on 2014-07-21
	 * @param str_date
	 * @return
	 */
	public long dateToTimestamp(String str_date);
	
	/**
	 * @Author Smruti 
	 * @param list
	 * @return
	 */
	public Object[] listToObjectArray(List<Object> list);
	
	/**
	 * Gets time zone
	 * @return
	 */
	public String getTimeZone();
}
