package IO������;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 * �����
 * @author jie
 *
 */
public class Test187 {
	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
		demo3();
	}
	
	/**
	 * ָ�� ���λ�ö�ȡʣ����������
	 * @throws IOException 
	 */
	private static void demo1() throws IOException {
		RandomAccessFile raf=new RandomAccessFile("src/IO������/Test186.java","r");
		raf.seek(2);
		int len=-1;
		byte[] flush=new byte[1024];
		while((len=raf.read(flush))!=-1) {
			System.out.println(new String(flush,0,len));
		}
	}
	/**
	 * �ֿ�˼�룬��ʼ��ʵ�ʴ�С
	 * @throws IOException
	 */
	private static void demo2() throws IOException {
		RandomAccessFile raf=new RandomAccessFile("src/IO������/Test186.java","r");
		int beginPos=2;
		int actualSize=1026;
		raf.seek(beginPos);
		int len=-1;
		byte[] flush=new byte[1024];
		while((len=raf.read(flush))!=-1) {
			if(actualSize>beginPos) {
				System.out.println(new String(flush,0,len));	
				actualSize-=len;
			}else {
				System.out.println(new String(flush,0,actualSize));
				break;
			}
			
		}
	}
	private static void demo3() {
		File file=new File("src/IO������/Test186.java");
		//�ܳ���
		long len=file.length();
		//ÿ���С
		int blockSize=1024;
		//���ٿ�
		int num=(int) Math.ceil(len*1.0/blockSize);
		//��ʼλ��
		int beginPos=0;
		
		int actualSize=0;
		
		for(int i=0;i<num;i++) {
			beginPos=i*blockSize;
			if(i==(num-1)) {
				actualSize=(int) len;
			}else {
				actualSize=blockSize;
				len-=actualSize;
			}
			System.out.println("��"+i+"��,��ʼλ��:"+beginPos+"���С:"+actualSize);
		}
		
	}
}
