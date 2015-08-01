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
	
	
	@RequestMapping(method = RequestMethod.GET, value={"/admin/states"})
	@ResponseBody Map<Integer, String> getAllStates( final HttpServletRequest request, final HttpServletResponse response) {
		
		 LOGGER.debug("Inside /admin/states");
		

		return locationService.getAllStatesService();
	}
	
	
	
	
}



