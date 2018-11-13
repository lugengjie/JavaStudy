package ������.Test244;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���½  ����
 * ����������
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ����� accept
 * 3.�����������������
 * 4.�ͷ���Դ
 * @author jie
 *
 */
public class LoginService {
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
		String[] dataArray=data.split("&");
		for(String info:dataArray) {
			String[] msg=info.split("=");
			if(msg[0].equals("uname")) {
				System.out.println("�û�����"+msg[1]);
			}else {
				System.out.println("���룺"+msg[1]);
			}
		}
		// * 4.�ͷ���Դ
		dis.close();
		client.close();

	}

}
