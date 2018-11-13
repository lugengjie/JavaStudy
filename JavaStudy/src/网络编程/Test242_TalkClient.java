package 网络编程;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端
 * 1.使用DatagramSocket指定端口 创建发送端
 * 2.准备数据,一定要转成字节数组
 * 3.封装成DatagramPacket包裹,需要指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 * @author jie
 *
 */
public class Test242_TalkClient {
	public static void main(String[] args) throws IOException {
		System.out.println("发送端启动中.....");
		//*1.使用DatagramSocket指定端口 创建发送端
		DatagramSocket client=new DatagramSocket(8888);
		//* 2.准备数据,一定要转成字节数组
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String data=br.readLine();
			byte[] datas=data.getBytes();
			//* 3.封装成DatagramPacket包裹,需要指定目的地
			DatagramPacket packet=new DatagramPacket(datas, 0,datas.length,new InetSocketAddress("localhost",9999));
			//*4.发送包裹send(DatagramPacket p)
			client.send(packet);
			if(data.equals("bye")) {
				break;
			}
		}
		//* 5.释放资源
		client.close();
	}
}
