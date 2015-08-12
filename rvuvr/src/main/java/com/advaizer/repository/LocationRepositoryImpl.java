/**
 * 
 */
package com.advaizer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.advaizer.enums.LocationColumns;
import com.advaizer.model.Product;
import com.advaizer.model.Tracker;
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
		final String query = BasicFilterQueryBuilder.getAllStateQuery(new StringBuilder(" " )).toString();
					
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
	 * @see com.advaizer.repository.LocationRepository#getBrandsPerCompanyRepository(int)
	 */
	@Override
	public Map<Integer, String> getBrandsPerCompanyRepository(final int companyId) {
		// TODO Auto-generated method stub
final String query = BasicFilterQueryBuilder.getBrandsPerCompanyQuery(companyId).toString();
		
		LOGGER.debug("Getting all brands ");
		LOGGER.debug("Brands query : " + query);
		
		final HashMap<Integer,String> brandList = new LinkedHashMap<Integer,String>();

		try {
			jdbcTemplate.query(query, new RowMapper<Integer>(){
				@Override
				public Integer mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					brandList.put(rs.getInt("brandId"), rs.getString("brandname"));
																							
					return 1;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			
		}
						
		LOGGER.debug("Brands found : " + brandList.size());
		
		return brandList;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getBrandsPerLocationRepository(int)
	 */
	@Override
	public Map<Integer, String> getBrandsPerLocationRepository(final int locationId) {
		// TODO Auto-generated method stub
final String query = BasicFilterQueryBuilder.getBrandsPerLocationQuery(locationId).toString();
		
		LOGGER.debug("Getting all brands ");
		LOGGER.debug("Brands query : " + query);
		
		final HashMap<Integer,String> brandList = new LinkedHashMap<Integer,String>();

		try {
			jdbcTemplate.query(query, new RowMapper<Integer>(){
				@Override
				public Integer mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					brandList.put(rs.getInt("brandId"), rs.getString("brandname"));
																							
					return 1;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			
		}
						
		LOGGER.debug("Brands found : " + brandList.size());
		
		return brandList;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getProductsPerLocationRepository(int)
	 */
	@Override
	public Map<Integer, String> getProductsPerLocationRepository(final int locationId) {
		// TODO Auto-generated method stub
final String query = BasicFilterQueryBuilder.getProductsPerLocationQuery(locationId).toString();
		
		LOGGER.debug("Getting all products ");
		LOGGER.debug("Products query : " + query);
		
		final HashMap<Integer,String> productList = new LinkedHashMap<Integer,String>();

		try {
			jdbcTemplate.query(query, new RowMapper<Integer>(){
				@Override
				public Integer mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					productList.put(rs.getInt("productId"), rs.getString("productname"));
																							
					return 1;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			
		}
						
		LOGGER.debug("Products found : " + productList.size());
		
		return productList;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getCompanyPerStateRepository(int)
	 */
	@Override
	public Map<Integer, String> getCompanyPerStateRepository(final int stateId) {
		// TODO Auto-generated method stub
final String query = BasicFilterQueryBuilder.getCompanyPerStateQuery(stateId).toString();
		
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
		LOGGER.debug("Products found : " + companyList.size());
		return companyList;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getProductPerCompanyRepository(int)
	 */
	@Override
	public Map<Integer, String> getProductPerCompanyRepository(final int companyId) {
		// TODO Auto-generated method stub
final String query = BasicFilterQueryBuilder.getProductPerCompanyQuery(companyId).toString();
		
		LOGGER.debug("Getting all Products ");
		LOGGER.debug("Products query : " + query);
		
		final HashMap<Integer,String> productList = new LinkedHashMap<Integer,String>();

		try {
			jdbcTemplate.query(query, new RowMapper<Integer>(){
				@Override
				public Integer mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					productList.put(rs.getInt("productId"), rs.getString("productname"));
																							
					return 1;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			
		}				
		LOGGER.debug("Products found : " + productList.size());
		return productList;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getProductRatingPerLocationRepository(int)
	 */
	@Override
	public Map<Integer, String> getProductRatingPerLocationRepository(final int locationId) {
		// TODO Auto-generated method stub
final String query = BasicFilterQueryBuilder.getProductRatingPerLocationQuery(locationId).toString();
		
		LOGGER.debug("Getting all Products Ratings ");
		LOGGER.debug("Products query : " + query);
		
		final HashMap<Integer,String> productratingList = new LinkedHashMap<Integer,String>();

		try {
			jdbcTemplate.query(query, new RowMapper<Integer>(){
				@Override
				public Integer mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					productratingList.put(rs.getInt("productId"), rs.getString("ratingpoint"));
																							
					return 1;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			
		}				
		LOGGER.debug("Products Rating found : " + productratingList.size());
		return productratingList;
	}

	/* (non-Javadoc)
<<<<<<< HEAD
	 * @see com.advaizer.repository.LocationRepository#saveBrandDetails(java.util.Map)
	 */
	@Override
	public Map<String, String> saveBrandDetails(final Map<String, Object> brandData) {
		final Tracker tracker = new Tracker();
		 
		final StringBuilder query = new StringBuilder();
		 LOGGER.debug("Getting query for saving track details");

		 
		 query=(StringBuilder) BasicFilterQueryBuilder.addBrandDetailsQuery();

	 LOGGER.debug(" query : " + query.toString());

		// final int trackId = jdbcTemplate.update(query.toString(),
		// parameterMap.values().toArray());
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(
					final Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(
						query.toString(), Statement.RETURN_GENERATED_KEYS);
				 
				ps.setString(1, parameterArray[0].toString()); // name
				ps.setInt(2, parameterArray[1].toString()); // filterString
				ps.setInt(3, parameterArray[2].toString()); // start_old_timeformat
				 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final long trackerId = Long.valueOf(keyHolder.getKeyList().get(0)
				.get("id").toString());

		if (trackerId >= 1) {
			tracker.setId(trackerId);
			tracker.setTrackName(trackName);
			// tracker.setFilterLabel(filterString.toString());
			tracker.setFilterLabel(filterLabels);
			tracker.setFilterString(filterJson);
		}

		return tracker.convertToMap();
	}
	 /* @see com.advaizer.repository.LocationRepository#getProductDetailPerCompanyRepository(int)
	 */
	@Override
	public List<Product> getProductDetailPerCompanyRepository(final int companyId) {
		// TODO Auto-generated method stub
final String query = BasicFilterQueryBuilder.getProductDetailPerCompanyQuery(companyId).toString();
		
		LOGGER.debug("Getting all Products Ratings ");
		LOGGER.debug("Products query : " + query);
		
		 List<Product> productList = new ArrayList<Product>();

		try {
			productList=jdbcTemplate.query(query, new RowMapper<Product>(){
				@Override
				public Product mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					final Product productDetail=new Product();
					productDetail.setProductId(rs.getInt("productid"));
					productDetail.setProductName(rs.getString("productname"));
					productDetail.setBrandId(rs.getInt("brandid"));
					productDetail.setProductName(rs.getString("brandname"));
					productDetail.setBrandId(rs.getInt("categoryid"));
					productDetail.setProductName(rs.getString("categoryname"));																		
					return productDetail;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			
		}				
		LOGGER.debug("Products Details found : " + productList.size());
		return productList;
 	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getMajorZoneAreaRepository(int)
	 */

}
