package BankInvoicingCalculator.com.publicis.sapient.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SummaryGroup {
	
	String clientId;
	String transactionType;
	Date transactionDate;
	boolean priority;
	
	public SummaryGroup() {
		super();
	}
	
	public SummaryGroup(String clientId, String transactionType, Date transactionDate, boolean priority) {
		super();
		this.clientId = clientId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.priority = priority;
	}
	
	public SummaryGroup(SummaryGroup copy) {
		this.clientId = copy.getClientId();
		this.transactionType = copy.getTransactionType();
		this.transactionDate = copy.getTransactionDate();
		this.priority = copy.isPriority();
	}
	
	public static int comparator( SummaryGroup g1, SummaryGroup g2) {
		int rc = g1.getClientId().compareToIgnoreCase(g2.getClientId());
		if ( rc == 0) {
			rc = g1.getTransactionType().compareToIgnoreCase(g2.getTransactionType());
			if ( rc == 0) {
				rc = g1.getTransactionDate().compareTo(g2.getTransactionDate());
				if ( rc == 0) {
					return g1.isPriority() == true ? 1:0;
				}
				return rc;
			}
			return rc;
		}
		return rc;
	}
	
	@Override
	public String toString() {
		return "SummaryGroup [clientId=" + clientId + ", transactionType=" + transactionType + ", transactionDate="
				+ getTransactionDatetoStr() + ", priority=" + priority + "]";
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}
	
	public String getTransactionDatetoStr() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(transactionDate);
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public boolean isPriority() {
		return priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}
}
