package ���߳�;
/**
 * ��ֹ�߳�
 * 1.�߳�����ִ�����-->����
 * 2.�ⲿ����--�������ʶ
 * ��Ҫʹ��stop destory
 * @author jie
 */
public class Test204 implements Runnable{
	//�����ʶ����ʶ�߳����Ƿ��������
	private boolean flag=true;
	private String name;
	
	public Test204(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		//������ʶ��true-->���� flase-->��ͣ
		int i=0;
		while(flag) {
			System.out.println(name+"-->"+i++);
		}
	}
	//�����ṩ�ı��ʶ�ķ���
	private void terminate() {
		this.flag=false;

	}
	public static void main(String[] args) {
		Test204 tt=new Test204("СС");
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
