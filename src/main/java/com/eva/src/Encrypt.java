package com.eva.src;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class Encrypt {

    private PublicKey publicKey;
    private PrivateKey privateKey;



    public static void main(String [] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();

        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter string:");
        String msg = scan.nextLine();

        Cipher encryptCiper = Cipher.getInstance("RSA");
        encryptCiper.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] secretMessageBytes = msg.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = encryptCiper.doFinal(secretMessageBytes);

        String encryptedMsg = Base64.getEncoder().encodeToString(encryptedMessageBytes);

        System.out.println(encryptedMsg);

        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
        String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);

        System.out.println(decryptedMessage);
    }
}