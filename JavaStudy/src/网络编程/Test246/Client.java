package 网络编程.Test246;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 在线聊天室：客户端
 * 目标：实现一个客户可以正常收发消息
 * @author jie
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----Client----");	
		// 1.建立连接：使用Socket创建客户端+服务器的地址和端口
		Socket client=new Socket("localhost",8888);
		//2.客户端发送消息
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String msg=br.readLine();
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		dos.writeUTF(msg);
		dos.flush();
		//3.获取消息
		DataInputStream dis=new DataInputStream(client.getInputStream());
		msg=dis.readUTF();
		System.out.println(msg);
		//4.释放资源
		dis.close();
		dos.close();
		client.close();
		
		
	}
}
