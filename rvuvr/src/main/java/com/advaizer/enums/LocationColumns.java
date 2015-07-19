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
	STATENAME("statename");
	
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
