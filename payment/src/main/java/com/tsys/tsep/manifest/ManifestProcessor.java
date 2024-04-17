package com.tsys.tsep.manifest;


import com.tsys.tsep.service.TransactionKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;



@Service
@Lazy
public class ManifestProcessor {

    private static final String transactionKey = "9GLAYQ3LN0CP3I46A6Z2W44FF7SJ8BL9";
    private static final String merchantId = "887000000352";
    private static final String deviceId = "88700000035204";
    private static final int amount = 0;


    @Autowired
    private TransactionKeyService transactionKeyService;


    public String generateFinalManifest() throws Exception {

        String manifestString = ManifestCreator.createManifestString(merchantId, deviceId, amount);
        return encryptManifestString(manifestString, transactionKey);

    }

    public static String base64ToHex(String base64String) {
        // Decode the Base64 string to bytes
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);

        // Convert the bytes to a hex string
        StringBuilder hexString = new StringBuilder();
        for (byte b : decodedBytes) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    }

    public static String hashTransactionKey(String transactionKey) {

        String hexHash = "";

        try {
            // Convert the secret key to a SecretKeySpec
            SecretKeySpec secretKeySpec = new SecretKeySpec(transactionKey.getBytes(), "HmacMD5");

            // Get an instance of the Mac object and initialize it with the secret key
            Mac mac = Mac.getInstance("HmacMD5");
            mac.init(secretKeySpec);

            // Compute the HMAC-MD5 hash
            byte[] hashBytes = mac.doFinal(transactionKey.getBytes());

            // Convert the hash to a hex string
            hexHash = bytesToHex(hashBytes);

            // Print the result
//            System.out.println("HMAC-MD5: " + hexHash);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return hexHash;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }


    private static String encryptManifestString(String manifestString, String transactionKey) throws Exception {

        String keyString = transactionKey.substring(0,16);
        byte[] keyBytes = keyString.getBytes(StandardCharsets.UTF_8);

        // Your 16-byte initialization vector (IV)
        String ivString = transactionKey.substring(0,16);
        byte[] ivBytes = ivString.getBytes(StandardCharsets.UTF_8);

        // Encrypt the message
        byte[] encrypted = encrypt(manifestString, keyBytes, ivBytes);

        // Print the base64-encoded ciphertext
        String ciphertextBase64 = Base64.getEncoder().encodeToString(encrypted);
        String ciphertextHex = base64ToHex(ciphertextBase64);
//        System.out.println("Ciphertext: " + ciphertextBase64);
//        System.out.println("Ciphertext in hex: " + ciphertextHex);
        String hashTransactionKey = hashTransactionKey(transactionKey);
//        System.out.println("Hashed Transaction Key: " + hashTransactionKey);
        //        System.out.println("Encrypted Manifest String: " + encryptedManifestString);
        return encryptedmanifestString(ciphertextHex,hashTransactionKey);
    }

    public static byte[] encrypt(String plaintext, byte[] key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        // If your plaintext length is not a multiple of 16, you may need to pad it manually
        return cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
    }

    private static String encryptedmanifestString(String hexManifest, String hexTransactionKey) {
        return hexTransactionKey.substring(0, 4) + hexManifest + hexTransactionKey.substring(hexTransactionKey.length() - 4);
    }


    public static void main(String[] args) throws Exception {
        // Example usage

//        TransactionKeyConfig singleton = TransactionKeyConfig.getInstance();
//        String transactionKey = singleton.getTransactionKey();
//        System.out.println(transactionKey);

//        System.out.println(transactionKeyService.getTransactionKey());

    }
}
