/**
 * 
 */
package com.advaizer.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.advaizer.enums.RoamType;
import com.advaizer.model.Tracker;

/**
 * Contains common utility functions
 * @author sarvesh
 *
 */
public class CommonUtil {

	/**
	 * Converts a comma separated string to object array
	 * @param css - comma separated string
	 * @return object array
	 */
	public static <T> List<Object> convertToList(final String css, final String type ) {
		final String[] strArray =  css.split(RAConstants.COMMA);
		final List<Object> list = new ArrayList<Object>(5);
		for(final String str : strArray) {
			if (Integer.class.getName().equalsIgnoreCase(type))
				list.add(Integer.valueOf(str));
			else 
				list.add(str);
		}
		return list;
	}
	

	/**
	 * Parses the selected attributes. Splits by # to get selected attributes and categories
	 *
	 * @param attributes the attributes
	 * @return the map <attribute indicator, comma separated string of sub attribute indicators>
	 */
	public static  Map<String,String> parseSelectedAttributes(final String attributes) {
		final String[] attrArray = attributes.split(RAConstants.HASH);
		final Map<String,String> attributeMap = new HashMap<String, String>();
		
		for (final String attrInd : attrArray) {
			final String[] currentAttribute = attrInd.split(":");
			final String attributeKey[] =  currentAttribute[0].trim().split(",");
			final String key = attributeKey[1];
			final String value = attributeKey[2] + ":" + currentAttribute[1].trim();
			attributeMap.put(key,value );
		}
		return attributeMap;
	}
	
	public static String convertToCommaSeparatedString(final Collection<? extends Object> list) {
		final StringBuilder result = new StringBuilder();
		boolean first = true;
		
		for (final Object object : list) {
			if (first) {
				first = false;
			} else {
				result.append(",");
			}
			if (object instanceof String) {
				result.append("'").append(object).append("'");
			} else {
				result.append(object);
			}			
		}
		
		return result.toString();
	}

	public static Date getMaximumDate(final Date d1, final Date d2) {
        if (d1 == null && d2 == null) return null;
        if (d1 == null) return d2;
        if (d2 == null) return d1;
        
        return (d1.after(d2)) ? d1 : d2;
    }
	
	public static Date getMinimumDate(final Date d1, final Date d2) {
        if (d1 == null && d2 == null) return null;
        if (d1 == null) return d2;
        if (d2 == null) return d1;
        return (d1.before(d2)) ? d1 : d2;
    }
	
	public static boolean isInteger(final String str) {
		if (str == null) {
			return false;
		}
		final int length = str.length();
		
		if (length == 0) {
			return false;
		}
		
		int i = 0;
		
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		
		for (; i < length; i++) {
			final char c = str.charAt(i);
			if (c <= '/' || c >= ':') {
				return false;
			}
		}
		
		return true;
	}
	
	public static String covnertToCommaSeparatedString(final String css, final String type) {
		final StringBuilder result = new StringBuilder();
		
		if (String.class.getName().equalsIgnoreCase(type)) {
			final String[] strArray =  css.split(RAConstants.COMMA);
			boolean first = true;
			
			for(final String str : strArray) {
				if (first) {
					first = false;
				} else {
					result.append(",");
				}
				result.append("'").append(str).append("'");
			}
			
			return result.toString();
		} else {
			return css;
		}
	}


	/**
	 * @param trackers 
	 * @param roamType 
	 * @return
	 */
	public static Map<String,List<String>> extractFilterStrings(final List<Tracker> trackers, final String roamType) {
		// TODO Auto-generated method stub
		final Map<String,List<String>> filterStringsMap = new LinkedHashMap<String,List<String>>(100);
		
		//create map with track name and filter parameters list
		for(final Tracker tracker : trackers){
			final String[] rawFilterArray = tracker.getFilterString().split(" and ");
			final List<String> filterQueryList = new ArrayList<String>();
			
			for(final String filter : rawFilterArray){
				final StringBuilder filterQuery = new StringBuilder();
				
				if(filter.contains("network.countryid")){
					String values = filter.split(" in ")[1];
					values = values.substring(1, values.length()-2);
					if(!values.contains("select") && isInteger(values.split(",")[0])){						
						filterQuery.append(" "+filter);
					}
				}
				else if(filter.startsWith("concat")){			
						filterQuery.append(" "+filter);			
				}
				else{
					String values = filter.split(" in ")[1];
					values = values.substring(1, values.length()-2);
					if(isInteger(values.split(",")[0])){						
						filterQuery.append(" "+filter);
					}
				}	
				
				if(filterQuery.toString().trim().length() != 0){
					final StringBuilder prependString = new StringBuilder();
					if(!filterQuery.toString().toLowerCase().startsWith("select")){
						prependString.append("select ");
					}					
					
					if(filterQuery.toString().contains("network.")){
						prependString.append("network_name from "+RAPropertyUtil.getProperty("common.table.tadignetwork"));
						prependString.append(" network where ");
							
					} else if(filterQuery.toString().contains("trip.")){	
							if (RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)) {	
								prependString.append(" distinct network.network_name from ")
							.append(RAPropertyUtil.getProperty("common.table.tadignetwork"))
							.append(" network inner join ").append(RAPropertyUtil.getProperty("out.table.trip"))
							.append(" trip on trip.visitedmcc=network.mcc ");
								prependString.append(" where ");
							}				
							else if(RoamType.IN.getRoamType().equalsIgnoreCase(roamType)){					
								prependString.append(" distinct network.network_name from ")
								.append(RAPropertyUtil.getProperty("common.table.tadignetwork"))
								.append(" network inner join ")
								.append(RAPropertyUtil.getProperty("in.table.trip"))
								.append(" trip on trip.visitedmcc=network.mcc ");
								prependString.append(" where ");
							}
					}
					filterQuery.insert(filterQuery.indexOf("select",0) < 0 ? 0 : 
						filterQuery.indexOf("select",0) +7 ,prependString.toString());
				}
				if(!filterQuery.toString().isEmpty()){
					filterQueryList.add(filterQuery.toString());
				}
			}			
			
			
			filterStringsMap.put(tracker.getTrackName(), filterQueryList);
		}
		
		return filterStringsMap;
	}
	
	public static int getDifferenceDays(final Date d1, final Date d2) {
		int daysdiff=0;
		final long diff = d2.getTime() - d1.getTime();
		final long diffDays = diff / (24 * 60 * 60 * 1000)+1;
		 daysdiff = (int) diffDays;
		return daysdiff;
	}
	
	public static String normalizeString(final String str) {
		if (str == null || RAConstants.EMPTY_STRING.equalsIgnoreCase(str.trim())) {
			return RAConstants.UNKNOWN;
		}
		return str.trim();
	}
	
}
