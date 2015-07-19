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
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

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

import com.advaizer.common.CommonUtil;
import com.advaizer.common.RAConstants;
import com.advaizer.common.TrackerQueryBuilder;
import com.advaizer.enums.Relation;
import com.advaizer.enums.RoamType;
import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.Filter;
import com.advaizer.model.RoamingStatistics;
import com.advaizer.model.Tracker;
import com.facebook.presto.jdbc.internal.joda.time.DateTime;
import com.facebook.presto.jdbc.internal.joda.time.Period;


/**
 * @author cheshta
 *
 */
@Repository
public class TrackerRepositoryImpl implements TrackerRepository{

	private static Logger LOGGER = LogManager.getLogger(TrackerRepositoryImpl.class.getName());
		
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JdbcTemplate prestoJdbcTempate;
	
	/** The count sort desc. */
	private static Comparator<Object[]> COUNT_SORT_DESC = new Comparator<Object[]> () {

		@Override
		public int compare(final Object[] o1, final Object[] o2) {
			return ((Double)o2[1]).compareTo((Double)o1[1]);
		}
		
	};
			
	@Override
	public Map<String, String> saveTrackerDetails(final Filter filter, final String trackName,
			final String roamType ,final String startDateRange, final String endDateRange, 
			final String filterLabels, final String filterJson, final boolean isCustomTracker,
			final String quarterlyOption) 
			throws RADataAccessException {
		
		final Tracker tracker = new Tracker();		
		final Map<String, Object> parameterMap = new LinkedHashMap<String, Object>();
		
		final StringBuilder query = new StringBuilder(); 
		final StringBuilder filterString = new StringBuilder("");
				
		LOGGER.debug("Getting query for saving track details");
		
		parameterMap.put("trackName", trackName.toLowerCase());			
				
		TrackerQueryBuilder.populateQueryForTrackSave(filter, query, parameterMap, 
					filterString,roamType);
		
//		parameterMap.put("filter_string", microSegmentCharts);
		parameterMap.put("filter_string", filterJson);
					
//		final MutableDateTime mdt = new MutableDateTime();
//	    mdt.addMonths(1);
//	    mdt.setMillisOfDay(0); // make sure you're at midnight
	    		
		if(isCustomTracker){
			populateDatesForCustomTracker(parameterMap, startDateRange.split(":"), endDateRange.split(":"));
		}
		else if(quarterlyOption!= null && !quarterlyOption.equals("")){
			populateDatesForQuarterlyTracker(parameterMap, quarterlyOption);
		}
		else{
			populateDates(parameterMap, startDateRange, endDateRange);
		}	
		
		parameterMap.put("filterLabels", filterLabels);	
				
		LOGGER.debug(" query : " + query.toString());	
				
//		final int trackId = jdbcTemplate.update(query.toString(), parameterMap.values().toArray()); 
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		 jdbcTemplate.update(new PreparedStatementCreator() {
	        @Override
			public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
	            final PreparedStatement ps =
	                connection.prepareStatement(query.toString(),Statement.RETURN_GENERATED_KEYS);
	            final Object[] parameterArray = parameterMap.values().toArray();
	            ps.setString(1, parameterArray[0].toString()); //name
	            ps.setString(2, parameterArray[1].toString()); //filterString
	            ps.setString(3, parameterArray[2].toString()); //start_old_timeformat
	            ps.setInt(4, Integer.parseInt(parameterArray[3].toString())); //start_old_year
	            ps.setInt(5, Integer.parseInt(parameterArray[4].toString())); //start_old_month
	            ps.setInt(6, Integer.parseInt(parameterArray[5].toString())); //start_old_day
	            ps.setString(7, parameterArray[6].toString()); // end_old_timeformat
	            ps.setInt(8, Integer.parseInt(parameterArray[7].toString())); //end_old_year
	            ps.setInt(9, Integer.parseInt(parameterArray[8].toString())); //end_old_month
	            ps.setInt(10, Integer.parseInt(parameterArray[9].toString())); //end_old_day
	            ps.setString(11, parameterArray[10].toString()); //start_new_timeformat
	            ps.setInt(12, Integer.parseInt(parameterArray[11].toString())); //start_new_year
	            ps.setInt(13, Integer.parseInt(parameterArray[12].toString())); //start_new_month
	            ps.setInt(14, Integer.parseInt(parameterArray[13].toString())); //start_new_day
	            ps.setString(15, parameterArray[14].toString()); //end_new_timeformat
	            ps.setInt(16, Integer.parseInt(parameterArray[15].toString())); //end_new_year
	            ps.setInt(17, Integer.parseInt(parameterArray[16].toString())); //end_new_month
	            ps.setInt(18, Integer.parseInt(parameterArray[17].toString())); //end_new_day
	            ps.setString(19, parameterArray[18].toString()); //filterlabel  
	            
	            return ps;
	        }
	    },
	    keyHolder);
//		LOGGER.debug(trackId + " Tracker created ");
		final long trackerId = Long.valueOf(keyHolder.getKeyList().get(0).get("id").toString());
		
		if(trackerId >=1){
			tracker.setId(trackerId);
			tracker.setTrackName(trackName);
//			tracker.setFilterLabel(filterString.toString());			
			tracker.setFilterLabel(filterLabels);
			tracker.setFilterString(filterJson);			
		}
		
		return tracker.convertToMap();
	}
	
	public void populateDates(final Map<String, Object> parameterMap, 
			final String startDateRange, final String endDateRange){
		
		final DateFormat dateFormat = new SimpleDateFormat(RAConstants.DEFAULT_DATE_FORMAT);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
				
		final DateTime today = new DateTime();
		
		DateTime startDate = null;
	    DateTime endDate = null;
		try {
			startDate = new DateTime(dateFormat.parse(startDateRange.split(":")[0]));
			endDate = new DateTime(dateFormat.parse(endDateRange.split(":")[0]));
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		parameterMap.put("start_old_timeformat","%Y-%m-01 00:00:00");
		parameterMap.put("start_old_year",new Period(today, startDate).getYears());
		parameterMap.put("start_old_month",new Period(today, startDate).getMonths());
		parameterMap.put("start_old_day", 0);
							
		parameterMap.put("end_old_timeformat","%Y-%m-01 00:00:00");
		parameterMap.put("end_old_year",parameterMap.get("start_old_year"));
		parameterMap.put("end_old_month",new Period(today, startDate).getMonths()+1);
		parameterMap.put("end_old_day",0);
//		parameterMap.put("end_old_day", new Period(today, startDate).getDays());
		
		parameterMap.put("start_new_timeformat","%Y-%m-01 00:00:00");
//		final Days days = Days.daysBetween(today, startDate);
		parameterMap.put("start_new_year", new Period(today, endDate).getYears());
		parameterMap.put("start_new_month", new Period(today, endDate).getMonths());
		parameterMap.put("start_new_day",0);
//		parameterMap.put("start_new_day", new Period(today, endDate).getDays());
	
		parameterMap.put("end_new_timeformat", "%Y-%m-01 00:00:00");
		parameterMap.put("end_new_year", parameterMap.get("start_new_year"));
		parameterMap.put("end_new_month", (new Period(today, endDate).getMonths() + 1));
		parameterMap.put("end_new_day", 0);
//		parameterMap.put("end_new_day", new Period(today, endDate).getDays());
	}
	
	public void populateDatesForCustomTracker(final Map<String, Object> parameterMap, 
			final String[] startDateRange, final String[] endDateRange){
		
		final DateFormat dateFormat = new SimpleDateFormat(RAConstants.DEFAULT_DATE_FORMAT);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		final DateFormat dateFormat_time =  new SimpleDateFormat("yyyy-MM-dd");
		dateFormat_time.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		try {
			parameterMap.put("start_old_timeformat", dateFormat_time.format(dateFormat.parse(startDateRange[0]))+" 00:00:00");
			
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error occurred while formatting date: ", e);
		}
		parameterMap.put("start_old_year",0);
		parameterMap.put("start_old_month",0);
		parameterMap.put("start_old_day", 0);
							
		try {
			parameterMap.put("end_old_timeformat", dateFormat_time.format(dateFormat.parse(startDateRange[1]))+" 00:00:00");
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error occurred while formatting date: ", e);
		}
		parameterMap.put("end_old_year",0);
		parameterMap.put("end_old_month",0);
		parameterMap.put("end_old_day",0);
		
		try {
			parameterMap.put("start_new_timeformat", dateFormat_time.format(dateFormat.parse(endDateRange[0]))+" 00:00:00");
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error occurred while formatting date: ", e);
		}
		
		parameterMap.put("start_new_year", 0);
		parameterMap.put("start_new_month", 0);
		parameterMap.put("start_new_day",0);
	
		try {
			parameterMap.put("end_new_timeformat", dateFormat_time.format(dateFormat.parse(endDateRange[1]))+" 00:00:00");
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error occurred while formatting date: ", e);
		}
		parameterMap.put("end_new_year", 0);
		parameterMap.put("end_new_month", 0);
		parameterMap.put("end_new_day", 0);
	}
	
	public void populateDatesForQuarterlyTracker(final Map<String, Object> parameterMap, 
			 final String quarterlyOption){
					
		final String[] startDateOption = getValuesForQuarterlyOption(quarterlyOption.split(":")[0]);
		final String[] endDateOption = getValuesForQuarterlyOption(quarterlyOption.split(":")[1]);
				
		parameterMap.put("start_old_timeformat", startDateOption[0]);			
		
		parameterMap.put("start_old_year",startDateOption[1]);
		parameterMap.put("start_old_month",startDateOption[2]);
		parameterMap.put("start_old_day", startDateOption[3]);
							
		parameterMap.put("end_old_timeformat", startDateOption[4]);
		
		parameterMap.put("end_old_year",startDateOption[5]);
		parameterMap.put("end_old_month",startDateOption[6]);
		parameterMap.put("end_old_day",startDateOption[7]);
				
		parameterMap.put("start_new_timeformat", endDateOption[0]);		
		
		parameterMap.put("start_new_year", endDateOption[1]);
		parameterMap.put("start_new_month", endDateOption[2]);
		parameterMap.put("start_new_day", endDateOption[3]);
			
		parameterMap.put("end_new_timeformat", endDateOption[4]);
		
		parameterMap.put("end_new_year", endDateOption[5]);
		parameterMap.put("end_new_month", endDateOption[6]);
		parameterMap.put("end_new_day", endDateOption[7]);		
	}
	
	public String[] getValuesForQuarterlyOption(final String option){
		String[] dateArray = null;
		if(option.equalsIgnoreCase("this quarter")){				
				dateArray = new String[] {"%Y-((%m/3)*3)-01 00:00:00","0","-3","0","%Y-((%m/3)*3)-01 00:00:00","0","0","-1"};			
		}
		if(option.equalsIgnoreCase("last quarter")){
					dateArray = new String[] {"%Y-((%m/3)*3)-01 00:00:00","0","-6","0","%Y-((%m/3)*3)-01 00:00:00","0","-3","-1"};		
		}
		if(option.equalsIgnoreCase("last year last quarter")){
					dateArray = new String[] {"%Y-((%m/3)*3)-01 00:00:00","-1","-6","0","%Y-((%m/3)*3)-01 00:00:00","-1","-3","-1"};		
		}
		if(option.equalsIgnoreCase("last year this quarter")){
					dateArray = new String[] {"%Y-((%m/3)*3)-01 00:00:00","-1","-3","0","%Y-((%m/3)*3)-01 00:00:00","-1","0","-1"};				
		}
		return dateArray;
	}
			
	/**
	 * returns true if any tracker matching with 'trackName' is existing 
	 */
	@Override
	public boolean isExistingTracker(final String trackName, final String roamType) {
		// TODO Auto-generated method stub
		final StringBuilder query = new StringBuilder(); 
		
		LOGGER.debug("Getting query for track details for trackname: "+trackName);
		
		if( RoamType.OUT.getRoamType().equalsIgnoreCase(roamType)){
			TrackerQueryBuilder.populateQueryForTrackDetails(query,Relation.TRACKEROUT);
		}
		else if(RoamType.IN.getRoamType().equalsIgnoreCase(roamType)){
			TrackerQueryBuilder.populateQueryForTrackDetails(query,Relation.TRACKERIN);
		}
		final Object[] parameters = new Object[] {trackName};
		
		LOGGER.debug(" query : " + query.toString());

		final Integer trackCount = jdbcTemplate.queryForObject(query.toString(), 
				Integer.class, parameters);
						
		return trackCount > 0;
	}
	
	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.TrackRepository#getAllTrackers(java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getAllTrackers(final String roamType,final String trackerName)
			throws RADataAccessException {
		// TODO Auto-generated method stub
		final String query = TrackerQueryBuilder.queryForAllTrackers(roamType,trackerName);
				
		LOGGER.debug("Getting all trackers ");
		LOGGER.debug("Tracker query : " + query);
		
		List<Map<String,String>> trackers = new ArrayList<Map<String,String>>(100);

		try {
			trackers = jdbcTemplate.query(query, new RowMapper<Map<String,String>>(){
				@Override
				public Map<String,String> mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
					
					final Map<String,String> tracker = new HashMap<String,String>();
					tracker.put("id",rs.getString("id"));
					tracker.put("trackName",rs.getString("track_name"));
					tracker.put("filterString",rs.getString("filter_string"));
					tracker.put("filterLabel",rs.getString("filterLabel"));
					
					tracker.put("startOldTimeformat",rs.getString("oldstartdate"));
					tracker.put("startNewTimeformat",rs.getString("newstartdate"));
					tracker.put("endOldTimeformat",rs.getString("oldenddate"));
					tracker.put("endNewTimeformat",rs.getString("newenddate"));
																								
					return tracker;
				}
			});
		} catch(final DataAccessException dae) {
			LOGGER.error("Error occurred while getting all trackers: ", dae);
			throw new RADataAccessException(dae);
		}
						
		LOGGER.debug("Trackers found : " + trackers.size());
		LOGGER.trace("Tracker details : " + trackers);
		
		return trackers;
	}
	
	@Override
	public Map<String,String> getTrackerDetails(final List<Tracker> trackers,final String roamType) throws RADataAccessException{
		
		final Map<String,String> trackerDetails = new HashMap<String,String>(100);
		
		LOGGER.debug("Getting all filter Strings for all trackers ");
		
		final Map<String,List<String>> filterStringsMap = CommonUtil.extractFilterStrings(trackers,roamType);
		final StringBuilder filterNames = new StringBuilder();
		
		for (final Map.Entry<String, List<String>> filterQuery : filterStringsMap.entrySet()) {		
			for(final String filterQueryString : filterQuery.getValue()){
				
				LOGGER.debug("Query : " + filterQueryString);
				
				try {
					filterNames.append( prestoJdbcTempate.query(filterQueryString, new RowMapper<String>(){
						@Override
						public String mapRow(final ResultSet rs, final int rowNumber) throws SQLException {
							final String filters = rs.getString(1);				
							return filters;
						}
					}));
					
					trackerDetails.put(filterQuery.getKey() , filterNames.toString());
					filterNames.setLength(0);
				
				} catch(final DataAccessException dae) {
					LOGGER.error("Error occurred while getting all trackers: ", dae.getMessage());
					throw new RADataAccessException(dae);
				}				
			}
		}		
		return trackerDetails;
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.TrackRepository#deleteTracker(java.lang.String)
	 */
	@Override
	public String deleteTracker(final long trackerId, final String roamType)  throws RADataAccessException{
		// TODO Auto-generated method stub
		final String query = TrackerQueryBuilder.queryForDeleteTrackers(roamType);
		
		LOGGER.debug("Getting all trackers ");
		LOGGER.debug("Tracker query : " + query);
		
		final int trackId = jdbcTemplate.update(query.toString(), new Object[]{trackerId}); 
		LOGGER.debug(" Tracker deleted: " + (trackId == 1? "yes" : "no"));
		return "";
	}
	
	@Override
	public Map<String, Object> getTrackerDataForNetwork(final Filter filter,
			final String column, final String columnType, final Map<String, String> catNameValue,
			final String roamType, final Long newStartdate, final Long newEndDate) throws RADataAccessException {
		
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		final DateFormat dateFormat = new SimpleDateFormat(RAConstants.DEFAULT_DATE_FORMAT);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
				

		final int startDate_daysBetween = Math.abs((int) ((filter.getDateTo() -  filter.getDateFrom()) / (60*60*24))) + 1;
		final int endDate_daysBetween = Math.abs((int) ((newEndDate - newStartdate) / (60*60*24))) + 1; 
		
		final StringBuilder query = new StringBuilder();

		query.append("select 'startDate' date, "+ startDate_daysBetween +" numberOfDays, ");
		TrackerQueryBuilder.populateQueryForTrackerNetwork(filter, query, parameterMap, roamType,
				filter.getDateFrom(),filter.getDateTo());
		query.append(" union all ");
		query.append("select 'endDate' date, "+ endDate_daysBetween +" numberOfDays, ");
		TrackerQueryBuilder.populateQueryForTrackerNetwork(filter, query, parameterMap, roamType,
				newStartdate, newEndDate);
		query.append(" order by imsicount desc, mocallminutes desc, mtcallminutes desc, ")
		.append("  datausage desc");
		
		LOGGER.debug("Getting microsegment chart data for attribute : Network ");
		LOGGER.debug(" Network  query : " + query.toString());		
		
		
		final Map<String,Object> dataMap = new HashMap<String, Object>();
		
		final Map<String,Map<String,Object>> roamersMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("roamers",roamersMap);

		final Map<String,Map<String,Object>> mtMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("mt",mtMap);
		
		final Map<String,Map<String,Object>> moMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("mo",moMap);
		
		final Map<String,Map<String,Object>> datausageMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("data",datausageMap);
		
		dataMap.put("earlierRoamers",new Double(0));
		dataMap.put("latestRoamers",new Double(0));
		
		dataMap.put("earlierMt",new Double(0));
		dataMap.put("latestMt",new Double(0));
		
		dataMap.put("earlierMo",new Double(0));
		dataMap.put("latestMo",new Double(0));
		
		dataMap.put("earlierData",new Double(0));
		dataMap.put("latestData",new Double(0));
		
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				
				String categoryValue = null;
				String dateType = null;	
				int numberOfDays = 0;
				
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {

					dateType = rs.getString("date");	
					numberOfDays = rs.getInt("numberOfDays");
					
					final double imsicount = rs.getDouble("imsicount");
					final double mocallminutes = rs.getDouble("mocallminutes");
					final double mtcallminutes = rs.getDouble("mtcallminutes");
					final double datausage = rs.getDouble("datausage");
					
					
					final double roamersPerDay = imsicount / numberOfDays;
					final double moPerDay = mocallminutes / numberOfDays;
					final double mtPerDay = mtcallminutes / numberOfDays;
					final double dataPerDay = datausage / numberOfDays;
					
					
					categoryValue = rs.getString("networkName");
					categoryValue = CommonUtil.normalizeString(categoryValue);
					
					populateCategoryMap(roamersMap, roamersPerDay,categoryValue,dateType);
					populateCategoryMap(moMap, moPerDay,categoryValue,dateType);
					populateCategoryMap(mtMap, mtPerDay,categoryValue,dateType);
					populateCategoryMap(datausageMap, dataPerDay,categoryValue,dateType);
					
					if(dateType.equalsIgnoreCase("startDate")) {	
						dataMap.put("earlierRoamers",(Double)dataMap.get("earlierRoamers") + imsicount);
						dataMap.put("earlierMt",(Double)dataMap.get("earlierMt") + mtcallminutes);
						dataMap.put("earlierMo",(Double)dataMap.get("earlierMo") + mocallminutes);
						dataMap.put("earlierData",(Double)dataMap.get("earlierData") + datausage);
					} else if(dateType.equalsIgnoreCase("endDate")) {
						dataMap.put("latestRoamers",(Double)dataMap.get("latestRoamers") + imsicount);
						dataMap.put("latestMt",(Double)dataMap.get("latestMt") + mtcallminutes);
						dataMap.put("latestMo",(Double)dataMap.get("latestMo") + mocallminutes);
						dataMap.put("latestData",(Double)dataMap.get("latestData") + datausage);
					}		
					return null;
				}
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting network group data in microsegment : ", dae);
			throw new RADataAccessException(dae);
		}
		dataMap.put("earlierRoamers", (Double)dataMap.get("earlierRoamers") / startDate_daysBetween);
		dataMap.put("latestRoamers", (Double)dataMap.get("latestRoamers") / endDate_daysBetween);
		
		
		dataMap.put("earlierMt", (Double)dataMap.get("earlierMt") / startDate_daysBetween);
		dataMap.put("latestMt", (Double)dataMap.get("latestMt") / endDate_daysBetween);
		
		dataMap.put("earlierMo", (Double)dataMap.get("earlierMo") / startDate_daysBetween);
		dataMap.put("latestMo", (Double)dataMap.get("latestMo") / endDate_daysBetween);
		
		dataMap.put("earlierData", (Double)dataMap.get("earlierData") / startDate_daysBetween);
		dataMap.put("latestData", (Double)dataMap.get("latestData") / endDate_daysBetween);
				
		LOGGER.debug("Network  data found :" + dataMap.size());
		LOGGER.trace("Network  data :" + dataMap);
		
		return dataMap;		
	}	


	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.TrackRepository#getTrackerDataForNetworkGroup(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.String, java.util.Map, java.lang.String)
	 */
	@Override
	public Map<String, Object> getTrackerDataForNetworkGroup(final Filter filter, 
			final String column, final String columnType, final Map<String, String> catNameValue,
			final String roamType, final Long newStartdate, final Long newEndDate) throws RADataAccessException{
		// TODO Auto-generated method stub
		
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		final int startDate_daysBetween = Math.abs((int) ((filter.getDateTo() -  filter.getDateFrom()) / (60*60*24))) + 1;
		final int endDate_daysBetween = Math.abs((int) ((newEndDate - newStartdate) / (60*60*24))) + 1; 
		
		final StringBuilder query = new StringBuilder();
		query.append("SELECT 'startDate' date, "+ startDate_daysBetween +" numberOfDays, ");
		TrackerQueryBuilder.populateQueryForTrackerNetworkGroup(filter, query, parameterMap, roamType,
				filter.getDateFrom(),filter.getDateTo());
		query.append(" union all ");
		query.append("SELECT 'endDate' date, "+ endDate_daysBetween +" numberOfDays, ");
		TrackerQueryBuilder.populateQueryForTrackerNetworkGroup(filter, query, parameterMap, roamType,
				newStartdate, newEndDate);
		query.append(" order by imsicount desc, mocallminutes desc, mtcallminutes desc, datausage desc");
				
		LOGGER.debug("Getting microsegment chart data for attribute : Network Group");
		LOGGER.debug(" Network Group query : " + query.toString());
		
		
		final Map<String,Object> dataMap = new HashMap<String, Object>();
		
		final Map<String,Map<String,Object>> roamersMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("roamers",roamersMap);
		
		final Map<String,Map<String,Object>> mtMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("mt",mtMap);
		
		final Map<String,Map<String,Object>> moMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("mo",moMap);
		
		final Map<String,Map<String,Object>> datausageMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("data",datausageMap);
		
		dataMap.put("earlierRoamers",new Double(0));
		dataMap.put("latestRoamers",new Double(0));	
		
		dataMap.put("earlierMt",new Double(0));
		dataMap.put("latestMt",new Double(0));
		
		dataMap.put("earlierMo",new Double(0));
		dataMap.put("latestMo",new Double(0));
		
		dataMap.put("earlierData",new Double(0));
		dataMap.put("latestData",new Double(0));
		
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				
				String networkGroup = null;
				String dateType = null;		
				int numberOfDays = 1;
				
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {
					
					dateType = rs.getString("date");					
					networkGroup = rs.getString("networkGroup");
					networkGroup = CommonUtil.normalizeString(networkGroup);	
					
					numberOfDays = rs.getInt("numberOfDays");
					final double imsicount = rs.getDouble("imsicount");
					final double mocallminutes = rs.getDouble("mocallminutes");
					final double mtcallminutes = rs.getDouble("mtcallminutes");
					final double datausage = rs.getDouble("datausage");
					
					final double roamersPerDay = imsicount / numberOfDays;
					final double moPerDay = mocallminutes / numberOfDays;
					final double mtPerDay = mtcallminutes / numberOfDays;
					final double dataPerDay = datausage / numberOfDays;
					
					if (networkGroup != null && !networkGroup.isEmpty() && networkGroup.contains(RAConstants.PIPE)) {
						final String[] groupArray = networkGroup.split("\\"+RAConstants.PIPE);
						for (final String groupName : groupArray) {
							populateNetworkGroup(roamersMap, mtMap, moMap,
									datausageMap, roamersPerDay, moPerDay,
									mtPerDay, dataPerDay, groupName);
						}
						
					} else {
						
						populateNetworkGroup(roamersMap, mtMap, moMap,
								datausageMap, roamersPerDay, moPerDay,
								mtPerDay, dataPerDay, networkGroup);
					}					
					if(dateType.equalsIgnoreCase("startDate")) {	
						dataMap.put("earlierRoamers",(Double)dataMap.get("earlierRoamers") + imsicount);
						dataMap.put("earlierMt",(Double)dataMap.get("earlierMt") + mtcallminutes);
						dataMap.put("earlierMo",(Double)dataMap.get("earlierMo") + mocallminutes);
						dataMap.put("earlierData",(Double)dataMap.get("earlierData") + datausage);
					} else if(dateType.equalsIgnoreCase("endDate")) {
						dataMap.put("latestRoamers",(Double)dataMap.get("latestRoamers") + imsicount);
						dataMap.put("latestMt",(Double)dataMap.get("latestMt") + mtcallminutes);
						dataMap.put("latestMo",(Double)dataMap.get("latestMo") + mocallminutes);
						dataMap.put("latestData",(Double)dataMap.get("latestData") + datausage);
					}	
					return null;
				}

				/**
				 * @param roamersMap
				 * @param mtMap
				 * @param moMap
				 * @param datausageMap
				 * @param roamersPerDay
				 * @param moPerDay
				 * @param mtPerDay
				 * @param dataPerDay
				 * @param groupName
				 */
				private void populateNetworkGroup(
						final Map<String, Map<String, Object>> roamersMap,
						final Map<String, Map<String, Object>> mtMap,
						final Map<String, Map<String, Object>> moMap,
						final Map<String, Map<String, Object>> datausageMap,
						final double roamersPerDay, final double moPerDay,
						final double mtPerDay, final double dataPerDay,
						final String groupName) {
					Map<String, Object> groupRoamersMap = roamersMap.get(groupName);		
					if (groupRoamersMap == null) {
						groupRoamersMap = new HashMap<String, Object>(2);
						roamersMap.put(groupName, groupRoamersMap);
					}
					
					Double roamers = (Double) groupRoamersMap.get(dateType);
					if (roamers == null) {
						roamers = new Double(0);
						groupRoamersMap.put(dateType,roamers);
					}
					groupRoamersMap.put(dateType, new Double(roamers.doubleValue() + roamersPerDay));
					// MO map
					Map<String, Object> groupMoMap = moMap.get(groupName);		
					if (groupMoMap == null) {
						groupMoMap = new HashMap<String, Object>(2);
						moMap.put(groupName, groupMoMap);
					}
					
					Double mo = (Double) groupMoMap.get(dateType);
					if (mo == null) {
						mo = new Double(0);
						groupMoMap.put(dateType,mo);
					}
					groupMoMap.put(dateType, new Double(mo.doubleValue() + moPerDay));
					
					// MT Map
					Map<String, Object> groupMtMap = mtMap.get(groupName);		
					if (groupMtMap == null) {
						groupMtMap = new HashMap<String, Object>(2);
						mtMap.put(groupName, groupMtMap);
					}
					
					Double mt = (Double) groupMtMap.get(dateType);
					if (mt == null) {
						mt = new Double(0);
						groupMtMap.put(dateType,mt);
					}
					groupMtMap.put(dateType, new Double(mt.doubleValue() + mtPerDay));
					
					// Data Usage Map
					Map<String, Object> groupDataMap = datausageMap.get(groupName);		
					if (groupDataMap == null) {
						groupDataMap = new HashMap<String, Object>(2);
						datausageMap.put(groupName, groupDataMap);
					}
					
					Double data = (Double) groupDataMap.get(dateType);
					if (data == null) {
						data = new Double(0);
						groupDataMap.put(dateType,data);
					}
					groupDataMap.put(dateType, new Double(data.doubleValue() + dataPerDay));
				}
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting network group data in microsegment : ", dae);
			throw new RADataAccessException(dae);
		}
		
		dataMap.put("earlierRoamers", (Double)dataMap.get("earlierRoamers") / startDate_daysBetween);
		dataMap.put("latestRoamers", (Double)dataMap.get("latestRoamers") / endDate_daysBetween);
		
		dataMap.put("earlierMt", (Double)dataMap.get("earlierMt") / startDate_daysBetween);
		dataMap.put("latestMt", (Double)dataMap.get("latestMt") / endDate_daysBetween);
		
		dataMap.put("earlierMo", (Double)dataMap.get("earlierMo") / startDate_daysBetween);
		dataMap.put("latestMo", (Double)dataMap.get("latestMo") / endDate_daysBetween);
		
		dataMap.put("earlierData", (Double)dataMap.get("earlierData") / startDate_daysBetween);
		dataMap.put("latestData", (Double)dataMap.get("latestData") / endDate_daysBetween);
		
		LOGGER.debug("Network Group data found :" + dataMap.size());
		LOGGER.trace("Network Group data :" + dataMap);
		
		return dataMap;
	}
	
	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.TrackerRepository#getTrackerDataForGraph(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.Long, java.lang.Long)
	 */
	@Override
	public  Map<String, Object> getTrackerDataForGraph(final Filter filter, final String attributeName,
			final String column, final String columnType, final Map<String, String> catNameValue,
			final String roamType, final Long newStartdate, final Long newEndDate)
			throws RADataAccessException {
		// TODO Auto-generated method stub
		
		final Map<String, Object> parameterMap = new HashMap<String, Object>();

		final int startDate_daysBetween = Math.abs((int) ((filter.getDateTo() -  filter.getDateFrom()) / (60*60*24))) + 1;
		final int endDate_daysBetween = Math.abs((int) ((newEndDate - newStartdate) / (60*60*24))) + 1; 
		
		final StringBuilder query = new StringBuilder();
		query.append("SELECT 'startDate' date, "+ startDate_daysBetween +" numberOfDays, ");
		TrackerQueryBuilder.populateQueryForTrackerGraph(filter, query, column, parameterMap, roamType,
				filter.getDateFrom(),filter.getDateTo());
		query.append(" union all ");
		query.append("SELECT 'endDate' date, "+ endDate_daysBetween +" numberOfDays, ");
		TrackerQueryBuilder.populateQueryForTrackerGraph(filter, query, column, parameterMap, roamType,
				newStartdate,newEndDate);
		query.append(" order by imsicount desc, mocallminutes desc, mtcallminutes desc, ")
		.append(" datausage desc ");
		
		LOGGER.debug("Getting microsegment chart data for attribute : " + attributeName);
		LOGGER.debug(attributeName + " query : " + query.toString());
		
		final Map<String,Object> dataMap = new HashMap<String, Object>();
		
		final Map<String,Map<String,Object>> roamersMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("roamers",roamersMap);
		
		final Map<String,Map<String,Object>> mtMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("mt",mtMap);
		
		final Map<String,Map<String,Object>> moMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("mo",moMap);
		
		final Map<String,Map<String,Object>> datausageMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("data",datausageMap);
		
		dataMap.put("earlierRoamers",new Double(0));
		dataMap.put("latestRoamers",new Double(0));
		
		dataMap.put("earlierMt",new Double(0));
		dataMap.put("latestMt",new Double(0));
		
		dataMap.put("earlierMo",new Double(0));
		dataMap.put("latestMo",new Double(0));
		
		dataMap.put("earlierData",new Double(0));
		dataMap.put("latestData",new Double(0));
		
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				
				String categoryValue = null;
				String dateType = null;	
				int numberOfDays = 0;
				
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {

					dateType = rs.getString("date");	
					numberOfDays = rs.getInt("numberOfDays");
					
					final double imsicount = rs.getDouble("imsicount");
					final double mocallminutes = rs.getDouble("mocallminutes");
					final double mtcallminutes = rs.getDouble("mtcallminutes");
					final double datausage = rs.getDouble("datausage");
					
					final double roamersPerDay = imsicount / numberOfDays;
					final double moPerDay = mocallminutes / numberOfDays;
					final double mtPerDay = mtcallminutes / numberOfDays;
					final double dataPerDay = datausage / numberOfDays;
					
					categoryValue = catNameValue.get(rs.getString("categoryValue"));
					if (categoryValue == null && !(RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(attributeName)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(attributeName))) {
						categoryValue = "Unknown";
					} else if (RAConstants.ATTR_DEVICE_MODEL.equalsIgnoreCase(attributeName)
							|| RAConstants.ATTR_MANUFACTURER.equalsIgnoreCase(attributeName)) {
						categoryValue = rs.getString("categoryValue");
					}
					
					categoryValue = CommonUtil.normalizeString(categoryValue);
					
					populateCategoryMap(roamersMap, roamersPerDay,categoryValue,dateType);
					populateCategoryMap(moMap, moPerDay,categoryValue,dateType);
					populateCategoryMap(mtMap, mtPerDay,categoryValue,dateType);
					populateCategoryMap(datausageMap, dataPerDay,categoryValue,dateType);
					
					if(dateType.equalsIgnoreCase("startDate")) {	
						dataMap.put("earlierRoamers",(Double)dataMap.get("earlierRoamers") + imsicount);
						dataMap.put("earlierMt",(Double)dataMap.get("earlierMt") + mtcallminutes);
						dataMap.put("earlierMo",(Double)dataMap.get("earlierMo") + mocallminutes);
						dataMap.put("earlierData",(Double)dataMap.get("earlierData") + datausage);
					} else if(dateType.equalsIgnoreCase("endDate")) {
						dataMap.put("latestRoamers",(Double)dataMap.get("latestRoamers") + imsicount);
						dataMap.put("latestMt",(Double)dataMap.get("latestMt") + mtcallminutes);
						dataMap.put("latestMo",(Double)dataMap.get("latestMo") + mocallminutes);
						dataMap.put("latestData",(Double)dataMap.get("latestData") + datausage);
					}	
					return null;
				}

				
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting "+ attributeName + " chart's data : ", dae);
			throw new RADataAccessException(dae);
		}
		dataMap.put("earlierRoamers", (Double)dataMap.get("earlierRoamers") / startDate_daysBetween);
		dataMap.put("latestRoamers", (Double)dataMap.get("latestRoamers") / endDate_daysBetween);
		
		dataMap.put("earlierMt", (Double)dataMap.get("earlierMt") / startDate_daysBetween);
		dataMap.put("latestMt", (Double)dataMap.get("latestMt") / endDate_daysBetween);
		
		dataMap.put("earlierMo", (Double)dataMap.get("earlierMo") / startDate_daysBetween);
		dataMap.put("latestMo", (Double)dataMap.get("latestMo") / endDate_daysBetween);
		
		dataMap.put("earlierData", (Double)dataMap.get("earlierData") / startDate_daysBetween);
		dataMap.put("latestData", (Double)dataMap.get("latestData") / endDate_daysBetween);
		
			
		LOGGER.debug(attributeName + " chart data found :" + dataMap.size());
		LOGGER.trace( attributeName + " chart data list: " + dataMap);
		
		return dataMap;		
	}
	
	
	
	
	/**
	 * @param roamersMap
	 * @param roamersPerDay
	 */
	private void populateCategoryMap(
			final Map<String, Map<String, Object>> measureMap,
			final double measurePerDay, final String categoryValue, final String dateType) {
		Map<String, Object> categoryMap = measureMap.get(categoryValue);
		if (categoryMap == null) {
			categoryMap = new HashMap<String, Object>();
			measureMap.put(categoryValue, categoryMap);
		}
		
		Object dateValue = categoryMap.get(dateType);
		if (dateValue == null) {
			dateValue = new Double(0);
			categoryMap.put(dateType, dateValue);
		}
		dateValue = new Double((Double)dateValue + measurePerDay);
		categoryMap.put(dateType, dateValue);
	}
	
	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.TrackRepository#getTrackerStatisticsData(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<RoamingStatistics> getTrackerStatisticsData(final Filter filter,
			final String roamType, final Long newStartDate, final Long newEndDate) {
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		final StringBuilder query = new StringBuilder();
		TrackerQueryBuilder.populateQueryForTrackerStatistics(filter,query,parameterMap, roamType,newStartDate,newEndDate);
		LOGGER.debug(query.toString());
		final int startDate_daysBetween = Math.abs((int) ((filter.getDateTo() -  filter.getDateFrom()) / (60*60*24))) + 1;
		final int endDate_daysBetween = Math.abs((int) ((newEndDate - newStartDate) / (60*60*24))) + 1; 
		
		return prestoJdbcTempate.query(query.toString(), new RowMapper<RoamingStatistics>() {

			@Override
			public RoamingStatistics mapRow(final ResultSet rs, final int rowNum) throws SQLException {
				
				int noOfDays=1;
				if(rs.getString("dateidentifier").equals("oldrange"))
					noOfDays=startDate_daysBetween;
				else
					noOfDays=endDate_daysBetween;
				
				final RoamingStatistics roamingStatistics = new RoamingStatistics();
				roamingStatistics.setCountryCode(rs.getString("dateidentifier"));
				roamingStatistics.setRoamerTotal(Math.round(rs.getLong("roamercount")/noOfDays));
				roamingStatistics.setMoTotal(Math.round(rs.getLong("mocallminutes")/noOfDays));
				roamingStatistics.setMoLocal(Math.round(rs.getLong("mocallminuteslocal")/noOfDays));
				roamingStatistics.setMoHome(Math.round(rs.getLong("mocallminuteshome")/noOfDays));
				roamingStatistics.setMoIntl(Math.round(rs.getLong("mocallminutesother")/noOfDays));
				roamingStatistics.setDataUsage(Math.round(rs.getLong("datausage")/noOfDays));
				roamingStatistics.setMt(Math.round(rs.getLong("mtcallminutes")/noOfDays));
				roamingStatistics.setSmsUsage(Math.round(rs.getLong("mosmscount")/noOfDays));
				roamingStatistics.setOverAllTripCategory(rs.getInt("roamingcategory"));
				if(rs.getInt("roamingcategory")==1)
				{
					roamingStatistics.setRoamerSilent(rs.getLong("roamercount")/noOfDays);
					roamingStatistics.setOverAllTripCategory(rs.getInt("roamingcategory")*1);					
					
				}else if(rs.getInt("roamingcategory")==2)
				{
					roamingStatistics.setRoamerValue(rs.getLong("roamercount")/noOfDays);
					roamingStatistics.setOverAllTripCategory(rs.getInt("roamingcategory")*10);
					
				}else if(rs.getInt("roamingcategory")==3)
				{
					roamingStatistics.setRoamerPremium(rs.getLong("roamercount")/noOfDays);
					roamingStatistics.setOverAllTripCategory(rs.getInt("roamingcategory")*100);
				}
				
				return roamingStatistics;
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.TrackRepository#getTrackerStatisticsData(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.Long, java.lang.Long)
	 */
	@Override
	public List<RoamingStatistics> getTrackerListStatisticsData(final Filter filter,
			final String roamType, final Long newStartDate, final Long newEndDate) {
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		final StringBuilder query = new StringBuilder();
		TrackerQueryBuilder.populateQueryForTrackerListStatistics(filter,query,parameterMap, roamType,newStartDate,newEndDate);
		LOGGER.debug("Tracker List query : " + query);
		
		final int startDate_daysBetween = Math.abs((int) ((filter.getDateTo() -  filter.getDateFrom()) / (60*60*24))) + 1;
		final int endDate_daysBetween = Math.abs((int) ((newEndDate - newStartDate) / (60*60*24))) + 1; 
		return prestoJdbcTempate.query(query.toString(), new RowMapper<RoamingStatistics>() {

			@Override
			public RoamingStatistics mapRow(final ResultSet rs, final int rowNum) throws SQLException {
				int noOfDays=1;
				if(rs.getString("dateidentifier").equals("oldrange"))
					noOfDays=startDate_daysBetween;
				else
					noOfDays=endDate_daysBetween;
				
				final RoamingStatistics roamingStatistics = new RoamingStatistics();
				roamingStatistics.setCountryCode(rs.getString("dateidentifier"));
				roamingStatistics.setRoamerTotal(Math.round(rs.getLong("roamercount")/noOfDays));
				roamingStatistics.setMoTotal(Math.round(rs.getLong("mocallminutes")/noOfDays));
				roamingStatistics.setMoLocal(Math.round(rs.getLong("mocallminuteslocal")/noOfDays));
				roamingStatistics.setMoHome(Math.round(rs.getLong("mocallminuteshome")/noOfDays));
				roamingStatistics.setMoIntl(Math.round(rs.getLong("mocallminutesother")/noOfDays));
				roamingStatistics.setDataUsage(Math.round(rs.getLong("datausage")/noOfDays));
				roamingStatistics.setMt(Math.round(rs.getLong("mtcallminutes")/noOfDays));
				roamingStatistics.setSmsUsage(Math.round(rs.getLong("mosmscount")/noOfDays));
				return roamingStatistics;
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.repository.TrackerRepository#getTrackerDataForOtherCountriesTraveled(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.Long, java.lang.Long)
	 */
	@Override
	public Map<String, Object> getTrackerDataForOtherCountriesTraveled(
			final Filter filter, final String attributeName, final String column,
			final String columnType,final String roamType, final Long newStartdate, final Long newEndDate)
			throws RADataAccessException {
		
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		final int startDate_daysBetween = Math.abs((int) ((filter.getDateTo() -  filter.getDateFrom()) / (60*60*24))) + 1;
		final int endDate_daysBetween = Math.abs((int) ((newEndDate - newStartdate) / (60*60*24))) + 1; 
		
		final StringBuilder query = new StringBuilder();
		query.append("SELECT 'startDate' date, "+ startDate_daysBetween +" numberOfDays, ");
		TrackerQueryBuilder.populateQueryForOtherCountriesTraveledGraph(filter, query, column, parameterMap, roamType,
				filter.getDateFrom(),filter.getDateTo());
		query.append(" union all ");
		query.append("SELECT 'endDate' date, "+ endDate_daysBetween +" numberOfDays, ");
		TrackerQueryBuilder.populateQueryForOtherCountriesTraveledGraph(filter, query, column, parameterMap, roamType,
				newStartdate,newEndDate);
		query.append(" order by imsicount desc, mocallminutes desc, mtcallminutes desc, ")
		.append(" datausage desc ");
		
		LOGGER.debug("Getting tracker chart data for attribute : " + attributeName);
		LOGGER.debug(attributeName + " query : " + query.toString());
		
		final Map<String,Object> dataMap = new HashMap<String, Object>();
		
		final Map<String,Map<String,Object>> roamersMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("roamers",roamersMap);
		
		final Map<String,Map<String,Object>> mtMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("mt",mtMap);
		
		final Map<String,Map<String,Object>> moMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("mo",moMap);
		
		final Map<String,Map<String,Object>> datausageMap = new HashMap<String, Map<String,Object>>();
		dataMap.put("data",datausageMap);
		
		dataMap.put("earlierRoamers",new Double(0));
		dataMap.put("latestRoamers",new Double(0));
		
		dataMap.put("earlierMt",new Double(0));
		dataMap.put("latestMt",new Double(0));
		
		dataMap.put("earlierMo",new Double(0));
		dataMap.put("latestMo",new Double(0));
		
		dataMap.put("earlierData",new Double(0));
		dataMap.put("latestData",new Double(0));
		
		try {
			this.prestoJdbcTempate.query(query.toString(), new RowMapper<Object>() {
				
				String dateType = null;	
				int numberOfDays = 0;
				
				@Override
				public Object mapRow(final ResultSet rs, final int rowNum)
						throws SQLException {

					dateType = rs.getString("date");	
					numberOfDays = rs.getInt("numberOfDays");
					
					final int bordering = rs.getInt("bordering");
					final int leisure = rs.getInt("leisure");
					final int leisurePremium = rs.getInt("leisurePremium");
					final int lowGDP = rs.getInt("lowGDP");
					
					final double imsicount = rs.getDouble("imsicount");
					final double mocallminutes = rs.getDouble("mocallminutes");
					final double mtcallminutes = rs.getDouble("mtcallminutes");
					final double datausage = rs.getDouble("datausage");
					
					final double roamersPerDay = imsicount / numberOfDays;
					final double moPerDay = mocallminutes / numberOfDays;
					final double mtPerDay = mtcallminutes / numberOfDays;
					final double dataPerDay = datausage / numberOfDays;
					
					if (bordering > 0) {
						populateCategoryMap(roamersMap, roamersPerDay,RAConstants.NEIGHBOURS,dateType);
						populateCategoryMap(moMap, moPerDay,RAConstants.NEIGHBOURS,dateType);
						populateCategoryMap(mtMap, mtPerDay,RAConstants.NEIGHBOURS,dateType);
						populateCategoryMap(datausageMap, dataPerDay,RAConstants.NEIGHBOURS,dateType);
					}
					if (leisure > 0) {
						populateCategoryMap(roamersMap, roamersPerDay,RAConstants.LEISURE,dateType);
						populateCategoryMap(moMap, moPerDay,RAConstants.LEISURE,dateType);
						populateCategoryMap(mtMap, mtPerDay,RAConstants.LEISURE,dateType);
						populateCategoryMap(datausageMap, dataPerDay,RAConstants.LEISURE,dateType);
					}
					
					if (leisurePremium > 0) {
						populateCategoryMap(roamersMap, roamersPerDay,RAConstants.LEISURE_PREMIUM,dateType);
						populateCategoryMap(moMap, moPerDay,RAConstants.LEISURE_PREMIUM,dateType);
						populateCategoryMap(mtMap, mtPerDay,RAConstants.LEISURE_PREMIUM,dateType);
						populateCategoryMap(datausageMap, dataPerDay,RAConstants.LEISURE_PREMIUM,dateType);
					}
					
					if (lowGDP > 0) {
						populateCategoryMap(roamersMap, roamersPerDay,RAConstants.LOW_GDP,dateType);
						populateCategoryMap(moMap, moPerDay,RAConstants.LOW_GDP,dateType);
						populateCategoryMap(mtMap, mtPerDay,RAConstants.LOW_GDP,dateType);
						populateCategoryMap(datausageMap, dataPerDay,RAConstants.LOW_GDP,dateType);
					}
					
					if(dateType.equalsIgnoreCase("startDate")) {	
						dataMap.put("earlierRoamers",(Double)dataMap.get("earlierRoamers") + imsicount);
						dataMap.put("earlierMt",(Double)dataMap.get("earlierMt") + mtcallminutes);
						dataMap.put("earlierMo",(Double)dataMap.get("earlierMo") + mocallminutes);
						dataMap.put("earlierData",(Double)dataMap.get("earlierData") + datausage);
					} else if(dateType.equalsIgnoreCase("endDate")) {
						dataMap.put("latestRoamers",(Double)dataMap.get("latestRoamers") + imsicount);
						dataMap.put("latestMt",(Double)dataMap.get("latestMt") + mtcallminutes);
						dataMap.put("latestMo",(Double)dataMap.get("latestMo") + mocallminutes);
						dataMap.put("latestData",(Double)dataMap.get("latestData") + datausage);
					}	
					return null;
				}

				
			});
		} catch (final DataAccessException dae) {
			LOGGER.error("Exception While getting "+ attributeName + " chart's data : ", dae);
			throw new RADataAccessException(dae);
		}
		
		dataMap.put("earlierRoamers", (Double)dataMap.get("earlierRoamers") / startDate_daysBetween);
		dataMap.put("latestRoamers", (Double)dataMap.get("latestRoamers") / endDate_daysBetween);
		
		dataMap.put("earlierMt", (Double)dataMap.get("earlierMt") / startDate_daysBetween);
		dataMap.put("latestMt", (Double)dataMap.get("latestMt") / endDate_daysBetween);
		
		dataMap.put("earlierMo", (Double)dataMap.get("earlierMo") / startDate_daysBetween);
		dataMap.put("latestMo", (Double)dataMap.get("latestMo") / endDate_daysBetween);
		
		dataMap.put("earlierData", (Double)dataMap.get("earlierData") / startDate_daysBetween);
		dataMap.put("latestData", (Double)dataMap.get("latestData") / endDate_daysBetween);
			
		LOGGER.debug(attributeName + " chart data found :" + dataMap.size());
		LOGGER.trace( attributeName + " chart data list: " + dataMap);
		
		return dataMap;		
	}

	
}
