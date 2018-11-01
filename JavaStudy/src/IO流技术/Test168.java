package IO流技术;

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
	 * getPath() 绝对或相对
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
	 * 文件状态
	 * exist()
	 * 存在
	 * isFile()
	 * isDirectory()
	 */
	private static void demo02() {
		File file=new File("src");
		if(null!=file&&file.exists()) {
			System.out.println("文件存在");
			if(file.isFile()) {
				System.out.println("文件");
			}
			if(file.isDirectory()) {
				System.out.println("文件夹");
			}
		}else {
			System.out.println("文件不存在");
		}
	}
	/**
	 * length()
	 * 目录或无此文件返回0
	 */
	private static void demo03() {
		File file1=new File("C:/Users/jie/git/JavaStudy/JavaStudy/src/03.jpeg");
		File file2=new File("C:/Users/jie/git/JavaStudy/JavaStudy/src/04.jpeg");
		System.out.println(file1.length());
		System.out.println(file2.length());

	}
	/**
	 * createFile() 不存在才创建,存在创建失败
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
		
		//不带后缀创建不带后缀的文件，不是文件夹
//		File file2=new File("D:/NaNa/test");
//		try {
//			file2.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		file2.delete();
		
		//补充com3,cn,com3.....操作系统设备名不能创建
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
