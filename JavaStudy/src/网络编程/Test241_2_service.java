package 网络编程;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

public class Test241_2_service {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("接收方启动中....");
		//* 1.使用DatagramSocket指定端口 创建接收端
		DatagramSocket server=new DatagramSocket(9999);
		//* 2.准备容器封装成DatagramPacket包裹
		byte[] container=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(container, 0,container.length);
		//* 3.阻塞式接收包裹receive(DatagramPacket p)
		server.receive(packet);
		//* 4.分析数据
		//* byte[] getData()
		//* 	   getLength()
		byte[] datas=packet.getData();
		int len=packet.getLength();
		IOUtils.byteArrayToFile(datas, "src/网络编程/logo2.png");
		//* 5.释放资源
		server.close();
	}
}
