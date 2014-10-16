/**
 * 
 */
package com.coding.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.coding.exception.FileProcessException;

/**
 * This class is file utility class.
 * 
 * @author Bharat.Khandelwal
 * 
 */
public class FileUtil {

	/**
	 * This method is a utility method to retrive scanner object.
	 * 
	 * @param inputFile
	 * @return scanner
	 * @throws FileProcessException
	 */
	public static Scanner getFileReader(File inputFile)
			throws FileProcessException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(inputFile);
		} catch (FileNotFoundException e) {
			throw new FileProcessException("File not found"
					+ inputFile.getName(), e);
		}
		Scanner scanner = new Scanner(fis);
		return scanner;
	}

	/**
	 * This method is a utility method to close scanner object.
	 * 
	 * @param fileReader
	 */
	public static void closeFileReader(Scanner fileReader) {
		if (fileReader != null) {
			fileReader.close();
		}
	}
}
