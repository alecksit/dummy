/**
 * 
 */
package com.advaizer.model.chart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.advaizer.enums.DayOfWeek;
import com.advaizer.enums.RoamerType;
import com.advaizer.enums.VoiceType;

/**
 * @author sarvesh
 *
 */
public class RoamingTrendResultSetExtractor implements ResultSetExtractor<RoamingTrend> {

	
	/** The logger. */
	private static Logger LOGGER = LogManager.getLogger(RoamingTrendResultSetExtractor.class.getName());
	
	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.ResultSet)
	 */
	@Override
	public RoamingTrend extractData(final ResultSet rs) throws SQLException,
			DataAccessException {

		final Map<RoamerType, Map<DayOfWeek, Double>> dowCountMap = new TreeMap<RoamerType, Map<DayOfWeek, Double>>();
		final Map<RoamerType, Map<Long, Double>> perDayCountMap = new TreeMap<RoamerType, Map<Long, Double>>();
		
		final Map<VoiceType, Map<DayOfWeek, Double>> dowCallMap = new HashMap<VoiceType, Map<DayOfWeek,Double>>();
		final Map<VoiceType, Map<Long, Double>> perDayCallMap = new HashMap<VoiceType, Map<Long, Double>>();
		
		final Map<DayOfWeek, Double> dowDataMap = new TreeMap<DayOfWeek, Double>();
		final Map<Long, Double> perDayDataMap = new TreeMap<Long, Double>();
		
		final Map<DayOfWeek, Double> dowSMSMap = new TreeMap<DayOfWeek, Double>();
		final Map<Long, Double> perDaySMSMap = new TreeMap<Long, Double>();
		
		final Set<DayOfWeek> dowCategory = new TreeSet<DayOfWeek>();
		final Set<Long> dateCategory = new TreeSet<Long>();
		long startDate = System.currentTimeMillis();
		boolean first = true;
		while (rs.next()) {
			final Long date = rs.getLong("usagebintime") * 1000;
			final Double count = rs.getDouble("imsicount");
			final Integer tripCategory = rs.getInt("overalltripcategory");
			final Double mt = rs.getDouble("mtcallminutes");
			final Double mo = rs.getDouble("mocallminutes");
			final Double mosms = rs.getDouble("mosmscount");
			final Double data = rs.getDouble("datausage");
			
			final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			cal.setTimeInMillis(date);
			int calDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			calDayOfWeek = calDayOfWeek == 1 ? 7 : calDayOfWeek - 1;
			final DayOfWeek dow =  DayOfWeek.of(calDayOfWeek);
			dateCategory.add(date);
			if (first) {
				startDate = date;
				first = false;
			}
			
			dowCategory.add(dow);
			
			// Roamers Count Chart
			populateRoamersCountDoW(dowCountMap, count, tripCategory, dow);
			populateRoamersCountPerDay(perDayCountMap, date, count, tripCategory);
			
			// Voice Call Chart
			populateCallCountDoW(dowCallMap, dow, mt, mo);
			populateCallCountPerDay(perDayCallMap, date, mt, mo);
			
			// Data chart
			populateDataPerDoW(dowDataMap, dow, data);
			populateDataPerDay(perDayDataMap, date, data);
			
			// SMS chart
			populateDataPerDoW(dowSMSMap, dow, mosms);
			populateDataPerDay(perDaySMSMap, date, mosms);
			
		}

		final RoamingTrend roamingTrend = new RoamingTrend();
		
		populateRoamingTrend(dowCountMap, perDayCountMap, dowCallMap, perDayCallMap, 
				dowDataMap, perDayDataMap,dowSMSMap,perDaySMSMap, dowCategory, dateCategory, roamingTrend, startDate);
		
		LOGGER.trace("Roaming trends result : " + roamingTrend);
		return roamingTrend;
	}

	/**
	 * @param dowCountMap
	 * @param dowCallMap
	 * @param dowCategory
	 * @param dateCategory
	 * @param roamingTrend
	 */
	private void populateRoamingTrend(
			final Map<RoamerType, Map<DayOfWeek, Double>> dowCountMap,
			final Map<RoamerType, Map<Long, Double>> perDayCountMap,
			final Map<VoiceType, Map<DayOfWeek, Double>> dowCallMap, 
			final Map<VoiceType, Map<Long, Double>> perDayCallMap,
			final Map<DayOfWeek, Double> dowDataMap,
			final Map<Long, Double> perDayDataMap,
			final Map<DayOfWeek, Double> dowSMSMap,
			final Map<Long, Double> perDaySMSMap,
			final Set<DayOfWeek> dowCategory, final Set<Long> dateCategory,
			final RoamingTrend roamingTrend, final long startDate) {
		
		// Roamer Count Chart
		populateRoamerCountChart(dowCountMap, perDayCountMap, dowCategory, dateCategory, roamingTrend, startDate);
		
		// Voice Chart
		populateVoiceCallChart(dowCallMap, perDayCallMap, dowCategory, dateCategory, roamingTrend, startDate);
		
		// Data Chart
		populateDataChart(dowDataMap, perDayDataMap, dowCategory, dateCategory, roamingTrend, startDate);
		
		//SMS  Chart
		populateSMSChart(dowSMSMap, perDaySMSMap, dowCategory, dateCategory, roamingTrend, startDate);
	}

	
	
	/**
	 * @param dowCallMap
	 * @param perDayCallMap
	 * @param dowCategory
	 * @param dateCategory
	 * @param roamingTrend
	 */
	private void populateSMSChart(
			final Map<DayOfWeek, Double> dowDataMap,
			final Map<Long, Double> perDayDataMap,
			final Set<DayOfWeek> dowCategory, final Set<Long> dateCategory,
			final RoamingTrend roamingTrend, final long startDate) {
		
		final List<ChartSeries> dowDataSeriesList = new ArrayList<ChartSeries>();
		if (!dowDataMap.values().isEmpty()) {
			final ChartSeries dowSeries = new ChartSeries();
			dowSeries.setName("SMS");
			dowSeries.setShowInLegend(false);
			dowSeries.setData(dowDataMap.values());
			dowDataSeriesList.add(dowSeries);
		}
		final List<ChartSeries> perDayDataSeriesList = new ArrayList<ChartSeries>();
		if (!perDayDataMap.values().isEmpty()) {
			final PerDaySeries dateSeries = new PerDaySeries();
			dateSeries.setName("SMS");
			dateSeries.setShowInLegend(false);
			dateSeries.setData(perDayDataMap.values());
			dateSeries.setPointStart(startDate);
			perDayDataSeriesList.add(dateSeries);
		}
		
		final RoamingTrendChart dataChart = new RoamingTrendChart();
		dataChart.setDowCategoryList(dowCategory);
		//dataChart.setPerDayCategoryList(dateCategory);
		dataChart.setDowSeriesList(dowDataSeriesList);
		dataChart.setPerDaySeriesList(perDayDataSeriesList);
		roamingTrend.setRoamersSMSChart(dataChart);
	}
	
	/**
	 * @param dowCallMap
	 * @param perDayCallMap
	 * @param dowCategory
	 * @param dateCategory
	 * @param roamingTrend
	 */
	private void populateDataChart(
			final Map<DayOfWeek, Double> dowDataMap,
			final Map<Long, Double> perDayDataMap,
			final Set<DayOfWeek> dowCategory, final Set<Long> dateCategory,
			final RoamingTrend roamingTrend, final long startDate) {
		
		final List<ChartSeries> dowDataSeriesList = new ArrayList<ChartSeries>();
		
		if (!dowDataMap.values().isEmpty()) {
			final ChartSeries dowSeries = new ChartSeries();
			dowSeries.setName("Data");
			dowSeries.setShowInLegend(false);
			dowSeries.setData(dowDataMap.values());
			dowDataSeriesList.add(dowSeries);
		}
		final List<ChartSeries> perDayDataSeriesList = new ArrayList<ChartSeries>();
		if (!perDayDataMap.values().isEmpty()) {
			final PerDaySeries dateSeries = new PerDaySeries();
			dateSeries.setName("Data");
			dateSeries.setShowInLegend(false);
			dateSeries.setData(perDayDataMap.values());
			dateSeries.setPointStart(startDate);
			perDayDataSeriesList.add(dateSeries);
		}
		
		final RoamingTrendChart dataChart = new RoamingTrendChart();
		dataChart.setDowCategoryList(dowCategory);
		//dataChart.setPerDayCategoryList(dateCategory);
		dataChart.setDowSeriesList(dowDataSeriesList);
		dataChart.setPerDaySeriesList(perDayDataSeriesList);
		roamingTrend.setRoamersDataChart(dataChart);
	}
	
	
	/**
	 * @param dowCallMap
	 * @param perDayCallMap
	 * @param dowCategory
	 * @param dateCategory
	 * @param roamingTrend
	 */
	private void populateVoiceCallChart(
			final Map<VoiceType, Map<DayOfWeek, Double>> dowCallMap,
			final Map<VoiceType, Map<Long, Double>> perDayCallMap,
			final Set<DayOfWeek> dowCategory, final Set<Long> dateCategory,
			final RoamingTrend roamingTrend, final long startDate) {
		final List<ChartSeries> dowCallSeriesList = new ArrayList<ChartSeries>();
		for (final VoiceType voiceType : dowCallMap.keySet()) {
			final ChartSeries series = new ChartSeries();
			series.setName(voiceType.name());
			series.setData(dowCallMap.get(voiceType).values());
			dowCallSeriesList.add(series);
		}
		
		final List<ChartSeries> perDayCallSeriesList = new ArrayList<ChartSeries>();
		for (final VoiceType voiceType : perDayCallMap.keySet()) {
			final PerDaySeries series = new PerDaySeries();
			series.setName(voiceType.name());
			series.setPointStart(startDate);
			series.setData(perDayCallMap.get(voiceType).values());
			perDayCallSeriesList.add(series);
		}
		
		final RoamingTrendChart voiceChart = new RoamingTrendChart();
		voiceChart.setDowCategoryList(dowCategory);
		//voiceChart.setPerDayCategoryList(dateCategory);
		voiceChart.setDowSeriesList(dowCallSeriesList);
		voiceChart.setPerDaySeriesList(perDayCallSeriesList);
		roamingTrend.setRoamersMTMOChart(voiceChart);
	}

	/**
	 * @param dowCountMap
	 * @param perDayCountMap
	 * @param dowCategory
	 * @param dateCategory
	 * @param roamingTrend
	 */
	private void populateRoamerCountChart(
			final Map<RoamerType, Map<DayOfWeek, Double>> dowCountMap,
			final Map<RoamerType, Map<Long, Double>> perDayCountMap,
			final Set<DayOfWeek> dowCategory, final Set<Long> dateCategory,
			final RoamingTrend roamingTrend, final long startDate) {
		
		final List<ChartSeries> dowCountSeriesList = new ArrayList<ChartSeries>();
		for (final RoamerType roamerType : dowCountMap.keySet()) {
			final ChartSeries series = new ChartSeries();
			series.setName(roamerType.getDisplayName());
			series.setData(dowCountMap.get(roamerType).values());
			dowCountSeriesList.add(series);
		}
		
		final List<ChartSeries> perDayCountSeriesList = new ArrayList<ChartSeries>();
		for (final RoamerType roamerType : perDayCountMap.keySet()) {
			final PerDaySeries series = new PerDaySeries();
			series.setName(roamerType.getDisplayName());
			series.setPointStart(startDate);
			series.setData(perDayCountMap.get(roamerType).values());
			perDayCountSeriesList.add(series);
		}
		
		final RoamingTrendChart roamerCountChart = new RoamingTrendChart();
		roamerCountChart.setDowCategoryList(dowCategory);
		//roamerCountChart.setPerDayCategoryList(dateCategory);
		roamerCountChart.setDowSeriesList(dowCountSeriesList);
		roamerCountChart.setPerDaySeriesList(perDayCountSeriesList);
		roamingTrend.setRoamersCountChart(roamerCountChart);
	}

	
	/**
	 * Extract call count dow.
	 *
	 * @param dowDataMap the dow data map
	 * @param dow the dow
	 * @param data the data
	 */
	private void populateDataPerDay(final Map<Long, Double> perDayDataMap,final Long date, 
			final Double data) {
		final Double perDayData = perDayDataMap.get(date);
		if (perDayData == null) {
			perDayDataMap.put(date, data);
		} else {
			perDayDataMap.put(date, perDayData + data);
		}
	}
	
	
	/**
	 * Extract call count dow.
	 *
	 * @param dowDataMap the dow data map
	 * @param dow the dow
	 * @param data the data
	 */
	private void populateDataPerDoW(final Map<DayOfWeek, Double> dowDataMap,final DayOfWeek dow, 
			final Double data) {
		final Double dowData = dowDataMap.get(dow);
		if (dowData == null) {
			dowDataMap.put(dow, data);
		} else {
			dowDataMap.put(dow, dowData + data);
		}
	}
	
	
	/**
	 * Extract call count dow.
	 *
	 * @param dowCallMap the dow call map
	 * @param dow the dow
	 * @param mt the mt
	 * @param mo the mo
	 */
	private void populateCallCountPerDay(final Map<VoiceType, Map<Long, Double>> perDayCallMap,final Long date, 
			final Double mt, final Double mo) {
		Map<Long, Double> mtMap = perDayCallMap.get(VoiceType.MT);
		if (mtMap == null) {
			mtMap = new TreeMap<Long, Double>();
			perDayCallMap.put(VoiceType.MT, mtMap);
		}
		
		final Double mtcalls = mtMap.get(date);
		if (mtcalls == null) {
			mtMap.put(date, mt);
		} else {
			mtMap.put(date, mt + mtcalls);
		}
		
		Map<Long, Double> moMap = perDayCallMap.get(VoiceType.MO);
		if (moMap == null) {
			moMap = new TreeMap<Long, Double>();
			perDayCallMap.put(VoiceType.MO, moMap);
		}
		
		final Double mocalls = moMap.get(date);
		if (mocalls == null) {
			moMap.put(date, mo);
		} else {
			moMap.put(date, mo + mocalls);
		}
		
	}
	
	
	/**
	 * Extract call count dow.
	 *
	 * @param dowCallMap the dow call map
	 * @param dow the dow
	 * @param mt the mt
	 * @param mo the mo
	 */
	private void populateCallCountDoW(final Map<VoiceType, Map<DayOfWeek, Double>> dowCallMap,final DayOfWeek dow, 
			final Double mt, final Double mo) {
		Map<DayOfWeek, Double> mtMap = dowCallMap.get(VoiceType.MT);
		if (mtMap == null) {
			mtMap = new TreeMap<DayOfWeek, Double>();
			dowCallMap.put(VoiceType.MT, mtMap);
		}
		
		final Double mtcalls = mtMap.get(dow);
		if (mtcalls == null) {
			mtMap.put(dow, mt);
		} else {
			mtMap.put(dow, mt + mtcalls);
		}
		
		Map<DayOfWeek, Double> moMap = dowCallMap.get(VoiceType.MO);
		if (moMap == null) {
			moMap = new TreeMap<DayOfWeek, Double>();
			dowCallMap.put(VoiceType.MO, moMap);
		}
		
		final Double mocalls = moMap.get(dow);
		if (mocalls == null) {
			moMap.put(dow, mo);
		} else {
			moMap.put(dow, mo + mocalls);
		}
		
	}
	/**
	 * @param dateDataMap
	 * @param date
	 * @param count
	 * @param tripCategory
	 */
	private void populateRoamersCountPerDay(
			final Map<RoamerType, Map<Long, Double>> dateDataMap, final Long date,
			final Double count, final Integer tripCategory) {
		Map<Long, Double> dateRoamerTypeMap = dateDataMap
				.get(RoamerType.of(tripCategory));

		if (dateRoamerTypeMap == null) {
			dateRoamerTypeMap = new TreeMap<Long, Double>();
			dateDataMap.put(RoamerType.of(tripCategory),
					dateRoamerTypeMap);
		}

		final Double dateData = dateRoamerTypeMap.get(date);
		if (dateData == null) {
			dateRoamerTypeMap.put(date, count);
		} else {
			dateRoamerTypeMap.put(date, count + dateData);
		}
	}

	/**
	 * @param dayDataMap
	 * @param count
	 * @param tripCategory
	 * @param dow
	 */
	private void populateRoamersCountDoW(
			final Map<RoamerType, Map<DayOfWeek, Double>> dayDataMap, final Double count,
			final Integer tripCategory, final DayOfWeek dow) {
		Map<DayOfWeek, Double> dayRoamerTypeMap = dayDataMap
				.get(RoamerType.of(tripCategory));
		if (dayRoamerTypeMap == null) {
			dayRoamerTypeMap = new TreeMap<DayOfWeek, Double>();
			dayDataMap.put(RoamerType.of(tripCategory),
					dayRoamerTypeMap);
		}

		final Double dayData = dayRoamerTypeMap.get(dow);
		if (dayData == null) {
			dayRoamerTypeMap.put(dow, count);
		} else {
			dayRoamerTypeMap.put(dow, count + dayData);
		}
	}

}
