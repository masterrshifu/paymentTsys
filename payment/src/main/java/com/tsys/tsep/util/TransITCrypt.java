package com.tsys.tsep.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class TransITCrypt {
    private static final String SECRET_KEY_ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int KEY_SIZE = 256;
    private static final int ITERATION_COUNT = 65536;
    private static final int IV_SIZE = 16;

    public static String encryptManifest(String merchantID, String deviceID, int amount, String transactionKey) {
        try {

            byte[] iv = new byte[IV_SIZE];

            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            // Derive a key from the merchantID and transactionKey using PBKDF2
            SecretKey secretKey = deriveKey(merchantID, transactionKey);

            // Combine the manifest data into a string
            String manifestData = merchantID + deviceID + amount;

            // Encrypt the manifest data
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
            byte[] encryptedBytes = cipher.doFinal(manifestData.getBytes());

            // Convert the encrypted bytes to a base64-encoded string
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static SecretKey deriveKey(String merchantID, String transactionKey) throws Exception {
        // Derive a secret key from merchantID and transactionKey using PBKDF2
        SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY_ALGORITHM);
        KeySpec spec = new PBEKeySpec((merchantID + transactionKey).toCharArray(), merchantID.getBytes(), ITERATION_COUNT, KEY_SIZE);
        SecretKey tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), SECRET_KEY_ALGORITHM);
    }
}
