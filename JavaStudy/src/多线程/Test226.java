package 多线程;
/**
 * happenbefore
 * 指令重排：代码执行顺序与预期不一致
 * 目的：提高性能
 * @author jie
 *
 */
public class Test226 {
	//变量1
	static int a=0;
	//变量2
	static boolean flag=false;
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<10;i++) {
			 a=0;
			 flag=false;
			 
			 //线程1更改数据
			 Thread t1 = new Thread(()->{
				a=1;
				flag=true;
			});
			 //线程2 读取数据
			Thread t2=new Thread(()-> {
				if(flag) {
					a*=1;
				}
				//指令重排
				if(a==0) {
					System.out.println("happen before a->"+a);
				}
			});
	
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
		}
		
	}
}
