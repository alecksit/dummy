/**
 * 
 */
package com.advaizer.model;

/**
 * @author ANKIT
 *
 */
public class Service {
	int serviceId;
	String serviceName;
	int brandId;
	/**
	 * @return the serviceId
	 */
	public int getServiceId() {
		return serviceId;
	}
	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(final int serviceId) {
		this.serviceId = serviceId;
	}
	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}
	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(final String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * @return the brandId
	 */
	public int getBrandId() {
		return brandId;
	}
	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(final int brandId) {
		this.brandId = brandId;
	}

}
