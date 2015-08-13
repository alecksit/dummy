/**
 * 
 */
package com.advaizer.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.advaizer.model.Area;
import com.advaizer.model.Category;
import com.advaizer.model.Company;
import com.advaizer.model.Location;
import com.advaizer.model.Product;
import com.advaizer.model.ProductBrand;
import com.advaizer.model.ProductRating;
import com.advaizer.model.User;

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
	public Map<String, String> saveBrandDetails(final ProductBrand brandData);
 
	 /* @param companyId
	 * @return
	 */
	public List<Product> getProductDetailPerCompanyRepository(int companyId);

	/**
	 * @param areaData
	 * @return
	 */
	public Map<String, String> saveAreaDetails(final Area areaData);

	/**
	 * @param categoryData
	 * @return
	 */
	public Map<String, String> saveCategoryDetails(final Category categoryData);

	/**
	 * @param companyData
	 * @return
	 */
	public Map<String, String> saveCompanyDetails(final Company companyData);

	/**
	 * @param locationData
	 * @return
	 */
	public Map<String, String> saveLocationDetails(final Location locationData);

	/**
	 * @param productData
	 * @return
	 */
	public Map<String, String> saveProductDetails(final Product productData);

	/**
	 * @param productRatingData
	 * @return
	 */
	public Map<String, String> saveProductRatingDetails(final ProductRating productRatingData);

	/**
	 * @param userData
	 * @return
	 */
	public Map<String, String> saveUserDetails(final User userData);

	/**
	 * @param categoryData
	 * @return
	 */
 
	/**
	 * @return
	 */

}
