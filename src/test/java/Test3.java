package test.java;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Test3 {
	
	// EDB 加密密钥向量
	private static byte[] iv1 = { (byte) 0x12, (byte) 0x34, (byte) 0x56,
			(byte) 0x78, (byte) 0x90, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF };
	
	public static byte[] encrypt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(iv1);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		return cipher.doFinal(message.getBytes("UTF-8"));
	}
	
	public static String decrypt(String decryptString, String decryptKey) {
		IvParameterSpec iv = new IvParameterSpec(iv1);
		SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key, iv);
			BASE64Decoder decoder = new BASE64Decoder();
			return new String(
					cipher.doFinal(decoder.decodeBuffer(decryptString)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decryptKey;
	}
	
	public static void main(String[] args) throws Exception {
		String key = "d31f64ab";
		String value = "18105850628";
		System.out.println("加密数据:" + value);
		
		String a = new BASE64Encoder().encode(encrypt(value, key));
		System.out.println("加密后的数据为:" + a);
		String b = decrypt(a, key);
		System.out.println("解密后的数据:" + b);
		// System.out.println(decrypt1("uKMlb5WeW6Yk/wt6cHDamg==", key));
	}
}
