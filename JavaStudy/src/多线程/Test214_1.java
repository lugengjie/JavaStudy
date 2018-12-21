package 多线程;
/**
 * 线程安全：并发时保证数据的正确性，效率尽可能高
 * @author jie
 *synchronized
 *1.同步方法
 *2.同步块
 */
public class Test214_1 {
	public static void main(String[] args) {
		Web1230 test=new Web1230();
		new Thread(test,"晓晓").start();
		new Thread(test,"潇潇").start();
		new Thread(test,"海海").start();
	}
}
class Web1230 implements Runnable{
	private int ticketNum=100;
	private boolean flag=true;
	@Override
	public void run() {
		while(flag) {
			try {
				test();
			} catch (InterruptedException e) {	
				e.printStackTrace();
			}
		}
	}
	private synchronized void test() throws InterruptedException {
		if(ticketNum<0) {
			flag=false;
			return;
		}
		Thread.sleep(200);
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNum--);

	}
	
	
}
