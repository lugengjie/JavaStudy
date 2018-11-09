package ���߳�;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * �̰߳�ȫ������ʱ��֤���ݵ���ȷ�ԣ�Ч�ʾ����ܸ�
 * @author jie
 *synchronized
 *1.ͬ������
 *2.ͬ����:Ŀ�����ȷ
 */
public class Test214_3 {
	public static void main(String[] args) throws InterruptedException {
		List<String> list=new ArrayList<String>();
		Thread t=null;
		for(int i=0;i<10000;i++) {
			synchronized(list) {
				t=new Thread(()->{
					list.add(Thread.currentThread().getName());
				});
			}
			t.start();
			t.join();
		}
		System.out.println(list.size());
	}
}
