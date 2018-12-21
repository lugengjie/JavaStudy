package 网络编程.Test247;

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
public class MultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----Client----");	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名");
		String uname=br.readLine();
		// 1.建立连接：使用Socket创建客户端+服务器的地址和端口
		Socket client=new Socket("localhost",8888);
		new Thread(new Send(client,uname)).start();
		new Thread(new Receive(client)).start();
	}
}
