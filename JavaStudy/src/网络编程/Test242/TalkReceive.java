package ������.Test242;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
	private DatagramSocket server;
	private String from;
	public TalkReceive(int port,String from) {
		this.from=from;
		try {
			this.server =new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
			while(true) {
				//* 2.׼��������װ��DatagramPacket����
				byte[] container=new byte[1024*60];
				DatagramPacket packet=new DatagramPacket(container, 0,container.length);
				//* 3.����ʽ���հ���receive(DatagramPacket p)
				try {
					server.receive(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}
				//* 4.��������
				//* byte[] getData()
				//* 	   getLength()
				byte[] datas=packet.getData();
				int len=packet.getLength();
				String data=new String(datas,0,len);
				System.out.println(this.from+":"+data);
				if(data.equals("bye")) {
					break;
				}
		}
		//* 5.�ͷ���Դ
		server.close();
	}

}
