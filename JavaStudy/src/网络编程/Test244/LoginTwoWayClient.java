package ������.Test244;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ģ���½  ˫��
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
 * 2.�����������������
 * 3.�ͷ���Դ
 * @author jie
 *
 */
public class LoginTwoWayClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----Client----");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û���:");
		String uname=br.readLine();
		System.out.println("����������:");
		String upw=br.readLine();
		// * 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
		Socket client=new Socket("localhost",8888);
		// * 2.�����������������
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("uname="+uname+"&"+"upw="+upw);
		dos.flush();
		DataInputStream dis=new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		// * 3.�ͷ���Դ
		dos.close();
		client.close();
	}
}
