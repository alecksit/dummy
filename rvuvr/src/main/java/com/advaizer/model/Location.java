/**
 * 
 */
package com.advaizer.model;

/**
 * @author ANKIT
 *
 */
public class Location {
	int locationId;
	int areaId;
	String locationName;
	/**
	 * @return the locationId
	 */
	public int getLocationId() {
		return locationId;
	}
	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(final int locationId) {
		this.locationId = locationId;
	}
	/**
	 * @return the areaId
	 */
	public int getAreaId() {
		return areaId;
	}
	/**
	 * @param areaId the areaId to set
	 */
	public void setAreaId(final int areaId) {
		this.areaId = areaId;
	}
	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}
	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(final String locationName) {
		this.locationName = locationName;
	}
	
}
