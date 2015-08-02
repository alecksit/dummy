/**
 * 
 */
package com.advaizer.repository;

import java.util.HashMap;
import java.util.Map;

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

}
