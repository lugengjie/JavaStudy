package 多线程;
/**
 * 线程不安全：数据有相同，有负数
 * @author jie
 *
 */
public class Test212_1 {
	public static void main(String[] args) {
		Web12306 test=new Web12306();
		new Thread(test,"晓晓").start();
		new Thread(test,"潇潇").start();
		new Thread(test,"海海").start();
	}
}
class Web12306 implements Runnable{
	private int ticketNum=10;
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
	private void test() throws InterruptedException {
		if(ticketNum<0) {
			flag=false;
			return;
		}
		Thread.sleep(200);
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNum--);

	}
	
	
}
