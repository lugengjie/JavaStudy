package ���߳�;
/**
 * ������������Դ���̰߳�ȫ��
 * @author jie
 *
 */
public class Test199_1 implements Runnable{
	//Ʊ��
	private int ticketNums=99;
	@Override
	public void run() {
		while(true) {
			if(ticketNums<0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
		}
		
	}
	public static void main(String[] args) {
		//һ����Դ
		Test199_1 web=new Test199_1();
		//�������
		new Thread(web,"��ũ").start();;
		new Thread(web,"����").start();
		new Thread(web,"���").start();
	}
	
}
