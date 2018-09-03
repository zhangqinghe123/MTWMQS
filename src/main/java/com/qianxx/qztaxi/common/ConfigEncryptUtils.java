package com.qianxx.qztaxi.common;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class ConfigEncryptUtils {

	public static String encrypt() {
		// 加密工具
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		// 加密配置
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
		config.setAlgorithm("PBEWithMD5AndDES");
		// 自己在用的时候更改此密码
		config.setPassword("yubin");
		// 应用配置
		encryptor.setConfig(config);
		String plaintext = "root";
		// 加密
		String ciphertext = encryptor.encrypt(plaintext);
		return plaintext + " : " + ciphertext;
	}

	public static String decrypt() {
		// 加密工具
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		// 加密配置
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
		config.setAlgorithm("PBEWithMD5AndDES");
		// 自己在用的时候更改此密码
		config.setPassword("yubin");
		// 应用配置
		encryptor.setConfig(config);
		String ciphertext = "8YTo/dgPG90feR53dkRGTxvXa7RXOxwm";
		// 解密
		String plaintext = encryptor.decrypt(ciphertext);
		return ciphertext + " : " + plaintext;
	}

	public static void main(String[] args) {
		System.out.println(encrypt());
		System.out.println(decrypt());
	}

}