package ���߳�;
/**
 * �̰߳�ȫ������ʱ��֤���ݵ���ȷ�ԣ�Ч�ʾ����ܸ�
 * @author jie
 *synchronized
 *1.ͬ������
 *2.ͬ����
 */
public class Test214_1 {
	public static void main(String[] args) {
		Web1230 test=new Web1230();
		new Thread(test,"����").start();
		new Thread(test,"����").start();
		new Thread(test,"����").start();
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
