package 网络编程.Test248;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

import 网络编程.Test247.Utils;

/**
 * 在线聊天室：服务器
 * 目标：加入容器，实现群聊
 * @author jie
 *
 */
public class TMultiChat {
	private static CopyOnWriteArrayList<Channel> others=new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		System.out.println("------Service------");
		// * 1.指定端口 使用ServiceSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		// * 2.阻塞式等待连接 accept
		while(true) {
			Socket client = server.accept();
			System.out.println("一个客户端连接");
			Channel c=new Channel(client);
			others.add(c);
			new Thread(c).start();
		}
	}
	//一个客户端代表一个Channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		private String name;
		
		@Override
		public void run() {
			while(isRunning) {
				String msg=receive();
				if(msg!=null) {
					sendOthers(msg);
				}
			}
			
		}
		public Channel(Socket client) {
			this.client = client;
			try {
				this.dis=new DataInputStream(client.getInputStream());
				this.dos=new DataOutputStream(client.getOutputStream());
				//获取名称
				this.name=receive();
				this.isRunning=true;
				//欢迎您的到来
				send("欢迎您的到来");
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
		/**
		 * 群聊：获取自己的消息，发给其他人
		 */
		private void sendOthers(String msg) {
			for(Channel other:others) {
				if(other==this) {
					continue;
				}else {
					other.send(this.name+"对所有人说："+msg);
				}
			}
		}
		//释放资源
		private void release() {
			this.isRunning=false;
			Utils.close(dos,dis,client);
		}
		
	}
}
