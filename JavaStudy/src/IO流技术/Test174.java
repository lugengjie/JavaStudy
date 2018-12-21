package IO流技术;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO文件字节流
 * 创建源
 * 选择流
 * 操作
 * 释放资源
 * @author jie
 *
 */
public class Test174 {
	public static void main(String[] args) {
//		input();
		output();
	}
	private static void input() {
		File file=new File(System.getProperty("user.dir")+"/src/IO流技术/test.txt");
		InputStream is=null;
		try {
			is=new FileInputStream(file);
			byte[] car=new byte[1024]; //缓存容器
			int len=-1;
			while(-1!=(len=is.read(car))) {
				//字节数组->字符串（解码）
				System.out.print(new String(car,0,len));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	private static void output() {
		File file=new File(System.getProperty("user.dir")+"/src/IO流技术/test2.txt");
		OutputStream os=null;
		try {
			//FileOutputStream(xx,true) 覆盖
			//FileOutputStream(xx,true) 追加
			os=new FileOutputStream(file,true);
			String msg="你好啊 今天天气好好啊";
			//字符串-->字符数组（编码）
			byte[] datas=msg.getBytes();
			os.write(datas,0,datas.length);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=os) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


