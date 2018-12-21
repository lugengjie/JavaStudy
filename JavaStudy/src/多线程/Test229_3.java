package 多线程;
/**
 * ThreadLocal分析上下文环境 起点
 * 构造器：哪里调用，就属于哪里
 * @author jie
 *
 */
public class Test229_3 {
	private static ThreadLocal<Integer> threadLocal= ThreadLocal.withInitial(()->1);

	public static void main(String[] args) {
				new Thread(new MyRun()).start();
	}
	public static class MyRun implements Runnable{

		public MyRun() {
			System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
		}
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
		}
	}
}

