package com.zsy.auth;

import com.zsy.blog.common.exception.MyException;
import com.zsy.blog.common.exception.enums.ErrorEnum;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-26 17:06
 */
public class TokenGenerator {

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String generateValue(){
        return generateValue(UUID.randomUUID().toString());
    }

    private static String generateValue(String param) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(param.getBytes());
            byte[] digest = messageDigest.digest();
            return toHexString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new MyException(ErrorEnum.TOKEN_GENERATOR_ERROR, e);
        }
    }
    private static String toHexString(byte[] data) {
        if (data == null){
            return null;
        }
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data){
            r.append(hexCode[b>>4 & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }
}
