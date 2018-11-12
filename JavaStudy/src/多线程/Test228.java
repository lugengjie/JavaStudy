package ���߳�;
/**
 * DCL�������ģʽ��������·�������ϲ������ƣ���֤���߳��£��������һ������
 * 1.������˽�л�-->�����ⲿnew������
 * 2.�ṩ˽�еľ�̬����--���洢����ĵ�ַ
 * 3.�ṩ���еľ�̬����--����ȡ����
 * 
 * @author jie
 *
 */
public class Test228 {
	//2.�ṩ˽�еľ�̬����
	//û��volatile,�����߳̿��ܷ���һ��û�г�ʼ���Ķ���
	private volatile static Test228 instance;
	//1.������˽�л�
	private Test228() {
		
	}
	//3.�ṩ���еľ�̬������ȡ����
	public static Test228 getInstance() {
		//�ٴμ��
		if(instance!=null) {//���ⲻ��Ҫ��ͬ�����Ѿ����ڶ���
			return instance;
		}
		synchronized(Test228.class) {
			if(instance==null) {
				instance=new Test228();
				//1.���ٿռ� 2.��ʼ��������Ϣ3.���ض���ĵ�ַ����
			}
		}
		
		return instance;
		
	}
	
	public static Test228 getInstance1(long time) {
		if(instance==null) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance=new Test228();
			//1.���ٿռ� 2.��ʼ��������Ϣ3.���ض���ĵ�ַ����
		}
		return instance;
		
	}
	
	public static void main(String[] args) {
//		new Thread(()->{
//			System.out.println(new Test228().getInstance());
//		}).start();
//		
//		System.out.println(new Test228().getInstance());
		new Thread(()->{
		System.out.println(new Test228().getInstance1(500));
		}).start();
	
	System.out.println(new Test228().getInstance1(1000));
	}
	
}
