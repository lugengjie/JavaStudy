package IO流技术;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 字节缓冲流
 * @author jie
 *
 */
public class Test181 {
	public static void main(String[] args) {
		//加字节缓冲流 输出118ms
		long t1=System.currentTimeMillis();
		copy1("src/IO流技术/166_IO_开篇.mp4","src/IO流技术/开篇.mp4");
		long t2=System.currentTimeMillis();
		System.out.println(t2-t1);
		
		//不加字节缓冲流 输出360ms
//		long t1=System.currentTimeMillis();
//		copy2("src/IO流技术/166_IO_开篇.mp4","src/IO流技术/开篇.mp4");
//		long t2=System.currentTimeMillis();
//		System.out.println(t2-t1);
		
	}
	//加字节缓冲流
	private static void copy1(String srcPath,String destPath) {
		try (InputStream is=new BufferedInputStream(new FileInputStream(srcPath));
			OutputStream os=new BufferedOutputStream(new FileOutputStream(destPath));){
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
	//不加字节缓冲流
	private static void copy2(String srcPath,String destPath) {
		try (InputStream is=new FileInputStream(srcPath);
			OutputStream os=new FileOutputStream(destPath);){
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
}
