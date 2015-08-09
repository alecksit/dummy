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
	int categoryId;
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
		
}
