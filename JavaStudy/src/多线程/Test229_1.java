package 多线程;
/**
 * ThreadLocal每个线程自身的本地存储,局部区域
 * get/set/initialValue
 * @author jie
 *
 */
public class Test229_1 {
//	private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
//	private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>() {
//		public Integer initialValue(){
//			return 200;
//		}
//	};
	private static ThreadLocal<Integer> threadLocal= ThreadLocal.withInitial(()->200);
		
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
		threadLocal.set(300);
		System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
		new Thread(new MyRun()).start();
	}
	public static class MyRun implements Runnable{
		@Override
		public void run() {
			threadLocal.set((int) (Math.random()*99));
			System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
			
		}
	}
}

