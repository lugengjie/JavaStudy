package ���߳�;
/**
 * happenbefore
 * ָ�����ţ�����ִ��˳����Ԥ�ڲ�һ��
 * Ŀ�ģ��������
 * @author jie
 *
 */
public class Test226 {
	//����1
	static int a=0;
	//����2
	static boolean flag=false;
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<10;i++) {
			 a=0;
			 flag=false;
			 
			 //�߳�1��������
			 Thread t1 = new Thread(()->{
				a=1;
				flag=true;
			});
			 //�߳�2 ��ȡ����
			Thread t2=new Thread(()-> {
				if(flag) {
					a*=1;
				}
				//ָ������
				if(a==0) {
					System.out.println("happen before a->"+a);
				}
			});
	
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
		}
		
	}
}
