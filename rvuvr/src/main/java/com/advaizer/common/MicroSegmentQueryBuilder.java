/**
 * 
 */
package com.advaizer.common;

import java.util.Map;

import com.advaizer.enums.BusinessTableColumn;
import com.advaizer.enums.RoamType;
import com.advaizer.model.Filter;

/**
 * @author sarvesh
 *
 */
public class MicroSegmentQueryBuilder {

	/**
	 * Populate query for microsegment chart.
	 *
	 * @param filter the filter
	 * @param query the query
	 * @param column the column
	 * @param columnType the column type
	 * @param parameterMap the parameter map
	 */
	public static void populateQueryForMicrosegmentChart(final Filter filter, final StringBuilder query, 
			final String column,  final Map<String, Object> parameterMap, final String roamType) {
		query.append(" select count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
			.append(" sum(trip.mtcallminutes) mtcallminutes,")
			.append(" sum(trip.uplink + trip.downlink)/1048576.0  datausage, ")
			.append(" trip.").append(column).append(" categoryValue ");
			
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ");
		} else {
			query.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ");
		}
		
		query.append(" where (trip.usagebintime >= ")
			.append(filter.getDateFrom()).append(" and trip.usagebintime <= ").append(filter.getDateTo())
			.append(") ");

		if (!filter.getSelectedCountries().isEmpty()) {
			query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
		}	
		
		final Map<String,String> filterParameters = filter.getSelectedAttributes();
		StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
		
		query.append(" group by trip.").append(column);
		query.append(" order by imsicount desc, mocallminutes desc, mtcallminutes desc, ")
			.append(" datausage desc ");
	}

	
	/**
	 * Populate query for microsegment chart.
	 *
	 * @param filter the filter
	 * @param query the query
	 * @param column the column
	 * @param columnType the column type
	 * @param parameterMap the parameter map
	 */
	public static void populateQueryForMicrosegmentOverlayChart(final Filter filter, final StringBuilder query, 
			final String column, final String overlayColumn, final String roamType) {
		query.append(" select count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
			.append(" sum(trip.mtcallminutes) mtcallminutes,")
			.append(" sum(trip.uplink + trip.downlink)/1048576.0  datausage, ")
			.append(" trip.").append(column).append(" categoryValue, ")
			.append(" trip.").append(overlayColumn).append(" overlayValue ");
			
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ");
		} else {
			query.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ");
		}
		
		query.append(" where (trip.usagebintime >= ")
			.append(filter.getDateFrom()).append(" and trip.usagebintime <= ").append(filter.getDateTo())
			.append(") ");

		if (!filter.getSelectedCountries().isEmpty()) {
			query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
		}	
		
		final Map<String,String> filterParameters = filter.getSelectedAttributes();
		StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
		
		query.append(" group by trip.").append(column).append(", trip.").append(overlayColumn);
		query.append(" order by imsicount desc, mocallminutes desc, mtcallminutes desc, ")
			.append(" datausage desc ");
	}
	
	/**
	 * Populate query for network chart.
	 *
	 * @param filter the filter
	 * @param query the query
	 * @param column the column
	 * @param columnType the column type
	 * @param parameterMap the parameter map
	 */
	public static void populateQueryForNetworkOverlayChart(final Filter filter, final StringBuilder query,  
			final String overlayColumn, final String roamType) {
		query.append(" select count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
			.append(" sum(trip.mtcallminutes) mtcallminutes, ")
			.append(" sum(trip.uplink + trip.downlink)/1048576.0  datausage, ");
			
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append("trip.visitednetwork networkName ")
				.append(", trip.").append(overlayColumn).append(" overlayValue ")
				.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ");
				
		} else {
			query.append("trip.homenetwork networkName ")
				.append(", trip.").append(overlayColumn).append(" overlayValue ")
				.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ");
		}
		
		
	
		query.append(" where (trip.usagebintime >= ")
			.append(filter.getDateFrom()).append(" and trip.usagebintime <= ").append(filter.getDateTo())
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
		query.append(", trip.").append(overlayColumn);
		query.append(" order by imsicount desc, mocallminutes desc, mtcallminutes desc, ")
			.append("  datausage desc ");
	}
	
	/**
	 * Populate query for network chart.
	 *
	 * @param filter the filter
	 * @param query the query
	 * @param column the column
	 * @param columnType the column type
	 * @param parameterMap the parameter map
	 */
	public static void populateQueryForNetworkChart(final Filter filter, final StringBuilder query,  
			final Map<String, Object> parameterMap, final String roamType) {
		query.append(" select count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
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
			.append(filter.getDateFrom()).append(" and trip.usagebintime <= ").append(filter.getDateTo())
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
		
		query.append(" order by imsicount desc, mocallminutes desc, mtcallminutes desc, ")
			.append("  datausage desc ");
	}

	/**
	 * Populate query for network group chart.
	 *
	 * @param filter the filter
	 * @param query the query
	 * @param column the column
	 * @param columnType the column type
	 * @param parameterMap the parameter map
	 */
	public static void populateQueryForNetworkGroupOverlayChart(final Filter filter, final StringBuilder query,
			final String overlayColumn, final String roamType) {
		query.append(" select count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
			.append(" sum(trip.mtcallminutes) mtcallminutes, ")
			.append(" sum(trip.uplink + trip.downlink)/1048576.0  datausage, ");
		
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append("trip.visitednetworkgroup networkGroup ")
				.append(", trip.").append(overlayColumn).append(" overlayValue ")
				.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ");
				
		} else {
			query.append("trip.homenetworkgroup networkGroup ")
				.append(", trip.").append(overlayColumn).append(" overlayValue ")
				.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ");
		}
		
		
		
		query.append(" where (trip.usagebintime >= ")
			.append(filter.getDateFrom()).append(" and trip.usagebintime <= ").append(filter.getDateTo())
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
		
		query.append(", trip.").append(overlayColumn);
		query.append(" order by imsicount desc, mocallminutes desc, mtcallminutes desc, ")
			.append("  datausage desc ");
	}
	
	/**
	 * @param filter
	 * @param query
	 * @param parameterMap
	 * @param roamType
	 */
	public static void populateQueryForOtherCountriesTraveledOverlayChart(final Filter filter, final StringBuilder query,
			final String overlayColumn, final String roamType) {
		query.append(" select count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
			.append(" sum(trip.mtcallminutes) mtcallminutes, ")
			.append(" sum(trip.uplink + trip.downlink)/1048576.0  datausage, ")
			.append(" trip.").append(overlayColumn).append(" overlayValue, ");
		

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
				.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ");
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
			query.append(" group by trip.visitedcountryid ")
				.append(", trip.").append(overlayColumn);;

		} else {
			query.append(" and  trip.imsi in (select distinct trip.imsi ")
				.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ")
				.append(" where (trip.usagebintime >= ")
				.append(filter.getDateFrom()).append(" and trip.usagebintime <= ").append(filter.getDateTo())
				.append(") ");
				if (!filter.getSelectedCountries().isEmpty()) {
					query.append(StatsQueryBuilder.getClauseForCountry(filter.getSelectedCountries(), roamType));
				} 
				StatsQueryBuilder.appendClauseForAttributes(query, filterParameters);
				query.append(" ) ");
			query.append(" group by trip.homecountryid ")
				.append(", trip.").append(overlayColumn);
		}

	}
	
	/**
	 * Populate query for network group chart.
	 *
	 * @param filter the filter
	 * @param query the query
	 * @param column the column
	 * @param columnType the column type
	 * @param parameterMap the parameter map
	 */
	public static void populateQueryForNetworkGroupChart(final Filter filter, final StringBuilder query, 
			final Map<String, Object> parameterMap, final String roamType) {
		query.append(" select count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
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
			.append(filter.getDateFrom()).append(" and trip.usagebintime <= ").append(filter.getDateTo())
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
		
		query.append(" order by imsicount desc, mocallminutes desc, mtcallminutes desc, ")
			.append("  datausage desc ");
	}

	/**
	 * @param filter
	 * @param query
	 * @param parameterMap
	 * @param roamType
	 */
	public static void populateQueryForOtherCountriesTraveledChart(final Filter filter, final StringBuilder query,
			final Map<String, Object> parameterMap, final String roamType) {
		query.append(" select count(distinct trip.imsi) imsicount, sum(trip.mocallminutes) mocallminutes, ")
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
				.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ");
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
				.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ")
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
