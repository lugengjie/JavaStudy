package 多线程;
/**
 * 线程优先级
 * 1.NORM_PRIORITY 5默认
 * 2.MIN_PRIORITY 1
 * 3.MAX_PRIORITY 10
 * @author jie
 *
 */
public class Test209 {
	public static void main(String[] args) {
//		System.out.println(Thread.currentThread().getPriority());
		Thread t1=new Thread(new MyPriority());
		Thread t2=new Thread(new MyPriority());
		Thread t3=new Thread(new MyPriority());
		Thread t4=new Thread(new MyPriority());
		Thread t5=new Thread(new MyPriority());
		Thread t6=new Thread(new MyPriority());
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

class MyPriority implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getPriority());
	}
	
}