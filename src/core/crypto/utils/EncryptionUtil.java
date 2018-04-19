package core.crypto.utils;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {
	public static String calculateHMAC(String secret, String username, String timestamp) {
        // Concatenate the username and timestamp (epoch seconds)
        String data = username + timestamp;
 
        try {
            // Encrypt data using the secret
            SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes());
 
            // encrypted data is a byte array convert back to string
            String encoded = "";
            for (final byte element : rawHmac) {
                encoded += Integer.toString((element & 0xff) + 0x100, 16).substring(1);
            }
            return encoded;
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException();
        }
    }
}
