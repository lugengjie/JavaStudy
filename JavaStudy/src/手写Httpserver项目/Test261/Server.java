package 手写Httpserver项目.Test261;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标：封装响应信息
 * 1.内容可以动态拼接
 * 2.关注状态码，拼接好响应的协议信息
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
			
			
			//返回
			//1.响应行：
			//2、响应头(最后一行存在空行):
			/*
			 Date:Mon,31Dec209904:25:57GMT
			Server:shsxt Server/0.0.1;charset=GBK
			Content-type:text/html
			Content-length:39725426
			 */
			//3.正文
			Response response=new Response(client);
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");
			response.print("服务器响应成功");
			response.print("</title>");
			response.print("</head>");
			response.print("<body>");
			response.print("shsxt server终于回来了。。。。");
			response.print("</body>");
			response.print("</html>");
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
