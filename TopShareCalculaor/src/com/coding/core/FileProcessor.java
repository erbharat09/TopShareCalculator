/**
 * 
 */
package com.coding.core;

import java.io.File;
import java.util.Map;

import com.coding.exception.FileProcessException;
import com.coding.pojo.Company;

/**
 * Processes the files and outputs the map of companies with highest share
 * price.
 * 
 * @author Bharat.Khandelwal
 * 
 */
public interface FileProcessor {

	public Map<String, Company> processFileForMaxShares(File inputFile)
			throws FileProcessException;
}
