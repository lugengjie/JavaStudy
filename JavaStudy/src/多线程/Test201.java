package ���߳�;
/**
 * ��̬�������ģʽ
 * �����ӿ�:
 * �����ɫ
 * ������ɫ
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
		System.out.println("����ˣ������");
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
		System.out.println("���û����ֳ�");

	}
	private void after() {
		System.out.println("���ֻ���");
	}
	
}