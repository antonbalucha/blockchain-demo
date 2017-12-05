package technology.tonyb.blockchain;

import java.util.Arrays;

public class Transaction {

	private String source;
	
	private String target;
	
	private Double amount;

	private int transactionHash;
	
	public Transaction(String source, String target, Double amount) {
		this.source = source;
		this.target = target;
		this.amount = amount;
		
		this.countTransactionHash();
	}

	private void countTransactionHash() {
		Object[] content = {this.source, this.target, this.amount};
		this.transactionHash = Arrays.hashCode(content);
	}
	
	public String getSource() {
		return this.source;
	}

	public String getTarget() {
		return this.target;
	}

	public Double getAmount() {
		return this.amount;
	}

	public int getTransactionHash() {
		return this.transactionHash;
	}
}
