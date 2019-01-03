package 手写Httpserver项目.Test266;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import 手写Httpserver项目.Test261.Response;

/**
 * 目标：整合配置文件
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
			Servlet servlet=WebApp.getServletFromUrl(request.getUrl());
			
			if(null!=servlet) {
				servlet.service(request, response);
				//关注了状态码
				response.pushToBrowser(200);
			}else{
				//错误...
				response.pushToBrowser(404);
			}		
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
