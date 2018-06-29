package com.hm.assignment.sortingcsv;

import java.util.List;

import com.hm.assignment.util.CSVSortUtil;
import com.hm.assignment.util.NoArgumentsException;

public class SortingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if(args == null || args.length == 0) {
				throw new NoArgumentsException("Please pass all the four arguments!!");
			}
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
		}
	}

}
