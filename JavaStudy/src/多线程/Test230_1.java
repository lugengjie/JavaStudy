package ���߳�;
/**
 * ��������������������ʹ��
 * @author jie
 *
 */
public class Test230_1 {
	public static void main(String[] args) {
		new Test230_1().test();
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
