/**
 * 
 */
package com.advaizer.query;
import com.advaizer.enums.LocationColumns;
import com.advaizer.enums.Relation;
/**
 * @author smruti
 *
 */
public class BasicFilterQueryBuilder {
	public static StringBuilder getAllStateQuery(final StringBuilder whereClause){
		
		final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(LocationColumns.STATEID).append(" stateid,")
		.append(LocationColumns.STATENAME).append(" statename from ").append(Relation.STATE).append("  ").append(whereClause);
		
		return query;		
	}

	/**
	 * @param stringBuilder
	 * @return
	 */
	public static StringBuilder getStateAreaQuery(final StringBuilder whereClause) {
final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(LocationColumns.AREAID).append(" areaid,")
		.append(LocationColumns.AREANAME).append(" areaname from ").append(Relation.AREA).append(" where ").append(whereClause);
		
		return query;
	}
	public static StringBuilder getStateZoneQuery(final StringBuilder whereClause) {
		final StringBuilder query=new StringBuilder("");
				
				query.append("Select ").append(LocationColumns.STATEID).append(" stateid,")
				.append(LocationColumns.STATENAME).append(" statename from ").append(Relation.STATE).append(" where ").append(whereClause);
				
				return query;
			}
	public static StringBuilder getMajorZoneAreaQuery(final int zoneId) {
		final StringBuilder query=new StringBuilder("");
				
				query.append("Select ").append(Relation.AREA).append(".").append(LocationColumns.AREANAME).append(" areaname,").append(Relation.AREA).append(".").append(LocationColumns.AREAID)
				.append(" areaid").append(" from ").append(Relation.AREA).append(" inner join ")
				.append(Relation.STATE).append(" on ").append( Relation.STATE).append(".")
				.append(LocationColumns.STATEID).append("=").append(Relation.AREA).append(".")
				.append(LocationColumns.STATEID).append(" and ").append(Relation.STATE).append(".")
				.append(LocationColumns.STATEZONE).append("=").append(zoneId);
				return query;
	}
	
	/**
	 * @param locationId
	 * @return
	 */
	public static StringBuilder getCompaniesPerLocationQuery(final int locationId) {
		final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(LocationColumns.COMPANYID).append(" companyid,")
		.append(LocationColumns.COMPANYNAME).append(" companyname from ").append(Relation.COMPANY).append(" where ").append(LocationColumns.COMPANYLOCATION).append(" = ").append(locationId);
		
		return query;
			}

	/**
	 * @param companyId
	 * @return
	 */
	public static Object getBrandsPerCompanyQuery(final int companyId) {
		// TODO Auto-generated method stub
final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(LocationColumns.BRANDID).append(" brandid,")
		.append(LocationColumns.BRANDNAME).append(" brandname from ").append(Relation.BRAND).append(" where ").append(LocationColumns.COMPANYID).append(" = ").append(companyId);
		
		return query;
	}

	/**
	 * @param locationId
	 * @return
	 */
	public static Object getBrandsPerLocationQuery(final int locationId) {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(Relation.BRAND).append(".").append(LocationColumns.BRANDID).append(" brandid,").append(Relation.BRAND).append(".").append(LocationColumns.BRANDNAME)
		.append(" brandname").append(" from ").append(Relation.BRAND).append(" inner join ")
		.append(Relation.COMPANY).append(" on ").append( Relation.BRAND).append(".")
		.append(LocationColumns.COMPANYID).append("=").append(Relation.COMPANY).append(".")
		.append(LocationColumns.COMPANYID).append(" and ").append(Relation.COMPANY).append(".")
		.append(LocationColumns.COMPANYLOCATION).append("=").append(locationId);
		return query;
	}

	/**
	 * @param locationId
	 * @return
	 */
	public static Object getProductsPerLocationQuery(final int locationId) {
		// TODO Auto-generated method stub
final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(Relation.PRODUCT).append(".").append(LocationColumns.PRODUCTID).append(" productid,").append(Relation.PRODUCT).append(".").append(LocationColumns.PRODUCTNAME)
		.append(" productname").append(" from ").append(Relation.PRODUCT).append(" inner join ")
		.append(Relation.BRAND).append(" on ").append( Relation.BRAND).append(".")
		.append(LocationColumns.BRANDID).append("=").append(Relation.PRODUCT).append(".")
		.append(LocationColumns.BRANDID).append(" inner join ").append(Relation.COMPANY).append(" on ")
		.append(Relation.COMPANY).append(".").append(LocationColumns.COMPANYID).append("=").append( Relation.BRAND)
		.append(".").append(LocationColumns.COMPANYID)		
		.append(" and ").append(Relation.COMPANY).append(".")
		.append(LocationColumns.COMPANYLOCATION).append("=").append(locationId);
		return query;
	}

	/**
	 * @param stateId
	 * @return
	 */
	public static Object getCompanyPerStateQuery(final int stateId) {
		// TODO Auto-generated method stub
final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(Relation.COMPANY).append(".").append(LocationColumns.COMPANYID).append(" companyid,").append(Relation.COMPANY).append(".").append(LocationColumns.COMPANYNAME)
		.append(" companyname").append(" from ").append(Relation.COMPANY).append(" inner join ")
		.append(Relation.LOCATION).append(" on ").append( Relation.LOCATION).append(".")
		.append(LocationColumns.LOCATIONID).append("=").append(Relation.COMPANY).append(".")
		.append(LocationColumns.COMPANYLOCATION).append(" inner join ").append(Relation.AREA).append(" on ")
		.append(Relation.AREA).append(".").append(LocationColumns.AREAID).append("=").append( Relation.LOCATION)
		.append(".").append(LocationColumns.AREAID).append(" inner join ").append(Relation.STATE).append(" on ")
		.append(Relation.STATE).append(".").append(LocationColumns.STATEID).append("=").append(Relation.AREA).append(".").append(LocationColumns.STATEID)		
		.append(" and ").append(Relation.STATE).append(".")
		.append(LocationColumns.STATEID).append("=").append(stateId);
		return query;
	}

	/**
	 * @param companyId
	 * @return
	 */
	public static Object getProductPerCompanyQuery(final int companyId) {
		// TODO Auto-generated method stub
final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(Relation.PRODUCT).append(".").append(LocationColumns.PRODUCTID).append(" productid,").append(Relation.PRODUCT).append(".").append(LocationColumns.PRODUCTNAME)
		.append(" productname").append(" from ").append(Relation.PRODUCT).append(" inner join ")
		.append(Relation.BRAND).append(" on ").append( Relation.BRAND).append(".")
		.append(LocationColumns.BRANDID).append("=").append(Relation.PRODUCT).append(".")
		.append(LocationColumns.BRANDID).append(" inner join ").append(Relation.COMPANY).append(" on ")
		.append(Relation.COMPANY).append(".").append(LocationColumns.COMPANYID).append("=").append( Relation.BRAND)
		.append(".").append(LocationColumns.COMPANYID)		
		.append(" and ").append(Relation.COMPANY).append(".")
		.append(LocationColumns.COMPANYID).append("=").append(companyId);
		return query;
	}

	/**
	 * @param locationId
	 * @return
	 */
	public static Object getProductRatingPerLocationQuery(final int locationId) {
		// TODO Auto-generated method stub
final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(Relation.PRODUCTRATINGS).append(".").append(LocationColumns.PRODUCTID).append(" productid,").append(Relation.PRODUCTRATINGS).append(".").append(LocationColumns.RATINGPOINT)
		.append(" ratingpoint").append(" from ").append(Relation.PRODUCTRATINGS).append(" inner join ")
		.append(Relation.PRODUCT).append(" on ").append( Relation.PRODUCT).append(".")
		.append(LocationColumns.PRODUCTID).append("=").append(Relation.PRODUCTRATINGS).append(".")
		.append(LocationColumns.PRODUCTID).append(" inner join ").append(Relation.BRAND).append(" on ")
		.append(Relation.BRAND).append(".").append(LocationColumns.BRANDID).append("=").append( Relation.PRODUCT)
		.append(".").append(LocationColumns.BRANDID).append(" inner join ").append(Relation.COMPANY).append(" on ")
		.append(Relation.COMPANY).append(".").append(LocationColumns.COMPANYID).append("=").append( Relation.BRAND).append(".").append(LocationColumns.COMPANYID)
		.append(" inner join ").append(Relation.LOCATION).append(" on ").append(Relation.LOCATION).append(".").append(LocationColumns.LOCATIONID).append("=")
		.append(Relation.COMPANY).append(".").append(LocationColumns.COMPANYLOCATION)
		.append(" and ").append(Relation.LOCATION).append(".")
		.append(LocationColumns.LOCATIONID).append("=").append(locationId);
		return query;
	}
	

	public static Object addBrandDetailsQuery( )  {	
	
		final StringBuilder query=new StringBuilder("");
		query.append(" insert into ");
	 
		query.append(Relation.BRAND);
	 
		
		query.append(" (brandname,brandtype,companyid )")
		.append(" values(?,?,? ) ");
		
		 return query;
						
}
	
	/**
	 * @param companyId
	 * @return
	 */
	public static Object getProductDetailPerCompanyQuery(final int companyId) {
		// TODO Auto-generated method stub
final StringBuilder query=new StringBuilder("");
		
		query.append("Select ").append(Relation.PRODUCT).append(".").append(LocationColumns.PRODUCTID).append(" productid,").append(Relation.PRODUCT).append(".").append(LocationColumns.PRODUCTNAME)
		.append(" productname,").append(Relation.BRAND).append(".").append(LocationColumns.BRANDID).append(" brandid,").append(Relation.BRAND).append(".").append(LocationColumns.BRANDNAME).append(" brandname,")
		.append(Relation.CATEGORY).append(".").append(LocationColumns.CATEGORYID).append(" categoryid,").append(Relation.CATEGORY).append(".").append(LocationColumns.CATEGORYNAME).append(" categoryname")
		.append(" from ").append(Relation.PRODUCT).append(" inner join ").append(Relation.BRAND).append(" on ")
		.append(Relation.PRODUCT).append(".").append(LocationColumns.BRANDID).append("=").append(Relation.BRAND).append(".").append(LocationColumns.BRANDID)
		.append(" inner join ").append(Relation.CATEGORY).append(" on ").append(Relation.PRODUCT).append(".").append(LocationColumns.CATEGORYID).append("=").append(Relation.CATEGORY).append(".").append(LocationColumns.CATEGORYID)
		.append(" inner join ").append(Relation.COMPANY).append(" on ").append(Relation.COMPANY).append(".").append(LocationColumns.COMPANYID).append("=").append(Relation.BRAND).append(".").append(LocationColumns.COMPANYID)
		.append(" and ").append(Relation.COMPANY).append(".")
		.append(LocationColumns.COMPANYID).append("=").append(companyId);
		
		return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder addAreaDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" insert into ");
	 
		query.append(Relation.AREA);
	 
		
		query.append(" (stateid,areaname )")
		.append(" values(?,?) ");
		
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder addCategoryDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" insert into ");
	 
		query.append(Relation.CATEGORY);
	 
		
		query.append(" (parentcategoryid,categoryname )")
		.append(" values(?,?) ");
		
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder addCompanyDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" insert into ");
	 
		query.append(Relation.COMPANY);
	 
		
		query.append(" (companyname,companylocation,parentcompanyid )")
		.append(" values(?,?,?) ");
		
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder addLocationDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" insert into ");
	 
		query.append(Relation.LOCATION);
	 
		
		query.append(" (areaid,locationname )")
		.append(" values(?,?) ");
		
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder addProductDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" insert into ");
	 
		query.append(Relation.PRODUCT);
	 
		
		query.append(" (productname,brandid,categoryid )")
		.append(" values(?,?,?) ");
		
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder addProductRatingDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" insert into ");
	 
		query.append(Relation.PRODUCTRATINGS);
	 
		
		query.append(" (ratingpoint,productid,userid )")
		.append(" values(?,?,?) ");
		
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder addUserDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" insert into ");
	 
		query.append(Relation.USER);
	 
		
		query.append(" (username,userpass )")
		.append(" values(?,?) ");
		
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder updateAreaDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" update ");
	 
		query.append(Relation.AREA).append(" set ").append("stateid").append(" = ?")
		.append(", ").append("areaname").append(" = ? ").append(" where ").append("areaid ")
		.append("= ?") ;		
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder updateBrandDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" update ");
	 
		query.append(Relation.BRAND).append(" set ").append("companyid").append(" = ?")
		.append(", ").append("brandname").append(" = ? ").append(", ").append("brandtype").append(" = ? ").append(" where ").append("brandid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder updateCategoryDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" update ");
	 
		query.append(Relation.CATEGORY).append(" set ").append("categoryname").append(" = ?")
		.append(", ").append("parentcategoryid").append(" = ? ").append(" where ").append("categoryid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder updateCompanyDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" update ");
	 
		query.append(Relation.COMPANY).append(" set ").append("companyname").append(" = ?")
		.append(", ").append("companylocation").append(" = ? ").append(", ").append("parentcompanyid").append(" = ? ").append(" where ").append("companyid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder updateLocationDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" update ");
	 
		query.append(Relation.LOCATION).append(" set ").append("areaid").append(" = ?")
		.append(", ").append("locationname").append(" = ? ").append(" where ").append("locationid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder updateProductDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" update ");
	 
		query.append(Relation.PRODUCT).append(" set ").append("productname").append(" = ?")
		.append(", ").append("brandid").append(" = ? ").append(", ").append("categoryid").append(" = ? ").append(" where ").append("productid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder updateProductRatingDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" update ");
	 
		query.append(Relation.PRODUCTRATINGS).append(" set ").append("ratingpoint").append(" = ?")
		.append(", ").append("productid").append(" = ? ").append(", ").append("userid").append(" = ? ").append(" where ").append("ratingid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder updateUserDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" update ");
	 
		query.append(Relation.USER).append(" set ").append("username").append(" = ?")
		.append(", ").append("userpass").append(" = ? ").append(" where ").append("userid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder deleteAreaDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" delete ");
	 
		query.append(" from ").append(Relation.AREA).append(" where ").append(" areaid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder deleteBrandDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" delete ");
	 
		query.append(" from ").append(Relation.BRAND).append(" where ").append(" brandid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder deleteCategoryDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" delete ");
	 
		query.append(" from ").append(Relation.CATEGORY).append(" where ").append(" categoryid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder deleteCompanyDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" delete ");
	 
		query.append(" from ").append(Relation.COMPANY).append(" where ").append(" companyid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder deleteLocationDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" delete ");
	 
		query.append(" from ").append(Relation.LOCATION).append(" where ").append(" locationid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder deleteProductDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" delete ");
	 
		query.append(" from ").append(Relation.PRODUCT).append(" where ").append(" productid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder deleteProductRatingDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" delete ");
	 
		query.append(" from ").append(Relation.PRODUCTRATINGS).append(" where ").append(" ratingid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder deleteUserDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" delete ");
	 
		query.append(" from ").append(Relation.USER).append(" where ").append(" userid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder addServiceDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" insert into ");
	 
		query.append(Relation.SERVICE);
	 
		
		query.append(" (servicename,brandid )")
		.append(" values(?,?) ");
		
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder updateServiceDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" update ");
	 
		query.append(Relation.SERVICE).append(" set ").append("servicename").append(" = ?")
		.append(", ").append("brandid").append(" = ? ").append(" where ").append("serviceid ")
		.append("= ?") ;	
		 return query;
	}

	/**
	 * @return
	 */
	public static StringBuilder deleteServiceDetailsQuery() {
		// TODO Auto-generated method stub
		final StringBuilder query=new StringBuilder("");
		query.append(" delete ");
	 
		query.append(" from ").append(Relation.SERVICE).append(" where ").append(" serviceid ")
		.append("= ?") ;	
		 return query;
	}

}
