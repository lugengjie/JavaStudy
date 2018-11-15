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
public class MultiChat {
	public static void main(String[] args) throws IOException {
		System.out.println("------Service------");
		// * 1.ָ���˿� ʹ��ServiceSocket����������
		ServerSocket server=new ServerSocket(8888);
		// * 2.����ʽ�ȴ����� accept
		Socket client=server.accept();
		System.out.println("һ���ͻ��˽�������");
		//3.������Ϣ
		DataInputStream dis=new DataInputStream(client.getInputStream());	
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		boolean isRunning=true;
		while(isRunning) {
			String msg=dis.readUTF();
			dos.writeUTF(msg);
			dos.flush();
		}
		//5.�ͷ���Դ
		dis.close();
		dos.close();
		client.close();
	}
}
