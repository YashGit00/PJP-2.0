package com.ps.demo.AverageCityIncome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import PerCapitaInformation.PerCapitaInfoDAO;

public class PerCapitaInfoDAOList {

	ArrayList<PerCapitaInfoDAO> list;
	String inputFilePath;

	public PerCapitaInfoDAOList(String inputFilePath) {
		this.inputFilePath = inputFilePath;
		try {
			FileReader reader = new FileReader(new File(inputFilePath));
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] input = line.replace("\\s", "").split(",");
				PerCapitaInfoDAO item = new PerCapitaInfoDAO(input);
				list.add(item);
			}
			br.close();
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<PerCapitaInfoDAO> getList() {
		return list;
	}

	public void setList(ArrayList<PerCapitaInfoDAO> list) {
		this.list = list;
	}

	public String getInputFilePath() {
		return inputFilePath;
	}

	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}
}
