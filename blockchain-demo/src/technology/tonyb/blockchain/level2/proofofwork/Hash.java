package technology.tonyb.blockchain.level2.proofofwork;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Method which calculates SHA-256 or SHA-512 hashes. <br>
 *  
 * @author Anton Balucha
 */
public class Hash {

	public static final String SHA_512 = "SHA-512";
	public static final String SHA_256 = "SHA-256";
	public static final String USED_ALGORITHM = SHA_256;
	
	public static final String ENCODING = "UTF-8";
	
	/** 
	 * Method, which calculates hash for entered array of strings.
	 * 
	 * @param stringsToHash - array of strings for which will be calculated hash
	 * @return calculated hash
	 */
	public static String getHash(String[] stringsToHash) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < stringsToHash.length; i++) {
			sb.append(stringsToHash[i]);
		}
		
		return getHash(sb.toString());
	}
	
	/** 
	 * Method, which calculates hash for entered string.
	 * 
	 * @param stringToHash - string for which will be calculated hash
	 * @return calculated hash
	 */
	public static String getHash(String stringToHash) {
		
		StringBuilder sb = new StringBuilder();
		
		try {
			MessageDigest md = MessageDigest.getInstance(USED_ALGORITHM);
			md.update(stringToHash.getBytes(ENCODING));
			byte[] bytes = md.digest();
			
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}
