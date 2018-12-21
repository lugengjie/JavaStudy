package 网络编程.Test247;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 使用多线程封装 发送端
 * @author jie
 *
 */
public class Send implements Runnable {
	private BufferedReader br;
	private DataOutputStream dos;
	private boolean isRunning;
	private String name;
	@Override
	public void run() {
		while(isRunning) {
			send(readLine());
		}
	}

	public Send(Socket client,String name) {
		this.br=new BufferedReader(new InputStreamReader(System.in));
		try {
			this.isRunning=true;
			this.name=name;
			this.dos=new DataOutputStream(client.getOutputStream());
			send(name);
			
		} catch (IOException e) {
			System.out.println("-----发送构造器错误-------");
			release();
		}
	}
	public void send(String msg) {
		try {
			if(br!=null) {
				dos.writeUTF(msg);
			}
		} catch (IOException e) {
			System.out.println("-----发送错误-------");
			release();
		}
		
	}
	private String readLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	private void release() {
		this.isRunning=false;
		Utils.close(br,dos);
	}
}
