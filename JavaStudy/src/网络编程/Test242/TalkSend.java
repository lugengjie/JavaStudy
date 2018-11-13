package ������.Test242;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{
	private DatagramSocket client;
	private BufferedReader br;
	private String toIp;
	private int toPort;
	
	public TalkSend(int port,String toIp,int toPort) {
		this.toIp=toIp;
		this.toPort=toPort;
		try {
			this.client =new DatagramSocket(port);
			this.br=new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			String data = null;
			try {
				data = br.readLine();
				byte[] datas=data.getBytes();
				//* 3.��װ��DatagramPacket����,��Ҫָ��Ŀ�ĵ�
				DatagramPacket packet=new DatagramPacket(datas, 0,datas.length,new InetSocketAddress(toIp,toPort));
				//*4.���Ͱ���send(DatagramPacket p)
				client.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(data.equals("bye")) {
				break;
			}
		}
		//* 5.�ͷ���Դ
		client.close();
	}
	
}
