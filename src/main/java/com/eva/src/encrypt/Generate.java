package com.eva.src.encrypt;

import java.security.*;

public class Generate {
    private PublicKey publicKey;
    private PrivateKey privateKey;


    //genetrating keys
    private void generate() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();

        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    //getting private key
    public PrivateKey getPrKey(){
        return privateKey;
    }

    //getting public key
    public PublicKey getPublicKey(){
        return publicKey;
    }

    //public foo for generating keys
    public void Genetate() throws NoSuchAlgorithmException {
        generate();
    }
}
