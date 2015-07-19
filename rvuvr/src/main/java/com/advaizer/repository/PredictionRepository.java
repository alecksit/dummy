/**
 * 
 */
package com.advaizer.repository;

import java.util.List;
import java.util.Map;

import com.advaizer.model.Filter;
import com.advaizer.model.TravelPrediction;

/**
 * @author smruti
 *
 */
public interface PredictionRepository {

	/**
	 * @param filter
	 * @param roamType
	 * @param newStartDate
	 * @param newEndDate
	 * @return
	 */
	List<TravelPrediction> getBeforeTravelStatisticsData(Filter filter,
			String roamType);

	/**
	 * @param filter
	 * @param roamType
	 * @param newStartDate
	 * @param newEndDate
	 * @return
	 */
	List<TravelPrediction> getUponLandingStatisticsData(Filter filter,
			String roamType);
	
	/**
	 * 
	 * @param filter
	 * @param campaignStartTime
	 * @param campaignEndTime
	 * @param monitoringStartTime
	 * @param monitoringEndTime
	 * @return
	 */
	Map<String, Object> getTagSubscriberData(Filter filter, long tagId, long campaignStartTime, long campaignEndTime,
			long monitoringStartTime, long monitoringEndTime,String roamType,String tagType);

}
