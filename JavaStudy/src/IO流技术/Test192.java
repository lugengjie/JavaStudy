package IO������;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * CommonIO�������Ĳ���
 * @author jie
 *
 */
public class Test192 {
	public static void main(String[] args) throws IOException {
		//�����ļ�
//		FileUtils.copyFile(new File("src/IO������/��ƪ.mp4"), new File("src/IO������/Copy��ƪ.mp4"));
		//�����ļ���Ŀ¼
//		FileUtils.copyFileToDirectory(new File("src/IO������/��ƪ.mp4"),new File("lib"));
		//����Ŀ¼��Ŀ¼
//		FileUtils.copyDirectoryToDirectory(new File("lib"), new File("src/IO������/lib2"));
		//����Ŀ¼
//		FileUtils.copyDirectory(new File("lib"), new File("src/IO������/lib2"));
		//����URL����
//		String url="http://pic19.nipic.com/20120210/7827303_221233267358_2.jpg";
//		FileUtils.copyURLToFile(new URL(url), new File("src/IO������/copyPicture.jpg"));
		String datas=IOUtils.toString(new URL("http://www.163.com"),"gbk");
		System.out.println(datas);
	}
}
