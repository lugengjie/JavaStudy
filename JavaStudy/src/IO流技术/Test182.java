package IO流技术;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 字符缓冲流
 * @author jie
 *
 */
public class Test182 {
	public static void main(String[] args) {	
		copy("src/IO流技术/test.txt","src/IO流技术/test1.txt");
	
	}
	
	private static void copy(String srcPath,String destPath) {
		try (BufferedReader br=new BufferedReader(new FileReader(srcPath));
			BufferedWriter bw=new BufferedWriter(new FileWriter(destPath));){
			String line=null;
			while((line=br.readLine())!=null) {
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
