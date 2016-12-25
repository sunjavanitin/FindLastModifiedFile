package com.nitin.lastModified;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;
public class LastModifiedFile {
	
	public static void main(String[] args) throws IOException {
		File directory = new File("FileDirectory");
		// get just files, not directories
		File[] files = directory.listFiles((FileFilter) FileFileFilter.FILE);

		System.out.println("Default order");
		displayFiles(files);

		Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
		System.out.println("\nLast Modified Ascending Order (LASTMODIFIED_COMPARATOR)");
		displayFiles(files);

		Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		System.out.println("\nLast Modified Descending Order (LASTMODIFIED_REVERSE)");
		displayFiles(files);

	}

	public static void displayFiles(File[] files) {
		for (File file : files) {
			System.out.printf("File: %-20s Last Modified:" + new Date(file.lastModified()) + "\n", file.getName());
		}
	}
	

}
