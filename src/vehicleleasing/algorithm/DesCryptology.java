package vehicleleasing.algorithm;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64.*;
/**
 * @author lszzz
 * @create 2020/6/3
 */
public class DesCryptology{


	/**
	 * DES加密介绍 DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。
	 */
	public DesCryptology()
	{
	}

//		// 测试
//		public static void main(String args[]) throws UnsupportedEncodingException {
//			// 待加密内容
//			String str = "lszzz";
//			// 密码，长度要是8的倍数
//			String password = "12343213";
//			String res=Des.encrypt(str, password);
//			System.out.println(res);
//			//System.out.println(s1+" BASE "+s2);
//			// 直接将如上内容解密;
//			try
//			{
//				String decryResult = Des.decrypt(res, password);
//				System.out.println("after："+decryResult);
//			} catch (Exception e1)
//			{
//				e1.printStackTrace();
//			}
//
//		}


	/**
	 * 加密
	 *
	 * @param data
	 *            byte[]
	 * @param password
	 *            String
	 * @return byte[]
	 */
	//data为数据，password是密钥
	public static String encrypt(String data, String password)
	{
		try
		{
			//获取比特
			byte []datasource=data.getBytes();
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 现在，获取数据并加密
			// 正式执行加密操作
			System.out.println(new String(cipher.doFinal(datasource)));
			return jdkBase64String(cipher.doFinal(datasource));
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
		return null;
	}
	//使用base64编码消除使用其他编码时与DES返回的字节格式不匹配的问题；
	public static String jdkBase64String(byte[] key)
	{
		return Base64.getEncoder().encodeToString(key);
	}

	public static byte[] jdkBase64Decoder(String str)
	{
		return Base64.getDecoder().decode(str);
	}

	/**
	 * 解密
	 *
	 * @param Src
	 *            byte[]
	 * @param password
	 *            String
	 * @return byte[]
	 * @throws Exception
	 */
	public static String decrypt(String Src, String password) throws Exception
	{
		//获取base64的字节流；
		byte []src=jdkBase64Decoder(Src);
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		System.out.println(new String(cipher.doFinal(src))+"  解密");
		return new String(cipher.doFinal(src));
	}
}

