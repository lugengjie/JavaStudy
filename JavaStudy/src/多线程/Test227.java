package ���߳�;
/**
 * volatile���ڱ�֤���ݵ�ͬ����Ҳ���ǿɼ���
 * @author jie
 *
 */
public class Test227 {
	static private volatile int num=0;
	public static void main(String[] args) throws InterruptedException {
		
		new Thread(()->{
			while(num==0) {
				
			}
		}).start();
		Thread.sleep(1000);
		num=1;
	}
}
