package ������.Test247;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң�������
 * Ŀ�꣺��װʹ�ö��߳�ʵ�ֶ���û����������շ�������Ϣ
 * @author jie
 *
 */
public class TMultiChat {
	public static void main(String[] args) throws IOException {
		System.out.println("------Service------");
		// * 1.ָ���˿� ʹ��ServiceSocket����������
		ServerSocket server=new ServerSocket(8888);
		// * 2.����ʽ�ȴ����� accept
		while(true) {
			Socket client = server.accept();
			new Thread(new Channel(client)).start();
		}
	}
	//һ���ͻ��˴���һ��Channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		
		@Override
		public void run() {
			while(isRunning) {
				String msg=receive();
				if(msg!=null) {
					send(msg);
				}
			}
			
		}
		public Channel(Socket client) {
			this.client = client;
			try {
				this.dis=new DataInputStream(client.getInputStream());
				this.dos=new DataOutputStream(client.getOutputStream());
				this.isRunning=true;
			} catch (IOException e) {
				System.out.println("------������------");
				release();
			}	
			
		}
		//������Ϣ
		private String receive() {
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				System.out.println("------����------");
				release();
			}
			return msg;
		}
		//������Ϣ
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				System.out.println("------����------");
				release();
			}
			

		}
		//�ͷ���Դ
		private void release() {
			this.isRunning=false;
			Utils.close(dos,dis,client);
		}
		
	}
}
