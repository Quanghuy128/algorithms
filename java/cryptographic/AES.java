package cryptographic;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AES {
    public static void main(String[] args) throws Exception {
        String plainText = "Hello, AES!";
        // Generate a secret key
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
        
        // Encrypt the message
        byte[] encryptedBytes = encrypt(plainText, secretKey);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encryptedBytes));

        // Decrypt the message
        String decryptedText = decrypt(encryptedBytes, secretKey);
        System.out.println("Decrypted: " + decryptedText);
    }

    public static byte[] encrypt(String plainText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
    }

    public static String decrypt(byte[] cipherText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
