/**
 * 
 */
package com.advaizer.service;

import java.util.HashMap;
import java.util.List;

import com.advaizer.model.AggregatedCountryStatistics;
import com.advaizer.model.Filter;
import com.advaizer.model.RoamingStatistics;
import com.advaizer.model.chart.RoamingTrend;

/**
 * @author sarvesh
 *
 */
public interface TrendService {

	/**
	 * @Authr Smruti
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public  AggregatedCountryStatistics getTopCountry(Filter filter, String roamType);
	/**
	 *  @Authr Smruti
	 * @param startDate
	 * @param endDate
	 * @param orderBy
	 * @param groupBy
	 * @return
	 */
	public List<RoamingStatistics> getHeatMap(Filter filter , String roamType);	

	/**
	 * Gets the trends charts.
	 *
	 * @param filter the filter
	 * @return the trends charts
	 */
	public RoamingTrend getTrendsCharts(Filter filter, String roamType);		
	
	/**
	 * Gets the Roaming Statistics.
	 *
	 * @param filter the filter
	 * @return the trends charts
	 */
	public HashMap<String,Long> getRoamingStatistics(Filter filter, String roamType);

}
