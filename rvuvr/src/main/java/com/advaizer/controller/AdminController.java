/**
 * 
 */
package com.advaizer.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.advaizer.model.Area;
import com.advaizer.model.Category;
import com.advaizer.model.Company;
import com.advaizer.model.Location;
import com.advaizer.model.Product;
import com.advaizer.model.ProductBrand;
import com.advaizer.model.ProductRating;
import com.advaizer.model.Service;
import com.advaizer.model.User;
import com.advaizer.repository.LocationRepositoryImpl;
import com.advaizer.service.LocationService;

/**
 * @author smruti
 *
 */

@Controller

public class AdminController {
	
	private static Logger LOGGER = LogManager.getLogger(LocationRepositoryImpl.class.getName());
	
	
	/** The trend service. */
	@Autowired
	private LocationService locationService;
	
	
	@RequestMapping(method = RequestMethod.GET, value={"/admin"})
	public ModelAndView showAppHome( final HttpServletRequest request, final HttpServletResponse response) {
		
				
		ModelAndView mv;
		mv= new ModelAndView("adminHome");
		return mv;
	}
	

	@RequestMapping(method = RequestMethod.GET, value={"/admin/add/brand"})
	public ModelAndView showAddBrandHome( final HttpServletRequest request, final HttpServletResponse response) {
			
		ModelAndView mv;
		mv= new ModelAndView("addBrandAdminBody");
		
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/admin/add/areainfo"})
	public ModelAndView showAddAreaInfo( final HttpServletRequest request, final HttpServletResponse response) {
			
		ModelAndView mv;
		mv= new ModelAndView("areaInfoAdminBody");
		
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/admin/add/categoryinfo"})
	public ModelAndView showAddCategoryInfo( final HttpServletRequest request, final HttpServletResponse response) {
			
		ModelAndView mv;
		mv= new ModelAndView("categoryInfoAdminBody");
		
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/admin/add/companyinfo"})
	public ModelAndView showAddCompanyInfo( final HttpServletRequest request, final HttpServletResponse response) {
			
		ModelAndView mv;
		mv= new ModelAndView("companyInfoAdminBody");
		
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/admin/add/locationinfo"})
	public ModelAndView showAddLocationInfo( final HttpServletRequest request, final HttpServletResponse response) {
			
		ModelAndView mv;
		mv= new ModelAndView("locationInfoAdminBody");
		
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/admin/add/stateinfo"})
	public ModelAndView showAddStateInfo( final HttpServletRequest request, final HttpServletResponse response) {
			
		ModelAndView mv;
		mv= new ModelAndView("stateInfoAdminBody");
		
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/admin/add/tempusers"})
	public ModelAndView showAddTempUsersInfo( final HttpServletRequest request, final HttpServletResponse response) {
			
		ModelAndView mv;
		mv= new ModelAndView("tempUsersAdminBody");
		
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/admin/add/userinfo"})
	public ModelAndView showAddUserInfo( final HttpServletRequest request, final HttpServletResponse response) {
			
		ModelAndView mv;
		mv= new ModelAndView("userInfoAdminBody");
		
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/admin/add/usersrole"})
	public ModelAndView showAddUsersRoleInfo( final HttpServletRequest request, final HttpServletResponse response) {
			
		ModelAndView mv;
		mv= new ModelAndView("userRoleAdminBody");
		
		return mv;
	}
	
	@RequestMapping(value="/add/brand", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> addBrand(  
			 final ProductBrand brandData) 
			  {
 
		
		   System.out.print(brandData.getBrandId()+""+brandData.getBrandName()+""+brandData.getBrandType()+""+brandData.getCompanyId());
		  final Map<String, String> brandMap =  locationService.saveBrandDetails(brandData);
 
		
		 return brandMap; 
	}
	
	@RequestMapping(value="/add/area", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> addArea(  
			 final Area areaData) 
			  {
 
		
		   System.out.print(areaData.getAreaId()+""+areaData.getStateId()+""+areaData.getAreaName());
		  final Map<String, String> areaMap =  locationService.saveAreaDetails(areaData);
 
		
		 return areaMap; 
	}
	@RequestMapping(value="/add/category", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> addCategory(  
			 final Category categoryData) 
			  {
 
		
		   System.out.print(categoryData.getCategoryId()+""+categoryData.getCategoryName()+""+categoryData.getParentCategoryId());
		  final Map<String, String> categoryMap =  locationService.saveCategoryDetails(categoryData);
 
		
		 return categoryMap; 
	}
	@RequestMapping(value="/add/company", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> addCompany(  
			 final Company companyData) 
			  {
 
		
		   System.out.print(companyData.getCompanyId()+""+companyData.getCompanyName()+""+companyData.getCompanyLocation()+""+companyData.getParentCompanyId());
		  final Map<String, String> companyMap =  locationService.saveCompanyDetails(companyData);
 
		
		 return companyMap; 
	}
	@RequestMapping(value="/add/location", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> addLocation(  
			 final Location locationData) 
			  {
 
		   System.out.print(locationData.getLocationId()+""+locationData.getAreaId()+""+locationData.getLocationName());
		  final Map<String, String> locationMap =  locationService.saveLocationDetails(locationData);
 
		 return locationMap; 
	}
	@RequestMapping(value="/add/product", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> addProduct(  
			 final Product productData) 
			  {
 
		   System.out.print(productData.getProductId()+""+productData.getProductName()+""+productData.getBrandId()+""+productData.getCategoryId());
		  final Map<String, String> productMap =  locationService.saveProductDetails(productData);
 
		 return productMap; 
	}
	@RequestMapping(value="/add/productratings", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> addProductRating(  
			 final ProductRating productRatingData) 
			  {
 
		   System.out.print(productRatingData.getRatingId()+""+productRatingData.getRatingPoint()+""+productRatingData.getRatingId()+""+productRatingData.getUserId());
		  final Map<String, String> productRatingMap =  locationService.saveProductDetails(productRatingData);
 
		 return productRatingMap; 
	}
	@RequestMapping(value="/add/service", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> addService(  
			 final Service serviceData) 
			  {
 
		   System.out.print(serviceData.getServiceId()+""+serviceData.getServiceName()+""+serviceData.getBrandId());
		  final Map<String, String> serviceMap =  locationService.saveServiceDetails(serviceData);
 
		 return serviceMap; 
	}
	@RequestMapping(value="/add/user", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> addUser(  
			 final User userData) 
			  {
 
		   System.out.print(userData.getUserId()+""+userData.getUserName()+""+userData.getUserPass());
		  final Map<String, String> userMap =  locationService.saveUserDetails(userData);
 
		 return userMap; 
	}
	
	@RequestMapping(method = RequestMethod.GET, value={"/states"})
	@ResponseBody Map<Integer, String> getAllStates( final HttpServletRequest request, final HttpServletResponse response) {
		
		 LOGGER.debug("Inside /admin/states");
		

		return locationService.getAllStatesService();
	}
	@RequestMapping(value="/update/area", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> updateArea(  
			 final Area areaData) 
			  {
 
		   System.out.print(areaData.getAreaId()+""+areaData.getStateId()+""+areaData.getAreaName());
		  final Map<String, String> areaMap =  locationService.updateAreaDetails(areaData);
 
		 return areaMap; 
	}
	@RequestMapping(value="/update/brand", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> updateBrand(  
			 final ProductBrand brandData) 
			  {
 
		
		   System.out.print(brandData.getBrandId()+""+brandData.getBrandName()+""+brandData.getBrandType()+""+brandData.getCompanyId());
		  final Map<String, String> brandMap =  locationService.updateBrandDetails(brandData);
 
		
		 return brandMap; 
	}
	@RequestMapping(value="/update/category", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> updateCategory(  
			 final Category categoryData) 
			  {
 
		
		   System.out.print(categoryData.getCategoryId()+""+categoryData.getCategoryName()+""+categoryData.getParentCategoryId());
		  final Map<String, String> categoryMap =  locationService.updateCategoryDetails(categoryData);
 		
		 return categoryMap; 
	}
	@RequestMapping(value="/update/company", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> updateCompany(  
			 final Company companyData) 
			  {
 
		
		   System.out.print(companyData.getCompanyId()+""+companyData.getCompanyName()+""+companyData.getCompanyLocation()+""+companyData.getParentCompanyId());
		  final Map<String, String> companyMap =  locationService.updateCompanyDetails(companyData);
 
		
		 return companyMap; 
	}
	@RequestMapping(value="/update/location", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> updateLocation(  
			 final Location locationData) 
			  {
 
		   System.out.print(locationData.getLocationId()+""+locationData.getAreaId()+""+locationData.getLocationName());
		  final Map<String, String> locationMap =  locationService.updateLocationDetails(locationData);
 
		 return locationMap; 
	}
	@RequestMapping(value="/update/product", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> updateProduct(  
			 final Product productData) 
			  {
 
		   System.out.print(productData.getProductId()+""+productData.getProductName()+""+productData.getBrandId()+""+productData.getCategoryId());
		  final Map<String, String> productMap =  locationService.updateProductDetails(productData);
 
		 return productMap; 
	}
	@RequestMapping(value="/update/service", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> updateService(  
			 final Service serviceData) 
			  {
 
		   System.out.print(serviceData.getServiceId()+""+serviceData.getServiceName()+""+serviceData.getBrandId());
		  final Map<String, String> serviceMap =  locationService.updateServiceDetails(serviceData);
 
		 return serviceMap; 
	}
	@RequestMapping(value="/update/productratings", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> updateProductRating(  
			 final ProductRating productRatingData) 
			  {
 
		   System.out.print(productRatingData.getRatingId()+""+productRatingData.getRatingPoint()+""+productRatingData.getRatingId()+""+productRatingData.getUserId());
		  final Map<String, String> productRatingMap =  locationService.updateProductRatingDetails(productRatingData);
 
		 return productRatingMap; 
	}
	@RequestMapping(value="/update/user", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> updateUser(  
			 final User userData) 
			  {
 
		   System.out.print(userData.getUserId()+""+userData.getUserName()+""+userData.getUserPass());
		  final Map<String, String> userMap =  locationService.updateUserDetails(userData);
 
		 return userMap; 
	}
	@RequestMapping(value="/dalete/area", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> deleteArea(  
			 final Area areaData) 
			  {
		   System.out.print(areaData.getAreaId()+""+areaData.getStateId()+""+areaData.getAreaName());
		  final Map<String, String> areaMap =  locationService.deleteAreaDetails(areaData);
 
		 return areaMap; 
	}
	@RequestMapping(value="/delete/brand", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> deleteBrand(  
			 final ProductBrand brandData) 
			  {
		   System.out.print(brandData.getBrandId()+""+brandData.getBrandName()+""+brandData.getBrandType()+""+brandData.getCompanyId());
		  final Map<String, String> brandMap =  locationService.deleteBrandDetails(brandData);
 		
		 return brandMap; 
	}
	@RequestMapping(value="/delete/category", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> deleteCategory(  
			 final Category categoryData) 
			  {
 
		
		   System.out.print(categoryData.getCategoryId()+""+categoryData.getCategoryName()+""+categoryData.getParentCategoryId());
		  final Map<String, String> categoryMap =  locationService.deleteCategoryDetails(categoryData);
 		
		 return categoryMap; 
	}
	@RequestMapping(value="/delete/company", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> deleteCompany(  
			 final Company companyData) 
			  {
 
		
		   System.out.print(companyData.getCompanyId()+""+companyData.getCompanyName()+""+companyData.getCompanyLocation()+""+companyData.getParentCompanyId());
		  final Map<String, String> companyMap =  locationService.deleteCompanyDetails(companyData);
 
		
		 return companyMap; 
	}
	@RequestMapping(value="/delete/location", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> deleteLocation(  
			 final Location locationData) 
			  {
 
		   System.out.print(locationData.getLocationId()+""+locationData.getAreaId()+""+locationData.getLocationName());
		  final Map<String, String> locationMap =  locationService.deleteLocationDetails(locationData);
 
		 return locationMap; 
	}
	@RequestMapping(value="/delete/product", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> deleteProduct(  
			 final Product productData) 
			  {
 
		   System.out.print(productData.getProductId()+""+productData.getProductName()+""+productData.getBrandId()+""+productData.getCategoryId());
		  final Map<String, String> productMap =  locationService.deleteProductDetails(productData);
 
		 return productMap; 
	}
	@RequestMapping(value="/delete/productratings", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> deleteProductRating(  
			 final ProductRating productRatingData) 
			  {
 
		   System.out.print(productRatingData.getRatingId()+""+productRatingData.getRatingPoint()+""+productRatingData.getRatingId()+""+productRatingData.getUserId());
		  final Map<String, String> productRatingMap =  locationService.deleteProductRatingDetails(productRatingData);
 
		 return productRatingMap; 
	}
	@RequestMapping(value="/delete/user", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> deleteUser(  
			 final User userData) 
			  {
 
		   System.out.print(userData.getUserId()+""+userData.getUserName()+""+userData.getUserPass());
		  final Map<String, String> userMap =  locationService.deleteUserDetails(userData);
 
		 return userMap; 
	}
	@RequestMapping(value="/delete/service", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> deleteService(  
			 final Service serviceData) 
			  {
 
		   System.out.print(serviceData.getServiceId()+""+serviceData.getServiceName()+""+serviceData.getBrandId());
		  final Map<String, String> serviceMap =  locationService.deleteServiceDetails(serviceData);
 
		 return serviceMap; 
	}
	
}



