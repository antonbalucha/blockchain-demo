package technology.tonyb.blockchain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Block {

	private int previousBlockHash = 0;
	
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	private int currentBlockHash;
	
	public Block(int previousBlockHash, List<Transaction> transactions) {
		this.previousBlockHash = previousBlockHash;
		this.transactions = transactions;
		
		this.countCurrentBlockHash();
	}
	
	public int getPreviousBlockHash() {
		return this.previousBlockHash;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public int getCurrentBlockHash() {
		return this.currentBlockHash;
	}
	
	private void countCurrentBlockHash() {
		int[] transactionHashes = new int[this.transactions.size() + 1];
		
		transactionHashes[0] = this.previousBlockHash;

		for (int i = 1; i <= this.transactions.size(); i++) {
			transactionHashes[i] = this.transactions.get(i - 1).getTransactionHash();
		}
		
		this.currentBlockHash = Arrays.hashCode(transactionHashes);
	}
}
