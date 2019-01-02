package 手写Httpserver项目.Test265;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import 手写Httpserver项目.Test261.Response;

/**
 * 目标：加入Servlet,解耦了业务代码
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
			Request request=new Request(client);
			//获取响应协议
			Response response=new Response(client);
			
			Servlet servlet = null;
			if(request.getUrl().equals("login")) {
				servlet=new LoginServlet();
			}else if(request.getUrl().equals("reg")) {
				servlet=new RegisterServlet();
			}
			servlet.service(request, response);
			response.pushToBrowser(200);
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
