package IO������;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * �ֽڻ�����
 * @author jie
 *
 */
public class Test181 {
	public static void main(String[] args) {
		//���ֽڻ����� ���118ms
		long t1=System.currentTimeMillis();
		copy1("src/IO������/166_IO_��ƪ.mp4","src/IO������/��ƪ.mp4");
		long t2=System.currentTimeMillis();
		System.out.println(t2-t1);
		
		//�����ֽڻ����� ���360ms
//		long t1=System.currentTimeMillis();
//		copy2("src/IO������/166_IO_��ƪ.mp4","src/IO������/��ƪ.mp4");
//		long t2=System.currentTimeMillis();
//		System.out.println(t2-t1);
		
	}
	//���ֽڻ�����
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
	//�����ֽڻ�����
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
