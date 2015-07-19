/**
 * 
 */
package com.advaizer.model.chart;

/**
 * @author sarvesh
 *
 */
public class MSChartMetadata {
	private String title;
	private String column;
	private String columnType;
	private byte chartType;
	private int attributeId;
	private String measure;
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(final String title) {
		this.title = title;
	}
	/**
	 * @return the column
	 */
	public String getColumn() {
		return column;
	}
	/**
	 * @param column the column to set
	 */
	public void setColumn(final String column) {
		this.column = column;
	}
	/**
	 * @return the columnType
	 */
	public String getColumnType() {
		return columnType;
	}
	/**
	 * @param columnType the columnType to set
	 */
	public void setColumnType(final String columnType) {
		this.columnType = columnType;
	}
	/**
	 * @return the chartType
	 */
	public byte getChartType() {
		return chartType;
	}
	/**
	 * @param chartType the chartType to set
	 */
	public void setChartType(final byte chartType) {
		this.chartType = chartType;
	}
	/**
	 * @return the attributeId
	 */
	public int getAttributeId() {
		return attributeId;
	}
	/**
	 * @param attributeId the attributeId to set
	 */
	public void setAttributeId(final int attributeId) {
		this.attributeId = attributeId;
	}
	/**
	 * @return the measure
	 */
	public String getMeasure() {
		return measure;
	}
	/**
	 * @param measure the measure to set
	 */
	public void setMeasure(final String measure) {
		this.measure = measure;
	}
}
