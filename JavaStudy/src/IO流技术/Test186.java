package IO������;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * ��ӡ��
 * PrintStream
 * PrintWriter
 * @author jie
 *
 */
public class Test186 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps=System.out;
		ps.print("���");
		
		ps=new PrintStream(new BufferedOutputStream(new FileOutputStream("src/IO������/printStream.txt")),true);
		ps.print("���������úð�");
		
		//�ض��������
		System.setOut(ps);
		System.out.println("change");
		ps.close();
		//�ض���ؿ���̨
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		System.out.println("I am back");
		
	}
}
