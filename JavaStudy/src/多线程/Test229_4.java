package ���߳�;
/**
 * InheritableThreadLocal�̳������Ļ��������ݣ�����һ�ݸ����߳�
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

