package ������;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

public class Test141_2_client {
	public static void main(String[] args) throws IOException {
		System.out.println("���ͷ�������.....");
		//* 1.ʹ��DatagramSocketָ���˿� �������Ͷ�
		DatagramSocket client=new DatagramSocket(8888);
		//* 2.׼������,һ��Ҫת���ֽ�����
		//д��
		byte[] datas=IOUtils.fileToByteArray("src/������/logo.png");
		//* 3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
		DatagramPacket packet=new DatagramPacket(datas, 0,datas.length,new InetSocketAddress("localhost",9999));
		//* 4.���Ͱ���send(DatagramPacket p)
		client.send(packet);
		//* 5.�ͷ���Դ
		client.close();
	}
}
