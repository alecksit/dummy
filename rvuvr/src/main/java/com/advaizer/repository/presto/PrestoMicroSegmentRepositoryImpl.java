/**
 * 
 */
package com.advaizer.repository.presto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.advaizer.common.CommonUtil;
import com.advaizer.common.MicroSegmentQueryBuilder;
import com.advaizer.common.RAConstants;
import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.Filter;
import com.advaizer.repository.MicroSegmentRepository;

/**
 * @author sarvesh
 *
 */
@Repository
@Qualifier("prestoMetadataRepository")
public class PrestoMicroSegmentRepositoryImpl implements MicroSegmentRepository {

	/** The logger. */
	private static Logger LOGGER = LogManager.getLogger(PrestoMicroSegmentRepositoryImpl.class.getName());
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate prestoJdbcTempate;
	
	
	/** The count sort desc. */
	private static Comparator<Object[]> COUNT_SORT_DESC = new Comparator<Object[]> () {

		@Override
		public int compare(final Object[] o1, final Object[] o2) {
			return ((Double)o2[1]).compareTo((Double)o1[1]);
		}
		
	};
	
	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.MicroSegmentRepository#getMSChartData(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.util.Map, java.lang.String)
	 */
	@Override
	public Map<String, Map<String, Map<String, Double>>> getMSOverlayChartData(
			final Filter filter, final String attributeName, final String column,
			final String overlayAttribute, final String overlayColumn,
			final Map<String, String> catNameValue,
			final Map<String, String> overlayNameValue, final String roamType)
			throws RADataAccessException {
		
		final StringBuilder query = new StringBuilder();
		MicroSegmentQueryBuilder.populateQueryForMicrosegmentOverlayChart(filter, query, column, overlayColumn, roamType);
		
		LOGGER.debug("Getting microsegment chart data for attribute : " + attributeName);
		LOGGER.debug(attributeName + " query : " + query.toString());
		
		final Map<String,Map<String,Map<String,Double>>> dataMap = new HashMap<String, Map<String,Map<String,Double>>>();
		dataMap.put("roamers",new HashMap<String,Map<String,Double>>());
		dataMap.put("mt",new HashMap<String,Map<String,Double>>());
		dataMap.put("mo",new HashMap<String,Map<String,Double>>());
		dataMap.put("data",new HashMap<String,Map<String,Double>>());
		
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				
				String categoryValue = null;
				String overlayValue = null;
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {

					categoryValue = catNameValue.get(rs.getString("categoryValue"));
					if (categoryValue == null && !(RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(attributeName)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(attributeName)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(attributeName))) {
						categoryValue = "Unknown";
					} else if (RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(attributeName)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(attributeName)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(attributeName)) {
						categoryValue = rs.getString("categoryValue");
					}
					
					overlayValue = overlayNameValue.get(rs.getString("overlayValue"));
					if (overlayValue == null && !(RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(overlayAttribute))) {
						overlayValue = "Unknown";
					} else if (RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(overlayAttribute)) {
						overlayValue = rs.getString("overlayValue");
					}
					
					categoryValue = CommonUtil.normalizeString(categoryValue);
					overlayValue = CommonUtil.normalizeString(overlayValue);
					Map<String,Double> overlayRoamersMap = dataMap.get("roamers").get(categoryValue);
					if (overlayRoamersMap == null) {
						overlayRoamersMap = new HashMap<String, Double>();
						dataMap.get("roamers").put(categoryValue, overlayRoamersMap);
					}
					overlayRoamersMap.put(overlayValue, rs.getDouble("imsicount"));
					
					
					Map<String,Double> overlayMoMap = dataMap.get("mo").get(categoryValue);
					if (overlayMoMap == null) {
						overlayMoMap = new HashMap<String, Double>();
						dataMap.get("mo").put(categoryValue, overlayMoMap);
					}
					overlayMoMap.put(overlayValue, rs.getDouble("mocallminutes"));
					
					
					
					Map<String,Double> overlayMtMap = dataMap.get("mt").get(categoryValue);
					if (overlayMtMap == null) {
						overlayMtMap = new HashMap<String, Double>();
						dataMap.get("mt").put(categoryValue, overlayMtMap);
					}
					overlayMtMap.put(overlayValue, rs.getDouble("mtcallminutes"));
					
					
					Map<String,Double> overlayDataMap = dataMap.get("data").get(categoryValue);
					if (overlayDataMap == null) {
						overlayDataMap = new HashMap<String, Double>();
						dataMap.get("data").put(categoryValue, overlayDataMap);
					}
					overlayDataMap.put(overlayValue, rs.getDouble("datausage"));
					
					return null;
				}
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting "+ attributeName + " chart's data : ", dae);
			throw new RADataAccessException(dae);
		}
		
		
		LOGGER.debug(attributeName + " chart data found :" + dataMap.size());
		LOGGER.trace( attributeName + " chart data list: " + dataMap);
		return dataMap;
	}
	
	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.MicroSegmentRepository#getNetworkOverlayChartData(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.util.Map, java.lang.String)
	 */
	@Override
	public Map<String, Map<String, Map<String, Double>>> getNetworkOverlayChartData(
			final Filter filter, final String attributeName, final String column,
			final String overlayAttribute, final String overlayColumn,
			final Map<String, String> catNameValue,
			final Map<String, String> overlayNameValue, final String roamType)
			throws RADataAccessException {
		
		final StringBuilder query = new StringBuilder();
		MicroSegmentQueryBuilder.populateQueryForNetworkOverlayChart(filter, query, overlayColumn, roamType);
		
		LOGGER.debug("Getting microsegment chart data for attribute : " + attributeName);
		LOGGER.debug(attributeName + " query : " + query.toString());
		
		final Map<String,Map<String,Map<String,Double>>> dataMap = new HashMap<String, Map<String,Map<String,Double>>>();
		dataMap.put("roamers",new HashMap<String,Map<String,Double>>());
		dataMap.put("mt",new HashMap<String,Map<String,Double>>());
		dataMap.put("mo",new HashMap<String,Map<String,Double>>());
		dataMap.put("data",new HashMap<String,Map<String,Double>>());
		
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				
				String categoryValue = null;
				String overlayValue = null;
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {

					categoryValue = rs.getString("networkName");
					
					overlayValue = overlayNameValue.get(rs.getString("overlayValue"));
					if (overlayValue == null && !(RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(overlayAttribute))) {
						overlayValue = "Unknown";
					} else if (RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(overlayAttribute)) {
						overlayValue = rs.getString("overlayValue");
					}
					
					categoryValue = CommonUtil.normalizeString(categoryValue);
					overlayValue = CommonUtil.normalizeString(overlayValue);
					Map<String,Double> overlayRoamersMap = dataMap.get("roamers").get(categoryValue);
					if (overlayRoamersMap == null) {
						overlayRoamersMap = new HashMap<String, Double>();
						dataMap.get("roamers").put(categoryValue, overlayRoamersMap);
					}
					overlayRoamersMap.put(overlayValue, rs.getDouble("imsicount"));
					
					
					Map<String,Double> overlayMoMap = dataMap.get("mo").get(categoryValue);
					if (overlayMoMap == null) {
						overlayMoMap = new HashMap<String, Double>();
						dataMap.get("mo").put(categoryValue, overlayMoMap);
					}
					overlayMoMap.put(overlayValue, rs.getDouble("mocallminutes"));
					
					
					
					Map<String,Double> overlayMtMap = dataMap.get("mt").get(categoryValue);
					if (overlayMtMap == null) {
						overlayMtMap = new HashMap<String, Double>();
						dataMap.get("mt").put(categoryValue, overlayMtMap);
					}
					overlayMtMap.put(overlayValue, rs.getDouble("mtcallminutes"));
					
					
					Map<String,Double> overlayDataMap = dataMap.get("data").get(categoryValue);
					if (overlayDataMap == null) {
						overlayDataMap = new HashMap<String, Double>();
						dataMap.get("data").put(categoryValue, overlayDataMap);
					}
					overlayDataMap.put(overlayValue, rs.getDouble("datausage"));
					
					return null;
				}
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting "+ attributeName + " chart's data : ", dae);
			throw new RADataAccessException(dae);
		}
		
		
		LOGGER.debug(attributeName + " chart data found :" + dataMap.size());
		LOGGER.trace( attributeName + " chart data list: " + dataMap);
		return dataMap;
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.MicroSegmentRepository#getNetworkGroupOverlayChartData(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.util.Map, java.lang.String)
	 */
	@Override
	public Map<String, Map<String, Map<String, Double>>> getNetworkGroupOverlayChartData(
			final Filter filter, final String attributeName, final String column,
			final String overlayAttribute, final String overlayColumn,
			final Map<String, String> catNameValue,
			final Map<String, String> overlayNameValue, final String roamType)
			throws RADataAccessException {
		
		final StringBuilder query = new StringBuilder();
		MicroSegmentQueryBuilder.populateQueryForNetworkGroupOverlayChart(filter, query, overlayColumn, roamType);
		
		LOGGER.debug("Getting microsegment chart data for attribute : " + attributeName);
		LOGGER.debug(attributeName + " query : " + query.toString());
		
		final Map<String,Map<String,Map<String,Double>>> dataMap = new HashMap<String, Map<String,Map<String,Double>>>();
		dataMap.put("roamers",new HashMap<String,Map<String,Double>>());
		dataMap.put("mt",new HashMap<String,Map<String,Double>>());
		dataMap.put("mo",new HashMap<String,Map<String,Double>>());
		dataMap.put("data",new HashMap<String,Map<String,Double>>());
		
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				
				String networkGroup = null;
				String overlayValue = null;
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {

					networkGroup = rs.getString("networkGroup");
					
					final double imsicount = rs.getDouble("imsicount");
					final double mocallminutes = rs.getDouble("mocallminutes");
					final double mtcallminutes = rs.getDouble("mtcallminutes");
					final double datausage = rs.getDouble("datausage");
					
					overlayValue = overlayNameValue.get(rs.getString("overlayValue"));
					
					if (overlayValue == null && !(RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(overlayAttribute))) {
						overlayValue = "Unknown";
					} else if (RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(overlayAttribute)) {
						overlayValue = rs.getString("overlayValue");
					}
					
					networkGroup = CommonUtil.normalizeString(networkGroup);
					overlayValue = CommonUtil.normalizeString(overlayValue);
					if (networkGroup != null && !networkGroup.isEmpty() && networkGroup.contains(RAConstants.PIPE)) {
						final String[] groupArray = networkGroup.split("\\"+RAConstants.PIPE);
						for (final String groupName : groupArray) {
							Map<String,Double> overlayRoamersMap = dataMap.get("roamers").get(groupName);
							if (overlayRoamersMap == null) {
								overlayRoamersMap = new HashMap<String, Double>();
								dataMap.get("roamers").put(groupName, overlayRoamersMap);
							}
							
							final Double overlayRoamers = overlayRoamersMap.get(overlayValue);
							if (overlayRoamers != null) {
								overlayRoamersMap.put(overlayValue, overlayRoamers + imsicount);
							} else {
								overlayRoamersMap.put(overlayValue, imsicount);
							}
							
							
							Map<String,Double> overlayMoMap = dataMap.get("mo").get(groupName);
							if (overlayMoMap == null) {
								overlayMoMap = new HashMap<String, Double>();
								dataMap.get("mo").put(groupName, overlayMoMap);
							}
							
							final Double overlayMo = overlayMoMap.get(overlayValue);
							if (overlayMo != null) {
								overlayMoMap.put(overlayValue, overlayMo + mocallminutes);
							} else {
								overlayMoMap.put(overlayValue, mocallminutes);
							}
							
							
							Map<String,Double> overlayMtMap = dataMap.get("mt").get(groupName);
							if (overlayMtMap == null) {
								overlayMtMap = new HashMap<String, Double>();
								dataMap.get("mt").put(groupName, overlayMtMap);
							}
							
							final Double overlayMt = overlayMtMap.get(overlayValue);
							if (overlayMt != null) {
								overlayMtMap.put(overlayValue, overlayMt + mtcallminutes);
							} else {
								overlayMtMap.put(overlayValue, mtcallminutes);
							}
							
							
							Map<String,Double> overlayDataMap = dataMap.get("data").get(groupName);
							if (overlayDataMap == null) {
								overlayDataMap = new HashMap<String, Double>();
								dataMap.get("data").put(groupName, overlayDataMap);
							}
							
							final Double overlayData = overlayDataMap.get(overlayValue);
							if (overlayData != null) {
								overlayDataMap.put(overlayValue, overlayData + datausage);
							} else {
								overlayDataMap.put(overlayValue, datausage);
							}
						}
						
					} else {
						Map<String,Double> overlayRoamersMap = dataMap.get("roamers").get(networkGroup);
						if (overlayRoamersMap == null) {
							overlayRoamersMap = new HashMap<String, Double>();
							dataMap.get("roamers").put(networkGroup, overlayRoamersMap);
						}
						
						final Double overlayRoamers = overlayRoamersMap.get(overlayValue);
						if (overlayRoamers != null) {
							overlayRoamersMap.put(overlayValue, overlayRoamers + imsicount);
						} else {
							overlayRoamersMap.put(overlayValue, imsicount);
						}
						
						
						Map<String,Double> overlayMoMap = dataMap.get("mo").get(networkGroup);
						if (overlayMoMap == null) {
							overlayMoMap = new HashMap<String, Double>();
							dataMap.get("mo").put(networkGroup, overlayMoMap);
						}
						
						final Double overlayMo = overlayMoMap.get(overlayValue);
						if (overlayMo != null) {
							overlayMoMap.put(overlayValue, overlayMo + mocallminutes);
						} else {
							overlayMoMap.put(overlayValue, mocallminutes);
						}
						
						
						Map<String,Double> overlayMtMap = dataMap.get("mt").get(networkGroup);
						if (overlayMtMap == null) {
							overlayMtMap = new HashMap<String, Double>();
							dataMap.get("mt").put(networkGroup, overlayMtMap);
						}
						
						final Double overlayMt = overlayMtMap.get(overlayValue);
						if (overlayMt != null) {
							overlayMtMap.put(overlayValue, overlayMt + mtcallminutes);
						} else {
							overlayMtMap.put(overlayValue, mtcallminutes);
						}
						
						
						Map<String,Double> overlayDataMap = dataMap.get("data").get(networkGroup);
						if (overlayDataMap == null) {
							overlayDataMap = new HashMap<String, Double>();
							dataMap.get("data").put(networkGroup, overlayDataMap);
						}
						
						final Double overlayData = overlayDataMap.get(overlayValue);
						if (overlayData != null) {
							overlayDataMap.put(overlayValue, overlayData + datausage);
						} else {
							overlayDataMap.put(overlayValue, datausage);
						}
					}
					
					
					return null;
				}
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting "+ attributeName + " chart's data : ", dae);
			throw new RADataAccessException(dae);
		}
		
		
		LOGGER.debug(attributeName + " chart data found :" + dataMap.size());
		LOGGER.trace( attributeName + " chart data list: " + dataMap);
		return dataMap;
	}
	
	@Override
	public Map<String, Map<String, Map<String, Double>>> getOCTOverlayChartData(
			final Filter filter, final String attributeName, final String column,
			final String overlayAttribute, final String overlayColumn,
			final Map<String, String> catNameValue,
			final Map<String, String> overlayNameValue, final String roamType)
			throws RADataAccessException {
		final StringBuilder query = new StringBuilder();
		MicroSegmentQueryBuilder.populateQueryForOtherCountriesTraveledOverlayChart(filter, query, overlayColumn, roamType);
		
		LOGGER.debug("Getting microsegment chart data for attribute : " + attributeName);
		LOGGER.debug(attributeName + " query : " + query.toString());
		
		final Map<String,Map<String,Map<String,Double>>> dataMap = new HashMap<String, Map<String,Map<String,Double>>>();
		dataMap.put("roamers",new HashMap<String,Map<String,Double>>());
		dataMap.put("mt",new HashMap<String,Map<String,Double>>());
		dataMap.put("mo",new HashMap<String,Map<String,Double>>());
		dataMap.put("data",new HashMap<String,Map<String,Double>>());
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				
				String overlayValue;
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {
					
					final int bordering = rs.getInt("bordering");
					final int leisure = rs.getInt("leisure");
					final int leisurePremium = rs.getInt("leisurePremium");
					final int lowGDP = rs.getInt("lowGDP");
					
					final double imsicount = rs.getDouble("imsicount");
					final double mocallminutes = rs.getDouble("mocallminutes");
					final double mtcallminutes = rs.getDouble("mtcallminutes");
					final double datausage = rs.getDouble("datausage");
					
					overlayValue = overlayNameValue.get(rs.getString("overlayValue"));
					
					
					if (overlayValue == null && !(RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(overlayAttribute))) {
						overlayValue = "Unknown";
					} else if (RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(overlayAttribute)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(overlayAttribute)) {
						overlayValue = rs.getString("overlayValue");
					}
					
					overlayValue = CommonUtil.normalizeString(overlayValue);
					
					if (bordering > 0) {
						
						Map<String,Double> overlayRoamersMap = dataMap.get("roamers").get(RAConstants.NEIGHBOURS);
						if (overlayRoamersMap == null) {
							overlayRoamersMap = new HashMap<String, Double>();
							dataMap.get("roamers").put(RAConstants.NEIGHBOURS, overlayRoamersMap);
						}
						final Double overlayRoamers = overlayRoamersMap.get(overlayValue);
						if (overlayRoamers != null) {
							overlayRoamersMap.put(overlayValue, overlayRoamers + imsicount);
						} else {
							overlayRoamersMap.put(overlayValue, imsicount);
						}
						
						
						Map<String,Double> overlayMoMap = dataMap.get("mo").get(RAConstants.NEIGHBOURS);
						if (overlayMoMap == null) {
							overlayMoMap = new HashMap<String, Double>();
							dataMap.get("mo").put(RAConstants.NEIGHBOURS, overlayMoMap);
						}
						
						final Double overlayMo = overlayMoMap.get(overlayValue);
						if (overlayMo != null) {
							overlayMoMap.put(overlayValue, overlayMo + mocallminutes);
						} else {
							overlayMoMap.put(overlayValue, mocallminutes);
						}
						
						Map<String,Double> overlayMtMap = dataMap.get("mt").get(RAConstants.NEIGHBOURS);
						if (overlayMtMap == null) {
							overlayMtMap = new HashMap<String, Double>();
							dataMap.get("mt").put(RAConstants.NEIGHBOURS, overlayMtMap);
						}
						
						final Double overlayMt = overlayMtMap.get(overlayValue);
						if (overlayMt != null) {
							overlayMtMap.put(overlayValue, overlayMt + mtcallminutes);
						} else {
							overlayMtMap.put(overlayValue, mtcallminutes);
						}
						
						Map<String,Double> overlayDataMap = dataMap.get("data").get(RAConstants.NEIGHBOURS);
						if (overlayDataMap == null) {
							overlayDataMap = new HashMap<String, Double>();
							dataMap.get("data").put(RAConstants.NEIGHBOURS, overlayDataMap);
						}
						
						final Double overlayData = overlayDataMap.get(overlayValue);
						if (overlayData != null) {
							overlayDataMap.put(overlayValue, overlayData + datausage);
						} else {
							overlayDataMap.put(overlayValue, datausage);
						}
					}
					if (leisure > 0) {
						
						Map<String,Double> overlayRoamersMap = dataMap.get("roamers").get(RAConstants.LEISURE);
						if (overlayRoamersMap == null) {
							overlayRoamersMap = new HashMap<String, Double>();
							dataMap.get("roamers").put(RAConstants.LEISURE, overlayRoamersMap);
						}
						final Double overlayRoamers = overlayRoamersMap.get(overlayValue);
						if (overlayRoamers != null) {
							overlayRoamersMap.put(overlayValue, overlayRoamers + imsicount);
						} else {
							overlayRoamersMap.put(overlayValue, imsicount);
						}
						
						
						Map<String,Double> overlayMoMap = dataMap.get("mo").get(RAConstants.LEISURE);
						if (overlayMoMap == null) {
							overlayMoMap = new HashMap<String, Double>();
							dataMap.get("mo").put(RAConstants.LEISURE, overlayMoMap);
						}
						
						final Double overlayMo = overlayMoMap.get(overlayValue);
						if (overlayMo != null) {
							overlayMoMap.put(overlayValue, overlayMo + mocallminutes);
						} else {
							overlayMoMap.put(overlayValue, mocallminutes);
						}
						
						Map<String,Double> overlayMtMap = dataMap.get("mt").get(RAConstants.LEISURE);
						if (overlayMtMap == null) {
							overlayMtMap = new HashMap<String, Double>();
							dataMap.get("mt").put(RAConstants.LEISURE, overlayMtMap);
						}
						
						final Double overlayMt = overlayMtMap.get(overlayValue);
						if (overlayMt != null) {
							overlayMtMap.put(overlayValue, overlayMt + mtcallminutes);
						} else {
							overlayMtMap.put(overlayValue, mtcallminutes);
						}
						
						Map<String,Double> overlayDataMap = dataMap.get("data").get(RAConstants.LEISURE);
						if (overlayDataMap == null) {
							overlayDataMap = new HashMap<String, Double>();
							dataMap.get("data").put(RAConstants.LEISURE, overlayDataMap);
						}
						
						final Double overlayData = overlayDataMap.get(overlayValue);
						if (overlayData != null) {
							overlayDataMap.put(overlayValue, overlayData + datausage);
						} else {
							overlayDataMap.put(overlayValue, datausage);
						}
					}
					if (leisurePremium > 0) {
						
						Map<String,Double> overlayRoamersMap = dataMap.get("roamers").get(RAConstants.LEISURE_PREMIUM);
						if (overlayRoamersMap == null) {
							overlayRoamersMap = new HashMap<String, Double>();
							dataMap.get("roamers").put(RAConstants.LEISURE_PREMIUM, overlayRoamersMap);
						}
						final Double overlayRoamers = overlayRoamersMap.get(overlayValue);
						if (overlayRoamers != null) {
							overlayRoamersMap.put(overlayValue, overlayRoamers + imsicount);
						} else {
							overlayRoamersMap.put(overlayValue, imsicount);
						}
						
						
						Map<String,Double> overlayMoMap = dataMap.get("mo").get(RAConstants.LEISURE_PREMIUM);
						if (overlayMoMap == null) {
							overlayMoMap = new HashMap<String, Double>();
							dataMap.get("mo").put(RAConstants.LEISURE_PREMIUM, overlayMoMap);
						}
						
						final Double overlayMo = overlayMoMap.get(overlayValue);
						if (overlayMo != null) {
							overlayMoMap.put(overlayValue, overlayMo + mocallminutes);
						} else {
							overlayMoMap.put(overlayValue, mocallminutes);
						}
						
						Map<String,Double> overlayMtMap = dataMap.get("mt").get(RAConstants.LEISURE_PREMIUM);
						if (overlayMtMap == null) {
							overlayMtMap = new HashMap<String, Double>();
							dataMap.get("mt").put(RAConstants.LEISURE_PREMIUM, overlayMtMap);
						}
						
						final Double overlayMt = overlayMtMap.get(overlayValue);
						if (overlayMt != null) {
							overlayMtMap.put(overlayValue, overlayMt + mtcallminutes);
						} else {
							overlayMtMap.put(overlayValue, mtcallminutes);
						}
						
						Map<String,Double> overlayDataMap = dataMap.get("data").get(RAConstants.LEISURE_PREMIUM);
						if (overlayDataMap == null) {
							overlayDataMap = new HashMap<String, Double>();
							dataMap.get("data").put(RAConstants.LEISURE_PREMIUM, overlayDataMap);
						}
						
						final Double overlayData = overlayDataMap.get(overlayValue);
						if (overlayData != null) {
							overlayDataMap.put(overlayValue, overlayData + datausage);
						} else {
							overlayDataMap.put(overlayValue, datausage);
						}
					}
					if (lowGDP > 0) {
						
						Map<String,Double> overlayRoamersMap = dataMap.get("roamers").get(RAConstants.LOW_GDP);
						if (overlayRoamersMap == null) {
							overlayRoamersMap = new HashMap<String, Double>();
							dataMap.get("roamers").put(RAConstants.LOW_GDP, overlayRoamersMap);
						}
						final Double overlayRoamers = overlayRoamersMap.get(overlayValue);
						if (overlayRoamers != null) {
							overlayRoamersMap.put(overlayValue, overlayRoamers + imsicount);
						} else {
							overlayRoamersMap.put(overlayValue, imsicount);
						}
						
						
						Map<String,Double> overlayMoMap = dataMap.get("mo").get(RAConstants.LOW_GDP);
						if (overlayMoMap == null) {
							overlayMoMap = new HashMap<String, Double>();
							dataMap.get("mo").put(RAConstants.LOW_GDP, overlayMoMap);
						}
						
						final Double overlayMo = overlayMoMap.get(overlayValue);
						if (overlayMo != null) {
							overlayMoMap.put(overlayValue, overlayMo + mocallminutes);
						} else {
							overlayMoMap.put(overlayValue, mocallminutes);
						}
						
						Map<String,Double> overlayMtMap = dataMap.get("mt").get(RAConstants.LOW_GDP);
						if (overlayMtMap == null) {
							overlayMtMap = new HashMap<String, Double>();
							dataMap.get("mt").put(RAConstants.LOW_GDP, overlayMtMap);
						}
						
						final Double overlayMt = overlayMtMap.get(overlayValue);
						if (overlayMt != null) {
							overlayMtMap.put(overlayValue, overlayMt + mtcallminutes);
						} else {
							overlayMtMap.put(overlayValue, mtcallminutes);
						}
						
						Map<String,Double> overlayDataMap = dataMap.get("data").get(RAConstants.LOW_GDP);
						if (overlayDataMap == null) {
							overlayDataMap = new HashMap<String, Double>();
							dataMap.get("data").put(RAConstants.LOW_GDP, overlayDataMap);
						}
						
						final Double overlayData = overlayDataMap.get(overlayValue);
						if (overlayData != null) {
							overlayDataMap.put(overlayValue, overlayData + datausage);
						} else {
							overlayDataMap.put(overlayValue, datausage);
						}
						
					}
					return null;
				}
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting Other Countries traveled data in microsegment : ", dae);
			throw new RADataAccessException(dae);
		}
		
		LOGGER.debug(attributeName + " chart data found :" + dataMap.size());
		LOGGER.trace( attributeName + " chart data list: " + dataMap);
		return dataMap;
	}
	
	@Override
	public Map<String,List<Object[]>> getMSChartData(final Filter filter,final String attributeName, final String column,  
			final Map<String,String> catNameValue, final String roamType) throws RADataAccessException {
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		final StringBuilder query = new StringBuilder();
		MicroSegmentQueryBuilder.populateQueryForMicrosegmentChart(filter, query, column, parameterMap, roamType);
		
		LOGGER.debug("Getting microsegment chart data for attribute : " + attributeName);
		LOGGER.debug(attributeName + " query : " + query.toString());
		
		final Map<String,List<Object[]>> dataMap = new HashMap<String, List<Object[]>>();
		dataMap.put("roamers",new ArrayList<Object[]>());
		dataMap.put("mt",new ArrayList<Object[]>());
		dataMap.put("mo",new ArrayList<Object[]>());
		dataMap.put("data",new ArrayList<Object[]>());
		
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				
				String categoryValue = null;
				
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {

					categoryValue = catNameValue.get(rs.getString("categoryValue"));
					if (categoryValue == null && !(RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(attributeName)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(attributeName)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(attributeName))) {
						categoryValue = "Unknown";
					} else if (RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(attributeName)
							|| RAConstants.ATTR_DEVICE_TYPE.equalsIgnoreCase(attributeName)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(attributeName)) {
						categoryValue = rs.getString("categoryValue");
					}
					
					categoryValue = CommonUtil.normalizeString(categoryValue);
					
					final Object[] roamersObject = new Object[2];
					roamersObject[0] = categoryValue;
					roamersObject[1] = rs.getDouble("imsicount");
					
					final Object[] moObject = new Object[2];
					moObject[0] = categoryValue;
					moObject[1] = rs.getDouble("mocallminutes");
				
					
					final Object[] mtObject = new Object[2];
					mtObject[0] = categoryValue;
					mtObject[1] = rs.getDouble("mtcallminutes");
					
					
					final Object[] dataObject = new Object[2];
					dataObject[0] = categoryValue;
					dataObject[1] = rs.getDouble("datausage");
					
					
					dataMap.get("mt").add(mtObject);
					dataMap.get("mo").add(moObject);
					dataMap.get("roamers").add(roamersObject);
					dataMap.get("data").add(dataObject);
					
					return null;
				}
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting "+ attributeName + " chart's data : ", dae);
			throw new RADataAccessException(dae);
		}
		
		Collections.sort(dataMap.get("mo"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("mt"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("data"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("roamers"),COUNT_SORT_DESC);
		
		
		LOGGER.debug(attributeName + " chart data found :" + dataMap.size());
		LOGGER.trace( attributeName + " chart data list: " + dataMap);
		return dataMap;
	}
	

	@Override
	public Map<String,List<Object[]>> getNetworkGroupData(final Filter filter,
			final String column, final String columnType, final Map<String, String> catNameValue, final String roamType)
			throws RADataAccessException {
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		final StringBuilder query = new StringBuilder();
		MicroSegmentQueryBuilder.populateQueryForNetworkGroupChart(filter, query,parameterMap,roamType);
		
		LOGGER.debug("Getting microsegment chart data for attribute : Network Group");
		LOGGER.debug(" Network Group query : " + query.toString());
		
		
		final Map<String,List<Object[]>> dataMap = new HashMap<String, List<Object[]>>();
		dataMap.put("roamers",new ArrayList<Object[]>());
		dataMap.put("mt",new ArrayList<Object[]>());
		dataMap.put("mo",new ArrayList<Object[]>());
		dataMap.put("data",new ArrayList<Object[]>());
		
		final Map<String, Map<String, Double>> networkGroupMap = new HashMap<String, Map<String,Double>>(200);
		
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				String networkGroup = null;
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {
					
					networkGroup = rs.getString("networkGroup");
					final double imsicount = rs.getDouble("imsicount");
					final double mocallminutes = rs.getDouble("mocallminutes");
					final double mtcallminutes = rs.getDouble("mtcallminutes");
					final double datausage = rs.getDouble("datausage");
					
					networkGroup = CommonUtil.normalizeString(networkGroup);
					
					if (networkGroup != null && !networkGroup.isEmpty() && networkGroup.contains(RAConstants.PIPE)) {
						final String[] groupArray = networkGroup.split("\\"+RAConstants.PIPE);
						for (final String groupName : groupArray) {
							Map<String,Double> groupDataMap = networkGroupMap.get(groupName);
							if (groupDataMap == null) {
								groupDataMap = new HashMap<String,Double>(4);
								groupDataMap.put("roamers", 0d);
								groupDataMap.put("mt", 0d);
								groupDataMap.put("mo", 0d);
								groupDataMap.put("data", 0d);
								networkGroupMap.put(groupName, groupDataMap);
							}
							groupDataMap.put("roamers", imsicount + groupDataMap.get("roamers"));
							groupDataMap.put("mt", mtcallminutes + groupDataMap.get("mt"));
							groupDataMap.put("mo", mocallminutes + groupDataMap.get("mo"));
							groupDataMap.put("data", datausage + groupDataMap.get("data"));
						}
						
					} else {
						Map<String,Double> groupDataMap = networkGroupMap.get(networkGroup);
						if (groupDataMap == null) {
							groupDataMap = new HashMap<String,Double>(4);
							groupDataMap.put("roamers", 0d);
							groupDataMap.put("mt", 0d);
							groupDataMap.put("mo", 0d);
							groupDataMap.put("data", 0d);
							networkGroupMap.put(networkGroup, groupDataMap);
						}
						groupDataMap.put("roamers", imsicount + groupDataMap.get("roamers"));
						groupDataMap.put("mt", mtcallminutes + groupDataMap.get("mt"));
						groupDataMap.put("mo", mocallminutes + groupDataMap.get("mo"));
						groupDataMap.put("data", datausage + groupDataMap.get("data"));
					}
									
					return null;
				}
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting network group data in microsegment : ", dae);
			throw new RADataAccessException(dae);
		}
		
		for (final String group : networkGroupMap.keySet()) {
			final Object[] roamersObject = new Object[2];
			roamersObject[0] = group;
			roamersObject[1] = networkGroupMap.get(group).get("roamers");
			
			final Object[] moObject = new Object[2];
			moObject[0] = group;
			moObject[1] = networkGroupMap.get(group).get("mo");
		
			
			final Object[] mtObject = new Object[2];
			mtObject[0] = group;
			mtObject[1] = networkGroupMap.get(group).get("mt");
			
			
			final Object[] dataObject = new Object[2];
			dataObject[0] = group;
			dataObject[1] = networkGroupMap.get(group).get("data");
			
			
			dataMap.get("mt").add(mtObject);
			dataMap.get("mo").add(moObject);
			dataMap.get("roamers").add(roamersObject);
			dataMap.get("data").add(dataObject);
		}
		
		
		Collections.sort(dataMap.get("mo"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("mt"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("data"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("roamers"),COUNT_SORT_DESC);
			
		
		LOGGER.debug("Network Group data found :" + dataMap.size());
		LOGGER.trace("Network Group data :" + dataMap);
		return dataMap;
	}
	
	@Override
	public Map<String,List<Object[]>> getNetworkData(final Filter filter,
			final String column, final String columnType, final Map<String, String> catNameValue, final String roamType)
			throws RADataAccessException {
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		final StringBuilder query = new StringBuilder();
		MicroSegmentQueryBuilder.populateQueryForNetworkChart(filter, query,parameterMap,roamType);
		
		LOGGER.debug("Getting microsegment chart data for attribute : Network ");
		LOGGER.debug(" Network  query : " + query.toString());
		
		
		final Map<String,List<Object[]>> dataMap = new HashMap<String, List<Object[]>>();
		dataMap.put("roamers",new ArrayList<Object[]>());
		dataMap.put("mt",new ArrayList<Object[]>());
		dataMap.put("mo",new ArrayList<Object[]>());
		dataMap.put("data",new ArrayList<Object[]>());
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				String networkName = null;
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {
					
					networkName = rs.getString("networkName");
					networkName = CommonUtil.normalizeString(networkName);
					
					final Object[] roamersObject = new Object[2];
					roamersObject[0] = networkName;
					roamersObject[1] = rs.getDouble("imsicount");
					
					final Object[] moObject = new Object[2];
					moObject[0] = networkName;
					moObject[1] = rs.getDouble("mocallminutes");
				
					
					final Object[] mtObject = new Object[2];
					mtObject[0] = networkName;
					mtObject[1] = rs.getDouble("mtcallminutes");
					
					
					final Object[] dataObject = new Object[2];
					dataObject[0] = networkName;
					dataObject[1] = rs.getDouble("datausage");
					
					
					dataMap.get("mt").add(mtObject);
					dataMap.get("mo").add(moObject);
					dataMap.get("roamers").add(roamersObject);
					dataMap.get("data").add(dataObject);
					
					return null;
				}
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting network group data in microsegment : ", dae);
			throw new RADataAccessException(dae);
		}
		
		Collections.sort(dataMap.get("mo"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("mt"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("data"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("roamers"),COUNT_SORT_DESC);
			
		
		LOGGER.debug("Network  data found :" + dataMap.size());
		LOGGER.trace("Network  data :" + dataMap);
		return dataMap;
	}

	@Override
	public Map<String, List<Object[]>> getOtherCountriesTraveledData(
			final Filter filter, final String column, final String columnType, 
			final Map<String, String> catNameValue, final String roamType) throws RADataAccessException {
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		final StringBuilder query = new StringBuilder();
		MicroSegmentQueryBuilder.populateQueryForOtherCountriesTraveledChart(filter, query,parameterMap, roamType);
		
		final Map<String,List<Object[]>> dataMap = new HashMap<String, List<Object[]>>();
		dataMap.put("roamers",new ArrayList<Object[]>());
		dataMap.put("mt",new ArrayList<Object[]>());
		dataMap.put("mo",new ArrayList<Object[]>());
		dataMap.put("data",new ArrayList<Object[]>());
		final Map<String, Map<String,Double>> countryDataMap = new HashMap<String, Map<String,Double>>();
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {
					
					final int bordering = rs.getInt("bordering");
					final int leisure = rs.getInt("leisure");
					final int leisurePremium = rs.getInt("leisurePremium");
					final int lowGDP = rs.getInt("lowGDP");
					
					final double imsicount = rs.getDouble("imsicount");
					final double mocallminutes = rs.getDouble("mocallminutes");
					final double mtcallminutes = rs.getDouble("mtcallminutes");
					final double datausage = rs.getDouble("datausage");
					
					if (bordering > 0) {
						Map<String, Double> borderingData = countryDataMap.get(RAConstants.NEIGHBOURS);
						if (borderingData == null) {
							borderingData = new HashMap<String, Double>();
							borderingData.put("imsicount", imsicount);
							borderingData.put("mocallminutes", mocallminutes);
							borderingData.put("mtcallminutes", mtcallminutes);
							borderingData.put("datausage", datausage);
							countryDataMap.put(RAConstants.NEIGHBOURS, borderingData);
						} else {
							borderingData.put("imsicount", imsicount + borderingData.get("imsicount"));
							borderingData.put("mocallminutes", mocallminutes + borderingData.get("mocallminutes"));
							borderingData.put("mtcallminutes", mtcallminutes + borderingData.get("mtcallminutes"));
							borderingData.put("datausage", datausage + borderingData.get("datausage"));
							
						}
					}
					if (leisure > 0) {
						Map<String, Double> borderingData = countryDataMap.get(RAConstants.LEISURE);
						if (borderingData == null) {
							borderingData = new HashMap<String, Double>();
							borderingData.put("imsicount", imsicount);
							borderingData.put("mocallminutes", mocallminutes);
							borderingData.put("mtcallminutes", mtcallminutes);
							borderingData.put("datausage", datausage);
							countryDataMap.put(RAConstants.LEISURE, borderingData);
						} else {
							borderingData.put("imsicount", imsicount + borderingData.get("imsicount"));
							borderingData.put("mocallminutes", mocallminutes + borderingData.get("mocallminutes"));
							borderingData.put("mtcallminutes", mtcallminutes + borderingData.get("mtcallminutes"));
							borderingData.put("datausage", datausage + borderingData.get("datausage"));
							
						}
					}
					if (leisurePremium > 0) {
						Map<String, Double> borderingData = countryDataMap.get(RAConstants.LEISURE_PREMIUM);
						if (borderingData == null) {
							borderingData = new HashMap<String, Double>();
							borderingData.put("imsicount", imsicount);
							borderingData.put("mocallminutes", mocallminutes);
							borderingData.put("mtcallminutes", mtcallminutes);
							borderingData.put("datausage", datausage);
							countryDataMap.put(RAConstants.LEISURE_PREMIUM, borderingData);
						} else {
							borderingData.put("imsicount", imsicount + borderingData.get("imsicount"));
							borderingData.put("mocallminutes", mocallminutes + borderingData.get("mocallminutes"));
							borderingData.put("mtcallminutes", mtcallminutes + borderingData.get("mtcallminutes"));
							borderingData.put("datausage", datausage + borderingData.get("datausage"));
							
						}
					}
					if (lowGDP > 0) {
						Map<String, Double> borderingData = countryDataMap.get(RAConstants.LOW_GDP);
						if (borderingData == null) {
							borderingData = new HashMap<String, Double>();
							borderingData.put("imsicount", imsicount);
							borderingData.put("mocallminutes", mocallminutes);
							borderingData.put("mtcallminutes", mtcallminutes);
							borderingData.put("datausage", datausage);
							countryDataMap.put(RAConstants.LOW_GDP, borderingData);
						} else {
							borderingData.put("imsicount", imsicount + borderingData.get("imsicount"));
							borderingData.put("mocallminutes", mocallminutes + borderingData.get("mocallminutes"));
							borderingData.put("mtcallminutes", mtcallminutes + borderingData.get("mtcallminutes"));
							borderingData.put("datausage", datausage + borderingData.get("datausage"));
							
						}
					}
					return null;
				}
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting Other Countries traveled data in microsegment : ", dae);
			throw new RADataAccessException(dae);
		}
		
		for (final String group : countryDataMap.keySet()) {
			final Object[] roamersObject = new Object[2];
			roamersObject[0] = group;
			roamersObject[1] = countryDataMap.get(group).get("imsicount");
			
			final Object[] moObject = new Object[2];
			moObject[0] = group;
			moObject[1] = countryDataMap.get(group).get("mocallminutes");
		
			
			final Object[] mtObject = new Object[2];
			mtObject[0] = group;
			mtObject[1] = countryDataMap.get(group).get("mtcallminutes");
			
			
			final Object[] dataObject = new Object[2];
			dataObject[0] = group;
			dataObject[1] = countryDataMap.get(group).get("datausage");
			
			
			dataMap.get("mt").add(mtObject);
			dataMap.get("mo").add(moObject);
			dataMap.get("roamers").add(roamersObject);
			dataMap.get("data").add(dataObject);
		}
		
		Collections.sort(dataMap.get("mo"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("mt"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("data"),COUNT_SORT_DESC);
		Collections.sort(dataMap.get("roamers"),COUNT_SORT_DESC);
			
		
		LOGGER.debug("Other Countries traveled data found :" + dataMap.size());
		LOGGER.trace("Other Countries traveled data :" + dataMap);
		return dataMap;
	}


}
