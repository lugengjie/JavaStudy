package 网络编程.Test244;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 模拟登陆  双向
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端+服务器的地址和端口
 * 2.操作：输入输出操作
 * 3.释放资源
 * @author jie
 *
 */
public class LoginTwoWayClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----Client----");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名:");
		String uname=br.readLine();
		System.out.println("请输入密码:");
		String upw=br.readLine();
		// * 1.建立连接：使用Socket创建客户端+服务器的地址和端口
		Socket client=new Socket("localhost",8888);
		// * 2.操作：输入输出操作
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF("uname="+uname+"&"+"upw="+upw);
		dos.flush();
		DataInputStream dis=new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		// * 3.释放资源
		dos.close();
		client.close();
	}
}
