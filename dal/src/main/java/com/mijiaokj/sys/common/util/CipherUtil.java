/*
 * Cainiao.com Inc.
 * Copyright (c) 2013-2016 All Rights Reserved.
 */
package com.mijiaokj.sys.common.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 通用的密码工具
 *
 * @author moyun
 */
public class CipherUtil {

	/**
	 * AES密钥
	 */
	private static final byte[] AES_CIPHER_KEY = Base64.decodeBase64("bZaXnKqpO9mMDlGSkBx8/A==");

	/**
	 * AES密码解密
	 *
	 * @param cipherText
	 * 		密文
	 *
	 * @return 明文
	 */
	public static String decryptAes(String cipherText) {
		try {
			SecretKey key = new SecretKeySpec(AES_CIPHER_KEY, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(Cipher.DECRYPT_MODE, key);

			return new String(cipher.doFinal(Base64.decodeBase64(cipherText)));
		} catch (Exception e) {
			throw new RuntimeException("处理AES解密时发生异常。[cipherText=" + cipherText + "]", e);
		}
	}

	/**
	 * AES加密
	 *
	 * @param clearText
	 * 		明文
	 *
	 * @return 密文
	 */
	public static String encryptAes(String clearText) {
		try {
			SecretKey key = new SecretKeySpec(AES_CIPHER_KEY, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(Cipher.ENCRYPT_MODE, key);

			return Base64.encodeBase64String(cipher.doFinal(clearText.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException("处理AES加密时发生异常。[clearText=" + clearText + "]", e);
		}
	}
}