/**
 * 
 */
package com.advaizer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.advaizer.common.RAConstants;
import com.advaizer.common.RoamerCampaignTrackerQueryBuilder;
import com.advaizer.common.TagQueryBuilder;
import com.advaizer.enums.Relation;
import com.advaizer.enums.RoamType;
import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.Filter;
import com.advaizer.model.Tag;
import com.facebook.presto.jdbc.internal.joda.time.DateTime;

/**
 * @author cheshta
 *
 */
@Repository
public class TagRepositoryImpl implements TagRepository{
	
	private static Logger LOGGER = LogManager.getLogger(TagRepositoryImpl.class.getName());
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate prestoJdbcTempate;

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.TagRepository#isExistingTag(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isExistingTag(final String tagName, final String roamType) {
		// TODO Auto-generated method stub
		final StringBuilder query = new StringBuilder(); 
		
		LOGGER.debug("Getting query for tag details for tagname: "+tagName);
		
		if( RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)){
			TagQueryBuilder.populateQueryForTagDetails(query,Relation.TAGOUT);
		}
		else if(RoamType.IN.getRoamType().equalsIgnoreCase(roamType)){
			TagQueryBuilder.populateQueryForTagDetails(query,Relation.TAGIN);
		}
		final Object[] parameters = new Object[] {tagName};
		
		LOGGER.debug(" query : " + query.toString());

		final Integer tagCount = jdbcTemplate.queryForObject(query.toString(), 
				Integer.class, parameters);
						
		return tagCount > 0;
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.TagRepository#saveTrackerDetails(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, String> saveTag(final Filter filter, final String tagName, final String tagType, final String roamType,
			String campaignStartDate, String campaignEndDate, final String filterLabels, 
			final String filterString, final int campaignFrequency, final String projectedUsageMo, 
			final String projectedUsageMt, final String projectedUsageData)
			throws RADataAccessException {
		// TODO Auto-generated method stub
		
		DateFormat dateFormat = new SimpleDateFormat(RAConstants.DEFAULT_DATE_FORMAT);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		DateTime monitoringDurationEnd = null;
		try {
			monitoringDurationEnd = new DateTime(dateFormat.parse(campaignEndDate)).plusDays(7);
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.debug("Parse Exception: "+e.getMessage());	
			e.printStackTrace();
		}
		
		
		final DateFormat dbDateFormat =  new SimpleDateFormat("yyyy-MM-dd");
		dbDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		final Tag tag = new Tag();		
		final Map<String, Object> parameterMap = new LinkedHashMap<String, Object>();
		
		final StringBuilder query = new StringBuilder(); 
		final StringBuilder filterClause = new StringBuilder("");
						
		LOGGER.debug("Getting query for saving tag details");	
				
		TagQueryBuilder.populateQueryForTagSave(query, roamType,tagType, campaignFrequency, filter, filterClause);
		
		try {
			campaignStartDate = dbDateFormat.format(dateFormat.parseObject(campaignStartDate));		
			campaignEndDate = dbDateFormat.format(dateFormat.parseObject(campaignEndDate));
		} catch (final ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final String monitoringDurationEndStr = dbDateFormat.format(monitoringDurationEnd.toDate());
		
		parameterMap.put("tagname", tagName.toLowerCase());			
		parameterMap.put("tagType", tagType);
		parameterMap.put("filterlabel", filterLabels);
		parameterMap.put("filterstring", filterClause.substring(filterClause.indexOf("and")!=-1 ? filterClause.indexOf("and")+3 : 0,  filterClause.length()).toString());
//		parameterMap.put("filterstring", filterString);
		parameterMap.put("campaignfrequency", campaignFrequency);
		parameterMap.put("campaigndurationstarttime", campaignStartDate);
		parameterMap.put("campaigndurationendtime", campaignEndDate);
		parameterMap.put("monitoringdurationstarttime", campaignStartDate);
		parameterMap.put("monitoringdurationendtime", monitoringDurationEndStr);
		parameterMap.put("projectedusagemomin", projectedUsageMo.split("-")[0]);
		parameterMap.put("projectedusagemomax", projectedUsageMo.split("-")[1]);
		parameterMap.put("projectedusagemtmin", projectedUsageMt.split("-")[0]);
		parameterMap.put("projectedusagemtmax", projectedUsageMt.split("-")[1]);
		parameterMap.put("projectedusagedatamin", projectedUsageData.split("-")[0]);
		parameterMap.put("projectedusagedatamax", projectedUsageData.split("-")[1]);
		
		LOGGER.debug(" query : " + query.toString());	
		
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		 jdbcTemplate.update(new PreparedStatementCreator() {
	        @Override
			public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
	            final PreparedStatement ps =
	                connection.prepareStatement(query.toString(),Statement.RETURN_GENERATED_KEYS);
	            final Object[] parameterArray = parameterMap.values().toArray();
	            ps.setString(1, parameterArray[0].toString()); //name
	            ps.setString(2, parameterArray[1].toString()); //tagType
	            ps.setString(3, parameterArray[2].toString()); //filterlabel
	            ps.setString(4, parameterArray[3].toString()); //filterstring
	            ps.setInt(5, Integer.parseInt(parameterArray[4].toString())); //campaignfrequency
	            ps.setString(6, parameterArray[5].toString()); //campaigndurationstarttime
	            ps.setString(7, parameterArray[6].toString()); // campaigndurationendtime
	            ps.setString(8, parameterArray[7].toString()); //monitoringdurationstarttime
	            ps.setString(9, parameterArray[8].toString()); //monitoringdurationendtime
	            ps.setInt(10, Integer.parseInt(parameterArray[9].toString())); //projectedusagemomin
	            ps.setInt(11, Integer.parseInt(parameterArray[10].toString())); //projectedusagemomax
	            ps.setInt(12, Integer.parseInt(parameterArray[11].toString())); //projectedusagemtmin
	            ps.setInt(13, Integer.parseInt(parameterArray[12].toString())); //projectedusagemtmax
	            ps.setInt(14, Integer.parseInt(parameterArray[13].toString())); //projectedusagedatamin
	            ps.setInt(15, Integer.parseInt(parameterArray[14].toString())); //projectedusagedatamax
	           	            
	            return ps;
	        }
	    },
	    keyHolder);

		final Long tagId = Long.valueOf(keyHolder.getKeyList().get(0).get("id").toString());
		
		LOGGER.debug(" Tag created with tag id: "+tagId);
		
		if(tagId >= 1){
			tag.setId(tagId);
			tag.setTagName(tagName);		
			tag.setFilterLabel(filterLabels);
			tag.setFilterString(filterString);	
			tag.setCampaignFrequency(campaignFrequency);
			tag.setCampaignDurationStartTime(campaignStartDate);
			tag.setCampaignDurationEndTime(campaignEndDate);
			tag.setMonitoringDurationStartTime(campaignStartDate);
			tag.setMonitoringDurationEndTime(monitoringDurationEndStr);
			tag.setTagType(tagType);
			
			try {
				 dateFormat = new SimpleDateFormat(RAConstants.TRACKER_DATE_FORMAT);
				saveRoamerCampaignTracker(filterClause, roamType,tag,dateFormat.parse(campaignStartDate).getTime(), 
						dateFormat.parse(campaignEndDate).getTime());
			} catch (final ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		return tag.convertToMap();
	}

	/**
	 * @param roamType and tag
	 */
	private void saveRoamerCampaignTracker(final StringBuilder filterClause, final String roamType,final Tag tag,
			final long campaignStartDate, final long campaignEndDate) throws RADataAccessException {
		// TODO Auto-generated method stub
		
		final StringBuilder fetchImsiQuery = new StringBuilder(); 
		
		
		RoamerCampaignTrackerQueryBuilder.populateQueryForFetchingIMSI(filterClause,tag, fetchImsiQuery, roamType,
				campaignStartDate, campaignEndDate);
		
		
		
		try {
			final Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			
			final List<Long> imsiList=prestoJdbcTempate.query(fetchImsiQuery.toString(), new RowMapper<Long>(){
				@Override
				public Long mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
																		
					return rs.getLong("imsi");
				}
			});
			
			
			final StringBuilder query=new StringBuilder("");
			
			LOGGER.error("imsiList.size "+imsiList.size()+"fdgff");
			
			if(imsiList!=null && imsiList.size()>0){
			RoamerCampaignTrackerQueryBuilder.populateQueryForRoamerCampaignTrackerSave(query, roamType);
						 
				  jdbcTemplate.batchUpdate(query.toString(), new BatchPreparedStatementSetter() {
				 
					@Override
					public void setValues(final PreparedStatement ps, final int i) throws SQLException {
						
						ps.setLong(1,tag.getId());
						ps.setLong(2, imsiList.get(i));
						ps.setLong(3,cal.getTimeInMillis()/1000 );
						ps.setInt(4, 1);
						ps.setInt(5, 1);
						
						
					}
				 
					@Override
					public int getBatchSize() {
						
						return imsiList.size();
					}
				  });
				  
				  
				  
			}
			
			
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			throw new RADataAccessException(dae);
		}
		
		
		
	
		
		
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.TagRepository#getAllTags(java.lang.String)
	 */
	@Override
	public Map<String,List<Map<String,String>>> getAllTags(final String roamType, final String ids) throws RADataAccessException{
		final String query = TagQueryBuilder.queryForAllTags(roamType, ids);
		
		LOGGER.debug("Getting all tags ");
		LOGGER.debug("Tags query : " + query);
		
//		final List<Map<String,String>> tags = new ArrayList<Map<String,String>>(100);
		
		final Map<String,List<Map<String,String>>> tagMap = new HashMap<String,List<Map<String,String>>>(100);
		tagMap.put("BeforeTravel", new ArrayList<Map<String,String>>());
		tagMap.put("UponLanding", new ArrayList<Map<String,String>>());
		tagMap.put("OnReturn", new ArrayList<Map<String,String>>());
	
		try {
			 jdbcTemplate.query(query, new RowMapper<Map<String,String>>(){
				@Override
				public Map<String,String> mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					final Map<String,String> tag = new HashMap<String,String>();
					tag.put("id",rs.getString("id"));
					tag.put("tagname",rs.getString("tagname"));
					final String tagType = rs.getString("tagtype");
					tag.put("tagtype",tagType);
					tag.put("filterlabel",rs.getString("filterlabel"));
					
					tag.put("filterstring",rs.getString("filterstring"));
					tag.put("campaignfrequency",rs.getString("campaignfrequency"));
					tag.put("campaigndurationstarttime",rs.getString("campaigndurationstarttime"));
					tag.put("campaigndurationendtime",rs.getString("campaigndurationendtime"));
					tag.put("monitoringdurationstarttime",rs.getString("monitoringdurationstarttime"));
					tag.put("monitoringdurationendtime",rs.getString("monitoringdurationendtime"));
					tag.put("projectedusagemomin",rs.getString("projectedusagemomin"));
					tag.put("projectedusagemomax",rs.getString("projectedusagemomax"));
					tag.put("projectedusagemtmin",rs.getString("projectedusagemtmin"));
					tag.put("projectedusagemtmax",rs.getString("projectedusagemtmax"));
					tag.put("projectedusagedatamin",rs.getString("projectedusagedatamin"));
					tag.put("projectedusagedatamax",rs.getString("projectedusagedatamax"));
					if(tagMap.get(tagType)!=null){
					tagMap.get(tagType).add(tag);
					tagMap.put(tagType, tagMap.get(tagType));
					}
										
					return null;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			throw new RADataAccessException(dae);
		}
		
		LOGGER.trace("Tracker details : " + tagMap);
		
		return tagMap;
	}
	

}
