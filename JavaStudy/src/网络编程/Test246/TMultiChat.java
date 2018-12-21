package 网络编程.Test246;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器
 * 目标：实现一个客户可以正常收发消息
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
			new Thread(()-> {
				DataInputStream dis=null;
				DataOutputStream dos=null;
				boolean isRunning=true;
				try {
					System.out.println("一个客户端建立连接");
					//3.接收消息
					dis=new DataInputStream(client.getInputStream());	
					dos=new DataOutputStream(client.getOutputStream());
					
					while(isRunning) {
						String msg=dis.readUTF();
						dos.writeUTF(msg);
						dos.flush();
					}
				} catch (IOException e) {
					isRunning = false; //停止线程
					e.printStackTrace();
				}
				//4.释放资源
				try {
					if(null==dos) {
						dos.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(null==dis) {
						dis.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					if(null==client) {
						client.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
