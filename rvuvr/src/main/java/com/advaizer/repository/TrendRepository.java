/**
 * 
 */
package com.advaizer.repository;


import java.util.List;

import com.advaizer.model.Filter;
import com.advaizer.model.RoamingStatistics;
import com.advaizer.model.chart.RoamingTrend;

/**
 * @author smruti
 *
 */
public interface TrendRepository {
	
	

	/**
	 * Gets the trends charts.
	 *
	 * @param filter the filter
	 * @return the trends charts
	 */
	public RoamingTrend getTrendsCharts(Filter filter,String roamType);
	
	/**
	 * Gets the Roaming Statistics.
	 *
	 * @param filter the filter
	 * @return the trends charts
	 */
	public List<RoamingStatistics> getRoamingStatistics(Filter filter,String roamType);
	

	/**
	 * Gets the Roaming Statistics.
	 *
	 * @param filter the filter
	 * @return the trends charts
	 */
	public List<RoamingStatistics> getRoamingStatisticsOnly(final Filter filter,  final String roamType);
	

	/**
	 * Gets the Roaming Statistics.
	 *
	 * @param filter the filter
	 * @return the trends charts
	 */
	public List<RoamingStatistics> getDistinctRoamingStatisticsOnly(final Filter filter,  final String roamType);


}
