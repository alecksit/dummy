/**
 * 
 */
package com.advaizer.enums;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author smruti
 *
 */
public enum BasicFilterConstants {
	
	
	@Autowired
	private String name;
	private BasicFilterConstants(final String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}

}
