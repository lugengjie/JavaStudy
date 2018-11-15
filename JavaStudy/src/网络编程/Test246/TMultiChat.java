package ������.Test246;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң�������
 * Ŀ�꣺ʵ��һ���ͻ����������շ���Ϣ
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
			new Thread(()-> {
				DataInputStream dis=null;
				DataOutputStream dos=null;
				boolean isRunning=true;
				try {
					System.out.println("һ���ͻ��˽�������");
					//3.������Ϣ
					dis=new DataInputStream(client.getInputStream());	
					dos=new DataOutputStream(client.getOutputStream());
					
					while(isRunning) {
						String msg=dis.readUTF();
						dos.writeUTF(msg);
						dos.flush();
					}
				} catch (IOException e) {
					isRunning = false; //ֹͣ�߳�
					e.printStackTrace();
				}
				//4.�ͷ���Դ
				try {
					if(null==dos) {
						dos.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(null==dis) {
						dis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(null==client) {
						client.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
