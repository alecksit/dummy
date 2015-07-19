/**
 * 
 */
package com.advaizer.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.advaizer.common.PredictionQueryBuilder;
import com.advaizer.common.RAConstants;
import com.advaizer.common.RAPropertyUtil;
import com.advaizer.enums.Propensity;
import com.advaizer.enums.PropensityValue;
import com.advaizer.model.Filter;
import com.advaizer.model.TravelPrediction;

/**
 * @author smruti
 *
 */
@Repository
public class PredictionRepositoryImpl implements PredictionRepository {

	private static Logger LOGGER = LogManager.getLogger(PredictionRepositoryImpl.class.getName());
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate prestoJdbcTempate;
	
	
	@Override
	public List<TravelPrediction> getBeforeTravelStatisticsData(final Filter filter,
			final String roamType) {
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		final StringBuilder query = new StringBuilder();
		PredictionQueryBuilder.populateQueryForBeforeTravel(filter,query,parameterMap, roamType);
		LOGGER.debug(query.toString());
		
		
		
		final List<TravelPrediction> travelPredictionList= prestoJdbcTempate.query(query.toString(), new RowMapper<TravelPrediction>() {

			@Override
			public TravelPrediction mapRow(final ResultSet rs, final int rowNum) throws SQLException {
				
				final TravelPrediction travelPrediction = new TravelPrediction();
				if(rs.getInt("probablitygroup")==0)
				{
					travelPrediction.setConfidenceLow(rs.getInt("roamercount"));
					
				}else if(rs.getInt("probablitygroup")==1)
				{
					travelPrediction.setConfidenceMedium(rs.getInt("roamercount"));
					
				}else if(rs.getInt("probablitygroup")==2)
				{
					travelPrediction.setConfidenceHigh(rs.getInt("roamercount"));
				}
				
				return travelPrediction;
			}
		});
		
		
		query.setLength(0);
		PredictionQueryBuilder.populateQueryForBeforeTravelImsi(filter,query,parameterMap, roamType);
		final Set<Long> BeforeTravelImsiSet = new HashSet<Long>();
		
		final Map<Propensity, Integer> propensityDensityMap = new HashMap<Propensity, Integer>();
		propensityDensityMap.put(Propensity.SEAMLESS, 0);
		propensityDensityMap.put(Propensity.VOIP, 0);
		propensityDensityMap.put(Propensity.ROAMING_PACK, 0);

		
		final Map<Integer, Integer> propensityMap = new HashMap<Integer, Integer>();
		
		if(travelPredictionList.size()>0){
		travelPredictionList.get(0).setExpectedUsageMoMin(100000000);
		travelPredictionList.get(0).setExpectedUsageMtMin( 100000000);
		travelPredictionList.get(0).setExpectedUsageDataMin(100000000);
		travelPredictionList.get(0).setTravelDurationMin(100000000);
		}
		
		
		try {
	
			prestoJdbcTempate.query(query.toString(), new RowMapper<Long>() {
				@Override
				public Long mapRow(final ResultSet rs, final int rowNum) throws SQLException {
					
					final Long imsi = rs.getLong("imsi");
					
					BeforeTravelImsiSet.add(imsi);
					return null;
				}
			});
		
			final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			final long currentTime=cal.getTimeInMillis()/1000;
			cal.add(Calendar.DAY_OF_YEAR, -7);
			final long sevenDaysAgo = cal.getTimeInMillis()/1000;
			
			query.setLength(0);
				final String expectedUsageQuery = PredictionQueryBuilder.queryForExpectedUsageBeforeUpon(roamType,
						sevenDaysAgo, currentTime, filter,"BeforeTravel" );
				
				LOGGER.debug("Expected Usage query : " + expectedUsageQuery);
				prestoJdbcTempate.query(expectedUsageQuery, new RowMapper<Long>() {
					@Override
					public Long mapRow(final ResultSet rs, final int rowNum) throws SQLException {
						final int propensity = rs.getInt("propensity");
						final int propensitycount = rs.getInt("propensitycount");
						
						final Integer previousCount = propensityMap.get(propensity);
						propensityMap.put(propensity, previousCount == null ? propensitycount : previousCount + propensitycount);
						
						final int momin = rs.getInt("expectedusagemomin");
						final int momax = rs.getInt("expectedusagemomax");
						final int mtmin = rs.getInt("expectedusagemtmin");
						final int mtmax = rs.getInt("expectedusagemtmax");
						final double datamin = rs.getDouble("expectedusagedatamin");
						final double datamax= rs.getDouble("expectedusagedatamax");
						
						travelPredictionList.get(0).setExpectedUsageMoMin( Math.min(travelPredictionList.get(0).getExpectedUsageMoMin(), momin));
						travelPredictionList.get(0).setExpectedUsageMoMax( Math.min(travelPredictionList.get(0).getExpectedUsageMoMax(), momax));
						travelPredictionList.get(0).setExpectedUsageMtMin( Math.min(travelPredictionList.get(0).getExpectedUsageMtMin(), mtmin));
						travelPredictionList.get(0).setExpectedUsageMtMax( Math.min(travelPredictionList.get(0).getExpectedUsageMtMax(), mtmax));						
						travelPredictionList.get(0).setExpectedUsageDataMin((long) Math.min(travelPredictionList.get(0).getExpectedUsageDataMin(), datamin));
						travelPredictionList.get(0).setExpectedUsageDataMin((long) Math.min(travelPredictionList.get(0).getExpectedUsageDataMin(), datamax));
						
						
						return null;
					}
				});
				
				query.setLength(0);
				final String upsellTravellDurationQuery = PredictionQueryBuilder.queryForUpsellTravellDuration(roamType,
						sevenDaysAgo, currentTime, filter,"BeforeTravel" );
				
				LOGGER.debug("upsell travelduration query : " + upsellTravellDurationQuery);
				
				prestoJdbcTempate.query(upsellTravellDurationQuery, new RowMapper<Long>() {
					@Override
					public Long mapRow(final ResultSet rs, final int rowNum) throws SQLException {
						
						travelPredictionList.get(0).setUpSellPotentialData(Math.round(rs.getLong("upsellpotentialdata")/BeforeTravelImsiSet.size()));
						travelPredictionList.get(0).setUpSellPotentialMo(Math.round(rs.getLong("upsellpotentialmo")/BeforeTravelImsiSet.size()));
						travelPredictionList.get(0).setUpSellPotentialMt(Math.round(rs.getLong("upsellpotentialmt")/BeforeTravelImsiSet.size()));
						
						travelPredictionList.get(0).setTravelDurationAvg(rs.getInt("traveldurationavg"));
						travelPredictionList.get(0).setTravelDurationMax(rs.getInt("traveldurationmax"));
						travelPredictionList.get(0).setTravelDurationMin(rs.getInt("traveldurationmin"));
						
						return null;
					}
				});
				
			
		}	catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting tagged subscriber data ", dae);
		}
		
		if(travelPredictionList.size()>0){
		travelPredictionList.get(0).setExpectedUsageMoMin(travelPredictionList.get(0).getExpectedUsageDataMin()==100000000 ? 0 : travelPredictionList.get(0).getExpectedUsageDataMin());
		travelPredictionList.get(0).setExpectedUsageMtMin(travelPredictionList.get(0).getExpectedUsageMtMin()==100000000 ? 0 : travelPredictionList.get(0).getExpectedUsageMtMin());
		travelPredictionList.get(0).setExpectedUsageDataMin(travelPredictionList.get(0).getExpectedUsageDataMin()==100000000 ? 0 : travelPredictionList.get(0).getExpectedUsageDataMin());
		travelPredictionList.get(0).setTravelDurationMin(travelPredictionList.get(0).getTravelDurationMin()==100000000 ? 0 : travelPredictionList.get(0).getTravelDurationMin());
		}
		
		
		for (final Integer propensity: propensityMap.keySet()) {
			final Integer propensityCount = propensityMap.get(propensity);
			if (propensityCount != null) {
				for (int i=2; i >= 0; i--) {
					final int bit = (propensityCount >> i) & 1;
					final Propensity p = Propensity.of(i);
					propensityDensityMap.put(p, propensityDensityMap.get(p) + bit * propensityCount);
				}
			}
		}
		if(travelPredictionList.size()>0){
		travelPredictionList.get(0).setPropensityCallback(getPropensityLabel(propensityDensityMap.get(Propensity.SEAMLESS)));
		travelPredictionList.get(0).setPropensityRoamingPacks(getPropensityLabel(propensityDensityMap.get(Propensity.ROAMING_PACK)));
		travelPredictionList.get(0).setPropensityVoip(getPropensityLabel(propensityDensityMap.get(Propensity.VOIP)));
		}
			LOGGER.debug("Targeted ISMI List : " + BeforeTravelImsiSet);
			
			
		
		return travelPredictionList;
	}
	
	@Override
	public List<TravelPrediction> getUponLandingStatisticsData(final Filter filter,
			final String roamType) {
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		final StringBuilder query = new StringBuilder();
		PredictionQueryBuilder.populateQueryForUponLanding(filter,query,parameterMap, roamType);
		LOGGER.debug(query.toString());

		final List<TravelPrediction> travelPredictionList= prestoJdbcTempate.query(query.toString(), new RowMapper<TravelPrediction>() {

			@Override
			public TravelPrediction mapRow(final ResultSet rs, final int rowNum) throws SQLException {
				
				final TravelPrediction travelPrediction = new TravelPrediction();
				travelPrediction.setSubscriberCount(rs.getInt("roamercount"));
				return travelPrediction;
			}
		});
		
		
		query.setLength(0);

		PredictionQueryBuilder.populateQueryForUponLandingImsi(filter,query,parameterMap, roamType);
		final Set<Long> uponLandingImsiSet = new HashSet<Long>();
		
		final Map<Propensity, Integer> propensityDensityMap = new HashMap<Propensity, Integer>();
		propensityDensityMap.put(Propensity.SEAMLESS, 0);
		propensityDensityMap.put(Propensity.VOIP, 0);
		propensityDensityMap.put(Propensity.ROAMING_PACK, 0);

		
		final Map<Integer, Integer> propensityMap = new HashMap<Integer, Integer>();
		if(travelPredictionList.size()>0){
		travelPredictionList.get(0).setExpectedUsageMoMin(100000000);
		travelPredictionList.get(0).setExpectedUsageMtMin( 100000000);
		travelPredictionList.get(0).setExpectedUsageDataMin(100000000);
		travelPredictionList.get(0).setTravelDurationMin(100000000);
		}
		
		try {
	
			prestoJdbcTempate.query(query.toString(), new RowMapper<Long>() {
				@Override
				public Long mapRow(final ResultSet rs, final int rowNum) throws SQLException {
					
					final Long imsi = rs.getLong("imsi");
					
					uponLandingImsiSet.add(imsi);
					return null;
				}
			});
		
			final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			final long currentTime=cal.getTimeInMillis()/1000;
			cal.add(Calendar.DAY_OF_YEAR, -7);
			final long sevenDaysAgo = cal.getTimeInMillis()/1000;
			query.setLength(0);
				final String expectedUsageQuery = PredictionQueryBuilder.queryForExpectedUsageBeforeUpon(roamType,
						sevenDaysAgo, currentTime, filter,"UponLanding" );
				
				LOGGER.debug("Expected Usage query : " + expectedUsageQuery);
				prestoJdbcTempate.query(expectedUsageQuery, new RowMapper<Long>() {
					@Override
					public Long mapRow(final ResultSet rs, final int rowNum) throws SQLException {
						final int propensity = rs.getInt("propensity");
						final int propensitycount = rs.getInt("propensitycount");
						
						final Integer previousCount = propensityMap.get(propensity);
						propensityMap.put(propensity, previousCount == null ? propensitycount : previousCount + propensitycount);
						
						final int momin = rs.getInt("expectedusagemomin");
						final int momax = rs.getInt("expectedusagemomax");
						final int mtmin = rs.getInt("expectedusagemtmin");
						final int mtmax = rs.getInt("expectedusagemtmax");
						final double datamin = rs.getDouble("expectedusagedatamin");
						final double datamax= rs.getDouble("expectedusagedatamax");
						
						travelPredictionList.get(0).setExpectedUsageMoMin( Math.min(travelPredictionList.get(0).getExpectedUsageMoMin(), momin));
						travelPredictionList.get(0).setExpectedUsageMoMax( Math.min(travelPredictionList.get(0).getExpectedUsageMoMax(), momax));
						travelPredictionList.get(0).setExpectedUsageMtMin( Math.min(travelPredictionList.get(0).getExpectedUsageMtMin(), mtmin));
						travelPredictionList.get(0).setExpectedUsageMtMax( Math.min(travelPredictionList.get(0).getExpectedUsageMtMax(), mtmax));						
						travelPredictionList.get(0).setExpectedUsageDataMin((long) Math.min(travelPredictionList.get(0).getExpectedUsageDataMin(), datamin));
						travelPredictionList.get(0).setExpectedUsageDataMin((long) Math.min(travelPredictionList.get(0).getExpectedUsageDataMin(), datamax));
						
						
						
						return null;
					}
				});
				
				
				query.setLength(0);
				final String upsellTravellDurationQuery = PredictionQueryBuilder.queryForUpsellTravellDuration(roamType,
						sevenDaysAgo, currentTime, filter,"BeforeTravel" );
				
				LOGGER.debug("upsell travelduration query : " + upsellTravellDurationQuery);
				
				prestoJdbcTempate.query(upsellTravellDurationQuery, new RowMapper<Long>() {
					@Override
					public Long mapRow(final ResultSet rs, final int rowNum) throws SQLException {
						
						travelPredictionList.get(0).setUpSellPotentialData(Math.round(rs.getLong("upsellpotentialdata")/uponLandingImsiSet.size()));
						travelPredictionList.get(0).setUpSellPotentialMo(Math.round(rs.getLong("upsellpotentialmo")/uponLandingImsiSet.size()));
						travelPredictionList.get(0).setUpSellPotentialMt(Math.round(rs.getLong("upsellpotentialmt")/uponLandingImsiSet.size()));
						
						travelPredictionList.get(0).setTravelDurationAvg(rs.getInt("traveldurationavg"));
						travelPredictionList.get(0).setTravelDurationMax(rs.getInt("traveldurationmax"));
						travelPredictionList.get(0).setTravelDurationMin(rs.getInt("traveldurationmin"));
						
						return null;
					}
				});
			
		}	catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting tagged subscriber data ", dae);
		}
		if(travelPredictionList.size()>0){
		travelPredictionList.get(0).setExpectedUsageMoMin(travelPredictionList.get(0).getExpectedUsageDataMin()==100000000 ? 0 : travelPredictionList.get(0).getExpectedUsageDataMin());
		travelPredictionList.get(0).setExpectedUsageMtMin(travelPredictionList.get(0).getExpectedUsageMtMin()==100000000 ? 0 : travelPredictionList.get(0).getExpectedUsageMtMin());
		travelPredictionList.get(0).setExpectedUsageDataMin(travelPredictionList.get(0).getExpectedUsageDataMin()==100000000 ? 0 : travelPredictionList.get(0).getExpectedUsageDataMin());
		travelPredictionList.get(0).setTravelDurationMin(travelPredictionList.get(0).getTravelDurationMin()==100000000 ? 0 : travelPredictionList.get(0).getTravelDurationMin());
		}
		
		
		for (final Integer propensity: propensityMap.keySet()) {
			final Integer propensityCount = propensityMap.get(propensity);
			if (propensityCount != null) {
				for (int i=2; i >= 0; i--) {
					final int bit = (propensityCount >> i) & 1;
					final Propensity p = Propensity.of(i);
					propensityDensityMap.put(p, propensityDensityMap.get(p) + bit * propensityCount);
				}
			}
		}
		if(travelPredictionList.size()>0){
		travelPredictionList.get(0).setPropensityCallback(getPropensityLabel(propensityDensityMap.get(Propensity.SEAMLESS)));
		travelPredictionList.get(0).setPropensityRoamingPacks(getPropensityLabel(propensityDensityMap.get(Propensity.ROAMING_PACK)));
		travelPredictionList.get(0).setPropensityVoip(getPropensityLabel(propensityDensityMap.get(Propensity.VOIP)));
		}
			LOGGER.debug("Targeted ISMI List : " + uponLandingImsiSet);
			
			
		
		return travelPredictionList;
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.PredictionRepository#getTagSubscriberData(com.mobileum.roameranalytics.model.Filter, long, long, long, long)
	 */
	@Override
	public Map<String, Object> getTagSubscriberData(final Filter filter,final long tagId,
			final long campaignStartTime, final long campaignEndTime,
			final long monitoringStartTime, final long monitoringEndTime,final String roamType, final String tagType) {
		
		final Set<Long> targetedImsiSet = new HashSet<Long>();
		final List<Long> adoptedImsiSet = new ArrayList<Long>();
		final Map<String, Object> result = new HashMap<String, Object>();
		result.put("targeted", 0L);
		result.put("adopted", 0L);
		result.put("travelled", 0L);
		result.put("segment", 0L);
		
		result.put("actualMo", 0L);
		result.put("actualMt", 0L);
		result.put("actualData", 0D);
		
		result.put("expectedMoMin", null);
		result.put("expectedMtMin", null);
		result.put("expectedDataMin", null);
		
		result.put("expectedMoMax", 0L);
		result.put("expectedMtMax", 0L);
		result.put("expectedDataMax", 0D);
		
		result.put("maxExpTrvDuration", 0L);
		result.put("minExpTrvDuration", null);
		result.put("avgExpTrvDuration", 0D);
		
		result.put("maxTrvDuration", 0L);
		result.put("minTrvDuration", null);
		result.put("avgTrvDuration", 0D);
		
		
		result.put("expectedSeamless", PropensityValue.LOW.getDisplayName());
		result.put("expectedVoip", PropensityValue.LOW.getDisplayName());
		result.put("expectedRoamingPacks", PropensityValue.LOW.getDisplayName());
		
		final Map<Propensity, Integer> propensityDensityMap = new HashMap<Propensity, Integer>();
		propensityDensityMap.put(Propensity.SEAMLESS, 0);
		propensityDensityMap.put(Propensity.VOIP, 0);
		propensityDensityMap.put(Propensity.ROAMING_PACK, 0);

		
		final Map<Integer, Integer> propensityMap = new HashMap<Integer, Integer>();
		
		final String taggedSubscriberQuery = PredictionQueryBuilder.queryForTagedSubscriber(roamType, tagId, 
				campaignStartTime, campaignEndTime);
		final String traveledSubscriberQuery = PredictionQueryBuilder.queryForTraveledSubscriber(roamType,
				monitoringStartTime, monitoringEndTime, filter, tagType);
		
		try {
			LOGGER.debug("Tagged Subscriber query : " + taggedSubscriberQuery);
			jdbcTemplate.query(taggedSubscriberQuery, new RowMapper<Long>() {
				@Override
				public Long mapRow(final ResultSet rs, final int rowNum) throws SQLException {
					
					final Long imsi = rs.getLong("imsi");
					final int targeted = rs.getInt("targeted");
					final int adopted = rs.getInt("adopted");
					targetedImsiSet.add(imsi);
					if (targeted > 0) {
						result.put("targeted", 1 + (Long)result.get("targeted"));
					}
					if (targeted > 0 && adopted == 1) {
						result.put("adopted", 1 + (Long)result.get("adopted"));
						adoptedImsiSet.add(imsi);
					}
					return null;
				}
			});
		
			LOGGER.debug("Targeted ISMI List : " + targetedImsiSet);
			LOGGER.debug("Adopted ISMI List : " + adoptedImsiSet);
			
			result.put("segment", targetedImsiSet.size());
			
			LOGGER.debug("Traveled Subscriber query : " + traveledSubscriberQuery);
			prestoJdbcTempate.query(traveledSubscriberQuery, new RowMapper<Long>() {
				@Override
				public Long mapRow(final ResultSet rs, final int rowNum) throws SQLException {
					final Long imsi = rs.getLong("imsi");
					result.put("travelled", 1 + (Long)result.get("travelled") );
					if (targetedImsiSet.contains(imsi)) {
						final int mo = rs.getInt("mocallminutes");
						final int mt = rs.getInt("mtcallminutes");
						final double data = rs.getDouble("datausage");
						final long traveldurationmin = rs.getLong("traveldurationmin");
						final long traveldurationmax = rs.getLong("traveldurationmax");
						final long traveldurationavg = rs.getLong("traveldurationavg");
						
						result.put("actualMo", mo + (Long)result.get("actualMo"));
						result.put("actualMt", mt + (Long)result.get("actualMt"));
						result.put("actualData", data + (Double)result.get("actualData"));
						
						result.put("maxTrvDuration", Math.max((Long)result.get("maxTrvDuration") , traveldurationmax));
						result.put("minTrvDuration", result.get("minTrvDuration") == null ? traveldurationmin :
							Math.min((Long)result.get("minTrvDuration") , traveldurationmin));
						result.put("avgTrvDuration", ((Double)result.get("avgTrvDuration") + traveldurationavg)/2);
						
					}
					return null;
				}
			});
			
			
			
			if (!RAConstants.ON_RETURN.equalsIgnoreCase(tagType)) {
				
				final int buckets = adoptedImsiSet.size()/RAConstants.IN_CLAUSE_THRESHOLD;
				final int remaining = adoptedImsiSet.size()%RAConstants.IN_CLAUSE_THRESHOLD;
				List<Long> adoptedList;
				int i;
				for (i = 1; i <= buckets; i++) {
					adoptedList = adoptedImsiSet.subList((i-1) * RAConstants.IN_CLAUSE_THRESHOLD,
							i * RAConstants.IN_CLAUSE_THRESHOLD);
					
					if (adoptedList != null) {
						populateExpectedUsage(filter, monitoringStartTime,
								monitoringEndTime, roamType, tagType, result,
								propensityMap, adoptedList);
					}
				}
				
				if (remaining > 0) {
					adoptedList = adoptedImsiSet.subList((i-1) * RAConstants.IN_CLAUSE_THRESHOLD, adoptedImsiSet.size());
				}
			}
		}	catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting tagged subscriber data ", dae);
		}
		
		
		result.put("expectedMoMin", result.get("expectedMoMin") == null ? 0L : result.get("expectedMoMin"));
		result.put("expectedMtMin", result.get("expectedMtMin") == null ? 0L :result.get("expectedMtMin"));
		result.put("expectedDataMin", result.get("expectedDataMin") == null ? 0D : result.get("expectedDataMin"));
		
		result.put("minTrvDuration", result.get("minTrvDuration") == null ? 0L :result.get("minTrvDuration"));
		result.put("minExpTrvDuration", result.get("minExpTrvDuration") == null ? 0 : result.get("minExpTrvDuration"));
		
		result.put("maxTrvDuration", (Long)result.get("maxTrvDuration") / RAConstants.SECONDS_IN_A_DAY);
		result.put("minTrvDuration", (Long)result.get("minTrvDuration") / RAConstants.SECONDS_IN_A_DAY);
		result.put("avgTrvDuration", Math.round((Double)result.get("avgTrvDuration")/ RAConstants.SECONDS_IN_A_DAY));
		
		
		for (final Integer propensity: propensityMap.keySet()) {
			final Integer propensityCount = propensityMap.get(propensity);
			if (propensityCount != null) {
				for (int i=2; i >= 0; i--) {
					final int bit = (propensityCount >> i) & 1;
					final Propensity p = Propensity.of(i+1);
					propensityDensityMap.put(p, propensityDensityMap.get(p) + bit * propensityCount);
				}
			}
		}
		
		result.put("expectedSeamless", getPropensityLabel(propensityDensityMap.get(Propensity.SEAMLESS)));
		result.put("expectedVoip", getPropensityLabel(propensityDensityMap.get(Propensity.VOIP)));
		result.put("expectedRoamingPacks", getPropensityLabel(propensityDensityMap.get(Propensity.ROAMING_PACK)));
		
		
		LOGGER.debug("Tagged Subscriber Data for tag Id " + tagId + " : " + result);
		return result;
	}

	/**
	 * @param filter
	 * @param monitoringStartTime
	 * @param monitoringEndTime
	 * @param roamType
	 * @param tagType
	 * @param result
	 * @param propensityMap
	 * @param adoptedList
	 */
	private void populateExpectedUsage(final Filter filter,
			final long monitoringStartTime, final long monitoringEndTime,
			final String roamType, final String tagType,
			final Map<String, Object> result,
			final Map<Integer, Integer> propensityMap,
			final List<Long> adoptedList) {
		final String expectedUsageQuery = PredictionQueryBuilder.queryForExpectedUsage(roamType,
				monitoringStartTime, monitoringEndTime, filter,adoptedList,tagType );
		
		LOGGER.debug("Expected Usage query : " + expectedUsageQuery);
		prestoJdbcTempate.query(expectedUsageQuery, new RowMapper<Long>() {
			@Override
			public Long mapRow(final ResultSet rs, final int rowNum) throws SQLException {
				final int propensity = rs.getInt("propensity");
				final int propensitycount = rs.getInt("propensitycount");
				
				final Integer previousCount = propensityMap.get(propensity);
				propensityMap.put(propensity, previousCount == null ? propensitycount : previousCount + propensitycount);
				
				final int momin = rs.getInt("expectedusagemomin");
				final int momax = rs.getInt("expectedusagemomax");
				final int mtmin = rs.getInt("expectedusagemtmin");
				final int mtmax = rs.getInt("expectedusagemtmax");
				final double datamin = rs.getDouble("expectedusagedatamin");
				final double datamax= rs.getDouble("expectedusagedatamax");
				
				final int maxExpTrvDuration = rs.getInt("maxExpTrvDuration");
				final int minExpTrvDuration = rs.getInt("minExpTrvDuration");
				final double avgExpTrvDuration = rs.getInt("avgExpTrvDuration");
				
				result.put("expectedMoMin", result.get("expectedMoMin") == null ? momin :
					Math.min((Long)result.get("expectedMoMin"), momin));
				
				result.put("expectedMoMax", Math.max((Long)result.get("expectedMoMax") , momax));
				
				result.put("expectedMtMin", result.get("expectedMtMin") == null ? mtmin :
					Math.min((Long)result.get("expectedMtMin") , mtmin));
				
				result.put("expectedMtMax", Math.max((Long)result.get("expectedMtMax") , mtmax));
				
				result.put("expectedDataMin", result.get("expectedDataMin") == null ? 
						datamin : Math.min((Double)result.get("expectedDataMin") , datamin));
				
				result.put("expectedDataMax", Math.max((Double)result.get("expectedDataMax") , datamax));
				
				result.put("maxExpTrvDuration", Math.max((Long)result.get("maxExpTrvDuration") , maxExpTrvDuration));
				
				result.put("minExpTrvDuration", result.get("minExpTrvDuration") == null ? minExpTrvDuration :
					Math.min((Long)result.get("minExpTrvDuration") , minExpTrvDuration));
				
				result.put("avgExpTrvDuration", ((Double)result.get("avgExpTrvDuration") + avgExpTrvDuration)/2);
				return null;
			}
		});
	}
	
	private String getPropensityLabel(final int count) {
		final int lowThreshold = Integer.parseInt(RAPropertyUtil.getProperty("low.propensity.threshold"));
		final int highThreshold = Integer.parseInt(RAPropertyUtil.getProperty("high.propensity.threshold"));
		
		if (count <= lowThreshold) return PropensityValue.LOW.getDisplayName();
		else if (count > lowThreshold && count <= highThreshold) return PropensityValue.MEDIUM.getDisplayName();
		else  return PropensityValue.HIGH.getDisplayName();
	}
}
