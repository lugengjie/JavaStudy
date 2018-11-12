package ���߳�;
/**
 * ������������������������ʹ��
 * @author jie
 *
 */
public class Test230_2 {
	Lock lock=new Lock();
	public void a() throws InterruptedException {
		lock.lock();
		doSomething();
		lock.unlock();

	}
	private void doSomething() throws InterruptedException {
		lock.lock();
		//....
		lock.unlock();

	}
	public static void main(String[] args) throws InterruptedException {
		Test230_2 test=new Test230_2();
		test.a();
//		test.doSomething();
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
//����������
class Lock{
	//�Ƿ�ռ��
	private boolean isLocked=false;
	//ʹ����
	public synchronized void lock() throws InterruptedException {
		while(isLocked) {
			wait();
		}
		isLocked=true;
	}
	//�ͷ���
	public synchronized void unlock() {
		isLocked=false;
		notify();
	}
}
