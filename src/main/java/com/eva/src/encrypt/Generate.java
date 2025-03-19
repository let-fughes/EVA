package com.eva.src.encrypt;

import java.security.*;

public class Generate {
    private PublicKey publicKey;
    private PrivateKey privateKey;


    private void generate() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();

        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public PrivateKey getPrKey(){
        return privateKey;
    }

    public PublicKey getPublicKey(){
        return publicKey;
    }

    public void Genetate() throws NoSuchAlgorithmException {
        generate();
    }
}
