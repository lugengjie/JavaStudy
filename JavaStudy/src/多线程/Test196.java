package ���߳�;
/**
 * �����̷߳���һ
 * 1)�������̳�Thread,��дrun()
 * 2)����:�����������,start()
 * @author jie
 *
 */
public class Test196 extends Thread{
	@Override
	/**
	 * �߳������
	 */
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("����");
		}
	}
	public static void main(String[] args) {
		Test196 threadTest=new Test196();
		/**
		 * ����֤�������У�cpu����
		 */
		threadTest.start();
		
		for(int i=0;i<20;i++) {
			System.out.println("Coding");
		}
	}
}
