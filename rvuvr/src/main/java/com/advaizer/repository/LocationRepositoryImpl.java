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
import com.advaizer.model.Area;
import com.advaizer.model.Category;
import com.advaizer.model.Company;
import com.advaizer.model.Location;
import com.advaizer.model.Product;
import com.advaizer.model.ProductBrand;
import com.advaizer.model.ProductRating;
import com.advaizer.model.Service;
import com.advaizer.model.User;
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
	public Map<String, String> saveBrandDetails(final ProductBrand brandData) {
		final HashMap<String,String> brandIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =(StringBuilder) BasicFilterQueryBuilder.addBrandDetailsQuery();

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
				 
				ps.setString(1, brandData.getBrandName().toString()); // name
				ps.setInt(2,  brandData.getBrandType()  ); // filterString
				ps.setInt(3, brandData.getCompanyId() ); // start_old_timeformat
				 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int brandId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("brandid").toString());

		brandIdMap.put("brandId", brandId+" ");

		return brandIdMap;
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
	 * @see com.advaizer.repository.LocationRepository#saveAreaDetails(com.advaizer.model.Area)
	 */
	@Override
	public Map<String, String> saveAreaDetails(final Area areaData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> areaIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.addAreaDetailsQuery();

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
				 
				ps.setInt(1,  areaData.getStateId() ); // filterString
				ps.setString(2, areaData.getAreaName().toString()); // name
				 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int areaId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("areaid").toString());

		areaIdMap.put("areaId", areaId+" ");

		return areaIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#saveCategoryDetails(com.advaizer.model.Category)
	 */
	@Override
	public Map<String, String> saveCategoryDetails(final Category categoryData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> categoryIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.addCategoryDetailsQuery();

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
				 
				ps.setInt(1,  categoryData.getParentCategoryId() ); // filterString
				ps.setString(2, categoryData.getCategoryName().toString()); // name
				 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int categoryId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("categoryid").toString());

		categoryIdMap.put("categoryId", categoryId+" ");

		return categoryIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#saveCompanyDetails(com.advaizer.model.Company)
	 */
	@Override
	public Map<String, String> saveCompanyDetails(final Company companyData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> companyIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.addCompanyDetailsQuery();

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
				 
				ps.setString(1, companyData.getCompanyName().toString()); // filterString
				ps.setInt(2, companyData.getCompanyLocation()); //
				ps.setInt(3, companyData.getParentCompanyId());
				 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int companyId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("companyid").toString());

		companyIdMap.put("companyId", companyId+" ");

		return companyIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#saveLocationDetails(com.advaizer.model.Location)
	 */
	@Override
	public Map<String, String> saveLocationDetails(final Location locationData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> locationIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.addLocationDetailsQuery();

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
				 
				ps.setInt(1, locationData.getAreaId()); // filterString
				ps.setString(2,locationData.getLocationName().toString() );
				
				 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int locationId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("locationid").toString());

		locationIdMap.put("locationId", locationId+" ");

		return locationIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#saveProductDetails(com.advaizer.model.Product)
	 */
	@Override
	public Map<String, String> saveProductDetails(final Product productData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> productIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.addProductDetailsQuery();

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
				 
				ps.setString(1, productData.getProductName().toString()); // filterString
				ps.setInt(2,productData.getBrandId() );
				ps.setInt(3,productData.getCategoryId() );
							 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int productId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("productid").toString());

		productIdMap.put("productId", productId+" ");

		return productIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#saveProductRatingDetails(com.advaizer.model.ProductRating)
	 */
	@Override
	public Map<String, String> saveProductRatingDetails(final ProductRating productRatingData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> productRatingIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.addProductRatingDetailsQuery();

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
				 
				ps.setInt(1, productRatingData.getRatingPoint()); // filterString
				ps.setInt(2,productRatingData.getProductId() );
				ps.setInt(3,productRatingData.getUserId() );
							 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int productRatingId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("productratingid").toString());

		productRatingIdMap.put("productratingId", productRatingId+" ");

		return productRatingIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#saveUserDetails(com.advaizer.model.User)
	 */
	@Override
	public Map<String, String> saveUserDetails(final User userData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> userIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.addUserDetailsQuery();

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
				 
				ps.setString(1, userData.getUserName().toString()); // filterString
				ps.setString(2, userData.getUserPass().toString());
							 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int userId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("userid").toString());

		userIdMap.put("userId", userId+" ");

		return userIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#updateAreaDetails(com.advaizer.model.Area)
	 */
	@Override
	public Map<String, String> updateAreaDetails(final Area areaData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> areaIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for updating track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.updateAreaDetailsQuery();

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
				
				ps.setInt(1,  areaData.getStateId() ); // filterString
				ps.setString(2, areaData.getAreaName().toString()); // name
				ps.setInt(3,  areaData.getAreaId() );						 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int areaId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("areaid").toString());

		areaIdMap.put("areaId", areaId+" ");

		return areaIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#updateBrandDetails(com.advaizer.model.ProductBrand)
	 */
	@Override
	public Map<String, String> updateBrandDetails(final ProductBrand brandData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> brandIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.updateBrandDetailsQuery();

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
				
				ps.setInt(1, brandData.getCompanyId() );
				ps.setString(2, brandData.getBrandName().toString()); // name
				ps.setInt(3,  brandData.getBrandType()  ); // filterString
				ps.setInt(4, brandData.getBrandId() );
				 // start_old_timeformat
				 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int brandId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("brandid").toString());

		brandIdMap.put("brandId", brandId+" ");

		return brandIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#updateCategoryDetails(com.advaizer.model.Category)
	 */
	@Override
	public Map<String, String> updateCategoryDetails(final Category categoryData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> categoryIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.updateCategoryDetailsQuery();

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
				
				ps.setString(1, categoryData.getCategoryName().toString()); 
				ps.setInt(2,  categoryData.getParentCategoryId() ); // filterString
				ps.setInt(3,  categoryData.getCategoryId() );  
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int categoryId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("categoryid").toString());

		categoryIdMap.put("categoryId", categoryId+" ");

		return categoryIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#updateCompanyDetails(com.advaizer.model.Company)
	 */
	@Override
	public Map<String, String> updateCompanyDetails(final Company companyData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> companyIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.updateCompanyDetailsQuery();

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
				 
				ps.setString(1, companyData.getCompanyName().toString()); // filterString
				ps.setInt(2, companyData.getCompanyLocation()); //
				ps.setInt(3, companyData.getParentCompanyId());
				ps.setInt(4, companyData.getCompanyId()); 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int companyId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("companyid").toString());

		companyIdMap.put("companyId", companyId+" ");

		return companyIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#updateLocationDetails(com.advaizer.model.Location)
	 */
	@Override
	public Map<String, String> updateLocationDetails(final Location locationData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> locationIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.updateLocationDetailsQuery();

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
				 
				ps.setInt(1, locationData.getAreaId()); // filterString
				ps.setString(2,locationData.getLocationName().toString() );
				ps.setInt(3, locationData.getLocationId());
				 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int locationId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("locationid").toString());

		locationIdMap.put("locationId", locationId+" ");

		return locationIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#updateProductDetails(com.advaizer.model.Product)
	 */
	@Override
	public Map<String, String> updateProductDetails(final Product productData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> productIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.updateProductDetailsQuery();

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
				 
				ps.setString(1, productData.getProductName().toString()); // filterString
				ps.setInt(2,productData.getBrandId() );
				ps.setInt(3,productData.getCategoryId() );
				ps.setInt(4,productData.getProductId());			 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int productId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("productid").toString());

		productIdMap.put("productId", productId+" ");

		return productIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#updateProductRatingDetails(com.advaizer.model.ProductRating)
	 */
	@Override
	public Map<String, String> updateProductRatingDetails(final ProductRating productRatingData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> productRatingIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.updateProductRatingDetailsQuery();

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
				 
				ps.setInt(1, productRatingData.getRatingPoint()); // filterString
				ps.setInt(2,productRatingData.getProductId() );
				ps.setInt(3,productRatingData.getUserId() );
				ps.setInt(4,productRatingData.getRatingId() );			 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int productRatingId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("productratingid").toString());

		productRatingIdMap.put("productratingId", productRatingId+" ");

		return productRatingIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#updateUserDetails(com.advaizer.model.User)
	 */
	@Override
	public Map<String, String> updateUserDetails(final User userData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> userIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.updateUserDetailsQuery();

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
				 
				ps.setString(1, userData.getUserName().toString()); // filterString
				ps.setString(2, userData.getUserPass().toString());
				ps.setInt(3, userData.getUserId());			 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int userId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("userid").toString());

		userIdMap.put("userId", userId+" ");

		return userIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#deleteAreaDetails(com.advaizer.model.Area)
	 */
	@Override
	public Map<String, String> deleteAreaDetails(final Area areaData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> areaIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for deleting track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.deleteAreaDetailsQuery();

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
				
				ps.setInt(1,  areaData.getAreaId() );						 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int areaId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("areaid").toString());

		areaIdMap.put("areaId", areaId+" ");

		return areaIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#deleteBrandDetails(com.advaizer.model.ProductBrand)
	 */
	@Override
	public Map<String, String> deleteBrandDetails(final ProductBrand brandData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> brandIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.deleteBrandDetailsQuery();

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
				
				ps.setInt(1, brandData.getBrandId() );
				 // start_old_timeformat
				 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int brandId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("brandid").toString());

		brandIdMap.put("brandId", brandId+" ");

		return brandIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#deleteCategoryDetails(com.advaizer.model.Category)
	 */
	@Override
	public Map<String, String> deleteCategoryDetails(final Category categoryData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> categoryIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.deleteCategoryDetailsQuery();

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
				ps.setInt(1,  categoryData.getCategoryId() );  
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int categoryId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("categoryid").toString());

		categoryIdMap.put("categoryId", categoryId+" ");

		return categoryIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#deleteCompanyDetails(com.advaizer.model.Company)
	 */
	@Override
	public Map<String, String> deleteCompanyDetails(final Company companyData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> companyIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.deleteCompanyDetailsQuery();

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
				 
				ps.setInt(1, companyData.getCompanyId()); 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int companyId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("companyid").toString());

		companyIdMap.put("companyId", companyId+" ");

		return companyIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#deleteLocationDetails(com.advaizer.model.Location)
	 */
	@Override
	public Map<String, String> deleteLocationDetails(final Location locationData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> locationIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.deleteLocationDetailsQuery();

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
				 
				ps.setInt(1, locationData.getLocationId());
				 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int locationId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("locationid").toString());

		locationIdMap.put("locationId", locationId+" ");

		return locationIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#deleteProductDetails(com.advaizer.model.Product)
	 */
	@Override
	public Map<String, String> deleteProductDetails(final Product productData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> productIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.deleteProductDetailsQuery();

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
				 
				ps.setInt(1,productData.getProductId());			 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int productId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("productid").toString());

		productIdMap.put("productId", productId+" ");

		return productIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#deleteProductRatingDetails(com.advaizer.model.ProductRating)
	 */
	@Override
	public Map<String, String> deleteProductRatingDetails(final ProductRating productRatingData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> productRatingIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.deleteProductRatingDetailsQuery();

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
				 
				ps.setInt(1,productRatingData.getRatingId() );			 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int productRatingId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("productratingid").toString());

		productRatingIdMap.put("productratingId", productRatingId+" ");

		return productRatingIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#deleteUserDetails(com.advaizer.model.User)
	 */
	@Override
	public Map<String, String> deleteUserDetails(final User userData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> userIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.deleteUserDetailsQuery();

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
				 
				ps.setInt(1, userData.getUserId());			 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int userId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("userid").toString());

		userIdMap.put("userId", userId+" ");

		return userIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#saveServiceDetails(com.advaizer.model.Service)
	 */
	@Override
	public Map<String, String> saveServiceDetails(final Service serviceData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> serviceIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.addServiceDetailsQuery();

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
				 
				ps.setString(1, serviceData.getServiceName().toString()); // filterString
				ps.setInt(2,serviceData.getBrandId() );
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int serviceId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("serviceid").toString());

		serviceIdMap.put("serviceId", serviceId+" ");

		return serviceIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#updateServiceDetails(com.advaizer.model.Service)
	 */
	@Override
	public Map<String, String> updateServiceDetails(final Service serviceData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> serviceIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.updateServiceDetailsQuery();

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
				 
				ps.setString(1, serviceData.getServiceName().toString()); // filterString
				ps.setInt(2,serviceData.getBrandId() );
				ps.setInt(3,serviceData.getServiceId() );		 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int serviceId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("serviceid").toString());

		serviceIdMap.put("serviceId", serviceId+" ");

		return serviceIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#deleteServiceDetails(com.advaizer.model.Service)
	 */
	@Override
	public Map<String, String> deleteServiceDetails(final Service serviceData) {
		// TODO Auto-generated method stub
		final HashMap<String,String> serviceIdMap = new HashMap<String,String>();
		 
		  LOGGER.debug("Getting query for saving track details");
	 
		 final StringBuilder query =BasicFilterQueryBuilder.deleteServiceDetailsQuery();

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
				 
				ps.setInt(1,serviceData.getServiceId() );		 
				return ps;
			}
		}, keyHolder);
		// LOGGER.debug(trackId + " Tracker created ");
		final int serviceId = Integer.valueOf(keyHolder.getKeyList().get(0)
				.get("serviceid").toString());

		serviceIdMap.put("serviceId", serviceId+" ");

		return serviceIdMap;
	}

	/* (non-Javadoc)
	 * @see com.advaizer.repository.LocationRepository#getMajorZoneAreaRepository(int)
	 */

}
