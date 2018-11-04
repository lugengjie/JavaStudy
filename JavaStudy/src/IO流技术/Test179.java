package IO流技术;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO工具类
 * @author jie
 *
 */
public class Test179 {
	public static void main(String[] args) {
		//文件到文件
//		try {
//			InputStream is=new FileInputStream("src/IO流技术/test.txt");
//			OutputStream os=new FileOutputStream("src/IO流技术/test2.txt");
//			copy(is,os);
//			close(is,os);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
		//文件到字节数组
		byte[] datas=null;
		try {
			InputStream is=new FileInputStream("src/IO流技术/03.jpeg");
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			copy(is,os);
			datas=os.toByteArray();
			System.out.println(datas.length);
			close(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//字节数组到文件
		try {
			OutputStream os=new FileOutputStream("src/IO流技术/04.jpeg");
			ByteArrayInputStream is=new ByteArrayInputStream(datas);
			copy(is,os);
			System.out.println(datas.length);
			close(os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 对接输入输出流
	 */
	private static void copy(InputStream is,OutputStream os) {			
		try {
			byte[] datas=new byte[1024];
			int len=-1;
			while((len=is.read(datas))!=-1) {
				os.write(datas, 0, len);
			}
			os.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void close(Closeable... ios) {
		for(Closeable io:ios) {
			try {
				if(null!=io) {
					io.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
