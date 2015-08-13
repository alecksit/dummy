/**
 * 
 */
package com.advaizer.model;

/**
 * @author ANKIT
 *
 */
public class Category {
	String categoryName;
	int parentCategoryId;
	int categoryId;
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(final String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the parentCategoryId
	 */
	public int getParentCategoryId() {
		return parentCategoryId;
	}
	/**
	 * @param parentCategoryId the parentCategoryId to set
	 */
	public void setParentCategoryId(final int parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(final int categoryId) {
		this.categoryId = categoryId;
	}
	

}
