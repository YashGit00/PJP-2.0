package BankInvoicingCalculator.com.publicis.sapient.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ClientFees {

	HashMap<SummaryGroup, Integer> processingFees;

	public ClientFees() {
		processingFees = new HashMap<SummaryGroup, Integer>();
	}

	public void calculateFees(TransactionList tl) {
		for (Transaction t : tl.transactionList) {
			Integer fee = t.getPriority() ? 500 : 0;
			String transType = t.getTransactionType();
			fee += (transType.equalsIgnoreCase("sell") || transType.equalsIgnoreCase("withdraw")) ? 50 : 100;
			fee += tl.transactionList.contains(t.getOppIntraTransaction()) ? 10 : 0;
			SummaryGroup temp = new SummaryGroup(t.clientId, t.transactionType, t.transactionDate, t.priority);
			if (processingFees.containsKey(temp)) {
				Integer currFee = processingFees.get(temp);
				processingFees.replace(temp, currFee, currFee + fee);
			} else {
				processingFees.put(temp, fee);
			}
		}
		Set<SummaryGroup> set = processingFees.keySet();
		List<SummaryGroup> list = new ArrayList<SummaryGroup>(set);
		Collections.sort(list, SummaryGroup::comparator);
	}

	public String getSummary() {
		String format = "%1$20s";
		String summ = String.format(format, "Client Id");
		summ += String.format(format, "Transaction Type");
		summ += String.format(format, "Transaction Date");
		summ += String.format(format, "Priority");
		summ += String.format(format, "Processing Fee");
		summ += "\n";
		for (SummaryGroup entry : processingFees.keySet()) {
			summ += String.format(format, entry.getClientId());
			summ += String.format(format, entry.getTransactionType());
			summ += String.format(format, entry.getTransactionDatetoStr());
			summ += String.format(format, (entry.isPriority() ? "Y" : "N"));
			summ += String.format(format, processingFees.get(entry));
			summ += "\n";
		}
		return summ;
	}

	public String printProcessingFees() {
		String res = "";
		for (SummaryGroup entry : processingFees.keySet()) {
			res += entry + " => " + processingFees.get(entry) + "\n";
		}
		return res;
	}

}
