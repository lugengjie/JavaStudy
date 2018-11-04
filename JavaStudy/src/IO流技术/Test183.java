package IO������;

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
 * ת����
 * InputStreamReader()
 * OutputStreamWriter()
 * ���ֽ���ת��Ϊ�ַ���
 * ָ���ַ���
 * @author jie
 *
 */
public class Test183 {
	public static void main(String[] args) {
		demo1();
	}
	/**
	 * ���������
	 * System.in System.out
	 */
	public static void demo1() {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("src/IO������/baidu.txt"));){
			String line="";
			while((line=br.readLine())!=null) {
				bw.write(line); //ѭ��д��
				bw.newLine();
				bw.flush(); //ǿ��ˢ��
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ������
	 */
	private static  void demo2() {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));){
			//ѭ����ȡ���̵�����(exit�˳�)�����������
			String msg ="";
			while(!msg.equals("exit")) {
				msg = br.readLine(); //ѭ����ȡ
				bw.write(msg); //ѭ��д��
				bw.newLine();
				bw.flush(); //ǿ��ˢ��
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
