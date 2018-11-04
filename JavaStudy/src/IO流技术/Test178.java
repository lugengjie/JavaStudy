package IO流技术;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 对接流
 * @author jie
 *
 */
public class Test178 {
	public static void main(String[] args) {
		byte[] flush=fileToByteArray("src/IO流技术/03.jpeg");
		byteArrayToFile(flush,"src/IO流技术/04.jpeg");
	}
	/**
	 * 图片读取到字节数组
	 * 1）图片到程序InputSteam
	 * 2)程序到字节数组ByteArrayOutputStream
	 */
	private static byte[] fileToByteArray(String filePath) {
		File file=new File(filePath);
		InputStream is=null;
		ByteArrayOutputStream baos=null;
		try {
			is=new FileInputStream(file);
			baos=new ByteArrayOutputStream();
			byte[] flush=new byte[1024]; //缓存容器
			int len=-1;
			while(-1!=(len=is.read(flush))) {
				baos.write(flush, 0, len);
			}
			baos.flush();
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 字节数组写到文件
	 * 1）字节数组到程序 ByteArrayInputStream
	 * 2）程序到文件 OutputStream
	 */
	
	private static void byteArrayToFile(byte[] src,String filePath) {
		File file=new File(filePath);
		OutputStream os=null;
		InputStream is=null;
		try {
			os=new FileOutputStream(file);
			is=new ByteArrayInputStream(src);
			int len=-1;
			byte[] flush=new byte[1024];
			while((len=is.read(flush))!=-1) {
				os.write(flush, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=os) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
