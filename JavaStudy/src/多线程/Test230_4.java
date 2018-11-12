package ���߳�;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ��������������������ʹ��
 * @author jie
 *
 */
public class Test230_4 {
	ReentrantLock lock=new ReentrantLock();
	public void a() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		doSomething();
		lock.unlock();
		System.out.println(lock.getHoldCount());

	}
	private void doSomething() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		//....
		lock.unlock();
		System.out.println(lock.getHoldCount());

	}
	public static void main(String[] args) throws InterruptedException {
		Test230_4 test=new Test230_4();
		test.a();
//		test.doSomething();
		Thread.sleep(1000);
		System.out.println(test.lock.getHoldCount());
	}
	public void test() {
		// ��һ�λ�ȡ��
		synchronized(this) {
			while(true) {
				//�ڶ��λ�ȡ��
				synchronized (this) {
					System.out.println("ReentrantLock");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
