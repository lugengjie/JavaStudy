package IO流技术;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 打印流
 * PrintStream
 * PrintWriter
 * @author jie
 *
 */
public class Test186 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps=System.out;
		ps.print("你好");
		
		ps=new PrintStream(new BufferedOutputStream(new FileOutputStream("src/IO流技术/printStream.txt")),true);
		ps.print("今天天气好好啊");
		
		//重定向输出端
		System.setOut(ps);
		System.out.println("change");
		ps.close();
		//重定向回控制台
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("I am back");
		
	}
}
