/**
 * 
 */
package com.advaizer.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.advaizer.service.LocationService;
import com.advaizer.service.MetaDataService;
import com.advaizer.service.TrendService;

/**
 * The Class TrendController.
 *
 * @author sarvesh
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	/** The logger. */
	private static Logger LOGGER = LogManager.getLogger(HomeController.class.getName());
	
	/** The common service. */
	@Autowired
	private MetaDataService metaDataService;
	
	/** The trend service. */
	@Autowired
	private TrendService trendService;
	
	
	/** The trend service. */
	@Autowired
	private LocationService locationService;

	private Object statezone;
	
	
	
	
	/**
	 * Show home.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value={"/"})
	public ModelAndView showAppHome( final HttpServletRequest request, final HttpServletResponse response) {
		
		
		final HashMap<Integer,String> activeStateList=locationService.getAllStatesService();
		ModelAndView mv;
		mv= new ModelAndView("appHome");
		mv.addObject("activeStateList", activeStateList);
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/account"})
	public ModelAndView showUserAccount( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userAccount");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/blog"})
	public ModelAndView showUserBlog( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userBlog");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/bloggrid"})
	public ModelAndView showUserBlogGrid( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userBlogGrid");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/bloglist"})
	public ModelAndView showUserBlogList( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userBlogList");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/contact"})
	public ModelAndView showUserContact( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userContact");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/details"})
	public ModelAndView showUserDetail( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userDetail");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/faq"})
	public ModelAndView showUserFaq( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userFaq");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/features"})
	public ModelAndView showUserFeatures( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userFeatures");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/head"})
	public ModelAndView showUserHead( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userHead");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/listing"})
	public ModelAndView showUserListing( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userListing");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/listinggrid"})
	public ModelAndView showUserListingGrid( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userListingGrid");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/listings"})
	public ModelAndView showUserListings( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userListings");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/profile"})
	public ModelAndView showUserProfile( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userProfile");
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, value={"/register"})
	public ModelAndView showUserRegister( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("userRegister");
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value={"/login"})
	public ModelAndView login( final HttpServletRequest request, final HttpServletResponse response) {
		
		final String referrer = request.getHeader("Referer");

	    request.getSession().setAttribute("url_prior_login", referrer);
	    
	    System.out.print("login"+request.getHeader("Referer"));
		
		final ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	
	
	/**
	 * Show home.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value={"/invalid"})
	public ModelAndView invalid( final HttpServletRequest request, final HttpServletResponse response) {
		
	
		final HashMap<Integer,String> activeStateList=locationService.getAllStatesService();
		final ModelAndView mv = new ModelAndView("invalid");
		mv.addObject("activeStateList",activeStateList);
		return mv;
	}
	
	/**
	 * Show home.
	 *
	 * @return the model and view
	 */
/*	@RequestMapping(method = RequestMethod.GET, value="/{appType}")
	public ModelAndView showHome(@PathVariable("appType") final String appType, final HttpServletRequest request, final HttpServletResponse response) {
		ModelAndView mv;
		
		
		if(appType.equals("admin"))
				mv= new ModelAndView("adminHome");
		else if (appType.equals("user"))
			mv= new ModelAndView("userHome");
		else 
			mv = new ModelAndView("login");
		
		if(request.getSession().getAttribute("loginModule")!=null && !(request.getSession().getAttribute("loginModule").toString().equals(appType)) || RAPropertyUtil.getProperty(appType+".app.modules")==null || RAPropertyUtil.getProperty(appType+".app.modules").equals("")){
			
			try {
				response.sendRedirect("./invalid");
			} catch (final IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			
		}else 
			request.getSession().setAttribute("loginModule", appType);
		
		
		
		mv.addObject("appType", appType);
		 final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 mv.addObject("userName", auth.getName());
	      
		
		return mv;
	}*/
	
	
	@RequestMapping(method = RequestMethod.GET, value={"/states"})
	@ResponseBody Map<Integer, String> getAllStates( final HttpServletRequest request, final HttpServletResponse response) {
		
		 LOGGER.debug("Inside states");
		

		return locationService.getAllStatesService();
	}
	
	@RequestMapping(method = RequestMethod.GET, value={"/area/{stateId}"})
	@ResponseBody Map<Integer, String> getStateArea( final HttpServletRequest request, final HttpServletResponse response,@PathVariable("stateId") final int stateId) {
		
		 LOGGER.debug("Inside states");
		
		return locationService.getStateAreaService(stateId);
	}
	

	@RequestMapping(method = RequestMethod.GET, value={"/zonestates/{zoneId}"})
	@ResponseBody Map<Integer, String> getStateZone( final HttpServletRequest request, final HttpServletResponse response,@PathVariable("zoneId") final int zoneId) {
		
		 LOGGER.debug("Inside states");
		
		return locationService.getZoneStateService(zoneId);
	}


	@RequestMapping(method = RequestMethod.GET, value={"/majorarea"})
	@ResponseBody Map<Integer, String> getMajorArea( final HttpServletRequest request, final HttpServletResponse response) {
		
		 LOGGER.debug("Inside majorarea");
		

		return locationService.getMajorAreaService();
	}
	@RequestMapping(method = RequestMethod.GET, value={"/majorzonearea/{zoneId}"})
	@ResponseBody Map<Integer, String> getMajorZoneArea( final HttpServletRequest request, final HttpServletResponse response,@PathVariable("zoneId") final int zoneId) {
		
		 LOGGER.debug("Inside majorzonearea");
		
		return locationService.getMajorZoneAreaService(zoneId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value={"/companyinformation/{locationId}"})
	@ResponseBody Map<Integer, String> getCompaniesPerLocation( final HttpServletRequest request, final HttpServletResponse response,@PathVariable("locationId") final int locationId) {
		
		 LOGGER.debug("Inside company per location id"+locationId);
		
		return locationService.getCompaniesPerLocationService(locationId);
	}
	@RequestMapping(method = RequestMethod.GET, value={"/brandinfo/{companyId}"})
	@ResponseBody Map<Integer, String> getBrandsPerCompany( final HttpServletRequest request, final HttpServletResponse response,@PathVariable("companyId") final int companyId) {
		
		 LOGGER.debug("Inside brands per companyid"+companyId);
		
		return locationService.getBrandsPerCompanyService(companyId);
	}
	@RequestMapping(method = RequestMethod.GET, value={"/brandperlocation/{locationId}"})
	@ResponseBody Map<Integer, String> getBrandsPerLocation( final HttpServletRequest request, final HttpServletResponse response,@PathVariable("locationId") final int locationId) {
		
		 LOGGER.debug("Inside brands per locationid"+locationId);
		
		return locationService.getBrandsPerLocationService(locationId);
	}
	@RequestMapping(method = RequestMethod.GET, value={"/productsperlocation/{locationId}"})
	@ResponseBody Map<Integer, String> getProductsPerLocation( final HttpServletRequest request, final HttpServletResponse response,@PathVariable("locationId") final int locationId) {
		
		 LOGGER.debug("Inside products per locationid"+locationId);
		
		return locationService.getProductsPerLocationService(locationId);
	}
	@RequestMapping(method = RequestMethod.GET, value={"/companyperstate/{stateId}"})
	@ResponseBody Map<Integer, String> getCompanyPerState( final HttpServletRequest request, final HttpServletResponse response,@PathVariable("stateId") final int stateId) {
		
		 LOGGER.debug("Inside companies per stateid"+stateId);
		
		return locationService.getCompanyPerStateService(stateId);
	}
	@RequestMapping(method = RequestMethod.GET, value={"/productpercompany/{companyId}"})
	@ResponseBody Map<Integer, String> getProductPerCompany( final HttpServletRequest request, final HttpServletResponse response,@PathVariable("companyId") final int companyId) {
		
		 LOGGER.debug("Inside products per companyid"+companyId);
		
		return locationService.getProductPerCompanyService(companyId);
	}
	
	/**
	 * Renders roaming trends.
	 *
	 * @return the model and view
	 */
	/*@RequestMapping(method=RequestMethod.GET, value="/{roamType}/trends")
	public ModelAndView showRoamingTrends(@PathVariable("roamType") final String roamType) {
		final ModelAndView mv = new ModelAndView("trends");
		mv.addObject("roamType", roamType);
		return mv;
	}*/
		
}
