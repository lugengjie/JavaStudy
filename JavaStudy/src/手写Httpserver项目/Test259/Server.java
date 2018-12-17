package 手写Httpserver项目.Test259;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用ServerSocket建立与浏览器的连接，获取请求协议
 * @author jie
 *
 */
public class Server {
	private  ServerSocket serverSocket;
	public static void main(String[] args) {
		Server server=new Server();
		server.start();
	}
	//启动服务
	public void start() {
		try {
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			System.out.println("服务器启动失败");
			e.printStackTrace();
		}

	}
	//接收连接
	public  void receive() {
	    try {
			Socket client=serverSocket.accept();
			System.out.println("一个客户端建立连接");
			//获取请求协议
			InputStream is=client.getInputStream();
			byte[] datas=new byte[1024*1024];
			int len=is.read(datas);
			String requestInfo=new String(datas,0,len);
			System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("客户端错误");
		}

	}
	//停止服务
	public void stop() {
		// TODO Auto-generated method stub

	}
}
