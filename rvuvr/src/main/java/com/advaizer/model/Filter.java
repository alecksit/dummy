/**
 * 
 */
package com.advaizer.model;

import java.util.HashMap;
import java.util.Map;

import com.advaizer.common.RAConstants;

/**
 * Represents filter selected at a given time. It is the collection of countries selected with the
 * attributes
 * @author sarvesh
 *
 */
public class Filter {

	/** The selected countries. */
	private String selectedCountries;
	
	/** The selected attributes. */
	private Map<String,String> selectedAttributes = new HashMap<String, String>(1);
	
	/** The date from. */
	private long dateFrom;
	
	/** The date to. */
	private long dateTo;

	
	private String filterString;
	
	/**
	 * @return the selectedCountries
	 */
	public String getSelectedCountries() {
		return selectedCountries;
	}

	/**
	 * @param selectedCountries the selectedCountries to set
	 */
	public void setSelectedCountries(final String selectedCountries) {
		this.selectedCountries = selectedCountries;
	}

	/**
	 * @return the selectedAttributes
	 */
	public Map<String, String> getSelectedAttributes() {
		return selectedAttributes;
	}

	/**
	 * @param selectedAttributes the selectedAttributes to set
	 */
	public void setSelectedAttributes(final Map<String, String> selectedAttributes) {
		this.selectedAttributes = selectedAttributes;
	}

	/**
	 * @return the dateFrom
	 */
	public long getDateFrom() {
		return dateFrom;
	}

	/**
	 * @param dateFrom the dateFrom to set
	 */
	public void setDateFrom(final long dateFrom) {
		this.dateFrom = dateFrom/1000;
	}

	/**
	 * @return the dateTo
	 */
	public long getDateTo() {
		return dateTo;
	}

	/**
	 * @param dateTo the dateTo to set
	 */
	public void setDateTo(final long dateTo) {
		this.dateTo = dateTo/1000 + (RAConstants.SECONDS_IN_A_DAY - 1);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Filter [selectedCountries=" + selectedCountries
				+ ", selectedAttributes=" + selectedAttributes
				+ ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + "]";
	}

	/**
	 * @return the filterString
	 */
	public String getFilterString() {
		return filterString;
	}

	/**
	 * @param filterString the filterString to set
	 */
	public void setFilterString(final String filterString) {
		this.filterString = filterString;
	}
	
}
