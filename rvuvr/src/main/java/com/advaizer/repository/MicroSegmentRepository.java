/**
 * 
 */
package com.advaizer.repository;

import java.util.List;
import java.util.Map;

import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.Filter;

/**
 * @author sarvesh
 *
 */
public interface MicroSegmentRepository {

	/**
	 *  Gets data required for all charts in microsegment section.
	 *
	 * @return the network data
	 * @throws RADataAccessException 
	 */
	Map<String,List<Object[]>> getMSChartData(Filter filter,String attributeName, String column,
			Map<String,String> catNameValue, String roamType) throws RADataAccessException;
	
	/**
	 *  Gets data required for all charts in microsegment section.
	 *
	 * @return the network data
	 * @throws RADataAccessException 
	 */
	Map<String,Map<String,Map<String,Double>>> getMSOverlayChartData(Filter filter,String attributeName, String column,
			String overlayAttribute, String overlayColumn, Map<String,String> catNameValue,Map<String,String> overlayNameValue ,
			String roamType) throws RADataAccessException;
	
	
	/**
	 *  Gets data required for all charts in microsegment section.
	 *
	 * @return the network data
	 * @throws RADataAccessException 
	 */
	Map<String,Map<String,Map<String,Double>>> getNetworkOverlayChartData(Filter filter,String attributeName, String column,
			String overlayAttribute, String overlayColumn, Map<String,String> catNameValue,Map<String,String> overlayNameValue ,
			String roamType) throws RADataAccessException;
	
	
	/**
	 *  Gets data required for all charts in microsegment section.
	 *
	 * @return the network data
	 * @throws RADataAccessException 
	 */
	Map<String,Map<String,Map<String,Double>>> getOCTOverlayChartData(Filter filter,String attributeName, String column,
			String overlayAttribute, String overlayColumn, Map<String,String> catNameValue,Map<String,String> overlayNameValue ,
			String roamType) throws RADataAccessException;
	
	/**
	 *  Gets data required for all charts in microsegment section.
	 *
	 * @return the network data
	 * @throws RADataAccessException 
	 */
	Map<String,Map<String,Map<String,Double>>> getNetworkGroupOverlayChartData(Filter filter,String attributeName, String column,
			String overlayAttribute, String overlayColumn, Map<String,String> catNameValue,Map<String,String> overlayNameValue ,
			String roamType) throws RADataAccessException;
	/**
	 *  Gets data required for network group in microsegment section.
	 *
	 * @return the network data
	 * @throws RADataAccessException 
	 */
	Map<String,List<Object[]>> getNetworkGroupData(Filter filter, String column, String columnType,
			Map<String,String> catNameValue, String roamType) throws RADataAccessException;
	
	/**
	 *  Gets data required for network group in microsegment section.
	 *
	 * @return the network data
	 * @throws RADataAccessException 
	 */
	Map<String,List<Object[]>> getNetworkData(Filter filter, String column, String columnType,
			Map<String,String> catNameValue, String roamType) throws RADataAccessException;
	
	
	/**
	 *  Gets data required for other countries traveled in microsegment section.
	 *
	 * @return the network data
	 * @throws RADataAccessException 
	 */
	Map<String,List<Object[]>> getOtherCountriesTraveledData(Filter filter, String column, String columnType,
			Map<String,String> catNameValue, String roamType) throws RADataAccessException;
}
