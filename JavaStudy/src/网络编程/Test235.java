package 网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * InetAddress多个静态方法
 * getLocalHost:本机
 * getByName:根据域名DNS|ip地址--》ip
 * @author jie
 * 两个成员方法
 * getHostAddress:返回地址
 * getHostName:返回计算机名
 */
public class Test235 {
	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建InetAddress对象
		InetAddress ia=InetAddress.getLocalHost();
		System.out.println(ia.getHostAddress()); //输出IP地址
		System.out.println(ia.getHostName()); //输出计算机名
		
		//根据域名得到InetAddress对象
		ia=InetAddress.getByName("www.shsxt.com");
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
		
		//根据Ip得到InetAddress对象
		ia=InetAddress.getByName("169.254.53.180");
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
	}
}
