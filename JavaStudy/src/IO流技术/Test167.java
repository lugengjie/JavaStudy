package IO������;

import java.io.File;
/**
 * ���Ʒָ���
 * @author jie
 *
 */
public class Test167 {
	public static void main(String[] args) {
		//_path();
		//_file();
		file_path();
		
	}
	//���Ʒָ���
	private static void _path(){
		String path="C:\\Users\\jie\\git\\JavaStudy\\JavaStudy\\src\\03.jpeg";
		System.out.println(File.separatorChar);
		//���飬�ɿ�ƽ̨
		//1,/
		path="C:/Users/jie/git/JavaStudy/JavaStudy/src/03.jpeg";
		System.out.println(path);
		//2,����ƴ��
		path="C:"+File.separator+"Users"+File.separator+"jie"+File.separator+"git"+File.separator+"JavaStudy"+File.separator+"JavaStudy"+File.separator+"src"+File.separator+"03.jpeg";
		System.out.println(path);
	}
	//����File����
	private static void _file() {
		File src=new File("C:/Users/jie/git/JavaStudy/JavaStudy/src/03.jpeg");
		src=new File("C:/Users/jie/git","/JavaStudy/JavaStudy/src/03.jpeg");
		src=new File(new File("C:/Users/jie/git/JavaStudy/JavaStudy/src"),"03.jpeg");
		System.out.println(src.length());

	}
	
	private static void file_path() {
		String path="C:/Users/jie/git/JavaStudy/JavaStudy/src/03.jpeg";
		//����·��
		File file=new File(path);
		System.out.println(file.getAbsolutePath());
		
		//���·��
		System.out.println(System.getProperty("user.dir"));
		file=new File("03.jpeg");
		System.out.println(file.getAbsolutePath());
		
		//����һ�������ڵ��ļ�
		File file01=new File("04.jpeg");
		System.out.println(file01.getAbsolutePath());

	}
}
