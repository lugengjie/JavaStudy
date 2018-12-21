package 多线程;
/**
 * 并发，共享资源（线程安全）
 * @author jie
 *
 */
public class Test199_1 implements Runnable{
	//票数
	private int ticketNums=99;
	@Override
	public void run() {
		while(true) {
			if(ticketNums<0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
		}
		
	}
	public static void main(String[] args) {
		//一份资源
		Test199_1 web=new Test199_1();
		//多个代理
		new Thread(web,"码农").start();;
		new Thread(web,"码畜").start();
		new Thread(web,"码蟥").start();
	}
	
}
