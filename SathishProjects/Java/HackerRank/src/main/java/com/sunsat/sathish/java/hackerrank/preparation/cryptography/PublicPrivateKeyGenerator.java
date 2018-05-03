package com.sunsat.sathish.java.hackerrank.preparation.cryptography;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

/**
 * Created by sathishkumar_su on 4/17/2018.
 */
public class PublicPrivateKeyGenerator {

    private KeyPairGenerator keyGen = null;
    private KeyPair pair;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public PublicPrivateKeyGenerator(int length) throws NoSuchAlgorithmException {
        keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
    }

    public void createKeys() {
        this.pair = this.keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public void writeToFile(String path, byte[] key) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public static void main(String[] args) {
        PublicPrivateKeyGenerator gk;
        try {
            gk = new PublicPrivateKeyGenerator(1024);
            gk.createKeys();
            String path = System.getProperty("user.dir");
            gk.writeToFile("KeyPair"+File.separator+"publicKey", gk.getPublicKey().getEncoded());
            gk.writeToFile("KeyPair"+File.separator+"privateKey", gk.getPrivateKey().getEncoded());
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
