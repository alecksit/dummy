/**
 * 
 */
package com.advaizer.enums;

/**
 * @author smruti
 *
 */
public enum LocationColumns {
	STATEID("stateid"),
	ISACTIVE("isactive"),
	STATENAME("statename"),
	AREAID("areaid"),
	AREANAME("areaname"),
	STATEZONE("zoneid"),
	ISMAJORCITY("ISMAJORCITY"),
	COMPANYLOCATION("companylocation"),
	COMPANYID("companyid"),
	COMPANYNAME("companyname"),
	BRANDID("brandid"),
	BRANDNAME("brandname"),
	PRODUCTID("productid"),
	PRODUCTNAME("productname"),
	LOCATIONID("locationid");

	
	private final String name;
	private LocationColumns(final String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}
	
}
