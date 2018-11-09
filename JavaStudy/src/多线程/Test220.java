package 多线程;
/**
 * 死锁：过多的同步可能造成相互不释放资源
 * 从而造成相互等待，一般发生于同步中持有多个锁
 * 
 * 避免：不要在一个代码块中同时持有多个对象的锁
 * @author jie
 *
 */
public class Test220 {
	public static void main(String[] args) {
		Markup g1=new Markup(1, "风");
		Markup g2=new Markup(2, "雪");
		g1.start();
		g2.start();
	}
}
//口红
class Lipstick{
	
}
//镜子
class Mirror{
	
}

class Markup extends Thread{
	static Lipstick lipstick=new Lipstick();
	static Mirror mirror=new Mirror();
	
	int choice;
	String girl;
	
	public Markup(int choice, String girl) {
		super();
		this.choice = choice;
		this.girl = girl;
	}

	@Override
	public void run() {
		markup();
	}
	
	private void markup() {
		if(choice==1) {
			synchronized (lipstick) {
				System.out.println(this.girl+"涂口红");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				synchronized (mirror) {
//					System.out.println(this.girl+"照镜子");
//					
//				}
			}
			synchronized (mirror) {
				System.out.println(this.girl+"照镜子");
				
			}
		}else {
			synchronized (mirror) {
				System.out.println(this.girl+"照镜子");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				synchronized (lipstick) {
//					System.out.println(this.girl+"涂口红");
//					
//				}
			}
			synchronized (lipstick) {
				System.out.println(this.girl+"涂口红");
				
			}
		}
	}
}
