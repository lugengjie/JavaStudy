package ���߳�;
/**
 * �����������ͬ����������໥���ͷ���Դ
 * �Ӷ�����໥�ȴ���һ�㷢����ͬ���г��ж����
 * 
 * ���⣺��Ҫ��һ���������ͬʱ���ж���������
 * @author jie
 *
 */
public class Test220 {
	public static void main(String[] args) {
		Markup g1=new Markup(1, "��");
		Markup g2=new Markup(2, "ѩ");
		g1.start();
		g2.start();
	}
}
//�ں�
class Lipstick{
	
}
//����
class Mirror{
	
}

class Markup extends Thread{
	static Lipstick lipstick=new Lipstick();
	static Mirror mirror=new Mirror();
	
	int choice;
	String girl;
	
	public Markup(int choice, String girl) {
		super();
		this.choice = choice;
		this.girl = girl;
	}

	@Override
	public void run() {
		markup();
	}
	
	private void markup() {
		if(choice==1) {
			synchronized (lipstick) {
				System.out.println(this.girl+"Ϳ�ں�");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				synchronized (mirror) {
//					System.out.println(this.girl+"�վ���");
//					
//				}
			}
			synchronized (mirror) {
				System.out.println(this.girl+"�վ���");
				
			}
		}else {
			synchronized (mirror) {
				System.out.println(this.girl+"�վ���");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				synchronized (lipstick) {
//					System.out.println(this.girl+"Ϳ�ں�");
//					
//				}
			}
			synchronized (lipstick) {
				System.out.println(this.girl+"Ϳ�ں�");
				
			}
		}
	}
}
