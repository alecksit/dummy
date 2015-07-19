/**
 * 
 */
package com.advaizer.enums;

/**
 * @author sarvesh
 *
 */
public enum ThresholdColumn {

	COUNTRY_ID("country_id"),
	THRESHOLD_ID("threshold_id"),
	MO_CALL_DURATION("mo_call_duration"),
	MT_CALL_DURATION("mt_call_duration"),
	MO_SMS_COUNT("mo_sms_count"),
	TONNAGE("tonnage"),
	TIMESTAMP("timestamp");
	
	private String name;
	private ThresholdColumn(final String name) {
		this.name = name;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
