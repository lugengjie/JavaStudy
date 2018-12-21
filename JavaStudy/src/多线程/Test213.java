package 多线程;
/**
 * 协作模型：消费者生产者 实现方法二：信号灯
 * @author jie
 *
 */
public class Test213 {
	public static void main(String[] args) {
		Tv tv=new Tv();
		Player player=new Player(tv);
		Watcher watcher=new Watcher(tv);
		player.start();
		watcher.start();
	}
}
//生产者 演员
class Player extends Thread{
	Tv tv;
	public Player(Tv tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++)
			this.tv.play("奇葩说");
	}
}
class Watcher extends Thread{
	Tv tv;

	public Watcher(Tv tv) {
		this.tv = tv;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			tv.watch();
		}
	}
	
}
class Tv{
	String voice;
	//信号灯
	//true表示演员表演，观众等待
	//false表示观众等待 演员表演
	boolean flag=true;
	
	//表演
	public synchronized void play(String voice) {
		//演员等待
		if(!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//表演
		System.out.println("表演了"+voice);
		this.voice=voice;
		//唤醒
		this.notifyAll();
		//切换标志
		this.flag=!this.flag;
	}
	//观看
	public synchronized void watch() {
		//观众等待
		if(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//观看
		System.out.println("观看了"+voice);
		//唤醒
		this.notifyAll();
		//切换标志
		this.flag=!this.flag;
	}
	
}

