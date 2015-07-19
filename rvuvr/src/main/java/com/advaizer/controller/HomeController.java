/**
 * 
 */
package com.advaizer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	/**
	 * Show home.
	 *
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.GET, value={"/"})
	public ModelAndView showAppHome( final HttpServletRequest request, final HttpServletResponse response) {
		
		ModelAndView mv;
		mv= new ModelAndView("appHome");
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
		
	
		
		final ModelAndView mv = new ModelAndView("invalid");
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
