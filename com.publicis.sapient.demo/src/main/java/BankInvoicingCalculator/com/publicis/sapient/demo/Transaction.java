package BankInvoicingCalculator.com.publicis.sapient.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	String externalTransactionId;
	String clientId;
	String securityId;
	String transactionType;
	Date transactionDate;
	Float marketValue;
	Boolean priority;
	
	public Transaction() {
		
	}
	
	public Transaction ( String[] transaction) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		this.externalTransactionId = transaction[0];
		this.clientId = transaction[1];
		this.securityId = transaction[2];
		this.transactionType = transaction[3];
		this.transactionDate = formatter.parse(transaction[4]);
		this.marketValue = Float.valueOf(transaction[5]);
		this.priority = transaction[6].equalsIgnoreCase("y") ? true: false;		
	}
	
	public String toString() {
		return "Transaction [externalTransactionId=" + externalTransactionId + ", clientId=" + clientId
				+ ", securityId=" + securityId + ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", marketValue=" + marketValue + ", priority=" + priority + "]";
	}

	public Transaction(String externalTransactionId, String clientId, String securityId, String transactionType,
			Date transactionDate, Float marketValue, Boolean priority) {
		super();
		this.externalTransactionId = externalTransactionId;
		this.clientId = clientId;
		this.securityId = securityId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.marketValue = marketValue;
		this.priority = priority;
	}

	public Transaction( Transaction t) {
		this.externalTransactionId = t.externalTransactionId;
		this.clientId = t.clientId;
		this.securityId = t.securityId;
		this.transactionType = t.transactionType;
		this.transactionDate = t.transactionDate;
		this.marketValue = t.marketValue;
		this.priority = t.priority;
	}
	
	public String getExternalTransactionId() {
		return externalTransactionId;
	}

	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
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

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Float getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(Float marketValue) {
		this.marketValue = marketValue;
	}

	public Boolean getPriority() {
		return priority;
	}

	public void setPriority(Boolean priority) {
		this.priority = priority;
	}
	
	public Transaction getOppIntraTransaction() 
	{
		Transaction t = new Transaction(this);
		t.setTransactionType(this.getTransactionType().equalsIgnoreCase("sell")?"buy":"sell");
		return t;
	}
	
	public static int comparator( Transaction t1, Transaction t2) {
		int rc = t1.getExternalTransactionId().compareToIgnoreCase(t2.getExternalTransactionId());
		return rc;
	}
	
}
