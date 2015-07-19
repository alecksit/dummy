/**
 * 
 */
package com.advaizer.repository;

import java.util.List;
import java.util.Map;

import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.Filter;

/**
 * @author cheshta
 *
 */
public interface TagRepository {

	/**
	 * @param tagName
	 * @param roamType
	 * @return
	 */
	boolean isExistingTag(String tagName, String roamType);

	/**
	 * @param filter
	 * @param tagName
	 * @param roamType
	 * @param startDateRange
	 * @param endDateRange
	 * @param filterLabels
	 * @param filterJson
	 * @param campaignFrequency
	 * @param projectedUsageMo
	 * @param projectedUsageMt
	 * @param projectedUsageData
	 * @return
	 */
	Map<String, String> saveTag(Filter filter, String tagName, String tagType,
			String roamType, String startDateRange, String endDateRange,
			String filterLabels, String filterString, int campaignFrequency,
			String projectedUsageMo, String projectedUsageMt,
			String projectedUsageData) throws RADataAccessException;

	/**
	 * @param roamType
	 * @return
	 * @throws RADataAccessException 
	 */
	Map<String, List<Map<String, String>>> getAllTags(String roamType, String ids) throws RADataAccessException;

}
