package 多线程;
/**
 * InheritableThreadLocal继承上下文环境的数据，拷贝一份给子线程
 * @author jie
 *
 */
public class Test229_4 {
	private static ThreadLocal<Integer> threadLocal= new InheritableThreadLocal<>();

	public static void main(String[] args) {
		threadLocal.set(2);
		System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"->"+threadLocal.get());
		}).start();
	}

	
	
}

