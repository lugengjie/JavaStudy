package 多线程;
/**
 * lambda表达式,简化线程（用一次）的使用
 * @author jie
 *
 */
public class Test202_1 {
	//静态内部类
	static class Test implements Runnable{
		@Override
		public void run() {
			System.out.println("抱抱我，哄哄我");
		}
	}
	public static void main(String[] args) {
		new Thread(new Test()).start();
		
		//局部内部类
		class Test2 implements Runnable{
			@Override
			public void run() {
				System.out.println("抱抱我，哄哄我");
			}
		}
		new Thread(new Test2()).start();
		//匿名内部类，必须借助接口或父类
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("抱抱我，哄哄我");
			}
		}).start();;
		//jdk8.0 lambda表达式
		new Thread(()-> {
			System.out.println("抱抱我，哄哄我");
		}).start();
	}
}
