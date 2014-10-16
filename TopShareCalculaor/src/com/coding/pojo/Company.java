/**
 * 
 */
package com.coding.pojo;

/**
 * This class represents the Company and its details in the input file.
 * 
 * @author Bharat Khandelwal
 * 
 */
public class Company {

	private String month;
	private String year;
	private String name;
	private double sharePrice;

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sharePrice
	 */
	public double getSharePrice() {
		return sharePrice;
	}

	/**
	 * @param sharePrice
	 *            the sharePrice to set
	 */
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", year=" + year + ", month=" + month
				+ ", price=" + sharePrice + "]";
	}
}
