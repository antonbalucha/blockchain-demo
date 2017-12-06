package technology.tonyb.blockchain.level2.proofofwork;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {

	public static void main(String[] args) {

		Transaction genesisTransaction = new Transaction("A", "B", 1.0);
		System.out.println("Hash of genesis transaction: " + genesisTransaction.getTransactionHash());
		
		List<Transaction> genesisTransactions1 = new ArrayList<Transaction>();
		genesisTransactions1.add(genesisTransaction);		
		
		Block genesisBlock = new Block(0, genesisTransactions1);
		System.out.println("Hash of genesis block: " + genesisBlock.getCurrentBlockHash());

		
		
		Transaction transaction1 = new Transaction("B", "C", 1.0);
		System.out.println("Hash of transaction 1: " + transaction1.getTransactionHash());
		
		Transaction transaction2 = new Transaction("C", "D", 2.0);
		System.out.println("Hash of transaction 2: " + transaction2.getTransactionHash());
		
		List<Transaction> transactions1 = new ArrayList<Transaction>();
		transactions1.add(transaction1);
		transactions1.add(transaction2);
		
		Block block1 = new Block(genesisBlock.getCurrentBlockHash(), transactions1);
		System.out.println("Hash of block 1: " + block1.getCurrentBlockHash());
		
		
		
		Transaction transaction3 = new Transaction("B", "C", 2.0);
		System.out.println("Hash of transaction 3: " + transaction3.getTransactionHash());
		
		Transaction transaction4 = new Transaction("C", "D", 5.0);
		System.out.println("Hash of transaction 4: " + transaction4.getTransactionHash());
		
		List<Transaction> transactions2 = new ArrayList<Transaction>();
		transactions1.add(transaction3);
		transactions1.add(transaction4);
		
		Block block2 = new Block(block1.getCurrentBlockHash(), transactions2);
		System.out.println("Hash of block 2: " + block2.getCurrentBlockHash());
	}
}
