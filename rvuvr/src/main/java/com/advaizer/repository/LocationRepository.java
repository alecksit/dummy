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

	/**

	 * @param statezone
	 * @return
	 */
	public Map<Integer, String> getZoneStateRepository(int statezone);
	/**

	 * @param 
	 * @return
	 */
	public Map<Integer, String> getMajorAreaRepository();

	/**
	 * @return
	 */
	public Map<Integer, String> getMajorZoneAreaRepository();

	/**
	 * @param zoneid
	 * @return
	 */
	public Map<Integer, String> getMajorZoneAreaRepository(int zoneid);

	/**
	 * @param locationId
	 * @return
	 */
	public Map<Integer, String> getCompaniesPerLocationRepository(int locationId);

	/**
	 * @return
	 */

}
