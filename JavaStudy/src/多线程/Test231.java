package ���߳�;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * �Ƚϲ����� CAS
 * @author jie
 *
 */
public class Test231 {
	private static AtomicInteger stock=new AtomicInteger(5);
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			new Thread(()->{
				//ģ��������ʱ
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Integer left=stock.decrementAndGet();
				if(left<1) {
					System.out.println("������");
					return;
				}
				System.out.print(Thread.currentThread().getName()+"����һ����Ʒ");
				System.out.println("��ʣ"+left);
			}).start();
		}
	}
}
