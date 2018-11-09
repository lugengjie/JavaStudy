package IO������;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
/**
 * commonsIO���Ĳ���
 * @author jie
 *
 */
public class Test191 {

	public static void main(String[] args) throws IOException {
//		demo1();
//		demo2();
//		demo3();
		demo4();
		
		
	}
	//�ļ����ļ�Ŀ¼��С
	private static void demo1() {
		long len=FileUtils.sizeOf(new File("src/IO������/��ƪ.mp4"));
		System.out.println(len);
		len=FileUtils.sizeOf(new File("src/IO������"));
		System.out.println(len);
	}
	/**
	 * �г����Ｖ
	 */
	private static void demo2() {
//		Collection<File> files=FileUtils.listFiles(new File("src/IO������"),EmptyFileFilter.NOT_EMPTY,null);
//		for(File file:files) {
//			System.out.println(file.getAbsolutePath());
//		}
		
//		Collection<File> files=FileUtils.listFiles(new File("src/IO������"),EmptyFileFilter.NOT_EMPTY,DirectoryFileFilter.INSTANCE);
//		for(File file:files) {
//			System.out.println(file.getAbsolutePath());
//		}
		
//		Collection<File> files=FileUtils.listFiles(new File("src/IO������"),new SuffixFileFilter("mp4"),DirectoryFileFilter.INSTANCE);
//		for(File file:files) {
//			System.out.println(file.getAbsolutePath());
//		}
		
//		Collection<File> files=FileUtils.listFiles(new File("src/IO������"),FileFilterUtils.or(new SuffixFileFilter("mp4"),new SuffixFileFilter("class"),EmptyFileFilter.NOT_EMPTY),DirectoryFileFilter.INSTANCE);
//		for(File file:files) {
//			System.out.println(file.getAbsolutePath());
//		}
		
		Collection<File> files=FileUtils.listFiles(new File("src/IO������"),FileFilterUtils.and(new SuffixFileFilter("mp4"),EmptyFileFilter.NOT_EMPTY),DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
	}
	/**
	 * ��ȡ�ļ�
	 * @throws IOException 
	 */
	public static void demo3() throws IOException {
//		String msg=FileUtils.readFileToString(new File("src/IO������/Test167.java"),"gbk");
//		System.out.println(msg);
//		byte[] byteArray=FileUtils.readFileToByteArray(new File("src/IO������/Test167.java"));
//		System.out.println(byteArray.length);
		
		//���ж�ȡ
//		List<String> msgs=FileUtils.readLines(new File("src/IO������/Test167.java"), "gbk");
//		for(String msgTemp:msgs) {
//			System.out.println(msgTemp);
//		}
		
		LineIterator it=FileUtils.lineIterator(new File("src/IO������/Test167.java"),"gbk");
		while(it.hasNext()) {
			System.out.println(it.nextLine());
		}

	}
	private static void demo4() throws IOException {
		//д���ļ�
		FileUtils.write(new File("src/IO������/test1.txt"), "ϲ��һ������һ��ʲô���ĸо�\n","gbk");
		FileUtils.writeStringToFile(new File("src/IO������/test1.txt"), "ϲ��һ������һ��ʲô���ĸо�\n","gbk",true);
		FileUtils.writeByteArrayToFile(new File("src/IO������/test1.txt"), "ϲ��һ������һ��ʲô���ĸо�\n".getBytes("gbk"),true);
		
		//д���б�
		List list=new ArrayList<>();
		list.add("��Ṥ��ѧ");
		list.add("ѧϰ");
		FileUtils.writeLines(new File("src/IO������/test1.txt"),list,"...",true);

	}
}
