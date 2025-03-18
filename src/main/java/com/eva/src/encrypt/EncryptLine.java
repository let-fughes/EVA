package com.eva.src.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class EncryptLine {
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public String Encryption(String line) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        Generate gen = new Generate();
        gen.Genetate(publicKey, privateKey);

        Cipher encryptCiper = Cipher.getInstance("RSA");
        encryptCiper.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] byteline = line.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedLineByte = encryptCiper.doFinal(byteline);

        String encryptedLine = Base64.getEncoder().encodeToString(encryptedLineByte);
        return encryptedLine;
    }
}
