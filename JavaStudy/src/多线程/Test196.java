package 多线程;
/**
 * 创建线程方法一
 * 1)创建：继承Thread,重写run()
 * 2)启动:创建子类对象,start()
 * @author jie
 *
 */
public class Test196 extends Thread{
	@Override
	/**
	 * 线程体入口
	 */
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("听歌");
		}
	}
	public static void main(String[] args) {
		Test196 threadTest=new Test196();
		/**
		 * 不保证立即运行，cpu调用
		 */
		threadTest.start();
		
		for(int i=0;i<20;i++) {
			System.out.println("Coding");
		}
	}
}
