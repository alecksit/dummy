/**
 * 
 */
package com.advaizer.model;

/**
 * @author ANKIT
 *
 */
public class Company {
	
	int companyid;
	String companyname;
	int companylocation;
	int parentcompanyid;
	/**
	 * @return the companyid
	 */
	public int getCompanyid() {
		return companyid;
	}
	/**
	 * @param companyid the companyid to set
	 */
	public void setCompanyid(final int companyid) {
		this.companyid = companyid;
	}
	/**
	 * @return the companyname
	 */
	public String getCompanyname() {
		return companyname;
	}
	/**
	 * @param companyname the companyname to set
	 */
	public void setCompanyname(final String companyname) {
		this.companyname = companyname;
	}
	/**
	 * @return the companylocation
	 */
	public int getCompanylocation() {
		return companylocation;
	}
	/**
	 * @param companylocation the companylocation to set
	 */
	public void setCompanylocation(final int companylocation) {
		this.companylocation = companylocation;
	}
	/**
	 * @return the parentcompanyid
	 */
	public int getParentcompanyid() {
		return parentcompanyid;
	}
	/**
	 * @param parentcompanyid the parentcompanyid to set
	 */
	public void setParentcompanyid(final int parentcompanyid) {
		this.parentcompanyid = parentcompanyid;
	}
	
	

}
