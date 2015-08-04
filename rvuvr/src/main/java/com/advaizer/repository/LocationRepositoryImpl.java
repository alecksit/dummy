/**
 * 
 */
package com.advaizer.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.advaizer.enums.LocationColumns;
import com.advaizer.query.BasicFilterQueryBuilder;

/**
 * @author smruti
 *
 */
@Repository
public class LocationRepositoryImpl implements LocationRepository {
private static Logger LOGGER = LogManager.getLogger(LocationRepositoryImpl.class.getName());
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public HashMap<Integer, String> getAllStatesRepository() {
		// TODO Auto-generated method stub
		final String query = BasicFilterQueryBuilder.getAllStateQuery(new StringBuilder(" "+LocationColumns.ISACTIVE+ "=1 ")).toString();
					
			LOGGER.debug("Getting all States ");
			LOGGER.debug("States query : " + query);
			
			final HashMap<Integer,String> stateList = new LinkedHashMap<Integer,String>();

			try {
				jdbcTemplate.query(query, new RowMapper<Integer>(){
					@Override
					public Integer mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
						
						stateList.put(rs.getInt("stateid"), rs.getString("statename"));
																								
						return 1;
					}
				});
			} catch(final DataAccessException dae) {
				LOGGER.error("Error occurred while getting all trackers: ", dae);
				
			}
							
			LOGGER.debug("Sates found : " + stateList.size());
			
			return stateList;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getStateAreaRepository(int)
	 */
	@Override
	public Map<Integer, String> getStateAreaRepository(final int stateId) {
		// TODO Auto-generated method stub
				final String query = BasicFilterQueryBuilder.getStateAreaQuery(new StringBuilder(" "+LocationColumns.STATEID+ "="+stateId)).toString();
							
					LOGGER.debug("Getting all Areas per stateId " + stateId);
					LOGGER.debug("States query : " + query);
					
					final HashMap<Integer,String> stateList = new LinkedHashMap<Integer,String>();

					try {
						jdbcTemplate.query(query, new RowMapper<Integer>(){
							@Override
							public Integer mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
								
								stateList.put(rs.getInt("areaid"), rs.getString("areaname"));
																										
								return 1;
							}
						});
					} catch(final DataAccessException dae) {
						LOGGER.error("Error occurred while getting all trackers: ", dae);						
					}
									
					LOGGER.debug("Sates found : " + stateList.size());
					
					return stateList;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getZoneStateRepository(int)
	 */
	@Override
	public Map<Integer, String> getZoneStateRepository(final int statezone) {
		// TODO Auto-generated method stub
		final String query = BasicFilterQueryBuilder.getStateZoneQuery(new StringBuilder(" "+LocationColumns.STATEZONE+ "="+statezone)).toString();
		
		LOGGER.debug("Getting all Sates per zoneId " + statezone);
		LOGGER.debug("States query : " + query);
		
		final HashMap<Integer,String> areaList = new LinkedHashMap<Integer,String>();

		try {
			jdbcTemplate.query(query, new RowMapper<Integer>(){
				@Override
				public Integer mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					areaList.put(rs.getInt("stateid"), rs.getString("statename"));
																							
					return 1;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			
		}
						
		LOGGER.debug("Sates found : " + areaList.size());
		
		return areaList;
	}
	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getMajorAreaRepository()
	 */
	@Override
	public Map<Integer, String> getMajorAreaRepository() {
		// TODO Auto-generated method stub

		final String query = BasicFilterQueryBuilder.getStateAreaQuery(new StringBuilder(" "+LocationColumns.ISMAJORCITY+ "=1")).toString();
		
		LOGGER.debug("Getting all major Areas ");
		LOGGER.debug("States query : " + query);
		
		final HashMap<Integer,String> areaList = new LinkedHashMap<Integer,String>();

		try {
			jdbcTemplate.query(query, new RowMapper<Integer>(){
				@Override
				public Integer mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					areaList.put(rs.getInt("areaid"), rs.getString("areaname"));
																							
					return 1;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			
		}
						
		LOGGER.debug("Sates found : " + areaList.size());
		
		return areaList;
	}
	
	@Override
	public Map<Integer, String> getMajorZoneAreaRepository(final int zoneid) {
		// TODO Auto-generated method stub

		final String query = BasicFilterQueryBuilder.getMajorZoneAreaQuery(zoneid).toString();
		
		LOGGER.debug("Getting all major Areas ");
		LOGGER.debug("States query : " + query);
		
		final HashMap<Integer,String> areaList = new LinkedHashMap<Integer,String>();

		try {
			jdbcTemplate.query(query, new RowMapper<Integer>(){
				@Override
				public Integer mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					areaList.put(rs.getInt("areaid"), rs.getString("areaname"));
																							
					return 1;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			
		}
						
		LOGGER.debug("Sates found : " + areaList.size());
		
		return areaList;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getMajorZoneAreaRepository()
	 */
	@Override
	public Map<Integer, String> getMajorZoneAreaRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getCompaniesDataRepository(int)
	 */
	@Override
	public Map<Integer, String> getCompaniesPerLocationRepository(final int locationId) {
final String query = BasicFilterQueryBuilder.getCompaniesPerLocationQuery(locationId).toString();
		
		LOGGER.debug("Getting all companies ");
		LOGGER.debug("Companies query : " + query);
		
		final HashMap<Integer,String> companyList = new LinkedHashMap<Integer,String>();

		try {
			jdbcTemplate.query(query, new RowMapper<Integer>(){
				@Override
				public Integer mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					companyList.put(rs.getInt("companyId"), rs.getString("companyname"));
																							
					return 1;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			
		}
						
		LOGGER.debug("Companies found : " + companyList.size());
		
		return companyList;
		
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getMajorZoneAreaRepository(int)
	 */

}
