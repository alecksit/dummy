/**
 * 
 */
package com.advaizer.model;

import java.util.List;

/**
 * The Class Attribute.
 *
 * @author sarvesh
 */
public class Attribute {

	/** The id. */
	private long id;
	
	/** The attribute name. */
	private String attributeName;
	
	/** The module id. */
	private int moduleId;
	
	/** The display order. */
	private int displayOrder;

	/** The db column. */
	private String dbColumn;
	
	/** The column type. */
	private String columnType;
	
	/** The chart type. */
	private byte chartType;
	
	/** The attribute category list. */
	private List<AttributeCategory> attributeCategoryList;
	
	private String measure;
	
	private boolean overlay;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final long id) {
		this.id = id;
	}

	/**
	 * @return the attributeName
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * @param attributeName the attributeName to set
	 */
	public void setAttributeName(final String attributeName) {
		this.attributeName = attributeName;
	}

	/**
	 * @return the moduleId
	 */
	public int getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(final int moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @return the displayOrder
	 */
	public int getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * Sets the display order.
	 *
	 * @param displayOrder the displayOrder to set
	 */
	public void setDisplayOrder(final int displayOrder) {
		this.displayOrder = displayOrder;
	}

	/**
	 * @return the attributeCategoryList
	 */
	public List<AttributeCategory> getAttributeCategoryList() {
		return attributeCategoryList;
	}

	/**
	 * @param attributeCategoryList the attributeCategoryList to set
	 */
	public void setAttributeCategoryList(
			final List<AttributeCategory> attributeCategoryList) {
		this.attributeCategoryList = attributeCategoryList;
	}

	/**
	 * @return the dbColumn
	 */
	public String getDbColumn() {
		return dbColumn;
	}

	/**
	 * @param dbColumn the dbColumn to set
	 */
	public void setDbColumn(final String dbColumn) {
		this.dbColumn = dbColumn;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Attribute [id=" + id + ", attributeName=" + attributeName
				+ ", moduleId=" + moduleId + ", displayOrder=" + displayOrder
				+ ", dbColumn=" + dbColumn + ", columnType=" + columnType + "]";
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

	/**
	 * @return the overlay
	 */
	public boolean isOverlay() {
		return overlay;
	}

	/**
	 * @param overlay the overlay to set
	 */
	public void setOverlay(final boolean overlay) {
		this.overlay = overlay;
	}
}
