package IO������;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO�ļ�����
 * @author jie
 *
 */
public class Test175 {
	public static void main(String[] args) {
		copy("src/IO������/03.jpeg","src/IO������/02.jpeg");
	}
	private static void copy(String res,String dec) {
		File resFile=new File(res);
		File decFile=new File(dec);
		InputStream is=null;
		OutputStream os=null;
		
		try {
			is=new FileInputStream(resFile);
			os=new FileOutputStream(decFile);
	
			byte[] datas=new byte[1024];
			int len=-1;
			while((len=is.read(datas))!=-1) {
				os.write(datas, 0, len);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ȴ򿪵ĺ�رգ���򿪵��ȹر�
			if(null!=os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(null!=is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		

	}
}
