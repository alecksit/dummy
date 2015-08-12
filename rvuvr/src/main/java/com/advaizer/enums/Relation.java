/**
 * 
 */
package com.advaizer.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum Relation.
 *
 * @author smruti
 */
public enum Relation {
	
	/** The attribute. */
	STATE("stateinfo"),
	
	/** The attribute. */
	AREA("areainfo"),
	PRODUCT("productinfo"),
	LOCATION("locationinfo"),
	CATEGORY("categoryinfo"),
	COMPANY("companyinfo"),
	BRAND("brandinfo"),
	PRODUCTRATINGS("productratings"),
	
	/** The attribute category. */
	ATTRIBUTE_CATEGORY("ATTRIBUTE_CATEGORY"),
	
	;
	
	/** The table name. */
	private String tableName;
	
	/**
	 * Instantiates a new table.
	 *
	 * @param tableName the table name
	 */
	Relation(final String tableName) {
		this.tableName = tableName;
	}
	
	/**
	 * Gets the table name.
	 *
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.tableName;
	}

}
