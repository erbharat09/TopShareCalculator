/**
 * 
 */
package com.coding.core.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coding.core.CSVFileProcessor;
import com.coding.core.FileProcessor;
import com.coding.exception.FileProcessException;
import com.coding.pojo.Company;

/**
 * @author Bharat.Khandelwal
 * 
 */
public class FileProcessorTest {

	FileProcessor fileProcessor;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fileProcessor = new CSVFileProcessor();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		fileProcessor = null;
	}

	/**
	 * This method is to test file not found exception.
	 */
	@Test
	public void testFileNotFoundError() {

		try {
			File file = new File("test.csv");
			fileProcessor.processFileForMaxShares(file);
		} catch (FileProcessException e) {
			assertTrue("Expected Exception FileProcessException", true);
		}
	}

	/**
	 * This method is to test null pointer exception.
	 */
	@Test
	public void testNullPointerError() {

		File file = null;
		try {
			fileProcessor.processFileForMaxShares(file);
		} catch (FileProcessException e) {
			assertTrue("Expected Exception FileProcessException", true);
		}
	}

	/**
	 * This method is to test file starting without header.
	 */
	@Test
	public void testInvalidHeader() {

		File file = new File("test_shares_data_wrong_header.csv");
		;
		try {
			fileProcessor.processFileForMaxShares(file);
		} catch (FileProcessException e) {
			assertTrue("Expected Exception FileProcessException", true);
			assertEquals("Invalid header Data", e.getMessage());
		}
	}

	/**
	 * This method is to test file proceesor functionality for popoulating the
	 * result of companies with max share price.
	 */
	@Test
	public void testfileProcessor() {

		File file = new File("test_shares_data.csv");
		try {
			Map<String, Company> topSharesCompany = fileProcessor
					.processFileForMaxShares(file);
			if (topSharesCompany == null) {
				fail("topSharesCompany map should not be empty");
			} else {
				assertEquals("2000", topSharesCompany.get("Company-A")
						.getYear());
				assertEquals(1000.0, topSharesCompany.get("Company-A")
						.getSharePrice(), 0);

				assertEquals("2007", topSharesCompany.get("Company-B")
						.getYear());
				assertEquals(986.0, topSharesCompany.get("Company-B")
						.getSharePrice(), 0);
			}
		} catch (FileProcessException e) {
			fail("Exceptions should not come" + e);
		}
	}
}
