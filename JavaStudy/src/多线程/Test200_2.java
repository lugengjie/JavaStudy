package ���߳�;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ģ���������
 * @author jie
 *
 */
public class Test200_2 implements Callable<Integer>{
	private String winner; 
	
	@Override
	public Integer call() {
		for(int step=0;step<100;step++) {
			if((Thread.currentThread().getName().equals("rabbit"))&&(step%10==0)) {
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"-->"+step);
			boolean flag=gameOver(step);
			if(flag) {
				return step;
			}
		}
		return null;
	}
	private boolean gameOver(int step) {
		if(winner!=null) {
			return true;
		}else {
			if(step==99) {
				winner=Thread.currentThread().getName();
				System.out.println("winner-->"+winner);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Test200_2 racer=new Test200_2();
		//����ִ�з���
		ExecutorService es=Executors.newFixedThreadPool(2);
		//�ύִ��
		Future<Integer> result1=es.submit(racer);
		Future<Integer> result2=es.submit(racer);

		//��ȡ���
		Integer r1=result1.get();
		Integer r2=result2.get();
	
		System.out.println(r1+"__"+r2);
		//�رշ���
		es.shutdownNow();
		

	}
}
