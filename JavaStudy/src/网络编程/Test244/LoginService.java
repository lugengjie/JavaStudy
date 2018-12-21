package 网络编程.Test244;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登陆  单向
 * 创建服务器
 * 1.指定端口 使用ServerSocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作：输入输出操作
 * 4.释放资源
 * @author jie
 *
 */
public class LoginService {
	public static void main(String[] args) throws IOException {
		System.out.println("------Service------");
		// * 1.指定端口 使用ServiceSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		// * 2.阻塞式等待连接 accept
		Socket client=server.accept();
		System.out.println("一个客户端建立连接");
		// * 3.操作：输入输出操作
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String data=dis.readUTF();
		String[] dataArray=data.split("&");
		for(String info:dataArray) {
			String[] msg=info.split("=");
			if(msg[0].equals("uname")) {
				System.out.println("用户名："+msg[1]);
			}else {
				System.out.println("密码："+msg[1]);
			}
		}
		// * 4.释放资源
		dis.close();
		client.close();

	}

}
