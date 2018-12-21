package 网络编程;

import java.net.InetSocketAddress;

/**
 * 端口
 * 1.区分软件
 * 2.2个字节0-65535 UDP TCP
 * 3.同一个协议端口不能冲突
 * @author jie
 * 1.构造器 new InetSocketAddress(地址|域名，端口)
 * getAddress()
 * getPost()
 * getHostName()
 * 
 *
 */
public class Test236 {
	public static void main(String[] args) {
		//包含端口
		InetSocketAddress isa=new InetSocketAddress("localhost",8080);
		InetSocketAddress isa2=new InetSocketAddress("127.0.0.1",8080);
		
		System.out.println(isa.getHostName());
		System.out.println(isa.getAddress());
		
		System.out.println(isa2.getHostName());
		System.out.println(isa2.getAddress());
		System.out.println(isa2.getPort());
	}

}
