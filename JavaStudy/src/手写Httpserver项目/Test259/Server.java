package 手写Httpserver项目.Test259;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ʹ��ServerSocket����������������ӣ���ȡ����Э��
 * @author jie
 *
 */
public class Server {
	private  ServerSocket serverSocket;
	public static void main(String[] args) {
		Server server=new Server();
		server.start();
	}
	//��������
	public void start() {
		try {
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			System.out.println("����������ʧ��");
			e.printStackTrace();
		}

	}
	//��������
	public  void receive() {
	    try {
			Socket client=serverSocket.accept();
			System.out.println("һ���ͻ��˽�������");
			//��ȡ����Э��
			InputStream is=client.getInputStream();
			byte[] datas=new byte[1024*1024];
			int len=is.read(datas);
			String requestInfo=new String(datas,0,len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ͻ��˴���");
		}

	}
	//ֹͣ����
	public void stop() {
		// TODO Auto-generated method stub

	}
}
