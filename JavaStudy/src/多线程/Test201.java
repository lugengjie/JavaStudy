package 多线程;
/**
 * 静态代理设计模式
 * 公共接口:
 * 代理角色
 * 真正角色
 * 
 * @author jie
 *
 */
public class Test201 {
	public static void main(String[] args) {
		new MarryCompany(new You()).happyMarry();;
	}
}

interface Marry{
	void happyMarry();
}

class You implements Marry{
	public void happyMarry() {
		System.out.println("结婚了，结婚了");
	}
}

class MarryCompany implements Marry{

	private Marry target;
	
	public MarryCompany(Marry target) {
		this.target = target;
	}

	@Override
	public void happyMarry() {
		start();
		target.happyMarry();
		after();
	}
	private void start() {
		System.out.println("布置婚礼现场");

	}
	private void after() {
		System.out.println("主持婚礼");
	}
	
}
