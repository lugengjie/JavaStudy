package ������.Test244;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ��Ϥ����
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
 * 2.�����������������
 * 3.�ͷ���Դ
 * @author jie
 *
 */
public class FileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----Client----");
		// * 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
		Socket client=new Socket("localhost",8888);
		// * 2.�����������������
		InputStream is=new BufferedInputStream(new FileInputStream("src/������/03.jpeg"));
		OutputStream os=new BufferedOutputStream(client.getOutputStream());
		int len=0;
		byte[] data=new byte[1024];
		while((len=is.read(data))!=-1) {
			os.write(data, 0, len);
		}
		os.flush();
		// * 3.�ͷ���Դ
		os.close();
		is.close();
		client.close();
	}
}
