package com.nutz.mvc.demo.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 实现MD5加密算法
 * @author gcy71
 *
 */
public class MD5Encryption {
	
	/**
	 * 
	 * @param Text 需加密的字符串(明文)
	 * @return 加密后的密文
	 */
	public static String encryption(String Text){
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(Text.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有MD5加密算法");
		}
		return new BigInteger(1, secretBytes).toString();
	}

}
