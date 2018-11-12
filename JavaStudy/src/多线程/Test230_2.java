package 多线程;
/**
 * 不可重入锁：锁不可以延续使用
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
		// 第一次获取锁
		synchronized(this) {
			while(true) {
				//第二次获取锁
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
//不可重入锁
class Lock{
	//是否占用
	private boolean isLocked=false;
	//使用锁
	public synchronized void lock() throws InterruptedException {
		while(isLocked) {
			wait();
		}
		isLocked=true;
	}
	//释放锁
	public synchronized void unlock() {
		isLocked=false;
		notify();
	}
}
