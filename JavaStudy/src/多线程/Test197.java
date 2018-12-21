package 多线程;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * 多线程下载图片
 * @author jie
 *
 */
public class Test197 extends Thread{
	private String url;
	private String name;
	
	public Test197(String url, String name) {
		this.url = url;
		this.name = name;
	}
	@Override
	public void run() {
		try {
			FileUtils.copyURLToFile(new URL(this.url),new File("src/多线程/"+this.name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(name);
	}

	public static void main(String[] args) {
		Test197 td1=new Test197("http://upload.news.cecb2b.com/2014/0511/1399775432250.jpg", "phone.jpg");
		Test197 td2=new Test197("http://p1.pstatp.com/large/403c00037462ae2eee13","spl.jpg");
		Test197 td3=new Test197("http://5b0988e595225.cdn.sohucs.com/images/20170830/d8b57e0dce0d4fa29bd5ef014be663d5.jpeg", "success.jpg");
		
		td1.start();
		td2.start();
		td3.start();
	}
}
