package com.sysware.cloud.utils.md5;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    private static final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * 获取计算MD5的值
     * 
     * @param baseToken
     * @return
     */
    public static final String digestMD5(String baseToken) {

        try {
            byte[] strTemp = baseToken.getBytes("utf-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static final String digestMD5(String baseToken, String charset) {

        try {
            byte[] strTemp = baseToken.getBytes(charset);
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 增加对文件流的MD5算法
     *
     * @param inputStream
     * @return
     */
    public static String digestMD5(InputStream inputStream) {

        String md5String = null;
        try {
            byte[] buffer = new byte[4096];
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            int len;
            while ((len = inputStream.read(buffer, 0, 4096)) != -1) {
                md5.update(buffer, 0, len);
            }
            BigInteger bigInteger = new BigInteger(1, md5.digest());
            md5String = bigInteger.toString(16);
            if (md5String.length() < 32) {
                int j = 32 - md5String.length();
                for (int i = 0; i < j; i++) {
                    md5String = "0" + md5String;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return md5String;
    }
}
