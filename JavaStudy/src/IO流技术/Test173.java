package IO流技术;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * IO标准步骤
 * @author jie
 *
 */
public class Test173 {
	public static void main(String[] args) {
		//demo1();
		demo2();
	}
	public static void demo1() {
		//创建源
		File file=new File(System.getProperty("user.dir")+"/src/IO流技术/test.txt");
		
		try {
			//选择流
			InputStream is=new FileInputStream(file);
			//操作
			//读取第一个字节
			int data=is.read();
			System.out.println((char)data);
			//读取第二个字节
			data=is.read();
			System.out.println((char)data);
			//读到文件尾返回-1
			data=is.read();
			System.out.println(data);
			//通知操作系统可以释放资源了
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 对demo1的优化
	 */
	private static void demo2() {
		//创建源
		File file=new File(System.getProperty("user.dir")+"/src/IO流技术/test.txt");
		InputStream is=null;
		try {
			//选择流
			is=new FileInputStream(file);
			int temp;
			while(-1!=(temp=is.read())) {
				System.out.println((char)temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(null!=is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
