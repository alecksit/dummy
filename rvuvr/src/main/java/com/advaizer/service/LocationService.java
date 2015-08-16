/**
 * 
 */
package com.advaizer.service;

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
import com.advaizer.model.Service;
import com.advaizer.model.User;

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
	/**
<<<<<<< HEAD
	 * @param brandData
	 * @return
	 */
	public Map<String, String> saveBrandDetails(final ProductBrand brandData);
 
	 /* @param companyId
	 * @return
	 */
	public List<Product> getProductDetailPerCompanyService(int companyId);
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
	 * @param productData
	 * @return
	 */
	public Map<String, String> saveProductDetails( final Product productData);
	/**
	 * @param locationData
	 * @return
	 */
	public Map<String, String> saveLocationDetails(Location locationData);
	/**
	 * @param productRatingData
	 * @return
	 */
	public Map<String, String> saveProductDetails(final ProductRating productRatingData);
	/**
	 * @param userData
	 * @return
	 */
	public Map<String, String> saveUserDetails(final User userData);
	/**
	 * @param areaData
	 * @return
	 */
	public Map<String, String> updateAreaDetails(final Area areaData);
	/**
	 * @param brandData
	 * @return
	 */
	public Map<String, String> updateBrandDetails(final ProductBrand brandData);
	/**
	 * @param categoryData
	 * @return
	 */
	public Map<String, String> updateCategoryDetails(final Category categoryData);
	/**
	 * @param companyData
	 * @return
	 */
	public Map<String, String> updateCompanyDetails(final Company companyData);
	/**
	 * @param locationData
	 * @return
	 */
	public Map<String, String> updateLocationDetails(final Location locationData);
	/**
	 * @param productData
	 * @return
	 */
	public Map<String, String> updateProductDetails(final Product productData);
	/**
	 * @param productRatingData
	 * @return
	 */
	public Map<String, String> updateProductRatingDetails(final ProductRating productRatingData);
	/**
	 * @param userData
	 * @return
	 */
	public Map<String, String> updateUserDetails(final User userData);
	/**
	 * @param areaData
	 * @return
	 */
	public Map<String, String> deleteAreaDetails(final Area areaData);
	/**
	 * @param brandData
	 * @return
	 */
	public Map<String, String> deleteBrandDetails(final ProductBrand brandData);
	/**
	 * @param categoryData
	 * @return
	 */
	public Map<String, String> deleteCategoryDetails(final Category categoryData);
	/**
	 * @param companyData
	 * @return
	 */
	public Map<String, String> deleteCompanyDetails(final Company companyData);
	/**
	 * @param locationData
	 * @return
	 */
	public Map<String, String> deleteLocationDetails(final Location locationData);
	/**
	 * @param productData
	 * @return
	 */
	public Map<String, String> deleteProductDetails(final Product productData);
	/**
	 * @param productRatingData
	 * @return
	 */
	public Map<String, String> deleteProductRatingDetails(final ProductRating productRatingData);
	/**
	 * @param userData
	 * @return
	 */
	public Map<String, String> deleteUserDetails(final User userData);
	/**
	 * @param serviceData
	 * @return
	 */
	public Map<String, String> saveServiceDetails(final Service serviceData);
	/**
	 * @param serviceData
	 * @return
	 */
	public Map<String, String> updateServiceDetails(final Service serviceData);
	/**
	 * @param serviceData
	 * @return
	 */
	public Map<String, String> deleteServiceDetails(final Service serviceData);
	 

}
