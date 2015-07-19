/**
 * 
 */
package com.advaizer.common;

import java.util.Calendar;
import java.util.TimeZone;

import com.advaizer.enums.Relation;
import com.advaizer.enums.RoamType;
import com.advaizer.model.Tag;

/**
 * @author cheshta
 *
 */
public class RoamerCampaignTrackerQueryBuilder {

	public static void populateQueryForRoamerCampaignTrackerSave(final StringBuilder query,
			final String roamType) {
		// TODO Auto-generated method stub
		
		query.append(" insert into ");
		if(RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)){
			query.append(Relation.ROAMERCAMPAIGNTRACKEROUT);
		}
		else if(RoamType.IN.getRoamType().equalsIgnoreCase(roamType)){
			query.append(Relation.ROAMERCAMPAIGNTRACKERIN);
		}
			
		query.append(" (tagid,imsi,campaigntime,targeted,adopted)")
			.append(" values(?,?,?,?,?)");			
		
	}

	/**
	 * @param query
	 * @param roamType
	 * @param campaignEndDate 
	 * @param campaignStartDate 
	 */
	public static void populateQueryForFetchingIMSI(final StringBuilder filterClause,final Tag tag,
			final StringBuilder query, final String roamType, final long campaignStartDate,
			final long campaignEndDate) {
						
		query.append("select distinct(trip.imsi) imsi");
		
		if(tag.getTagType().equalsIgnoreCase("BeforeTravel")){
			
			final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			final long currentTime=cal.getTimeInMillis()/1000;
			cal.add(Calendar.DAY_OF_YEAR, -7);
			final long sevenDaysAgo = cal.getTimeInMillis()/1000;
			
			query.append(" from ").append(RAPropertyUtil.getProperty("out.table.travelprediction")).append(" trip ");
			query.append(" where trip.predictiontime >= ").append(sevenDaysAgo)
			.append(" and trip.predictiontime <= ").append(currentTime);
		
			query.append(filterClause);

			
		}else if(RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)){
			query.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ");
			query.append(filterClause);
					
		}
		else if(RoamType.IN.getRoamType().equalsIgnoreCase(roamType)){
			query.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ");
			query.append(filterClause);
		}
		
		
	}
	
}
