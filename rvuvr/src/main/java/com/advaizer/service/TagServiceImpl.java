/**
 * 
 */
package com.advaizer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advaizer.common.RAConstants;
import com.advaizer.exception.ApplicationException;
import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.Filter;
import com.advaizer.repository.TagRepository;

/**
 * @author cheshta
 *
 */
@Service
public class TagServiceImpl implements TagService{
	
	@Autowired
	private TagRepository tagDao;
		
	private static Logger LOGGER = LogManager.getLogger(TrackerServiceImpl.class.getName());

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.service.TagService#saveTag(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, String> saveTag(final Filter filter, final String tagName, final String tagType,
			final String roamType, final String campaignStartDate, final String campaignEndDate,
			final String filterLabels, final String filterString, final int campaignFrequency,			
			final String projectedUsageMo, final String projectedUsageMt,
			final String projectedUsageData) {
		// TODO Auto-generated method stub
		
		try {
			if(!tagDao.isExistingTag(tagName, roamType)){
				return tagDao.saveTag(filter, tagName, tagType, roamType, campaignStartDate,
						campaignEndDate, filterLabels, filterString, campaignFrequency,						 
						projectedUsageMo, projectedUsageMt, projectedUsageData );
			}
			else{
				final Map<String,String> error = new HashMap<String, String>();
				error.put("error", "This tag is already existing. Please enter a different name.");
				return error;
			}
		} catch (final RADataAccessException dae) {
			LOGGER.debug("Save Tag Error: " + dae.getMessage() + " for tag name: " + tagName);
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.service.TagService#getAllTags(java.lang.String)
	 */
	@Override
	public Map<String,List<Map<String,String>>> getAllTags(final String roamType, final String ids) {
		try {			
			return tagDao.getAllTags(roamType, ids);
					
	} catch (final RADataAccessException dae) {
		LOGGER.debug("Something went wrong while fetching trackers: " + dae.getMessage());
		throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
	}
	}
	

}
