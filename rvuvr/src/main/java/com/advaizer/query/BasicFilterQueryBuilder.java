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
	
}
