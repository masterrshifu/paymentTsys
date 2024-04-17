package com.tsys.tsep.manifest;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESEncryption {

    public static void main(String[] args) throws Exception {

        String transactionKey = "9GLAYQ3LN0CP3I46A6Z2W44FF7SJ8BL9";
        // Your 128-bit key (16 bytes)

        String keyString = "9GLAYQ3LN0CP3I46";
        byte[] keyBytes = keyString.getBytes(StandardCharsets.UTF_8);

        // Your 16-byte initialization vector (IV)
        String ivString = "9GLAYQ3LN0CP3I46";
        byte[] ivBytes = ivString.getBytes(StandardCharsets.UTF_8);

        // Your plaintext message
        String plaintext = "887000000352        88700000035204          00000000000012152023";

        // Encrypt the message
        byte[] encrypted = encrypt(plaintext, keyBytes, ivBytes);

        // Print the base64-encoded ciphertext
        String ciphertextBase64 = Base64.getEncoder().encodeToString(encrypted);
        String ciphertextHex = base64ToHex(ciphertextBase64);
        System.out.println("Ciphertext: " + ciphertextBase64);
        System.out.println("Ciphertext in hex: " + ciphertextHex);
        String hashTransactionKey = hashTransactionKey();
        System.out.println("Hashed Transaction Key: " + hashTransactionKey);
        String encryptedManifestString = encryptedmanifestString(ciphertextHex,hashTransactionKey);
        System.out.println("Encrypted Manifest String: " + encryptedManifestString);
    }

    public static byte[] encrypt(String plaintext, byte[] key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        // If your plaintext length is not a multiple of 16, you may need to pad it manually
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        return ciphertext;
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

    public static String hashTransactionKey() {

        String secretKey = "9GLAYQ3LN0CP3I46A6Z2W44FF7SJ8BL9";
        // Your message to be hashed
        String message = "9GLAYQ3LN0CP3I46A6Z2W44FF7SJ8BL9";
        String hexHash = "";

        try {
            // Convert the secret key to a SecretKeySpec
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacMD5");

            // Get an instance of the Mac object and initialize it with the secret key
            Mac mac = Mac.getInstance("HmacMD5");
            mac.init(secretKeySpec);

            // Compute the HMAC-MD5 hash
            byte[] hashBytes = mac.doFinal(message.getBytes());

            // Convert the hash to a hex string
            hexHash = bytesToHex(hashBytes);

            // Print the result
            System.out.println("HMAC-MD5: " + hexHash);
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

    private static String encryptedmanifestString(String hexManifest, String hexTransactionKey) {

        String encryptedmanifest = "";

        StringBuilder sb = new StringBuilder();

        sb.append(hexTransactionKey.substring(0,4) + hexManifest + hexTransactionKey.substring(hexTransactionKey.length()-4));
        return sb.toString();
    }


}
