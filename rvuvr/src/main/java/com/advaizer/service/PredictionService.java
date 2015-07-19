/**
 * 
 */
package com.advaizer.service;

import java.util.List;
import java.util.Map;

import com.advaizer.model.Filter;
import com.advaizer.model.TravelPrediction;

/**
 * @author smruti
 *
 */
public interface PredictionService {

	/**
	 * 
	 * @param filter
	 * @param roamType
	 * @return
	 */
	TravelPrediction getBeforeTravelStatistics(Filter filter, String roamType);

	/**
	 * 
	 * @param filter
	 * @param roamType
	 * @return
	 */
	List<TravelPrediction> getUponLandingStatistics(Filter filter,
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
	Map<String, Object> getTagSubscriberData(Filter filter, long campaignStartTime, long campaignEndTime,
			long monitoringStartTime, long monitoringEndTime, long tagId, String roamType, String tagType);
}
