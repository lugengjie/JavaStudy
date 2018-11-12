package 网络编程;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 爬虫原理+模拟浏览器
 * @author jie
 *
 */
public class Test238_2 {
	public static void main(String[] args) throws Exception {
		//获取URL
		URL url=new URL("https://www.dianping.com");
		//下载资源
		
		HttpURLConnection htc=(HttpURLConnection) url.openConnection();
		htc.setRequestMethod("GET");
		htc.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.67 Safari/537.36");
		BufferedReader br=new BufferedReader(new InputStreamReader(htc.getInputStream(),"UTF-8"));
		String msg=null;
		while((msg=br.readLine())!=null){
			System.out.println(msg);
		}
	}
}
