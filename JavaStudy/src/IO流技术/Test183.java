package IO流技术;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 转换流
 * InputStreamReader()
 * OutputStreamWriter()
 * 将字节流转换为字符流
 * 指定字符集
 * @author jie
 *
 */
public class Test183 {
	public static void main(String[] args) {
		demo1();
	}
	/**
	 * 输入输出流
	 * System.in System.out
	 */
	public static void demo1() {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("src/IO流技术/baidu.txt"));){
			String line="";
			while((line=br.readLine())!=null) {
				bw.write(line); //循环写出
				bw.newLine();
				bw.flush(); //强制刷新
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 网络流
	 */
	private static  void demo2() {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));){
			//循环获取键盘的输入(exit退出)，输出此内容
			String msg ="";
			while(!msg.equals("exit")) {
				msg = br.readLine(); //循环读取
				bw.write(msg); //循环写出
				bw.newLine();
				bw.flush(); //强制刷新
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
