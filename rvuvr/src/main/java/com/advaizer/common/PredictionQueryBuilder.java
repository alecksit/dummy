/**
 * 
 */
package com.advaizer.common;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.advaizer.enums.Relation;
import com.advaizer.enums.RoamType;
import com.advaizer.model.Filter;

/**
 * @author smruti
 *
 */
public class PredictionQueryBuilder {
	
	/**
	 * Populates query for trends chart.
	 *
	 * @param filter - filters selected
	 * @param query the query to be populated 
	 * @param parameterMap the parameter map - will have parameter and its value used in query
	 * @throws ClassNotFoundException 
	 */
	public static void populateQueryForBeforeTravel(final Filter filter, final StringBuilder query, 
			final Map<String, Object> parameterMap, final String roamType)  {
		
		final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		final long currentTime=cal.getTimeInMillis()/1000;
		cal.add(Calendar.DAY_OF_YEAR, -7);
		final long sevenDaysAgo = cal.getTimeInMillis()/1000;
		
		query.append("select probablitygroup probablitygroup, count(distinct imsi) roamercount from ");
		query.append(RAPropertyUtil.getProperty("out.table.travelprediction") );
		query.append(" trip ");
		
		query.append(" where trip.predictiontime >= ").append(sevenDaysAgo)
			.append(" and trip.predictiontime <= ").append(currentTime);
		
		
		final Map<String,String> filterParameters = filter.getSelectedAttributes();
		StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
			
		query.append(" group by trip.probablitygroup");
		
		
	}
	
	
	public static void populateQueryForBeforeTravelImsi(final Filter filter, final StringBuilder query, 
			final Map<String, Object> parameterMap, final String roamType)  {
		
		final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		final long currentTime=cal.getTimeInMillis()/1000;
		cal.add(Calendar.DAY_OF_YEAR, -7);
		final long sevenDaysAgo = cal.getTimeInMillis()/1000;
		
		query.append("select distinct imsi from ");
		query.append(RAPropertyUtil.getProperty("out.table.travelprediction") );
		query.append(" trip ");
		
		query.append(" where trip.predictiontime >= ").append(sevenDaysAgo)
			.append(" and trip.predictiontime <= ").append(currentTime);
		
		
		final Map<String,String> filterParameters = filter.getSelectedAttributes();
		StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
			
		
		
		
	}
	
	public static String queryForTagedSubscriber(final String roamType,final long tagId, final long campaignStartTime, 
			final long campaignEndTime) {
		final StringBuilder query = new StringBuilder();
		query.append("select tagId, imsi, targeted, adopted from ");
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append(Relation.ROAMERCAMPAIGNTRACKEROUT);
		} else {
			query.append(Relation.ROAMERCAMPAIGNTRACKERIN);
		}
		query.append(" where tagId = ").append(tagId)
			.append(" and campaigntime >= ").append(campaignStartTime)
			.append(" and campaigntime <= ").append(campaignEndTime);
		System.out.println(query.toString());
		return query.toString();
	}
	
	public static String queryForExpectedUsage(final String roamType, final long monitoringStartTime, 
			final long monitoringEndTime, final Filter filter, final List<Long> adoptedImsi, final String tagType) {
		final StringBuilder query = new StringBuilder();
		query.append("select expectedpropensity propensity, count(expectedpropensity) propensitycount, min(expectedusagemo) expectedusagemomin, ")
			.append(" max(expectedusagemo) expectedusagemomax, min(expectedusagemt) expectedusagemtmin, ")
			.append(" max(expectedusagemt) expectedusagemtmax, min(expectedusagedata)/1048576.0 expectedusagedatamin, ")
			.append(" max(expectedusagedata)/1048576.0 expectedusagedatamax, max(expectedtravelduration) maxExpTrvDuration, ")
			.append(" min(expectedtravelduration) minExpTrvDuration, ")
			.append(" avg(expectedtravelduration) avgExpTrvDuration from ")
			.append(RAPropertyUtil.getProperty("out.table.usageprediction"))
			.append(" usagePrediction inner join ");
			if (RAConstants.BEFORE_TRAVEL.equalsIgnoreCase(tagType)) {
				query.append(RAPropertyUtil.getProperty("out.table.travelprediction"))
					.append(" travelPrediction on  usagePrediction.imsi = travelPrediction.imsi ")
					.append(" and usagePrediction.visitedcountry = travelPrediction.visitedcountry ")
					.append(" and usagePrediction.predictiontime = travelPrediction.predictiontime")
					.append(" where usagePrediction.predictiontime >= ").append(monitoringStartTime)
					.append(" and usagePrediction.predictiontime <= ").append(monitoringEndTime);
			} else {
				if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
					query.append(RAPropertyUtil.getProperty("out.table.tripusage"))
						.append(" trip on  usagePrediction.imsi = trip.imsi ")
						.append(" and usagePrediction.visitedcountry = trip.visitedcountry ")
						//.append(" and usagePrediction.predictiontime = trip.usagebintime")
						.append(" where usagePrediction.predictiontime >= ").append(monitoringStartTime)
						.append(" and usagePrediction.predictiontime <= ").append(monitoringEndTime);
				} else {
					query.append(RAPropertyUtil.getProperty("in.table.tripusage"))
						.append(" trip on  usagePrediction.imsi = trip.imsi ")
						.append(" and usagePrediction.visitedcountry = trip.homecountry ")
						.append(" and usagePrediction.predictiontime = trip.usagebintime")
						//.append(" where usagePrediction.predictiontime >= ").append(monitoringStartTime)
						.append(" and usagePrediction.predictiontime <= ").append(monitoringEndTime);
				}
			}
			
		if (!adoptedImsi.isEmpty()) {
			query.append(" and usagePrediction.imsi in (")
				.append(CommonUtil.convertToCommaSeparatedString(adoptedImsi)).append(")");
		}
		if (RAConstants.BEFORE_TRAVEL.equalsIgnoreCase(tagType)) {
			if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
				query.append(" and usagePrediction.visitedcountry in (select distinct visitedcountry from  ")
					.append(RAPropertyUtil.getProperty("out.table.travelprediction"))
					.append(" where predictiontime >= ").append(monitoringStartTime)
					.append(" and predictiontime <= ").append(monitoringEndTime);
				if (filter.getFilterString() != null && !filter.getFilterString().isEmpty()) {
					query.append(" and ").append(filter.getFilterString());
				}
				query.append(" ) ");
			} 
		} else {
			if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
				query.append(" and usagePrediction.visitedcountry in (select distinct visitedcountry from  ")
					.append(RAPropertyUtil.getProperty("out.table.tripusage"))
					.append(" where tripstarttime >= ").append(monitoringStartTime)
					.append(" and tripendtime <= ").append(monitoringEndTime);
				if (filter.getFilterString() != null && !filter.getFilterString().isEmpty()) {
					query.append(" and ").append(filter.getFilterString());
				}
				query.append(" ) ");
			} else {
				query.append(" and usagePrediction.visitedcountry in (select distinct homecountry from  ")
					.append(RAPropertyUtil.getProperty("in.table.tripusage"))
					.append(" where tripstarttime >= ").append(monitoringStartTime)
					.append(" and tripendtime <= ").append(monitoringEndTime);
				if (filter.getFilterString() != null && !filter.getFilterString().isEmpty()) {
					query.append(" and ").append(filter.getFilterString());
				}
				query.append(" ) ");
			}
		}

		
	
		if (filter.getFilterString() != null && !filter.getFilterString().isEmpty()) {
			query.append(" and ").append(filter.getFilterString());
		}
		query.append(" group by usagePrediction.expectedpropensity ");
		return query.toString();
	}
	
	
	public static String queryForExpectedUsageBeforeUpon(final String roamType, final long monitoringStartTime, 
			final long monitoringEndTime, final Filter filter, final String tagType) {
		final StringBuilder query = new StringBuilder();
		query.append("select expectedpropensity propensity, count(expectedpropensity) propensitycount, min(expectedusagemo) expectedusagemomin, ")
			.append(" max(expectedusagemo) expectedusagemomax, min(expectedusagemt) expectedusagemtmin, ")
			.append(" max(expectedusagemt) expectedusagemtmax, min(expectedusagedata)/1048576.0 expectedusagedatamin, ")
			.append(" max(expectedusagedata)/1048576.0 expectedusagedatamax   from ")
			.append(RAPropertyUtil.getProperty("out.table.usageprediction"))
			.append(" usagePrediction inner join ");
			if (RAConstants.BEFORE_TRAVEL.equalsIgnoreCase(tagType)) {
				query.append(RAPropertyUtil.getProperty("out.table.travelprediction"))
					.append(" travelPrediction on  usagePrediction.imsi = travelPrediction.imsi ")
					.append(" and usagePrediction.visitedcountry = travelPrediction.visitedcountry ")
					.append(" and usagePrediction.predictiontime = travelPrediction.predictiontime")
					.append(" where usagePrediction.predictiontime >= ").append(monitoringStartTime)
					.append(" and usagePrediction.predictiontime <= ").append(monitoringEndTime);
			} else {
				if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
					query.append(RAPropertyUtil.getProperty("out.table.tripusage"))
						.append(" trip on  usagePrediction.imsi = trip.imsi ")
						.append(" and usagePrediction.visitedcountry = trip.visitedcountry ")
						//.append(" and usagePrediction.predictiontime = trip.usagebintime")
						.append(" where usagePrediction.predictiontime >= ").append(monitoringStartTime)
						.append(" and usagePrediction.predictiontime <= ").append(monitoringEndTime);
				} else {
					query.append(RAPropertyUtil.getProperty("in.table.tripusage"))
						.append(" trip on  usagePrediction.imsi = trip.imsi ")
						.append(" and usagePrediction.visitedcountry = trip.homecountry ")
						//.append(" and usagePrediction.predictiontime = trip.usagebintime")
						.append(" where usagePrediction.predictiontime >= ").append(monitoringStartTime)
						.append(" and usagePrediction.predictiontime <= ").append(monitoringEndTime);
				}
			}
		
		if (RAConstants.BEFORE_TRAVEL.equalsIgnoreCase(tagType)) {
			if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
				query.append(" and usagePrediction.visitedcountry in (select distinct visitedcountry from  ")
					.append(RAPropertyUtil.getProperty("out.table.travelprediction"))
					.append(" where predictiontime >= ").append(monitoringStartTime)
					.append(" and predictiontime <= ").append(monitoringEndTime);
				if (filter.getFilterString() != null && !filter.getFilterString().isEmpty()) {
					query.append(" and ").append(filter.getFilterString());
				}
				query.append(" ) ");
			} 
		} else {
			if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
				query.append(" and usagePrediction.visitedcountry in (select distinct visitedcountry from  ")
					.append(RAPropertyUtil.getProperty("out.table.tripusage"))
					.append(" where tripstarttime >= ").append(monitoringStartTime)
					.append(" and tripendtime <= ").append(monitoringEndTime);
				if (filter.getFilterString() != null && !filter.getFilterString().isEmpty()) {
					query.append(" and ").append(filter.getFilterString());
				}
				query.append(" ) ");
			} else {
				query.append(" and usagePrediction.visitedcountry in (select distinct homecountry from  ")
					.append(RAPropertyUtil.getProperty("in.table.tripusage"))
					.append(" where tripstarttime >= ").append(monitoringStartTime)
					.append(" and tripendtime <= ").append(monitoringEndTime);
				if (filter.getFilterString() != null && !filter.getFilterString().isEmpty()) {
					query.append(" and ").append(filter.getFilterString());
				}
				query.append(" ) ");
			}
		}


	

	if (filter.getFilterString() != null && !filter.getFilterString().isEmpty()) {
		query.append(" and ").append(filter.getFilterString());
	}
	query.append(" group by usagePrediction.expectedpropensity ");
	return query.toString();
}
	
	
	
	public static String queryForUpsellTravellDuration(final String roamType, final long monitoringStartTime, 
			final long monitoringEndTime, final Filter filter,final String tagType) {
		final StringBuilder query = new StringBuilder();
		query.append("select  avg(momax) upsellpotentialmo, avg(mtmax) upsellpotentialmt, ")
			.append(" avg(datamax) upsellpotentialdata, sum(traveldurationmax) traveldurationmax,sum(traveldurationmin) traveldurationmin, ")
			.append(" sum(traveldurationavg) traveldurationavg from ");
			if (RAConstants.BEFORE_TRAVEL.equalsIgnoreCase(tagType)) {
				query.append(RAPropertyUtil.getProperty("out.table.travelprediction"));
			} else {
				if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
					query.append(RAPropertyUtil.getProperty("out.table.tripusage"));
				} else {
					query.append(RAPropertyUtil.getProperty("in.table.tripusage"));						
				}
			}
			
			query.append(" trip inner join "+RAPropertyUtil.getProperty("out.table.usagepattern")+" usagepattern ");
			query.append(" on  usagepattern.persona = trip.persona ");
			query.append(" and usagepattern.visitedcountry = trip.visitedcountry ");
			
						
			if (RAConstants.BEFORE_TRAVEL.equalsIgnoreCase(tagType)) {
			query.append(" where trip.predictiontime >= ").append(monitoringStartTime)
			.append(" and trip.predictiontime <= ").append(monitoringEndTime);
			
			}else {
		
				query.append(" where trip.tripstarttime >= ").append(monitoringStartTime)
				.append(" and trip.tripstarttime <= ").append(monitoringEndTime)
				.append(" and trip.tripendtime = 0 ");
				

				if (!filter.getSelectedCountries().isEmpty()) {
					query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
				}
				
			}
			 
			final Map<String,String> filterParameters = filter.getSelectedAttributes();
			StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
			
			return query.toString();
	}
	
	public static String queryForTraveledSubscriber(final String roamType, final long monitoringStartTime, 
			final long monitoringEndTime, final Filter filter,final String tagType) {
		final StringBuilder query = new StringBuilder();
		query.append("select imsi,  sum(trip.mocallminutes) mocallminutes, sum(trip.mtcallminutes) mtcallminutes, ")
			.append(" sum(trip.uplink + trip.downlink)/1048576.0  datausage, ")
			.append(" min(trip.tripendtime-tripstarttime) traveldurationmin, ")
			.append(" max(trip.tripendtime-tripstarttime) traveldurationmax, ")
			.append(" avg(trip.tripendtime-tripstarttime) traveldurationavg ")
			.append(" from ");
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append(RAPropertyUtil.getProperty("out.table.tripusage")).append(" trip ");
		} else {
			query.append(RAPropertyUtil.getProperty("in.table.tripusage")).append(" trip ");
		}
		if (RAConstants.ON_RETURN.equalsIgnoreCase(tagType)) {
			query.append(" where (trip.tripstarttime >= ")
				.append(monitoringStartTime).append(" and (trip.tripendtime <= ").append(monitoringEndTime)
				.append(")) ");
		} else {
			query.append(" where (trip.tripstarttime >= ")
				.append(monitoringStartTime).append(" and (trip.tripendtime = 0 or trip.tripendtime <= ")
				.append(monitoringEndTime).append(")) ");
		}
		
		if (filter.getFilterString() != null && !filter.getFilterString().isEmpty()) {
			query.append(" and ").append(filter.getFilterString());
		}
		
		query.append(" group by  trip.imsi");
		return query.toString();
	}
	
	/**
	 * Populates query for trends chart.
	 *
	 * @param filter - filters selected
	 * @param query the query to be populated 
	 * @param parameterMap the parameter map - will have parameter and its value used in query
	 * @throws ClassNotFoundException 
	 */
	public static void populateQueryForUponLanding(final Filter filter, final StringBuilder query, 
			final Map<String, Object> parameterMap, final String roamType)  {
			
		final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		final long currentTime=cal.getTimeInMillis()/1000;
		cal.add(Calendar.DAY_OF_YEAR, -7);
		final long sevenDaysAgo = cal.getTimeInMillis()/1000;
		
		query.append("select count(distinct imsi) roamercount from ");
		query.append(RoamType.OUT.getRoamType().equalsIgnoreCase(roamType) 
				? RAPropertyUtil.getProperty("out.table.tripusage") : RAPropertyUtil.getProperty("in.table.tripusage") );
		query.append(" trip ");
		
		query.append(" where trip.tripstarttime >= ").append(sevenDaysAgo)
			.append(" and trip.tripstarttime <= ").append(currentTime)
			.append(" and trip.tripendtime = 0 ");
		
		if (!filter.getSelectedCountries().isEmpty()) {
			query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
		}
		   
		//((endtime >= t1 || endtime == 0) && starttime <= t2)
		
		final Map<String,String> filterParameters = filter.getSelectedAttributes();
		StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
		
		
	}

	/**
	 * Populates query for trends chart.
	 *
	 * @param filter - filters selected
	 * @param query the query to be populated 
	 * @param parameterMap the parameter map - will have parameter and its value used in query
	 * @throws ClassNotFoundException 
	 */
	public static void populateQueryForUponLandingImsi(final Filter filter, final StringBuilder query, 
			final Map<String, Object> parameterMap, final String roamType)  {
			
		final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		final long currentTime=cal.getTimeInMillis()/1000;
		cal.add(Calendar.DAY_OF_YEAR, -7);
		final long sevenDaysAgo = cal.getTimeInMillis()/1000;
		
		query.append("select distinct imsi from ");
		query.append(RoamType.OUT.getRoamType().equalsIgnoreCase(roamType) 
				? RAPropertyUtil.getProperty("out.table.tripusage") : RAPropertyUtil.getProperty("in.table.tripusage") );
		query.append(" trip ");
		
		query.append(" where trip.tripstarttime >= ").append(sevenDaysAgo)
			.append(" and trip.tripstarttime <= ").append(currentTime)
			.append(" and trip.tripendtime = 0 ");
		
		if (!filter.getSelectedCountries().isEmpty()) {
			query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
		}
		   
		//((endtime >= t1 || endtime == 0) && starttime <= t2)
		
		final Map<String,String> filterParameters = filter.getSelectedAttributes();
		StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
		
		
	}
}
