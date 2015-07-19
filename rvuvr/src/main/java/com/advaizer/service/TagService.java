/**
 * 
 */
package com.advaizer.service;

import java.util.List;
import java.util.Map;

import com.advaizer.model.Filter;

/**
 * @author cheshta
 *
 */
public interface TagService {

	/**
	 * @param filter
	 * @param tagName
	 * @param roamType
	 * @param string
	 * @param string2
	 * @param filterLabels
	 * @param filterJson
	 * @param campaignFrequency
	 * @param projectedUsageMo
	 * @param projectedUsageMt
	 * @param projectedUsageData
	 * @return
	 */
	Map<String, String> saveTag(Filter filter, String tagName, String tagType, String roamType,
			String string, String string2, String filterLabels,
			String filterString, int campaignFrequency,			
			String projectedUsageMo, String projectedUsageMt, String projectedUsageData);

	/**
	 * @param roamType
	 * @return
	 */
	Map<String, List<Map<String, String>>> getAllTags(String roamType, String ids);

}
