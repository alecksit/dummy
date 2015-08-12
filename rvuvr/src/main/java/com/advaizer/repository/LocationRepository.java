/**
 * 
 */
package com.advaizer.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.advaizer.model.Product;

/**
 * @author smruti
 *
 */
public interface LocationRepository {
	
	public HashMap<Integer,String> getAllStatesRepository();

	/**
	 * @param stateId
	 * @return
	 */
	public Map<Integer, String> getStateAreaRepository(int stateId);

	/**

	 * @param statezone
	 * @return
	 */
	public Map<Integer, String> getZoneStateRepository(int statezone);
	
	/**
	 * @param 
	 * @return
	 */
	public Map<Integer, String> getMajorAreaRepository();

	/**
	 * @return
	 */
	public Map<Integer, String> getMajorZoneAreaRepository();

	/**
	 * @param zoneid
	 * @return
	 */
	public Map<Integer, String> getMajorZoneAreaRepository(int zoneid);

	/**
	 * @param locationId
	 * @return
	 */
	public Map<Integer, String> getCompaniesPerLocationRepository(int locationId);

	/**
	 * @param companyId
	 * @return
	 */
	public Map<Integer, String> getBrandsPerCompanyRepository(int companyId);

	/**
	 * @param locationId
	 * @return
	 */
	public Map<Integer, String> getBrandsPerLocationRepository(int locationId);

	/**
	 * @param locationId
	 * @return
	 */
	public Map<Integer, String> getProductsPerLocationRepository(int locationId);

	/**
	 * @param stateId
	 * @return
	 */
	public Map<Integer, String> getCompanyPerStateRepository(int stateId);

	/**
	 * @param companyId
	 * @return
	 */
	public Map<Integer, String> getProductPerCompanyRepository(int companyId);

	/**
	 * @param locationId
	 * @return
	 */
	public Map<Integer, String> getProductRatingPerLocationRepository(int locationId);

	/**
<<<<<<< HEAD
	 * @param brandData
	 * @return
	 */
	public Map<String, String> saveBrandDetails(Map<String, Object> brandData);
 
	 /* @param companyId
	 * @return
	 */
	public List<Product> getProductDetailPerCompanyRepository(int companyId);
 
	/**
	 * @return
	 */

}
