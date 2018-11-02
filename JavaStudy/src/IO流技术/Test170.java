package IO������;

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
	 * �����ļ���С���ļ��������ļ��и���
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
	 * ��ӡ�ļ���С���ļ��������ļ��и���
	 */
	public void printFile1(File file) {
		doFile(file);
		System.out.println("�ļ���С:"+length);
		System.out.println("�ļ�����"+fileNum);
		System.out.println("�ļ��и���"+dirNum);
	}
	/**
	 * �ݹ��ӡ���ＶĿ¼���ļ���
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
