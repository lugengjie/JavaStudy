package IO������;

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
 * �Խ���
 * @author jie
 *
 */
public class Test178 {
	public static void main(String[] args) {
		byte[] flush=fileToByteArray("src/IO������/03.jpeg");
		byteArrayToFile(flush,"src/IO������/04.jpeg");
	}
	/**
	 * ͼƬ��ȡ���ֽ�����
	 * 1��ͼƬ������InputSteam
	 * 2)�����ֽ�����ByteArrayOutputStream
	 */
	private static byte[] fileToByteArray(String filePath) {
		File file=new File(filePath);
		InputStream is=null;
		ByteArrayOutputStream baos=null;
		try {
			is=new FileInputStream(file);
			baos=new ByteArrayOutputStream();
			byte[] flush=new byte[1024]; //��������
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
	 * �ֽ�����д���ļ�
	 * 1���ֽ����鵽���� ByteArrayInputStream
	 * 2�������ļ� OutputStream
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
