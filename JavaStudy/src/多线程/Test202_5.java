package ���߳�;
//lambda�Ƶ�+�Ӳ���+�ӷ�ֵ
public class Test202_5 {
	public static void main(String[] args) {
		new Thread(()->{
			System.out.println("�Է�˯���򶺶�");
		}).start();
		new Thread(()->{
			for(int i=0;i<10;i++) {
				System.out.println("�Է�˯��");
			}
		}).start();
	}
}


