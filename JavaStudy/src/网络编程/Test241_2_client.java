package 网络编程;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

public class Test241_2_client {
	public static void main(String[] args) throws IOException {
		System.out.println("发送方启动中.....");
		//* 1.使用DatagramSocket指定端口 创建发送端
		DatagramSocket client=new DatagramSocket(8888);
		//* 2.准备数据,一定要转成字节数组
		//写出
		byte[] datas=IOUtils.fileToByteArray("src/网络编程/logo.png");
		//* 3.封装成DatagramPacket包裹,需要指定目的地
		DatagramPacket packet=new DatagramPacket(datas, 0,datas.length,new InetSocketAddress("localhost",9999));
		//* 4.发送包裹send(DatagramPacket p)
		client.send(packet);
		//* 5.释放资源
		client.close();
	}
}
