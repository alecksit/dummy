/**
 * 
 */
package com.advaizer.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.advaizer.common.ConfigurationQueryBuilder;
import com.advaizer.common.RAConstants;
import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.RoamingThresholds;

/**
 * @author smruti
 *
 */
@Repository
public class ConfigurationRepositoryImpl implements ConfigurationRepository {
	
	private static Logger LOGGER = LogManager.getLogger(TrackerRepositoryImpl.class.getName());
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void deleteCountryThresholds(final String roamType, final int countryId) throws RADataAccessException {
		final String deleteQuery = ConfigurationQueryBuilder.queryForDeleteThreshold(roamType, countryId);
		LOGGER.debug("Delete thresholds for country query : " + deleteQuery);
		try {
			jdbcTemplate.update(deleteQuery);
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while deleting thresholds for country ", dae);
			throw new RADataAccessException(dae);
		}
	}
	
	@Override
	public void saveThresholds(final String roamType, final int countryId,
			final RoamingThresholds zero, final RoamingThresholds moderate,
			final RoamingThresholds heavy) throws RADataAccessException {
		final StringBuilder insertQuery = new StringBuilder();
		insertQuery.append(ConfigurationQueryBuilder.queryForSaveConfiguration(roamType, countryId, zero))
			.append(RAConstants.SEMI_COLON)
			.append(ConfigurationQueryBuilder.queryForSaveConfiguration(roamType, countryId, moderate))
			.append(RAConstants.SEMI_COLON)
			.append(ConfigurationQueryBuilder.queryForSaveConfiguration(roamType, countryId, heavy))
			.append(RAConstants.SEMI_COLON);
		LOGGER.debug("Save thresholds for country query : " + insertQuery.toString());
		try {
			jdbcTemplate.update(insertQuery.toString());
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while saving thresholds for country ", dae);
			throw new RADataAccessException(dae);
		}
	}
	
	/**
	 * Method to list all the thresholds
	 * @param RoamType
	 * @return
	 */
		@Override
		public List<RoamingThresholds> FetchAllThresholds(final String roamType) throws RADataAccessException {
			
			final String query = ConfigurationQueryBuilder.queryForThresholdsListing(roamType);
		
			LOGGER.debug("Threshold query : " + query);
		
			try {
				return jdbcTemplate.query(query, new RowMapper<RoamingThresholds>(){
					@Override
					public RoamingThresholds mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
						
						final RoamingThresholds roamingThresholds = new RoamingThresholds();
						roamingThresholds.setCountryId(rs.getLong("country_id"));
						roamingThresholds.setMoCallDuration(rs.getLong("mo_call_duration"));
						roamingThresholds.setMtCallDuration(rs.getLong("mt_call_duration"));
						roamingThresholds.setMoSmsCount(rs.getLong("mo_sms_count"));
						roamingThresholds.setTonnage(rs.getLong("tonnage"));
						roamingThresholds.setThresholdId(rs.getLong("threshold_id"));
						roamingThresholds.setTimestamp(rs.getLong("timestamp"));																									
						return roamingThresholds;
					}
				});
			} catch(final DataAccessException dae) {
				LOGGER.error("Error occurred while getting all Thresholds: ", dae);
				throw new RADataAccessException(dae);
			}
							
			
			
		}

	@Override
	public List<RoamingThresholds> getSystemGeneratedThreshold(final String roamType,
			final int countryId) throws RADataAccessException {
		final String query = ConfigurationQueryBuilder.queryForSystemGeneratedCountry(roamType, countryId);
		try {
			LOGGER.debug("Get System generated configurations for country : " + query);
			return  jdbcTemplate.query(query, new RowMapper<RoamingThresholds>(){
				@Override
				public RoamingThresholds mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					final RoamingThresholds roamingThresholds = new RoamingThresholds();
					roamingThresholds.setCountryId(rs.getLong("country_id"));
					roamingThresholds.setMoCallDuration(rs.getLong("mo_call_duration"));
					roamingThresholds.setMtCallDuration(rs.getLong("mt_call_duration"));
					roamingThresholds.setMoSmsCount(rs.getLong("mo_sms_count"));
					roamingThresholds.setTonnage(rs.getLong("tonnage"));
					roamingThresholds.setThresholdId(rs.getLong("threshold_id"));
					roamingThresholds.setTimestamp(rs.getLong("timestamp"));	
					return roamingThresholds;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while System generated configurations Thresholds: ", dae);
			throw new RADataAccessException(dae);
		}
	}


}
