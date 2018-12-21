package 多线程;
/**
 * 可重入锁：锁可以延续使用
 * @author jie
 *
 */
public class Test230_1 {
	public static void main(String[] args) {
		new Test230_1().test();
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
