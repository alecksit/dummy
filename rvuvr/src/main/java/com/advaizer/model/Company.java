/**
 * 
 */
package com.advaizer.model;

/**
 * @author ANKIT
 *
 */
public class Company {
	
	int companyId;
	String companyName;
	int companyLocation;
	int parentCompanyId;
	/**
	 * @return the companyid
	 */
	public int getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyid the companyid to set
	 */
	public void setCompanyId(final int companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the companyname
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyname the companyname to set
	 */
	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the companylocation
	 */
	public int getCompanyLocation() {
		return companyLocation;
	}
	/**
	 * @param companylocation the companylocation to set
	 */
	public void setCompanyLocation(final int companyLocation) {
		this.companyLocation = companyLocation;
	}
	/**
	 * @return the parentcompanyid
	 */
	public int getParentCompanyId() {
		return parentCompanyId;
	}
	/**
	 * @param parentcompanyid the parentcompanyid to set
	 */
	public void setParentCompanyId(final int parentCompanyId) {
		this.parentCompanyId = parentCompanyId;
	}
	
}
