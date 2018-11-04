package IO流技术;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;

/**
 * IO字节数组流
 * 创建源
 * 选择流
 * 操作
 * 释放资源
 * @author jie
 *
 */
public class Test177 {
	public static void main(String[] args) {
//		input();
		output();
	}
	/**
	 * 字节数组输入流：ByteArrayInputStream
	 * 创建源：字节数组不要太大
	 * 选择流
	 * 操作
	 * 释放资源：交给JVM,不用处理
	 */
	private static void input() {
		byte[] datas="talk is cheap show me the code".getBytes();
		InputStream input=null;
		try {
			input=new ByteArrayInputStream(datas);
			byte[] car=new byte[1024]; //缓存容器
			int len=-1;
			while(-1!=(len=input.read(car))) {
				//字节数组->字符串（解码）
				System.out.print(new String(car,0,len));
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=input) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 字节数组输入流：ByteArrayOutputStream
	 * 创建源：JVM维护
	 * 选择流：不关联源
	 * 操作：
	 * 释放资源：交给JVM,不用处理
	 * 获取数据：toByteArray()  
	 */
	private static void output() {
		//创建源
		byte[] dest=null;
		//选择流
		ByteArrayOutputStream output=null;
		try {
			output=new ByteArrayOutputStream();
			//操作（写出）
			output.write("talk is cheap show me the code".getBytes());
			output.flush();
			//获取数据
			dest=output.toByteArray();
			System.out.println(dest.length+"-->"+new String(dest,0,dest.length));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=output) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


