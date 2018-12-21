package 多线程;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全：操作并发容器
 */
public class Test218 {
	public static void main(String[] args) throws InterruptedException {
		List<String> list=new CopyOnWriteArrayList<String>();
		Thread t=null;
		for(int i=0;i<10000;i++) {		
				t=new Thread(()->{
					list.add(Thread.currentThread().getName());
				});
			t.start();
			t.join();
		}
		System.out.println(list.size());
	}
}
