package IO流技术;

import java.io.File;

/**
 * @author jie
 */
public class Test170 {
	public static void main(String[] args) {
		File file=new File(System.getProperty("user.dir"));
		DoFile doFile=new DoFile();
		doFile.printFile1(file);
	}
	
}
class DoFile{
	private int length;
	private int fileNum;
	private int dirNum=-1;
	

	/**
	 * 计算文件大小，文件个数，文件夹个数
	 */
	public void doFile(File file) {
		if(null==file||!file.exists()) {
			return;
		}else if(file.isDirectory()){
			dirNum++;
			for(File temp:file.listFiles()) {
				doFile(temp);
			}
		}else if(file.isFile()) {
			length+=file.length();
			fileNum++;
		}
	}
	/**
	 * 打印文件大小，文件个数，文件夹个数
	 */
	public void printFile1(File file) {
		doFile(file);
		System.out.println("文件大小:"+length);
		System.out.println("文件个数"+fileNum);
		System.out.println("文件夹个数"+dirNum);
	}
	/**
	 * 递归打印子孙级目录和文件名
	 */
	public static void printFile2(File file,int deep) {
		for(int i=0;i<deep;i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());
		if(null==file||!file.exists()) {  
			return;
		}else if(file.isDirectory()){
			for(File temp:file.listFiles()) {
				printFile2(temp,deep+1);
			}
		}

	}
	
}
