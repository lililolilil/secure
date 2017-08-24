package SwingTest;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class createHash {

    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";
    public static final int SALT_BYTES = 24;
    public static final int HASH_BYTES = 24;
    public static final int PBKDF2_ITERATIONS = 1000;

    public static final int ITERATION_INDEX = 0;
    public static final int SALT_INDEX = 1;
    public static final int PBKDF2_INDEX = 2;
    
    public static String createHash(String in_text)
            throws NoSuchAlgorithmException, InvalidKeySpecException
        {
            return createHash(in_text.toCharArray());
        }

	private static String createHash(char[] charArray) throws NoSuchAlgorithmException, InvalidKeySpecException{
		// TODO Auto-generated method stub
		SecureRandom random = new SecureRandom();  
		byte[] salt = new byte[SALT_BYTES]; 
		byte[] hash = pdkdf2(in_text, salt, PBKDF2_ALGORITHM, HASH_BYTES); 
	}

    
    
}
