package ���߳�;
/**
 * �ػ��̣߳���Ϊ�û�����ģ���������õ��ػ��߳�ִ�����
 * Ĭ���û��߳�
 * @author jie
 *
 */
public class Test210 {
	public static void main(String[] args) {
		new Thread(new Person()).start();;
		Thread t=new Thread(new God());;
		t.setDaemon(true);
		t.start();
	}
}
class Person implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<=360*100;i++) {
			System.out.println("happy life");
		}
	}
}

class God implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println("bless you");
		}
	}
}
