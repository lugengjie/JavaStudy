package ������;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

public class Test141_2_service {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("���շ�������....");
		//* 1.ʹ��DatagramSocketָ���˿� �������ն�
		DatagramSocket server=new DatagramSocket(9999);
		//* 2.׼��������װ��DatagramPacket����
		byte[] container=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(container, 0,container.length);
		//* 3.����ʽ���հ���receive(DatagramPacket p)
		server.receive(packet);
		//* 4.��������
		//* byte[] getData()
		//* 	   getLength()
		byte[] datas=packet.getData();
		int len=packet.getLength();
		IOUtils.byteArrayToFile(datas, "src/������/logo2.png");
		//* 5.�ͷ���Դ
		server.close();
	}
}
