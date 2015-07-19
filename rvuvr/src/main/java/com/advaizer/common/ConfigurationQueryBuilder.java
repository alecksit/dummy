/**
 * 
 */
package com.advaizer.common;


import com.advaizer.enums.Relation;
import com.advaizer.enums.RoamType;
import com.advaizer.enums.ThresholdColumn;
import com.advaizer.model.RoamingThresholds;

/**
 * @author smruti
 *
 */
public class ConfigurationQueryBuilder {
	
	/**
	 * Creates query for getting all thresholds
	 * @return query
	 */
	
	public static String queryForThresholdsListing(final String roamType) {
		final StringBuilder query = new StringBuilder(" ");
		
		if(RoamType.OUT.getRoamType().equalsIgnoreCase(roamType))
		{
			query.append("select country_id ,threshold_id, mo_call_duration ,  mt_call_duration , mo_sms_count , tonnage,timestamp from "+Relation.ROAMING_THRESHOLDS_OUT+" where timestamp=0 union all select distinct country_id , threshold_id, mo_call_duration ,  mt_call_duration , mo_sms_count , tonnage, timestamp from "+Relation.ROAMING_THRESHOLDS_OUT
					+" where timestamp=(select max(timestamp) from "+Relation.ROAMING_THRESHOLDS_OUT+")  and country_id not in (select distinct country_id from "+Relation.ROAMING_THRESHOLDS_OUT+" where timestamp=0) order by timestamp,country_id,threshold_id ");
		}else{

			query.append("select country_id ,threshold_id, mo_call_duration ,  mt_call_duration , mo_sms_count , tonnage,timestamp from  "+Relation.ROAMING_THRESHOLDS_IN+" where timestamp=0 union all select distinct country_id , threshold_id, mo_call_duration ,  mt_call_duration , mo_sms_count , tonnage, timestamp from "+Relation.ROAMING_THRESHOLDS_IN
					+" where timestamp=(select max(timestamp) from "+Relation.ROAMING_THRESHOLDS_IN+")  and country_id not in (select distinct country_id from "+Relation.ROAMING_THRESHOLDS_IN+" where timestamp=0) order by timestamp,country_id,threshold_id ");
		}
		return query.toString();
		
	}
	
	
	public static String queryForSystemGeneratedCountry(final String roamType, final int countryId) {
		final StringBuilder query = new StringBuilder(" ");

		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append("select country_id ,threshold_id, mo_call_duration,  mt_call_duration, mo_sms_count,")
				.append(" tonnage,timestamp from ").append(Relation.ROAMING_THRESHOLDS_OUT)
				.append(" where country_id = ").append(countryId).append(" and timestamp > 0 ")
				.append(" and timestamp = (select max(timestamp) from ")
				.append(Relation.ROAMING_THRESHOLDS_OUT).append(") order by threshold_id ");
		} else {
			query.append("select country_id ,threshold_id, mo_call_duration,  mt_call_duration, mo_sms_count,")
				.append(" tonnage,timestamp from ").append(Relation.ROAMING_THRESHOLDS_IN)
				.append(" where country_id = ").append(countryId).append(" and timestamp > 0 ")
				.append(" and timestamp = (select max(timestamp) from ")
				.append(Relation.ROAMING_THRESHOLDS_IN).append(") order by order by threshold_id ");
		}
		return query.toString();
	}
	public static String queryForSaveConfiguration(final String roamType, final int countryId,
			final RoamingThresholds threshold)  {
		final StringBuilder insertQuery = new StringBuilder();
		insertQuery.append(" insert into ");
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			insertQuery.append(Relation.ROAMING_THRESHOLDS_OUT);
		} else {
			insertQuery.append(Relation.ROAMING_THRESHOLDS_IN);
		}
		
		insertQuery.append(" (")
			.append(ThresholdColumn.COUNTRY_ID).append(RAConstants.COMMA)
			.append(ThresholdColumn.THRESHOLD_ID).append(RAConstants.COMMA)
			.append(ThresholdColumn.MO_CALL_DURATION).append(RAConstants.COMMA)
			.append(ThresholdColumn.MT_CALL_DURATION).append(RAConstants.COMMA)
			.append(ThresholdColumn.MO_SMS_COUNT).append(RAConstants.COMMA)
			.append(ThresholdColumn.TONNAGE).append(RAConstants.COMMA)
			.append(ThresholdColumn.TIMESTAMP)
			.append(") ").append(" values (")
			.append(threshold.getCountryId()).append(RAConstants.COMMA)
			.append(threshold.getThresholdId()).append(RAConstants.COMMA)
			.append(threshold.getMoCallDuration()).append(RAConstants.COMMA)
			.append(threshold.getMtCallDuration()).append(RAConstants.COMMA)
			.append(threshold.getMoSmsCount()).append(RAConstants.COMMA)
			.append(threshold.getTonnage()).append(RAConstants.COMMA)
			.append(0).append(")");
		return insertQuery.toString();
		
	}
	
	public static String queryForDeleteThreshold(final String roamType, final int countryId) {
		final StringBuilder deleteQuery = new StringBuilder();
		deleteQuery.append(" delete from ");
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			deleteQuery.append(Relation.ROAMING_THRESHOLDS_OUT);
		} else {
			deleteQuery.append(Relation.ROAMING_THRESHOLDS_IN);
		}
		deleteQuery.append(" where ").append(ThresholdColumn.COUNTRY_ID).append(" = ").append(countryId)
			.append(" and ").append(ThresholdColumn.TIMESTAMP).append(" = 0");
		return deleteQuery.toString();
	}
	

}
