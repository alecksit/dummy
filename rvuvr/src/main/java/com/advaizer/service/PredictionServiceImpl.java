/**
 * 
 */
package com.advaizer.service;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advaizer.common.RAPropertyUtil;
import com.advaizer.model.Filter;
import com.advaizer.model.TravelPrediction;
import com.advaizer.repository.PredictionRepository;

/**
 * @author smruti
 *
 */
@Service
public class PredictionServiceImpl  implements PredictionService{
	
	@Autowired
	private PredictionRepository predictionDao;
		
	private static Logger LOGGER = LogManager.getLogger(TrackerServiceImpl.class.getName());
	
	
	@Override
	public TravelPrediction getBeforeTravelStatistics(final Filter filter,final String roamType){
		
		final Map<String,String> filterParameters = filter.getSelectedAttributes();
		for (final String columnName : filterParameters.keySet()) {
			if(columnName.toLowerCase().indexOf(RAPropertyUtil.getProperty("out.travelprediction.na").toLowerCase())!=-1){
				filterParameters.put(columnName,"");
			}
		}
		
		final List<TravelPrediction> travelPredictionList=predictionDao.getBeforeTravelStatisticsData(filter,roamType);
		
		final TravelPrediction travelPrediction=new TravelPrediction();
	
		
		for(final TravelPrediction travelPredictionEntity : travelPredictionList ){
			
			travelPrediction.setConfidenceHigh(travelPrediction.getConfidenceHigh()+travelPredictionEntity.getConfidenceHigh());
			travelPrediction.setConfidenceMedium(travelPrediction.getConfidenceMedium()+travelPredictionEntity.getConfidenceMedium());
			travelPrediction.setConfidenceLow(travelPrediction.getConfidenceLow()+travelPredictionEntity.getConfidenceLow());
			travelPrediction.setSubscriberCount(travelPrediction.getConfidenceLow()+travelPrediction.getConfidenceMedium()+travelPrediction.getConfidenceHigh());
		}
		
		
		 return travelPrediction;
			
	
	}
	
	@Override
	public List<TravelPrediction> getUponLandingStatistics(final Filter filter,final String roamType){
		 return predictionDao.getUponLandingStatisticsData(filter,roamType);
	}

	@Override
	public Map<String, Object> getTagSubscriberData(final Filter filter,
			final long campaignStartTime, final long campaignEndTime,
			final long monitoringStartTime, final long monitoringEndTime,final long tagId, final String roamType,final String tagType) {
		
		return this.predictionDao.getTagSubscriberData(filter, tagId, campaignStartTime, campaignEndTime,
				monitoringStartTime, monitoringEndTime, roamType,tagType);
	}


}
