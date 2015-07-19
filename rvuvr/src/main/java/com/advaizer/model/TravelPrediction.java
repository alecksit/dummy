/**
 * 
 */
package com.advaizer.model;

/**
 * @author smruti
 *
 */
public class TravelPrediction {
	
	long subscriberCount;
	long confidenceHigh;
	long confidenceMedium;
	long confidenceLow;
	long expectedUsageMtMin;
	long expectedUsageMtMax;
	long expectedUsageMoMin;
	long expectedUsageMoMax;
	long expectedUsageDataMin;
	long expectedUsageDataMax;
	long upSellPotentialMt;
	long upSellPotentialMo;
	long upSellPotentialData;
	String propensityCallback;
	String propensityVoip;
	String propensityRoamingPacks;
	int travelDurationMin;
	int travelDurationAvg;
	int travelDurationMax;
	String predictionType;
	/**
	 * @return the subscriberCount
	 */
	public long getSubscriberCount() {
		return subscriberCount;
	}
	/**
	 * @param subscriberCount the subscriberCount to set
	 */
	public void setSubscriberCount(final long subscriberCount) {
		this.subscriberCount = subscriberCount;
	}
	/**
	 * @return the confidenceHigh
	 */
	public long getConfidenceHigh() {
		return confidenceHigh;
	}
	/**
	 * @param confidenceHigh the confidenceHigh to set
	 */
	public void setConfidenceHigh(final long confidenceHigh) {
		this.confidenceHigh = confidenceHigh;
	}
	/**
	 * @return the confidenceMedium
	 */
	public long getConfidenceMedium() {
		return confidenceMedium;
	}
	/**
	 * @param confidenceMedium the confidenceMedium to set
	 */
	public void setConfidenceMedium(final long confidenceMedium) {
		this.confidenceMedium = confidenceMedium;
	}
	/**
	 * @return the confidenceLow
	 */
	public long getConfidenceLow() {
		return confidenceLow;
	}
	/**
	 * @param confidenceLow the confidenceLow to set
	 */
	public void setConfidenceLow(final long confidenceLow) {
		this.confidenceLow = confidenceLow;
	}
	/**
	 * @return the expectedUsageMtMin
	 */
	public long getExpectedUsageMtMin() {
		return expectedUsageMtMin;
	}
	/**
	 * @param expectedUsageMtMin the expectedUsageMtMin to set
	 */
	public void setExpectedUsageMtMin(final long expectedUsageMtMin) {
		this.expectedUsageMtMin = expectedUsageMtMin;
	}
	/**
	 * @return the expectedUsageMtMax
	 */
	public long getExpectedUsageMtMax() {
		return expectedUsageMtMax;
	}
	/**
	 * @param expectedUsageMtMax the expectedUsageMtMax to set
	 */
	public void setExpectedUsageMtMax(final long expectedUsageMtMax) {
		this.expectedUsageMtMax = expectedUsageMtMax;
	}
	/**
	 * @return the expectedUsageMoMin
	 */
	public long getExpectedUsageMoMin() {
		return expectedUsageMoMin;
	}
	/**
	 * @param expectedUsageMoMin the expectedUsageMoMin to set
	 */
	public void setExpectedUsageMoMin(final long expectedUsageMoMin) {
		this.expectedUsageMoMin = expectedUsageMoMin;
	}
	/**
	 * @return the expectedUsageMoMax
	 */
	public long getExpectedUsageMoMax() {
		return expectedUsageMoMax;
	}
	/**
	 * @param expectedUsageMoMax the expectedUsageMoMax to set
	 */
	public void setExpectedUsageMoMax(final long expectedUsageMoMax) {
		this.expectedUsageMoMax = expectedUsageMoMax;
	}
	/**
	 * @return the expectedUsageDataMin
	 */
	public long getExpectedUsageDataMin() {
		return expectedUsageDataMin;
	}
	/**
	 * @param expectedUsageDataMin the expectedUsageDataMin to set
	 */
	public void setExpectedUsageDataMin(final long expectedUsageDataMin) {
		this.expectedUsageDataMin = expectedUsageDataMin;
	}
	/**
	 * @return the expectedUsageDataMax
	 */
	public long getExpectedUsageDataMax() {
		return expectedUsageDataMax;
	}
	/**
	 * @param expectedUsageDataMax the expectedUsageDataMax to set
	 */
	public void setExpectedUsageDataMax(final long expectedUsageDataMax) {
		this.expectedUsageDataMax = expectedUsageDataMax;
	}
	/**
	 * @return the upSellPotentialMt
	 */
	public long getUpSellPotentialMt() {
		return upSellPotentialMt;
	}
	/**
	 * @param upSellPotentialMt the upSellPotentialMt to set
	 */
	public void setUpSellPotentialMt(final long upSellPotentialMt) {
		this.upSellPotentialMt = upSellPotentialMt;
	}
	/**
	 * @return the upSellPotentialMo
	 */
	public long getUpSellPotentialMo() {
		return upSellPotentialMo;
	}
	/**
	 * @param upSellPotentialMo the upSellPotentialMo to set
	 */
	public void setUpSellPotentialMo(final long upSellPotentialMo) {
		this.upSellPotentialMo = upSellPotentialMo;
	}
	/**
	 * @return the upSellPotentialData
	 */
	public long getUpSellPotentialData() {
		return upSellPotentialData;
	}
	/**
	 * @param upSellPotentialData the upSellPotentialData to set
	 */
	public void setUpSellPotentialData(final long upSellPotentialData) {
		this.upSellPotentialData = upSellPotentialData;
	}
	/**
	 * @return the propensityCallback
	 */
	public String getPropensityCallback() {
		return propensityCallback;
	}
	/**
	 * @param propensityCallback the propensityCallback to set
	 */
	public void setPropensityCallback(final String propensityCallback) {
		this.propensityCallback = propensityCallback;
	}
	/**
	 * @return the propensityVoip
	 */
	public String getPropensityVoip() {
		return propensityVoip;
	}
	/**
	 * @param propensityVoip the propensityVoip to set
	 */
	public void setPropensityVoip(final String propensityVoip) {
		this.propensityVoip = propensityVoip;
	}
	/**
	 * @return the propensityRoamingPacks
	 */
	public String getPropensityRoamingPacks() {
		return propensityRoamingPacks;
	}
	/**
	 * @param propensityRoamingPacks the propensityRoamingPacks to set
	 */
	public void setPropensityRoamingPacks(final String propensityRoamingPacks) {
		this.propensityRoamingPacks = propensityRoamingPacks;
	}
	/**
	 * @return the travelDurationMin
	 */
	public int getTravelDurationMin() {
		return travelDurationMin;
	}
	/**
	 * @param travelDurationMin the travelDurationMin to set
	 */
	public void setTravelDurationMin(final int travelDurationMin) {
		this.travelDurationMin = travelDurationMin;
	}
	/**
	 * @return the travelDurationAvg
	 */
	public int getTravelDurationAvg() {
		return travelDurationAvg;
	}
	/**
	 * @param travelDurationAvg the travelDurationAvg to set
	 */
	public void setTravelDurationAvg(final int travelDurationAvg) {
		this.travelDurationAvg = travelDurationAvg;
	}
	/**
	 * @return the travelDurationMax
	 */
	public int getTravelDurationMax() {
		return travelDurationMax;
	}
	/**
	 * @param travelDurationMax the travelDurationMax to set
	 */
	public void setTravelDurationMax(final int travelDurationMax) {
		this.travelDurationMax = travelDurationMax;
	}
	/**
	 * @return the predictionType
	 */
	public String getPredictionType() {
		return predictionType;
	}
	/**
	 * @param predictionType the predictionType to set
	 */
	public void setPredictionType(final String predictionType) {
		this.predictionType = predictionType;
	}
	
	

}
