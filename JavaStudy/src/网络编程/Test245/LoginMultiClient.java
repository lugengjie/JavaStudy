package ������.Test245;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ģ���½  ����ͻ�������
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
 * 2.�����������������
 * 3.�ͷ���Դ
 * @author jie
 *
 */
public class LoginMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----Client----");	
		// * 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
		Socket client=new Socket("localhost",8888);
		// * 2.�����������������
		new Send(client).send();;
		new Receive(client);
		// * 3.�ͷ���Դ
		client.close();
	}
	static class Send{
		private Socket client;
		private BufferedReader br;
		private DataOutputStream dos;

		public Send(Socket client) {
			this.client=client;
			this.br=new BufferedReader(new InputStreamReader(System.in));
			try {
				dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void send() {
			try {
				dos.writeUTF(init());
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		private String init() {
			String uname="";
			String upw="";
			try {
				System.out.println("�������û���:");
				uname=br.readLine();
				System.out.println("����������:");
				upw=br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "uname="+uname+"&"+"upw="+upw;
		}
	}
	
	static class Receive{
		private Socket client;
		private DataInputStream dis;
		
		public Receive(Socket client) {	
			this.client = client;
			try {
				this.dis=new DataInputStream(client.getInputStream());
				System.out.println(dis.readUTF());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
