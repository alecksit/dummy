/**
 * 
 */
package com.advaizer.service;

import java.util.List;
import java.util.Map;

import com.advaizer.model.Filter;
import com.advaizer.model.RoamingStatistics;


/**
 * @author cheshta
 *
 */
public interface TrackerService {
		
	/**
	 * Saves the track details for microsegment.
	 * @param filter
	 * @param trackName
	 * @param microSegmentCharts 
	 * @return
	 */
	Map<String, String> saveTrackerDetails(Filter filter, String trackName, String roamType,
			String startDateRange, String endDateRange, String filterLabels, String filterJson, boolean isCustomTracker,
			String quarterlyOption);
	
	/**
	 * 
	 * @param roamType
	 * @param trackerName
	 * @return
	 */
	List<Map<String, String>> getAllTrackers(String roamType, String trackerName);

	/**
	 * @param trackName
	 * @param roamType
	 * @return
	 */
	String deleteTracker(long trackerId, String roamType);
	
	Map<String, Object> getTrackerDataForNetwork(Filter startFilter, String column,
			String columnType, Map<String, String> catNameValue, String roamType, Long newStartdate, Long newEndDate) ;

	/**
	 * @param filter
	 * @param column
	 * @param columnType
	 * @param catNameValue
	 * @param roamType
	 * @return
	 */
	Map<String, Object> getTrackerDataForNetworkGroup(Filter filter, String column, 
			String columnType, Map<String, String> catNameValue, String roamType, Long newStartdate, Long newEndDate);
	
	/**
	 * 
	 * @param filter
	 * @param roamType
	 * @return
	 */
	List<RoamingStatistics> getTrackerStatistics(Filter filter,String roamType,Long newStartDate,Long newEndDate);
	
	/**
	 * 
	 * @param filter
	 * @param roamType
	 * @return
	 */
	List<RoamingStatistics> getTrackerListStatistics(Filter filter,String roamType,Long newStartDate,Long newEndDate);

	/**
	 * @param filter
	 * @param string
	 * @param string2
	 * @param map
	 * @param roamType
	 * @param newStartdate
	 * @param newEndDate
	 * @return
	 */
	Map<String, Object> getTrackerDataForGraph(Filter filter, String attributeName,
			String string, String string2, Map<String, String> map,
			String roamType, Long newStartdate, Long newEndDate);
	
	/**
	 * @param filter
	 * @param string
	 * @param string2
	 * @param map
	 * @param roamType
	 * @param newStartdate
	 * @param newEndDate
	 * @return
	 */
	Map<String, Object> getTrackerDataForOtherCountriesTraveled(Filter filter, String attributeName,
			String column, String columnType, String roamType, Long newStartdate, Long newEndDate);

}
