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

	/**
	 * @param companyId
	 * @return
	 */
	public static Object getBrandsPerCompanyQuery(final int companyId) {
		// TODO Auto-generated method stub
final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(LocationColumns.BRANDID).append(" brandid,")
		.append(LocationColumns.BRANDNAME).append(" brandname from ").append(Relation.BRAND).append(" where ").append(LocationColumns.COMPANYID).append(" = ").append(companyId);
		
		return query;
	}

	/**
	 * @param locationId
	 * @return
	 */
	public static Object getBrandsPerLocationQuery(final int locationId) {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(Relation.BRAND).append(".").append(LocationColumns.BRANDID).append(" brandid,").append(Relation.BRAND).append(".").append(LocationColumns.BRANDNAME)
		.append(" brandname").append(" from ").append(Relation.BRAND).append(" inner join ")
		.append(Relation.COMPANY).append(" on ").append( Relation.BRAND).append(".")
		.append(LocationColumns.COMPANYID).append("=").append(Relation.COMPANY).append(".")
		.append(LocationColumns.COMPANYID).append(" and ").append(Relation.COMPANY).append(".")
		.append(LocationColumns.COMPANYLOCATION).append("=").append(locationId);
		return query;
	}

}