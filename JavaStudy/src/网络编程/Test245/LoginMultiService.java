package ������.Test245;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���½  ˫��
 * ����������
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ����� accept
 * 3.�����������������
 * 4.�ͷ���Դ
 * @author jie
 *
 */
public class LoginMultiService {
	public static void main(String[] args) throws IOException {
		System.out.println("------Service------");
		// * 1.ָ���˿� ʹ��ServiceSocket����������
		ServerSocket server=new ServerSocket(8888);
		while(true) {
			// * 2.����ʽ�ȴ����� accept
			Socket client=server.accept();
			new Thread(new Channel(client)).start();
		}

	}
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		public Channel(Socket client) {
			this.client=client;
			try {
				this.dis=new DataInputStream(client.getInputStream());
				this.dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				release();
			};
		}
		@Override
		public void run() {
			// *����
			String[] dataArray=receive().split("&");
			String uname=null;
			String upw=null;
			for(String info:dataArray) {
				String[] msg=info.split("=");
				if(msg[0].equals("uname")) {
					uname=msg[1];
					System.out.println("�û�����"+msg[1]);
				}else {
					upw=msg[1];
					System.out.println("���룺"+msg[1]);
				}
			}
			
			if(uname.equals("a")&&upw.equals("a")) {
				send("��½�ɹ�");
			}else {
				send("��½ʧ��");	
			}
			// * 4.�ͷ���Դ
			release();
		}
		private String receive() {
			String data="";
			try {
				data=dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return data;
		}
		
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		private void release() {
			try {
				if(dis!=null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(dos!=null) {
					dos.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if(client!=null) {
					client.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

