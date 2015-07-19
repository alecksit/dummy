/**
 * 
 */
package com.advaizer.common;

import java.util.List;
import java.util.Map;

import com.advaizer.enums.BusinessTableColumn;
import com.advaizer.enums.Relation;
import com.advaizer.enums.RoamType;
import com.advaizer.model.Filter;


/**
 * The Class QueryBuilder. Creates dynamic queries.
 *
 * @author cheshta
 */
public class TrackerQueryBuilder {

	public static void populateQueryForTrackSave(final Filter filter, final StringBuilder query,
			final Map<String, Object> parameterMap , final StringBuilder filterString, final String roamType)  {	
		query.append(" insert into ");
		if(RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)){
			query.append(Relation.TRACKEROUT);
		}
		else{
			query.append(Relation.TRACKERIN);
		}
			
			query.append(" (track_name,filter_string,start_old_timeformat,start_old_year,"
				+ "start_old_month,start_old_day,end_old_timeformat,end_old_year,end_old_month,"
				+ "end_old_day,start_new_timeformat,start_new_year,start_new_month,start_new_day,"
				+ "end_new_timeformat,end_new_year,end_new_month,end_new_day,filterlabel)")
			.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			
			filterString.append(" network.countryid in ")
			.append(!filter.getSelectedCountries().isEmpty() ? "("+filter.getSelectedCountries()+")" :  "(select distinct countryid from countryib) ");	
		
		final Map<String, String> attributeMap = filter.getSelectedAttributes();
		appendAttributesToFilterString(filterString, parameterMap, attributeMap);
		
//		parameterMap.put("filter_string", filterString);
							
	}

	/**
	 * @param filterString
	 * @param parameterMap
	 * @param attributeMap
	 */
	private static void appendAttributesToFilterString(
			final StringBuilder filterString, final Map<String, Object> parameterMap,
			final Map<String, String> attributeMap) {
		
		for (final String columnName : attributeMap.keySet()) {
			final String value = attributeMap.get(columnName);
			final String[] valueArr = value.split(RAConstants.COLON);
			final String type = valueArr[0];
			final String values = valueArr[1];
			final List<Object> parameterList = CommonUtil.convertToList(values, type);
						
			if ("othercountriestraveled".equalsIgnoreCase(columnName)) {
				parameterMap.put("countries",parameterList);
			}  else if ("visitednetwork".equalsIgnoreCase(columnName)) {
				filterString.append(" and concat(cast(trip.visitedmcc as varchar),")
					.append(" concat('-',cast(trip.visitedmnc as varchar))) ")
					.append(" in (")
					.append(CommonUtil.covnertToCommaSeparatedString(values,type))
					.append(") ");
			}  else if ("homenetwork".equalsIgnoreCase(columnName)) {
				filterString.append(" and concat(cast(trip.homemcc as varchar),")
					.append(" concat('-',cast(trip.homemnc as varchar))) ")
					.append(" in (")
					.append(CommonUtil.covnertToCommaSeparatedString(values,type))
					.append(") ");
			} else {
				filterString.append(" and trip.").append(columnName).append(" in (")
					.append(CommonUtil.convertToCommaSeparatedString(parameterList))
					.append(") ");
			}			
		}
	}

	/**
	 * @param query existing track details
	 */
	public static void populateQueryForTrackDetails(final StringBuilder query, final Relation relation) {
		query.append(" select count(*) AS trackCount from ")
		.append(relation).append(" WHERE track_name = ?");			
	}

	/**
	 * @param roamType
	 * @return
	 */
	public static String queryForAllTrackers(final String roamType,final String trackerName) {
		final StringBuilder query = new StringBuilder();
		query.append(
				"SELECT id, track_name, filter_string, filterLabel, start_old_year, start_old_month, ")
				.append("case when start_old_timeformat='%Y-((%m/3)*3)-01 00:00:00' then ")
				.append("to_char(date_trunc('year', now())::date+(start_old_year || 'year')::interval +")
				.append("(trunc(EXTRACT(QUARTER FROM now()))*3+start_old_month || 'month')::interval + ")
				.append("(start_old_day || 'day')::interval, 'YYYY-MM-DD')")
				.append(" when start_old_timeformat!='%Y-%m-01 00:00:00' then replace(start_old_timeformat,' 00:00:00','')")
				.append("else to_char(date_trunc('month', now())::date+ (start_old_year || 'year')::interval + (start_old_month || 'month')::interval + (start_old_day || 'day')::interval, 'YYYY-MM-DD') end as oldstartdate,")
				.append("case when end_old_timeformat='%Y-((%m/3)*3)-01 00:00:00' then ")
				.append("to_char(date_trunc('year', now())::date+ (end_old_year || 'year')::interval +")
				.append("(trunc(EXTRACT(QUARTER FROM now()))*3 + end_old_month || 'month')::interval + ")
				.append("(end_old_day || 'day')::interval, 'YYYY-MM-DD')")
				.append(" when end_old_timeformat!='%Y-%m-01 00:00:00' then replace(end_old_timeformat,' 00:00:00','')")
				.append("else to_char(date_trunc('month', now())::date - 1 + (end_old_year || 'year')::interval + (end_old_month || 'month')::interval + (end_old_day || 'day')::interval, 'YYYY-MM-DD') end as oldenddate,")
				.append("case when start_new_timeformat='%Y-((%m/3)*3)-01 00:00:00' then ")
				.append("to_char(date_trunc('year', now())::date+ (start_new_year || 'year')::interval +")
				.append("(trunc(EXTRACT(QUARTER FROM now()))*3 + start_new_month || 'month')::interval + ")
				.append("(start_new_day || 'day')::interval, 'YYYY-MM-DD')")
				.append(" when start_new_timeformat!='%Y-%m-01 00:00:00' then replace(start_new_timeformat,' 00:00:00','')")
				.append("else to_char(date_trunc('month', now())::date+ (start_new_year || 'year')::interval + (start_new_month || 'month')::interval + (start_new_day || 'day')::interval, 'YYYY-MM-DD') end as newstartdate,")
				.append("case when end_new_timeformat='%Y-((%m/3)*3)-01 00:00:00' then ")
				.append("to_char(date_trunc('year', now())::date+ (end_new_year || 'year')::interval + ")
				.append("( trunc(EXTRACT(QUARTER FROM now()))*3 + end_new_month || 'month')::interval + ") 
				.append("(end_new_day || 'day')::interval, 'YYYY-MM-DD') ")
				.append(" when end_new_timeformat!='%Y-%m-01 00:00:00' then replace(end_new_timeformat,' 00:00:00','')")
				.append("else to_char(date_trunc('month', now())::date - 1 + (end_new_year || 'year')::interval + (end_new_month || 'month')::interval + (end_new_day || 'day')::interval, 'YYYY-MM-DD') end as newenddate")
				.append(",end_old_year,end_old_month,start_new_year,start_new_month,end_new_year,end_new_month FROM ");
		
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append(Relation.TRACKEROUT);
		} else {
			query.append(Relation.TRACKERIN);

		}
		
		if (trackerName==null || trackerName.equals("")) {
			
		} else {
			query.append(" where upper(track_name) like('%"+trackerName.toUpperCase()+"%') ");

		}
		query.append(" order by id asc");
		
		
		return query.toString();
	}

	/**
	 * @param roamType
	 * @return
	 */
	public static String queryForDeleteTrackers(final String roamType) {
		final StringBuilder query = new StringBuilder();
		query.append("DELETE FROM ");			
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {				
			query.append(Relation.TRACKEROUT);				
		} else {			
			query.append(Relation.TRACKERIN);				
		}	
		query.append(" WHERE id=?");
		return query.toString();
	}
	
	public static void populateQueryForTrackerNetwork(final Filter filter, final StringBuilder query,
			final Map<String, Object> parameterMap, final String roamType, final long startDate, final long endDate){
				
			query.append(" count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
				.append(" sum(trip.mtcallminutes) mtcallminutes, ")
				.append(" sum(trip.uplink + trip.downlink)/1048576.0  datausage, ");
				
			if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
				query.append("trip.visitednetwork networkName ")
					.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ");
					
			} else {
				query.append("trip.homenetwork networkName ")
					.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ");
			}
		
			query.append(" where (trip.usagebintime >= ")
				.append(startDate).append(" and trip.usagebintime <= ").append(endDate)
				.append(") ");
		
			if (!filter.getSelectedCountries().isEmpty()) {
				query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
			} 
		
			final Map<String,String> filterParameters = filter.getSelectedAttributes();
			StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
		
			if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
				query.append(" group by trip.visitednetwork ");
					
			} else {
				query.append(" group by trip.homenetwork ");
			}			
	}
	
	public static void populateQueryForTrackerNetworkGroup(final Filter filter, final StringBuilder query,
			final Map<String, Object> parameterMap, final String roamType, final long startDate, final long endDate){
		
			query.append(" count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
				.append(" sum(trip.mtcallminutes) mtcallminutes, ")
				.append(" sum(trip.uplink + trip.downlink)/1048576.0  datausage, ");
			
			if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
				query.append("trip.visitednetworkgroup networkGroup ")
					.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ");
					
			} else {
				query.append("trip.homenetworkgroup networkGroup ")
					.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ");
			}
			
			query.append(" where (trip.usagebintime >= ")
				.append(startDate).append(" and trip.usagebintime <= ").append(endDate)
				.append(") ");
		
			if (!filter.getSelectedCountries().isEmpty()) {
				query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
			} 
			
			final Map<String,String> filterParameters = filter.getSelectedAttributes();
			StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
			
			if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
				query.append(" group by trip.visitednetworkgroup ");
					
			} else {
				query.append(" group by trip.homenetworkgroup ");
			}	
	}
	
	
	
	public static void populateQueryForTrackerStatistics(final Filter filter, final StringBuilder query,
			final Map<String, Object> parameterMap, final String roamType, final Long newStartDate, final Long newEndDate){
		
		query.append("select 'oldrange' dateidentifier,");
		query .append(" overalltripcategory roamingcategory, count(distinct imsi) roamercount, sum(mocallminutes) mocallminutes, sum(mtcallminutes) mtcallminutes,"+ 
				 "sum(mosmscount) mosmscount, sum(uplink + downlink) datausage, sum(mocallminuteslocal) mocallminuteslocal, "+ 
				 " sum(mocallminuteshome) mocallminuteshome,sum(mocallminutesothers) mocallminutesother from ");
		query.append(RoamType.OUT.getRoamType().equalsIgnoreCase(roamType) ? RAPropertyUtil.getProperty("out.table.business") : RAPropertyUtil.getProperty("in.table.business") );
		query.append(" trip where trip.usagebintime >= ").append(filter.getDateFrom())
			.append(" and trip.usagebintime <= ").append(filter.getDateTo())
			.append(" ");
		
		if (!filter.getSelectedCountries().isEmpty()) {
			query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
		}
		   
		//((endtime >= t1 || endtime == 0) && starttime <= t2)
		
		final Map<String,String> filterParameters = filter.getSelectedAttributes();
		StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
			
		query.append(" group by  overalltripcategory");
		
		query.append(" union all ");
		
		query.append("select 'newrange' dateidentifier,");
		query .append(" overalltripcategory roamingcategory, count(distinct imsi) roamercount, sum(mocallminutes) mocallminutes, sum(mtcallminutes) mtcallminutes,"+ 
				 "sum(mosmscount) mosmscount, sum(uplink + downlink) datausage, sum(mocallminuteslocal) mocallminuteslocal, "+ 
				 " sum(mocallminuteshome) mocallminuteshome,sum(mocallminutesothers) mocallminutesother from ");
		query.append(RoamType.OUT.getRoamType().equalsIgnoreCase(roamType) ? RAPropertyUtil.getProperty("out.table.business") : RAPropertyUtil.getProperty("in.table.business") );
		query.append(" trip where trip.usagebintime >= ").append(newStartDate)
			.append(" and trip.usagebintime <= ").append(newEndDate)
			.append(" ");
		
		if (!filter.getSelectedCountries().isEmpty()) {
			query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
		}
		   
		//((endtime >= t1 || endtime == 0) && starttime <= t2)
		
		StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
			
		query.append(" group by  overalltripcategory order by dateidentifier");
		
	}
	public static void populateQueryForTrackerListStatistics(final Filter filter, final StringBuilder query,
			final Map<String, Object> parameterMap, final String roamType, final Long newStartDate, final Long newEndDate){
		
		query.append("select 'oldrange' dateidentifier,");
		query .append("  count(distinct imsi) roamercount, sum(mocallminutes) mocallminutes, sum(mtcallminutes) mtcallminutes,"+ 
				 "sum(mosmscount) mosmscount, sum(uplink + downlink) datausage, sum(mocallminuteslocal) mocallminuteslocal, "+ 
				 " sum(mocallminuteshome) mocallminuteshome,sum(mocallminutesothers) mocallminutesother from ");
		query.append(RoamType.OUT.getRoamType().equalsIgnoreCase(roamType) ? RAPropertyUtil.getProperty("out.table.business") : RAPropertyUtil.getProperty("in.table.business") );
		query.append(" trip where trip.usagebintime >= ").append(filter.getDateFrom())
			.append(" and trip.usagebintime <= ").append(filter.getDateTo())
			.append(" ");
		
		if (!filter.getSelectedCountries().isEmpty()) {
			query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
		}
		   
		//((endtime >= t1 || endtime == 0) && starttime <= t2)
		
		final Map<String,String> filterParameters = filter.getSelectedAttributes();
		StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
		
		query.append(" union all ");
		
		query.append("select 'newrange' dateidentifier,");
		query .append("  count(distinct imsi) roamercount, sum(mocallminutes) mocallminutes, sum(mtcallminutes) mtcallminutes,"+ 
				 "sum(mosmscount) mosmscount, sum(uplink + downlink) datausage, sum(mocallminuteslocal) mocallminuteslocal, "+ 
				 " sum(mocallminuteshome) mocallminuteshome,sum(mocallminutesothers) mocallminutesother from ");
		query.append(RoamType.OUT.getRoamType().equalsIgnoreCase(roamType) ? RAPropertyUtil.getProperty("out.table.business") : RAPropertyUtil.getProperty("in.table.business") );
		query.append(" trip where trip.usagebintime >= ").append(newStartDate)
			.append(" and trip.usagebintime <= ").append(newEndDate);
			
		
		if (!filter.getSelectedCountries().isEmpty()) {
			query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
		}
		   
		//((endtime >= t1 || endtime == 0) && starttime <= t2)
		
		StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
		
		query.append(" order by dateidentifier ");
			
		
	}

	/**
	 * @param filter
	 * @param query
	 * @param column
	 * @param parameterMap
	 * @param roamType
	 * @param newStartdate
	 * @param newEndDate
	 */
	public static void populateQueryForTrackerGraph(final Filter filter,
			final StringBuilder query, final String column,
			final Map<String, Object> parameterMap, final String roamType,
			final Long newStartdate, final Long newEndDate) {
		
			query.append(" count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
				.append(" sum(trip.mtcallminutes) mtcallminutes,")
				.append(" sum(trip.uplink + trip.downlink)/1048576.0  datausage, ")
				.append(" trip.").append(column).append(" categoryValue ");
				
			if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
				query.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ");
			} else {
				query.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ");
			}
			
			query.append(" where (trip.usagebintime >= ")
				.append(newStartdate).append(" and trip.usagebintime <= ").append(newEndDate)
				.append(") ");
		
			if (!filter.getSelectedCountries().isEmpty()) {
				query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
			}	
			
			final Map<String,String> filterParameters = filter.getSelectedAttributes();
			StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
			
			query.append(" group by trip.").append(column);
			
	}

	
	/**
	 * @param filter
	 * @param query
	 * @param column
	 * @param parameterMap
	 * @param roamType
	 * @param newStartdate
	 * @param newEndDate
	 */
	public static void populateQueryForOtherCountriesTraveledGraph(final Filter filter,
			final StringBuilder query, final String column,
			final Map<String, Object> parameterMap, final String roamType,
			final Long newStartdate, final Long newEndDate) {
		
		query.append(" count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
		.append(" sum(trip.mtcallminutes) mtcallminutes, ")
		.append(" sum(trip.uplink + trip.downlink)/1048576.0  datausage, ");

		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append(" sum(trip.").append(BusinessTableColumn.ISNEIGHBOURING).append(") bordering, ")
			.append(" sum(trip.").append(BusinessTableColumn.ISVISITEDCOUNTRYLEISURE).append(") leisure, ")
			.append(" sum(trip.").append(BusinessTableColumn.ISVISITEDCOUNTRYLEISUREPREMIUM).append(") leisurePremium, ")
			.append(" sum(trip.").append(BusinessTableColumn.VISITEDCOUNTRYGDP).append(") lowGDP ")
			.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ");

		} else {
			query.append(" sum(trip.").append(BusinessTableColumn.ISNEIGHBOURING).append(") bordering, ")
			.append(" sum(trip.").append(BusinessTableColumn.ISHOMECOUNTRYLEISURE).append(") leisure, ")
			.append(" sum(trip.").append(BusinessTableColumn.ISHOMECOUNTRYLEISUREPREMIUM).append(") leisurePremium, ")
			.append(" sum(trip.").append(BusinessTableColumn.HOMECOUNTRYGDP).append(") lowGDP ")
			.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ");
		}

		query.append(" where (trip.usagebintime >= ")
		.append(filter.getDateFrom()).append(" and trip.usagebintime <= ").append(filter.getDateTo())
		.append(") ");

		if (!filter.getSelectedCountries().isEmpty()) {
			query.append(StatsQueryBuilder.getClauseForCountryNotIn(filter.getSelectedCountries(), roamType));
		} 

		final Map<String,String> filterParameters = filter.getSelectedAttributes();
		StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);

		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append(" and  trip.imsi in (select distinct trip.imsi ")
			.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ")
			.append(" where (trip.usagebintime >= ")
			.append(filter.getDateFrom()).append(" and trip.usagebintime <= ").append(filter.getDateTo())
			.append(") ");
			if (!filter.getSelectedCountries().isEmpty()) {
				query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
			} 
			StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
			query.append(" ) ");
			query.append(" group by trip.visitedcountryid ");

		} else {
			query.append(" and  trip.imsi in (select distinct trip.imsi ")
			.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ")
			.append(" where (trip.usagebintime >= ")
			.append(filter.getDateFrom()).append(" and trip.usagebintime <= ").append(filter.getDateTo())
			.append(") ");
			if (!filter.getSelectedCountries().isEmpty()) {
				query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
			} 
			StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
			query.append(" ) ");
			query.append(" group by trip.homecountryid ");
		}

			
	}
}
