package BankInvoicingCalculator.com.publicis.sapient.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TransactionList {

	public ArrayList<Transaction> transactionList;

	public TransactionList() {
		super();
	}

	public TransactionList(String inputFilePath, String type) {
		if (type.equalsIgnoreCase("csv")) {
			readingCSVFile(inputFilePath);
		}
		else readingXLSXFile(inputFilePath);
	}
	
	@Override
	public String toString() {
		return "TransactionList [transactionList=" + transactionList + "]";
	}

	public void readingCSVFile(String inputFilePath) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(inputFilePath));
			String line;
			transactionList = new ArrayList<Transaction>();
			line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] tempTransaction = line.replace("\\s", "").replace("\"", "").split(",");
				if (tempTransaction.length == 7) {
					Transaction t = new Transaction(tempTransaction);
					transactionList.add(t);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void readingXLSXFile(String inputFilePath) {
		try {
			FileInputStream fis = new FileInputStream(new File(inputFilePath));
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    Iterator<Row> rowIt = sheet.iterator();
		    while ( rowIt.hasNext()) {
		    	Row row = rowIt.next();
		    	Iterator<Cell> cellIt = row.cellIterator();
		    	while (cellIt.hasNext()) {
		    		Cell cell = cellIt.next();
		    		System.out.println(cell);
				}
		    }

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String printTrasnactionList() {
		String res = "";
		for (Transaction t : transactionList) {
			res += t.toString() + "\n";
		}
		return res;
	}
}