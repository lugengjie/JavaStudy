package 网络编程.Test245;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登陆  双向
 * 创建服务器
 * 1.指定端口 使用ServerSocket创建服务器
 * 2.阻塞式等待连接 accept
 * 3.操作：输入输出操作
 * 4.释放资源
 * @author jie
 *
 */
public class LoginMultiService {
	public static void main(String[] args) throws IOException {
		System.out.println("------Service------");
		// * 1.指定端口 使用ServiceSocket创建服务器
		ServerSocket server=new ServerSocket(8888);
		while(true) {
			// * 2.阻塞式等待连接 accept
			Socket client=server.accept();
			new Thread(new Channel(client)).start();
		}

	}
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		public Channel(Socket client) {
			this.client=client;
			try {
				this.dis=new DataInputStream(client.getInputStream());
				this.dos=new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				release();
			};
		}
		@Override
		public void run() {
			// *分析
			String[] dataArray=receive().split("&");
			String uname=null;
			String upw=null;
			for(String info:dataArray) {
				String[] msg=info.split("=");
				if(msg[0].equals("uname")) {
					uname=msg[1];
					System.out.println("用户名："+msg[1]);
				}else {
					upw=msg[1];
					System.out.println("密码："+msg[1]);
				}
			}
			
			if(uname.equals("a")&&upw.equals("a")) {
				send("登陆成功");
			}else {
				send("登陆失败");	
			}
			// * 4.释放资源
			release();
		}
		private String receive() {
			String data="";
			try {
				data=dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return data;
		}
		
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		private void release() {
			try {
				if(dis!=null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(dos!=null) {
					dos.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if(client!=null) {
					client.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

