package 多线程;
/**
 * DCL单例设计模式：懒汉套路基础加上并发控制，保证单线程下，对外存在一个对象
 * 1.构造器私有化-->避免外部new构造器
 * 2.提供私有的静态属性--》存储对象的地址
 * 3.提供共有的静态方法--》获取属性
 * 
 * @author jie
 *
 */
public class Test228 {
	//2.提供私有的静态属性
	//没有volatile,其他线程可能访问一个没有初始化的对象
	private volatile static Test228 instance;
	//1.构造器私有化
	private Test228() {
		
	}
	//3.提供公有的静态方法获取属性
	public static Test228 getInstance() {
		//再次检测
		if(instance!=null) {//避免不必要的同步，已经存在对象
			return instance;
		}
		synchronized(Test228.class) {
			if(instance==null) {
				instance=new Test228();
				//1.开辟空间 2.初始化对象信息3.返回对象的地址引用
			}
		}
		
		return instance;
		
	}
	
	public static Test228 getInstance1(long time) {
		if(instance==null) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance=new Test228();
			//1.开辟空间 2.初始化对象信息3.返回对象的地址引用
		}
		return instance;
		
	}
	
	public static void main(String[] args) {
//		new Thread(()->{
//			System.out.println(new Test228().getInstance());
//		}).start();
//		
//		System.out.println(new Test228().getInstance());
		new Thread(()->{
		System.out.println(new Test228().getInstance1(500));
		}).start();
	
	System.out.println(new Test228().getInstance1(1000));
	}
	
}
