package ���߳�;
/**
 * lambda���ʽ,���̣߳���һ�Σ���ʹ��
 * @author jie
 *
 */
public class Test202_1 {
	//��̬�ڲ���
	static class Test implements Runnable{
		@Override
		public void run() {
			System.out.println("�����ң������");
		}
	}
	public static void main(String[] args) {
		new Thread(new Test()).start();
		
		//�ֲ��ڲ���
		class Test2 implements Runnable{
			@Override
			public void run() {
				System.out.println("�����ң������");
			}
		}
		new Thread(new Test2()).start();
		//�����ڲ��࣬��������ӿڻ���
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("�����ң������");
			}
		}).start();;
		//jdk8.0 lambda���ʽ
		new Thread(()-> {
			System.out.println("�����ң������");
		}).start();
	}
}
