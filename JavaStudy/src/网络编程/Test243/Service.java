package ������.Test243;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��Ϥ����
 * ����������
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ����� accept
 * 3.�����������������
 * 4.�ͷ���Դ
 * @author jie
 *
 */
public class Service {
	public static void main(String[] args) throws IOException {
		System.out.println("------Service------");
		// * 1.ָ���˿� ʹ��ServiceSocket����������
		ServerSocket server=new ServerSocket(8888);
		// * 2.����ʽ�ȴ����� accept
		Socket client=server.accept();
		System.out.println("һ���ͻ��˽�������");
		// * 3.�����������������
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String data=dis.readUTF();
		System.out.println(data);
		// * 4.�ͷ���Դ
		dis.close();
		client.close();

	}

}
