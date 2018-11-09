package 多线程;
/**
 * 终止线程
 * 1.线程正常执行完毕-->次数
 * 2.外部干涉--》加入标识
 * 不要使用stop destory
 * @author jie
 */
public class Test204 implements Runnable{
	//加入标识，标识线程体是否可以运行
	private boolean flag=true;
	private String name;
	
	public Test204(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		//关联标识，true-->运行 flase-->暂停
		int i=0;
		while(flag) {
			System.out.println(name+"-->"+i++);
		}
	}
	//对外提供改变标识的方法
	private void terminate() {
		this.flag=false;

	}
	public static void main(String[] args) {
		Test204 tt=new Test204("小小");
		new Thread(tt).start();
		for(int i=0;i<99;i++) {
			if(88==i) {
				tt.terminate();
				System.out.println("game over");	
			}
			System.out.println("main-->"+i);
		}
	}
	
}
