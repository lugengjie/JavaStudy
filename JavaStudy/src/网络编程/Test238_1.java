package 网络编程;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 爬虫原理
 * @author jie
 *
 */
public class Test238_1 {
	public static void main(String[] args) throws Exception {
		//获取URL
		URL url=new URL("https://www.jd.com");
		//下载资源
		InputStream is=url.openStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String msg=null;
		while((msg=br.readLine())!=null){
			System.out.println(msg);
		}
	}
}
