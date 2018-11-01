package IO流技术;

import java.io.File;
/**
 * 名称分隔符
 * @author jie
 *
 */
public class Test167 {
	public static void main(String[] args) {
		//_path();
		//_file();
		file_path();
		
	}
	//名称分隔符
	private static void _path(){
		String path="C:\\Users\\jie\\git\\JavaStudy\\JavaStudy\\src\\03.jpeg";
		System.out.println(File.separatorChar);
		//建议，可跨平台
		//1,/
		path="C:/Users/jie/git/JavaStudy/JavaStudy/src/03.jpeg";
		System.out.println(path);
		//2,常量拼接
		path="C:"+File.separator+"Users"+File.separator+"jie"+File.separator+"git"+File.separator+"JavaStudy"+File.separator+"JavaStudy"+File.separator+"src"+File.separator+"03.jpeg";
		System.out.println(path);
	}
	//构建File对象
	private static void _file() {
		File src=new File("C:/Users/jie/git/JavaStudy/JavaStudy/src/03.jpeg");
		src=new File("C:/Users/jie/git","/JavaStudy/JavaStudy/src/03.jpeg");
		src=new File(new File("C:/Users/jie/git/JavaStudy/JavaStudy/src"),"03.jpeg");
		System.out.println(src.length());

	}
	
	private static void file_path() {
		String path="C:/Users/jie/git/JavaStudy/JavaStudy/src/03.jpeg";
		//绝对路径
		File file=new File(path);
		System.out.println(file.getAbsolutePath());
		
		//相对路径
		System.out.println(System.getProperty("user.dir"));
		file=new File("03.jpeg");
		System.out.println(file.getAbsolutePath());
		
		//构建一个不存在的文件
		File file01=new File("04.jpeg");
		System.out.println(file01.getAbsolutePath());

	}
}
