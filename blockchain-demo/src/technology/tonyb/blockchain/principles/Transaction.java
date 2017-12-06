package technology.tonyb.blockchain.principles;

import java.util.Arrays;

/**
 * Object {@link technology.tonyb.blockchain.principles.Transaction Transaction} contains only information about transaction.
 * Transaction contains one <b>source address</b> from which is send some <b>amount</b> of money to <b>target address</b>. 
 * Transaction is used by {@link technology.tonyb.blockchain.principles.Block Block} object.
 * 
 * @author Anton Balucha
 */
public class Transaction {

	/** Source address */
	private String source;
	
	/** Target address */
	private String target;
	
	/** Some amount of money, which will be send. */
	private Double amount;

	/** Hash of the transaction. */
	private int transactionHash;
	
	/** 
	 * Transaction is initialized via constructor, which takes on input following parameters: <br> 
	 * 
	 * @param source - source address
	 * @param target - target address
	 * @param amount - amount of sent money
	 */
	public Transaction(String source, String target, Double amount) {
		this.source = source;
		this.target = target;
		this.amount = amount;
		
		this.countTransactionHash();
	}

	/** Method will count transaction hash. */
	private void countTransactionHash() {
		Object[] content = {this.source, this.target, this.amount};
		this.transactionHash = Arrays.hashCode(content);
	}

	/** 
	 * Method returns source address. <br>
	 * 
	 * @return source address
	 */
	public String getSource() {
		return this.source;
	}

	/** 
	 * Method returns target address. <br>
	 * 
	 * @return target address
	 */
	public String getTarget() {
		return this.target;
	}

	/** 
	 * Method returns amount of sent money. <br>
	 * 
	 * @return amount of sent money
	 */
	public Double getAmount() {
		return this.amount;
	}

	/** 
	 * Method returns transaction hash based on source address, target address and amount of sent money.
	 * 
	 * @return transaction hash
	 */
	public int getTransactionHash() {
		return this.transactionHash;
	}
}
