/**
 * 
 */
package com.advaizer.controller;

import src.main.java.com.advaizer.repository.LocationRepositoryImpl;
import src.main.java.com.advaizer.service.LocationService;


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
	
	
	@RequestMapping(method = RequestMethod.GET, value={"/admin/states"})
	@ResponseBody Map<Integer, String> getAllStates( final HttpServletRequest request, final HttpServletResponse response) {
		
		 LOGGER.debug("Inside /admin/states Okay");
		

		return locationService.getAllStatesService();
	}
	
	
	
	
}



