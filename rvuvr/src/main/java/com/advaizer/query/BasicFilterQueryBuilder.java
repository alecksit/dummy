/**
 * 
 */
package com.advaizer.query;
import com.advaizer.enums.LocationColumns;
import com.advaizer.enums.Relation;
/**
 * @author smruti
 *
 */
public class BasicFilterQueryBuilder {
	public static StringBuilder getAllStateQuery(final StringBuilder whereClause){
		
		final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(LocationColumns.STATEID).append(" stateid,")
		.append(LocationColumns.STATENAME).append(" statename from ").append(Relation.STATE).append(" where ").append(whereClause);
		
		return query;		
	}

	/**
	 * @param stringBuilder
	 * @return
	 */
	public static StringBuilder getStateAreaQuery(final StringBuilder whereClause) {
final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(LocationColumns.AREAID).append(" areaid,")
		.append(LocationColumns.AREANAME).append(" areaname from ").append(Relation.AREA).append(" where ").append(whereClause);
		
		return query;
	}
	public static StringBuilder getStateZoneQuery(final StringBuilder whereClause) {
		final StringBuilder query=new StringBuilder("");
				
				query.append("Select ").append(LocationColumns.STATEID).append(" stateid,")
				.append(LocationColumns.STATENAME).append(" statename from ").append(Relation.STATE).append(" where ").append(whereClause);
				
				return query;
			}
	public static StringBuilder getMajorZoneAreaQuery(final int zoneId) {
		final StringBuilder query=new StringBuilder("");
				
				query.append("Select ").append(Relation.AREA).append(".").append(LocationColumns.AREANAME).append(" areaname,").append(Relation.AREA).append(".").append(LocationColumns.AREAID)
				.append(" areaid").append(" from ").append(Relation.AREA).append(" inner join ")
				.append(Relation.STATE).append(" on ").append( Relation.STATE).append(".")
				.append(LocationColumns.STATEID).append("=").append(Relation.AREA).append(".")
				.append(LocationColumns.STATEID).append(" and ").append(Relation.STATE).append(".")
				.append(LocationColumns.STATEZONE).append("=").append(zoneId);
				return query;
	}
	
	/**
	 * @param locationId
	 * @return
	 */
	public static StringBuilder getCompaniesPerLocationQuery(final int locationId) {
		final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(LocationColumns.COMPANYID).append(" companyid,")
		.append(LocationColumns.COMPANYNAME).append(" companyname from ").append(Relation.COMPANY).append(" where ").append(LocationColumns.COMPANYLOCATION).append(" = ").append(locationId);
		
		return query;
			}

}