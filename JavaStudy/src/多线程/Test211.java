package 多线程;
/**
 * 其他方法
 * isAlive（）
 * setName()
 * Thread.currentThread()
 * @author jie
 *
 */
public class Test211 {
	public static void main(String[] args) throws InterruptedException {
		Test test=new Test("战斗机");
		Thread t=new Thread(test);
		//设置真实角色和代理角色名称
		t.setName("程序员");
		t.start();
		t.sleep(1000);
		System.out.println(t.isAlive());
	}
}
class Test implements Runnable{
	private String name;
	
	public Test(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name+"--》"+Thread.currentThread().getName());
		
	}
	
}
