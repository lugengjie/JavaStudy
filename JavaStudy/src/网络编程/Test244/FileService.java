package ������.Test244;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public class FileService {
	public static void main(String[] args) throws IOException {
		System.out.println("------Service------");
		// * 1.ָ���˿� ʹ��ServiceSocket����������
		ServerSocket server=new ServerSocket(8888);
		// * 2.����ʽ�ȴ����� accept
		Socket client=server.accept();
		System.out.println("һ���ͻ��˽�������");
		// * 3.�����������������
		InputStream is=new BufferedInputStream(client.getInputStream());
		OutputStream os=new BufferedOutputStream(new FileOutputStream("src/������/04.jpeg"));
		// * 4.�ͷ���Դ
		os.close();
		is.close();
		client.close();

	}

}
