package 多线程;
/**
 * 守护线程：是为用户服务的，虚拟机不用等守护线程执行完毕
 * 默认用户线程
 * @author jie
 *
 */
public class Test210 {
	public static void main(String[] args) {
		new Thread(new Person()).start();;
		Thread t=new Thread(new God());;
		t.setDaemon(true);
		t.start();
	}
}
class Person implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<=360*100;i++) {
			System.out.println("happy life");
		}
	}
}

class God implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println("bless you");
		}
	}
}
