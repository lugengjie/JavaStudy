package ������;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * InetAddress�����̬����
 * getLocalHost:����
 * getByName:��������DNS|ip��ַ--��ip
 * @author jie
 * ������Ա����
 * getHostAddress:���ص�ַ
 * getHostName:���ؼ������
 */
public class Test235 {
	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost��������InetAddress����
		InetAddress ia=InetAddress.getLocalHost();
		System.out.println(ia.getHostAddress()); //���IP��ַ
		System.out.println(ia.getHostName()); //����������
		
		//���������õ�InetAddress����
		ia=InetAddress.getByName("www.shsxt.com");
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
		
		//����Ip�õ�InetAddress����
		ia=InetAddress.getByName("169.254.53.180");
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
	}
}
