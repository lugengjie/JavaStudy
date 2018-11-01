package IO������;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author jie
 *
 */
public class Test168 {
	public static void main(String[] args) {
		//demo01();
		//demo02();
		//demo03();
		 demo04();
	}
	/**
	 * getName()
	 * getPath() ���Ի����
	 * getAbsolutePath()
	 * getParent()
	 * getParentFile()
	 */

	private static void demo01() {
		File file=new File("C:/Users/jie/git/JavaStudy/JavaStudy/src/03.jpeg");
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParent());
		System.out.println(file.getParentFile().getName());
	}
	/**
	 * �ļ�״̬
	 * exist()
	 * ����
	 * isFile()
	 * isDirectory()
	 */
	private static void demo02() {
		File file=new File("src");
		if(null!=file&&file.exists()) {
			System.out.println("�ļ�����");
			if(file.isFile()) {
				System.out.println("�ļ�");
			}
			if(file.isDirectory()) {
				System.out.println("�ļ���");
			}
		}else {
			System.out.println("�ļ�������");
		}
	}
	/**
	 * length()
	 * Ŀ¼���޴��ļ�����0
	 */
	private static void demo03() {
		File file1=new File("C:/Users/jie/git/JavaStudy/JavaStudy/src/03.jpeg");
		File file2=new File("C:/Users/jie/git/JavaStudy/JavaStudy/src/04.jpeg");
		System.out.println(file1.length());
		System.out.println(file2.length());

	}
	/**
	 * createFile() �����ڲŴ���,���ڴ���ʧ��
	 * delete()
	 * @throws IOException 
	 */
	private static void demo04(){
//		File file1=new File("D:/NaNa/test.txt");
//		boolean flag = false;
//		try {
//			flag = file1.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(flag);
//		flag=file1.delete();
//		System.out.println(flag);
		
		//������׺����������׺���ļ��������ļ���
//		File file2=new File("D:/NaNa/test");
//		try {
//			file2.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		file2.delete();
		
		//����com3,cn,com3.....����ϵͳ�豸�����ܴ���
		File file3=new File("D:/NaNa/com3");
		boolean flag=false;
		try {
			flag=file3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(flag);
		file3.delete();

	}
}
