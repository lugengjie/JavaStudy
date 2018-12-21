package 多线程;
/**
 * volatile用于保证数据的同步，也就是可见性
 * @author jie
 *
 */
public class Test227 {
	static private volatile int num=0;
	public static void main(String[] args) throws InterruptedException {
		
		new Thread(()->{
			while(num==0) {
				
			}
		}).start();
		Thread.sleep(1000);
		num=1;
	}
}
