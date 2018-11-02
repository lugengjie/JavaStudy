package IO流技术;

import java.io.UnsupportedEncodingException;

public class Test171 {
	public static void main(String[] args) {
		String msg="性命生命使命";
		//默认使用工程的字符集
		//字节数组
		byte[] datas=msg.getBytes();
		System.out.println(datas.length);
		//编码
		try {
			datas=msg.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(datas.length);
		//解码
		try {
			msg=new String(datas,0,datas.length,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(msg);
	}

}
