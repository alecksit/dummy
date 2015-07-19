/**
 * 
 */
package com.advaizer.service;

import java.util.List;
import java.util.Map;

import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.Filter;

/**
 * @author sarvesh
 *
 */
public interface MicroSegmentService {
	
	/**
	 *  Gets data required for network graph in microsegment section.
	 *
	 * @return the network data
	 */
	Map<String, List<Object[]>> getMSChartData(Filter filter, String attributeName, String column, String columnType,
			Map<String,String> catNameValue, String roamType);
	
	
	/**
	 *  Gets data required for network graph in microsegment section.
	 *
	 * @return the network data
	 */
	Map<String, Map<String,Map<String,Double>>> getMSChartDataForOverlay(Filter filter, String attributeName, String column, String overlayAttributeName,
			String overlayAttributeColumn, Map<String,String> catNameValue,Map<String,String> overlayAttrNameValue, String roamType);
	
	
	/**
	 *  Gets data required for network graph in microsegment section.
	 *
	 * @return the network data
	 */
	Map<String, Map<String,Map<String,Double>>> getNetworkDataForOverlay(Filter filter, String attributeName, String column, String overlayAttributeName,
			String overlayAttributeColumn, Map<String,String> catNameValue,Map<String,String> overlayAttrNameValue, String roamType);
	
	/**
	 *  Gets data required for network graph in microsegment section.
	 *
	 * @return the network data
	 */
	Map<String, Map<String,Map<String,Double>>> getNetworkGroupForOverlay(Filter filter, String attributeName, String column, String overlayAttributeName,
			String overlayAttributeColumn, Map<String,String> catNameValue,Map<String,String> overlayAttrNameValue, String roamType);
	
	
	
	/**
	 *  Gets data required for network graph in microsegment section.
	 *
	 * @return the network data
	 */
	Map<String, Map<String,Map<String,Double>>> getOCTForOverlay(Filter filter, String attributeName, String column, String overlayAttributeName,
			String overlayAttributeColumn, Map<String,String> catNameValue,Map<String,String> overlayAttrNameValue, String roamType);
	/**
	 * Gets the network group data.
	 *
	 * @param filter the filter
	 * @param column the column
	 * @param columnType the column type
	 * @param catNameValue the cat name value
	 * @return the network data
	 */
	Map<String, List<Object[]>> getNetworkGroupData(Filter filter, String column, String columnType,
			Map<String,String> catNameValue, String roamType);
	
	/**
	 * Gets the network  data.
	 *
	 * @param filter the filter
	 * @param column the column
	 * @param columnType the column type
	 * @param catNameValue the cat name value
	 * @return the network data
	 */
	Map<String, List<Object[]>> getNetworkData(Filter filter, String column, String columnType,
			Map<String,String> catNameValue, String roamType);
	
	
	/**
	 *  Gets data required for other countries traveled in microsegment section.
	 *
	 * @return the network data
	 * @throws RADataAccessException 
	 */
	Map<String, List<Object[]>> getOtherCountriesTraveledData(Filter filter, String column, String columnType,
			Map<String,String> catNameValue,String roamType);
	
}
