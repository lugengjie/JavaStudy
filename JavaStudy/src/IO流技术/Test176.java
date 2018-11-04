package IO������;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * IO�ļ��ַ���
 * ����Դ
 * ѡ����
 * ����
 * �ͷ���Դ
 * @author jie
 *
 */
public class Test176 {
	public static void main(String[] args) {
//		input();
		output();
	}
	private static void input() {
		File file=new File(System.getProperty("user.dir")+"/src/IO������/test.txt");
		Reader reader=null;
		try {
			reader=new FileReader(file);
			char[] car=new char[1024]; //��������
			int len=-1;
			while(-1!=(len=reader.read(car))) {
				//�ֽ�����->�ַ��������룩
				System.out.print(new String(car,0,len));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=reader) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	private static void output() {
		File file=new File(System.getProperty("user.dir")+"/src/IO������/test2.txt");
		Writer writer=null;
		try {
			//FileOutputStream(xx,true) ����
			//FileOutputStream(xx,true) ׷��
			writer=new FileWriter(file,true);
			String msg="��ð� ���������úð�";
			//�ַ���-->�ַ����飨���룩
//			char[] datas=msg.toCharArray();
//			writer.write(datas,0,datas.length);
			
//			writer.write(msg);
			
			writer.append("haha").append("jsjdfas");
			writer.flush();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=writer) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


