/**
 * 
 */
package com.coding.util;

import java.util.Map;

import com.coding.pojo.Company;

/**
 * This is shares utility class which displays the companies with highest share
 * price.
 * 
 * @author Bharat.Khandelwal
 * 
 */
public class SharesUtil {

	/**
	 * This method is a utility method to display highest share price of
	 * companies.
	 * 
	 * @param topSharesMap
	 */
	public static void displayTopShares(Map<String, Company> topSharesMap) {
		java.util.Iterator<Company> iterator = topSharesMap.values().iterator();
		while (iterator.hasNext()) {
			Company next = iterator.next();

			System.out.println(next.toString());
		}
	}
}
