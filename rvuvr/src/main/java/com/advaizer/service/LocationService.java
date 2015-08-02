/**
 * 
 */
package com.advaizer.service;

import java.util.HashMap;
import java.util.Map;

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
	 * @return
	 */
	public Map<Integer, String> getMajorAreaService();

}
