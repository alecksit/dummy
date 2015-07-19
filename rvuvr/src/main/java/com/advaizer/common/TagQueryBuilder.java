/**
 * 
 */
package com.advaizer.common;

import java.util.Map;

import com.advaizer.enums.Relation;
import com.advaizer.enums.RoamType;
import com.advaizer.model.Filter;

/**
 * @author cheshta
 *
 */
public class TagQueryBuilder {

	
	/**
	 * @param query existing track details
	 */
	public static void populateQueryForTagDetails(final StringBuilder query, final Relation relation) {
		// TODO Auto-generated method stub		
		query.append(" select count(*) AS tagCount from ")
		.append(relation).append(" WHERE tagname = ?");			
	}

	/**
	 * @param filter
	 * @param query
	 * @param parameterMap
	 * @param filterString
	 * @param roamType
	 * @param campaignFrequency
	 */
	public static void populateQueryForTagSave(final StringBuilder query,
			final String roamType,final String tagType, final int campaignFrequency, final Filter filter, final StringBuilder filterClause) {
		// TODO Auto-generated method stub
						
		query.append(" insert into ");
		if(RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)){
			query.append(Relation.TAGOUT);
		}
		else if(RoamType.IN.getRoamType().equalsIgnoreCase(roamType)){
			query.append(Relation.TAGIN);
		}
			
		query.append(" (tagname,tagtype,filterlabel,filterstring,campaignfrequency,campaigndurationstarttime,"
					+ "campaigndurationendtime,monitoringdurationstarttime,monitoringdurationendtime,"
					+ "projectedusagemomin,projectedusagemomax,projectedusagemtmin,projectedusagemtmax,"
					+ "projectedusagedatamin,projectedusagedatamax)")
			.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		
		if (!filter.getSelectedCountries().isEmpty()) {
			filterClause.append(StatsQueryBuilder.getClauseForCountryTags(filter.getSelectedCountries(), roamType));
		}	
		
		final Map<String,String> filterParameters = filter.getSelectedAttributes();
		if(tagType.equalsIgnoreCase("BeforeTravel")){
			for (final String columnName : filterParameters.keySet()) {
				if(columnName.toLowerCase().indexOf(RAPropertyUtil.getProperty("out.travelprediction.na").toLowerCase())!=-1){
					filterParameters.put(columnName,"");
				}
			}
		}
		
		StatsQueryBuilder.appendClauseForAttributesTags(filterClause, filterParameters);
			
	}
	
	/**
	 * @param roamType
	 * @return
	 */
	public static String queryForAllTags(final String roamType, final String ids) {
		final StringBuilder query = new StringBuilder();
		query.append(
				"SELECT id, tagname, tagtype, filterlabel, filterstring,"
				+ " campaignfrequency, campaigndurationstarttime, campaigndurationendtime,"
				+ " monitoringdurationstarttime, monitoringdurationendtime, projectedusagemomin, "
				+ " projectedusagemomax, projectedusagemtmin, projectedusagemtmax, projectedusagedatamin,"
				+ " projectedusagedatamax FROM ");
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append(Relation.TAGOUT);
		} else {
			query.append(Relation.TAGIN);

		}
		if (ids != null && !ids.isEmpty()) {
			query.append(" where id in (").append(ids).append(")");
		}
		query.append(" order by id asc");
		return query.toString();
	}
	
	
	
}
