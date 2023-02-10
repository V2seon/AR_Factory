package com.elfe.arfactory.promotion.common;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

// 뒤에붙은 숫자는 키의 길이를 의미함 (256 = 32바이트)
public class AES_256 {

    private SecretKeySpec secretKey;
    private IvParameterSpec IV;

    public AES_256() throws UnsupportedEncodingException, NoSuchAlgorithmException {

        String key_256 = "aeskey12345678987654321asekey987";//AES-256는 256비트(32바이트)의 키

        String iv = "aesiv12345678912";

        //바이트 배열로부터 SecretKey를 구축
        this.secretKey = new SecretKeySpec(key_256.getBytes("UTF-8"), "AES");
        //this.IV = new IvParameterSpec(reqSecretKey.substring(0,16).getBytes());
        this.IV = new IvParameterSpec(iv.getBytes());
    }

    //AES CBC PKCS5Padding 암호화(Hex | Base64)
    public String AesCBCEncode(String plainText) throws Exception {

        //Cipher 객체 인스턴스화(Java에서는 PKCS#5 = PKCS#7이랑 동일)
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Cipher 객체 초기화
        c.init(Cipher.ENCRYPT_MODE, secretKey, IV);

        //Encrpytion/Decryption
        byte[] encrpytionByte = c.doFinal(plainText.getBytes("UTF-8"));

        //Hex Encode
        return Hex.encodeHexString(encrpytionByte);

        //Base64 Encode
//		return Base64.encodeBase64String(encrpytionByte);
    }

    //AES CBC PKCS5Padding 복호화(Hex | Base64)
    public String AesCBCDecode(String encodeText) throws Exception {

        //Cipher 객체 인스턴스화(Java에서는 PKCS#5 = PKCS#7이랑 동일)
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Cipher 객체 초기화
        c.init(Cipher.DECRYPT_MODE, secretKey, IV);

        //Decode Hex
        byte[] decodeByte = Hex.decodeHex(encodeText.toCharArray());

        //Decode Base64
//		byte[] decodeByte = Base64.decodeBase64(encodeText);

        //Encrpytion/Decryption
        return new String(c.doFinal(decodeByte), "UTF-8");
    }



}
