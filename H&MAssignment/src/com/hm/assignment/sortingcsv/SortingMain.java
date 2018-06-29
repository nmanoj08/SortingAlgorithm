package com.hm.assignment.sortingcsv;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.hm.assignment.util.CSVSortUtil;

public class SortingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		try {
			CSVSortUtil sortUtil = new CSVSortUtil();
			// Reading the headers of csv files
			boolean file1ColumnExists = sortUtil.parseFilesForHeaders(args[0], args[1]);
			boolean file2ColumnExists = sortUtil.parseFilesForHeaders(args[2], args[3]);

			// If header column exists sort
			if (file1ColumnExists == true && file2ColumnExists == true) {
				List<String> sortByList = sortUtil.parseFileForSortByList(args[2], args[3]);
				sortUtil.sortDataUsingFile1List(args[0], args[1], sortByList);
			}
		} catch (Exception e) {
			// executes when this exception occurs
			System.out.println(e.getMessage());
		} finally {
			scan.close();
		}
	}

}
