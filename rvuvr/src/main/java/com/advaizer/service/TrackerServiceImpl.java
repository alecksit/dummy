/**
 * 
 */
package com.advaizer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advaizer.common.RAConstants;
import com.advaizer.exception.ApplicationException;
import com.advaizer.exception.RADataAccessException;
import com.advaizer.model.Filter;
import com.advaizer.model.RoamingStatistics;
import com.advaizer.repository.TrackerRepository;

/**
 * @author cheshta
 *
 */
@Service
public class TrackerServiceImpl implements TrackerService{

	@Autowired
	private TrackerRepository trackerDao;
		
	private static Logger LOGGER = LogManager.getLogger(TrackerServiceImpl.class.getName());
	
	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.service.TrackService#saveTrack()
	 */
	@Override
	public Map<String,String> saveTrackerDetails(final Filter filter,final String trackName, final String roamType,
			final String startDateRange, final String endDateRange, final String filterLabels, 
			final String filterJson, final boolean isCustomTracker, final String quarterlyOption) {
		// TODO Auto-generated method stub
		try {
			if(!trackerDao.isExistingTracker(trackName, roamType)){
				return trackerDao.saveTrackerDetails(filter, trackName, roamType, startDateRange,
						endDateRange, filterLabels, filterJson, isCustomTracker, quarterlyOption);
			}
			else{
				final Map<String,String> error = new HashMap<String, String>();
				error.put("error", "This tracker is already existing. Please enter a different name.");
				return error;
			}
		} catch (final RADataAccessException dae) {
			LOGGER.debug("Save Tracker Error: " + dae.getMessage() + " for tracker name: " + trackName);
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.service.TrackService#getTrackers(java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getAllTrackers(final String roamType,final String trackerName) {
		// TODO Auto-generated method stub
		try {			
				return trackerDao.getAllTrackers(roamType,trackerName);
						
		} catch (final RADataAccessException dae) {
			LOGGER.debug("Something went wrong while fetching trackers: " + dae.getMessage());
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.service.TrackService#deleteTracker(java.lang.String, java.lang.String)
	 */
	@Override
	public String deleteTracker(final long trackerId, final String roamType) {
		// TODO Auto-generated method stub
		try {			
			return trackerDao.deleteTracker(trackerId, roamType);
					
		} catch (final RADataAccessException dae) {
			LOGGER.debug("Something went wrong while deleting tracker id: " + trackerId + 
					" , Error: "+ dae.getMessage());
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.service.TrackService#getTrackerData(com.mobileum.roameranalytics.model.Filter, java.lang.String)
	 */
	@Override
	public Map<String, Object> getTrackerDataForNetwork(final Filter startFilter, final String column,
			final String columnType, final Map<String, String> catNameValue, final String roamType,
			final Long newStartdate, final Long newEndDate){
		try {
			return trackerDao.getTrackerDataForNetwork(startFilter, column, columnType, 
					catNameValue, roamType, newStartdate, newEndDate);

		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}			
	}
	
	@Override
	public Map<String, Object> getTrackerDataForNetworkGroup(final Filter filter, final String column,
			final String columnType, final Map<String, String> catNameValue, final String roamType,
			final Long newStartdate, final Long newEndDate){
		// TODO Auto-generated method stub
		try {
			return trackerDao.getTrackerDataForNetworkGroup(filter, column, columnType, catNameValue,roamType,newStartdate,newEndDate);
		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}			
	}
	
	@Override
	public List<RoamingStatistics> getTrackerStatistics(final Filter filter,final String roamType,final Long newStartDate,final Long newEndDate){
		
		 final List<RoamingStatistics> roamingStatisticsList = trackerDao.getTrackerStatisticsData(filter,roamType,newStartDate,newEndDate);
		 
		 final RoamingStatistics roamStatsNew=new RoamingStatistics();
		 final RoamingStatistics roamStatsOld=new RoamingStatistics();
		 roamStatsNew.setCountryCode("newrange");
		 roamStatsOld.setCountryCode("oldrange");
			
			
			for (final RoamingStatistics roamingStatistics : roamingStatisticsList) {
							 
					if(roamingStatistics.getCountryCode().equals(roamStatsOld.getCountryCode())){
						
						roamStatsOld.setDataUsage(roamStatsOld.getDataUsage()+roamingStatistics.getDataUsage());
						roamStatsOld.setMoHome(roamStatsOld.getMoHome()+roamingStatistics.getMoHome());
						roamStatsOld.setMoIntl(roamStatsOld.getMoIntl()+roamingStatistics.getMoIntl());
						roamStatsOld.setMoLocal(roamStatsOld.getMoLocal()+roamingStatistics.getMoLocal());
						roamStatsOld.setMoTotal(roamStatsOld.getMoTotal()+roamingStatistics.getMoTotal());
						roamStatsOld.setMt(roamStatsOld.getMt()+roamingStatistics.getMt());
						roamStatsOld.setOverAllTripCategory(roamStatsOld.getOverAllTripCategory()+roamingStatistics.getOverAllTripCategory());
						roamStatsOld.setRoamerPremium(roamStatsOld.getRoamerPremium()+roamingStatistics.getRoamerPremium());
						roamStatsOld.setRoamerSilent(roamStatsOld.getRoamerSilent()+roamingStatistics.getRoamerSilent());
						roamStatsOld.setRoamerTotal(roamStatsOld.getRoamerTotal()+roamingStatistics.getRoamerTotal());
						roamStatsOld.setRoamerValue(roamStatsOld.getRoamerValue()+roamingStatistics.getRoamerValue());
						roamStatsOld.setSmsUsage(roamStatsOld.getSmsUsage()+roamingStatistics.getSmsUsage());
					}
					
					if(roamingStatistics.getCountryCode().equals(roamStatsNew.getCountryCode())){
						roamStatsNew.setDataUsage(roamStatsNew.getDataUsage()+roamingStatistics.getDataUsage());
						roamStatsNew.setMoHome(roamStatsNew.getMoHome()+roamingStatistics.getMoHome());
						roamStatsNew.setMoIntl(roamStatsNew.getMoIntl()+roamingStatistics.getMoIntl());
						roamStatsNew.setMoLocal(roamStatsNew.getMoLocal()+roamingStatistics.getMoLocal());
						roamStatsNew.setMoTotal(roamStatsNew.getMoTotal()+roamingStatistics.getMoTotal());
						roamStatsNew.setMt(roamStatsNew.getMt()+roamingStatistics.getMt());
						roamStatsNew.setOverAllTripCategory(roamStatsNew.getOverAllTripCategory()+roamingStatistics.getOverAllTripCategory());
						roamStatsNew.setRoamerPremium(roamStatsNew.getRoamerPremium()+roamingStatistics.getRoamerPremium());
						roamStatsNew.setRoamerSilent(roamStatsNew.getRoamerSilent()+roamingStatistics.getRoamerSilent());
						roamStatsNew.setRoamerTotal(roamStatsNew.getRoamerTotal()+roamingStatistics.getRoamerTotal());
						roamStatsNew.setRoamerValue(roamStatsNew.getRoamerValue()+roamingStatistics.getRoamerValue());
						roamStatsNew.setSmsUsage(roamStatsNew.getSmsUsage()+roamingStatistics.getSmsUsage());

					}

				}

			final List<RoamingStatistics> finalRoamingStatisticsList =new ArrayList<RoamingStatistics>(2);
			finalRoamingStatisticsList.add(0,roamStatsNew);
			finalRoamingStatisticsList.add(1,roamStatsOld);
			
			
					return finalRoamingStatisticsList;
		
		
	
	}


	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.service.TrackerService#getTrackerDataForGraph(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.Long, java.lang.Long)
	 */
	@Override
	public Map<String, Object> getTrackerDataForGraph(final Filter filter, final String attributeName,
			final String column, final String columnType, final Map<String, String> catNameValue,
			final String roamType, final Long newStartdate, final Long newEndDate) {
		// TODO Auto-generated method stub
		
		try {
			return trackerDao.getTrackerDataForGraph(filter, attributeName, column, columnType, 
					catNameValue, roamType, newStartdate, newEndDate);

		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}	
	}


	@Override
	public List<RoamingStatistics> getTrackerListStatistics(final Filter filter,final String roamType,final Long newStartDate,final Long newEndDate){
		
		 return trackerDao.getTrackerListStatisticsData(filter,roamType,newStartDate,newEndDate);
			
	
	}

	/* (non-Javadoc)
	 * @see com.mobileum.roameranalytics.service.TrackerService#getTrackerDataForOtherCountriesTraveled(com.mobileum.roameranalytics.model.Filter, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.Long, java.lang.Long)
	 */
	@Override
	public Map<String, Object> getTrackerDataForOtherCountriesTraveled(
			final Filter filter, final String attributeName, final String column,
			final String columnType, final String roamType, final Long newStartdate, final Long newEndDate) {

		try {
			return trackerDao.getTrackerDataForOtherCountriesTraveled(filter, attributeName, column, columnType, 
					roamType, newStartdate, newEndDate);

		} catch (final RADataAccessException dae) {
			throw new ApplicationException(RAConstants.APPLICATION_EXCEPTION_STRING, dae);
		}	
	}
	
}
