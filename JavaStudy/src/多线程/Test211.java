package ���߳�;
/**
 * ��������
 * isAlive����
 * setName()
 * Thread.currentThread()
 * @author jie
 *
 */
public class Test211 {
	public static void main(String[] args) throws InterruptedException {
		Test test=new Test("ս����");
		Thread t=new Thread(test);
		//������ʵ��ɫ�ʹ����ɫ����
		t.setName("����Ա");
		t.start();
		t.sleep(1000);
		System.out.println(t.isAlive());
	}
}
class Test implements Runnable{
	private String name;
	
	public Test(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name+"--��"+Thread.currentThread().getName());
		
	}
	
}
