package IO������;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * IO��׼����
 * @author jie
 *
 */
public class Test173 {
	public static void main(String[] args) {
		//demo1();
		demo2();
	}
	public static void demo1() {
		//����Դ
		File file=new File(System.getProperty("user.dir")+"/src/IO������/test.txt");
		
		try {
			//ѡ����
			InputStream is=new FileInputStream(file);
			//����
			//��ȡ��һ���ֽ�
			int data=is.read();
			System.out.println((char)data);
			//��ȡ�ڶ����ֽ�
			data=is.read();
			System.out.println((char)data);
			//�����ļ�β����-1
			data=is.read();
			System.out.println(data);
			//֪ͨ����ϵͳ�����ͷ���Դ��
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��demo1���Ż�
	 */
	private static void demo2() {
		//����Դ
		File file=new File(System.getProperty("user.dir")+"/src/IO������/test.txt");
		InputStream is=null;
		try {
			//ѡ����
			is=new FileInputStream(file);
			int temp;
			while(-1!=(temp=is.read())) {
				System.out.println((char)temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
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
