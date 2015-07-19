/**
 * 
 */
package com.advaizer.model;

import java.util.HashMap;
import java.util.Map;

import com.advaizer.enums.RoamType;
import com.facebook.presto.jdbc.internal.joda.time.DateTime;

/**
 * @author cheshta
 *
 */
public class Tracker {
	
	private RoamType roamType;
	
	private DateTime fromDate;
	
	private DateTime toDate;
	
	private long id;
	
	private String trackName;	
	
	private String filterString;
	
	private String filterLabel;
	
	private String startOldTimeformat;
	
	private Integer startOldYear;
	
	private Integer startOldMonth;
	
	private Integer startOldDay;
	
	private String endOldTimeformat;
	
	private Integer endOldYear;
	
	private Integer endOldMonth;
	
	private Integer endOldDay;
	
	private String startNewTimeformat;
	
	private Integer startNewYear;
	
	private Integer startNewMonth;
	
	private Integer startNewDay;
	
	private String endNewTimeformat;
	
	private Integer endNewYear;
	
	private Integer endNewMonth;
	
	private Integer endNewDay;
		
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final long id) {
		this.id = id;
	}

	/**
	 * @return the trackName
	 */
	public String getTrackName() {
		return trackName;
	}

	/**
	 * @param trackName the trackName to set
	 */
	public void setTrackName(final String trackName) {
		this.trackName = trackName;
	}

	/**
	 * @return the filters
	 */
	public String getFilterString() {
		return filterString;
	}

	/**
	 * @param filters the filters to set
	 */
	public void setFilterString(final String filterString) {
		this.filterString = filterString;
	}
	
	/**
	 * @return the end_old_year
	 */
	public Integer getEndOldYear() {
		return endOldYear;
	}

	/**
	 * @param end_old_year the end_old_year to set
	 */
	public void setEndOldYear(final Integer endOldYear) {
		this.endOldYear = endOldYear;
	}

	/**
	 * @return the end_old_timeformat
	 */
	public String getEndOldTimeformat() {
		return endOldTimeformat;
	}

	/**
	 * @param end_old_timeformat the end_old_timeformat to set
	 */
	public void setEndOldTimeformat(final String endOldTimeformat) {
		this.endOldTimeformat = endOldTimeformat;
	}

	/**
	 * @return the start_old_day
	 */
	public Integer getStartOldDay() {
		return startOldDay;
	}

	/**
	 * @param start_old_day the start_old_day to set
	 */
	public void setStartOldDay(final Integer startOldDay) {
		this.startOldDay = startOldDay;
	}

	/**
	 * @return the start_old_month
	 */
	public Integer getStartOldMonth() {
		return startOldMonth;
	}

	/**
	 * @param start_old_month the start_old_month to set
	 */
	public void setStartOldMonth(final Integer startOldMonth) {
		this.startOldMonth = startOldMonth;
	}

	/**
	 * @return the start_old_year
	 */
	public Integer getStartOldYear() {
		return startOldYear;
	}

	/**
	 * @param start_old_year the start_old_year to set
	 */
	public void setStartOldYear(final Integer startOldYear) {
		this.startOldYear = startOldYear;
	}

	/**
	 * @return the start_old_timeformat
	 */
	public String getStartOldTimeformat() {
		return startOldTimeformat;
	}

	/**
	 * @param start_old_timeformat the start_old_timeformat to set
	 */
	public void setStartOldTimeformat(final String startOldTimeformat) {
		this.startOldTimeformat = startOldTimeformat;
	}

	/**
	 * @return the end_old_month
	 */
	public Integer getEndOldMonth() {
		return endOldMonth;
	}

	/**
	 * @param end_old_month the end_old_month to set
	 */
	public void setEndOldMonth(final Integer endOldMonth) {
		this.endOldMonth = endOldMonth;
	}

	/**
	 * @return the end_old_day
	 */
	public Integer getEndOldDay() {
		return endOldDay;
	}

	/**
	 * @param end_old_day the end_old_day to set
	 */
	public void setEndOldDay(final Integer endOldDay) {
		this.endOldDay = endOldDay;
	}

	/**
	 * @return the start_new_timeformat
	 */
	public String getStartNewTimeformat() {
		return startNewTimeformat;
	}

	/**
	 * @param start_new_timeformat the start_new_timeformat to set
	 */
	public void setStartNewTimeformat(final String startNewTimeformat) {
		this.startNewTimeformat = startNewTimeformat;
	}

	/**
	 * @return the start_new_year
	 */
	public Integer getStartNewYear() {
		return startNewYear;
	}

	/**
	 * @param start_new_year the start_new_year to set
	 */
	public void setStartNewYear(final Integer startNewYear) {
		this.startNewYear = startNewYear;
	}

	/**
	 * @return the start_new_month
	 */
	public Integer getStartNewMonth() {
		return startNewMonth;
	}

	/**
	 * @param start_new_month the start_new_month to set
	 */
	public void setStartNewMonth(final Integer startNewMonth) {
		this.startNewMonth = startNewMonth;
	}

	/**
	 * @return the start_new_day
	 */
	public Integer getStartNewDay() {
		return startNewDay;
	}

	/**
	 * @param start_new_day the start_new_day to set
	 */
	public void setStartNewDay(final Integer startNewDay) {
		this.startNewDay = startNewDay;
	}

	/**
	 * @return the end_new_timeformat
	 */
	public String getEndNewTimeformat() {
		return endNewTimeformat;
	}

	/**
	 * @param end_new_timeformat the end_new_timeformat to set
	 */
	public void setEndNewTimeformat(final String endNewTimeformat) {
		this.endNewTimeformat = endNewTimeformat;
	}

	/**
	 * @return the end_new_year
	 */
	public Integer getEndNewYear() {
		return endNewYear;
	}

	/**
	 * @param end_new_year the end_new_year to set
	 */
	public void setEndNewYear(final Integer endNewYear) {
		this.endNewYear = endNewYear;
	}

	/**
	 * @return the end_new_month
	 */
	public Integer getEndNewMonth() {
		return endNewMonth;
	}

	/**
	 * @param end_new_month the end_new_month to set
	 */
	public void setEndNewMonth(final Integer endNewMonth) {
		this.endNewMonth = endNewMonth;
	}

	/**
	 * @return the end_new_day
	 */
	public Integer getEndNewDay() {
		return endNewDay;
	}

	/**
	 * @param end_new_day the end_new_day to set
	 */
	public void setEndNewDay(final Integer endNewDay) {
		this.endNewDay = endNewDay;
	}

	/**
	 * @return the roamType
	 */
	public RoamType getRoamType() {
		return roamType;
	}

	/**
	 * @param roamType the roamType to set
	 */
	public void setRoamType(final RoamType roamType) {
		this.roamType = roamType;
	}

	/**
	 * @return the filterLabel
	 */
	public String getFilterLabel() {
		return filterLabel;
	}

	/**
	 * @param filterLabel the filterLabel to set
	 */
	public void setFilterLabel(final String filterLabel) {
		this.filterLabel = filterLabel;
	}
	
	@Override
	public String toString() {
		return "Track [id=" + id + ", trackName=" + trackName
				+ ", filterString=" + filterString 
				+ "]";
	}
	
	public Map<String, String> convertToMap(){
		final Map<String,String> trackMap = new HashMap<String,String>();
		
		trackMap.put("id", String.valueOf(id));
		trackMap.put("trackName", trackName);
		trackMap.put("filterString", filterString);		
		trackMap.put("filterLabel", filterLabel);	
		trackMap.put("startOldTimeformat", startOldTimeformat);			
		trackMap.put("endOldTimeformat", endOldTimeformat);			
		trackMap.put("startNewTimeformat", startNewTimeformat);		
		trackMap.put("endNewTimeformat", endNewTimeformat);		
		return trackMap;		
	}

	/**
	 * @return the fromDate
	 */
	public DateTime getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(final DateTime fromDate) {
		this.fromDate = fromDate;
	}

	public DateTime getToDate() {
		return toDate;
	}

	public void setToDate(final DateTime toDate) {
		this.toDate = toDate;
	}
	

}
