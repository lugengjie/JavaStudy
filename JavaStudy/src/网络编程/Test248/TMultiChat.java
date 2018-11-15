package ������.Test248;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

import ������.Test247.Utils;

/**
 * ���������ң�������
 * Ŀ�꣺����������ʵ��Ⱥ��
 * @author jie
 *
 */
public class TMultiChat {
	private static CopyOnWriteArrayList<Channel> others=new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		System.out.println("------Service------");
		// * 1.ָ���˿� ʹ��ServiceSocket����������
		ServerSocket server=new ServerSocket(8888);
		// * 2.����ʽ�ȴ����� accept
		while(true) {
			Socket client = server.accept();
			System.out.println("һ���ͻ�������");
			Channel c=new Channel(client);
			others.add(c);
			new Thread(c).start();
		}
	}
	//һ���ͻ��˴���һ��Channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		private String name;
		
		@Override
		public void run() {
			while(isRunning) {
				String msg=receive();
				if(msg!=null) {
					sendOthers(msg);
				}
			}
			
		}
		public Channel(Socket client) {
			this.client = client;
			try {
				this.dis=new DataInputStream(client.getInputStream());
				this.dos=new DataOutputStream(client.getOutputStream());
				//��ȡ����
				this.name=receive();
				this.isRunning=true;
				//��ӭ���ĵ���
				send("��ӭ���ĵ���");
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
		/**
		 * Ⱥ�ģ���ȡ�Լ�����Ϣ������������
		 */
		private void sendOthers(String msg) {
			for(Channel other:others) {
				if(other==this) {
					continue;
				}else {
					other.send(this.name+"��������˵��"+msg);
				}
			}
		}
		//�ͷ���Դ
		private void release() {
			this.isRunning=false;
			Utils.close(dos,dis,client);
		}
		
	}
}
