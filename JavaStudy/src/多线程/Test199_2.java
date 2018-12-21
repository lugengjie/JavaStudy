package 多线程;
/**
 * 模拟龟兔赛跑
 * @author jie
 *
 */
public class Test199_2 implements Runnable{
	private String winner; 
	
	@Override
	public void run() {
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
				break;
			}
		}
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
	
	public static void main(String[] args) {
		Test199_2 racer=new Test199_2();
		new Thread(racer,"tortoise").start();;
		new Thread(racer,"rabbit").start();;
		

	}
}
