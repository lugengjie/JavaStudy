package ���߳�;
/**
 * �̺߳ϲ�������߳�
 * @author jie
 *
 */
public class Test207_1 {
	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("lambda"+i);
			}
		});
		t.start();
		for(int i=0;i<100;i++) {
			if(i%20==0) {
				t.join(); //���,main������
			}
			System.out.println("main"+i);
		}
	}
}
