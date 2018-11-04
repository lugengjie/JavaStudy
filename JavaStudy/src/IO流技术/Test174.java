package IO������;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO�ļ��ֽ���
 * ����Դ
 * ѡ����
 * ����
 * �ͷ���Դ
 * @author jie
 *
 */
public class Test174 {
	public static void main(String[] args) {
//		input();
		output();
	}
	private static void input() {
		File file=new File(System.getProperty("user.dir")+"/src/IO������/test.txt");
		InputStream is=null;
		try {
			is=new FileInputStream(file);
			byte[] car=new byte[1024]; //��������
			int len=-1;
			while(-1!=(len=is.read(car))) {
				//�ֽ�����->�ַ��������룩
				System.out.print(new String(car,0,len));
			}
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
		
	}
	private static void output() {
		File file=new File(System.getProperty("user.dir")+"/src/IO������/test2.txt");
		OutputStream os=null;
		try {
			//FileOutputStream(xx,true) ����
			//FileOutputStream(xx,true) ׷��
			os=new FileOutputStream(file,true);
			String msg="��ð� ���������úð�";
			//�ַ���-->�ַ����飨���룩
			byte[] datas=msg.getBytes();
			os.write(datas,0,datas.length);
			os.flush();
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


