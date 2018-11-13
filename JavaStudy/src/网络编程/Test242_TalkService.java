package ������;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ���ն�
 * 1.ʹ��DatagramSocketָ���˿� �������ն�
 * 2.׼��������װ��DatagramPacket����
 * 3.����ʽ���հ���receive(DatagramPacket p)
 * 4.��������
 * byte[] getData()
 * 		  getLength()
 * 5.�ͷ���Դ
 * @author jie
 *
 */
public class Test242_TalkService {
	public static void main(String[] args) throws IOException {
		System.out.println("���շ�������....");
		
			//* 1.ʹ��DatagramSocketָ���˿� �������ն�
			DatagramSocket server=new DatagramSocket(9999);
			while(true) {
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
				String data=new String(datas,0,len);
				System.out.println(data);
				if(data.equals("bye")) {
					break;
				}
		}
		//* 5.�ͷ���Դ
		server.close();
	}
}
