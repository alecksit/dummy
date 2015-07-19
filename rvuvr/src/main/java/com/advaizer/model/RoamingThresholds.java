/**
 * 
 */
package com.advaizer.model;

/**
 * @author smruti
 *
 */
public class RoamingThresholds {

	long countryId ;
	private String countryName;
	long thresholdId ;
	long moCallCount ;
	long moCallDuration ;
	long mtCallCount ;
	long mtCallDuration ;
	long moSmsCount ;
	long mtSmsCount ;
	long upLink ;
	long downLink ;
	long tonnage ;
	long timestamp ;
	
	 /**
	 * 
	 */
	public RoamingThresholds() {
	}
	
	/**
	 * @param countryId
	 * @param thresholdId
	 * @param moCallDuration
	 * @param mtCallDuration
	 * @param moSmsCount
	 * @param tonnage
	 */
	public RoamingThresholds(final long countryId, final long thresholdId,
			final long moCallDuration, final long mtCallDuration, final long moSmsCount, final long tonnage) {
		this.countryId = countryId;
		this.thresholdId = thresholdId;
		this.moCallDuration = moCallDuration;
		this.mtCallDuration = mtCallDuration;
		this.moSmsCount = moSmsCount;
		this.tonnage = tonnage;
	}
	/**
	 * @return the countryId
	 */
	public long getCountryId() {
		return countryId;
	}
	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(final long countryId) {
		this.countryId = countryId;
	}
	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(final String countryName) {
		this.countryName = countryName;
	}
	/**
	 * @return the thresholdId
	 */
	public long getThresholdId() {
		return thresholdId;
	}
	/**
	 * @param thresholdId the thresholdId to set
	 */
	public void setThresholdId(final long thresholdId) {
		this.thresholdId = thresholdId;
	}
	/**
	 * @return the moCallCount
	 */
	public long getMoCallCount() {
		return moCallCount;
	}
	/**
	 * @param moCallCount the moCallCount to set
	 */
	public void setMoCallCount(final long moCallCount) {
		this.moCallCount = moCallCount;
	}
	/**
	 * @return the moCallDuration
	 */
	public long getMoCallDuration() {
		return moCallDuration;
	}
	/**
	 * @param moCallDuration the moCallDuration to set
	 */
	public void setMoCallDuration(final long moCallDuration) {
		this.moCallDuration = moCallDuration;
	}
	/**
	 * @return the mtCallCount
	 */
	public long getMtCallCount() {
		return mtCallCount;
	}
	/**
	 * @param mtCallCount the mtCallCount to set
	 */
	public void setMtCallCount(final long mtCallCount) {
		this.mtCallCount = mtCallCount;
	}
	/**
	 * @return the mtCallDuration
	 */
	public long getMtCallDuration() {
		return mtCallDuration;
	}
	/**
	 * @param mtCallDuration the mtCallDuration to set
	 */
	public void setMtCallDuration(final long mtCallDuration) {
		this.mtCallDuration = mtCallDuration;
	}
	/**
	 * @return the moSmsCount
	 */
	public long getMoSmsCount() {
		return moSmsCount;
	}
	/**
	 * @param moSmsCount the moSmsCount to set
	 */
	public void setMoSmsCount(final long moSmsCount) {
		this.moSmsCount = moSmsCount;
	}
	/**
	 * @return the mtSmsCount
	 */
	public long getMtSmsCount() {
		return mtSmsCount;
	}
	/**
	 * @param mtSmsCount the mtSmsCount to set
	 */
	public void setMtSmsCount(final long mtSmsCount) {
		this.mtSmsCount = mtSmsCount;
	}
	/**
	 * @return the upLink
	 */
	public long getUpLink() {
		return upLink;
	}
	/**
	 * @param upLink the upLink to set
	 */
	public void setUpLink(final long upLink) {
		this.upLink = upLink;
	}
	/**
	 * @return the downLink
	 */
	public long getDownLink() {
		return downLink;
	}
	/**
	 * @param downLink the downLink to set
	 */
	public void setDownLink(final long downLink) {
		this.downLink = downLink;
	}
	/**
	 * @return the tonnage
	 */
	public long getTonnage() {
		return tonnage;
	}
	/**
	 * @param tonnage the tonnage to set
	 */
	public void setTonnage(final long tonnage) {
		this.tonnage = tonnage;
	}
	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(final long timestamp) {
		this.timestamp = timestamp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoamingThresholds [countryId=" + countryId + ", countryName="
				+ countryName + ", thresholdId=" + thresholdId
				+ ", moCallCount=" + moCallCount + ", moCallDuration="
				+ moCallDuration + ", mtCallCount=" + mtCallCount
				+ ", mtCallDuration=" + mtCallDuration + ", moSmsCount="
				+ moSmsCount + ", mtSmsCount=" + mtSmsCount + ", upLink="
				+ upLink + ", downLink=" + downLink + ", tonnage=" + tonnage
				+ ", timestamp=" + timestamp + "]";
	}
	
	

	
}
