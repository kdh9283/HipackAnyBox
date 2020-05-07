package kr.co.packcom.hipackanybox;


import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class 암호화모듈 {
    private String password;

    public 암호화모듈(String password) {
        super();
        this.password = password;
    }

    public String 암호화(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes(Charset.forName("UTF-8")));

        byte[] rawKey = md.digest();
        byte[] hash = new byte[32];

        System.arraycopy(rawKey, 0, hash, 0, 16);
        System.arraycopy(rawKey, 0, hash, 15, 16);

        SecretKeySpec skeySpec = new SecretKeySpec(hash, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);


        byte[] encrypted = cipher.doFinal(input.getBytes(Charset.forName("UTF-8")));
        return Base64.encodeToString(encrypted, Base64.DEFAULT);

    }


    public String 복호화(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes(Charset.forName("UTF-8")));
        byte[] rawKey = md.digest();
        byte[] hash = new byte[32];
        System.arraycopy(rawKey, 0, hash, 0, 16);
        System.arraycopy(rawKey, 0, hash, 15, 16);
        SecretKeySpec skeySpec = new SecretKeySpec(hash, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(Base64.decode(input, Base64.DEFAULT));
        return new String(encrypted, Charset.forName("UTF-8"));


    }

}
