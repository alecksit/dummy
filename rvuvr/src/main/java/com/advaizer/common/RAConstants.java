/**
 * 
 */
package com.advaizer.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines application constants
 * @author sarvesh
 *
 */
public class RAConstants {

	/** The Constant DEFAULT_DATE_FORMAT. */
	public static final String DEFAULT_DATE_FORMAT = "dd/MM/yy";
	
	/** The Constant TRACKER_DATE_FORMAT. */
	public static final String TRACKER_DATE_FORMAT = "yyyy-MM-dd";
	
	/** The Constant APPLICATION_EXCEPTION_STRING. */
	public static final String APPLICATION_EXCEPTION_STRING = "Internal server error.";
	
	public static final String CONFIG_SAVE_SUCCESS_FULLY = "Configuration saved successfuly.";
	
	public static final String CONFIG_SAVE_ERROR = "Error ccured on saving configurations.";
	
	/** The Constant COMMA. */
	public static final String COMMA = ",";
	
	public static final String EMPTY_STRING = "";
	
	/** The Constant PIPE. */
	public static final String PIPE = "|";
	
	/** The Constant COLON. */
	public static final String COLON = ":";
	
	public static final String SEMI_COLON = ";";
	
	/** The Constant HASH. */
	public static final String HASH = "#";
	
	public static final String UNKNOWN = "Unknown";
	/** The Constant attributeNameValueCache. */
	public static final Map<String,Map<String,String>> attributeNameValueCache 
		= new HashMap<String, Map<String,String>>(100);
	
	/** The Constant ATTR_NETWORK. */
	public static final String ATTR_NETWORK = "Network";
	
	/** The Constant ATTR_NETWORK_GROUP. */
	public static final String ATTR_NETWORK_GROUP = "Network Group";
	
	/** The Constant ATTR_NETWORK_GROUP. */
	public static final String ATTR_DEVICE_TYPE = "Device Type";
	
	/** The Constant ATTR_NETWORK. */
	public static final String ATTR_DEVICE_MODEL = "Device Model";
	
	/** The Constant ATTR_NETWORK_GROUP. */
	public static final String ATTR_MANUFACTURER = "Device Manufacturer";
	
	/** The Constant ATTR_OTHER_COUNTRIES_TRAVLED. */
	public static final String ATTR_OTHER_COUNTRIES_TRAVLED = "Other Countries Traveled";
	
	public static final String NEIGHBOURS = "Neighbours";
	public static final String LEISURE = "Leisure";
	public static final String LEISURE_PREMIUM = "Leisure Premium";
	public static final String LOW_GDP = "Low GDP";
	
	public static final String DEFAULT_MICROSEGMENT_CHART_LOADING_COUNT = "4";
	
	public static int SECONDS_IN_A_DAY = 86400;
	public static int IN_CLAUSE_THRESHOLD = 1000;
	
	public static String BEFORE_TRAVEL = "BeforeTravel";
	public static String UPON_LANDING = "UponLanding";
	public static String ON_RETURN = "OnReturn";
	
	
	public static int ZERO_THRESHOLD_ID = 1;
	public static int MODERATE_THRESHOLD_ID = 2;
	public static int HEAVY_THRESHOLD_ID = 3;

	/**
	 * 
	 */
	public static final String UTC = "UTC";
	
	
	
	
	
}
