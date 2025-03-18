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

    private PrivateKey getPrKey(){
        return privateKey;
    }

    private PublicKey getPublicKey(){
        return publicKey;
    }

    public void Genetate(PublicKey pu, PrivateKey pr) throws NoSuchAlgorithmException {
        generate();
        pu = getPublicKey();
        pr = getPrKey();
    }
}
