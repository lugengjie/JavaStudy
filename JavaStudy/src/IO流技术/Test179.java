package IO������;

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
 * IO������
 * @author jie
 *
 */
public class Test179 {
	public static void main(String[] args) {
		//�ļ����ļ�
//		try {
//			InputStream is=new FileInputStream("src/IO������/test.txt");
//			OutputStream os=new FileOutputStream("src/IO������/test2.txt");
//			copy(is,os);
//			close(is,os);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
		//�ļ����ֽ�����
		byte[] datas=null;
		try {
			InputStream is=new FileInputStream("src/IO������/03.jpeg");
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			copy(is,os);
			datas=os.toByteArray();
			System.out.println(datas.length);
			close(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//�ֽ����鵽�ļ�
		try {
			OutputStream os=new FileOutputStream("src/IO������/04.jpeg");
			ByteArrayInputStream is=new ByteArrayInputStream(datas);
			copy(is,os);
			System.out.println(datas.length);
			close(os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �Խ����������
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
