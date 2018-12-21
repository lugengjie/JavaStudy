package 多线程;
/**
 * 可重入锁：锁可以延续使用
 * @author jie
 *
 */
public class Test230_3 {
	ReLock lock=new ReLock();
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
		Test230_3 test=new Test230_3();
		test.a();
//		test.doSomething();
		Thread.sleep(1000);
		System.out.println(test.lock.getHoldCount());
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
class ReLock{
	//是否占用
	private boolean isLocked=false;
	//存储线程
	private Thread lockedBy=null; 
	//计数器
	private int holdCount=0;
	//使用锁
	public synchronized void lock() throws InterruptedException {
		Thread t=Thread.currentThread();
		while(isLocked&&lockedBy!=t) {
			wait();
		}
		isLocked=true;
		lockedBy =t;
		holdCount++;
	}
	//释放锁
	public synchronized void unlock() {
		if(Thread.currentThread()==lockedBy) {
			holdCount--;
			if(holdCount==0) {
				isLocked=false;
				lockedBy=null;
				notify();
			}
			
		}
	}
	public int getHoldCount() {
		return holdCount;
	}
	
	
}
