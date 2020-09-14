package driver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import BankInvoicingCalculator.com.publicis.sapient.demo.ClientFees;
import BankInvoicingCalculator.com.publicis.sapient.demo.SummaryGroup;
import BankInvoicingCalculator.com.publicis.sapient.demo.Transaction;
import BankInvoicingCalculator.com.publicis.sapient.demo.TransactionList;

public class Runner {

	public static void main(String[] args) {

		String inputFilePath = "SampleData\\Sample_Data_Fee_Calculator.csv";
		String type = "csv";
		TransactionList list = new TransactionList(inputFilePath, type);
		System.out.println(list.printTrasnactionList());
		ClientFees cf = new ClientFees();
		String op = cf.printProcessingFees();
		cf.calculateFees(list);
		System.out.println(op);
		try {
			File opFile = new File(
					"SampleData\\Sample_Data_Fee_Calculator_output.txt");
			FileWriter fw = new FileWriter(opFile);
			if (opFile.createNewFile()) {
				System.out.println("File created: " + opFile.getName());
			} else {
				System.out.println("File already exists.");
			}
			String summ = cf.getSummary();
			fw.write(summ);
			fw.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} 
	}

}
