package com.coding.core;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.coding.exception.FileProcessException;
import com.coding.pojo.Company;
import com.coding.util.FileUtil;

/**
 * This class process csv files.
 * 
 * @author Bharat.Khandelwal
 * 
 */
public class CSVFileProcessor implements FileProcessor {

	/**
	 * This method processs the input file and populate map of companies with
	 * max shares.
	 * 
	 * @param inputFile
	 * @return topShareCompanies
	 * @throws FileProcessException
	 */
	@Override
	public Map<String, Company> processFileForMaxShares(File inputFile)
			throws FileProcessException {

		if (inputFile == null) {
			throw new FileProcessException("Input file is null");
		}
		Scanner fileReader = FileUtil.getFileReader(inputFile);
		Map<String, Company> topShareCompanies = new LinkedHashMap<String, Company>();

		try {
			String[] shareheader = getAndStoreHeader(topShareCompanies,
					fileReader);
			Company newCompany = null;
			while (fileReader.hasNext()) {

				String line = fileReader.next();
				String[] sharesRecord = line.split(",");

				String year = sharesRecord[0];
				String month = sharesRecord[1];

				int counter = 2;
				while (sharesRecord.length > counter) {
					newCompany = getNextCompanyData(counter, year, month,
							sharesRecord, shareheader);
					Company oldCompany = topShareCompanies.get(newCompany
							.getName());
					if (oldCompany == null
							|| newCompany.getSharePrice() > oldCompany
									.getSharePrice())
						topShareCompanies.put(newCompany.getName(), newCompany);
					counter++;
				}
			}
		} finally {
			FileUtil.closeFileReader(fileReader);
		}
		return topShareCompanies;
	}

	/**
	 * This method is to produce new company object.
	 * 
	 * @param year
	 * @param month
	 * @param sharesRecord
	 * @return company
	 */
	private Company getNextCompanyData(int counter, String year, String month,
			String[] sharesRecord, String[] sharesHeader) {
		// TODO Auto-generated method stub

		Company company = new Company();
		company.setYear(year);
		company.setMonth(month);
		company.setName(sharesHeader[counter]);
		company.setSharePrice(Double.parseDouble((sharesRecord[counter])));
		return company;
	}

	/**
	 * This method stores header values and returns the populated header
	 * 
	 * @param topShareCompanies
	 * @param fileReader
	 * @return sharesHeader
	 * @throws FileProcessException
	 */
	private String[] getAndStoreHeader(Map<String, Company> topShareCompanies,
			Scanner fileReader) throws FileProcessException {

		String header = fileReader.next();
		String[] sharesHeader = null;
		Company compDetails = null;
		if (validateHeader(header)) {
			sharesHeader = header.split(",");
			for (int counter = 2; counter < sharesHeader.length; counter++) {
				topShareCompanies.put(sharesHeader[counter], compDetails);
			}
		} else {
			throw new FileProcessException("Invalid header Data");
		}

		return sharesHeader;
	}

	/**
	 * This method validates the header value.
	 * 
	 * @param header
	 */
	private boolean validateHeader(String header) {

		return !(header != null && !header.isEmpty()) ? false : header
				.split(",")[0].equalsIgnoreCase("year") ? true : false;
	}
}
