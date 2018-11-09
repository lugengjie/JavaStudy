package 多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 模拟龟兔赛跑
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
		//创建执行服务
		ExecutorService es=Executors.newFixedThreadPool(2);
		//提交执行
		Future<Integer> result1=es.submit(racer);
		Future<Integer> result2=es.submit(racer);

		//获取结果
		Integer r1=result1.get();
		Integer r2=result2.get();
	
		System.out.println(r1+"__"+r2);
		//关闭服务
		es.shutdownNow();
		

	}
}
