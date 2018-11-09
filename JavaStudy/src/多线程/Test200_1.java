package 多线程;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.ExtensionFileComparator;

/**
 * 创建线程方法三：
 * Callable
 */
public class Test200_1 implements Callable<Boolean>{
	private String url;
	private String name;
	
	public Test200_1(String url, String name) {
		this.url = url;
		this.name = name;
	}

	@Override
	public Boolean call() throws Exception {
		FileUtils.copyURLToFile(new URL(this.url),new File("src/多线程/"+this.name));
		System.out.println(name);
		return true;
	}

	public static void main(String[] args) throws Exception {
		Test200_1 cd1=new Test200_1("http://upload.news.cecb2b.com/2014/0511/1399775432250.jpg", "phone.jpg");
		Test200_1 cd2=new Test200_1("http://p1.pstatp.com/large/403c00037462ae2eee13","spl.jpg");
		Test200_1 cd3=new Test200_1("http://5b0988e595225.cdn.sohucs.com/images/20170830/d8b57e0dce0d4fa29bd5ef014be663d5.jpeg", "success.jpg");
		
		//创建执行服务
		ExecutorService es=Executors.newFixedThreadPool(3);
		//提交执行
		Future<Boolean> result1=es.submit(cd1);
		Future<Boolean> result2=es.submit(cd2);
		Future<Boolean> result3=es.submit(cd3);
		//获取结果
		boolean r1=result1.get();
		boolean r2=result2.get();
		boolean r3=result3.get();
		System.out.println(r3);
		//关闭服务
		es.shutdownNow();
	}


}
