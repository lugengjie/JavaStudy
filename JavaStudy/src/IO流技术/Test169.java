package IO������;

import java.io.File;

public class Test169 {
	public static void main(String[] args) {
		//demo1();
		//demo2();
		demo3(0);
		
	}
	/**
	 * mkdir:�ϼ�Ŀ¼�����ڣ�����ʧ��
	 * mkdirs:�ϼ�Ŀ¼���Բ����ڣ�������һ�𴴽�
	 */
	private static void demo1() {
		File file=new File(System.getProperty("user.dir")+"/src/test");
		boolean flag=file.mkdirs();
		System.out.println(flag);
	}
	/**
	 * list():�г��¼�����
	 * listFiles():�г��¼�File����
	 * listRoots():�����̷�
	 */
	private static void demo2() {
		File file=new File(System.getProperty("user.dir"));
//		String[] subNames=file.list();
//		for(String subName:subNames) {
//			System.out.println(subName);
//		}
		
//		File[] subFiles=file.listFiles();
//		for(File subFile:subFiles) {
//			System.out.println(subFile.getAbsolutePath());
//		}
		
		File[] roots=file.listRoots();
		for(File root:roots) {
			System.out.println(root.getAbsolutePath());
		}
	}
	/**
	 * �ݹ飺�Լ������Լ�
	 * �ݹ�ͷ����������
	 * �ݹ��壺�ظ�����
	 */
	private static void demo3(int n) {
		if(n>10) return;
		System.out.println(n);
		demo3(n+1);
	}
}
