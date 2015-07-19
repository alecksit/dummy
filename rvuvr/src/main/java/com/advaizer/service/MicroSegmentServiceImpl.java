/**
 * 
 */
package com.advaizer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.advaizer.common.RAConstants;
import com.advaizer.exception.ApplicationException;
import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.Filter;
import com.advaizer.repository.MicroSegmentRepository;

/**
 * @author sarvesh
 *
 */
@Service
public class MicroSegmentServiceImpl implements MicroSegmentService {

	@Autowired
	@Qualifier("prestoMetadataRepository")
	private MicroSegmentRepository microsegmentDao;
	
	@Override
	public Map<String, List<Object[]>> getMSChartData(final Filter filter, final String attributeName, final String column, final String columnType,
			final Map<String,String> catNameValue, final String roamType) {
		try {
			return microsegmentDao.getMSChartData(filter, attributeName, column, catNameValue, roamType);
		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}

	@Override
	public Map<String, Map<String,Map<String,Double>>> getMSChartDataForOverlay(final Filter filter,
			final String attributeName, final String column, final String overlayAttributeName,
			final String overlayAttributeColumn, final Map<String, String> catNameValue,
			final Map<String, String> overlayAttrNameValue, final String roamType) {
		try {
			return microsegmentDao.getMSOverlayChartData(filter, attributeName, column, overlayAttributeName,
					overlayAttributeColumn, catNameValue,overlayAttrNameValue, roamType);
		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}
	

	@Override
	public Map<String, Map<String, Map<String, Double>>> getNetworkDataForOverlay(
			final Filter filter, final String attributeName, final String column,
			final String overlayAttributeName, final String overlayAttributeColumn,
			final Map<String, String> catNameValue,
			final Map<String, String> overlayAttrNameValue, final String roamType) {
		
		try {
			return microsegmentDao.getNetworkOverlayChartData(filter, overlayAttributeName, overlayAttributeColumn, 
					overlayAttributeName, overlayAttributeColumn, catNameValue, overlayAttrNameValue, roamType);
		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}

	@Override
	public Map<String, Map<String, Map<String, Double>>> getNetworkGroupForOverlay(
			final Filter filter, final String attributeName, final String column,
			final String overlayAttributeName, final String overlayAttributeColumn,
			final Map<String, String> catNameValue,
			final Map<String, String> overlayAttrNameValue, final String roamType) {
		try {
			return microsegmentDao.getNetworkGroupOverlayChartData(filter, overlayAttributeName, overlayAttributeColumn, 
					overlayAttributeName, overlayAttributeColumn, catNameValue, overlayAttrNameValue, roamType);
		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}
	
	@Override
	public Map<String, Map<String, Map<String, Double>>> getOCTForOverlay(
			final Filter filter, final String attributeName, final String column,
			final String overlayAttributeName, final String overlayAttributeColumn,
			final Map<String, String> catNameValue,
			final Map<String, String> overlayAttrNameValue, final String roamType) {
		try {
			return microsegmentDao.getOCTOverlayChartData(filter, overlayAttributeName, overlayAttributeColumn, 
					overlayAttributeName, overlayAttributeColumn, catNameValue, overlayAttrNameValue, roamType);
		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}
	
	@Override
	public Map<String, List<Object[]>> getNetworkGroupData(final Filter filter,
			final String column, final String columnType, final Map<String, String> catNameValue, final String roamType) {
		try {
			return microsegmentDao.getNetworkGroupData(filter, column, columnType, catNameValue,roamType);
		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}
	
	@Override
	public Map<String, List<Object[]>> getNetworkData(final Filter filter,
			final String column, final String columnType, final Map<String, String> catNameValue, final String roamType) {
		try {
			return microsegmentDao.getNetworkData(filter, column, columnType, catNameValue,roamType);
		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.service.MicroSegmentService#getOtherCountriesTraveledData(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, List<Object[]>> getOtherCountriesTraveledData(
			final Filter filter, final String column, final String columnType, final Map<String, String> catNameValue, final String roamType) {
		try {
			return microsegmentDao.getOtherCountriesTraveledData(filter, column, columnType, catNameValue, roamType);
		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}

	
}
