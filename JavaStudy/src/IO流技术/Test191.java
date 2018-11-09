package IO流技术;

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
 * commonsIO核心操作
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
	//文件或文件目录大小
	private static void demo1() {
		long len=FileUtils.sizeOf(new File("src/IO流技术/开篇.mp4"));
		System.out.println(len);
		len=FileUtils.sizeOf(new File("src/IO流技术"));
		System.out.println(len);
	}
	/**
	 * 列出子孙级
	 */
	private static void demo2() {
//		Collection<File> files=FileUtils.listFiles(new File("src/IO流技术"),EmptyFileFilter.NOT_EMPTY,null);
//		for(File file:files) {
//			System.out.println(file.getAbsolutePath());
//		}
		
//		Collection<File> files=FileUtils.listFiles(new File("src/IO流技术"),EmptyFileFilter.NOT_EMPTY,DirectoryFileFilter.INSTANCE);
//		for(File file:files) {
//			System.out.println(file.getAbsolutePath());
//		}
		
//		Collection<File> files=FileUtils.listFiles(new File("src/IO流技术"),new SuffixFileFilter("mp4"),DirectoryFileFilter.INSTANCE);
//		for(File file:files) {
//			System.out.println(file.getAbsolutePath());
//		}
		
//		Collection<File> files=FileUtils.listFiles(new File("src/IO流技术"),FileFilterUtils.or(new SuffixFileFilter("mp4"),new SuffixFileFilter("class"),EmptyFileFilter.NOT_EMPTY),DirectoryFileFilter.INSTANCE);
//		for(File file:files) {
//			System.out.println(file.getAbsolutePath());
//		}
		
		Collection<File> files=FileUtils.listFiles(new File("src/IO流技术"),FileFilterUtils.and(new SuffixFileFilter("mp4"),EmptyFileFilter.NOT_EMPTY),DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
	}
	/**
	 * 读取文件
	 * @throws IOException 
	 */
	public static void demo3() throws IOException {
//		String msg=FileUtils.readFileToString(new File("src/IO流技术/Test167.java"),"gbk");
//		System.out.println(msg);
//		byte[] byteArray=FileUtils.readFileToByteArray(new File("src/IO流技术/Test167.java"));
//		System.out.println(byteArray.length);
		
		//逐行读取
//		List<String> msgs=FileUtils.readLines(new File("src/IO流技术/Test167.java"), "gbk");
//		for(String msgTemp:msgs) {
//			System.out.println(msgTemp);
//		}
		
		LineIterator it=FileUtils.lineIterator(new File("src/IO流技术/Test167.java"),"gbk");
		while(it.hasNext()) {
			System.out.println(it.nextLine());
		}

	}
	private static void demo4() throws IOException {
		//写出文件
		FileUtils.write(new File("src/IO流技术/test1.txt"), "喜欢一个人是一种什么样的感觉\n","gbk");
		FileUtils.writeStringToFile(new File("src/IO流技术/test1.txt"), "喜欢一个人是一种什么样的感觉\n","gbk",true);
		FileUtils.writeByteArrayToFile(new File("src/IO流技术/test1.txt"), "喜欢一个人是一种什么样的感觉\n".getBytes("gbk"),true);
		
		//写出列表
		List list=new ArrayList<>();
		list.add("社会工程学");
		list.add("学习");
		FileUtils.writeLines(new File("src/IO流技术/test1.txt"),list,"...",true);

	}
}
