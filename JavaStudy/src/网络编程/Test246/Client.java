package ������.Test246;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ���������ң��ͻ���
 * Ŀ�꣺ʵ��һ���ͻ����������շ���Ϣ
 * @author jie
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----Client----");	
		// 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
		Socket client=new Socket("localhost",8888);
		//2.�ͻ��˷�����Ϣ
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String msg=br.readLine();
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		//3.��ȡ��Ϣ
		DataInputStream dis=new DataInputStream(client.getInputStream());
		msg=dis.readUTF();
		System.out.println(msg);
		//4.�ͷ���Դ
		dis.close();
		dos.close();
		client.close();
		
		
	}
}
