/**
 * 
 */
package com.advaizer.repository;

import java.util.List;
import java.util.Map;

import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.Filter;
import com.advaizer.model.RoamingStatistics;
import com.advaizer.model.Tracker;

/**
 * @author cheshta
 *
 */
public interface TrackerRepository {
	
	/**
	 * Saves track details.
	 * @param filter
	 * @param trackName
	 * @param microSegmentCharts 
	 * @return
	 * @throws RADataAccessException
	 */
	Map<String, String> saveTrackerDetails(Filter filter, String trackName, String roamType, String startDateRange,
			String endDateRange, String filterLabels, String filterJson, boolean isCustomTracker,
			String quarterlyOption)
			throws RADataAccessException;

	/**
	 * @param trackName
	 * @return
	 */
	boolean isExistingTracker(String trackName, String roamType);
	
	List<Map<String, String>> getAllTrackers(String roamType,String trackerName) throws RADataAccessException;

	/**
	 * @param trackers
	 * @param roamType
	 * @return
	 * @throws RADataAccessException
	 */
	Map<String, String> getTrackerDetails(List<Tracker> trackers,
			String roamType) throws RADataAccessException;

	/**
	 * @param roamType
	 * @param roamType2 
	 * @return
	 */
	String deleteTracker(long trackerId, String roamType) throws RADataAccessException;
	
	Map<String, Object> getTrackerDataForNetwork(Filter startFilter, String column, String columnType,
			Map<String, String> catNameValue, String roamType, Long newStartDate, 
			Long newEndDate) throws RADataAccessException ;

	/**
	 * @param filter
	 * @param column
	 * @param columnType
	 * @param catNameValue
	 * @param roamType
	 * @return
	 * @throws RADataAccessException 
	 */
	Map<String, Object> getTrackerDataForNetworkGroup(Filter filter,
			String column, String columnType, Map<String, String> catNameValue,
			String roamType, Long newStartdate, Long newEndDate) throws RADataAccessException;

	/**
	 * @param filter
	 * @param roamType
	 * @param newStartDate
	 * @param newEndDate
	 * @return
	 */
	List<RoamingStatistics> getTrackerStatisticsData(Filter filter,
			String roamType, Long newStartDate, Long newEndDate);

	/**
	 * @param filter
	 * @param column
	 * @param columnType
	 * @param catNameValue
	 * @param roamType
	 * @param newStartdate
	 * @param newEndDate
	 * @return
	 */
	Map<String, Object> getTrackerDataForGraph(Filter filter, String attributeName,
			String column, String columnType, Map<String, String> catNameValue,
			String roamType, Long newStartdate, Long newEndDate) throws RADataAccessException;
	
	

	/**
	 * @param filter
	 * @param column
	 * @param columnType
	 * @param catNameValue
	 * @param roamType
	 * @param newStartdate
	 * @param newEndDate
	 * @return
	 */
	Map<String, Object> getTrackerDataForOtherCountriesTraveled(Filter filter, String attributeName,
			String column, String columnType, String roamType, Long newStartdate, Long newEndDate)
					throws RADataAccessException;
	
	/**
	 * @param filter
	 * @param roamType
	 * @param newStartDate
	 * @param newEndDate
	 * @return
	 */
	List<RoamingStatistics> getTrackerListStatisticsData(Filter filter,
			String roamType, Long newStartDate, Long newEndDate);

}
