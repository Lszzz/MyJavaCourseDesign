package vehicleleasing.algorithm;

/**
 * @author lszzz
 * @create 2020/6/3
 */
public class XorCryptology {
	/**
	 * 简单的异或加密方法
	 * 任何一个整数和另一个整数异或两次得到的结果就是这个整数本身
	 * 因此a^b就是加密过程，a是原数据，b是密钥（a^b）^b就是解密的过程
	 */

	public static String encrypt(String Data,String Key)
	{
		byte[] data =Data.getBytes();
		byte[] key =Key.getBytes();
		if(data==null||data.length==0||key==null||key.length==0)
		{
			return new String(data);
		}
		byte []encode=new byte[data.length];
		//使用密钥异或，再与循环变量的低8位进行异或（增加复杂度）
		for(int i=0;i<data.length;i++) {
			encode[i]=(byte)(data[i]^key[i%key.length]^(i&0xFF));
		}
		return new String(encode);
		}

}

