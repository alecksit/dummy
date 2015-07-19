/**
 * 
 */
package com.advaizer.model;

import java.util.HashMap;
import java.util.Map;

import com.advaizer.enums.RoamType;

/**
 * @author cheshta
 *
 */
public class Tag {
	
	private long id;
	
	private RoamType roamType;
	
	private String tagName;
	
	private String tagType;
	
	private String filterString;
	
	private String filterLabel;
	
	//in hours
	private int campaignFrequency;
	
	private String campaignDurationStartTime;
	
	private String campaignDurationEndTime;
	
	private String monitoringDurationStartTime;
	
	private String monitoringDurationEndTime;
	
	private int projectedUsageMoMin;
	
	private int projectedUsageMoMax;
	
	private int projectedUsageMtMin;
	
	private int projectedUsageMtMax;
	
	private int projectedUsageDataMin;
	
	private int projectedUsageDataMax;
	
	//fields not in db follow from here
	private int subscribersSegment;
	
	private int subscribersTargetted;
	
	private int subscribersTravelled;
	
	private int subscribersAdopted;
	
	private int expectedUsageMoMin;
	
	private int expectedUsageMoMax;
	
	private int expectedUsageMtMin;
	
	private int expectedUsageMtMax;
	
	private int expectedUsageDataMin;
	
	private int expectedUsageDataMax;
	
	private int actualUsageMo;
		
	private int actualUsageMt;
			
	private int actualUsageData;	
		
	private int projectedDurationMin;
	
	private int projectedDurationMax;
	
	private int projectedDurationAvg;
	
	private int actualDurationMin;
	
	private int actualDurationMax;
	
	private int actualDurationAvg;
	
	//for propensity	
	private String projectedUsageSeamlessCallback;
	
	private String projectedUsageVoip;
	
	private String projectedUsageRoamingPacks;	

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
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(final String tagName) {
		this.tagName = tagName;
	}

	/**
	 * @return the tagType
	 */
	public String getTagType() {
		return tagType;
	}

	/**
	 * @param tagType the tagType to set
	 */
	public void setTagType(final String tagType) {
		this.tagType = tagType;
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

	/**
	 * @return the campaignFrequency
	 */
	public int getCampaignFrequency() {
		return campaignFrequency;
	}

	/**
	 * @param campaignFrequency the campaignFrequency to set
	 */
	public void setCampaignFrequency(final int campaignFrequency) {
		this.campaignFrequency = campaignFrequency;
	}

	/**
	 * @return the campaignDurationStartTime
	 */
	public String getCampaignDurationStartTime() {
		return campaignDurationStartTime;
	}

	/**
	 * @param campaignDurationStartTime the campaignDurationStartTime to set
	 */
	public void setCampaignDurationStartTime(final String campaignDurationStartTime) {
		this.campaignDurationStartTime = campaignDurationStartTime;
	}

	/**
	 * @return the campaignDurationEndTime
	 */
	public String getCampaignDurationEndTime() {
		return campaignDurationEndTime;
	}

	/**
	 * @param campaignDurationEndTime the campaignDurationEndTime to set
	 */
	public void setCampaignDurationEndTime(final String campaignDurationEndTime) {
		this.campaignDurationEndTime = campaignDurationEndTime;
	}

	/**
	 * @return the monitoringDurationStartTime
	 */
	public String getMonitoringDurationStartTime() {
		return monitoringDurationStartTime;
	}

	/**
	 * @param monitoringDurationStartTime the monitoringDurationStartTime to set
	 */
	public void setMonitoringDurationStartTime(
			final String monitoringDurationStartTime) {
		this.monitoringDurationStartTime = monitoringDurationStartTime;
	}

	/**
	 * @return the monitoringDurationEndTime
	 */
	public String getMonitoringDurationEndTime() {
		return monitoringDurationEndTime;
	}

	/**
	 * @param monitoringDurationEndTime the monitoringDurationEndTime to set
	 */
	public void setMonitoringDurationEndTime(final String monitoringDurationEndTime) {
		this.monitoringDurationEndTime = monitoringDurationEndTime;
	}

	/**
	 * @return the projectedUsageMoMin
	 */
	public int getProjectedUsageMoMin() {
		return projectedUsageMoMin;
	}

	/**
	 * @param projectedUsageMoMin the projectedUsageMoMin to set
	 */
	public void setProjectedUsageMoMin(final int projectedUsageMoMin) {
		this.projectedUsageMoMin = projectedUsageMoMin;
	}

	/**
	 * @return the projectedUsageMoMax
	 */
	public int getProjectedUsageMoMax() {
		return projectedUsageMoMax;
	}

	/**
	 * @param projectedUsageMoMax the projectedUsageMoMax to set
	 */
	public void setProjectedUsageMoMax(final int projectedUsageMoMax) {
		this.projectedUsageMoMax = projectedUsageMoMax;
	}

	/**
	 * @return the projectedUsageMtMin
	 */
	public int getProjectedUsageMtMin() {
		return projectedUsageMtMin;
	}

	/**
	 * @param projectedUsageMtMin the projectedUsageMtMin to set
	 */
	public void setProjectedUsageMtMin(final int projectedUsageMtMin) {
		this.projectedUsageMtMin = projectedUsageMtMin;
	}

	/**
	 * @return the projectedUsageMtMax
	 */
	public int getProjectedUsageMtMax() {
		return projectedUsageMtMax;
	}

	/**
	 * @param projectedUsageMtMax the projectedUsageMtMax to set
	 */
	public void setProjectedUsageMtMax(final int projectedUsageMtMax) {
		this.projectedUsageMtMax = projectedUsageMtMax;
	}

	/**
	 * @return the projectedUsageDataMin
	 */
	public int getProjectedUsageDataMin() {
		return projectedUsageDataMin;
	}

	/**
	 * @param projectedUsageDataMin the projectedUsageDataMin to set
	 */
	public void setProjectedUsageDataMin(final int projectedUsageDataMin) {
		this.projectedUsageDataMin = projectedUsageDataMin;
	}

	/**
	 * @return the projectedUsageDataMax
	 */
	public int getProjectedUsageDataMax() {
		return projectedUsageDataMax;
	}

	/**
	 * @param projectedUsageDataMax the projectedUsageDataMax to set
	 */
	public void setProjectedUsageDataMax(final int projectedUsageDataMax) {
		this.projectedUsageDataMax = projectedUsageDataMax;
	}

	/**
	 * @return the subscribersSegment
	 */
	public int getSubscribersSegment() {
		return subscribersSegment;
	}

	/**
	 * @param subscribersSegment the subscribersSegment to set
	 */
	public void setSubscribersSegment(final int subscribersSegment) {
		this.subscribersSegment = subscribersSegment;
	}

	/**
	 * @return the subscribersTargetted
	 */
	public int getSubscribersTargetted() {
		return subscribersTargetted;
	}

	/**
	 * @param subscribersTargetted the subscribersTargetted to set
	 */
	public void setSubscribersTargetted(final int subscribersTargetted) {
		this.subscribersTargetted = subscribersTargetted;
	}

	/**
	 * @return the subscribersTravelled
	 */
	public int getSubscribersTravelled() {
		return subscribersTravelled;
	}

	/**
	 * @param subscribersTravelled the subscribersTravelled to set
	 */
	public void setSubscribersTravelled(final int subscribersTravelled) {
		this.subscribersTravelled = subscribersTravelled;
	}

	/**
	 * @return the subscribersAdopted
	 */
	public int getSubscribersAdopted() {
		return subscribersAdopted;
	}

	/**
	 * @param subscribersAdopted the subscribersAdopted to set
	 */
	public void setSubscribersAdopted(final int subscribersAdopted) {
		this.subscribersAdopted = subscribersAdopted;
	}

	/**
	 * @return the expectedUsageMoMin
	 */
	public int getExpectedUsageMoMin() {
		return expectedUsageMoMin;
	}

	/**
	 * @param expectedUsageMoMin the expectedUsageMoMin to set
	 */
	public void setExpectedUsageMoMin(final int expectedUsageMoMin) {
		this.expectedUsageMoMin = expectedUsageMoMin;
	}

	/**
	 * @return the expectedUsageMoMax
	 */
	public int getExpectedUsageMoMax() {
		return expectedUsageMoMax;
	}

	/**
	 * @param expectedUsageMoMax the expectedUsageMoMax to set
	 */
	public void setExpectedUsageMoMax(final int expectedUsageMoMax) {
		this.expectedUsageMoMax = expectedUsageMoMax;
	}

	/**
	 * @return the expectedUsageMtMin
	 */
	public int getExpectedUsageMtMin() {
		return expectedUsageMtMin;
	}

	/**
	 * @param expectedUsageMtMin the expectedUsageMtMin to set
	 */
	public void setExpectedUsageMtMin(final int expectedUsageMtMin) {
		this.expectedUsageMtMin = expectedUsageMtMin;
	}

	/**
	 * @return the expectedUsageMtMax
	 */
	public int getExpectedUsageMtMax() {
		return expectedUsageMtMax;
	}

	/**
	 * @param expectedUsageMtMax the expectedUsageMtMax to set
	 */
	public void setExpectedUsageMtMax(final int expectedUsageMtMax) {
		this.expectedUsageMtMax = expectedUsageMtMax;
	}

	/**
	 * @return the expectedUsageDataMin
	 */
	public int getExpectedUsageDataMin() {
		return expectedUsageDataMin;
	}

	/**
	 * @param expectedUsageDataMin the expectedUsageDataMin to set
	 */
	public void setExpectedUsageDataMin(final int expectedUsageDataMin) {
		this.expectedUsageDataMin = expectedUsageDataMin;
	}

	/**
	 * @return the expectedUsageDataMax
	 */
	public int getExpectedUsageDataMax() {
		return expectedUsageDataMax;
	}

	/**
	 * @param expectedUsageDataMax the expectedUsageDataMax to set
	 */
	public void setExpectedUsageDataMax(final int expectedUsageDataMax) {
		this.expectedUsageDataMax = expectedUsageDataMax;
	}

	/**
	 * @return the actualUsageMoMin
	 */
	public int getActualUsageMoMin() {
		return actualUsageMo;
	}

	/**
	 * @param actualUsageMoMin the actualUsageMoMin to set
	 */
	public void setActualUsageMoMin(final int actualUsageMoMin) {
		this.actualUsageMo = actualUsageMoMin;
	}
	
	/**
	 * @return the actualUsageMtMin
	 */
	public int getActualUsageMtMin() {
		return actualUsageMt;
	}

	/**
	 * @param actualUsageMtMin the actualUsageMtMin to set
	 */
	public void setActualUsageMtMin(final int actualUsageMtMin) {
		this.actualUsageMt = actualUsageMtMin;
	}

	/**
	 * @return the actualUsageDataMin
	 */
	public int getActualUsageDataMin() {
		return actualUsageData;
	}

	/**
	 * @param actualUsageDataMin the actualUsageDataMin to set
	 */
	public void setActualUsageDataMin(final int actualUsageDataMin) {
		this.actualUsageData = actualUsageDataMin;
	}

	/**
	 * @return the projectedDurationMin
	 */
	public int getProjectedDurationMin() {
		return projectedDurationMin;
	}

	/**
	 * @param projectedDurationMin the projectedDurationMin to set
	 */
	public void setProjectedDurationMin(final int projectedDurationMin) {
		this.projectedDurationMin = projectedDurationMin;
	}

	/**
	 * @return the projectedDurationMax
	 */
	public int getProjectedDurationMax() {
		return projectedDurationMax;
	}

	/**
	 * @param projectedDurationMax the projectedDurationMax to set
	 */
	public void setProjectedDurationMax(final int projectedDurationMax) {
		this.projectedDurationMax = projectedDurationMax;
	}

	/**
	 * @return the projectedDurationAvg
	 */
	public int getProjectedDurationAvg() {
		return projectedDurationAvg;
	}

	/**
	 * @param projectedDurationAvg the projectedDurationAvg to set
	 */
	public void setProjectedDurationAvg(final int projectedDurationAvg) {
		this.projectedDurationAvg = projectedDurationAvg;
	}

	/**
	 * @return the actualDurationMin
	 */
	public int getActualDurationMin() {
		return actualDurationMin;
	}

	/**
	 * @param actualDurationMin the actualDurationMin to set
	 */
	public void setActualDurationMin(final int actualDurationMin) {
		this.actualDurationMin = actualDurationMin;
	}

	/**
	 * @return the actualDurationMax
	 */
	public int getActualDurationMax() {
		return actualDurationMax;
	}

	/**
	 * @param actualDurationMax the actualDurationMax to set
	 */
	public void setActualDurationMax(final int actualDurationMax) {
		this.actualDurationMax = actualDurationMax;
	}

	/**
	 * @return the actualDurationAvg
	 */
	public int getActualDurationAvg() {
		return actualDurationAvg;
	}

	/**
	 * @param actualDurationAvg the actualDurationAvg to set
	 */
	public void setActualDurationAvg(final int actualDurationAvg) {
		this.actualDurationAvg = actualDurationAvg;
	}

	/**
	 * @return the projectedUsageSeamlessCallback
	 */
	public String getProjectedUsageSeamlessCallback() {
		return projectedUsageSeamlessCallback;
	}

	/**
	 * @param projectedUsageSeamlessCallback the projectedUsageSeamlessCallback to set
	 */
	public void setProjectedUsageSeamlessCallback(
			final String projectedUsageSeamlessCallback) {
		this.projectedUsageSeamlessCallback = projectedUsageSeamlessCallback;
	}

	/**
	 * @return the projectedUsageVoip
	 */
	public String getProjectedUsageVoip() {
		return projectedUsageVoip;
	}

	/**
	 * @param projectedUsageVoip the projectedUsageVoip to set
	 */
	public void setProjectedUsageVoip(final String projectedUsageVoip) {
		this.projectedUsageVoip = projectedUsageVoip;
	}

	/**
	 * @return the projectedUsageRoamingPacks
	 */
	public String getProjectedUsageRoamingPacks() {
		return projectedUsageRoamingPacks;
	}

	/**
	 * @param projectedUsageRoamingPacks the projectedUsageRoamingPacks to set
	 */
	public void setProjectedUsageRoamingPacks(final String projectedUsageRoamingPacks) {
		this.projectedUsageRoamingPacks = projectedUsageRoamingPacks;
	}

	/**
	 * @return Map<String, String> containing Tag details
	 */
	public Map<String, String> convertToMap() {
		// TODO Auto-generated method stub
		final Map<String,String> tagMap = new HashMap<String,String>();
		
		tagMap.put("id", ""+id);
		tagMap.put("tagname", tagName);
		tagMap.put("filterstring", filterString);		
		tagMap.put("filterlabel", filterLabel);	
		tagMap.put("campaignFrequency", ""+campaignFrequency);			
		tagMap.put("campaigndurationstarttime", campaignDurationStartTime);			
		tagMap.put("campaigndurationendtime", campaignDurationEndTime);		
		tagMap.put("monitoringdurationstarttime", monitoringDurationStartTime);		
		tagMap.put("monitoringdurationendtime", monitoringDurationEndTime);	
		
		return tagMap;	
	}

	

	
}
