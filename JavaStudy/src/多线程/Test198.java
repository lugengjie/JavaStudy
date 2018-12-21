package 多线程;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * 创建线程方法二：
 * 1,创建：实现Runnable+重写run
 * 2,实现：创建实现类对象+Thread对象+start
 * @author jie
 *推荐：避免java单继承局限性，优先使用接口
 *方便共享资源
 */
public class Test198 implements Runnable{
	private String url;
	private String name;
	
	public Test198(String url, String name) {
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
		Test198 td1=new Test198("http://upload.news.cecb2b.com/2014/0511/1399775432250.jpg", "phone.jpg");
		Test198 td2=new Test198("http://p1.pstatp.com/large/403c00037462ae2eee13","spl.jpg");
		Test198 td3=new Test198("http://5b0988e595225.cdn.sohucs.com/images/20170830/d8b57e0dce0d4fa29bd5ef014be663d5.jpeg", "success.jpg");
		
		new Thread(td1).start();
		new Thread(td2).start();
		new Thread(td3).start();
	}
}
