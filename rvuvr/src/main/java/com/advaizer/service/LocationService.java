/**
 * 
 */
package com.advaizer.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smruti
 *
 */
public interface LocationService {
	
	public HashMap<Integer,String> getAllStatesService();
	/**
	 * @param stateId
	 * @return
	 */
	public Map<Integer, String> getStateAreaService(int stateId);

	/**

	 * @param statezone
	 * @return
	 */
	public Map<Integer, String> getZoneStateService(int statezone);

	 /* @return
	 */
	public Map<Integer, String> getMajorAreaService();
	
	/**
	 * @return
	 */
	public Map<Integer, String> getMajorZoneAreaService();

	/**
	 * @param zoneid
	 * @return
	 */
	Map<Integer, String> getMajorZoneAreaService(int zoneid);

	/**
	 * @param locationId
	 * @return
	 */
	public Map<Integer, String> getCompaniesPerLocationService(int locationId);
	/**
	 * @param companyId
	 * @return
	 */
	public Map<Integer, String> getBrandsPerCompanyService(int companyId);
	/**
	 * @param locationId
	 * @return
	 */
	public Map<Integer, String> getBrandsPerLocationService(int locationId);
	/**
	 * @param locationId
	 * @return
	 */
	public Map<Integer, String> getProductsPerLocationService(int locationId);
	/**
	 * @param stateId
	 * @return
	 */
	public Map<Integer, String> getCompanyPerStateService(int stateId);
	/**
	 * @param companyId
	 * @return
	 */
	public Map<Integer, String> getProductPerCompanyService(int companyId);
	/**
	 * @param locationId
	 * @return
	 */
	public Map<Integer, String> getProductRatingPerLocationService(int locationId);


}
