package 多线程;
/**
 * 线程合并，插队线程
 * @author jie
 *
 */
public class Test207_1 {
	public static void main(String[] args) throws InterruptedException {
		Thread t=new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("lambda"+i);
			}
		});
		t.start();
		for(int i=0;i<100;i++) {
			if(i%20==0) {
				t.join(); //插队,main被阻塞
			}
			System.out.println("main"+i);
		}
	}
}
