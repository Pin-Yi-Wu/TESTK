package com.example.mina.ksw_demo;

import java.math.BigInteger;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Mina on 2017/4/24.
 */

public class convertPassMd5 {
    public static String convertPassMd5(String pass) {
        char[] salt = {'8','5','0','2','6','0','2','0'} ;

        String password = null;
        MessageDigest mdEnc;
       try {
           mdEnc = MessageDigest.getInstance("MD5");
           mdEnc.update((pass+salt).getBytes(), 0, pass.length());
           pass = new BigInteger(1, mdEnc.digest()).toString(16);
           while (pass.length() < 32) {
                pass = "0" + pass;
                 }
              password = pass;
            } catch (NoSuchAlgorithmException e1) {
               e1.printStackTrace();
            }
        return password;
       }


}
