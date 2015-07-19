/**
 * 
 */
package com.advaizer.common;

import com.advaizer.enums.BusinessTableColumn;
import com.advaizer.enums.Relation;
import com.advaizer.enums.RoamType;
import com.advaizer.model.Filter;

/**
 * @author sarvesh
 *
 */
public class MetaDataQueryBuilder {

	/**
	 * Creates query for getting all attributes for left panel
	 * @return query
	 */
	
	public static String queryForTimeZone() {
		final StringBuilder query = new StringBuilder("select VALUE_STRING timeZone from ")
			.append(Relation.CONFIG).append(" where KEY_STRING = 'timeZone' ");
		return query.toString();
		
	}
	
	public static String queryForAttributes(final String roamType) {
		final StringBuilder query = new StringBuilder();
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append("select attr.id attrId, attr.name attrName, attr.applicablemodules moduleId, ")
				.append(" attr.dbcolumn db_column,  attr.columntype column_type, attr.charttype chart_type, ")
				.append(" stringIdMap.displaystring catName, stringIdMap.stringid catValue, attrValue.id catId, attr.measure measure, ")
				.append(" attr.isoverlay isoverlay ")
				.append(" from ").append(Relation.ATTRIBUTE).append(" attr left join ")
				.append(Relation.ATTRIBUTE_VALUE)
				.append(" attrValue on attr.id = attrValue.attributeid ")
				.append(" left join ").append(Relation.STRING_ID_MAP).append(" stringIdMap ")
				.append(" on stringIdMap.namespace = attrValue.namespace ")
				.append(" and stringIdMap.stringid = attrValue.stringid ")
				.append(" order by attr.displayorder, attrValue.displayorder");
		} else {
			query.append("select attr.id attrId, attr.name attrName, attr.applicablemodules moduleId, ")
				.append(" attr.dbcolumnin db_column,  attr.columntype column_type, attr.charttype chart_type, ")
				.append(" stringIdMap.displaystring catName, stringIdMap.stringid catValue, attrValue.id catId, attr.measure measure, ")
				.append(" attr.isoverlay isoverlay ")
				.append(" from ").append(Relation.ATTRIBUTE).append(" attr left join ")
				.append(Relation.ATTRIBUTE_VALUE)
				.append(" attrValue on attr.id = attrValue.attributeid ")
				.append(" left join ").append(Relation.STRING_ID_MAP).append(" stringIdMap ")
				.append(" on stringIdMap.namespace = attrValue.namespace ")
				.append(" and stringIdMap.stringid = attrValue.stringid ")
				.append(" order by attr.displayorder, attrValue.displayorder");
	}
		
		return query.toString();
	}
	

	/**
	 * Query for all countries.
	 *
	 * @return the string
	 */
	public static String queryForCountries(final Filter filter,final String roamType) {
		final StringBuilder query = new StringBuilder();

		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append(" select distinct trip.").append(BusinessTableColumn.VISITEDCOUNTRY).append(" countryName,")
				.append(" trip.").append(BusinessTableColumn.VISITEDCOUNTRYID).append(" countryid, ")
				.append(" trip.").append(BusinessTableColumn.ISNEIGHBOURING).append(" bordering, ")
				.append(" trip.").append(BusinessTableColumn.ISVISITEDCOUNTRYLEISURE).append(" leisure, ")
				.append(" trip.").append(BusinessTableColumn.ISVISITEDCOUNTRYLEISUREPREMIUM).append(" leisurePremium, ")
				.append(" trip.").append(BusinessTableColumn.VISITEDCOUNTRYGDP).append(" lowGDP ")
				.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ")
				.append(" where trip.usagebintime >= ").append(filter.getDateFrom())
				.append(" and trip.usagebintime <= ").append(filter.getDateTo()).append(" ");
			
			query.append(" order by trip.").append(BusinessTableColumn.VISITEDCOUNTRY);
		} else {
			query.append(" select distinct trip.").append(BusinessTableColumn.HOMECOUNTRY).append(" countryName,")
				.append(" trip.").append(BusinessTableColumn.HOMECOUNTRYID).append(" countryid, ")
				.append(" trip.").append(BusinessTableColumn.ISNEIGHBOURING).append(" bordering, ")
				.append(" trip.").append(BusinessTableColumn.ISHOMECOUNTRYLEISURE).append(" leisure, ")
				.append(" trip.").append(BusinessTableColumn.ISHOMECOUNTRYLEISUREPREMIUM).append(" leisurePremium, ")
				.append(" trip.").append(BusinessTableColumn.HOMECOUNTRYGDP).append(" lowGDP ")
				.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ")
				.append(" where trip.usagebintime >= ").append(filter.getDateFrom())
				.append(" and trip.usagebintime <= ").append(filter.getDateTo()).append(" ");
			query.append(" order by trip.").append(BusinessTableColumn.HOMECOUNTRY);
				
		}
		
		return query.toString();
	}
	
	

	/**
	 * Query for all countries.
	 *
	 * @return the string
	 */
	public static String queryForStaticCountries(final String roamType) {
		final StringBuilder query = new StringBuilder();

			query.append(" select country countryName,")
				.append("  countryid ")
				.append(" from countryib");	
		
		return query.toString();
	}
	
	/**
	 * Query for distinct networks.
	 *
	 * @return the string
	 */
	public static String queryForNetworkGroups(final Filter filter,final String roamType) {
		final StringBuilder query = new StringBuilder();
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append("select distinct trip.").append(BusinessTableColumn.VISITEDMCC).append(" mcc, ")
				.append(" trip.").append(BusinessTableColumn.VISITEDMNC).append(" mnc, ")
				.append(" trip.").append(BusinessTableColumn.VISITEDNETWORK).append(" networkName, ")
				.append(" trip.").append(BusinessTableColumn.VISITEDNETWORKGROUP).append(" networkGroup ")
				.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ")
				.append(" where trip.usagebintime >= ").append(filter.getDateFrom())
				.append(" and trip.usagebintime <= ").append(filter.getDateTo()).append(" ")
				.append(" order by trip.").append(BusinessTableColumn.VISITEDNETWORK);
		} else {
			query.append("select distinct trip.").append(BusinessTableColumn.HOMEMCC).append(" mcc, ")
				.append(" trip.").append(BusinessTableColumn.HOMEMNC).append(" mnc, ")
				.append(" trip.").append(BusinessTableColumn.HOMENETWORK).append(" networkName, ")
				.append(" trip.").append(BusinessTableColumn.HOMENETWORKGROUP).append(" networkGroup ")
				.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ")
				.append(" where trip.usagebintime >= ").append(filter.getDateFrom())
				.append(" and trip.usagebintime <= ").append(filter.getDateTo()).append(" ")
				.append(" order by trip.").append(BusinessTableColumn.HOMENETWORK);
		}
		return query.toString();
	}
	
	
	/**
	 * Query for distinct networks.
	 *
	 * @return the string
	 */
	public static String queryForDeviceModelAndManufacturer(final Filter filter,final String roamType) {
		final StringBuilder query = new StringBuilder();
		if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {
			query.append("select distinct trip.").append(BusinessTableColumn.DEVICEMODEL).append(" model, ")
				.append(" trip.").append(BusinessTableColumn.DEVICEMANUFACTURER).append(" manufacturer, ")
				.append(" trip.").append(BusinessTableColumn.DEVICECATEGORY).append(" devicecategory ")
				.append(" from ").append(RAPropertyUtil.getProperty("out.table.business")).append(" trip ")
				.append(" where trip.usagebintime >= ").append(filter.getDateFrom())
				.append(" and trip.usagebintime <= ").append(filter.getDateTo()).append(" ")
				.append(" and trip.").append(BusinessTableColumn.DEVICEMODEL).append(" != 'Unknown'")
				.append(" and trip.").append(BusinessTableColumn.DEVICEMANUFACTURER).append(" != 'Unknown'")
				.append(" and trip.").append(BusinessTableColumn.DEVICECATEGORY).append(" != 'Unknown'")
				.append(" order by model ");
		} else {
			query.append("select distinct trip.").append(BusinessTableColumn.DEVICEMODEL).append(" model, ")
				.append(" trip.").append(BusinessTableColumn.DEVICEMANUFACTURER).append(" manufacturer, ")
				.append(" trip.").append(BusinessTableColumn.DEVICECATEGORY).append(" devicecategory ")
				.append(" from ").append(RAPropertyUtil.getProperty("in.table.business")).append(" trip ")
				.append(" where trip.usagebintime >= ").append(filter.getDateFrom())
				.append(" and trip.usagebintime <= ").append(filter.getDateTo()).append(" ")
				.append(" and trip.").append(BusinessTableColumn.DEVICEMODEL).append(" != 'Unknown'")
				.append(" and trip.").append(BusinessTableColumn.DEVICEMANUFACTURER).append(" != 'Unknown'")
				.append(" and trip.").append(BusinessTableColumn.DEVICECATEGORY).append(" != 'Unknown'")
				.append(" order by model ");
		}
		return query.toString();
	}
}
