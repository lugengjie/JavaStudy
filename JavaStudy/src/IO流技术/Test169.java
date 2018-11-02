package IO流技术;

import java.io.File;

public class Test169 {
	public static void main(String[] args) {
		//demo1();
		//demo2();
		demo3(0);
		
	}
	/**
	 * mkdir:上级目录不存在，创建失败
	 * mkdirs:上级目录可以不存在，不存在一起创建
	 */
	private static void demo1() {
		File file=new File(System.getProperty("user.dir")+"/src/test");
		boolean flag=file.mkdirs();
		System.out.println(flag);
	}
	/**
	 * list():列出下级名称
	 * listFiles():列出下级File对象
	 * listRoots():所有盘符
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
	 * 递归：自己调用自己
	 * 递归头：结束调用
	 * 递归体：重复调用
	 */
	private static void demo3(int n) {
		if(n>10) return;
		System.out.println(n);
		demo3(n+1);
	}
}
