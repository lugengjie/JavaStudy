package ���߳�;
/**
 * ThreadLocalÿ���߳���������ݣ����Ĳ���Ӱ�������߳�
 * @author jie
 *
 */
public class Test229_2 {
	private static ThreadLocal<Integer> threadLocal= ThreadLocal.withInitial(()->1);

	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			new Thread(new MyRun()).start();
		}
	}
	public static class MyRun implements Runnable{
		@Override
		public void run() {
			Integer left=threadLocal.get();
			System.out.println(Thread.currentThread().getName()+"�õ���->"+left);
			threadLocal.set(left-1);
			System.out.println(Thread.currentThread().getName()+"��ʣ��->"+threadLocal.get());
			
		}
	}
}

