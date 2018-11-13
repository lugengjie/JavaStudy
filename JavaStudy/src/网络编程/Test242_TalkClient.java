package ������;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * ���Ͷ�
 * 1.ʹ��DatagramSocketָ���˿� �������Ͷ�
 * 2.׼������,һ��Ҫת���ֽ�����
 * 3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)
 * 5.�ͷ���Դ
 * @author jie
 *
 */
public class Test242_TalkClient {
	public static void main(String[] args) throws IOException {
		System.out.println("���Ͷ�������.....");
		//*1.ʹ��DatagramSocketָ���˿� �������Ͷ˫�
		DatagramSocket client=new DatagramSocket(8888);
		//* 2.׼������,һ��Ҫת���ֽ�����
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String data=br.readLine();
			byte[] datas=data.getBytes();
			//* 3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
			DatagramPacket packet=new DatagramPacket(datas, 0,datas.length,new InetSocketAddress("localhost",9999));
			//*4.���Ͱ���send(DatagramPacket p)
			client.send(packet);
			if(data.equals("bye")) {
				break;
			}
		}
		//* 5.�ͷ���Դ
		client.close();
	}
}
