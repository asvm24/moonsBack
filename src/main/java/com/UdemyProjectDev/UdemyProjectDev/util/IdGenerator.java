package com.UdemyProjectDev.UdemyProjectDev.util;

import lombok.extern.log4j.Log4j2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Log4j2
public class IdGenerator {
    private static final String HASH_ALGORITHM = "MD5";

    public static Long generateHash(String... data) {
        StringBuilder sb = new StringBuilder();
        for (String str : data) {
            sb.append(str);
        }
        String concatenatedData = sb.toString();
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hashedBytes = md.digest(concatenatedData.getBytes());
            return bytesToLong(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
    private static long bytesToLong(byte[] bytes) {
        long result = 0;
        for (int i = 0; i < bytes.length; i++) {
            result |= (long) (bytes[i] & 0xFF) << (8 * i);
        }
        return result;
    }
}
