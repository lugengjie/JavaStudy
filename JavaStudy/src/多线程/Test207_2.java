package ���߳�;
/**
 * �̺߳ϲ�������߳�
 * @author jie
 *
 */
public class Test207_2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("�ϰֺͶ������̵Ĺ���");
		new Thread(new Father()).start();
	}
}
class Father implements Runnable{
	@Override
	public void run() {
		System.out.println("����̣�������û��");
		System.out.println("�ö���ȥ����");
		Thread t=new Thread(new Son());
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�ְֽӹ��̣�����Ǯ���˶���");
		
	}
}
class Son implements Runnable{

	@Override
	public void run() {
		System.out.println("�ӹ��ϰֵ�Ǯ��ȥ��");
		System.out.println("·���и���Ϸ��,����10��");
		for(int i=0;i<10;i++) {
			System.out.println(i+"��");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�Ͻ�����ȥ");
		
	}
	
}
