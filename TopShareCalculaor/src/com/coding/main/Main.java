/**
 * 
 */
package com.coding.main;

import java.io.File;
import java.util.Map;

import com.coding.core.CSVFileProcessor;
import com.coding.core.FileProcessor;
import com.coding.exception.FileProcessException;
import com.coding.pojo.Company;
import com.coding.util.SharesUtil;

/**
 * Lists, for each Company, year and month in which the share price was highest.
 * 
 * @author Bharat.Khandelwal
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String file = args[0];
		File inputFile = new File(file);

		FileProcessor fileProcessor = new CSVFileProcessor();
		try {
			Map<String, Company> topSharesMap = fileProcessor
					.processFileForMaxShares(inputFile);
			SharesUtil.displayTopShares(topSharesMap);
		} catch (FileProcessException e) {
			e.printStackTrace();
		}
	}
}
