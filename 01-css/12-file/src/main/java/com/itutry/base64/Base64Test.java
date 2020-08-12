package com.itutry.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

public class Base64Test {

    public static void main(String[] args) throws Exception {
        String str = "这是需要Base64编码的内容";

        // 编码
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encodedStr = base64Encoder.encode(str.getBytes("UTF-8"));
        System.out.println(encodedStr);

        // 编码
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] bytes = base64Decoder.decodeBuffer(encodedStr);
        String decodedStr = new String(bytes, "UTF-8");
        System.out.println(decodedStr);
    }
}
