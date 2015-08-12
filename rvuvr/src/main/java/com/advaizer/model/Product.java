/**
 * 
 */
package com.advaizer.model;

/**
 * @author ANKIT
 *
 */
public class Product {
	int productId;
	String productName;
	int brandId;
	String brandName;
	int categoryId;
	String categoryName;
	int companyId;
	String companyName;
	
	/**
	 * @return the productid
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productid the productid to set
	 */
	public void setProductId(final int productId) {
		this.productId = productId;
	}
	/**
	 * @return the productname
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productname the productname to set
	 */
	public void setProductName(final String productName) {
		this.productName = productName;
	}
	/**
	 * @return the brandid
	 */
	public int getBrandId() {
		return brandId;
	}
	/**
	 * @param brandid the brandid to set
	 */
	public void setBrandId(final int brandId) {
		this.brandId = brandId;
	}
	/**
	 * @return the categoryid
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryid the categoryid to set
	 */
	public void setCategoryId(final int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the companyId
	 */
	public int getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(final int companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the brandName
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(final String brandName) {
		this.brandName = brandName;
	}
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
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}
		
}
