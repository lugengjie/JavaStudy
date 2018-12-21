package 网络编程.Test244;

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
 * 熟悉流程
 * 创建服务器
 * 1.指定端口 使用ServerSocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作：输入输出操作
 * 4.释放资源
 * @author jie
 *
 */
public class FileService {
	public static void main(String[] args) throws IOException {
		System.out.println("------Service------");
		// * 1.指定端口 使用ServiceSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		// * 2.阻塞式等待连接 accept
		Socket client=server.accept();
		System.out.println("一个客户端建立连接");
		// * 3.操作：输入输出操作
		InputStream is=new BufferedInputStream(client.getInputStream());
		OutputStream os=new BufferedOutputStream(new FileOutputStream("src/网络编程/04.jpeg"));
		// * 4.释放资源
		os.close();
		is.close();
		client.close();

	}

}
