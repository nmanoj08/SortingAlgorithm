package com.hm.assignment.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CSVSortUtil {

	public void sortDataUsingFile1List(String path, String column, List<String> file2Contents) {
		// TODO Auto-generated method stub
		int index = 0;
		String line = "";
		Map<String, String> csvToBeSortedMap = new LinkedHashMap<String, String>();
		File file = new File(this.getClass().getClassLoader().getResource(path).getFile());
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] file1Contents = line.split(",");
				for (int i = 0; i < file1Contents.length; i++) {
					if (file1Contents[i].equalsIgnoreCase(column)) {
						index = i;
						break;
					}
				}
				csvToBeSortedMap.put(file1Contents[index], line);// map key will hold column specific data and map value
																	// will be the whole row in csv
			}
			boolean header = true;
			for (String file2Data : file2Contents) {
				for (Map.Entry<String, String> entrySet : csvToBeSortedMap.entrySet()) {
					if (header) {
						System.out.println(entrySet.getValue());
						header = false;
					}
					if (file2Data.equalsIgnoreCase(entrySet.getKey())) {
						System.out.println(entrySet.getValue());// Printing the sorted order
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<String> parseFileForSortByList(String path, String column) {
		// TODO Auto-generated method stub
		String line = "";
		int index = 0;
		List<String> sortByList = new ArrayList<String>();
		File file = new File(this.getClass().getClassLoader().getResource(path).getFile());
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] file2Contents = line.split(",");
				for (int i = 0; i < file2Contents.length; i++) {
					if (file2Contents[i].equalsIgnoreCase(column)) {
						index = i;// get the index of file2 column for sorting
						break;
					}
				}
				sortByList.add(file2Contents[index]);// adding data from specific column only
			}
			sortByList.remove(0);// removing header
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return sortByList;
	}

	public boolean parseFilesForHeaders(String path, String column) {
		// TODO Auto-generated method stub
		File file = new File(this.getClass().getClassLoader().getResource(path).getFile());

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			if (line != null) {
				String[] file2Headers = line.split(",");// splitting the row data using the delimiter
				for (String header : file2Headers) {
					if (header.equalsIgnoreCase(column)) {
						return true;
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
