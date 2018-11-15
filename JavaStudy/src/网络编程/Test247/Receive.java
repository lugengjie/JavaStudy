package ������.Test247;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * ʹ�ö��̷߳�װ���ն�
 * @author jie
 *
 */
public class Receive implements Runnable {
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;
	public Receive(Socket client) {
		this.client=client;
		try {
			this.isRunning=true;
			this.dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			System.out.println("--------����������--------");
			release();
		}
	}
	@Override
	public void run() {
		while(isRunning) {
			String msg=receive();
			if(msg!=null) {
				System.out.println(msg);
			}
		}
	}
	
	private String receive() {
		String msg="";
		try {
			msg=this.dis.readUTF();
		} catch (IOException e) {
			System.out.println("--------���մ���--------");
			release();
		}
		return msg;
	}
	private void release() {
		this.isRunning=false;
		Utils.close(dis,client);

	}

}
