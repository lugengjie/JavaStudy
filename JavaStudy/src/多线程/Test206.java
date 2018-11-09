package 多线程;
/**
 * 礼让线程yield,暂停线程，直接进入就绪状态，不是阻塞状态
 * @author jie
 *
 */
public class Test206 implements Runnable{
	
	public static void main(String[] args) {
		Test206 test=new Test206();
		new Thread(test,"a").start();
		new Thread(test,"b").start();
	}

	@Override
	public void run() {
		System.out.println("start-->"+Thread.currentThread().getName());
		Thread.yield();
		System.out.println("end-->"+Thread.currentThread().getName());
	}
}
