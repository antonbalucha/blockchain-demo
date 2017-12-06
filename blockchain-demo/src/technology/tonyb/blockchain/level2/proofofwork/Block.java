package technology.tonyb.blockchain.level2.proofofwork;

import java.util.ArrayList;
import java.util.List;

/** 
 * Current block contains information about previous block - its hash and transactions listed in current block. 
 * When these information are provided, block hash is calculated. 
 *  
 * @author Anton Balucha
 */
public class Block {

	/** Difficulty represents number of generated zeros at the beginning of the hash. */
	public static final int DIFFICULTY = 4;

	public static final String zeroes;
	
	static {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < DIFFICULTY; i++) {
			sb.append("0");
		}
		
		zeroes = sb.toString();
	}
	
	/** Hash of previous block. */
	private String previousBlockHash = "0";
	
	/** List of transactions listed in current block. */
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	/** 
	 * Number which will be incremented in order to change hash of the block. It can be of course used another way of updating block,
	 * e.g. generate random string, GUID... <br> 
	 */ 
	private long nonce = 0;
	
	/** Hash of current block calculated when information about transactions and hash of previous block are provided. */
	private String currentBlockHash;
	
	/** Block is initialized by hash of previous block and all transactions, which should be present in block. */
	public Block(String previousBlockHash, List<Transaction> transactions) {
		this.previousBlockHash = previousBlockHash;
		this.transactions = transactions;
		
		this.countCurrentBlockHash();
		this.mineBlock();
	}
	
	/** Method returns hash of previous block. */
	public String getPreviousBlockHash() {
		return this.previousBlockHash;
	}

	/** Method returns list of transactions present in block. */
	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	/** 
	 * Method return current block hash.
	 * 
	 * @return hash of current block
	 */
	public String getCurrentBlockHash() {
		return this.currentBlockHash;
	}
	
	/** Method counts hash of current block. */
	private void countCurrentBlockHash() {
		String[] materialForBlockHash = new String[this.transactions.size() + 2];
		
		materialForBlockHash[0] = this.previousBlockHash;
		
		materialForBlockHash[1] = this.nonce + "";

		for (int i = 2; i <= this.transactions.size(); i++) {
			materialForBlockHash[i] = this.transactions.get(i - 2).getTransactionHash();
		}
		
		this.currentBlockHash = Hash.getHash(materialForBlockHash);
	}
	
	/** Method, which provides mining of block - finding hash, which fits to defined rules. */
	private void mineBlock() {
		while (!currentBlockHash.startsWith(zeroes)) {
			countCurrentBlockHash();
			nonce++;
		}
	}
}
