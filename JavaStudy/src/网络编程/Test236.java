package ������;

import java.net.InetSocketAddress;

/**
 * �˿�
 * 1.�������
 * 2.2���ֽ�0-65535 UDP TCP
 * 3.ͬһ��Э��˿ڲ��ܳ�ͻ
 * @author jie
 * 1.������ new InetSocketAddress(��ַ|�������˿�)
 * getAddress()
 * getPost()
 * getHostName()
 * 
 *
 */
public class Test236 {
	public static void main(String[] args) {
		//�����˿�
		InetSocketAddress isa=new InetSocketAddress("localhost",8080);
		InetSocketAddress isa2=new InetSocketAddress("127.0.0.1",8080);
		
		System.out.println(isa.getHostName());
		System.out.println(isa.getAddress());
		
		System.out.println(isa2.getHostName());
		System.out.println(isa2.getAddress());
		System.out.println(isa2.getPort());
	}

}
