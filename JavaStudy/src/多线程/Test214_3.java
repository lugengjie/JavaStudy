package 多线程;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 线程安全：并发时保证数据的正确性，效率尽可能高
 * @author jie
 *synchronized
 *1.同步方法
 *2.同步块:目标更明确
 */
public class Test214_3 {
	public static void main(String[] args) throws InterruptedException {
		List<String> list=new ArrayList<String>();
		Thread t=null;
		for(int i=0;i<10000;i++) {
			synchronized(list) {
				t=new Thread(()->{
					list.add(Thread.currentThread().getName());
				});
			}
			t.start();
			t.join();
		}
		System.out.println(list.size());
	}
}
