package ������.Test244;

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
public class LoginTwoWayService {
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
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		if(uname.equals("a")&&upw.equals("a")) {
			dos.writeUTF("��½�ɹ�");
		}else {
			dos.writeUTF("��½ʧ��");
		}
		dos.flush();
		// * 4.�ͷ���Դ
		dis.close();
		client.close();

	}

}
