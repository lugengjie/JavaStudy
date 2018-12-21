package 多线程;
//lambda推导+加参数+加返值
public class Test202_5 {
	public static void main(String[] args) {
		new Thread(()->{
			System.out.println("吃饭睡觉打逗逗");
		}).start();
		new Thread(()->{
			for(int i=0;i<10;i++) {
				System.out.println("吃饭睡觉");
			}
		}).start();
	}
}


