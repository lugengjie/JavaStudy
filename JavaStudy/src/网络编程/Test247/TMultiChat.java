package 网络编程.Test247;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器
 * 目标：封装使用多线程实现多个用户可以正常收发多条消息
 * @author jie
 *
 */
public class TMultiChat {
	public static void main(String[] args) throws IOException {
		System.out.println("------Service------");
		// * 1.指定端口 使用ServiceSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		// * 2.阻塞式等待连接 accept
		while(true) {
			Socket client = server.accept();
			new Thread(new Channel(client)).start();
		}
	}
	//一个客户端代表一个Channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		
		@Override
		public void run() {
			while(isRunning) {
				String msg=receive();
				if(msg!=null) {
					send(msg);
				}
			}
			
		}
		public Channel(Socket client) {
			this.client = client;
			try {
				this.dis=new DataInputStream(client.getInputStream());
				this.dos=new DataOutputStream(client.getOutputStream());
				this.isRunning=true;
			} catch (IOException e) {
				System.out.println("------构造器------");
				release();
			}	
			
		}
		//接收消息
		private String receive() {
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				System.out.println("------接收------");
				release();
			}
			return msg;
		}
		//发送消息
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				System.out.println("------发送------");
				release();
			}
			

		}
		//释放资源
		private void release() {
			this.isRunning=false;
			Utils.close(dos,dis,client);
		}
		
	}
}
