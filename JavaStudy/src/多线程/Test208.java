package 多线程;

import java.lang.Thread.State;
/**
 * 深度观察状态
 * @author jie
 *
 */
public class Test208 {
	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(()->{
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {	
					e.printStackTrace();
				}
				System.out.println("....");
			}
			
		});
		//观察状态
		State state=t.getState();
		System.out.println(state);//NEW
		t.start();	//RUNNABLE
		state=t.getState();
		System.out.println(state);
//		while(state!=Thread.State.TERMINATED) {
//			Thread.sleep(2000);
//			state=t.getState();
//			System.out.println(state);
//		}
		while(true) {
			int num=Thread.activeCount();
			if(num==1) {
				break;
			}
			Thread.sleep(200);
			state=t.getState();   //TIMED_WAITING
			System.out.println(state);
		}
		state=t.getState();
		System.out.println(state);  //TERMINATED
	}
}
