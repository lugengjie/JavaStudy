package 多线程;
/**
 * 线程合并，插队线程
 * @author jie
 *
 */
public class Test207_2 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("老爸和儿子买烟的故事");
		new Thread(new Father()).start();
	}
}
class Father implements Runnable{
	@Override
	public void run() {
		System.out.println("想抽烟，发现烟没了");
		System.out.println("让儿子去买烟");
		Thread t=new Thread(new Son());
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("爸爸接过烟，把零钱给了儿子");
		
	}
}
class Son implements Runnable{

	@Override
	public void run() {
		System.out.println("接过老爸的钱出去了");
		System.out.println("路边有个游戏厅,玩了10秒");
		for(int i=0;i<10;i++) {
			System.out.println(i+"秒");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("赶紧买烟去");
		
	}
	
}
