package IO流技术;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * CommonIO拷贝核心操作
 * @author jie
 *
 */
public class Test192 {
	public static void main(String[] args) throws IOException {
		//复制文件
//		FileUtils.copyFile(new File("src/IO流技术/开篇.mp4"), new File("src/IO流技术/Copy开篇.mp4"));
		//拷贝文件到目录
//		FileUtils.copyFileToDirectory(new File("src/IO流技术/开篇.mp4"),new File("lib"));
		//拷贝目录到目录
//		FileUtils.copyDirectoryToDirectory(new File("lib"), new File("src/IO流技术/lib2"));
		//拷贝目录
//		FileUtils.copyDirectory(new File("lib"), new File("src/IO流技术/lib2"));
		//拷贝URL内容
//		String url="http://pic19.nipic.com/20120210/7827303_221233267358_2.jpg";
//		FileUtils.copyURLToFile(new URL(url), new File("src/IO流技术/copyPicture.jpg"));
		String datas=IOUtils.toString(new URL("http://www.163.com"),"gbk");
		System.out.println(datas);
	}
}
