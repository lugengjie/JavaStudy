package 网络编程.Test244;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 熟悉流程
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端+服务器的地址和端口
 * 2.操作：输入输出操作
 * 3.释放资源
 * @author jie
 *
 */
public class FileClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----Client----");
		// * 1.建立连接：使用Socket创建客户端+服务器的地址和端口
		Socket client=new Socket("localhost",8888);
		// * 2.操作：输入输出操作
		InputStream is=new BufferedInputStream(new FileInputStream("src/网络编程/03.jpeg"));
		OutputStream os=new BufferedOutputStream(client.getOutputStream());
		int len=0;
		byte[] data=new byte[1024];
		while((len=is.read(data))!=-1) {
			os.write(data, 0, len);
		}
		os.flush();
		// * 3.释放资源
		os.close();
		is.close();
		client.close();
	}
}
